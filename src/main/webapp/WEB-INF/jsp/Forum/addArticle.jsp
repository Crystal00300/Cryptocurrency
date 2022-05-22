<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<jsp:include page="${pageContext}NavBar/CoinShellNavBar.jsp" />
<title>新增留言</title>
</head>
<div class="container">
	<div class="row justify-content-center">
		<div class="col-9">
			<h1>新增留言</h1>
			<div class="card">
				<div class="card-header">新增訊息</div>
				<div class="card-body">
					<!-- 			如果getmapping和postmapping的路徑一樣，action=""可以不用寫 -->
					<form:form action="${contextRoot}/article/add" method="post"
						modelAttribute="article">
						<div class="input-group">
							<form:select path="tag">
								<form:option value="NONE" label="請選擇幣別標籤" />
								<form:options items="${tagList}"/>
							</form:select>
							<form:input path="title"/>
						</div>
						<div class="input-group">
							<form:textarea path="text" class="form-control" />
							<!-- 				此text是Article的屬性 -->
						</div>
						<div>
						<form:input path="readNum" value="0" type="hidden"/>
						<form:input path="commentNum" value="0" type="hidden"/>
						<form:input path="deleted" value="n" type="hidden"/>
						</div>
						<input type="submit" name="submit" value="新增訊息於此">
					</form:form>
				</div>
			</div>
		</div>
	</div>
	<div class="row justify-content-center">
		<div class="col-9">
			<div class="card">
<!-- 			http://tw.gitbook.net/jsp/jstl_format_formatdate_tag.html -->
				<div class="card-header">新增時間: <fmt:formatDate pattern="yyyy-MM-dd EE 'at' HH:mm:ss" value="${lastestArticle.added}"/></div>
				<div class="card-body">
				
				<c:out value="${lastestArticle.text}"></c:out>
				
				</div>
			</div>
		</div>
	</div>
</div>