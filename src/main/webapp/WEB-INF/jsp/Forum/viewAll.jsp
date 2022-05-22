<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 <c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<jsp:include page="${contextRoot}/NavBar/CoinShellNavBar.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<title>討論區</title>
</head>
<body>
	<div class="container">
		<h1>討論區</h1>
		<div class="row justify-content-center">
			<div class="col-9">
				<table class="table table-hover table-primary">
					<thead class="thead-dark">
						<tr>
							<th scope="col" class="col-2">幣別</th>
							<th scope="col" class="col-6"></th>
							<th scope="col" class="col-2">閱讀/回復</th>
							<th scope="col" class="col-2">建立時間</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="Article" items="${page.content}">
							<tr class="table-info">
								<td><c:out value="${Article.tag}"></c:out></td>
								<td><a href="${contextRoot}/viewArticle/${Article.id}" style="display: block;">
										<div class="b-list">
											<div>
												<c:out value="${Article.title}"></c:out>
											</div>
											<p>
												<c:out value="${Article.peek}"></c:out>
											</p>
										</div>
								</a></td>
								<td align="center"><c:out value="${Article.readNum}"></c:out> / <c:out
										value="${Article.commentNum}"></c:out></td>
								<td><fmt:formatDate pattern="MM/dd EE HH:mm"
										value="${Article.added}" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>

		<!-- 		分頁功能 -->
		<div class="row justify-content-center">
			<div class="col-9">
				<c:forEach var="pageNumber" begin="1" end="${page.totalPages}">
					<!-- 	pageNumber過來時是否是現在這一頁，不是的話就顯示超連結，是的話只顯示數字 page.number是從0開始，pageNumber是從1開始，所以要剪一-->
					<c:choose>
						<c:when test="${page.number != pageNumber-1}">
							<a href="${contextRoot}/message/viewMessages?p=${pageNumber}"><c:out
									value="${pageNumber}" /></a>
						</c:when>

						<c:otherwise>
							<c:out value="${pageNumber}"></c:out>
						</c:otherwise>
					</c:choose>

					<c:if test="${pageNumber != page.totalPages}">
						<c:out value="|"></c:out>
					</c:if>

				</c:forEach>
			</div>
		</div>

	</div>
</body>
</html>