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
                        <td>$` + value.price.toFixed(2).toString().replace(/(\d)(?=(\d{3})+\.)/g, "$1,") + `</td>
                        <td>` + value.percentChange1h.toFixed(2) + `%</td>
                        <td>` + value.percentChange24h.toFixed(2) + `%</td>
                        <td>` + value.percentChange7d.toFixed(2) + `%</td>
                        <td>` + value.percentChange30d.toFixed(2) + `%</td>
                        <td>$` + value.volume24h.toFixed(2).toString().replace(/(\d)(?=(\d{3})+\.)/g, "$1,") + `</td>
                        <td>$` + value.marketCap.toFixed(2).toString().replace(/(\d)(?=(\d{3})+\.)/g, "$1,") + `</td>
                        <td>
                        <div class="chart-container">
                        <canvas id="canvas` + value.id + `" width="100%" height="100%"></canvas>
                        </div>
                        </tr>`);
                var xmlHttp = new XMLHttpRequest();
                var currencyName = value.symbol;
                var url = "http://localhost:8080/coinshell/historical/get30days?currencyName=" + value.symbol;
                xmlHttp.open("GET", url, true);
                xmlHttp.send();
                xmlHttp.onreadystatechange = function() {
                    if (this.readyState == 4 && this.status == 200) {
                        var data = JSON.parse(this.responseText);
                        var days = data.map(function(elem) {
                            return elem.informationDate
                                .substr(0, 14).replace('T', '').replace('-', '').replace('-', '').replace(':', '')
                        });
                        var price = data.map(function(elem) {
                            return elem.USD_Price_of_Cryptocurrency;
                        })
                        const ctx = document.getElementById('canvas' + value.id).getContext('2d');
                        // alert(123)
                        const myChart = new Chart(ctx, {
                            type: 'line',
                            data: {
                                labels: days,
                                pointHitRadius: 0,
                                datasets: [{
                                    label: 'US',
                                    data: price,
                                    backgroundColor: [
                                        'transparent'
                                    ],
                                    borderColor: 'green',
                                    borderWidth: 1,
                                    lineTension: 0,
                                    pointRadius: 0,

                                }]
                            },
                            options: {
                                plugins: {
                                    tooltip: {
                                        mode: 'nearest',
                                        intersect: false
                                    }
                                },
                                element: {
                                    line: {
                                        lineTension: 0
                                    }
                                },
                                scales: {
                                    xAxes: [{
                                        type: 'time',
                                        time: {
                                            unit: 'hour',
                                        }

                                    }],
                                    yAxes: {
                                        beginAtZero: false
                                    }
                                }
                            }
                        });
                    }
                };
            })
        })
    })
}
//設定間隔時間
window.setInterval(function() {
    upCoin()
}, 10000);

$(".responsive").slick({
    dots: true,
    infinite: false,
    speed: 300,
    slidesToShow: 4,
    slidesToScroll: 4,
    responsive: [{
            breakpoint: 1024,
            settings: {
                slidesToShow: 3,
                slidesToScroll: 3,
                infinite: true,
                dots: true
            }
        },
        {
            breakpoint: 600,
            settings: {
                slidesToShow: 2,
                slidesToScroll: 2
            }
        },
        {
            breakpoint: 480,
            settings: {
                slidesToShow: 1,
                slidesToScroll: 1
            }
        }
    ]
});






//function全部封裝起來 讓setinterval再跑時候讀取	

function upjquery() {

    //.toLocaleString =>千分位 
    //(undefined, {maximumFractionDigits: 0}) =>去小數點 設1則顯示小數點後1位
    //如果用 (td.toFixed(0)).toLocaleString(); 會失敗 只會顯示無小數點 但不會千分位

    $('.vol24h,.market').each(function(i, el) {
        var td = parseFloat($(el).text());
        if (!isNaN(td)) {
            $(el).text('$' + td.toLocaleString(undefined, { maximumFractionDigits: 0 }));
        }
    });


    //取小數後2位+百分比


    $('.1h,.24h,.7d,.30d').each(function(i, el) {
        var td = parseFloat($(el).text());
        if (!isNaN(td)) {
            $(el).text(td.toFixed(2) + '%');
        }
    });

    //取小數後兩位 + 前面加上錢字號

    $('.price,.price1').each(function(i, el) {
        var td = parseFloat($(el).text());
        if (!isNaN(td)) {
            $(el).text('$' + td.toFixed(2));
        }
    });


    //判斷大於0顯綠 反之顯紅


    $(function() {
        $('.1h,.24h,.7d,.30d').each(function() {
            var elem = $(this),
                value = parseFloat(elem.text());
            if (value < 0) {
                elem.css('color', 'red');
            }
            if (value > 0) {
                elem.css('color', 'green');
            }
        });
    });

}





//$(function() {
//  $('.price').each( function() {
//    var elem = $(this) ,
//        value = parseFloat( elem.text() );
//    if( value < $('.price1').text() ) {
//      elem.css('color', 'red');
//    }
//    if( value > $('.price1').text() ) {
//      elem.css('color', 'green');
//    }
//  });
//});




//只顯示幾位數

//$('.vol24h,.market').each(function(i,el){
//   var td = parseFloat($(el).text());
//   if(!isNaN(td)){
//      $(el).text('$'+td.toPrecision(11));
//   }
//});