<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<link rel="stylesheet" href="${contextRoot}/css/slick.css" >
<link rel="stylesheet" href="${contextRoot}/css/slick-theme.css" >
<link href="${contextRoot}/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light navbar-light ">
  <a class="navbar-brand" href="${contextRoot}/">Shellcoin</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="${contextRoot}/about">About us<span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${contextRoot}/">BeachTown</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${contextRoot}/">protfolio</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${contextRoot}/">Learn</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${contextRoot}/">Shell Shop</a>
      </li>
    </ul>
  </div>
</nav>



<script src="${contextRoot}/js/slick.js" ></script>
<script src="${contextRoot}/js/jquery-3.6.0.min.js" ></script>
<script src="${contextRoot}/js/bootstrap.bundle.min.js" ></script>
</body>
</html>