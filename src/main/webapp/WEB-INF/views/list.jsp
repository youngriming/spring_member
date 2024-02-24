<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%--forEach 반복을 위한 태그--%>
<html>
<head>
    <title>list</title>
</head>
<body>
    <table>
        <tr>
            <th>id</th>
            <th>email</th>
            <th>password</th>
            <th>name</th>
            <th>age</th>
            <th>mobile</th>
            <th>조회</th>
            <th>삭제</th>
        </tr>
        <c:forEach items="${memberList}" var="member"> <%--tr을 forEach로 감쌌음, memberList만큼 반복, member는 반복변수--%>
            <tr>
                <td>${member.id}</td> <%--dto의 필드값--%>
                <td>
                    <%--url ex) /member?id=1--%>
                    <a href="/member?id=${member.id}">${member.memberEmail}</a>
                </td>
                <td>${member.memberPassword}</td>
                <td>${member.memberName}</td>
                <td>${member.memberAge}</td>
                <td>${member.memberMobile}</td>
                <td>
                    <a href="/member?id=${member.id}">조회</a>
                </td>
                <td>
                    <button onclick="deleteMember('${member.id}')">삭제</button>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
<script>
    const deleteMember = (id) => {
        console.log(id);
        location.href = "/member/delete?id="+id;
    }
</script>
</html>