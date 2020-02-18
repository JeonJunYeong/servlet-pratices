<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	pageContext.setAttribute("newLine", "\n");

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>값 받아오기</h1>
	${ival } <br> 
	${lval } <br> 
	${fval } <br>
	${bval } <br>  
	-${obj }-- <br>
	${vo.no} <br>  
	<p style ='width :100px; height:50px;border:1px solid #0000ff'>
		${fn:replace(sval,newLine,"<br>") }
	</p>
	<h1>연산</h1>
	${map.ival +10 }<br>
	${map.ival ==10 }<br>
	
	
	<h1>파라미터 값 받아보기 </h1>
	-${param.a }- <br>
	-${param.email }- <br>
	
	<h1>map으로 값 받아보기</h1>
	${map.ival } <br>
	${map.lval } <br>
	
	
	
</body>
</html>