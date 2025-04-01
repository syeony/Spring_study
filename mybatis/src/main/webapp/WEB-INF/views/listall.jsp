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
	<h1>listall.jsp</h1>
	userid: ${member.userid }
	username: ${member.username }
	
	<h2>사용자 글 쓴 내역</h2>
	<c:forEach var="dto" items="${member.guestBookDtoList }">
		 <h2>${dto.articleno} ${dto.subject} ${dto.content}</h2>
	</c:forEach>
</body>
</html>