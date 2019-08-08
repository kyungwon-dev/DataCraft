<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String arr = request.getParameter("inputStr");
	
%>
<jsp:forward page="reader">
	<jsp:param name="inputSer" value="arr"/>
</jsp:forward>