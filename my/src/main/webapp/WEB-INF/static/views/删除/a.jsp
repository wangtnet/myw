<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ page import="java.util.*" %>
<html>
<body>
<%
    request.setAttribute("result",true);
%>
<h2></h2>
<c:set var="userName" value="张三"/>        
<c:if test="${result == true}"  var="flag">
    hello
</c:if>
<c:choose>
	<c:when test="${result == false}">
		false
	</c:when>
	<c:otherwise>
		otherwise
	</c:otherwise>
</c:choose>

 <script language="JavaScript" type="text/javascript">
          
    </script>
</body>
</html>
