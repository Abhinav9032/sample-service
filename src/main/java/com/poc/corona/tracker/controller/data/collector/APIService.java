package com.poc.corona.tracker.controller.data.collector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

public class APIService {

	public HashMap<String , Integer> processAPIdata(String jsonString) {
		JSONObject mainObject = new JSONObject(jsonString);

		JSONArray jsonArray = mainObject.names();
     	Map<String , JSONObject> statesMap = new HashMap<>();
     	ArrayList<HashMap<String , String>> listOfStateCount = new ArrayList<HashMap<String , String>>();
     	HashMap<String , Integer> stateCountMap = new HashMap<String , Integer>();
		for (int i = 0; i < jsonArray.length() ; i++) {
			
			statesMap.put(jsonArray.get(i).toString(), mainObject.getJSONObject(jsonArray.get(i).toString()));
			
			stateCountMap.put(jsonArray.get(i).toString(), caseSum(mainObject.getJSONObject(jsonArray.get(i).toString())));
		}
		
		Map<String , JSONObject> districtMap = new HashMap<>();
		
		System.out.println(stateCountMap);
		
		return stateCountMap;
	}
	
	
	public int caseSum(JSONObject jsonObj) {
		int sum = 0;
		
		JSONArray jsonArray = jsonObj.getJSONObject("districtData").names();
		
		HashMap<String , String> sumStateMap = new HashMap<String , String>();
		
	
		
		for (int i = 0; i < jsonArray.length(); i++) {
			sum+= Integer.parseInt(jsonObj.getJSONObject("districtData").getJSONObject(jsonArray.get(0).toString()).get("confirmed").toString());
	
		}
		
		return sum;
	}
}

