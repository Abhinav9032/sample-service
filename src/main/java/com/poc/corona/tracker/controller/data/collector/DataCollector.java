package com.poc.corona.tracker.controller.data.collector;

import java.util.HashSet;
import java.util.Set;

import org.springframework.web.client.RestTemplate;

public class DataCollector {
	
	
	public String getDataFromPublicApi() {
		final String uri = "https://api.covid19india.org/state_district_wise.json";
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);
		//System.out.println(result);
		return result;
	}
	
	public static void main(String[] args) {
		DataCollector dc = new DataCollector();
		
		dc.getDataFromPublicApi();
		
		APIService svc = new APIService();
		
		svc.processAPIdata(dc.getDataFromPublicApi());
	}

}
