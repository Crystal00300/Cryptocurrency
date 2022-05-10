<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.Locale" %>
<%@ page import="javax.servlet.*,javax.servlet.http.* "%>
<%@ page import="java.text.NumberFormat,java.util.Date" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%
	String title = "Locale Specific Currency";
   //获取客户端本地化信息
   Locale locale = new Locale("zh");
   //Locale locale = request.getLocale();
   String language = locale.getLanguage(); //返回語言碼的英文小寫，或ISO 639 格式的區域
   String country = locale.getCountry();   //返回國家/地區碼的英文大寫，或ISO 3166 2-letter 格式的區域
   String displayLanguage = locale.getDisplayLanguage(); //返回要給用戶看的語言名稱
   String iso3Language = locale.getISO3Language(); //返回語言名稱的3字母縮寫
   NumberFormat nft = NumberFormat.getCurrencyInstance(locale);
   String formattedCurr = nft.format(1000000);
   
%>




<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>



<body>





    
    <div id="footer">
    <div id="copyright">
        <span><fmt:message key="common.copyright"/></span>
    </div>
    <div id="language">
        <span><fmt:message key="common.language"/>:</span>
        <a href="#" data-value="zh_CN">中文</a>
        <span>|</span>
        <a href="#" data-value="en_US">English</a>
    </div>
</div>
    
    
    

<p align="center">
<% 
   out.println("Language : " + language  + "<br />");
   out.println("Country  : " + country   + "<br />");
   out.println("DisplayLanguage  : " + displayLanguage   + "<br />");
   out.println("Iso3Language  : " + iso3Language   + "<br />");
%>
<div align="center">
<p>Formatted Currency: <%  out.print(formattedCurr); %></p>
測試
</div>




</body>
</html>