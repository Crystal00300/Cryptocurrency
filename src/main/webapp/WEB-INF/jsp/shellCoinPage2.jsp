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
						<th>top</th>
						<th>name</th>
						<th>currency</th>
						<th>price</th>
  						<th>1h</th>
  						<th>24h</th>
  						<th>7d</th>
  						<th>30d</th>
 						<th>60d</th>
					</tr>
					</thead>
				</table>
				
<div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
    <a href="http://localhost:8080/myapp/"><button type="button" class="btn btn-link">1</button></a>
    <button type="button" class="btn btn-primary">2</button>
    <a href="http://localhost:8080/myapp/shellcoin/page3"><button type="button" class="btn btn-link">3</button></a>
    <a href="http://localhost:8080/myapp/shellcoin/page4"><button type="button" class="btn btn-link">4</button></a>
    <a href="http://localhost:8080/myapp/shellcoin/page5"><button type="button" class="btn btn-link">5</button></a>
    <a href="http://localhost:8080/myapp/shellcoin/page6"><button type="button" class="btn btn-link">6</button></a>
    <a href="http://localhost:8080/myapp/shellcoin/page7"><button type="button" class="btn btn-link">7</button></a>
    <a href="http://localhost:8080/myapp/shellcoin/page8"><button type="button" class="btn btn-link">8</button></a>
    <a href="http://localhost:8080/myapp/shellcoin/page9"><button type="button" class="btn btn-link">9</button></a>
   <a href="http://localhost:8080/myapp/shellcoin/page10"><button type="button" class="btn btn-link">10</button></a>
</div>
				
		</div>
<script>
function upCoin(){
         $.ajax({
            url:'http://localhost:8080/myapp/coin/page/2',
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
                	coinList += '<td>' + value.price + '</td>' 
                	coinList += '<td>' + value.percentChange1h + '</td>' 
                	coinList += '<td>' + value.percentChange24h + '</td>' 
                	coinList += '<td>' + value.percentChange7d + '</td>' 
                	coinList += '<td>' + value.percentChange30d + '</td>' 
                	coinList += '<td>' + value.percentChange60d + '</td>' 
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