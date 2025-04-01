<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" contentType="text/html; charset=UTF-8" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Write!!!
</h1>

<form method="post" action="/writeArticle">
    <table border="1" style="border-collapse: collapse;">
        <tr>
            <th>글쓴이</th>
            <td><input type="text" name="userid" id="userid" size="33" readonly></td>
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

    <script type="text/javascript">
        const cookies = document.cookie; // cookie1=value1; cookie2=value2;...
        const cookie = cookies.split("=") 
            console.log(cookie[1])
        if(cookie[0] == 'ssafy_id'){
        	console.log(cookie[1])
            document.getElementById("userid").value = cookie[1];
        }
    </script>
</body>
</html>
