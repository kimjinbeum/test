
//줃복체크
$(document).on("click",".checkBtn", function (){

    var userId = $("#userId").val();

    $.ajax({
        url: '/user/userCheck', // 서버의 URL
        type: 'POST',
        contentType: 'application/json', // JSON 형식으로 데이터 전송
        data: JSON.stringify({
            userId: userId
        }),
        success: function(data) {
            if(data.userCnt > 0){
                alert("등록되어 있는 아이디 입니다. 다른 아이디를 사용해주세요.");
            }else{
                alert("사용가능한 아이디 입니다.");
            }
        }
    });
});

$(document).on("click", "#userJoinBtn", function (){

    //비밀번호 유효성 체크
    var validateCheck = validatePassword($("#userPwd").val());
    if(validateCheck == "N"){
      alert("비밀번호는 8글자 이상, 영문과 숫자 혼용하여 주세요.");
      return;
    }

    if($("#selEmail").val() == ""){
        if($("#userEmailAddr").val() == ""){
            alert("이메일 주소를 입력해 주세요.");
            return;
        }
    }

    //필드 Validation 체크 진행
    inputValidationCheck();

    //이메일 셋팅
    var emailAddr = "";
    if($("#selEmail").val() == ""){
        emailAddr = $("#userEmailAddr").val();
    }else{
        emailAddr = $("#selEmail").val();
    }

    $.ajax({
        url: '/user/userJoin', // 서버의 URL
        type: 'POST',
        contentType: 'application/json', // JSON 형식으로 데이터 전송
        data: JSON.stringify({
            userId: $("#userId").val(),
            userNm: $("#userNm").val(),
            userPwd: $("#userPwd").val(),
            userGender: $('input[name=gender]:checked').val(),
            userEmail: $("#userEmail").val() + "@" + emailAddr,
            userBirth : $("#userBirth").val(),
            userPhone: $("#selPhone").val() + $("#phone1").val() + $("#phone2").val(),
            adReceiveYn: $('input[name=agree]:checked').val()
        }),
        success: function(data) {
            window.location.href = "/login";
        }
    });
});

$(document).on("change", "#selEmail", function (){

    if($("#selEmail").val() == ""){
        $("#userEmailAddr").attr("disabled", false);
    }else{
        $("#userEmailAddr").attr("disabled", true);
    }
});

$(document).on("click", "#backLogin", function (){
    window.location.href = "/login";
});