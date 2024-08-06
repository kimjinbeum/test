var historyCount = orderCount;

$(document).ready(function(){
    createPagination(historyCount,15, 1);
});

$(document).on("click", "#orderSearchBtn", function (){
    var pageNo= 1;
    getHistory(pageNo, "new");
});

function getPageData(pageNo){
    getHistory(pageNo, "");
}

function getHistory(pageNo, gb){
    var fromDt = $("#fromDt").val();
    var toDt = $("#toDt").val();

    $.ajax({
        url: '/historyList', // 서버의 URL
        type: 'POST',
        contentType: 'application/json', // JSON 형식으로 데이터 전송
        data: JSON.stringify({
            fromDt: fromDt,
            toDt : toDt,
            pageNo : pageNo
        }),
        success: function(data) {
            var historyList = data.orderList;
            var html = "";

            $(".orderList").empty();
            if(historyList.length > 0){
                for(var i=0; i < historyList.length; i++){
                    html += "<tr>";
                    html += "<td>" + historyList[i].orderDt  + "</td>";
                    html += "<td>" + historyList[i].productNm  + "</td>";
                    html += "<td>" + historyList[i].productAmt.toLocaleString()  + "</td>";
                    html += "<td>" + historyList[i].prizeNm  + "</td>";
                    html += "</tr>";
                }
            }else{
                html += "<tr>";
                html += "<td colspan='4'>" + "데이터가 없습니다."  + "</td>";
                html += "</tr>";
            }

            $(".orderList").append(html);

            if(gb == "new"){
                createPagination(data.orderCount, 15, 1);
            }
        }
    });
}