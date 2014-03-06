package org.beh.reglexicon;

import java.util.List;

public class Result {
	protected long startTime;
	protected long endTime;
	
	protected List<Word> resultSet;
	protected String feature;
	protected int amount;
	
	protected String errorInfo;
	
	public Result(String feature){
		this.feature = feature;
		endTime = startTime = System.currentTimeMillis();
		errorInfo = "";
		amount = 0;
	}
	
	public void setResultSet(List<Word> resultSet){
		this.resultSet = resultSet;
		endTime = System.currentTimeMillis();
		if (resultSet!=null){
			amount = resultSet.size();
		}
	}
	
	public List<Word> getResultSet(){
		return resultSet;
	}
	
	public String getErrorInfo(){
		return errorInfo;
	}
	
	public double getTimeCost(){
		double delta = (endTime - startTime)/1000.0;
		return delta;
	}
	
	public int getAmount(){
		return amount;
	}

	public void setErrorInfo(String errorInfo) {
		this.errorInfo = errorInfo;
	}
	
}
