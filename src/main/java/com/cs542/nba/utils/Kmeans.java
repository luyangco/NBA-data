package com.cs542.nba.utils;

import java.util.ArrayList;

import com.cs542.nba.model.ClusterVariable;

public class Kmeans {
	ArrayList<ClusterVariable> centoids = new ArrayList<ClusterVariable>(); // centoids for lloyd algorithm
	ArrayList<ClusterVariable> newCentoids = new ArrayList<ClusterVariable>();
	
	float compute(float x, float y) {
		float xy = x - y;
		return xy * xy;
	}
	
	double getD(ClusterVariable p, ClusterVariable center) {
		float v1 = compute(p.getAr(), center.getAr());
		float v2 = compute(p.getBlks(), center.getBlks());
		float v3 = compute(p.getDr(), center.getDr());
		float v4 = compute(p.getFt_atts(), center.getFt_atts());
		float v5 = compute(p.getFt_pct(), center.getFt_pct());
		float v6 = compute(p.getOr(), center.getOr());
		float v7 = compute(p.getStls(), center.getStls());
		float v8 = compute(p.getThree_atts(), center.getThree_atts());
		float v9 = compute(p.getThree_pct(), center.getThree_pct());
		float v10 = compute(p.getTor(), center.getTor());
		float v11 = compute(p.getTwo_atts(), center.getTwo_atts());
		float v12 = compute(p.getTwo_pct(), center.getTwo_pct());
		
		return Math.sqrt(v1 + v2 + v3 + v4 + v5 + v6 + v7 + v8 + v9 + v10 + v11 + v12);
	}
	
	double getD2(ClusterVariable p, ClusterVariable center) {
		double d = getD(p, center);
		return d * d;
	}
	
	// K Means++ Algorithm -- find initial seed centoids
	void initialize(int clusters, ArrayList<ClusterVariable> dataset) {
		// Create an unchosen vectors
		ArrayList<ClusterVariable> unchosen = new ArrayList<ClusterVariable>(); 
		for (ClusterVariable var : dataset) {
			unchosen.add(var);
		}
		// Choose one random vector as center, remove from unchosen vectors
		int index = (int)(Math.random() * dataset.size());
		ClusterVariable center = unchosen.remove(index);
		center.setGroup(1);
		centoids.add(center);
		
		// D(x)^2 for distance between vectors
		ArrayList<Double> d = new ArrayList<Double>(); 

		for (int i = 2; i <= clusters; i++) {
			// Choose one new vector at random as a new center, vector x is chosen with
			// probability proportional to D(x)^2
			double sum = 0;
			d.clear();
			for (ClusterVariable p : unchosen) {
				double dis = getD2(p, center);
				d.add(dis);
				sum += dis;
			}
			int j;
			for (j = 0; j < unchosen.size() - 1; j++) {
				double dis = d.get(j);
				Double rand = Math.random();
				if ( (rand * sum) < dis) {
					break;
				}
				sum -= dis;
			}
			center = unchosen.remove(j);
			center.setGroup(i);
			centoids.add(center);
		}		
	}
	
	
	void groupify(ArrayList<ClusterVariable> dataset) {
		
		// Throw vectors into different clusters
		for (ClusterVariable p : dataset) {
			double minD = 9999999d;  // huge value
			for (int i = 0; i < centoids.size(); i++) {
				double dis = getD(p, centoids.get(i));
				if (minD > dis) {
					minD = dis;
					p.setGroup(i+1);
				}
			}
		}
		
		// Compute new centoids
		for (int i = 1; i <= centoids.size(); i++) {
			int count = 0;
			float[] v = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}; // 12 zeros
			for (ClusterVariable var : dataset) {
				if (var.getGroup() == i) {
					count++;
					v[0] += var.getAr();
					v[1] += var.getTor();
					v[2] += var.getOr();
					v[3] += var.getDr();
					v[4] += var.getStls();
					v[5] += var.getBlks();
					v[6] += var.getTwo_atts();
					v[7] += var.getThree_atts();
					v[8] += var.getFt_atts();
					v[9] += var.getTwo_pct();
					v[10] += var.getThree_pct();
					v[11] += var.getFt_pct();
				}
			}
			newCentoids.add(new ClusterVariable(v[0] / count, v[1] / count, v[2] / count, v[3] / count, v[4] / count, 
					v[5] / count, v[6] / count, v[7] / count, v[8] / count, v[9] / count, v[10] / count, v[11] / count));
		}
	}
	
	// Lloyd's Algorithm for K Means cluster analysis
	public void lloyd(int clusters, ArrayList<ClusterVariable> dataset) {
		if (dataset == null)
			return;
		if (dataset.size() == 0 || clusters < 2)
			return;
		
		initialize(clusters, dataset);
		
		while (true) {
			newCentoids.clear();
			groupify(dataset);
			
			// Algorithm stops when centoids no longer move
			boolean finish = true;
			for (int i = 0; i < clusters; i++) {
				if (!newCentoids.get(i).isEqual(centoids.get(i))) {
					finish = false;
					newCentoids.get(i).isEqual(centoids.get(i));
				}
			}
			if (finish)
				break;
			
			centoids.clear();
			for (ClusterVariable c : newCentoids) {
				centoids.add(c);
			}
		}
		
		//printResult(clusters, dataset);
	}
	
	void printResult(int clusters,  ArrayList<ClusterVariable> dataset) {
		for (int i = 1; i <= clusters; i++) {
			System.out.format("\n%d:\n", i);
			for (ClusterVariable p : dataset) {
				if (p.getGroup() == i) {
					System.out.format("%d %d %f %f %f %f %f %f %f %f %f %f %f %f\n", 
							p.getTeam_id(), p.getProfile_id(), p.getAr(), p.getTor(),
							p.getOr(), p.getDr(), p.getStls(), p.getBlks(), p.getTwo_atts(),
							p.getThree_atts(), p.getFt_atts(), p.getTwo_pct(), p.getThree_pct(),
							p.getFt_pct());
				}
			}
		}
	}
	
}
