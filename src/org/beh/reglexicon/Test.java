package org.beh.reglexicon;

import java.util.List;
import java.util.regex.PatternSyntaxException;

public class Test {
	public static void main(String[] args) {
		String input = "?st*";
		String error = "未知错误";
		Searcher searcher = null;// = new WildcardSearcher();
		List<Word> results = null;
		searcher = Searcher.getInstance("wildcard");
		Result result = null;
		try {
			result = searcher.find(input);
			results = result.getResultSet();  
		} catch (PatternSyntaxException e){
			error = "正则表达式语法错误";
		} catch (Exception e) {
			error = "未知错误";
		}
		
		System.out.println("条件: "+input);
		System.out.println("查找方式: "+searcher.getSearchMethod());
		if (results!=null) {
			System.out.println("找到"+results.size()+"个结果！（用时"+result.getTimeCost()+"秒）");
			for (Word word:results){
				System.out.println(word.getName());
			}
		}
		else{
			System.out.println(error);
		}
	}
}
