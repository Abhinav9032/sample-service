package com.poc.corona.tracker.controller;

import java.util.Date;
import java.util.HashMap;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc.corona.tracker.controller.data.collector.APIService;
import com.poc.corona.tracker.controller.data.collector.DataCollector;

@RestController
public class CoronaAPIController {
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/getDataStatewise")
	public HashMap<String , Integer> getStateWiseData() {
		 
		DataCollector dc = new DataCollector();
		
		dc.getDataFromPublicApi();
		
		APIService svc = new APIService();
		
		return svc.processAPIdata(dc.getDataFromPublicApi());
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/getDistrictWise")
	public String getDistrictWiseData() {
		return "DistricWise";
	}
	
	@CrossOrigin(origins = "http://www.springservice.xyz")
	@GetMapping("/get")
	public String getReturn() {
		System.out.println("Hey I got a request at :  "+ new Date());
		return "Hello bro";
	}

}
