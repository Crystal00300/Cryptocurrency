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
<link rel="icon" href="${contextRoot}/images/NavBarImg/icon.jpg"
	type="image/x-icon">

<!-- FONT AWESOME: Place your kit's code here -->
<script src="https://kit.fontawesome.com/0ef2a35b44.js"
	crossorigin="anonymous"></script>

<!--Only for this login modal's CSS 連結-->
<link rel="stylesheet" href="${contextRoot}/css/loginStyle.css">
<style>
body {
	background-image: url("tempbackground.png");
	min-height: 100%;
	background-attachment: fixed;
	background-repeat: no-repeat;
	background-position: center;
	background-size: contain;
}
</style>

<!--reCAPTCHA v2 代碼-->
<script src="https://www.google.com/recaptcha/api.js"></script>
</head>

<body>
	<!-- Start of the Navbar-->
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="${contextRoot}"><img
			src="${contextRoot}/images/NavBarImg/CoinShell.png"
			style="width: 150px;" alt="logo"></a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item active"><a class="nav-link" href="#">About
						us<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="#">BeachTown</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="#">Portfolio</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="#">Learn</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Shell
						Shop</a></li>
			</ul>
		</div>
		<!-- Button trigger modal -->
		<div>
			<a href="#" type="button" class="btn btn-primary mr-2"
				data-toggle="modal" data-target="#loginModal"> <i
				class="fa-solid fa-anchor"></i> Log In
			</a>
		</div>

		<!--Search navbar-->
		<form class="form-inline my-1 my-lg-0">
			<div class="input-group">
				<input class="form-control pl-2 p-0" type="search"
					placeholder="Search" aria-label="Search">
				<div class="input-group-append">
					<button class="btn btn-secondary input-group-append" type="submit">
						<i class="fa-solid fa-magnifying-glass"></i>
					</button>
				</div>
			</div>
		</form>
	</nav>
	<!-- End of the Navbar -->


	<!-- Modal -->
	<div class="modal fade text-left" id="loginModal" tabindex="-1"
		role="dialog" data-backdrop="static" data-keyboard="false"
		tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
		<div role="document" class="modal-dialog">
			<div class="modal-content">
				<!--Header-->
				<div
					class="modal-header row d-flex justify-content-between mx-1 mx-sm-6 mb-0 pb-0 border-0">
					<div class="tabs" id="tab01">
						<h6 class="font-weight-bold">Log In</h6>
					</div>
					<div class="tabs active" id="tab02">
						<h6 class="text-muted">Sign Up</h6>
					</div>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="line"></div>
				<!--Body-->
				<div class="modal-body">
<!--tab01 對應的 Log In 頁籤-->
					<fieldset class="show" id="tab011">
						<!--登入表單-->
						<form:form method="post" modelAttribute="logInMember">
							<!--E-Mail-->
							<div class="form-group input-group">
								<div class="input-group-prepend">
									<div class="input-group-text">
										<i class="fas fa-user-circle"></i>
									</div>
								</div>
								<input type="email" class="account form-control"
									placeholder="E-mail">
							</div>

							<!--Password-->
							<div class="form-floating form-group input-group">
								<div class="input-group-prepend">
									<div class="input-group-text">
										<i class="fas fa-unlock-alt"></i>
									</div>
								</div>
								<input type="password" class="password form-control"
									placeholder="Password" id="floatingPassword1">
								<div class="input-group-append">
									<span class="input-group-text"> <i id="eye1"
										class="fas fa-eye"></i>
									</span>
								</div>
							</div>
							<a href="#" style="display: block; text-align: right;">Forgot
								password?</a>
							<!--Checkbox-->
							<div class="form-group">
								<input type="checkbox" class="remember-me">Remember me
							</div>
							<!--Submit btn-->
							<button type="button" class="btn btn-info">
								<i class="fa-solid fa-anchor"></i> Log In
							</button>
						</form:form>
					</fieldset>
					<!--tab02 對應的 Sign Up 頁籤-->
					<fieldset id="tab021">
						<p>Gain access to additional features such as Watchlist and
							Portfolio tracking.</p>
						<!--註冊表單-->
						<form:form method="post" modelAttribute="SignUpMember">
							<!--E-Mail-->
							<div class="form-group input-group">
								<div class="input-group-prepend">
									<div class="input-group-text">
										<i class="fas fa-user-circle"></i>
									</div>
								</div>
								<input type="email" class="account form-control"
									placeholder="E-mail">
							</div>
							<!--Password-->
							<div class="form-group form-floating">
								<div class="input-group">
									<div class="input-group-prepend">
										<div class="input-group-text">
											<i class="fas fa-unlock-alt"></i>
										</div>
									</div>
									<input type="password" class="password form-control"
										placeholder="Password" id="floatingPassword2">
									<div class="input-group-append">
										<span class="input-group-text"> <i id="eye2"
											class="fas fa-eye"></i>
										</span>
									</div>
								</div>
								<p>Password should contain both letter and number, with
									minimum length of 8 characters.</p>
							</div>
							<!--推薦人 Referral ID-->
							<div class="form-group input-group">
								<div class="input-group-prepend">
									<div class="input-group-text">
										<i class="fas fa-users"></i>
									</div>
								</div>
								<input type="text" class="referral form-control"
									placeholder="Referral / your friend's email">
							</div>
							<!--Checkbox-->
							<div class="form-group">
								<input type="checkbox" class="dailyshell">Get a daily
								post of CoinShell, right to your inbox!
							</div>
							<!--reCAPTCHA v2-->
							<div class="g-recaptcha"
								data-sitekey="6LfDfO8fAAAAAALEtexVflMvH0HDwc5HCLGPjrj5xxxxxxx"></div>
							<!--Submit btn-->
							<button type="button" class="btn btn-info">
								<i class="fa-solid fa-anchor"></i> Create an account
							</button>
						</form:form>
					</fieldset>
				</div>
				<div class="line"></div>
				<!--Footer-->
				<div class="modal-footer">
					<div class="tnc-div">
						By creating this account, you agree to our <a
							href="#privacy-policy頁面">privacy policy</a> and <a
							href="#cookies-policy頁面">cookie policy</a>.
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>


	<!-- jQuery + Bootstrap Bundle with Popper | Bootstrap 導入程式 JS -->
	<script
		src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF"
		crossorigin="anonymous"></script>

	<script>
	//Password 顯示密碼
	$(document).ready(function() {
		$("#eye1").click(function() {
			if ($(this).hasClass('fa-eye')) {
				$("#floatingPassword1").attr('type', 'text');
			} else {
				$("#floatingPassword1").attr('type', 'password');
			}
			$(this).toggleClass('fa-eye').toggleClass('fa-eye-slash');
		});
	});

	$(document).ready(function() {
		$("#eye2").click(function() {
			if ($(this).hasClass('fa-eye')) {
				$("#floatingPassword2").attr('type', 'text');
			} else {
				$("#floatingPassword2").attr('type', 'password');
			}
			$(this).toggleClass('fa-eye').toggleClass('fa-eye-slash');
		});
	});

		//Multiple Tabs in a Modal
		$(document).ready(function() {

			$(".tabs").click(function() {

				$(".tabs").removeClass("active");
				$(".tabs h6").removeClass("font-weight-bold");
				$(".tabs h6").addClass("text-muted");
				$(this).children("h6").removeClass("text-muted");
				$(this).children("h6").addClass("font-weight-bold");
				$(this).addClass("active");

				current_fs = $(".active");

				next_fs = $(this).attr('id');
				next_fs = "#" + next_fs + "1";

				$("fieldset").removeClass("show");
				$(next_fs).addClass("show");

				current_fs.animate({}, {
					step : function() {
						current_fs.css({
							'display' : 'none',
							'position' : 'relative'
						});
						next_fs.css({
							'display' : 'block'
						});
					}
				});
			});

		});
	</script>

</body>

</html>
