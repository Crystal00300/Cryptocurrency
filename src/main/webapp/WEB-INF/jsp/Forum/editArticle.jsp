<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改文章頁面</title>
</head>
<body>
<div class="container">
	<div class="row justify-content-center">
		<div class="col-9">
			<div class="card">
				<div class="card-header">修改文章</div>
				<div class="card-body">
					<!-- 			如果getmapping和postmapping的路徑一樣，action=""可以不用寫 -->
					<form:form action="${contextRoot}/postEditArticle" method="post"
						modelAttribute="article">
						<form:input type="hidden" path="id"/>
						<form:input type="hidden" path="added"/>
						<div class="input-group">
							<form:select path="tag">
								<form:option value="NONE" label="請選擇幣別標籤" />
								<form:options items="${tagList}"/>
							</form:select>
						</div>
						<div class="input-group">
							<form:textarea path="title" class="form-control" style="height: auto; width: auto;"/>
							<form:textarea path="text" class="form-control" />							
						</div>
						<div>
							<form:input path="readNum"/>
							<form:input path="commentNum"/>
							<form:input path="deleted"/>
						</div>
						<input type="submit" name="submit" value="修改訊息">
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>


</body>
</html>