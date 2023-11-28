<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
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
    <link href="img/favicon.ico" rel="icon">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600&family=Nunito:wght@600;700;800&display=swap" rel="stylesheet">

    <!-- Icon Font Stylesheet -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="lib/animate/animate.min.css" rel="stylesheet">
    <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

    <!-- Customized Bootstrap Stylesheet -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Template Stylesheet -->
    <link href="css/style.css" rel="stylesheet">
    
    
<script>
function uploadfrmCheck() {
	document.signupfrm.userphone.value = document.signupfrm.phone1.value + document.signupfrm.phone2.value + document.signupfrm.phone3.value;
	
	
	if(document.signupfrm.append.value=="")
	{
		document.signupfrm.action="/yuser/addYuser.do";
	}
	else
		document.signupfrm.action="/yuser/insertYuserVO.do";
	document.signupfrm.submit();
}
</script>
     
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



	
	
	
	
	 <!-- Contact Start -->
<section class="h-100 bg-dark">
<form id="signupfrm" name="signupfrm" target="_self" action="/yuser/insertYuserVO.do" method="post" enctype="multipart/form-data">
  <div class="container py-5 h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col">
        <div class="card card-registration my-4">
          <div class="row g-0">
            <div class="col-xl-6 d-none d-xl-block">
              <div height="100%"
                alt="Sample photo" class="img-fluid"
                style="border-top-left-radius: .25rem; border-bottom-left-radius: .25rem; height: 100%; background-size: cover; background-image: url(/img/gcimg.jpg);" ></div>
            </div>
            <div class="col-xl-6">
              <div class="card-body p-md-5 text-black">
                <h3 class="mb-5 text-uppercase">회원가입</h3>

                <div class="row">
                  <div class="mb-4">
                    <div class="form-outline">
                      <input type="text" id="form3Example1m" class="form-control form-control-lg" name="username"/>
                      <label class="form-label" for="form3Example1m">이름</label>
                    </div>
                  </div>
                </div>


                <div class="row">
                  <div class="mb-4">
                    <div class="form-outline">
                      <input type="text" id="form3Example1m" class="form-control form-control-lg" name="userid"/>
                      <label class="form-label" for="form3Example1m">학번</label>
                    </div>
                  </div>
                </div>

                <div class="row">
                  <div class="mb-4">
                    <div class="form-outline">
                      <input type="password" id="form3Example1m" class="form-control form-control-lg" name="userpw" />
                      <label class="form-label" for="form3Example1m">비밀번호</label>
                    </div>
                  </div>
                </div>

                <div class="row">
                  <div class="mb-4">
                    <div class="form-outline">
                      <input type="text" id="form3Example1m" class="form-control form-control-lg" />
                      <label class="form-label" for="form3Example1m">비밀번호 확인</label>
                    </div>
                  </div>
                </div>

                

                <div class="row">
                  <div class="col mb-3">
                    <div class="form-outline">
                      <!-- <input type="text" id="form3Example1m1" class="form-control form-control-lg" /> -->
                      <select name="phone1" class="form-select" aria-label="Floating label select example" id="" style="width: 100%; height: 48px;">
                        <option value="">선택하세요</option>
                        <option value="010">010</option>
                        <option value="011">011</option>
                        <option value="013">013</option>
                        <option value="017">017</option>
                      </select>
                      <label class="form-label" for="form3Example1n1">휴대폰 번호</label>
                    </div>
                  </div>
                  <div class="col-1 mb-3">
                    <h1>-</h1>
                  </div>
                  <div class="col mb-3">
                    <div class="form-outline">
                      <input type="text" id="form3Example1n1" class="form-control form-control-lg" name="phone2"/>
                    </div>
                  </div>
                   <div class="col-1 mb-3">
                    <h1>-</h1>
                  </div>
                   <div class="col mb-3">
                    <div class="form-outline">
                      <input type="text" id="form3Example1n1" class="form-control form-control-lg" name="phone3"/>
                      
                    </div>
                  </div>
                </div>
				<input type="hidden" id="" name="userphone">
                <div class="form-outline mb-4">
                  <input type="text" id="form3Example8" class="form-control form-control-lg" name="useraddr"/>
                  <label class="form-label" for="form3Example8">주소</label>
                </div>

                <div class="d-md-flex justify-content-start align-items-center mb-4 py-2">

                  <h6 class="mb-0 me-4">학년: </h6>

                  <div class="form-check form-check-inline mb-0 me-4">
                    <input class="form-check-input" type="radio" name="usergrade" id="femaleGender"
                      value="1" checked/>
                    <label class="form-check-label" for="femaleGender">1학년</label>
                  </div>

                  <div class="form-check form-check-inline mb-0 me-4">
                    <input class="form-check-input" type="radio" name="usergrade" id="maleGender"
                      value="2" />
                    <label class="form-check-label" for="maleGender">2학년</label>
                  </div>

                  <div class="form-check form-check-inline mb-0">
                    <input class="form-check-input" type="radio" name="usergrade" id="otherGender"
                      value="3" />
                    <label class="form-check-label" for="otherGender">3학년</label>
                  </div>

                </div>

                <!-- <div class="row">
                  <div class="col-md-6 mb-4">
                    <select class="select">
                      <option value="1">학년</option>
                      <option value="2">1학년</option>
                      <option value="3">2학년</option>
                      <option value="4">3학년</option>
                      <option value="4">4학년</option>
                    </select>

                  </div>
                  <div class="col-md-6 mb-4">

                    <select class="select">
                      <option value="1">City</option>
                      <option value="2">Option 1</option>
                      <option value="3">Option 2</option>
                      <option value="4">Option 3</option>
                    </select>

                  </div>
                </div> -->

                <div class="row">
                  <div class="mb-4">
                    <div class="form-outline">
                       <select class="form-select" id="floatingSelect" name="departno" aria-label="Floating label select example" style="height: 48px;">
                        <option value="0" selected>학과선택</option>
                        <option value="1">컴퓨터정보계열</option>
                        <option value="2">간호학과</option>
                        <option value="3">건축학과</option>
                      </select>
                      <label for="floatingSelect">학과선택</label>
                    </div>
                  </div>
                </div>

                <div class="row">
                  <div class="mb-4">
                    <input class="form-control form-control-sm" id="formFileSm" name="append" type="file">
                    <label for="formFileSm" class="form-label">프로필 사진</label>
                  </div>
                </div>

                <div class="d-flex justify-content-end pt-3">
                  <button type="button" class="btn btn-light btn-lg">Reset</button>
                  <button type="button" class="btn btn-warning btn-lg ms-2" onclick="uploadfrmCheck();">가입하기</button>
                </div>

              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  </form>
</section>
    </div>
    <!-- Contact End -->
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

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
</body>

</html>