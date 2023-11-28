<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="shortcut icon" href="/TemplateData/favicon.ico" />
  <link rel="stylesheet" href="/TemplateData/style.css" />
  <script src="/TemplateData/UnityProgress.js"></script>
  <script src="/Build/UnityLoader.js"></script>
      <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css"
    />

    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"
    />
  
  <style>
    .moveBtn {
      display: flex;
      border-radius: 50%;
      background-color: rgba(204, 204, 204, 0.548);
      width: 150px;
      height: 150px;
      flex-direction: column;
      justify-content: center;
      align-items: center;
      transition: all 0.8s;
      opacity: 0;
    }

    .moveBtn h1 {
      font-size: 25px;
      color: black;
      transition: all 0.8s;
    }
    .moveBtn i {
      height: 50px;
      font-size: 50px;
      color: black;
      transition: all 0.8s;
    }

    .bi::before,
    [class^="bi-"]::before,
    [class*=" bi-"]::before {
      vertical-align: 0;
    }

    .moveBtn:hover {
      background-color: rgb(90, 90, 90, 0.548);
    }

    .moveBtn:hover * {
      color: white;
      fill : white;
    }
    
    #washingimg{
    transition: all 0.8s;
    }
    
    .moveBtn:hover #washingimg {
       filter: invert(100%) sepia(0%) saturate(0%) hue-rotate(193deg) brightness(109%) contrast(101%);
    }
    
    

    .btnParent {
      width: 700px;
      display: flex;
      gap: 30px;
      justify-content: center;
      flex-wrap: wrap;
      position: absolute;
      z-index: 99;
      bottom: 150px;
      left: calc(50% - 350px);
    }

    .webgl {
      position: relative;
      height: calc(100% - 70px);
    }

    .startdiv {
      text-align: center;
      flex-direction: column;
      top: 130px;
      gap: 20px;
      position: absolute;
      z-index: 99;
      width: 800px;
      left: calc(50% - 400px);
      opacity: 0;
    }

     #webgl-content {
      z-index: -99;
    } 

    .inform-div {
      width: 400px;
      height: 100%;
      background: rgb(0, 0, 0);
      background: linear-gradient(
        90deg,
        rgba(0, 0, 0, 0) 0%,
        rgba(0, 0, 0, 0.9192051820728291) 100%
      );
      padding: 100px 40px 40px 40px;
      position: absolute;
      right: 0;
      top: 0;
      z-index: 99;
      opacity: 0;
    }

    .homebtndiv {
      margin-top: 400px;
      
    }

    .inform-div > * {
      color: white;
    }

    .inform-div > p {
      margin-top: 50px;
    }

    #unityContainer {
      height: calc(100vh - 75px);
    }
  </style>
<body>

</body>
    <%@ include file="/navbar.jsp" %>    
    <div class="container" >
      <div class="startdiv animate__animated animate__faster" style="z-index : 99">
        <h1 style="color: white">영진전문대 모델링 둘러보기</h1>
        <p style="color: white">
        	모델링을 통해 좀 더 실감나게 둘러 볼 수 있습니다. </br>
         	사용자의 컴퓨터 사양에 따라 프레임이 떨어지거나 느려질 수 있습니다.
        </p>
        <button type="button" class="btn btn-primary" onclick="startUnity()">
          시작하기
        </button>
      </div>

      <div
        class="webgl-content"
        style="position: absolute; left: 0; width: 100%; z-index:-99;"
      >
        <div id="unityContainer" style="width: 100vw; z-index:-99"></div>
      </div>
      <div class="inform-div animate__animated animate__faster">
        <h1 id="placeName">생활관</h1>
        <p id="explainPlace">
          Lorem ipsum dolor, sit amet consectetur adipisicing elit. Amet impedit
          aliquid in. Voluptate quod ut aliquid molestias repellendus
          necessitatibus fugiat?
        </p>
        <div class="homebtndiv">
        <button class="btn btn-primary" style="margin-bottom : 15px" onclick="goHome()">
          홈으로
        </button>
        <button id="reservationbtn" class="btn btn-primary" onclick="location.href = '/room/FloorList.do?radioValue=1'">
          방 예약하기
        </button>
        </div>
        
      </div>

      <div class="btnParent">
        <div
          class="moveBtn animate__animated animate__faster"
          onclick="goplace('Dom', '생활관')"
        >
          <h1>생활관</h1>
          <i class="fa fa-bed"></i>
        </div>
        <div
          class="moveBtn animate__animated animate__faster"
          onclick="goplace('Dining', '식당')"
        >
          <h1>식당</h1>
          <i class="fa fa-utensils"></i>
        </div>
        <div
          class="moveBtn animate__animated animate__faster"
          onclick="goplace('Break', '휴게실')"
        >
          <h1>휴게실</h1>
          <i class="fa fa-mug-hot"></i>
        </div>
        <div
          class="moveBtn animate__animated animate__faster"
          onclick="goplace('Laundry', '세탁실')"
        >
          <h1>세탁실</h1>
          <img src="/images/washing.svg" width="50px" id="washingimg"/>
        </div>
        <div class="moveBtn animate__animated animate__faster" onclick="goplace('Gym', '체육실')">
          <h1>체육실</h1>
          <i class="fa fa-dumbbell"></i>
        </div>
        <div class="moveBtn animate__animated animate__faster" onclick="goplace('Study', '독서실')">
          <h1>독서실</h1>
          <i class="bi bi-book-fill"></i>
        </div>
        <div class="moveBtn animate__animated animate__faster" onclick="goplace('Garden', '정원')">
          <h1>정원</h1>
          <i class="fa fa-cloud-sun"></i>
        </div>
      </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.6.0.slim.js"
                                    integrity="sha256-HwWONEZrpuoh951cQD1ov2HUK5zA5DwJ1DNUXaM6FsY="
                                    crossorigin="anonymous"></script>
    <script>
 var unityInstance = UnityLoader.instantiate(
      "unityContainer",
      "/Build/WebGl2.json",
      { onProgress: UnityProgress } 
    ); 
 
 var explains = [];
 explains['정원'] = '건물 내부에 위치한 아름다운 정원은 푸른 잔디와 다채로운 꽃들이 피어나는 자연의 경이로움을 제공합니다. 이곳에서는 산책을 즐기거나 휴식을 취하며 마음을 담담하게 정리할 수 있습니다.';
 explains['독서실'] = '조용하고 고요한 분위기 속에 자리한 독서실은 지식과 학습을 위한 완벽한 장소입니다. 다양한 학술 자료와 참고서가 구비되어 있으며, 개별 스터디 코너는 집중과 효율성을 높여줍니다.';
 explains['생활관'] = '현대적이고 편안한 생활관은 건물 내부에 위치하고 있으며, 학생 및 직원들에게 안락하고 안정적인 주거 환경을 제공합니다. 개인 객실과 공용 공간의 조화로운 조합은 사회적 상호작용과 개인적인 휴식의 기회를 제공합니다.';
 explains['식당'] = '건강하고 다양한 식사 옵션을 제공하는 식당은 건물 내부에서 편리하게 이용할 수 있습니다. 신선한 재료로 준비된 다양한 메뉴는 영양 가득한 식사를 즐길 수 있도록 도와줍니다. 또한, 편안하고 청결한 환경에서 맛있는 음식을 즐길 수 있으며, 친절한 직원들이 항상 고객의 만족을 위해 노력합니다.';
 explains['체육실'] = ' 건물 내에는 체력 단련과 건강 관리를 위한 헬스장이 갖춰져 있습니다. 최신 기구와 운동 시설을 활용하여 건강을 유지하고 몸을 단련할 수 있습니다.';
 explains['세탁실'] = '편리한 세탁실은 주민들의 생활 편의를 위해 설계되었으며, 깨끗하고 신속한 세탁 서비스를 제공합니다. 10여대의 세탁기와 건조기가 있기 때문에 시간 문제 없이 사용 가능 합니다.';
 explains['휴게실'] = '휴식과 소통을 위한 공간으로 활용되며, 편안한 의자와 커피 시설이 마련되어 있습니다. 이곳에서는 일상의 스트레스를 잠시 잊고 쉬어가는 시간을 가질 수 있습니다.';
 
  </script>
    <script>
      s = document.getElementsByClassName("moveBtn");

      var startUnity = () => {
        hideTitle();
        unityInstance.SendMessage("Cams", "LobbyCamChange", "Lobby");
      };

      var goplace = (place, title) => {
        hideBtns();
        unityInstance.SendMessage("Cams", "TestButton", place);
        setPlaceFont(title);
      };
      
      var goStraight = (place, title) => {
    	  unityInstance.SendMessage("Cams", "TestButton", place);
          setPlaceFont(title);
      }

      var goHome = () => {
        hideIntro();
        unityInstance.SendMessage("Cams", "LobbyCamChange", "Lobby");
      };

      var showBtns = () => {
        btnIndex = 0;
        var func = setInterval(() => {
          console.log(btnIndex);
          if (btnIndex < s.length) {
            var e = s[btnIndex];
            e.classList.remove("animate__fadeOutDown");
            e.classList.add("animate__fadeInUp");
            e.style.cursor = "pointer";
            btnIndex += 1;
          } else {
            clearInterval(func);
          }
        }, 50);
      };

      var hideBtns = () => {
        btnIndex = 0;
        var func = setInterval(() => {
          if (btnIndex < s.length) {
            var e = s[btnIndex];
            e.classList.remove("animate__fadeInUp");
            e.classList.add("animate__fadeOutDown");
            e.style.cursor = "default";
            btnIndex += 1;
          } else {
            clearInterval(func);
          }
        }, 50);
      };

      var showTitle = () => {
        var title = document.getElementsByClassName("startdiv")[0];
        title.classList.remove("animate__fadeOutUp");
        title.classList.add("animate__fadeInDown");
      };

      var hideTitle = () => {
        var title = document.getElementsByClassName("startdiv")[0];
        title.classList.remove("animate__fadeInDown");
        title.classList.add("animate__fadeOutUp");
      };

      var showIntro = () => {
        var title = document.getElementsByClassName("inform-div")[0];
        title.classList.remove("animate__fadeOut");
        title.classList.add("animate__fadeIn");
      };

      var hideIntro = () => {
        var title = document.getElementsByClassName("inform-div")[0];
        title.classList.remove("animate__fadeIn");
        title.classList.add("animate__fadeOut");
      };

      var setPlaceFont = (text) => {
        var title = document.getElementById("placeName");
        var content = document.getElementById("explainPlace");
        var btn = document.getElementById("reservationbtn");
        title.innerText = text;
        content.innerText = explains[text];
        
        if(text == '생활관'){
        	$('#reservationbtn').css('display', 'block');
        }else{
        	$('#reservationbtn').css('display', 'none');
        }
      };
    </script>
</html>