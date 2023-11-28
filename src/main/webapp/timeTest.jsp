<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>실시간 정보</div>
<div><p>현재시간: </p><span></span></div>
<script src="/js/jquery-2.1.4.min.js"></script>
<script>
$(document).ready(function(){
	setInterval("updateTime()", 1000);
});
function updateTime(){
	$.ajax({
		url: "/time.jsp",
		type: "get",
		cache: false,
		success: function(data){
			$("span").html(data);
		}
	});
}
</script>
</body>
</html>