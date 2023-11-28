<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    
</head>

<body>
<div class="container-fluid bg-dark text-light footer pt-5 mt-5 wow fadeIn" data-wow-delay="0.1s">
        <div class="container py-5">
            <div class="row g-5">
                <div class="col-lg-3 col-md-6">
                    <h4 class="text-white mb-3">Quick Link</h4>
                    <a class="btn btn-link" href="/facility.jsp">부대시설</a>
                    <a class="btn btn-link" href="/ynotice/YnoticeList.do">공지사항</a>
                    <a class="btn btn-link" href="/yfreeboard/YfreeboardList.do">자유게시판</a>
                    <a class="btn btn-link" href="/yrepair/YrepairList.do">수리접수</a>
                    <a class="btn btn-link" href="/room/FloorList.do?radioValue=1">입사신청</a>
                </div>
                <div class="col-lg-3 col-md-6">
                    <h4 class="text-white mb-3">Contact</h4>
                    <p class="mb-2"><i class="fa fa-map-marker-alt me-3"></i>경상북도 칠곡군 지천면 금송로 60</p>
                    <p class="mb-2"><i class="fa fa-phone-alt me-3"></i>054-970-9190</p>
                    <p class="mb-2"><i class="fa fa-envelope me-3"></i>info@example.com</p>
                    <div class="d-flex pt-2">
                        <a class="btn btn-outline-light btn-social" href=""><i class="fab fa-twitter"></i></a>
                        <a class="btn btn-outline-light btn-social" href=""><i class="fab fa-facebook-f"></i></a>
                        <a class="btn btn-outline-light btn-social" href=""><i class="fab fa-youtube"></i></a>
                        <a class="btn btn-outline-light btn-social" href=""><i class="fab fa-linkedin-in"></i></a>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6">
                    <h4 class="text-white mb-3">Gallery</h4>
                    <div class="row g-2 pt-2" onclick="location.href='/facility.jsp'">
                        <div class="col-4">
                            <img class="img-fluid bg-light p-1" src="/img/footer1.jpg" alt="">
                        </div>
                        <div class="col-4">
                            <img class="img-fluid bg-light p-1" src="/img/footer2.jpg" alt="">
                        </div>
                        <div class="col-4">
                            <img class="img-fluid bg-light p-1" src="/img/footer3.jpg" alt="">
                        </div>
                        <div class="col-4">
                            <img class="img-fluid bg-light p-1" src="/img/footer4.jpg" alt="">
                        </div>
                        <div class="col-4">
                            <img class="img-fluid bg-light p-1" src="/img/footer5.jpg" alt="">
                        </div>
                        <div class="col-4">
                            <img class="img-fluid bg-light p-1" src="/img/footer6.jpg" alt="">
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6">
                    <h4 class="text-white mb-3">Sign up</h4>
                    <p>아직 회원이 아니신가요?</p>
                    <div class="position-relative mx-auto" style="max-width: 400px;">
                        <input class="form-control border-0 w-100 py-3 ps-4 pe-5" type="text" placeholder="지금 바로 가입하세요">
                        <button type="button" class="btn btn-primary py-2 position-absolute top-0 end-0 mt-2 me-2" onclick="location.href='/signup.jsp'">SignUp</button>
                    </div>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="copyright">
                <div class="row">
                    <div class="col-md-6 text-center text-md-start mb-3 mb-md-0">
                        &copy; <a class="border-bottom" href="">영진전문대 글로벌캠퍼스 기숙사</a>, All Right Reserved.

                        <!--/*** This template is free as long as you keep the footer author’s credit link/attribution link/backlink. If you'd like to use the template without the footer author’s credit link/attribution link/backlink, you can purchase the Credit Removal License from "https://htmlcodex.com/credit-removal". Thank you for your support. ***/-->
                        3GCA <a class="border-bottom" href="">OneDirection</a><br><br>
                        Yeungjin University <a class="border-bottom" href="">Dormitory</a>
                    </div>
                    <div class="col-md-6 text-center text-md-end">
                        <div class="footer-menu">
                            <a href="/main.do">Home</a>
                            <a href="/manager.jsp">Manager</a>
                            <a href="/contact.jsp">CONTACT</a>
                            <a href="/facility.jsp">GALLERY</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>

</html>