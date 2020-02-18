<%@page import="com.douzone.guestbook.dao.GuestbookDao"%>
<%@page import="com.douzone.guestbook.vo.GuestbookVo"%>
<%
	request.setCharacterEncoding( "utf-8" );

	String name = request.getParameter( "name" );
	String password = request.getParameter( "pass" );
	String contents = request.getParameter( "contents" );
	
	GuestbookVo vo = new GuestbookVo();
	vo.setName( name );
	vo.setPassword( password );
	vo.setContents( contents );
	
	new GuestbookDao().insert( vo );
	
	response.sendRedirect( request.getContextPath() );
%> 
