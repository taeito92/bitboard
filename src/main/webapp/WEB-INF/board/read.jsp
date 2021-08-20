<%--
  Created by IntelliJ IDEA.
  User: gg974
  Date: 2021-08-19
  Time: 오전 11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>${boardDTO}</div>
<div>${pageDTO}</div>

<a href="/board/list?page=${pageDTO.page}&size=${pageDTO.size}">목록</a>

</body>
</html>
