<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring Blossom Edition</title>
<link href="https://fonts.googleapis.com/css2?family=Noto+Serif+KR:wght@400;700&display=swap" rel="stylesheet">
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
    <div class="container">
        <h1>🌸 List 🌸</h1>
        <button onclick="location.href='/register'">책 등록</button>
        <c:if test="${articles != null}">
            <table>
                <tr>
                    <th>isbn</th>
                    <th>title</th>
                    <th>author</th>
                    <th>price</th>
                    <th>content</th>
                </tr>
                <c:forEach var="guestbook" items="${articles}">
                    <tr>
                        <td>${guestbook.isbn}</td>
                        <td><a href="/getArticle/${guestbook.isbn}">${guestbook.title}</a></td>
                        <td>${guestbook.author}</td>
                        <td>${guestbook.price}</td>
                        <td>${guestbook.content}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </div>
    <script>
        function createPetal() {
            const petal = document.createElement("div");
            petal.classList.add("petal");
            petal.style.left = Math.random() * 100 + "vw";
            petal.style.animationDuration = Math.random() * 5 + 5 + "s";
            document.body.appendChild(petal);
            setTimeout(() => petal.remove(), 10000);
        }
        setInterval(createPetal, 300);
    </script>
</body>
</html>