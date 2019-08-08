<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="/datacraft/result" method="post" enctype="multipart/form-data">
	<table width="500" border="0" align="center" bgcolor="dddddd">
		        <tr>
                <td width="600" colspan="2" align="center"><b>파일 업로드 기능</b></td>
        </tr>
        <tr>
                <td width="100" align="center">파일명</td>
                <td width="500"> <input type="file" name="upfile" size="20">(파일의 용량 제한 : 20M)</td>
        </tr>
        <tr>
                <td align="center" colspan="2">
                        <input type="submit" value="전송"> <input type="reset" value="취소">
                </td>
        </tr>
	</table>
	</form>
	

</body>
</html>