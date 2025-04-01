<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" contentType="text/html; charset=UTF-8" %>
<html>
<head>
	<title>Home</title>
</head>
<body>

<h1>  글 수정  </h1>
<c:if test="${dto != null}">
	<form method="post" action="/updateArticle">
		<table border="1" style="border-collapse: collapse;">
			<tr>
				<th>글번호</th>
				<td><input type="text" name="articleno" value="${dto.articleno}" size="33" readonly></td>
			</tr>
			<tr>
				<th>글쓴이</th>
				<td><input type="text" name="userid" value="${dto.userid}" size="33" readonly></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="subject" value="${dto.subject}" size="33"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea type="text" name="content" rows="10" cols="35">${dto.content}</textarea></td>
			</tr>
		</table>
		<br>
		<button type="submit">수정</button>
	</form>	
	<button onclick="location.href='/listArticle'">목록으로</button>
</c:if>

</body>
</html>
