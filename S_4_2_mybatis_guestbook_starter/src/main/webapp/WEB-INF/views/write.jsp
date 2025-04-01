<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" contentType="text/html; charset=UTF-8" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Write
</h1>

<form method="post" action="/writeArticle">
    <table border="1" style="border-collapse: collapse;">
        <tr>
            <th>글쓴이</th>
            <td><input type="text" name="userid" value="ssafy" size="33" readonly></td>
        </tr>
        <tr>
            <th>제목</th>
            <td><input type="text" name="subject" size="33"></td>
        </tr>
        <tr>
            <th>내용</th>
            <td><textarea type="text" name="content" rows="10" cols="35"></textarea></td>
        </tr>
    </table>
    <button type="submit">저장</button>
</form>
<button onclick="location.href='/listArticle'">목록으로</button>
</body>
</html>
