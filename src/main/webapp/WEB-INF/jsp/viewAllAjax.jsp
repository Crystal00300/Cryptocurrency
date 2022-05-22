<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%-- <c:set var="contextRoot" value="${pageContext.request.contextPath}" /> --%>
<%-- <jsp:include page="${pageContext}NavBar/CoinShellNavBar.jsp" /> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%-- <c:set var="contextRoot" value="${pageContext.request.contextPath}" /> --%>
<title>討論區</title>
</head>
<body>
<div class="row justify-content-center">
<div class="col-9">
    <form id="searchByTag">
        <select id="tag-list"></select>        
        <input id="titlePart" type="text" placeholder="關鍵字查詢(標題/內文)"/>
        <input type="button" name="submit" value="查詢" id="search"/>
    </form>
    
	<table class="table table-hover table-primary">
		<thead class="thead-dark">
			<tr>
				<th scope="col" class="col-2">幣別</th>
				<th scope="col" class="col-6">文章</th>
				<th scope="col" class="col-2" style="text-align: center;">閱讀/回復</th>
				<th scope="col" class="col-2">建立時間</th>
			</tr>
		</thead>
		<tbody class="sel" id="atcTable">
		
		</tbody>
	</table>
</div>
</div>
</body>
<script type="text/javascript">
var contextRoot = "http://localhost:8080/myapp";
//下拉選單相關
var tag;
tagList();
loadAtc();
// loadPage();
$("#tag-list").change(function(){loadAtc();})
// $("#tag-list").change(function(){selectTag();loadAtc();})
$("#search").click(function(){loadAtcByTitle();})

// function selectTag(){	
//     var tag = document.getElementById("tag-list").value;
// 	console.log(tag);
// }

function tagList(index){
    var inner = "";
    var tags = ['All','BTC', 'ETH', 'USDT', 'USDC', 'BNB', 'XRP', 'ADA', 'BUSD', 'SOL', 'DOGE', 'DOT', 'AVAX', 'WBTC', 'TRX', 'SHIB', 'DAI', 'MATIC', 'CRO', 'LEO', 'LTC', 'NEAR', 'FTT', 'BCH', 'UNI', 'LINK', 'XLM', 'ATOM', 'ALGO', 'XMR', 'FLOW', 'ETC', 'APE', 'MANA', 'HBAR', 'EGLD', 'VET', 'ICP', 'FIL', 'SAND', 'XTZ', 'MKR', 'ZEC', 'KCS', 'THETA', 'CAKE', 'EOS', 'AXS', 'TUSD', 'GRT', 'AAVE', 'UST', 'KLAY', 'HT', 'RUNE', 'HNT', 'BTT', 'BSV', 'MIOTA', 'USDP', 'XEC', 'FTM', 'GMT', 'QNT', 'USDN', 'NEXO', 'STX', 'OKB', 'NEO', 'WAVES', 'CHZ', 'CVX', 'KSM', 'ZIL', 'ENJ', 'DASH', 'CELO', 'LRC', 'CRV', 'GALA', 'PAXG', 'BAT', 'AMP', 'GNO', 'ONE', 'XDC', 'AR', 'MINA', 'XEM', 'DCR', 'KDA', 'COMP', 'HOT', 'KAVA', 'LDO', 'GT', 'FEI', 'QTUM', 'BNT', '1INCH', 'XYM']
    for(var i=0;i<tags.length;i++){
            //inner第一行就會像是 <option value=0>商學院</option>
            inner=inner+`<option value=`+tags[i]+`>`+tags[i]+`</option>`;
        }
    $("#tag-list").html(inner)
}

function loadAtcByTitle(){
    $(function() {
        var titlePart = document.getElementById("titlePart").value;
        console.log(titlePart);
        $("#atcTable").empty();
        fetch("http://localhost:8080/myapp/article/viewAllAjaxByTitle?titlePart="+titlePart).then(function(response) {
            return response.json();
            // console.log(response.json())
        }).then(function(array) {
            $.each(array, function(index, value) {
                var added = new Date(Date.parse(value.added));
                var MM = added.getMonth();
                var dd = added.getDate();
                var HH = added.getHours();
                var mm = added.getMinutes();
                var weekIndex = added.getDay();
                var weekDay = ["星期天", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"];
                var weekDayPrint = weekDay[weekIndex];  
                var peek = value.text.substr(0,100);
                // console.log(peek);
                // console.log(array);
                $("#atcTable").append(`
                        <tr class="table-info">
                        <td>` + value.tag + `</td>
                        <td><a href="`+contextRoot+`/viewArticle/` + value.id + `" style="display: block;"><div class="b-list"><div><h3>` + value.title + `</h3></div></a><p>` + peek + `....</p></div></td>
                        <td align="center">` + value.readNum + ` / ` + value.commentNum + `</td>
                        <td>`+MM+`/`+dd+` `+HH+`:`+mm+` `+weekDayPrint+`</td>
                    	</tr>
                        `)
            })
        })

    })
}

function loadAtc() {
    $(function() {
        var tag = document.getElementById("tag-list").value;
        $("#atcTable").empty();
        fetch("http://localhost:8080/myapp/article/viewAllAjax?tag="+tag).then(function(response) {
            return response.json();
            console.log(response.json())
        }).then(function(array) {
            $.each(array, function(index, value) {
                var added = new Date(Date.parse(value.added));
                var MM = added.getMonth();
                var dd = added.getDate();
                var HH = added.getHours();
                var mm = added.getMinutes();
                var weekIndex = added.getDay();
                var weekDay = ["星期天", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"];
                var weekDayPrint = weekDay[weekIndex];  
                var peek = value.text.substr(0,100);
                console.log(peek);
                console.log(array);
                $("#atcTable").append(`
                        <tr class="table-info">
                        <td>` + value.tag + `</td>
                        <td><a href="`+contextRoot+`/viewArticle/` + value.id + `" style="display: block;"><div class="b-list"><div><h3>` + value.title + `</h3></div></a><p>` + peek + `....</p></div></td>
                        <td align="center">` + value.readNum + ` / ` + value.commentNum + `</td>
                        <td>`+MM+`/`+dd+` `+HH+`:`+mm+` `+weekDayPrint+`</td>
                    	</tr>
                        `)
            })
        })

    })
}

// function loadAtcByTag() {
//     $(function() {
//         $("#atcTable").empty();
//         fetch("http://localhost:8080/myapp/article/viewAllAjax?Tag="+tag).then(function(response) {
//             return response.json();
//             console.log(response.json())
//         }).then(function(array) {
//             $.each(array, function(index, value) {
//                 var added = new Date(Date.parse(value.added));
//                 var MM = added.getMonth();
//                 var dd = added.getDate();
//                 var HH = added.getHours();
//                 var mm = added.getMinutes();
//                 var weekIndex = added.getDay();
//                 var weekDay = ["星期天", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"];
//                 var weekDayPrint = weekDay[weekIndex];  
//                 console.log(array);
//                 $("#atcTable").append(`
//                         <tr class="table-info">
//                         <td>` + value.tag + `</td>
//                         <td><a href="`+contextRoot+`/viewArticle/` + value.id + `" style="display: block;"><div class="b-list"><div>` + value.title + `</div><p>` + value.peek + `</p></div></a></td>
//                         <td align="center">` + value.read_Num + ` / ` + value.comment_Num + `</td>
//                         <td>`+MM+`/`+dd+` `+HH+`:`+mm+` `+weekDayPrint+`</td>
//                     	</tr>
//                         `)
//             })
//         })

//     })
// }

// function loadPage(){
//     var s = "";
//     var name = $("#name").val;
//     var max = 1;
//     var min = 1;
//     fetch("zys.php").then(function(response){
//         return response.text().trim();
//     }).then(function(data){
//         min = data;
//     })
// }
//****fetch與ajax改寫

// <fmt:formatDate pattern="MM/dd EE HH:mm" value=""/>
// <fmt:parseDate pattern="MM/dd EE HH:mm" value=""/>
// <td>` + value.deleted + `</td>
// <td>` + value.id + `</td>
// <td>` + value.author_Id + `</td>
// <td>` + value.text + `</td>
// <td>` + value.peek + `</td>
// <td>` + value.read_Num + `</td>

//設定間隔時間
// window.setInterval(function() {
//     upCoin()
// }, 5000);


</script>
</html>