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

		<div id="academy-search-wrap" class="container">
			<!-- 학원 검색 상단 시작 -->
			<div class="academy-search-top content">
				<h2>학원검색</h2>
				<form action="find_academy" method="post">
					<div class="shadow-wrap academy-search-form">
						<p class="search-word">
							<span class="color-accent">'${keyword}'</span> 검색결과
						</p>
						<p class="search-total">
							총 <span class="color-accent">'${fn:length(allNameList)}'</span> 개의 검색결과가 있습니다.
						</p>

						<div class="flex-wrap flex-center">
							<input type="hidden" id="findLat" name="lat" value="${user_lat}">
							<input type="hidden" id="findLon" name="lon" value="${user_lon}">
							<input type="search" class="input-text" name="keyword" placeholder="학원명을 입력주세요." required="">
							<button type="submit" class="bt-sub green ic-search mgl-12">검색하기</button>
						</div>
					</div>
				</form>
			</div>
			<!-- 학원 검색 상단 끝 -->

			<!-- 학원 검색 내용 시작 -->
			<div class="academy-search-content">
				<div class="academy-search-list">
					<div class="list-sky" data-color="point"></div>
					<div class="list-1st" data-color="accent"></div>
					<div class="list-default">
						<h3 class="content">일반학원</h3>
						<ul>
							<c:forEach var="name" items="${allNameList}" varStatus="status">
								<li class="list-item" data-uaid="80999">
									<a href="#">
										<div class="item-logo">
											<img src="../resources/img/i_eka_empty.png">
										</div>
										<div class="item-content">
											<button class="bt-like float-right" data-uaid="80999" data-like="0"></button>
											<div>
												<span class="a-title">${name}</span><span class="a-distance hide-overlay"><fmt:formatNumber value="${distanceList[status.index]}" pattern="0.0"/>km</span>
											</div>
											<div>
												<span class="a-review-rating"> <c:if test="${!empty averageScoreList[status.index]}">
														${averageScoreList[status.index]}
													</c:if> <c:if test="${empty averageScoreList[status.index]}">
														0.0
													</c:if>
												</span> <span class="a-review-count">리뷰 : ${reviewNumList[status.index]}개</span>
											</div>
											<div class="show-overlay">
												<span class="a-addr-default">${allAddressList[status.index]}</span><span class="a-addr-detail">${allDetailAddressList[status.index]}</span>
											</div>
											<form action="detail_page" method="post">
												<input type="hidden" name="academyAid" value="${allAidList[status.index]}" />
												<input type="submit" class="bt-sub green" value="상세페이지" />
											</form>
										</div>
									</a>
								</li>
							</c:forEach>
						</ul>
					</div>
					<div class="list-empty" style="display: none;">
						<h3 class="content text-center">검색된 학원이 없습니다.</h3>
					</div>
				</div>
			</div>
			<!-- 학원 검색 내용 끝 -->
		</div>

		<%@ include file="common/footer.jsp"%>
	</div>

	<script type="text/javascript" src="../resources/js/common.js"></script>
	<script>
		
	</script>
</body>

</html>
