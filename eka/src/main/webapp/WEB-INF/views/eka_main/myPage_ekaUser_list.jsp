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
						<div>
							<button class="bt-sub yellowgreen" data="${status.index}">리뷰 관리</button>
						</div>
						<div>
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
								<input type="hidden" name="ekauserId" value="${ekauser.userId}" />
								<input type="hidden" name="academyAid" value="${academyIdList[status.index]}" />
								<input type="submit" class="ui-button ui-corner-all ui-widget" value="리뷰 작성" formaction="add_review"/>
								<input type="submit" class="ui-button ui-corner-all ui-widget" value="리뷰 조회" formaction="find_review"/>
							</form>
						</li>
					</ul>
				</c:forEach>
			</div>
		</div>

		<%@ include file="common/footer.jsp"%>
	</div>
</body>

<script type="text/javascript" src="../resources/js/common.js"></script>
<script type="text/javascript">
$(function(){
	$(".bt-sub.yellowgreen").click(function() {
		console.log("버튼 누름!");
		var index = $(this).attr("data");
		$(this).parents(".review_div").find(".shadow-wrap.review."+index+"").toggleClass("hidden3");
	})
});
</script>

</html>
