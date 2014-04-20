package com.cs542.nba.model;

public class PlayerProfile {

	int profile_id;
	String first_name;
	String last_name;
	String abbr_name;
	int weight;
	int height;
	String postion;
	String primary_position;
	int jersey_number;
	String birth_place;
	String birthDate;
	
	public PlayerProfile(int profile_id, String first_name, String last_name,
			String abbr_name, int weight, int height, String postion,
			String primary_position, int jersey_number, String birth_place,
			String birthDate) {
		super();
		this.profile_id = profile_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.abbr_name = abbr_name;
		this.weight = weight;
		this.height = height;
		this.postion = postion;
		this.primary_position = primary_position;
		this.jersey_number = jersey_number;
		this.birth_place = birth_place;
		this.birthDate = birthDate;
	}

	public int getProfile_id() {
		return profile_id;
	}

	public void setProfile_id(int profile_id) {
		this.profile_id = profile_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getAbbr_name() {
		return abbr_name;
	}

	public void setAbbr_name(String abbr_name) {
		this.abbr_name = abbr_name;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getPostion() {
		return postion;
	}

	public void setPostion(String postion) {
		this.postion = postion;
	}

	public String getPrimary_position() {
		return primary_position;
	}

	public void setPrimary_position(String primary_position) {
		this.primary_position = primary_position;
	}

	public int getJersey_number() {
		return jersey_number;
	}

	public void setJersey_number(int jersey_number) {
		this.jersey_number = jersey_number;
	}

	public String getBirth_place() {
		return birth_place;
	}

	public void setBirth_place(String birth_place) {
		this.birth_place = birth_place;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	
}
