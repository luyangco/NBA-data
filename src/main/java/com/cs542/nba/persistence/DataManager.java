package com.cs542.nba.persistence;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class DataManager {

	private static JdbcTemplate databaseInstance = null;
	
	public static JdbcTemplate getDatabaseInstance() {
		if (databaseInstance == null) {
			DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    	dataSource.setUrl("jdbc:mysql://localhost:3306/NBA_data");
	    	dataSource.setUsername("root"); //  <-- input your database username here
	    	dataSource.setPassword(""); 	//  <-- input your database password here
	    	dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	    	databaseInstance = new JdbcTemplate(dataSource);
		}
    	
		return databaseInstance;
	}
}
