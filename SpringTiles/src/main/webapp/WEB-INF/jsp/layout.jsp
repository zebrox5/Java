<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- Need to add the JSTL library -->
<%@taglib prefix="tile" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- name="title" should be the same in tiles.xml -->
<title><tile:insertAttribute name="title" ignore="true" /></title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<center>
	<div  style="width:80%;">
		<!-- this should be same as that of name used for header in tiles.xml -->
		<div style="background-color: #F8C471">
			<tile:insertAttribute name="header" />
		</div>
		<div
			style="float: left; width: 15%; height: 450px; background-color: #C39BD3;">
			<tile:insertAttribute name="menu" />
		</div>
		<!-- body in "base" doesn't have value. It comes from home and contact -->
		<div
			style="float: left; width: 85%; height: 450px; background-color: #76D7C4;">
			<tile:insertAttribute name="body" />
		</div>
		<div style="clear: both">
			<tile:insertAttribute name="footer" />
		</div>
	</div>
</center>
</body>
</html>