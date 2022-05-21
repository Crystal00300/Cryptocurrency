$(function() {
    $("#tabs").tabs();
});

var getUrlString = location.href;
var url = new URL(getUrlString);
var currencyName = url.searchParams.get('currencyName');
var day = url.searchParams.get('currentlyDay');

window.setInterval(function() {
    upCoin()
}, 10000);
$(function() {
    upCoin();
})


function upCoin() {
    $(function() {
        $("#rank").empty();
        $("#currentlyPrice").empty();
        $("#highLowRatio").empty();
        $("#marketCapByTotalSupply").empty();
        $("#maxSupply2").empty();
        $("#Fully-DilutedMarket-Cap_price").empty();
        $("#volume24h").empty();
        $("#circulatingSupply").empty()
        $("#totalSupply").empty()
        fetch("http://localhost:8080/coinshell/coin/getlastest?currencyName=" + currencyName).then(function(response) {
            return response.json();
        }).then(function(jsonObject) {
            $("#rank").append(`Rank#` + jsonObject.id);
            $("#currentlyPrice").append(`當前價位:$` + jsonObject.price.toFixed(2).toString().replace(/(\d)(?=(\d{3})+\.)/g, "$1,"));
            $("#highLowRatio").append(`24h漲跌幅:` + jsonObject.percentChange24h.toFixed(2) + `%`);
            $("#marketCapByTotalSupply").append(`$` + jsonObject.marketCapByTotalSupply.toFixed(0).toString().replace(/(\d)(?=(?:\d{3})+$)/g, "$1,"));
            $("#Fully-DilutedMarket-Cap_price").append(`$` + jsonObject.fullyDilluttedMarketCap.toFixed(2).toString().replace(/(\d)(?=(\d{3})+\.)/g, "$1,"));
            $("#volume24h").append(`$` + jsonObject.volume24h.toFixed(2).toString().replace(/(\d)(?=(\d{3})+\.)/g, "$1,"));
            $("#circulatingSupply").append(`$` + jsonObject.circulatingSupply.toFixed(2).toString().replace(/(\d)(?=(\d{3})+\.)/g, "$1,"));
            $("#maxSupply2").append(jsonObject.maxSupply.toFixed(0).toString().replace(/(\d)(?=(?:\d{3})+$)/g, "$1,"));
            $("#totalSupply").append(jsonObject.totalSupply.toFixed(0).toString().replace(/(\d)(?=(?:\d{3})+$)/g, "$1,"));

        })


    })
}

$("#page-news").click(function() {
    $("#news").empty();
    fetch("http://localhost:8080/coinshell/news/get?currencyName=" + currencyName).then(function(response) {
        return response.json();
    }).then(function(array) {
        $.each(array, function(index, value) {
            $("#news").append(`<div class="card mb-3" style="width: 150;">
    <div class="row no-gutters">
        <div class="col-md-4">
            <img width="300" height="200" src="` + value.imageOfNews + `">
        </div>
        <div class="col-md-8">
            <div class="new-card-body">
                <h5 class="card-title">` + value.title + `</h5>
                <p class="card-text">` + value.contentOfNews + `</p>
                <p class="card-text"><small class="text-muted">上傳日期:` + value.date + `</small></p>
            </div>

        </div>
    </div>
</div>`)
        })
    })
})


$("#page-historical").click(function() {
    $("#historical-row").empty()
    fetch("http://localhost:8080/coinshell/historical/get?currencyName=" + currencyName + "&day=" + day).then(function(response) {
        return response.json();
    }).then(function(array) {
        $.each(array, function(index, value) {
            $("#historical-row").append(`<tr>
                <th scope="col"> ` + day + `</th>
                <th scope="col">` + value.TheFristUsdDate + `</th>
                <th scope="col">` + value.TheHighestUsdPricePerUnit + `</th>
                <th scope="col">` + value.TheLowerUsdPricePerUnit + `</th>
                <th scope="col">` + value.TheLastUsdDate + `</th>
                <th scope="col">` + value.Usd24hVolume + `</th>
                <th scope="col">` + value.UsdMarkCap + `</th>
            </tr>3`);
        })
    })
})
var xmlHttp = new XMLHttpRequest();
var url = "http://localhost:8080/coinshell/historical/get30days?currencyName=" + currencyName
xmlHttp.open("GET", url, true);
xmlHttp.send()
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
            // console.log(days)
            // console.log(price)
            // document.write(days)
            // document.write(price)
        const ctx = document.getElementById('canvas').getContext('2d');
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
                    borderWidth: 3,
                    lineTension: 0,
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
}