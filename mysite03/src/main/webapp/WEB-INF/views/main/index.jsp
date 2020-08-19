<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="${pageContext.request.contextPath }/assets/css/mysite.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/jquery/jquery-1.9.0.js"></script>
<script>
/* var param = {
		url : "/mysite03/json",
		type : "get",
		data: "",
		dataType:"json",
		success: function(){
			
		}
}; */
$.ajax({
	url : "/mysite03/json",
	type : "get",
	data: "",
	dataType:"json",
	success: function(response){
		console.log(response);
	}
});

/* 	let o1 = {};
	o1.name = "강성호";
	o1.no = 10;
	console.log(o1); */
	
/* 	let i2 = new Number(10);
	let s2 = new String("hello")
	let b2 = new Boolean(true);
	let b2 = new Object();
	console.log(i); */ //객체 생성 
</script>
</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/includes/header.jsp" />
		<div id="wrapper">
			<div id="content">
				<div id="site-introduction">
					<img id="profile" style="width:200px" src="${pageContext.request.contextPath }/assets/images/myimage2.png">
							<h2>안녕하세요.</h2> <br>
							<c:choose>
								<c:when test='${not empty authUser }'>
									<h2>${authUser.name }의 MySite에 오신 것을 환영합니다.</h2><br>
								</c:when>
								<c:otherwise>
									<br>
								</c:otherwise>
							</c:choose>						
					<br><hr>
					<p>
						이 사이트는 스프링으로 만들었습니다.<br>
						메뉴는  사이트 소개, 방명록, 게시판이 있습니다.<br><br>
						<a href="${pageContext.request.contextPath }/guestbook">방명록</a>에 글 남기기<br>
					</p>
				</div>
			</div>
		</div>
		<c:import url="/WEB-INF/views/includes/navigation.jsp" />
		<c:import url="/WEB-INF/views/includes/footer.jsp" />
	</div>
</body>
</html>