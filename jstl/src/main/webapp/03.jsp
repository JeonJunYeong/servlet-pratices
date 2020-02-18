    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JSTL(forEach TAG)</h1>
	<h2>${fn:length(list) }</h2>
	
	<c:forEach items='${list }' var='vo' varStatus='status'>
		${listCount-status.index }->${status.index}: ${status.count }| ${vo.no } : ${vo.name } <br>
	</c:forEach>
	<c:set var='count2' value='10'/>
		===${count2}===
</body>
</html>