package com.cs542.nba.model;

public class ClusterVariable {

	int gp; /* Game Played */
	int min; /* Minutes played per game */
	int team_id;
	int profile_id;
	float ar; /* Assist Ratio */
	float tor; /* Turnover Ratio */
	float or; /* Average Offensive Rebound */
	float dr; /* Average Defensive Rebound */
	float stls; /* Average Steals */
	float blks; /* Average Blocks */
	float field_goal_atts; /* Average Shoot Attempts */
	float three_atts; /* Average Three Points Attempts */
	float ft_atts; /* Average Free Throws Attempts */
	float field_goal_pct; /* Field Goal percentage */
	float three_pct; /* 3 Points percentage */
	float ft_pct; /* Free Throw percentage */
	
	int group;
	
	private static final double precision = 0.00001d;
	
	public ClusterVariable(float ar, float tor, float or, float dr, float stls,
			float blks, float two_atts, float three_atts, float ft_atts,
			float two_pct, float three_pct, float ft_pct) {
		super();
		this.team_id = 0;
		this.profile_id = 0;
		this.ar = ar;
		this.tor = tor;
		this.or = or;
		this.dr = dr;
		this.stls = stls;
		this.blks = blks;
		this.field_goal_atts = two_atts;
		this.three_atts = three_atts;
		this.ft_atts = ft_atts;
		this.field_goal_pct = two_pct;
		this.three_pct = three_pct;
		this.ft_pct = ft_pct;
		
		this.group = 0;
	}
	
	public ClusterVariable(PlayerStats stats) {
		this.team_id = 0;
		this.profile_id = stats.profile_id;
		this.ar = ( stats.assists ) / (stats.free_throws_att * 0.44f + stats.field_goals_att + stats.turnovers);
		this.tor = (stats.turnovers) / (stats.free_throws_att * 0.44f + stats.field_goals_att + stats.turnovers);
		this.or = (float)stats.offensive_rebounds / stats.games_played;
		this.dr = (float)stats.defensive_rebounds / stats.games_played;
		this.stls = (float)stats.steals / stats.games_played;
		this.blks = (float)stats.blocks / stats.games_played;
		this.field_goal_atts = (float)(stats.field_goals_att/* - stats.three_points_att*/) / stats.games_played;
		this.three_atts = (float)stats.three_points_att / stats.games_played;
		this.ft_atts = (float)stats.free_throws_att / stats.games_played;
		if (stats.field_goals_att == 0)
			this.field_goal_pct = 0;
		else
			this.field_goal_pct = (float)stats.field_goals_made / stats.field_goals_att;
		
		if (stats.three_points_att == 0)
			this.three_pct = 0;
		else 
			this.three_pct = (float)stats.three_points_made / stats.three_points_att;
	
		if (stats.free_throws_att == 0)
			this.ft_pct = 0;
		else
			this.ft_pct = (float)stats.free_throws_made / stats.free_throws_att;
		
		this.group = 0;
		
	}
	

	public int getTeam_id() {
		return team_id;
	}

	public int getProfile_id() {
		return profile_id;
	}

	public float getAr() {
		return ar;
	}

	public void setAr(float ar) {
		this.ar = ar;
	}

	public float getTor() {
		return tor;
	}

	public void setTor(float tor) {
		this.tor = tor;
	}

	public float getOr() {
		return or;
	}

	public void setOr(float or) {
		this.or = or;
	}

	public float getDr() {
		return dr;
	}

	public void setDr(float dr) {
		this.dr = dr;
	}

	public float getStls() {
		return stls;
	}

	public void setStls(float stls) {
		this.stls = stls;
	}

	public float getBlks() {
		return blks;
	}

	public void setBlks(float blks) {
		this.blks = blks;
	}

	public float getTwo_atts() {
		return field_goal_atts;
	}

	public void setTwo_atts(float two_atts) {
		this.field_goal_atts = two_atts;
	}

	public float getThree_atts() {
		return three_atts;
	}

	public void setThree_atts(float three_atts) {
		this.three_atts = three_atts;
	}

	public float getFt_atts() {
		return ft_atts;
	}

	public void setFt_atts(float ft_atts) {
		this.ft_atts = ft_atts;
	}

	public float getTwo_pct() {
		return field_goal_pct;
	}

	public void setTwo_pct(float two_pct) {
		this.field_goal_pct = two_pct;
	}

	public float getThree_pct() {
		return three_pct;
	}

	public void setThree_pct(float three_pct) {
		this.three_pct = three_pct;
	}

	public float getFt_pct() {
		return ft_pct;
	}

	public void setFt_pct(float ft_pct) {
		this.ft_pct = ft_pct;
	}

	public int getGroup() {
		return group;
	}

	public void setGroup(int group) {
		this.group = group;
	}
	
	public boolean isEqual(ClusterVariable var) {
		return (this.ar - var.ar < precision) &&
				(this.tor - var.tor < precision) &&
				(this.or - var.or < precision) &&
				(this.dr - var.dr < precision) &&
				(this.stls - var.stls < precision) &&
				(this.blks - var.blks < precision) &&
				(this.field_goal_atts - var.field_goal_atts < precision) &&
				(this.three_atts - var.three_atts < precision) &&
				(this.ft_atts - var.ft_atts < precision) &&
				(this.field_goal_pct - var.field_goal_pct < precision) &&
				(this.three_pct - var.three_pct < precision) &&
				(this.ft_pct - var.ft_pct < precision);
	}
}
