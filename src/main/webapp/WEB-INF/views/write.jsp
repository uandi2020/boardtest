<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>�۾��� ���</h2>
	<form action="/write.do" method="post" enctype="multipart/form-data">
		<input type="hidden" name="writer" value="test">
		���� : <input type="text" name="title">
		���� : <textarea cols=30 rows=5 name=contents></textarea>
		    <div class="container">
			<input type="file" name="filename">
			<!-- ���⼭ files�� controller�� @RequestPart MultipartFile files -->
		<button type="submit">Ȯ��</button>
	</form>
</body>
</html>