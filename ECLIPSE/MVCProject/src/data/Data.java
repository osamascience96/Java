package data;

import java.util.HashMap;

import bean.StatePair;
import helper.UcwordsHelper;

public class Data {
	private HashMap<String, StatePair> hashMap;
	
	public Data() {
		this.hashMap = new HashMap<String, StatePair>();
	}
	
	public void InitlizeData() {
		this.hashMap.put("Maryland", new StatePair("Maryland", "MD"));
		this.hashMap.put("California", new StatePair("California", "CA"));
		this.hashMap.put("Florida", new StatePair("Florida", "FL"));
		this.hashMap.put("Hawaii", new StatePair("Hawaii", "HI"));
		this.hashMap.put("Colorado", new StatePair("Colorado", "CO"));
		this.hashMap.put("Lasvegas", new StatePair("Lasvegas", "LV"));
	}
	
	public StatePair GetStatePair(String state) {
		return this.hashMap.get(state);
	}
}
