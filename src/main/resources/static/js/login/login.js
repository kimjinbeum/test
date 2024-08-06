
$(document).on("click",".loginBtn", function (){
    $.ajax({
        url: '/user/userLogin',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify({
            userId: $("#userId").val(),
            userPwd: $("#userPwd").val(),
        }),
        success: function(data) {
            if(data.result == "error"){
                alert("아이디 비번이 틀렸습니다.");
            }else{
                window.location.href = "/fr_main";
            }
        }
    });
});
