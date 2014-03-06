package org.beh.reglexicon;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.regex.PatternSyntaxException;

public abstract class Searcher {
	public static String PACKAGE_NAME = Searcher.class.getPackage().getName();
	
	protected Dictionary dict;
	protected String lastError;
	protected long lastTimeCost;
	
	public Searcher() {
		dict = DictionaryLoader.getDictionary();
	}
	
	public void setLastError(String error){
		lastError=error;
	}
	public String getLastError(){
		return lastError;
	}
	
	public long getLastTimeCost(){
		return lastTimeCost;
	}
	
	public abstract String getSearchMethod();
	public abstract List<Word> handle(String feature) throws Exception;
	
	public static Searcher getInstance(String searcherName){
		Searcher searcher = null;
		//TODO 利用反射获取一个对象的实例
		if (searcherName.length()<2) return null;
		char firstChar = searcherName.charAt(0);
		if (Character.isLowerCase(firstChar)) firstChar-=0x20;
		String SearcherName = firstChar+searcherName.substring(1);
		String className = PACKAGE_NAME+".searcher."+SearcherName+"Searcher";
		System.out.println("载入"+className);
		try {
			Class<? extends Searcher> clazz = (Class<? extends Searcher>) Class.forName(className);
			Method method = clazz.getMethod("getInstance");
			searcher = (Searcher) method.invoke(clazz);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return searcher;
	}
	
	public Result find(String feature){
		Result result = new Result(feature);
		try {
			result.setResultSet( handle(feature) );
		} catch (PatternSyntaxException e){
			result.setErrorInfo("正则表达式语法错误");
		} catch (Exception e) {
			result.setErrorInfo("未知错误");
		}
		return result;
	}
}
