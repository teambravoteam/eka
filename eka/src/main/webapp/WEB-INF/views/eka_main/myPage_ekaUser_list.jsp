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
					<li>
						<form action="myPage" method="post">
							<input type="hidden" name="ekauserId" value="${ekauser.userId}" />
							<input type="submit" class="a-title" value="내 정보" />
						</form>
					</li>
					<li class="current">
						<form action="ekaUser_list" method="post">
							<input type="hidden" name="ekauserEid" value="${ekauser.eid}" />
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
			<div class="content flex-glow-1 review_div">
				<c:forEach var="academy" items="${academyNameList}" varStatus="status">
					<div class="shadow-wrap ekaUser">
						<div>${academy}</div>
						<div class="text-right">
							<button class="bt-sub yellowgreen" data="${status.index}">리뷰</button>
						</div>
						<div class="text-center">
							<form action="detail_page" method="get">
								<input type="hidden" name="academyAid" value="${academyIdList[status.index]}" />
								<input type="submit" class="bt-sub green" value="상세페이지" />
							</form>
						</div>
					</div>
					<ul class="shadow-wrap review ${status.index} hidden3">
						<li>
							<form method="post">
								<input type="text" name="reviewCotent" value="" />
								<select name="reviewScore">
									<option value="5" selected>5점</option>
									<option value="4">4점</option>
									<option value="3">3점</option>
									<option value="2">2점</option>
									<option value="1">1점</option>
								</select>
								<input type="hidden" name="ekauserId" value="${ekauser.userId}" />
								<input type="hidden" name="ekauserEid" value="${ekauser.eid}" />
								<input type="hidden" name="academyAid" value="${academyIdList[status.index]}" />
								<input type="submit" class="ui-button ui-corner-all ui-widget" value="리뷰 작성" formaction="add_review" />
							</form>
						</li>
					</ul>
				</c:forEach>
				<button type="button" class="ui-button ui-corner-all ui-widget float-right" id="bt-modify-user">리뷰 관리</button>

				<script>
					$("#bt-modify-user").on("click", function() {
						$("#modal-wrap").css('display', 'block');
						$("#wrap").addClass('transparent');
					});
				</script>
			</div>
		</div>

		<%@ include file="common/footer.jsp"%>
	</div>

	<div id="modal-wrap" class="modal-wrap width-s" style="display: none; max-width: 1000px;">
		<div class="modal-head">
			<button type="button" class="bt-icon close float-right">닫기</button>
			<h3 class="modal-title">리뷰 관리</h3>
			<span class="modal-guide" style="display: none;"></span>
		</div>
		<div class="modal-body">
			<ul class="input-wrap">
				<c:forEach var="reviewRid" items="${reviewRidList}" varStatus="status">
					<form method="post">
						<li>
							<div class="flex-wrap grid_33">
								<div class="flex-wrap grid_25">
									<input type="hidden" value="${reviewRid}">
									<input type="hidden" value="${reviewAcademyIdList[status.index]}">
									<input type="text" class="review_title" value="${reviewAcademyNameList[status.index]}" readonly="readonly">
									<input type="text" class="review_comment" value="${reviewCommentList[status.index]}" required="required">
									<input type="hidden" class="review_score" value="${reviewScoreList[status.index]}" required="required">
									<input type="text" class="review_regDate" value="${reviewRegDateList[status.index]}" readonly="readonly">
								</div>
								<input type="submit" class="input-text review-btn" value="수정" formaction="add_review">
								<input type="submit" class="input-text review-btn" value="삭제" formaction="update_Review">
							</div>
						</li>
					</form>
				</c:forEach>
			</ul>
			<input type="hidden" name="configType" value="user">
			<div class="bt-modal-wrap">
				<input type="hidden" name="aid" value="${manager.aid}">
				<input type="hidden" name="userId" value="${manager.userId}">
				<input type="hidden" name="userPw" value="${manager.userPw}">
				<input type="hidden" name="academyName" value="${academyNameList}">
				<button type="submit" class="bt-label color-point">저장</button>
			</div>
		</div>
	</div>
</body>

<script type="text/javascript" src="../resources/js/common.js"></script>
<script type="text/javascript">
	$(function() {
		$(".bt-sub.yellowgreen").click(
				function() {
					console.log("버튼 누름!");
					var index = $(this).attr("data");
					$(this).parents(".review_div").find(
							".shadow-wrap.review." + index + "").toggleClass(
							"hidden3");
				})
	});
</script>

</html>
