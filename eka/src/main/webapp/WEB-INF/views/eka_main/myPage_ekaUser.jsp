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
						<form action="myPage" method="post">
							<input type="hidden" name="ekauserId" value="${ekauser.userId}" />
							<input type="submit" class="a-title" value="내 정보" />
						</form>
					</li>
					<li>
						<form action="ekaUser_list" method="post">
							<input type="hidden" name="ekauserId" value="${ekauser.userId}" />
							<input type="submit" class="a-title" value="내 학원정보" />
						</form>
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
							<img src="../resources/img/empty_user.png" alt="${ekauser.name}">
						</div>
						<div class="flex-glow-1">
							<span class="chip-label point">학생</span>
							<table class="info-list">
								<tbody>
									<tr>
										<th scope="row">가입일시</th>
										<td>${ekauser.regDate}</td>
									</tr>
									<tr>
										<th scope="row">아이디</th>
										<td>${ekauser.userId}</td>
									</tr>
									<tr>
										<th scope="row">비밀번호</th>
										<td>${ekauser.userPw}</td>
									</tr>
									<tr>
										<th scope="row">이름</th>
										<td>${ekauser.name}</td>
									</tr>
									<tr>
										<th scope="row">성별</th>
										<td>${ekauser.gender}</td>
									</tr>
									<tr>
										<th scope="row">생년월일</th>
										<td>${ekauser.ssn}</td>
									</tr>
									<tr>
										<th scope="row">휴대폰번호</th>
										<td>${ekauser.phone}</td>
									</tr>
									<tr>
										<th scope="row">이메일</th>
										<td>${ekauser.email}</td>
									</tr>
								</tbody>
							</table>
							<div class="row-1"></div>
							<table class="info-list">
								<tbody>
									<c:forEach var="academy" items="${academyNameList}" varStatus="status">
										<tr>
											<th scope="row">등록 학원(${status.index+1})</th>
											<td>${academy}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<div class="bt-main-wrap">
								<button type="button" class="bt-label" id="bt-modify-user">수정</button>
							</div>
						</div>
					</div>

					<script>
						$("#bt-modify-user").on("click", function() {
							$("#modal-wrap").css('display', 'block');
							$("#wrap").addClass('transparent');
						});
					</script>

					<div class="bt-main-wrap">
						<button type="button" class="bt-label bt-withdraw">회원탈퇴</button>
					</div>
				</div>
			</div>
		</div>

		<%@ include file="common/footer.jsp"%>
	</div>

	<div id="modal-wrap" class="modal-wrap width-s" style="display: none;">
		<div class="modal-head">
			<button type="button" class="bt-icon close float-right">닫기</button>
			<h3 class="modal-title">내 정보 변경</h3>
			<span class="modal-guide" style="display: none;"></span>
		</div>
		<div class="modal-body">
			<form action="myPage_update" method="post">
				<ul class="input-wrap">
					<li>
						<label for="userPw" class="label-text">변경할 비밀번호</label>
						<div class="flex-wrap">
							<input type="password" name="password" id="userPw" class="input-text" value="${manager.userPw}" required="" autocomplete="new-password" placeholder="변경할 비밀번호를 입력해주세요">
						</div>
					</li>
					<li>
						<label for="userName" class="label-text">변경할 이름</label>
						<div class="flex-wrap">
							<input type="text" name="name" id="userName" class="input-text" value="${manager.name}" required="" autocomplete="new-password" placeholder="변경할 이름을 입력해주세요">
						</div>
					</li>
					<li>
						<label for="userSsn" class="label-text">변경할 생년월일</label>
						<div class="flex-wrap">
							<input type="text" name="ssn" id="userSsn" class="input-text" value="${manager.ssn}" required="" autocomplete="new-password" placeholder="주민번호 앞 6자리를 입력해주세요">
						</div>
					</li>
					<li>
						<label for="userPhone" class="label-text">변경할 휴대폰번호</label>
						<div class="input-phone-wrap flex-wrap">
							<input type="tel" name="phone" id="userPhone" class="input-text" value="${manager.phone}" required="" autocomplete="tel" placeholder="휴대폰번호를 입력해주세요 (-)제외">
						</div>
					</li>

				</ul>
				<input type="hidden" name="configType" value="user">
				<div class="bt-modal-wrap">
					<input type="hidden" name="aid" value="${manager.aid}">
					<input type="hidden" name="userId" value="${manager.userId}">
					<input type="hidden" name="userPw" value="${manager.userPw}">
					<input type="hidden" name="academyName" value="${academyName}">
					<button type="submit" class="bt-label color-point">저장</button>
				</div>
			</form>
		</div>
	</div>
</body>

<script type="text/javascript" src="../resources/js/common.js"></script>

</html>
