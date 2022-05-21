<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <style>
        .container {
            width: 90%;
        }
        
        h1 {
            text-align: center;
            font-size: 46px;
        }
        
        #canvas {
            width: 100%;
        }
    </style>
</head>

<body>
    <script>
    </script>
    <div class="container">

        <h1> ChartJs Line Chart with json data api</h1>

        <div>
            <canvas id="canvas">

                
            </canvas>
        </div>
    </div>
    <script>
        var xmlHttp = new XMLHttpRequest();
        var url = "http://localhost:8080/coinshell/historical/get30days?currencyName=btc"
        xmlHttp.open("GET", url, true);
        xmlHttp.send()
        xmlHttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
                var data = JSON.parse(this.responseText);
                var days = data.map(function(elem) {
                    return elem.informationDate.substr(0, 16).replace('T', '').replace('-', '').replace('-', '').replace(':', '')
                });
                var price = data.map(function(elem) {
                    return Math.round(elem.usdPriceOfCryptocurrency);
                })
                console.log(days)
                console.log(price)
                document.write(days)
                    // document.write(price)
                const ctx = document.getElementById('canvas').getContext('2d');
                const myChart = new Chart(ctx, {
                    type: 'line',
                    data: {
                        labels: days,
                        datasets: [{
                            label: 'US',
                            data: price,
                            backgroundColor: [
                                'transparent'
                            ],
                            borderColor: 'black',
                            borderWidth: 4,
                            lineTension: 0.5

                        }]
                    },
                    options: {
                        element: {
                            line: {
                                lineTension: 10
                            }
                        },
                        scales: {
                            xAxes: [{
                                type: 'time',
                                time: {
                                    unit: 'hour'
                                }
                            }],
                            y: {
                                beginAtZero: true
                            }


                        }
                    }
                });
            }
        }
    </script>
</body>

</html>