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
    
<style>
body {
  background: #f4f4f4;
}

.banner {
  background: #a770ef;
  background: -webkit-linear-gradient(to right, #a770ef, #cf8bf3, #fdb99b);
/*   background: linear-gradient(to right, #a770ef, #cf8bf3, #fdb99b);
   */
  background : linear-gradient(90deg, rgba(6,187,204,1) 0%, rgba(223,233,235,1) 100%);
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


    <!-- Header Start -->
    <div class="container-fluid bg-primary py-5 mb-5 page-header">
        <div class="container py-5">
            <div class="row justify-content-center">
                <div class="col-lg-10 text-center">
                    <h1 class="display-3 text-white animated slideInDown">시설</h1>
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb justify-content-center">
                            <li class="breadcrumb-item"><a class="text-white" href="#">Home</a></li>
                            <li class="breadcrumb-item"><a class="text-white" href="#">Pages</a></li>
                            <li class="breadcrumb-item text-white active" aria-current="page">facility</li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
    </div>
    <!-- Header End -->


    <!-- Categories Start -->
    
    <!-- Categories Start -->


    <!-- Courses Start -->
    
    
  
  
  
  <div class="container-fluid">
  <div class="px-lg-5">

    <!-- For demo purpose -->
    <div class="row py-5">
      <div class="col-lg-12 mx-auto">
        <div class="text-white p-5 shadow-sm rounded banner">
          <h1 class="display-4">부대시설 사진 갤러리</h1>
          <p class="lead">둘러보기를 클릭하시면 3D로 보실 수 있습니다.</p>
          <!-- <p class="lead">Lorem <a href="https://bootstrapious.com/snippets" class="text-reset"> 
                        ipsum dolor</a>, Images by <a href="https://unsplash.com" class="text-reset">adipisicing elit.</a>.
          </p> -->
        </div>
      </div>
    </div>
    <!-- End -->

    <div class="row">
      <!-- Gallery item -->
      <div class="col-xl-3 col-lg-4 col-md-6 mb-4">
        <div class="bg-white rounded shadow-sm"><img src="/img/facility1.jpg" alt="" class="img-fluid card-img-top">
          <div class="p-4">
            <h5> <a href="" class="text-dark">전경1</a></h5>
            <p class="small text-muted mb-0">기숙사 전경</p>
            <div class="d-flex align-items-center justify-content-between rounded-pill bg-light px-3 py-2 mt-4">
              <p class="small mb-0"><i class="fa fa-picture-o mr-2"></i><span class="font-weight-bold"></span></p>
              <div class="badge badge-danger px-3 rounded-pill font-weight-normal">New</div>
            </div>
          </div>
        </div>
      </div>
      <!-- End -->

      <!-- Gallery item -->
      <div class="col-xl-3 col-lg-4 col-md-6 mb-4">
        <div class="bg-white rounded shadow-sm"><img src="/img/facility2.jpg" alt="" class="img-fluid card-img-top">
          <div class="p-4">
            <h5> <a href="#" class="text-dark">전경2</a></h5>
            <p class="small text-muted mb-0">기숙사 전경</p>
            <div class="d-flex align-items-center justify-content-between rounded-pill bg-light px-3 py-2 mt-4">
              <p class="small mb-0"><i class="fa fa-picture-o mr-2"></i><span class="font-weight-bold"></span></p>
              <div class="badge badge-primary px-3 rounded-pill font-weight-normal">Trend</div>
            </div>
          </div>
        </div>
      </div>
      <!-- End -->

      <!-- Gallery item -->
      <div class="col-xl-3 col-lg-4 col-md-6 mb-4">
        <div class="bg-white rounded shadow-sm"><img src="/img/facility3.jpg" alt="" class="img-fluid card-img-top">
          <div class="p-4">
            <h5> <a href="#" class="text-dark">전경3</a></h5>
            <p class="small text-muted mb-0">기숙사 전경</p>
            <div class="d-flex align-items-center justify-content-between rounded-pill bg-light px-3 py-2 mt-4">
              <p class="small mb-0"><i class="fa fa-picture-o mr-2"></i><span class="font-weight-bold"></span></p>
              <div class="badge badge-warning px-3 rounded-pill font-weight-normal text-white">Featured</div>
            </div>
          </div>
        </div>
      </div>
      <!-- End -->

      <!-- Gallery item -->
      <div class="col-xl-3 col-lg-4 col-md-6 mb-4">
        <div class="bg-white rounded shadow-sm"><img src="/img/facility4.jpg" alt="" class="img-fluid card-img-top">
          <div class="p-4">
            <h5> <a href="/WebGL.jsp?place=Garden&kor=정원" class="text-dark">정원</a></h5>
            <p class="small text-muted mb-0">기숙사 전경</p>
            <div class="d-flex align-items-center justify-content-between rounded-pill bg-light px-3 py-2 mt-4">
              <p class="small mb-0"><i class="fa fa-picture-o mr-2"></i><span class="font-weight-bold" onclick="location.href='/WebGL.jsp?place=Garden&kor=정원'">둘러보기</span></p>
              <div class="badge badge-success px-3 rounded-pill font-weight-normal">Hot</div>
            </div>
          </div>
        </div>
      </div>
      <!-- End -->

      <!-- Gallery item -->
      <div class="col-xl-3 col-lg-4 col-md-6 mb-4">
        <div class="bg-white rounded shadow-sm"><img src="/img/facility5.jpg" alt="" class="img-fluid card-img-top">
          <div class="p-4">
            <h5> <a href="/WebGL.jsp?place=Dom&kor=기숙사" class="text-dark">1인실(내부)</a></h5>
            <p class="small text-muted mb-0">1인실(내부)</p>
            <div class="d-flex align-items-center justify-content-between rounded-pill bg-light px-3 py-2 mt-4">
              <p class="small mb-0"><i class="fa fa-picture-o mr-2"></i><span class="font-weight-bold" onclick="location.href='/WebGL.jsp?place=Dom&kor=기숙사'">둘러보기</span></p>
              <div class="badge badge-primary px-3 rounded-pill font-weight-normal">New</div>
            </div>
          </div>
        </div>
      </div>
      <!-- End -->

      <!-- Gallery item -->
      <div class="col-xl-3 col-lg-4 col-md-6 mb-4">
        <div class="bg-white rounded shadow-sm"><img src="/img/facility6.jpg" alt="" class="img-fluid card-img-top">
          <div class="p-4">
            <h5> <a href="#" class="text-dark">1인실(욕실)</a></h5>
            <p class="small text-muted mb-0">1인실(욕실)</p>
            <div class="d-flex align-items-center justify-content-between rounded-pill bg-light px-3 py-2 mt-4">
              <p class="small mb-0"><i class="fa fa-picture-o mr-2"></i><span class="font-weight-bold"></span></p>
              <div class="badge badge-warning px-3 rounded-pill font-weight-normal text-white">Featured</div>
            </div>
          </div>
        </div>
      </div>
      <!-- End -->

      <!-- Gallery item -->
      <div class="col-xl-3 col-lg-4 col-md-6 mb-4">
        <div class="bg-white rounded shadow-sm"><img src="/img/facility7.jpg" alt="" class="img-fluid card-img-top">
          <div class="p-4">
            <h5> <a href="/WebGL.jsp?place=Study&kor=독서실" class="text-dark">독서실(층별)</a></h5>
            <p class="small text-muted mb-0">조용하고 분위기 좋은 열람실</p>
            <div class="d-flex align-items-center justify-content-between rounded-pill bg-light px-3 py-2 mt-4">
              <p class="small mb-0"><i class="fa fa-picture-o mr-2"></i><span class="font-weight-bold" onclick="location.href='/WebGL.jsp?place=Study&kor=독서실'">둘러보기</span></p>
              <div class="badge badge-info px-3 rounded-pill font-weight-normal">Hot</div>
            </div>
          </div>
        </div>
      </div>
      <!-- End -->

      <!-- Gallery item -->
      <div class="col-xl-3 col-lg-4 col-md-6 mb-4">
        <div class="bg-white rounded shadow-sm"><img src="/img/facility8.jpg" alt="" class="img-fluid card-img-top">
          <div class="p-4">
            <h5> <a href="/WebGL.jsp?place=Break&kor=휴게실" class="text-dark">휴게실</a></h5>
            <p class="small text-muted mb-0">전자레인지,정수기,티포트 구비</p>
            <div class="d-flex align-items-center justify-content-between rounded-pill bg-light px-3 py-2 mt-4">
              <p class="small mb-0"><i class="fa fa-picture-o mr-2"></i><span class="font-weight-bold" onclick="location.href='/WebGL.jsp?place=Break&kor=휴게실'">둘러보기</span></p>
              <div class="badge badge-warning px-3 rounded-pill font-weight-normal text-white">Featured</div>
            </div>
          </div>
        </div>
      </div>
      <!-- End -->

      <!-- Gallery item -->
      <div class="col-xl-3 col-lg-4 col-md-6 mb-4">
        <div class="bg-white rounded shadow-sm"><img src="/img/facility9.jpg" alt="" class="img-fluid card-img-top">
          <div class="p-4">
            <h5> <a href="/WebGL.jsp?place=Gym&kor=체육실" class="text-dark">체육실</a></h5>
            <p class="small text-muted mb-0">다양한 최신식 고가의 운동기구 구비 </p>
            <div class="d-flex align-items-center justify-content-between rounded-pill bg-light px-3 py-2 mt-4">
              <p class="small mb-0"><i class="fa fa-picture-o mr-2"></i><span class="font-weight-bold"  onclick="location.href='/WebGL.jsp?place=Break&kor=체육실'">둘러보기</span></p>
              <div class="badge badge-danger px-3 rounded-pill font-weight-normal">New</div>
            </div>
          </div>
        </div>
      </div>
      <!-- End -->

      <!-- Gallery item -->
      <div class="col-xl-3 col-lg-4 col-md-6 mb-4">
        <div class="bg-white rounded shadow-sm"><img src="/img/facility10.jpg" alt="" class="img-fluid card-img-top">
          <div class="p-4">
            <h5> <a href="#" class="text-dark">탁구장</a></h5>
            <p class="small text-muted mb-0">넓고 깨끗한 탁구장</p>
            <div class="d-flex align-items-center justify-content-between rounded-pill bg-light px-3 py-2 mt-4">
              <p class="small mb-0"><i class="fa fa-picture-o mr-2"></i><span class="font-weight-bold"></span></p>
              <div class="badge badge-primary px-3 rounded-pill font-weight-normal">Trend</div>
            </div>
          </div>
        </div>
      </div>
      <!-- End -->

      <!-- Gallery item -->
      <div class="col-xl-3 col-lg-4 col-md-6 mb-4">
        <div class="bg-white rounded shadow-sm"><img src="/img/facility11.jpg" alt="" class="img-fluid card-img-top">
          <div class="p-4">
            <h5> <a href="/WebGL.jsp?place=Laundry&kor=세탁실" class="text-dark">세탁실</a></h5>
            <p class="small text-muted mb-0">코인세탁기,건조기 층마다 다수 보유</p>
            <div class="d-flex align-items-center justify-content-between rounded-pill bg-light px-3 py-2 mt-4">
              <p class="small mb-0"><i class="fa fa-picture-o mr-2"></i><span class="font-weight-bold" onclick="location.href='/WebGL.jsp?place=Laundry&kor=세탁실'">둘러보기</span></p>
              <div class="badge badge-warning px-3 rounded-pill font-weight-normal text-white">Featured</div>
            </div>
          </div>
        </div>
      </div>
      <!-- End -->

      <!-- Gallery item -->
      <div class="col-xl-3 col-lg-4 col-md-6 mb-4">
        <div class="bg-white rounded shadow-sm"><img src="/img/facility12.jpg" alt="" class="img-fluid card-img-top">
          <div class="p-4">
            <h5> <a href="/WebGL.jsp?place=Dining&kor=식당" class="text-dark">식당</a></h5>
            <p class="small text-muted mb-0">좌석 많고 넓은 식당</p>
            <div class="d-flex align-items-center justify-content-between rounded-pill bg-light px-3 py-2 mt-4">
              <p class="small mb-0"><i class="fa fa-picture-o mr-2"></i><span class="font-weight-bold" onclick="location.href='/WebGL.jsp?place=Dining&kor=식당'">둘러보기</span></p>
              <div class="badge badge-success px-3 rounded-pill font-weight-normal">Hot</div>
            </div>
          </div>
        </div>
      </div>
      <!-- End -->

    </div>
    <div class="py-5 text-right"><a href="#" class="btn btn-dark px-5 py-3 text-uppercase">위로 가기</a></div>
  </div>
</div>
  
  
  
  
  
  
    
    
    <!-- Courses End -->


    
        

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