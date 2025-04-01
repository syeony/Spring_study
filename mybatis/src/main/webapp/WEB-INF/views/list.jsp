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
	<h1>list.jsp</h1>
	
	<c:if test="${list!=null }">
		<c:forEach var="dto" items="${list}">
			<h2>${dto.articleno} ${dto.subject} ${dto.content}</h2>
		</c:forEach>
	</c:if>
	
	<c:if test="${list.size()==0 }">
		<h2>게시글이 없습니다. </h2>
	</c:if>
</body>
</html>