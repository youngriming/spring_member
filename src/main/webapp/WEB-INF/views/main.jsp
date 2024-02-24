<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>main</title>
</head>
<body>
    <h2>${sessionScope.loginEmail} 님 환영합니다.</h2> <%--세션에서 담고 있는 이메일 정보를 띄워줌--%>
    <button onclick="update()">내정보 수정하기</button>
    <button onclick="logout()">로그아웃</button>

</body>
<script>
    const update = () => {
        location.href = "/member/update";
    }
    const logout = () => {
        location.href = "/member/logout";
    }
</script>
</html>