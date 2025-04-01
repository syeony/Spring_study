<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>HOME4.jsp</h1>
	${msg } 
	<c:if test= "${dto != null}">
		${dto.name } ${dto.age }
	</c:if>
	
	<br>
	<br>
	
	<form method="post" action="/mvc/hello5">
		이름: <input type="text" name="name"><br>
		나이: <input type="text" name="age"><br>
		<input type="submit" value="전송하기">
	</form>
</body>
</html>