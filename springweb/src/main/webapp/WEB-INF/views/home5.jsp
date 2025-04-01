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
	<h1>HOME5.jsp</h1>
	${msg } 
	
	<c:if test= "${dto != null}">
		${dto.name } ${dto.age }
	</c:if>
	
	<h2>${userDto.name }</h2>
	<h2>${userDto.age }</h2>
</body>
</html>