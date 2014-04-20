package com.cs542.nba.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cs542.nba.model.ClusterVariable;
import com.cs542.nba.model.ComboInfo;
import com.cs542.nba.model.PlayerProfile;
import com.cs542.nba.model.PlayerStats;
import com.cs542.nba.persistence.SqlManager;
import com.cs542.nba.utils.Kmeans;

@Controller
@RequestMapping("api")
public class ApiController {

	ArrayList<ClusterVariable> dataset = new ArrayList<ClusterVariable>();
	
	@RequestMapping(value="stat/players")
	@ResponseBody
	public ArrayList<PlayerStats> getPlayerStats() {
		return SqlManager.getAllPlayerStats(1, 300);
	}
	
	@RequestMapping(value="cluster/{clusterNumber}")
	@ResponseBody
	public ArrayList<ComboInfo> getPlayerDetais(@PathVariable("clusterNumber") int clusters) {
		
		ArrayList<PlayerStats> stats = getPlayerStats();		
		for (PlayerStats s : stats) {
			dataset.add(new ClusterVariable(s));
		}		
		Kmeans kpp = new Kmeans();
		kpp.lloyd(clusters, dataset);
		
		ArrayList<ComboInfo> combo = new ArrayList<ComboInfo>();
		for (int i = 0; i < stats.size(); i++) {
			PlayerStats s = stats.get(i);
			ClusterVariable var = dataset.get(i);
			PlayerProfile profile = SqlManager.getPlayerProfile(s.getProfile_id());
			if (profile == null)
				continue;
			combo.add( new ComboInfo(profile, s, var) );
		}
		
		return combo;
	}
	
	@RequestMapping(value="filter/{filter}")
	@ResponseBody
	public ArrayList<ComboInfo> getFilterGroup(@PathVariable("filter") int filterGroup) {
		ArrayList<ComboInfo> combo = new ArrayList<ComboInfo>();
		if (dataset.size() == 0)
			return combo;
		
		ArrayList<PlayerStats> stats = getPlayerStats();
		for (int i = 0; i < stats.size(); i++) {
			if (dataset.get(i).getGroup() == filterGroup) {
				PlayerStats s = stats.get(i);
				ClusterVariable var = dataset.get(i);
				PlayerProfile profile = SqlManager.getPlayerProfile(s.getProfile_id());
				if (profile == null)
					continue;
				combo.add( new ComboInfo(profile, s, var) );
			}
		}
		return combo;
	}
}
