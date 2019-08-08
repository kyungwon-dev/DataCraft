<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>DataCraft</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
/* Set height of the grid so .sidenav can be 100% (adjust as needed) */
.row.content {
	height: 550px
}

/* Set gray background color and 100% height */
.sidenav {
	background-color: #f1f1f1;
	height: 100%;
}

/* On small screens, set height to 'auto' for the grid */
@media screen and (max-width: 767px) {
	.row.content {
		height: auto;
	}
}
</style>
</head>
<body>
	<jsp:include page="/WEB-INF/active.jsp" />
	<div class="container-fluid">
		<div class="row content">
			<jsp:include page="/WEB-INF/sidebar.jsp" />
			<br>
			<div class="textbox"> 
			<label for="ex_input">아이디</label> 
			<input type="text" id="ex_input"> 
			</div>

			<div class="col-sm-9">
				<div class="well">
					<h4>Dashboard</h4>
					<p>Some text..</p>
				</div>
				<div class="row">
					<div class="col-sm-3">
						<div class="well">
							<h4>Users</h4>
							<p>1 Million</p>
						</div>
					</div>
					<div class="col-sm-3">
						<div class="well">
							<h4>Pages</h4>
							<p>100 Million</p>
						</div>
					</div>
					<div class="col-sm-3">
						<div class="well">
							<h4>Sessions</h4>
							<p>10 Million</p>
						</div>
					</div>
					<div class="col-sm-3">
						<div class="well">
							<h4>Bounce</h4>
							<p>30%</p>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-4">
						<div class="well">
							<p>Text</p>
							<p>Text</p>
							<p>Text</p>
						</div>
					</div>
					<div class="col-sm-4">
						<div class="well">
							<p>Text</p>
							<p>Text</p>
							<p>Text</p>
						</div>
					</div>
					<div class="col-sm-4">
						<div class="well">
							<p>Text</p>
							<p>Text</p>
							<p>Text</p>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-8">
						<div class="well">
							<p>Text</p>
						</div>
					</div>
					<div class="col-sm-4">
						<div class="well">
							<p>Text</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
