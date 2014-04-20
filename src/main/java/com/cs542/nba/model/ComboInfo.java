package com.cs542.nba.model;

public class ComboInfo {

	PlayerProfile profile;
	PlayerStats stats;
	ClusterVariable v;
	
	public ComboInfo(PlayerProfile profile, PlayerStats stats, ClusterVariable v) {
		super();
		this.profile = profile;
		this.stats = stats;
		this.v = v;
	}

	public PlayerProfile getProfile() {
		return profile;
	}

	public void setProfile(PlayerProfile profile) {
		this.profile = profile;
	}

	public PlayerStats getStats() {
		return stats;
	}

	public void setStats(PlayerStats stats) {
		this.stats = stats;
	}

	public ClusterVariable getV() {
		return v;
	}

	public void setV(ClusterVariable v) {
		this.v = v;
	}
	
}
