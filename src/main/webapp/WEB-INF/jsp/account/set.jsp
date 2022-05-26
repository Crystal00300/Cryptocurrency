<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
			<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
			<jsp:include page="../NavBar/CoinShellNavBar.jsp" />

			<head>
				<title>Account Settings | CoinShell</title>
				<style type="text/css">
					body {
						padding-top: 82px;
					}
				</style>
			</head>

			<body>
				<div class="box" style="background-color: white; text-align: center;">
					<div class="header">
						<h4>Account Settings</h4>
					</div>
					<form action="/account/set" method="post">
						<div>
							<div class="label">Avatar</div>
							<div class="setting-avatar-wrapper">
								<div>
									<div>
										<div class="avatar-item">
											<img src="${ login.customizedUserAvatar }" class="avatar-item-img"
												style="border-radius: 50%; height: 100px;">
										</div>
									</div>
								</div>
								<a type="button" data-toggle="modal" data-target="#chooseAvatar">Edit Avatar</a>
							</div>
						</div>
						<div>
							<div class="label">User Referral ID  </div>
							<input type="text" disabled value="${ login.memId }">
						</div>
						<div>
							<div class="label">UserName</div>
							<input type="text" placeholder="Enter your display name..."
								value="${ login.customizedUserName }">
							<!-- 取消七天後才能重複變更的條件 -->
						</div>
						<div>
							<div class="label">Email Address</div>
							<input type="email" disabled placeholder="Your email address..." value="${login.eMail}">
						</div>
						<button>Save</button>
					</form>
					<div class="footer">
						<div class="left">
							<div>Password</div>
							<div>Set a unique password to protect your personal account.</div>
						</div>
						<button class="Members"></button>
						<a type="button" data-toggle="modal" data-target="#changePwd">Change password</a>
					</div>
				</div>
				</div>

				<!-- 選擇 avatar 的modal -->
				<div class="modal fade text-left" id="chooseAvatar" tabindex="-1" role="dialog" data-backdrop="static"
					data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">

				</div>

				<!-- 變更密碼的 modal -->
				<div class="modal fade text-left" id="chooseAvatar" tabindex="-1" role="dialog" data-backdrop="static"
					data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">

				</div>


				<!-- jQuery + Bootstrap Bundle with Popper | Bootstrap 導入程式 JS -->
				<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
					integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
					crossorigin="anonymous"></script>
				<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
					integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF"
					crossorigin="anonymous"></script>


			</body>