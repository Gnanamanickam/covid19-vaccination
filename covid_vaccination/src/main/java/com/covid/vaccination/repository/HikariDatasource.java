package com.covid.vaccination.repository;

import java.sql.Connection;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Component
public class HikariDatasource {
	
	Logger logger = LoggerFactory.getLogger(HikariDatasource.class);

    private static HikariConfig config = new HikariConfig();
    private static HikariDataSource ds = new HikariDataSource();
    
    private static final String url = "jdbc:mysql://localhost:3306/covid_vaccination";
    private static final String username = "root";
    private static final String password = "root";

    static {
        config.setJdbcUrl(url);
        config.setUsername(username);
        config.setPassword(password);
        config.addDataSourceProperty( "cachePrepStmts" , "true" );
        config.addDataSourceProperty( "prepStmtCacheSize" , "250" );
        config.addDataSourceProperty( "prepStmtCacheSqlLimit" , "2048" );
        config.setMaximumPoolSize(10);
        ds = new HikariDataSource( config );
    }

    private HikariDatasource() {}

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
    
    public void closeConnection(Connection connection) throws SQLException {
    	try {
    		connection.close();
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    }
}