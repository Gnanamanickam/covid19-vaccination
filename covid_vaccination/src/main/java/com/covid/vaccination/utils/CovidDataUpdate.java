package com.covid.vaccination.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.covid.vaccination.models.CovidVaccinationDetails;
import com.covid.vaccination.repository.CovidVaccinationDetailsRepository;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;


@Component
public class CovidDataUpdate {
	
	@Autowired
	FetchData fd;
	
	@Autowired
	CovidVaccinationDetailsRepository vaccinationRep;
	Logger logger = LogManager.getLogger(CovidDataUpdate.class);
	
	@SuppressWarnings("unused")
	@Scheduled(cron = "25 * * * * ?")
	public void updateTable() throws IOException, ParseException, InterruptedException, ExecutionException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
		logger.info("API call started  :: " + Calendar.getInstance().getTime());	
		
		ResponseEntity<String> response = fd.fetchData("https://raw.githubusercontent.com/sociepy/covid19-vaccination-subnational/main/data/vaccinations.csv");
		String responseData = response.getBody();
		String[] csvData = responseData.split(System.getProperty("line.separator"));
		BufferedReader lineReader = new BufferedReader( new StringReader(responseData));
		lineReader.readLine();
		 String lineText;
		 
		List<Callable<Object>> callable = new ArrayList<Callable<Object>>();
		int id = 0;
		while ((lineText = lineReader.readLine()) != null) {
			final String line = new String(lineText);
//			callable.add(new Callable<Object>() {
//
//				@Override
//				public Object call() throws Exception {
		             String[] data = line.split(",");
		             CovidVaccinationDetails vaccinationdetails = new CovidVaccinationDetails();
		             vaccinationdetails.setId(id++);
		             System.out.println("Inside while loop");
		             String location = data[0];
		             vaccinationdetails.setLocation(location);
		             String region = data[1];
		             vaccinationdetails.setRegion(region);
		             String date = data[2];
		             vaccinationdetails.setDate(new SimpleDateFormat("yyyy-mm-dd").parse(date));
		             String location_iso = data[3];
		             vaccinationdetails.setLocation_iso(location_iso);
		             String region_iso = data[4];
		             vaccinationdetails.setRegion_iso(region_iso);
		             String total_vaccinations = data[5] == null ? "0" : data[5];
		             vaccinationdetails.setTotal_vaccinations(Integer.parseInt(total_vaccinations));
		             String people_vaccinated = data[6] == null ? "0" : data[6];
		             vaccinationdetails.setPeople_vaccinated(Integer.parseInt(people_vaccinated));
		             String people_fully_vaccinated = data[7];
		             vaccinationdetails.setTotal_vaccinations(Integer.parseInt(total_vaccinations));
		             String total_vaccinations_per_100 = data[8] == null ? "0" : data[8];
		             vaccinationdetails.setTotal_vaccinations_per_100(Double.parseDouble(total_vaccinations_per_100));
		             String people_vaccinated_per_100 = data[9] == null ? "0.0" : data[9];
		             vaccinationdetails.setPeople_vaccinated_per_100(Double.parseDouble(people_vaccinated_per_100));
		             String people_fully_vaccinated_per_100 = data[10] == null ? "0.0" : data[10];
		             vaccinationdetails.setPeople_fully_vaccinated_per_100(Double.parseDouble(people_fully_vaccinated_per_100));
		             vaccinationRep.save(vaccinationdetails);
//		             return null;
				}
//			});
		
//		 }
		lineReader.close();
//		ResourceHandler.submitJob(callable);
//		ResourceHandler.Shutdown();
		}
	}
