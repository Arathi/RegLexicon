package org.beh.reglexicon.searcher;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.beh.reglexicon.Searcher;
import org.beh.reglexicon.Word;
import java.util.regex.*;

public class RegexSearcher extends Searcher {
	private static Searcher instance;
	public static Searcher getInstance(){
		if (instance==null){
			instance = new RegexSearcher();
		}
		return instance;
	}
	
	@Override
	public String getSearchMethod() {
		return "正则查找";
	}

	@Override
	public List<Word> handle(String feature) throws Exception {
		List<Word> results = new ArrayList<Word>();
		final Set<String> wordList = dict.getWordList();
		Pattern pattern = Pattern.compile(feature);
		for (String key : wordList){
			Matcher m = pattern.matcher(key);
			if (m.find()){
				Word word = dict.getWord(key);
				results.add(word);
			}
		}
		return results;
	}

}
