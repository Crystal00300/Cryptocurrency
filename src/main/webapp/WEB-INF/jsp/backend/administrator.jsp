<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
    <!DOCTYPE html>
    <html>

    <head>
    <link rel="stylesheet" type="text/css" href="${contextRoot}/css/backend.css">
    
        <meta charset="UTF-8">
        <title>後台人員管理介面</title>
    </head>

    <body> 
    <ul>後台人員管理介面</ul>


       <ul>
       <li><a href="administrator/store">商店商品增刪查改頁面</a></li>
       <li><a href="administrator/news">新聞增刪查改頁面</a></li>
       <li></li>
       <li></li>
       <li></li>
       <li></li>
       <li></li>
       <li><a href="administrator/account">使用者與會員頭像增刪查詢修改</a></li>
       
       </ul>

    </body>

    </html>