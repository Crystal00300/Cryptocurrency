<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<jsp:include page="NavBar/CoinShellNavBar.jsp" />

<head>
<meta charset="UTF-8">
<title>CoinShell</title>
<link rel="Shortcut Icon" type="image/x-icon"href="https://cdn-icons-png.flaticon.com/512/1490/1490853.png" />

<link rel="stylesheet" href="${contextRoot}/css/bootstrap.min.css" >
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<link rel="stylesheet" type="text/css" href="${contextRoot}/css/indexCss.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
<script src="${contextRoot}/javascripts/indexJs.js"></script>

<style type="text/css">
body {
	padding-top: 82px;
}
</style>
</head>

<body>
	<div class="main">
		<div class="top-web-space">
			<p>${loginError}</p>
		</div>


	</div>

	<div class=" news">
		<div class="banner">
			<div class="news-banner-font">&emsp;Coin News</div>
		</div>
		<div class="news-image">
			<img src="https://picsum.photos/300/180/?random=10"> <img
				src="https://picsum.photos/300/180/?random=11"> <img
				src="https://picsum.photos/300/180/?random=12"> <img
				src="https://picsum.photos/300/180/?random=13">
		</div>
	</div>

	<div class="top-coin">
		<div class="banner">
			<div class="news-banner-font">&emsp;Top Coin</div>
		</div>
		<div id="tabs">
			<ul>
				<li><a href="#overview" id="page-overview">TOP 100</a></li>
				<li><a href="#focus" id="page-historical">Follow List</a></li>
			</ul>
			<div id="overview">

				<input id="coinName" type="text" placeholder="Search" /> <input
					type="button" name="submit" value="查詢" id="search" />

				<table class="table table-hover" id="top">
					<thead>
						<tr>
							<th scope="col">Top</th>
							<th scope="col">Watch</th>
							<th scope="col">Name</th>
							<th scope="col">Currency</th>
							<th scope="col">Price</th>
							<th scope="col">1h%</th>
							<th scope="col">24h%</th>
							<th scope="col">7d%</th>
							<th scope="col">30d%</th>
							<th scope="col">Volume24h</th>
							<th scope="col">Market Cap</th>
						</tr>
					</thead>
					<tbody class="cointable">
					</tbody>
				</table>
			</div>
			<div id="focus">
				<table class="table table-hover" id="watch">
					<thead>
						<tr>
							<th scope="col">Top</th>
							<th scope="col">Watch</th>
							<th scope="col">Name</th>
							<th scope="col">Currency</th>
							<th scope="col">Price</th>
							<th scope="col">1h%</th>
							<th scope="col">24h%</th>
							<th scope="col">7d%</th>
							<th scope="col">30d%</th>
							<th scope="col">Volume24h</th>
							<th scope="col">Market Cap</th>
						</tr>
					</thead>
				</table>
			</div>
		</div>


	</div>



	</div>


	<script>
		$("#search").click(function() {
			loadCoinByName();
		})
	</script>

</body>

</html>

