<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
</head>
<body>
  <h1>  SSAFY 방명록  </h1>

  <a href="/listArticle">글 목록</a>
  <a href="/index.html">회원관리</a>

  <div id="loginForm">  <!-- 로그인 되어 있지 않으면 -->
    <form method="post" action="/login">
    loginid : <input type="text" name="userid"><br>
    loginpwd: <input type="password" name="userpwd"><br>
    <button type=submit>로그인</button>
    </form>
  </div>
  <div id="welcome"><!-- 로그인 되었다면 -->
    <h2><span id="userName"></span> 님 환영합니다.</h2>
    <a href="/logout">로그아웃</a>
  </div>
  
<br><br>
   <script type="text/javascript">
    const cookies = document.cookie; // cookie1=value1; cookie2=value2;...
    const cookie = cookies.split("=") 
    console.log((document.getElementById("loginForm")))
    if(cookie[0] == 'ssafy_id'){
        document.getElementById("loginForm").style.display = "none";
        document.getElementById("welcome").style.display = "visible";
        document.getElementById("userName").innerText = cookie[1]
    }else{
        document.getElementById("loginForm").style.display  = "visible";
        document.getElementById("welcome").style.display  = "none";
    }
   </script>
</body>
</html>
