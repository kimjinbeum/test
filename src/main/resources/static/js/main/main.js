
$(document).on("click","#orderBtn", function (){

    var productList = [];

    $('input[name="productCheck"]:checked').each(function() {
        var dataSplit = $(this).val().split("|");
        console.log(dataSplit[2] - 1);
        if(dataSplit[2] - 1 == 0){
            alert("33333");
            alert("2222");
            alert("22223333");
            alert("품절 상품은 주문 할 수 없습니다...sdfdsfsdf.dfdf.sdfsdfsdf......");
            alert("품절 상품은 주문 할 수 없습니다.....sdfsdfsdfsdfsdfsdfsdfsdf......");
            alert("품절 상품은 주문 할 수 없습니다.....sdfsdfsdfsdfsdfsdfsdfsdf......");
            return;
        }else{
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

            if(data.prizeNm == ""){
                window.location.href = "/fr_main";
            }else{
                alert("경품으로 " + data.prizeNm + "이(가) 지급됩니다.");
                window.location.href = "/fr_main";
            }



        }
    });
});

$(document).on("click","#orderDtailBtn", function (){
    window.location.href = "/order_history";
});
