<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<style>
	body {
       background: linear-gradient(to bottom, #fef9f9, #f6e6e6);
       font-family: 'Noto Serif KR', serif;
       text-align: center;
       margin: 0;
       padding: 0;
       display: flex;
       flex-direction: column;
       justify-content: center;
       align-items: center;
       height: 100vh;
       overflow: hidden;
       color: #4e4e4e;
       position: relative;
    }
    h1 {
        font-size: 3em;
        margin-bottom: 20px;
        animation: fadeIn 2s ease-in-out;
    }
    button {
        background-color: #ffb6c1;
        border: none;
        padding: 10px 20px;
        margin: 10px;
        border-radius: 20px;
        cursor: pointer;
        font-size: 1.2em;
        color: white;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        transition: transform 0.3s ease, background-color 0.3s ease;
    }
    button:hover {
        background-color: #ff69b4;
        transform: scale(1.05);
    }
    .container {
        padding: 50px;
        background-color: rgba(255, 255, 255, 0.9);
        border-radius: 20px;
        box-shadow: 0 10px 20px rgba(0, 0, 0, 0.1);
        animation: fadeIn 1.5s ease-in-out;
    }
    table {
        width: 80%;
        margin: 20px auto;
        border-collapse: collapse;
        background: rgba(255, 255, 255, 0.8);
        border-radius: 10px;
        overflow: hidden;
        box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
        animation: fadeIn 2s ease-in-out;
    }
    th, td {
        padding: 15px;
        text-align: center;
        border-bottom: 1px solid #ddd;
    }
    th {
        background-color: #ffb6c1;
        color: white;
        letter-spacing: 1px;
    }
    tr:hover {
        background-color: #f5e6e6;
    }
    @keyframes fadeIn {
        from {
            opacity: 0;
        }
        to {
            opacity: 1;
        }
    }
    .petal {
        position: absolute;
        background: pink;
        width: 15px;
        height: 15px;
        border-radius: 50%;
        opacity: 0.8;
        animation: fall 10s linear infinite;
    }
    @keyframes fall {
        from {
            transform: translateY(-100px) translateX(0px) rotate(0deg);
        }
        to {
            transform: translateY(100vh) translateX(30px) rotate(360deg);
        }
    }
</style>
</head>
<body>
<h1>update.jsp</h1>
<c:if test="${dto != null}">
	<form method="post" action="/updateArticle">
		<table border="1" style="border-collapse: collapse;">
			<tr>
				<th>isbn</th>
				<td><input type="text" name="isbn" value="${dto.isbn}" size="33" readonly></td>
			</tr>
			<tr>
				<th>title</th>
				<td><input type="text" name="title" value="${dto.title}" size="33"></td>
			</tr>
			<tr>
				<th>author</th>
				<td><input type="text" name="author" value="${dto.author}" size="33"></td>
			</tr>
			<tr>
				<th>price</th>
				<td><input type="number" name="price" value="${dto.price}" size="33"></td>
			</tr>
			<tr>
				<th>content</th>
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