
let isSubmit = false;
let pwCon = false;
let idCon = false;
let pwChecked = false;

const pwCheckView = () =>{
    const pwCheckView = $("#pwCheckView");
 	let pw = $("#pw").val();
 	let num = pw.search(/[0-9]/g); //숫자
 	let eng = pw.search(/[a-z]/ig); //영문자(대소문자)
 	let spe = pw.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi) //특수문자
 	
    if(pw.length < 8 || pw.length > 20){
    //   alert("8자리 ~ 20자리 이내로 입력해주세요.");
        pwCheckView.text("8자리 ~ 20자리 이내로 입력해주세요.");
        pwCheckView.css("color", "red");
        pwCon = false;
        // return isSubmit; 
    }else if(pw.search(/\s/) != -1){
    //   alert("비밀번호는 공백 없이 입력해주세요.");
        pwCheckView.text("비밀번호는 공백 없이 입력해주세요.");
        pwCheckView.css("color", "red");
        pwCon = false;
        // return isSubmit; 
    }else if(num < 0 || eng < 0 || spe < 0 ){
    //   alert("영문,숫자, 특수문자를 혼합하여 입력해주세요.");
        pwCheckView.text("영문,숫자, 특수문자를 혼합하여 입력해주세요.");
        pwCheckView.css("color", "red");
        pwCon = false;
        // return isSubmit; 
    }else {
        pwCheckView.text("사용가능한 비밀번호입니다.");
        pwCheckView.css("color", "green");
        pwCon = true;
        // return isSubmit; 
    }	
}
const pwCheckedView = () =>{
    if($("#pw").val() === $("#pwCheck").val()){
		$("#pwCheckedView").text("비밀번호 일치");
		$("#pwCheckedView").css("color", "green");
        pwChecked = true;
        // return pwChecked; 		 
	}else{
        $("#pwCheckedView").text("비밀번호 불일치");
		$("#pwCheckedView").css("color", "red");
        pwChecked = false;
        // return pwChecked;
    }   
}

$("#checkIdBtn").click(() => {
    let id = document.querySelector("#id").value;
    const idRule = /^[a-zA-Z0-9]{3,}$/;
    if(!idRule.test(id)){ //id가 영어 대소문자 + 숫자 3글자이상이 아닐 때
        alert("아이디는 3자 이상 영어 대/소문자와 숫자만 사용가능합니다.");
        idCon = false;
    }else{
        idCheck();
    }
});

$("#id").keyup(function(){
    idCon = false;
    $("#checkedId").attr("value", "");
});

$("#pw").keyup(function(){
	pwCheckView();
    pwCheckedView();
});

$("#pwCheck").keyup(function(){
	pwCheckedView();
}); 

const updateUser = () => {
    if(!pwCon||!pwChecked){
        alert("비밀번호를 확인해주세요.");
        $("#pw").focus();
    }else	{
    	$("#userphone").val(document.updatefrm.phone1.value + document.updatefrm.phone2.value + document.updatefrm.phone3.value);
        document.updatefrm.submit();
    }
}
function delete_event(){
  if (confirm("정말 삭제하시겠습니까??") == true){
      deleteUser();
  }else{
      return;
  }
}
const deleteUser = () => {
	document.updatefrm.action = "/user/deleteUser.do";
	document.updatefrm.submit();
}