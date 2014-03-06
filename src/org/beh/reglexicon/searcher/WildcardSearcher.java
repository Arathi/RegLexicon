package org.beh.reglexicon.searcher;

import java.util.List;

import org.beh.reglexicon.Searcher;
import org.beh.reglexicon.Word;

public class WildcardSearcher extends RegexSearcher {

	private static Searcher instance;
	public static Searcher getInstance(){
		if (instance==null){
			instance = new WildcardSearcher();
		}
		return instance;
	}
	
	@Override
	public String getSearchMethod() {
		// TODO Auto-generated method stub
		return "通配查找";
	}

	@Override
	public List<Word> handle(String feature) throws Exception {
		String pattern = "";
		pattern = feature.replaceAll("\\?", ".");
		pattern = pattern.replaceAll("\\*", ".*?");
		pattern = "^"+pattern+"$";
		System.out.println("\""+feature+"\"编译为正则表达式："+pattern);
		List<Word> results = super.handle(pattern);
		return results;
	}

}
