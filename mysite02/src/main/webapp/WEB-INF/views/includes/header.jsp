<%@page import="com.bit2020.mysite.vo.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        
<%
	HttpSession session2 = request.getSession();
	UserVo authUser = (UserVo)session2.getAttribute("authUser");
%>
<div id="header">
			<h1>MySite</h1>
			<%
				if(authUser != null){
					
			%>
			<ul>
		
				<li><a href="<%=request.getContextPath() %>/user?a=updateform">회원정보수정</a><li>
				<li><a href="<%=request.getContextPath() %>/user?a=logout">로그아웃</a><li>
				<li><%=authUser.getName() %>님 안녕하세요 ^^;</li>	
			<%
				} else{
			%>
				<li><a href="<%=request.getContextPath() %>/user?a=loginform">로그인</a><li>
				<li><a href="<%=request.getContextPath() %>/user?a=joinform">회원가입</a><li>
				
			</ul>
			<%
				}
			%>
		</div>