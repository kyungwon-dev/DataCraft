<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% String projectPath = request.getContextPath(); %>
<div class="col-sm-3 sidenav hidden-xs">
	<h2>DataCraft</h2>
	<ul class="nav nav-pills nav-stacked">
		<li class="active"><a href="<%=projectPath%>/main.jsp">Dashboard</a></li>
		<li><a href="<%=projectPath%>/table.jsp">Table</a></li>
	</ul>
	<br>
</div>