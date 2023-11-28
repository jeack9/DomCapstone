<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ page import="egovframework.room.service.RoomVO" %>
        <%@ page import="java.util.List" %>
            <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
                <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
                    <%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui" %>
                        <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

                            <!DOCTYPE html>
                            <html lang="en">


                            <head>
                                <meta charset="UTF-8">
                                <title></title>
                                <link rel="stylesheet" type="text/css" href="/css/hacademy-cinema.css">
                                <!-- Customized Bootstrap Stylesheet -->
                                <link href="/css/bootstrap.min.css" rel="stylesheet">

                                <!-- Template Stylesheet -->
                                <link href="/css/style.css" rel="stylesheet">
                                <style>
                                    * {
                                        box-sizing: border-box;
                                    }

                                    body {
                                        position: fixed;
                                        width: 100%;
                                        height: 100%;
                                        background-color: black;
                                    }

                                    .float-box {
                                        position: absolute;
                                        z-index: 3;
                                        top: 50%;
                                        left: 50%;
                                        transform: translate(-50%, -50%);
                                        width: 90%;
                                        text-align: center;
                                        border: 3px solid pink;
                                    }

                                    .float-box>div:not #img {
                                        /* float: left; */
                                        display: inline-block;
                                        width: 90%;

                                    }

                                    .float-box::after {
                                        content: "";
                                        display: block;
                                        clear: both;
                                    }

                                    .float-box>.result {
                                        padding: 0.5rem;
                                    }

                                    #img {
                                        position: absolute;
                                        z-index: 1;
                                        width: 30%;
                                        top: 50%;
                                        left: 80%;
                                        overflow: hidden;
                                    }

                                    .cinema-seat span {

                                        position: absolute;
                                        top: 60%;
                                        left: 50%;
                                        transform: translate(-50%, -50%);
                                        font-size: 27px;
                                        font-weight: 700;


                                    }

                                    .cinema-seat span:first-of-type {
                                        position: absolute;
                                        top: 40%;
                                        left: 50%;
                                        transform: translate(-50%, -50%);
                                    }

                                    .result_wrap {
                                        position: absolute;
                                        z-index: 3;
                                        width: 300px;
                                        height: 100px;
                                        top: 110%;
                                        left: 50%;
                                        transform: translate(-50%, 0);
                                    }

                                    #result {
                                        width: 100px;
                                        font-size: 25px;
                                        text-align: center;
                                        font-weight: 700;
                                        color: white;

                                    }
                                </style>

                                <script src="/js/hacademy-cinema.js"></script>
                            </head>

                            <body>
                                <nav class="navbar navbar-expand-lg bg-white navbar-light shadow sticky-top p-0">
                                    <a href="index.html" class="navbar-brand d-flex align-items-center px-4 px-lg-5">
                                        <h2 class="m-0 text-primary"><i class="fa fa-book me-3"></i>eLEARNING</h2>
                                    </a>
                                    <button type="button" class="navbar-toggler me-4" data-bs-toggle="collapse"
                                        data-bs-target="#navbarCollapse">
                                        <span class="navbar-toggler-icon"></span>
                                    </button>
                                    <div class="collapse navbar-collapse" id="navbarCollapse">
                                        <div class="navbar-nav ms-auto p-4 p-lg-0">
                                            <a href="index.html" class="nav-item nav-link">Home</a>
                                            <a href="about.html" class="nav-item nav-link">About</a>
                                            <a href="courses.html" class="nav-item nav-link active">Courses</a>
                                            <div class="nav-item dropdown">
                                                <a href="#" class="nav-link dropdown-toggle"
                                                    data-bs-toggle="dropdown">Pages</a>
                                                <div class="dropdown-menu fade-down m-0">
                                                    <a href="team.html" class="dropdown-item">Our
                                                        Team</a>
                                                    <a href="testimonial.html" class="dropdown-item">Testimonial</a>
                                                    <a href="404.html" class="dropdown-item">404
                                                        Page</a>
                                                </div>
                                            </div>
                                            <a href="contact.html" class="nav-item nav-link">Contact</a>
                                        </div>
                                        <a href="" class="btn btn-primary py-4 px-lg-5 d-none d-lg-block">Join
                                            Now<i class="fa fa-arrow-right ms-3"></i></a>
                                    </div>
                                </nav>
                                <div></div>

                                <div class="float-box">
                                    <div>
                                        <form id="roomForm" name="roomForm" method="get" action="/room/updateRoom.do"
                                            accept-charset="utf-8">
                                            <input type="hidden" name="selectedValue" id="selectedValue"
                                                value="${selectedValue}" />
                                            <div id="cinema" class="cinema-wrap" data-name="">
                                                <!-- manager 관리자, client 고객, rowsize 열, colsize 행, fill : manual 수동, auto 자동 -->
                                                <div class="cinema-seat-area" data-rowsize="3" data-colsize="17"
                                                    data-mode="client" data-fill="client" data-seatno="visible"
                                                    data-choice="single">
                                                    <c:forEach var="room" items="${resultList}" varStatus="status">
                                                        <div class="cinema-seat" data-state="${room.state}"
                                                            data-row="${room.row}" data-col="${room.col}"
                                                            data-num="${room.num}" data-people="${room.people}"
                                                            data-hosu="${room.name}"></div>
                                                    </c:forEach>
                                                </div>
                                            </div>
                                        </form>
                                        <form name="roomForm" method="post" action="/room/updateRoom.do">
                                            <div class="result_wrap">
                                                <span id="result" class="result" name="result" value="" hint="방번호">
                                                </span>
                                                <input type="hidden" name="value" id="input" value="">
                                                <br>

                                                <button type="submit">예약하기</button>
                                            </div>
                                        </form>

                                    </div>

                                </div>
                                <div id="img"><img src="/images/tiger.png" /></div>
                                <script>
                                    var activeSeat;
                                    var names;
                                    window.addEventListener("load", function () {

                                        var cinema = new Hacademy.Reservation("#cinema");
                                        cinema.addChangeListener(function (seat) {
                                            print(this);
                                        });
                                        print(cinema);
                                        function print(app) {
                                            activeSeat = app.getQueryString();
                                            names = activeSeat?.split('=', 1);
                                            document.querySelector(".result").textContent = names;

                                            $('#input').val(names);
                                            //var name = app.getQueryString();

                                            //document.querySelector(".result").textContent = name.replace('=','s');
                                            //$('#roomForm[name="'+name+'"]').val();
                                        }


                                    });


                                </script>
                                <style>
                                    .result_wrap {
                                        position: absolute;
                                        left: 50%
                                    }
                                </style>
                                <script src="https://code.jquery.com/jquery-3.6.0.slim.js"
                                    integrity="sha256-HwWONEZrpuoh951cQD1ov2HUK5zA5DwJ1DNUXaM6FsY="
                                    crossorigin="anonymous"></script>
                            </body>

                            </html>