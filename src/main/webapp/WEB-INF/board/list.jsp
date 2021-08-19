<%--
  Created by IntelliJ IDEA.
  User: gg974
  Date: 2021-08-18
  Time: 오후 4:18
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
 <h1>list page</h1>

 <h4>${pageMaker}</h4>
 <form action="/board/list" method="get">
     <input type="hidden" name="page" value="1">
     <select name="size">
         <option value="10" ${pageMaker.size == 10?"selected":""}>10</option>
         <option value="20" ${pageMaker.size == 20?"selected":""}>20</option>
         <option value="50" ${pageMaker.size == 50?"selected":""}>50</option>
         <option value="100" ${pageMaker.size == 100?"selected":""}>100</option>
     </select>
     <button type="submit">적용</button>
 </form>
 <ul>


     <c:forEach items="${dtoList}" var="dto">
         <li>${dto}</li>
     </c:forEach>
 </ul>

 <hr/>


 <ul class="pageList">
     <c:if test="${pageMaker.prev}">
         <li><a href="/board/list?page=${pageMaker.start-1}&size=${pageMaker.size}">PREV</a></li>
     </c:if>

     <c:forEach begin="${pageMaker.start}" end = "${pageMaker.end}" var="page">
         <li><a href="/board/list?page=${page}">${page}</a></li>
     </c:forEach>

     <c:if test="${pageMaker.next}">
         <li><a href="/board/list?page=${pageMaker.end+1}&size=${pageMaker.size}">NEXT</a></li>
     </c:if>

 </ul>

</body>
</html>
