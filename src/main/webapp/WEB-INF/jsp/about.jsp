<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<jsp:include page="default/myNavbar.jsp" />

<head>
<meta charset="UTF-8">
<title>關於我們</title>
</head>
<body>
<div class="container">
<h1>圖表測試</h1>

<!-- TradingView Widget BEGIN -->
<div class="tradingview-widget-container">
  <div id="tradingview_d723a"></div>
  <div class="tradingview-widget-copyright"><a href="https://tw.tradingview.com/symbols/BTCUSD/?exchange=FTX" rel="noopener" target="_blank"><span class="blue-text">BTCUSD圖表</span></a>由TradingView提供</div>
  <script type="text/javascript" src="https://s3.tradingview.com/tv.js"></script>
  <script type="text/javascript">
  new TradingView.widget(
  {
//   "autosize": true,
  "symbol": "FTX:BTCUSD",
  "interval": "D",
  "timezone": "Etc/UTC",
  "theme": "light",
  "style": "1",
  "locale": "zh_TW",
  "toolbar_bg": "#f1f3f6",
  "enable_publishing": false,
  "allow_symbol_change": true,
  "container_id": "tradingview_d723a"
}
  );
  </script>
</div>
<!-- TradingView Widget END -->
</div>
</body>
</html>