package org.beh.reglexicon;

import java.util.HashMap;
import java.util.Map;

public class Word {
	protected String name;
	protected Map<String, String> explain;
	
	public Word(String name){
		this.name = name;
		explain = new HashMap<String, String>();
	}

	public String getName() {
		return name;
	}
	
	@Override
	public String toString(){
		return name+"";
	}
	
}
