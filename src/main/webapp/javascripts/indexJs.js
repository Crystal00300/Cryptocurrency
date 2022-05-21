$(function() {
    $("#tabs").tabs();
});
//jquery控制分業的功能

$(function() {
        upCoin();
    })
    // $(function(){
    //     某個方法();
    // })
    // 讓程式一開始就執行某個方法
    //這邊設定成這樣，讓整個Dom載入完成後執行upCoin();


var contextRoot = "http://localhost:8080/coinshell"

var day = new Date();
let month = day.getMonth() + 1
month = (month < 10 ? '0' : '') + month
var today = day.getFullYear() + "-" + month + "-" + day.getDate();
//這邊定義今天的日期，格式為yyyy-MM-dd (2022-05-20)

function upCoin() {
    $(function() {
        $(".cointable").empty();
        fetch("http://localhost:8080/coinshell/coin/getAll").then(function(response) {
            return response.json();
            console.log(response.json())
        }).then(function(array) {
            $.each(array, function(index, value) {
                $(".cointable").append(`
                        <tr>
                        <th scope="row">` + value.id + `</th>
                        <td>` + `<img class=currencyIcon src="` + contextRoot + `/images/currencyIcon/` + value.symbol + `.png" alt="">` + `<a href="http://localhost:8080/coinshell/individualCryptocurrencyInformation?currencyName=` + value.symbol + `&currentlyDay=` + today + `">` + value.name + `</a></td>
                        <td>` + value.symbol + `</td>
                        <td>$` + value.price.toFixed(2) + `</td>
                        <td>` + value.percentChange1h.toFixed(2) + `%</td>
                        <td>` + value.percentChange24h.toFixed(2) + `%</td>
                        <td>` + value.percentChange7d.toFixed(2) + `%</td>
                        <td>` + value.percentChange30d.toFixed(2) + `%</td>
                        <td>$` + value.volume24h.toFixed(2) + `</td>
                        <td>$` + value.marketCap.toFixed(2) + `</td>
                    </tr>
                        `)
            })
        })
    })
}
//設定間隔時間
window.setInterval(function() {
    upCoin()
}, 10000);