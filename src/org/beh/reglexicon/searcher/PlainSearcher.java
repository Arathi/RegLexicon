package org.beh.reglexicon.searcher;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.beh.reglexicon.Searcher;
import org.beh.reglexicon.Word;

public class PlainSearcher extends Searcher {
	private static Searcher instance;
	public static Searcher getInstance(){
		if (instance==null){
			instance = new PlainSearcher();
		}
		return instance;
	}
	
	@Override
	public List<Word> handle(String feature) {
		List<Word> results = new ArrayList<Word>();
		Set<String> wordList = dict.getWordList();
		if (wordList.contains(feature)){
			Word word = dict.getWord(feature);
			results.add(word);
			return results;
		}
		return results;
	}

	@Override
	public String getSearchMethod() {
		return "绝对查找";
	}
	
}
