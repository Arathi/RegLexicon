<%@page import="org.beh.reglexicon.searcher.*"%>
<%@page import="org.beh.reglexicon.*"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

response.sendRedirect("query.action");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>正则字典</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  <%
  String wordfeature = request.getParameter("wordfeature");
  if (wordfeature==null || wordfeature.equals("")){
  %>
  	<form action="index.jsp">
  		<input type="text" name="wordfeature" value='' /><br/>
  		<input type="submit" >
  	</form>
    <br/>
    <%
    }
    else{
    %>
   	<form action="index.jsp">
  		<input type="text" name="wordfeature" value='<%=wordfeature %>' /> 
  		<input type="submit" />
  	</form>
    <%
    //显示结果
    	Searcher searcher = new WildcardSearcher();
    	Result result = searcher.find(wordfeature);
    	List<Word> results = result.getResultSet();
    	double timeCost = result.getTimeCost();
    	int amount = (results!=null)?results.size():0;
    	if (amount>0){
    		%>找到<%=amount %>条结果 （用时<%=searcher.getLastTimeCost() %> 秒）<br/><br/><%
    		for (Word word : results){
    		%>
    			<a href=""><%=word.getName() %></a><br/>
       		<%
    		}
    	}
    	else{
    		%>找不到和您查询的 "<%=wordfeature %>" 相符的单词或词组<%
    	}
    }
    %>
  </body>
</html>
