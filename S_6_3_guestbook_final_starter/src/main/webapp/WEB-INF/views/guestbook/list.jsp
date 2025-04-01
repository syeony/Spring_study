<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" contentType="text/html; charset=UTF-8" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>  글 목록  </h1>
<button onclick="location.href='/write'">글쓰기</button>
<button onclick="location.href='/'">홈으로</button>
<br><br>
<c:if test="${articles != null}">
	<table border="1" style="border-collapse: collapse;">
      <tr>
		<th>글번호</th>
		<th>제목</th>
		<th>내용</th>
      </tr>
      <c:forEach var="guestbook" items="${articles}">
		<tr>
			<td>${guestbook.articleno}</td>
			<td><a href="getArticle/${guestbook.articleno}">${guestbook.subject}</a></td>
			<td>${guestbook.content}</td>
		</tr>
      </c:forEach>
	</table>
</c:if>



</body>
</html>
