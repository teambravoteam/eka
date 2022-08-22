<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, viewport-fit=cover">
<meta charset="UTF-8">
<link href="<c:url value='/resources/css/auth.css'/>" rel="stylesheet">

<title>Insert title here</title>
</head>
<body>
	<form action="register_main" method="get">
		<div id="wrap" role="main">
			<a href="#wrap" class="bt-top hashLink"> <img
				src="https://skycatcher.co.kr/image/ic_arrow_up_24px.png" alt="맨위로">
				<span>맨위로</span>
			</a> <a href="https://pf.kakao.com/_sjxnTxb/chat" class="bt-kakao"
				target="_blank"> <img
				src="https://skycatcher.co.kr/image/ic_kakao_24px.png" alt="카톡상담">
				<span>문의</span>
			</a>
			<div id="login-bg" class="main">
				<a href="https://skycatcher.co.kr" class="header-logo">eka</a>
			</div>
			<div id="login-wrap">
				<div class="container small">
					<section class="content">
						<div class="shadow-wrap" style="margin-bottom: 16px;">
							<h1 class="title color-point">학생/원장 회원가입</h1>
							<ul class="join-select-wrap">
								<li class="shadow-wrap">
									<a href='<c:url value="/eka_main/adduser"/>'>
										<img src="../resources/img/student.png" alt="학생 회원가입"> <span>학생가입</span>
									</a>
								</li>
								<li class="shadow-wrap">
									<a href='<c:url value="/eka_main/addmanager"/>'>
										<img src="../resources/img/teacher.png" alt="원장 회원가입"> <span>원장가입</span>
									</a>
								</li>
							</ul>
						</div>
					</section>
				</div>
			</div>
		</div>
	</form>

	<script src='<c:url value="/resources/js/jquery-3.6.0.js"/>'></script>
	<script src='<c:url value="/resources/js/auth.js"/>'></script>
</body>
</html>