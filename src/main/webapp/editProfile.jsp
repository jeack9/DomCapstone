<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html lang="en">

<head>
    <meta charset="utf-8">
    <title>eLEARNING - eLearning HTML Template</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="" name="keywords">
    <meta content="" name="description">

    <!-- Favicon -->
    <link href="/img/favicon.ico" rel="icon">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600&family=Nunito:wght@600;700;800&display=swap" rel="stylesheet">

    <!-- Icon Font Stylesheet -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="/lib/animate/animate.min.css" rel="stylesheet">
    <link href="/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

    <!-- Customized Bootstrap Stylesheet -->
    <link href="/css/bootstrap.min.css" rel="stylesheet">

    <!-- Template Stylesheet -->
    <link href="/css/style.css" rel="stylesheet">
    <style>
    input[type=file]::file-selector-button {
		color: #FFFFFF; cursor: pointer; background-color: #06BBCC; 
        border-color: #06BBCC; font-family: 'Nunito', sans-serif; font-weight: 600; padding: 6px 12px;
	}
    </style>
</head>

<body>
    <!-- Spinner Start -->
    <div id="spinner" class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
        <div class="spinner-border text-primary" style="width: 3rem; height: 3rem;" role="status">
            <span class="sr-only">Loading...</span>
        </div>
    </div>
    <!-- Spinner End -->

	<!-- Navbar Start -->
	<%@ include file="/navbar.jsp" %>
	<!-- Navbar End -->
	
	<%
	System.out.println(System.getProperty("user.dir"));
	%>
	
	<div class="container-fluid bg-primary py-5 mb-5 page-header">
        <div class="container py-5">
            <div class="row justify-content-center">
                <div class="col-lg-10 text-center">
                    <h1 class="display-3 text-white animated slideInDown">프로필 수정</h1>
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb justify-content-center">
                            <li class="breadcrumb-item"><a class="text-white" href="#">Home</a></li>
                            <li class="breadcrumb-item"><a class="text-white" href="#">Pages</a></li>
                            <li class="breadcrumb-item text-white active" aria-current="page">상 벌점 조회</li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
    </div>
	<!-- EditProfile Strat  -->
	<div class="container-xl px-4 mt-4">
	    <!-- Account page navigation-->
	    <nav class="nav nav-borders">
<!-- 	        <a class="nav-link active ms-0" href="https://www.bootdey.com/snippets/view/bs5-edit-profile-account-details" target="__blank">Profile</a>
	        <a class="nav-link" href="https://www.bootdey.com/snippets/view/bs5-profile-billing-page" target="__blank">Billing</a>
	        <a class="nav-link" href="https://www.bootdey.com/snippets/view/bs5-profile-security-page" target="__blank">Security</a>
	        <a class="nav-link" href="https://www.bootdey.com/snippets/view/bs5-edit-notifications-page"  target="__blank">Notifications</a> -->
	    </nav>
	    <hr class="mt-0 mb-4">
	    <div class="row">	    
	        <div class="col-xl-4">
	            <!-- Profile picture card-->
	            <div class="card mb-4 mb-xl-0">
	                <div class="card-header">프로필 사진</div>
	                <div class="card-body text-center">
	                    <!-- Profile picture image-->
	                    <div>
	                    <img class="img-account-profile rounded-circle mb-2" id="imgsrc" src="/${loginedUserVO.appendix}" alt="" width="50%" style="aspect-ratio: 1 / 1;">
	                    </div>
	                    <!-- Profile picture upload button-->
 	                    <label for="chooseFileBtn" style="color: #FFFFFF; cursor: pointer; background-color: #06BBCC; 
	                    border-color: #06BBCC; font-family: 'Nunito', sans-serif; font-weight: 600; padding: 6px 12px;
	                    ">새 프로필 사진 업로드</label>
	                    <form action="/yuser/editProfileImage.do" method="post" id="chooseFile" name="editimagefrm" enctype="multipart/form-data">
	                    <input type="file" id="chooseFileBtn" name="append" accept="image/*" onchange="handleFileChange(event)" style="display:none;">
	                    </form>
	                    <!-- <button class="btn btn-primary" type="button">저장</button> -->
	                </div>
	            </div>
	        </div>
	        <div class="col-xl-8">
	            <!-- Account details card-->
	            <div class="card mb-4">
	                <div class="card-header">회원 정보</div>
	                <div class="card-body">
	                    <form action="/yuser/editYuser.do" method="post" name="updatefrm">
	                    	<!-- Form Group (학번)-->
	                        <div class="mb-3">
	                            <label class="small mb-1" for="inputUserid">학번</label>
	                            <input class="form-control" id="inputUserid" type="text" name="userid" value="${loginedUserVO.userid}" readonly style="background-color: #e9ecef; opacity: 1">
	                        </div>
	                        <!-- Form Group (이름)-->
	                        <div class="mb-3">
	                            <label class="small mb-1" for="inputUsername">이름</label>
	                            <input class="form-control" id="inputUsername" type="text" name="username" value="${loginedUserVO.username}" onkeydown="return event.key !== ' ';">
	                        </div>
	                         <!-- Form Group (비밀번호)-->
	                        <div class="mb-3">
	                            <label class="small mb-1" for="pw" id="pwCheckView">비밀번호</label>
	                            <input class="form-control" id="pw" type="password" name="userpw" value="">
	                        </div>
	                        <!-- Form Group (비밀번호 확인)-->
	                        <div class="mb-3">
	                            <label class="small mb-1" for="pwCheck" id="pwCheckedView">비밀번호확인</label>
	                            <input class="form-control" id="pwCheck" type="password" value="">
	                        </div>
	                        <!-- 전화번호w-->
	                        <div class="row gx-3 mb-3" style="justify-content: space-between;">
	                            <label class="small mb-1" for="inputUsernumber">전화번호</label>
	                            <!-- Form Group (전화번호)-->
	                            <div class="col-md-6" style="width: 30%;">
                                <select name="phone1" class="form-select" aria-label="Floating label select example">
			                        <option value="">선택하세요</option>
			                        <option value="010">010</option>
			                        <option value="011">011</option>
			                        <option value="013">013</option>
			                        <option value="017">017</option>
		                        </select>
	                            </div>
	                            <c:set var="phone" value="${loginedUserVO.userphone}">	                            
	                            </c:set>
	                            <b style ="width:2%">-</b>
	                            <input  id="userphone" name="userphone" style="display : none;"/>
	                            <!-- Form Group (middle num)-->
	                            <div class="col-md-6 " style="width: 30%;">
	                                <input class="form-control" value="${fn:substring(phone,3,7)}" type="number" pattern="[0-9]*" onkeydown="return event.key !== ' ';" oninput="javascript: if (this.value.length > 4) this.value = this.value.slice(0, 4);" name="phone2">
	                            </div>
	                            <b style ="width:2%">-</b>
	                            <!-- Form Group (last num)-->
	                            <div class="col-md-6" style="width: 30%;">
	                                <input class="form-control" value="${fn:substring(phone,7,11)}" type="number" pattern="[0-9]*" onkeydown="return event.key !== ' ';" oninput="javascript: if (this.value.length > 4) this.value = this.value.slice(0, 4);" name="phone3">
	                            </div>
	                        </div>
	                        <!-- Form Group (주소)-->
	                        <div class="mb-3">
	                            <label class="small mb-1" for="inputAddress">주소</label>
	                            <input class="form-control" id="inputAddress" type="text" placeholder="주소" value="${loginedUserVO.useraddr}" onkeydown="return event.key !== ' ';" name="useraddr">
	                        </div>	                       
	                        <!-- Save changes button-->
	                        <button class="btn btn-primary" type="button" onclick="updateUser()">변경사항 저장</button>
			        </form>
	                </div>
	            </div>
	        </div>
	    </div>
	</div>
	<!-- EditProfile Endd  -->
	              	
    <!-- Footer Start -->
    <%@ include file="/footer.jsp" %>
    <!-- Footer End -->


    <!-- Back to Top -->
    <a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i class="bi bi-arrow-up"></i></a>


    <!-- JavaScript Libraries -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="/lib/wow/wow.min.js"></script>
    <script src="/lib/easing/easing.min.js"></script>
    <script src="/lib/waypoints/waypoints.min.js"></script>
    <script src="/lib/owlcarousel/owl.carousel.min.js"></script>

    <!-- Template Javascript -->
    <script src="/js/main.js"></script>
    <script src="/js/editprofile.js"></script>
</body>
<script type="text/javascript">
const handleFileChange = (event) =>{
  	const file = event.target.files[0];
  	var form = $('#chooseFile')[0];
    var formData = new FormData(form);
	$.ajax({
		url: '/yuser/editProfileImage.do', // 클라이언트가 요청을 보낼 서버의 URL 주소
		/* data: $("#chooseFile").serialize(), */ // HTTP 요청과 함께 서버로 보낼 데이터 form id 또는 name.serialize()
		data: formData,
		type: 'POST',          // HTTP 요청 방식(GET, POST)
		dataType: 'json',      // 호출 했을 때 결과타입
		contentType : false,
        processData : false,
		success : function(data) {
			alert("사진을 변경하였습니다.");
            setTimeout(() => $("#imgsrc").attr("src", "/"+data.imgSrc), 3000);
		},
		error: function(){
            alert("에러요");
        }
	});
}
</script>
</html>