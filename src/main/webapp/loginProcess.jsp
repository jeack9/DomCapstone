<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="egovframework.yuser.service.YuserVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%YuserVO  loginedUserVO = (YuserVO) request.getAttribute("loginedUserVO");
		if(loginedUserVO != null){
			session.setAttribute("loginedUserVO", loginedUserVO);
			%>
				<script>alert('로그인 성공!')
					location.href = "/index.jsp"
				</script>
			<% 
		}else{
			%>
			<script>
			alert('로그인 실패하였습니다.');
			location.href = "/signin.jsp"
			</script>
			
			<%
		}
	%>
</body>
</html>