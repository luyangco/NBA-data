package com.cs542.nba.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.cs542.nba.model.PlayerProfile;
import com.cs542.nba.model.PlayerStats;

public class SqlManager {

	public static ArrayList<PlayerStats> getAllPlayerStats(int minimumGamesPlayed, int minimumMinutesPerGame) {
		
		List<PlayerStats> stats = DataManager.getDatabaseInstance().query(
				"Select * from player_stats "
				+ "where games_played >= ? and minutes >= ?",
				new Object[]{ minimumGamesPlayed, minimumMinutesPerGame},
				new RowMapper<PlayerStats>() {
					@Override
					public PlayerStats mapRow(ResultSet rs, int rowNum) throws SQLException {
						return new PlayerStats(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4),
								rs.getFloat(5), rs.getInt(6), rs.getInt(7), rs.getInt(8),
								rs.getInt(9), rs.getInt(10), rs.getInt(11), rs.getInt(12),
								rs.getInt(13), rs.getInt(14), rs.getInt(15), rs.getInt(16), 
								rs.getInt(17), rs.getInt(18), rs.getInt(19), rs.getInt(20));
					}					
				}
		);
		
		return (ArrayList<PlayerStats>)stats;
	}

	public static PlayerProfile getPlayerProfile(int profile_id) {
		
		List<PlayerProfile> profile = DataManager.getDatabaseInstance().query(
				"Select * from player_profile where id = ?", 
				new Object[]{ profile_id },
				new RowMapper<PlayerProfile>() {
					@Override
					public PlayerProfile mapRow(ResultSet rs, int rowNum) throws SQLException {
						return new PlayerProfile(rs.getInt(1), rs.getString(3), rs.getString(4), rs.getString(5), 
								rs.getInt(6), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getInt(10), 
								rs.getString(11), rs.getString(12));
					}
				}
		);
		
		if (profile.size() == 0)
			return null;
		
		return profile.get(0);
	}
}
