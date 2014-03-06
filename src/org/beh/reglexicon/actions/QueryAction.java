package org.beh.reglexicon.actions;

import com.opensymphony.xwork2.Action;
import org.beh.reglexicon.*;

public class QueryAction implements Action {
	public static final String TYPE_CLASSIC = "classic";
	public static final String TYPE_PLAIN = "plain";
	public static final String TYPE_REGEX = "regex";
	public static final String TYPE_WILDCARD = "wildcard";
	
	private String feature;
	private String type;
	private Result result;

	public String getFeature() {
		return feature;
	}

	public void setFeature(String feature) {
		this.feature = feature;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public Result getResult(){
		return result;
	}

	public String execute() {
		if (feature==null || type==null || feature.equals("") || type.equals("")){
			return "index";
		}
		Searcher searcher = Searcher.getInstance(type);
		result = searcher.find(feature);
		String errorInfo = result.getErrorInfo();
//		int amount = result.getAmount();
		if ( (errorInfo==null || errorInfo.equals("")==true) && result.getAmount()>0 ){
			return SUCCESS;
		}
		return ERROR;
	}
}
