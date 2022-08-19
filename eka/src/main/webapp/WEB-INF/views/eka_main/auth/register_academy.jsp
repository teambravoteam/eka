<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, viewport-fit=cover">
<meta charset="UTF-8">
<link href="<c:url value='/resources/css/auth.css'/>" rel="stylesheet">

<title>login_student</title>
</head>
<body>
	<div id="wrap" role="main">
		<a href="#wrap" class="bt-top hashLink"> <img
			src="https://skycatcher.co.kr/image/ic_arrow_up_24px.png" alt="맨위로">
			<span>맨위로</span>
		</a> <a href="https://pf.kakao.com/_sjxnTxb/chat" class="bt-kakao"
			target="_blank"> <img
			src="https://skycatcher.co.kr/image/ic_kakao_24px.png" alt="카톡상담">
			<span>문의</span>
		</a>
		<div id="login-bg" class="type2">
			<a href="https://skycatcher.co.kr" class="header-logo">eka</a>
		</div>
		<div id="login-wrap">
			<div class="container small">
				<section class="content">
					<form method="post" onsubmit="return joinJsChk(this);">
						<fieldset class="shadow-wrap">
							<h1 class="title color-accent">원장 회원가입</h1>
							<ul class="input-wrap">
								<li><label for="userId" class="label-text">아이디</label> <span
									id="userIdGuide" class="comment"></span>
									<div class="flex-wrap">
										<input type="text" class="input-text" name="userId"
											id="userId" maxlength="20" placeholder="아이디를 입력해주세요"
											value="${userId}"> <input type="submit"
											id="verifyRequest" class="bt-main white margin" value="중복확인"
											name="check" formaction="idtest1">
									</div>
									<div style="color: red;">
										<c:out value="${message_red}" />
									</div>
									<div style="color: green;">
										<c:out value="${message_green}" />
									</div>
									<div style="color: red;">
										<c:out value="${errorMsgs.userId}" />
									</div></li>
								<li><label for="userPass" class="label-text">비밀번호</label> <span
									id="userPassGuide" class="comment"></span>
									<div class="flex-wrap">
										<input type="password" name="userPw" class="input-text pass"
											id="userPass" autocomplete="new-password" maxlength="16"
											placeholder="비밀번호를 입력해주세요">
									</div>
									<div style="color: red;">
										<c:out value="${errorMsgs.userPw}" />
									</div></li>
								<li><label for="userPassConfirm" class="label-text">비밀번호
										확인</label> <span id="userPassConfirmGuide" class="comment"></span>
									<div class="flex-wrap">
										<input type="password" name="userPw2" id="userPassConfirm"
											class="input-text pass" autocomplete="new-password"
											maxlength="16" placeholder="비밀번호를 한번 더 입력해주세요">
									</div>
									<div style="color: red;">
										<c:out value="${errorMsgs.userPw2}" />
									</div>
									<div style="color: red;">
										<c:out value="${passwd}" />
									</div>
									</li>
								<li><label for="userName" class="label-text">이름</label>
									<div class="flex-wrap">
										<input type="text" name="name" id="userName"
											class="input-text" value="" autocomplete="name"
											placeholder="이름을 입력해주세요">
									</div>
									<div style="color: red;">
										<c:out value="${errorMsgs.name}" />
									</div></li>
								<li><label for="userName" class="label-text">폰번호</label>
									<div class="flex-wrap">
										<input type="text" name="phone" id="userName"
											class="input-text" value="" autocomplete="name"
											placeholder="폰번호를 입력해주세요">
									</div>
									<div style="color: red;">
										<c:out value="${errorMsgs.phone}" />
									</div></li>
								<li><label for="userName" class="label-text">주민번호</label>
									<div class="flex-wrap">
										<input type="text" name="ssn" id="userName" class="input-text"
											value="" autocomplete="name" placeholder="주민번호를 입력해주세요">
									</div>
									<div style="color: red;">
										<c:out value="${errorMsgs.ssn}" />
									</div></li>
							</ul>
						</fieldset>
						<div class="bt-wrap flex-wrap">
							<input type="submit" class="bt-main accent flex-glow-1"
								value="가입하기" name="check" formaction="addmanager">
						</div>
					</form>
				</section>
			</div>
		</div>
	</div>
	<script src='<c:url value="/resources/js/jquery-3.6.0.js"/>'></script>
	<script src='<c:url value="/resources/js/auth.js"/>'></script>
</body>
</html>