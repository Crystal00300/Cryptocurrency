<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<jsp:include page="default/myNavbar.jsp" />

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
		</div>
<script>
function upCoin(){
         $.ajax({
            url:'http://localhost:8080/myapp/coin/getAll',
            contentType:'application/json; charset=UTF-8',  //送過去的
            dataType:'json', //傳回來的
            method:'get',
            success: function(result){
            	$('#list_table_json tr td').remove();
                console.log(result)
                msg_data = '';
                $.each(result,function(index, value){
                    msg_data += '<tr>'
                    msg_data += '<td>' + value.id + '</td>'
                    msg_data += '<td>' + value.name + '</td>'
                    msg_data += '<td>' + value.quotes_name + '</td>' 
                    msg_data += '<td>' + value.price + '</td>' 
                    msg_data += '<td>' + value.percentChange1h + '</td>' 
                    msg_data += '<td>' + value.percentChange24h + '</td>' 
                    msg_data += '<td>' + value.percentChange7d + '</td>' 
                    msg_data += '<td>' + value.percentChange30d + '</td>' 
                    msg_data += '</tr>'      
                })
                $('#list_table_json').append(msg_data);
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