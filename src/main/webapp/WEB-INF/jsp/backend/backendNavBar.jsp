<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">

<!--響應式網站-->
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="${contextRoot}/css/bootstrap.min.css">

<!-- 這裡放title Logo -->
<link rel="icon" href="${contextRoot}/images/NavBarImg/icon-bknd.png"
	type="image/x-icon">

<!-- FONT AWESOME: Place your kit's code here -->
<script src="https://kit.fontawesome.com/0ef2a35b44.js" crossorigin="anonymous"></script>

<link rel="stylesheet" href="//code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
<style type="text/css">
.navbar-custom{
	background-color: black;
}
</style>

<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
<script src="${contextRoot}/javascripts/bootstrap.bundle.min.js"></script>
</head>
<nav class="navbar navbar-expand-lg navbar-custom">

  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavDropdown">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="${contextRoot}/administrator"><img
			src="${contextRoot}/images/NavBarImg/logo-bknd.png"
			style="width: 180px;" alt="logo"><span class="sr-only"></a>
      </li>
      <li class="nav-item active font-custom">
        <a class="nav-link" href="administrator/store">商店商品</a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="${contextRoot}/administrator/news">新聞</a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="administrator/article">文章</a>
      </li>
      <li class="nav-item dropdown active">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-expanded="false">
          使用者與會員
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
          <a class="dropdown-item" href="administrator/account">使用者</a>
          <a class="dropdown-item" href="administrator/account">頭像</a>
        </div>
      </li>
    </ul>
  </div>
</nav>
<body>

</body>

</html>