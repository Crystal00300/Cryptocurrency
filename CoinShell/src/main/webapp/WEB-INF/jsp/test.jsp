<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
            <c:set var="contextRoot" value="${pageContext.request.contextPath}" />
            <!DOCTYPE html>
            <html>

            <head>
                <meta charset="UTF-8">
                <title>首頁</title>
                <link rel="Shortcut Icon" type="image/x-icon" href="https://cdn-icons-png.flaticon.com/512/1490/1490853.png" />
                <link href="${contextRoot}/css/bootstrap.min.css" rel="stylesheet">
                <link rel="stylesheet" href="//code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
                <link rel="stylesheet" href="/resources/demos/style.css">
                <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
                <script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
                <style>
                    body {
                        margin: 0px 50px 0px 50px;
                        background-attachment: fixed;
                        background-repeat: repeat;
                        background-color: #a89494ea;
                        /*背景色彩*/
                    }
                    
                    .container-fluid {
                        background-color: rgb(255, 255, 255);
                        text-align: left;
                        width: 100%;
                        height: 60px;
                    }
                    
                    .top-web-space {
                        width: 100%;
                        height: 200px;
                        border: 3px black dashed;
                    }
                    
                    .news {
                        border: 3px red dashed;
                    }
                    
                    .banner {
                        width: 100%;
                        /* border: 3px green dashed; */
                        background-color: rgb(0, 132, 206);
                        border-radius: 5px;
                        font-family: 'Times New Roman', Times, serif;
                        font-size: 30px;
                        text-shadow: 2px 2px 4px #000000;
                        color: white;
                        box-shadow: -2px 1px 10px #000000;
                    }
                    
                    .news-image {
                        width: 100%;
                        height: 200px;
                        border: 3px green dashed;
                    }
                </style>
            </head>

            <body>

                <div class="top-web-space">
                </div>

                <div class=" news">
                    <div class="banner">
                        <div class="news-banner-font">&emsp;Coin News</div>
                    </div>
                    <div class="news-image">這邊放新聞圖片</div>
                </div>

                <div class="top-coin">
                    <div class="banner">
                        <div class="news-banner-font">&emsp;Top Coin</div>

                    </div>



            </body>

            </html>