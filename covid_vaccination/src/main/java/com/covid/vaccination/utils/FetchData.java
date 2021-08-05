package com.covid.vaccination.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.sql.DataSource;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FetchData {
	
	@Autowired
	DataSource dataSource;
	
	Logger logger = LogManager.getLogger(FetchData.class);
	
	public ResponseEntity<String> fetchData(String url) {
		RestTemplate req = new RestTemplate();
		ResponseEntity<String> response = null;
		try {
			response = req.getForEntity(url, String.class);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return response;
		
	}
	
	public JSONArray fetchDataSet(String query, Connection conn) throws SQLException {
		Date time = new Date();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		logger.info(time + "/n" + query);
		JSONArray result = convertToJson(rs);
		return result;
	}
	
	public void updateDataSet(String query, Connection conn) throws SQLException {
		Date time = new Date();
		Statement st = conn.createStatement();
		st.executeUpdate(query);
		logger.info(time + "/n" + query);
	}
	
	@SuppressWarnings("unchecked")
	public JSONArray convertToJson(ResultSet rs) throws SQLException {
		JSONArray jsonArray = new JSONArray();
		while(rs.next()) {
			int numColumns = rs.getMetaData().getColumnCount();
		      JSONObject obj = new JSONObject();
		      for (int i=1; i<numColumns+1; i++) {
		          String column_name = rs.getMetaData().getColumnName(i);
		          obj.put(column_name, rs.getObject(i));
		      }	
		      jsonArray.add(obj);
		}
		 return jsonArray;
	}
	
	public JSONArray getDetails(String query) {
		JSONArray details = new JSONArray();
		try {
			Connection conn = (Connection) dataSource.getConnection();
			details = fetchDataSet(query, conn);
			conn.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return details;
		
	}

}
