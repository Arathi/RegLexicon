package org.beh.reglexicon;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Dictionary {
	protected Map<String, Word> words;
	protected int wordAmount;
	
	public Dictionary(){
		words=new HashMap<String, Word>();
	}
	
	public Word getWord(String key){
		if (words.containsKey(key)) return words.get(key);
		return null;
	}
	
	public void setWord(Word word){
		String key = word.getName();
		words.put(key, word);
	}
	
	public Set<String> getWordList(){
		return words.keySet();
	}
}
