<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>正则词典</title>

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
	<form action="query">
		<table align='center'>
			<tr align='center'>
				<td>RegLexicon</td>
			</tr>
			<tr align='center'>
				<td><input type="text" name="feature" value=''  size="48"/> <select
					name="type">
						<option value="classic">经典</option>
						<option value="wildcard" selected>通配</option>
						<option value="regex">正则</option>
				</select></td>
			</tr>
			<tr align='center'>
				<td><input type="submit" value="查询" /></td>
			</tr>
		</table>
	</form>
</body>
</html>
