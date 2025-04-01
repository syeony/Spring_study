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
        font-family: 'Arial', sans-serif;
        text-align: center;
        margin: 0;
        padding: 0;
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
        height: 100vh;
        overflow: hidden;
        color: #ff69b4;
        text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.3);
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
        transform: scale(1.1);
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
        <h1>🌸 승연이네 도서관 🌸</h1>
        <button onclick="location.href='/register'">책 등록</button>
        <button onclick="location.href='/list'">책 목록</button>
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