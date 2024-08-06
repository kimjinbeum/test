

function validatePassword(pwd){

    var passwordRegex = /^(?=.*[a-zA-Z])(?=.*\d)[a-zA-Z\d]{8,}$/;
    var resultYn = "";

    // 유효성 검사 결과 확인
    if (passwordRegex.test(pwd)) {
        resultYn = "Y";
    } else {
        resultYn = "N";
    }

    return resultYn;
}

//인풋박스 Validation 체크
function inputValidationCheck(){
    var isRight = true;
    $(".join-container").find(".checkField").each(function(index, item){
        // 아무값없이 띄어쓰기만 있을 때도 빈 값으로 체크되도록 trim() 함수 호출
        if ($(this).val().trim() == '') {
            alert($(this).attr("data-name")+" 항목을 입력하세요.");
            isRight = false;
            return false;
        }
    });

    if (!isRight) {
        return;
    }

}


function setDate(event) {
    var input = event.target;
    var value = input.value.replace(/\D/g, '');

    // 숫자 입력이 아닌 경우 입력을 무시
    if (!/[0-9]/.test(event.key) || value.length >= 8) {
        event.preventDefault();
        return;
    }

    if (value.length === 5) {
        value += event.key;
        var formattedDate = value.slice(0, 4) + '-' + value.slice(4, 6);
        setTimeout(function() {
            input.value = formattedDate;
        }, 0);
        event.preventDefault();
    }


    if (value.length === 7) {
        value += event.key;
        var formattedDate = value.slice(0, 4) + '-' + value.slice(4, 6) + '-' + value.slice(6);
        setTimeout(function() {
            input.value = formattedDate;
        }, 0);
        event.preventDefault();
    }
}