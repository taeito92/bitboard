<%--
  Created by IntelliJ IDEA.
  User: gg974
  Date: 2021-08-20
  Time: 오후 2:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/upload" method="post" enctype="multipart/form-data">
    <input type="text" name="title" value="test...">
    <input type="file" name="uploadFiles" multiple>
    <button type="submit">Submit</button>
</form>
</body>
</html>