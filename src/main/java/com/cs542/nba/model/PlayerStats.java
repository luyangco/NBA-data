package com.cs542.nba.model;

public class PlayerStats {
	int team_id;
	int profile_id;
	int games_played;
	int games_started;
	float minutes;
	int field_goals_att;
	int three_points_att;
	int free_throws_att;
	int field_goals_made;
	int three_points_made;
	int free_throws_made;
	int offensive_rebounds;
	int defensive_rebounds;
	int rebounds;
	int assists;
	int steals;
	int blocks;
	int turnovers;
	int personal_fouls;
	int points;
	
	public PlayerStats(int team_id, int profile_id, int games_played,
			int games_started, float minutes, int field_goals_att,
			int three_points_att, int free_throws_att, int field_goals_made,
			int three_points_made, int free_throws_made,
			int offensive_rebounds, int defensive_rebounds, int rebounds,
			int assists, int steals, int blocks, int turnovers,
			int personal_fouls, int points) {
		super();
		this.team_id = team_id;
		this.profile_id = profile_id;
		this.games_played = games_played;
		this.games_started = games_started;
		this.minutes = minutes;
		this.field_goals_att = field_goals_att;
		this.three_points_att = three_points_att;
		this.free_throws_att = free_throws_att;
		this.field_goals_made = field_goals_made;
		this.three_points_made = three_points_made;
		this.free_throws_made = free_throws_made;
		this.offensive_rebounds = offensive_rebounds;
		this.defensive_rebounds = defensive_rebounds;
		this.rebounds = rebounds;
		this.assists = assists;
		this.steals = steals;
		this.blocks = blocks;
		this.turnovers = turnovers;
		this.personal_fouls = personal_fouls;
		this.points = points;
	}

	public int getTeam_id() {
		return team_id;
	}

	public void setTeam_id(int team_id) {
		this.team_id = team_id;
	}

	public int getProfile_id() {
		return profile_id;
	}

	public void setProfile_id(int profile_id) {
		this.profile_id = profile_id;
	}

	public int getGames_played() {
		return games_played;
	}

	public void setGames_played(int games_played) {
		this.games_played = games_played;
	}

	public int getGames_started() {
		return games_started;
	}

	public void setGames_started(int games_started) {
		this.games_started = games_started;
	}

	public float getMinutes() {
		return minutes;
	}

	public void setMinutes(float minutes) {
		this.minutes = minutes;
	}

	public int getField_goals_att() {
		return field_goals_att;
	}

	public void setField_goals_att(int field_goals_att) {
		this.field_goals_att = field_goals_att;
	}

	public int getThree_points_att() {
		return three_points_att;
	}

	public void setThree_points_att(int three_points_att) {
		this.three_points_att = three_points_att;
	}

	public int getFree_throws_att() {
		return free_throws_att;
	}

	public void setFree_throws_att(int free_throws_att) {
		this.free_throws_att = free_throws_att;
	}

	public int getField_goals_made() {
		return field_goals_made;
	}

	public void setField_goals_made(int field_goals_made) {
		this.field_goals_made = field_goals_made;
	}

	public int getThree_points_made() {
		return three_points_made;
	}

	public void setThree_points_made(int three_points_made) {
		this.three_points_made = three_points_made;
	}

	public int getFree_throws_made() {
		return free_throws_made;
	}

	public void setFree_throws_made(int free_throws_made) {
		this.free_throws_made = free_throws_made;
	}

	public int getOffensive_rebounds() {
		return offensive_rebounds;
	}

	public void setOffensive_rebounds(int offensive_rebounds) {
		this.offensive_rebounds = offensive_rebounds;
	}

	public int getDefensive_rebounds() {
		return defensive_rebounds;
	}

	public void setDefensive_rebounds(int defensive_rebounds) {
		this.defensive_rebounds = defensive_rebounds;
	}

	public int getRebounds() {
		return rebounds;
	}

	public void setRebounds(int rebounds) {
		this.rebounds = rebounds;
	}

	public int getAssists() {
		return assists;
	}

	public void setAssists(int assists) {
		this.assists = assists;
	}

	public int getSteals() {
		return steals;
	}

	public void setSteals(int steals) {
		this.steals = steals;
	}

	public int getBlocks() {
		return blocks;
	}

	public void setBlocks(int blocks) {
		this.blocks = blocks;
	}

	public int getTurnovers() {
		return turnovers;
	}

	public void setTurnovers(int turnovers) {
		this.turnovers = turnovers;
	}

	public int getPersonal_fouls() {
		return personal_fouls;
	}

	public void setPersonal_fouls(int personal_fouls) {
		this.personal_fouls = personal_fouls;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
	
}
