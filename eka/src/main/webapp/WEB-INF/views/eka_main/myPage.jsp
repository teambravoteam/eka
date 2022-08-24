<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width" />
<title>EKA! Every K-Academy</title>

<link rel="shortcut icon" href="../resources/img/logo.jpg" type="image/x-icon">
<link href="../resources/css/jquery-ui-1.12.1.css" type="text/css" rel="stylesheet">
<link href="../resources/css/swiper.css" type="text/css" rel="stylesheet">
<link href="../resources/css/aos.css" rel="stylesheet">
<link href="../resources/css/common.css" type="text/css" rel="stylesheet">
<link href="../resources/css/font.css" type="text/css" rel="stylesheet">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap" rel="stylesheet">

<script type="text/javascript" src="../resources/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="../resources/js/jquery-ui-1.12.1.min.js"></script>
<script type="text/javascript" src="../resources/js/swiper.min.js"></script>
<script type="text/javascript" src="../resources/js/aos.js"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=fc2120b8ad3fcff0b18376b88b35a6f5&amp;libraries=services,clusterer"></script>
<script charset="UTF-8" src="https://t1.daumcdn.net/mapjsapi/js/main/4.4.6-fixed2/kakao.js"></script>
<script charset="UTF-8" src="https://t1.daumcdn.net/mapjsapi/js/libs/services/1.0.2/services.js"></script>
<script charset="UTF-8" src="https://t1.daumcdn.net/mapjsapi/js/libs/clusterer/1.0.9/clusterer.js"></script>
</head>

<body>
	<div id="wrap" role="main">
		<header id="header" role="navigation">
			<%@ include file="common/header.jsp"%>
		</header>

		<a href="#wrap" class="bt-top hashLink">
			<img src="../resources/img/ic_arrow_up_24px.png" alt="맨위로"> <span>맨위로</span>
		</a>
		<a href="http://pf.kakao.com/_IxjQZxj/chat" class="bt-kakao" target="_blank">
			<img src="../resources/img/ic_kakao_24px.png" alt="카톡상담"> <span>문의</span>
		</a>

		<div class="mypage-wrap container">
			<nav class="flex-shrink-0 flex-glow-0">
				<ul class="snb point">
					<li class="current">
						<a href="https://skycatcher.co.kr/mypage/userInfo">내정보</a>
					</li>
					<li>
						<a href="https://skycatcher.co.kr/mypage/userAcademy">학원</a>
					</li>
				</ul>
			</nav>
			<script>
				(function() {
					var nowPage = location.href.split('?')[0];
					var navTarget = $(
							".snb a[href='" + location.href.split('?')[0]
									+ "']").parent().addClass("current");
					if (navTarget.parent().hasClass("depth2")) {
						navTarget.parent().show().parent().addClass("current");
					}
				})();
			</script>
			<div class="content flex-glow-1">
				<div class="shadow-wrap">
					<h2 class="info-title">내정보</h2>
					<div class="m-info">
						<div class="border-wrap profile-wrap flex-shrink-0">
							<img src="../resources/img/empty_user.png" alt="${manager.name}">
						</div>
						<div class="flex-glow-1">
							<span class="chip-label accent">원장</span>
							<table class="info-list">
								<tbody>
									<tr>
										<th scope="row">가입일시</th>
										<td>${manager.regDate}</td>
									</tr>
									<tr>
										<th scope="row">아이디</th>
										<td>${manager.userId}</td>
									</tr>
									<tr>
										<th scope="row">이름</th>
										<td>${manager.name}</td>
									</tr>
									<tr>
										<th scope="row">생년월일</th>
										<td>${manager.ssn}</td>
									</tr>
									<tr>
										<th scope="row">휴대폰번호</th>
										<td>${manager.phone}</td>
									</tr>
								</tbody>
							</table>
							<div class="row-1"></div>
							<table class="info-list">
								<tbody>
									<tr>
										<th scope="row">학원명</th>
										<td>${academyName}</td>
									</tr>

								</tbody>
							</table>
							<div class="bt-main-wrap">
								<button type="button" class="bt-label" id="bt-modify-user">수정</button>
							</div>
						</div>
					</div>

					<script>
						$("#bt-modify-user").on("click", function() {
							openModal("userInfo", null, function() {
								$("#modal-wrap").addClass("width-s");
							});
						});
					</script>

					<div class="bt-main-wrap">
						<button type="button" class="bt-label bt-withdraw">회원탈퇴</button>
					</div>
					<script>
						$('.bt-add').on("click", function() {
							openModal("regParent", "check", function() {
								$("#modal-wrap").addClass("width-s");
							});

						});

						$('.bt-withdraw').on('click', function() {
							openModal("userWidthdraw", null, function() {
								$("#modal-wrap").addClass("width-s");
							});
						});

						$('.bt-modify-relation').on('click', function() {
							openModal("regParent", $(this).val(), function() {
								$("#modal-wrap").addClass("width-s");
							});
						});
					</script>
				</div>
			</div>
		</div>
	</div>

	<div id="modal-wrap" class="modal-wrap width-s" style="display: block;">
		<div class="modal-head">
			<button type="button" class="bt-icon close float-right">닫기</button>
			<h3 class="modal-title">내 정보 변경</h3>
			<span class="modal-guide" style="display: none;"></span>
		</div>
		<div class="modal-body">
			<form action="./configUser" method="post" onsubmit="return chkModalSubmit(this)">
				<ul class="input-wrap">	
					<li>
						<label for="userPw" class="label-text">비밀번호</label>
						<span id="userPwGuide" class="comment"></span>
						<div class="flex-wrap">
							<input type="password" name="password" id="userPw" class="input-text" value="" required="" autocomplete="new-password" placeholder="변경할 비밀번호를 입력해주세요">
						</div>
					</li>
					<li>
						<label for="userPhone" class="label-text">휴대폰번호</label>
						<span id="userPhoneGuide" class="comment"></span>
						<div class="input-phone-wrap flex-wrap">
							<input type="tel" name="phone" id="userPhone" class="input-text" value="" required="" autocomplete="tel" placeholder="휴대폰번호를 입력해주세요 (-)제외">
						</div>
					</li>
					<li>
						<label for="userImageUploader" class="label-text">프로필이미지</label>
						<div class="input-file-wrap flex-wrap">
							<input type="text" id="userImageLabel" class="input-text" placeholder="jpg, png, gif만 업로드가능" readonly="">
							<input type="hidden" name="userImage" id="userImage" value="https://phinf.pstatic.net/contact/20180407_57/1523093071038buYU2_PNG/avatar_profile.png">
							<label for="userImageUploader" class="bt-main point">파일선택</label>
							<input type="file" id="userImageUploader" accept=".jpg,.jpeg,.png,.gif" data-target="userImage">
						</div>
						<input type="hidden" name="tokenId" id="tokenId">
					</li>
					
					<li>
						<label for="userEmail" class="label-text">이메일</label>
						<span id="userEmailGuide" class="comment"></span>
						<div class="flex-wrap">
							<input type="email" name="email" id="userEmail" class="input-text" value="" required="" autocomplete="email" placeholder="이메일을 입력해주세요">
						</div>
					</li>

				</ul>
				<input type="hidden" name="configType" value="user">
				<div class="bt-modal-wrap">
					<button type="submit" class="bt-label color-point">저장</button>
				</div>
			</form>
			<script>
				$('#userPass')
						.on(
								'keyup',
								function() {
									var strength = checkStrength($(this).val());
									$('#userPassConfirm').trigger("keyup");
									if (strength == -1) {
										$(this).removeClass('warning safe');
										$('#userPassGuide').text('');
									} else if (strength < 2) {
										$(this).removeClass('safe').addClass(
												'warning');
										$('#userPassGuide')
												.removeClass('safe')
												.addClass('warning')
												.text(
														'8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.');
									} else if (strength == 2) {
										$(this).removeClass('warning')
												.addClass('safe');
										$('#userPassGuide').removeClass(
												'warning').addClass('safe')
												.text('사용가능한 비밀번호입니다.');
									} else {
										$(this).removeClass('warning')
												.addClass('safe');
										$('#userPassGuide').removeClass(
												'warning').addClass('safe')
												.text('안전한 비밀번호입니다.');
									}
								});
				
				$('#userPassConfirm').on(
						'keyup',
						function() {
							if ($(this).val().length == 0) {
								$(this).removeClass('warning checked');
								$('#userPassConfirmGuide').text('');
							} else if ($(this).val() != $('#userPass').val()) {
								$(this).removeClass('checked').addClass(
										'warning');
								$('#userPassConfirmGuide').addClass('warning')
										.text('일치하지 않습니다.');
							} else {
								$(this).removeClass('warning').addClass(
										'checked');
								$('#userPassConfirmGuide').text('');
							}
						});
				
				$('#userEmail')
						.on(
								'keyup',
								function() {
									var email = $(this).val();
									if (email.length == 0) {
										$('#userEmailGuide').text('');
									} else if (email
											.match(/^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/)) {
										$('#userEmailGuide').removeClass(
												'warning').addClass('safe')
												.text('사용가능한 이메일입니다.');
									} else {
										$('#userEmailGuide')
												.removeClass('safe').addClass(
														'warning').text(
														'올바른 이메일 형식을 입력해주세요.');
									}
								});
				
				$("#userImageUploader").on("change", function() {
					var $this = $(this);
					uploader(this.files, {
						token : $("#tokenId").val(),
						mode : "thumb",
						width : 236,
						height : 236
					}, function(file) {
						$this.val("");
						$("#tokenId").val(file.token);
						$("#userImageLabel").val(file.alias);
						$("#userImage").val(file.url);
					}, function(msg) {
						$this.val("");
						alert(msg);
					});
				});
				function chkModalSubmit(form) {
					var userId = $('#userId');
					var userPass = $('#userPass');
					var userPassConfirm = $('#userPassConfirm');
					var userPhone = $('#userPhone');
					var userPhoneOrigin = $('#userPhoneOrigin');

					if (userPass && userPass.val()) {
						if (checkStrength(userPass.val()) < 2) {
							alert('사용할 수 없는 암호입니다.');
							userPass.focus();
							return false;
						}
						if (userPass.val() != userPassConfirm.val()) {
							alert('암호가 일치하지 않습니다.');
							userPassConfirm.focus();
							return false;
						}
					}
					if (userPhone.val() != userPhoneOrigin.val()) {
						if (!userPhone.val().match(
								/^(01[016789])([1-9]{1}[0-9]{2,3})([0-9]{4})$/)
								|| !$('#userPhoneVerify').val()
								|| !$('#userPhoneGuide').hasClass('safe')) {
							alert('휴대폰번호가 확인되지 않았습니다.');
							userPhone.focus();
							return false;
						}
					}
				}
			</script>
		</div>
	</div>

	<footer id="footer">
		<ul class="footer-wrap">
			<li>
				<a href="#" class="footer-nav">이용약관</a>
			</li>
			<li>
				<a href="#" class="footer-nav color-point">개인정보처리방침</a>
			</li>
		</ul>
		<div class="container">
			<section class="content">
				<h1 class="skip">사이트 이용정보</h1>
				<ul class="footer-company">
					<li>EKA</li>
					<li>팀 브라보</li>
					<li>
						<a href="tel:053-1234-1234">고객센터 053-1234-1234</a>
					</li>
					<li>
						<a href="mailto:bravoTeam@bravoTeam.co.kr">이메일 bravoTeam@bravoTeam.co.kr</a>
					</li>
					<li>대구광역시 중구 반월당</li>
				</ul>
			</section>
		</div>
	</footer>
	</div>
</body>

<script type="text/javascript" src="../resources/js/common.js"></script>

</html>
