package org.beh.reglexicon.searcher;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.beh.reglexicon.Searcher;
import org.beh.reglexicon.Word;

public class ClassicSearcher extends Searcher {
	private static Searcher instance;
	public static Searcher getInstance(){
		if (instance==null){
			instance = new ClassicSearcher();
		}
		return instance;
	}

	@Override
	public String getSearchMethod() {
		return "经典查找";
	}

	@Override
	public List<Word> handle(String feature) throws Exception {
		List<Word> results = new ArrayList<Word>();
		final Set<String> wordList = dict.getWordList();
		for (String key : wordList){
			if (key.startsWith(feature)==true){
				Word word = dict.getWord(key);
				results.add(word);
			}
		}
		return results;
	}

}
