let isSubmit = false;
let pwCon = false;
let idCon = false;
let pwChecked = false;
const idCheck = () => {
  const id = $("#id").val().trim();
  if (id == "") {
    alert("아이디를 입력하세요..");
    $("#id").val();
    return;
  }

  $.ajax({
    url: "/yuser/checkId.do", //Controller에서 요청 받을 주소
    type: "post", //POST 방식으로 전달
    data: { userid: id },
    dataType: "json",
    success: function (vo) {
      //컨트롤러에서 넘어온 cnt값을 받는다
      console.log(vo);
      if (!vo.isthere) {
        alert("사용가능한 아이디입니다.");
        $("#id").attr("readonly", true);
        //$("#checkedId").attr("value", $("#id").val());
        //$("#pw").focus();
        idCon = true;
        // return idCon;
      } else {
        alert("중복된 아이디입니다.");
        $("#checkedId").attr("value", "");
        $("#id").focus();
        idCon = false;
        // return idCon;
      }
    },
    error: function (s) {
      alert("에러입니다");
      console.log(s);
    },
  });
};

const pwCheckView = () => {
  const pwCheckView = $("#pwCheckView");
  let pw = $("#pw").val();
  let num = pw.search(/[0-9]/g); //숫자
  let eng = pw.search(/[a-z]/gi); //영문자(대소문자)
  let spe = pw.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi); //특수문자

  if (pw.length < 8 || pw.length > 20) {
    //   alert("8자리 ~ 20자리 이내로 입력해주세요.");
    pwCheckView.text("8자리 ~ 20자리 이내로 입력해주세요.");
    pwCheckView.css("color", "red");
    pwCon = false;
    // return isSubmit;
  } else if (pw.search(/\s/) != -1) {
    //   alert("비밀번호는 공백 없이 입력해주세요.");
    pwCheckView.text("비밀번호는 공백 없이 입력해주세요.");
    pwCheckView.css("color", "red");
    pwCon = false;
    // return isSubmit;
  } else if (num < 0 || eng < 0 || spe < 0) {
    //   alert("영문,숫자, 특수문자를 혼합하여 입력해주세요.");
    pwCheckView.text("영문,숫자, 특수문자를 혼합하여 입력해주세요.");
    pwCheckView.css("color", "red");
    pwCon = false;
    // return isSubmit;
  } else {
    pwCheckView.text("사용가능한 비밀번호입니다.");
    pwCheckView.css("color", "green");
    pwCon = true;
    // return isSubmit;
  }
};
const pwCheckedView = () => {
  if ($("#pw").val() === $("#pwCheck").val()) {
    $("#pwCheckedView").text("비밀번호 일치");
    $("#pwCheckedView").css("color", "green");
    pwChecked = true;
    // return pwChecked;
  } else {
    $("#pwCheckedView").text("비밀번호 불일치");
    $("#pwCheckedView").css("color", "red");
    pwChecked = false;
    // return pwChecked;
  }
};

$("#checkIdBtn").click(() => {
  let id = document.querySelector("#id").value;
  const idRule = /^[a-zA-Z0-9]{3,}$/;
  if (!idRule.test(id)) {
    //id가 영어 대소문자 + 숫자 3글자이상이 아닐 때
    alert("아이디는 3자 이상 영어 대/소문자와 숫자만 사용가능합니다.");
    idCon = false;
  } else {
    idCheck();
  }
});

$(".keyupevent").keyup(function () {
  const value = $(this).val();
  if (value[value.length - 1] == " ") {
    alert("공백은 입력 불가능 합니다.");
    $(this).val("");
    return;
  }
});

$("#pw").keyup(function () {
  pwCheckView();
  pwCheckedView();
});

$("#pwCheck").keyup(function () {
  pwCheckedView();
});

const joinUser = () => {
  console.log("pwCon: " + pwCon);
  console.log("pwChecked: " + pwChecked);
  console.log("idCon: " + idCon);
  console.log("checkedId: " + $("#checkedId").val());
  if (!idCon || $("#checkedId").val() == "") {
    alert("아이디를 확인해주세요.");
    $("#id").focus();
  } else if (!pwCon || !pwChecked) {
    alert("비밀번호를 확인해주세요.");
    $("#pw").focus();
  } else {
  	document.signupfrm.userphone.value = document.signupfrm.phone1.value + document.signupfrm.phone2.value + document.signupfrm.phone3.value;
    document.signupfrm.submit();
  }
  // if((pwCon&&pwChecked&&idCon&$("#checkedId").val()!="")){
  //     location.href = "/user/joinUser.do";
  // }else{
  // }
};

