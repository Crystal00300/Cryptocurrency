<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<jsp:include page="default/myNavbar.jsp" />
<link rel="stylesheet" href="${contextRoot}/css/coinList.css" >
<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick.css' >
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick-theme.min.css">

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>ShellCoin</title>
</head>

<body>
	<div class="container">

<p />
<div>
  <h2 class="bg-primary p-2">Coin news</h2>
  <div class="slider responsive">
    <div>
      <img src="https://picsum.photos/200/200/?random=2" alt="">
    </div>
    <div>
      <img src="https://picsum.photos/200/200/?random=1" alt="">
    </div>
    <div>
      <img src="https://picsum.photos/200/200/?random=1" alt="">
    </div>
    <div>
      <img src="https://picsum.photos/200/200/?random=1" alt="">
    </div>
    <div>
      <img src="https://picsum.photos/200/200/?random=1" alt="">
    </div>
    <div>
      <img src="https://picsum.photos/200/200/?random=1" alt="">
    </div>
    <div>
      <img src="https://picsum.photos/200/200/?random=1" alt="">
    </div>
    <div>
      <img src="https://picsum.photos/200/200/?random=3" alt="">
    </div>
  </div>
</div>

			<div>
				<table class="table" id="list_table_json">
				<thead class="bg-primary">
					<tr>
						<th scope="col">Top</th>
						<th>Name</th>
						<th>Currency</th>
						<th>Price</th>
  						<th>1h%</th>
  						<th>24h%</th>
  						<th>7d%</th>
  						<th>30d%</th>
						<th>Volume24h</th>
 						<th>Market Cap</th>
					</tr>
					</thead>
				</table>
				
<div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
    <a href="http://localhost:8080/myapp/"><button type="button" class="btn btn-link">1</button></a>
    <a href="http://localhost:8080/myapp/shellcoin/page2"><button type="button" class="btn btn-link">2</button></a>
    <a href="http://localhost:8080/myapp/shellcoin/page3"><button type="button" class="btn btn-link">3</button></a>
    <a href="http://localhost:8080/myapp/shellcoin/page4"><button type="button" class="btn btn-link">4</button></a>
    <a href="http://localhost:8080/myapp/shellcoin/page5"><button type="button" class="btn btn-link">5</button></a>
    <a href="http://localhost:8080/myapp/shellcoin/page6"><button type="button" class="btn btn-link">6</button></a>
    <a href="http://localhost:8080/myapp/shellcoin/page7"><button type="button" class="btn btn-link">7</button></a>
    <button type="button" class="btn btn-primary">8</button>
    <a href="http://localhost:8080/myapp/shellcoin/page9"><button type="button" class="btn btn-link">9</button></a>
   <a href="http://localhost:8080/myapp/shellcoin/page10"><button type="button" class="btn btn-link">10</button></a>
</div>
				
		</div>
<script>
function upCoin(){
         $.ajax({
            url:'http://localhost:8080/myapp/coin/page/8',
            contentType:'application/json; charset=UTF-8',  //送過去的
            dataType:'json', //傳回來的
            method:'get',
            success: function(result){
            	$('#list_table_json tr td').remove();
                console.log(result)
                coinList = '';
                $.each(result,function(index, value){
                	coinList += '<tr>'
                    coinList += '<td>' + value.id + '</td>'
                    coinList += '<td>' + '<div class="coinName"><img class="coinImg" src="${contextRoot}/images/' + value.symbol + '.png"><h1 class=coinH1>'  + value.name + '</h1></div></td>'
                    coinList += '<td>' + value.quotesName + '</td>' 
                    coinList += '<td class="price">' + value.price + '</td>'
                    coinList += '<td  type="text" class="1h">' + value.percentChange1h + '</td>' 
                    coinList += '<td class="24h">' + value.percentChange24h + '</td>' 
                    coinList += '<td class="7d">' + value.percentChange7d + '</td>' 
                    coinList += '<td class="30d">' + value.percentChange30d + '</td>' 
                    coinList += '<td class="vol24h">' + value.volume24h + '</td>' 
                    coinList += '<td class="market">' + value.marketCap + '</td>' 
                    coinList += '</tr>'      
                })
                $('#list_table_json').append(coinList);
            },
            error: function(err){
                console.log(err)
            }
         })
}
upCoin();
window.setInterval(function(){upCoin()},5000);

</script>
	</div>
	
<script src='https://code.jquery.com/jquery-3.6.0.slim.min.js'></script>
<script src="${contextRoot}/js/slick.js" ></script>
<script src="${contextRoot}/js/coinCarousel.js"></script>
</body>

</html>