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
</head>
    
    
<script>
function signincheck(){//로그인 버튼 누르면 호출
	  var id = document.getElementById('form2Example17').value;//아이디
	  var pw = document.getElementById('form2Example27').value;//비번

	  if(id.length <1) {//아이디 썼는지 확인
	    alert('학번을 입력해주세요.');
	    document.getElementById('form2Example17').focus();
	    return false;
	  }

	  if(pw.length <1) {//비번 썼는지 확인
	    alert('비밀번호를 입력해주세요.');
	    document.getElementById('form2Example27').focus();
	    return false;
	  }


	  document.memberloginfrm.submit();
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



	
	
	
	
	
	
	
	
	
	
	<section class="vh-100" style="background-color: #181D38;">
  <div class="container py-5 h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col col-xl-10">
        <div class="card" style="border-radius: 1rem;">
          <div class="row g-0">
            <div class="col-md-6 col-lg-5 d-none d-md-block" style="background-image : url('/img/gcimg.jpg'); background-repeat : no-repeat;
        background-size : cover;">
            <!--   <img src="/img/gcimg.jpg"
                alt="login form" class="img-fluid" style="border-radius: 1rem 0 0 1rem; width:100%; height:100%;" /> -->
            </div>
            <div class="col-md-6 col-lg-7 d-flex align-items-center">
              <div class="card-body p-4 p-lg-5 text-black">

                <form action ="/yuser/checkUserLogin.do" method="post" id="memberloginfrm" name="memberloginfrm" target="_self">

                  <div class="d-flex align-items-center mb-3 pb-1">
                    <i class="fas fa-cubes fa-2x me-3" style="color: #ff6219;"></i>
                    <span class="h1 fw-bold mb-0">로그인</span>
                  </div>

                  <h5 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">Sign into your account</h5>

                  <div class="form-outline mb-4">
                    <input type="text" id="form2Example17" name="userid" class="form-control form-control-lg" onkeydown="return event.key !== ' ';" />
                    <label class="form-label" for="form2Example17">학번</label>
                  </div>

                  <div class="form-outline mb-4">
                    <input type="password" id="form2Example27" name="userpw" class="form-control form-control-lg" onkeydown="return event.key !== ' ';"/>
                    <label class="form-label" for="form2Example27">비밀번호</label>
                  </div>

                  <div class="pt-1 mb-4">
                    <button class="btn btn-dark btn-lg btn-block" type="button" onclick="signincheck();">Login</button>
                  </div>

                  <a class="small text-muted" href="/findpw.jsp">비밀번호를 잊으셨나요?</a>
                  <p class="mb-5 pb-lg-2" style="color: #393f81;">회원이 아니신가요? <a href="/signup.jsp"
                      style="color: #393f81;">회원가입</a></p>
                  <a href="#!" class="small text-muted">Terms of use.</a>
                  <a href="#!" class="small text-muted">Privacy policy</a>
                </form>

              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

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