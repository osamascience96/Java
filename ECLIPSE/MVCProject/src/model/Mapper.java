package model;

import bean.StatePair;
import data.Data;

public class Mapper {
	private String stateName;
	private Data data;
	
	public Mapper(String stateName) {
		this.stateName = stateName;
		this.data = new Data();
		this.data.InitlizeData();
	}
	
	public StatePair GetStatePairObject() {
		return this.data.GetStatePair(this.stateName);
	}
}
