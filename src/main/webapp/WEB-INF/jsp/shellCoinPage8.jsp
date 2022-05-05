<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<jsp:include page="default/myNavbar.jsp" />
<link rel="stylesheet" href="${contextRoot}/css/coinList.css" >
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>ajax</title>
</head>

<body>
	<div class="container">
		<h1>coin ajax</h1>

			<div>
				<table class="mytable" id="list_table_json">
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
				</table>
				
				<a href="http://localhost:8080/myapp/">1</a>
				<a href="http://localhost:8080/myapp/shellcoin/page2">2</a>
				<a href="http://localhost:8080/myapp/shellcoin/page3">3</a>
				<a href="http://localhost:8080/myapp/shellcoin/page4">4</a>
				<a href="http://localhost:8080/myapp/shellcoin/page5">5</a>
				<a href="http://localhost:8080/myapp/shellcoin/page6">6</a>
				<a href="http://localhost:8080/myapp/shellcoin/page7">7</a>
				<a href="http://localhost:8080/myapp/shellcoin/page8">8</a>
				<a href="http://localhost:8080/myapp/shellcoin/page9">9</a>
				<a href="http://localhost:8080/myapp/shellcoin/page10">10</a>
				
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
                	coinList += '<td>' + value.name + '</td>'
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
window.setInterval(function(){upCoin()},5000);

</script>
	</div>
</body>

</html>