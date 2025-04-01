<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" contentType="text/html; charset=UTF-8" %>
<html>
<head>
	<title>Home</title>
</head>
<body>

<h1>  글 상세조회  </h1>
<c:if test="${dto != null}">
	<table border="1" style="border-collapse: collapse;">
		<tr>
			<th>글번호</th>
			<td>${dto.articleno}</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${dto.subject}</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>${dto.content}</td>
		</tr>
	</table>
	<br>
	<button onclick="location.href='/listArticle'">목록으로</button>
	<button onclick="location.href='/update/${dto.articleno}'">수정</button>
	<button onclick="location.href='/deleteArticle/${dto.articleno}'">삭제</button>
	
</c:if>

</body>
</html>
