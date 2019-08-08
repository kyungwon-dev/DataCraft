<%@page import="com.datacraft.vo.ExcelInfoVO"%>
<%@page import="com.datacraft.vo.ExcelVO"%>
<%@page import="java.util.List"%>
<%@page import="com.datacraft.excelreader.FileLoader"%>
<%@page import="com.datacraft.excelreader.ExcelReader"%>
<%@page import="com.datacraft.excelreader.*"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String projectPath = request.getContextPath(); //프로젝트 path 반환
	ExcelReader excelReader = new ExcelReader();
	FileLoader fileLoader = new FileLoader();
	fileLoader.setfilePath("C:\\Java\\eclipse-workspace\\DataCraft\\WebContent\\resources\\excel");
	fileLoader.fileset();
	String inputStr = request.getParameter("inputStr");
	excelReader.setFindString(inputStr);
	List<ExcelVO> xlsxList=null;
	for(int i=0;i<fileLoader.getFileLength();i++){
		xlsxList = excelReader.xlsxToExcelVoList(fileLoader.getFileList(i));
	}
	ExcelInfoVO excelInfovo = excelReader.getExcelInfoV();
%>
<!DOCTYPE html>
<html>
<head>
<title>DataCraft</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!-- Bootstrap core CSS-->
<!-- Custom fonts for this template-->
<link
	href="<%=projectPath%>/resources/sb_admin1/vendor/datatables/dataTables.bootstrap4.css"
	rel="stylesheet">
<!-- Bootstrap core JavaScript-->
<script
	src="<%=projectPath%>/resources/sb_admin1/vendor/jquery/jquery.min.js"></script>
<!-- Core plugin JavaScript-->
<script
	src="<%=projectPath%>/resources/sb_admin1/vendor/jquery-easing/jquery.easing.min.js"></script>
<!-- Page level plugin JavaScript-->
<script
	src="<%=projectPath%>/resources/sb_admin1/vendor/datatables/jquery.dataTables.js"></script>
<script
	src="<%=projectPath%>/resources/sb_admin1/vendor/datatables/dataTables.bootstrap4.js"></script>
<!-- Custom scripts for all pages-->
<script src="<%=projectPath%>/resources/sb_admin1/js/sb-admin.min.js"></script>
<!-- Custom scripts for this page-->
<script
	src="<%=projectPath%>/resources/sb_admin1/js/sb-admin-datatables.js"></script>
</head>
<body class="fixed-nav sticky-footer bg-dark" id="page-top">
	<div class="container-fluid">
		<div class="row content">
			<div class="well">
				<jsp:include page="/WEB-INF/sidebar.jsp" />
				<div class="well">
					<div class="card mb-3">
						<div class="card-header">
							<i class="fa fa-table"></i>
							<h3>Search Excel.xslx</h3>
							<form action="/DataCraft/table.jsp" method="get">
								<div class="textbox">
									<label for="input_text">이름</label> <input type="text"
										name="inputStr"> <input type="submit" value="찾기">
								</div>
							</form>
						</div>
						<div class="card-body">
							<div class="table-responsive">
								<table class="table" id="dataTable">
									<thead>
										<tr>
											<%
											if(inputStr != null){
												for(int i=0;i<excelInfovo.getIndex() ; i++){
										%>
											<th><%=excelInfovo.getInfo(i) %></th>
											<% } %>
										</tr>
									</thead>
									<tfoot>
										<tr>
											<%for(int i=0;i<excelInfovo.getIndex() ; i++){%>
											<th><%=excelInfovo.getInfo(i)%></th>
											<% } %>
										</tr>
									</tfoot>
									<tbody>
										<%for(int m=0;m<fileLoader.getFileLength();m++){
												xlsxList = excelReader.xlsxToExcelVoList(fileLoader.getFileList(m));
												for(int k=0;k<excelReader.getSheetPage();k++){
												for(int j=0;excelReader.getfindIndex(k,j)!=0; j++){
											%>
										<tr>
											<%		for(int i=0;i<excelReader.getXSSFRow().getPhysicalNumberOfCells();i++){
										%>

											<td><%=xlsxList.get(j).getCell(i) %></td>
											<%} %>
										</tr>
										<% }
												}
												
												}
										}	%>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
