
$(document).on("click","#orderBtn", function (){

    var productList = [];

    $('input[name="productCheck"]:checked').each(function() {
        var dataSplit = $(this).val().split("|");
        console.log(dataSplit[2] - 1);
        if(dataSplit[2] - 1 == 0){
            console.log("test");
            return;
        }else{
            console.log("test");
            var productDto = {
                productCd: dataSplit[0],
                productAmt: dataSplit[1],
                productQty: dataSplit[2]
            };
            productList.push(productDto);
        }
    });

    $.ajax({
        url: '/insOrder',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify({ productList: productList }),
        success: function(data) {
            console.log("test");
            if(data.prizeNm == ""){
                console.log("test");
                window.location.href = "/fr_main";
                console.log("test");
            }else{
                alert("1123123");
                console.log("test");
                alert("경품으로 " + data.prizeNm + "이(가) 지급됩니다.");
                window.location.href = "/fr_main";
            }



        }
    });
});

$(document).on("click","#orderDtailBtn", function (){
    window.location.href = "/order_history";
});
