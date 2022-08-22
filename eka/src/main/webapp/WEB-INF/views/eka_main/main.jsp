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
		<header id="header" role="navigation" class="main">
			<nav class="header-wrap">
				<ul>
					<li><a href="main" class="header-logo">
							<h1>eka</h1>
						</a></li>
					<li class="hide-m"><a href="notice" class="header-nav">공지사항</a></li>
					<li class="hide-m"><a href="add_academy" class="header-nav">학원신청</a></li>
				</ul>
				<ul class="hide-m">
					<a href='<c:url value="/eka_main/managerlogin"/>' class="header-nav">로그인</a>
					<a href='<c:url value="/eka_main/register_main"/>' class="bt-sub point">회원가입</a>
				</ul>
				<ul class="show-m">
					<li><button class="header-menu" title="메뉴">
							<span></span>
						</button></li>
				</ul>
			</nav>
			<nav class="show-m header-side">
				<ul class="gnb point">
					<div class="join-guide">
						<a href="#">
							<h4>회원가입</h4>
							<p>
								지금 회원가입하면<br> 5,000 포인트 지급!
							</p>
						</a>
					</div>
					<li><a href="#">로그인</a></li>
					<li><a href="notice">공지사항</a></li>
					<li><a href="add_academy">학원신청</a></li>
				</ul>
			</nav>

			<script>
				(function() {
					var nowPage = location.href.split('?')[0];
					var navTarget = $(".gnb a[href='" + nowPage + "']")
							.parent().addClass("current");
					var navParent = navTarget.parent();
					if (navParent.hasClass("depth2")) {
						navParent.show().parent().addClass("current");
					}
					if (navParent.hasClass("depth3")) {
						navParent.show().parent().addClass("current").parent()
								.show().parent().addClass("current");
					}
				})();
			</script>
		</header>


		<a href="#wrap" class="bt-top hashLink">
			<img src="../resources/img/ic_arrow_up_24px.png" alt="맨위로"> <span>맨위로</span>
		</a>
		<a href="http://pf.kakao.com/_IxjQZxj/chat" class="bt-kakao" target="_blank">
			<img src="../resources/img/ic_kakao_24px.png" alt="카톡상담"> <span>문의</span>
		</a>
		<div id="i-main">
			<div class="container">
				<section class="content">
					<div class="main-logo dragBlock">
						<h1 data-aos="fade-right" class="aos-init">eka</h1>
						<h2 data-aos="fade-right" class="aos-init">모두의 학원</h2>
					</div>
					<form action="./list_academy" method="post">
						<div class="shadow-wrap big-r flex-wrap flex-center m1 aos-init aos-animate" data-aos="fade-up" data-aos-delay="200">
							<div class="userAddr-wrap flex-glow-1">
								<span class="guide">현재 검색위치</span> <label for="bt-config-loc" class="userAddr">대구광역시 중구 국채보상로 670</label>
							</div>
							<button type="button" id="bt-config-loc" class="bt-sub point ic-gps mgl-12">현재위치 이동</button>
							<button type="button" id="bt-config-map" class="bt-sub accent ic-gps mgl-12">지도로 재설정</button>
							<input type="hidden" id="mainAddr" name="addr" value="대구광역시 중구 국채보상로 670">
							<input type="hidden" id="mainLat" name="lat" value="35.8582000811537">
							<input type="hidden" id="mainLon" name="lon" value="128.630629788584">
							<input type="hidden" id="mainCate" name="categoryNum" value="0">
							<input type="submit" class="bt-sub green ic-gps mgl-12" value="학원검색">
						</div>
						<div class="shadow-wrap big-r m1 aos-init" data-aos="fade-up" data-aos-delay="400">
							<ul class="i-category">
								<li class="border-wrap">
									<a href="./list_academy?category=국어">
										<input type="hidden" value="1">
										<span class="dragBlock">국어</span>
									</a>
								</li>
								<li class="border-wrap">
									<a href="./list_academy?category=영어">
										<input type="hidden" value="2">
										<span class="dragBlock">영어</span>
									</a>
								</li>
								<li class="border-wrap">
									<a href="./list_academy?category=수학">
										<input type="hidden" value="3">
										<span class="dragBlock">수학</span>
									</a>
								</li>
								<li class="border-wrap">
									<a href="./list_academy?category=사회">
										<input type="hidden" value="4">
										<span class="dragBlock">사회</span>
									</a>
								</li>
								<li class="border-wrap">
									<a href="./list_academy?category=과학">
										<input type="hidden" value="5">
										<span class="dragBlock">과학</span>
									</a>
								</li>
								<li class="border-wrap">
									<a href="./list_academy?category=한국사">
										<input type="hidden" value="6">
										<span class="dragBlock">한국사</span>
									</a>
								</li>
								<li class="border-wrap">
									<a href="./list_academy?category=미술">
										<input type="hidden" value="7">
										<span class="dragBlock">미술</span>
									</a>
								</li>
								<li class="border-wrap">
									<a href="./list_academy?category=음악">
										<input type="hidden" value="8">
										<span class="dragBlock">음악</span>
									</a>
								</li>
								<li class="border-wrap">
									<a href="./list_academy?category=체육">
										<input type="hidden" value="9">
										<span class="dragBlock">체육</span>
									</a>
								</li>
								<li class="border-wrap">
									<a href="./list_academy?category=디자인">
										<input type="hidden" value="10">
										<span class="dragBlock">디자인</span>
									</a>
								</li>
								<li class="border-wrap">
									<a href="./list_academy?category=일본어">
										<input type="hidden" value="11">
										<span class="dragBlock">일본어</span>
									</a>
								</li>
								<li class="border-wrap">
									<a href="./list_academy?category=중국어">
										<input type="hidden" value="12">
										<span class="dragBlock">중국어</span>
									</a>
								</li>
								<li class="border-wrap">
									<a href="./list_academy?category=제2외국어">
										<input type="hidden" value="13">
										<span class="dragBlock">제2외국어</span>
									</a>
								</li>
								<li class="border-wrap">
									<a href="./list_academy?category=IT">
										<input type="hidden" value="14">
										<span class="dragBlock">IT</span>
									</a>
								</li>
								<li class="border-wrap">
									<a href="./list_academy?category=토익/토플">
										<input type="hidden" value="15">
										<span class="dragBlock">토익/토플</span>
									</a>
								</li>
								<li class="border-wrap">
									<a href="./list_academy?category=자격증">
										<input type="hidden" value="16">
										<span class="dragBlock">자격증</span>
									</a>
								</li>
								<li class="border-wrap">
									<a href="./list_academy?category=재수">
										<input type="hidden" value="17">
										<span class="dragBlock">재수</span>
									</a>
								</li>
								<li class="border-wrap">
									<a href="./list_academy?category=종합">
										<input type="hidden" value="18">
										<span class="dragBlock">종합</span>
									</a>
								</li>
								<li class="border-wrap">
									<a href="./list_academy?category=기타">
										<input type="hidden" value="19">
										<span class="dragBlock">기타</span>
									</a>
								</li>
								<li class="border-wrap ready"><span class="ready dragBlock">준비중</span></li>
								<li class="border-wrap ready"><span class="ready dragBlock">준비중</span></li>
								<li class="border-wrap ready"><span class="ready dragBlock">준비중</span></li>
								<li class="border-wrap ready"><span class="ready dragBlock">준비중</span></li>
								<li class="border-wrap ready"><span class="ready dragBlock">준비중</span></li>
							</ul>
						</div>
					</form>
					<form action="./academySearch" method="get">
						<div class="shadow-wrap big-r flex-wrap flex-center m2">
							<input type="search" class="input-text" name="keyword" placeholder="학원명을 입력주세요." required="">
							<button type="submit" class="bt-sub accent ic-search mgl-12">검색하기</button>
						</div>
					</form>
				</section>
				<div class="m2">
					<div class="content">
						<h2 class="circle-point">주변 EKA 학원</h2>
					</div>
					<div class="swiper-container i-eka swiper-container-horizontal">
						<ul class="swiper-wrapper" style="transition-duration: 0ms; transform: translate3d(-3615px, 0px, 0px);">
							<li class="swiper-slide eka-card swiper-slide-duplicate" data-swiper-slide-index="0"></li>
							<li class="swiper-slide eka-card swiper-slide-duplicate" data-swiper-slide-index="1"></li>
							<li class="swiper-slide eka-card swiper-slide-duplicate" data-swiper-slide-index="2"></li>
							<li class="swiper-slide eka-card swiper-slide-duplicate" data-swiper-slide-index="3"></li>
							<li class="swiper-slide eka-card swiper-slide-duplicate" data-swiper-slide-index="4"></li>
							<li class="swiper-slide eka-card swiper-slide-duplicate swiper-slide-duplicate-prev" data-swiper-slide-index="5"></li>
							<li class="swiper-slide eka-card swiper-slide-duplicate swiper-slide-duplicate-active" data-swiper-slide-index="6"></li>
							<li class="swiper-slide eka-card swiper-slide-duplicate swiper-slide-duplicate-next" data-swiper-slide-index="7"></li>
							<li class="swiper-slide eka-card swiper-slide-duplicate" data-swiper-slide-index="8"></li>
							<li class="swiper-slide eka-card swiper-slide-duplicate" data-swiper-slide-index="9"></li>
							<li class="swiper-slide eka-card" data-swiper-slide-index="0"></li>
							<li class="swiper-slide eka-card" data-swiper-slide-index="1"></li>
							<li class="swiper-slide eka-card" data-swiper-slide-index="2"></li>
							<li class="swiper-slide eka-card" data-swiper-slide-index="3"></li>
							<li class="swiper-slide eka-card" data-swiper-slide-index="4"></li>
							<li class="swiper-slide eka-card swiper-slide-prev" data-swiper-slide-index="5"></li>
							<li class="swiper-slide eka-card swiper-slide-active" data-swiper-slide-index="6"></li>
							<li class="swiper-slide eka-card swiper-slide-next" data-swiper-slide-index="7"></li>
							<li class="swiper-slide eka-card" data-swiper-slide-index="8"></li>
							<li class="swiper-slide eka-card" data-swiper-slide-index="9"></li>
							<li class="swiper-slide eka-card swiper-slide-duplicate" data-swiper-slide-index="0"></li>
							<li class="swiper-slide eka-card swiper-slide-duplicate" data-swiper-slide-index="1"></li>
							<li class="swiper-slide eka-card swiper-slide-duplicate" data-swiper-slide-index="2"></li>
							<li class="swiper-slide eka-card swiper-slide-duplicate" data-swiper-slide-index="3"></li>
							<li class="swiper-slide eka-card swiper-slide-duplicate" data-swiper-slide-index="4"></li>
							<li class="swiper-slide eka-card swiper-slide-duplicate swiper-slide-duplicate-prev" data-swiper-slide-index="5"></li>
							<li class="swiper-slide eka-card swiper-slide-duplicate swiper-slide-duplicate-active" data-swiper-slide-index="6"></li>
							<li class="swiper-slide eka-card swiper-slide-duplicate swiper-slide-duplicate-next" data-swiper-slide-index="7"></li>
							<li class="swiper-slide eka-card swiper-slide-duplicate" data-swiper-slide-index="8"></li>
							<li class="swiper-slide eka-card swiper-slide-duplicate" data-swiper-slide-index="9"></li>
						</ul>
						<span class="swiper-notification" aria-live="assertive" aria-atomic="true"></span>
					</div>
				</div>
			</div>
		</div>
		<div id="i-board">
			<div class="container">
				<section class="m2">
					<div id="notice-title" class="content">
						<h2 class="circle-point">공지사항</h2>
					</div>
					<div id="notice-container">
						<ul class="notice-list">
							<li><a href="#" class="content">
									<div class="board-title">
										<span class="circle">공지 1</span>
									</div>
									<div class="board-date">
										<span>2022-08-12</span>
									</div>
								</a></li>
							<li><a href="#" class="content">
									<div class="board-title">
										<span class="circle">공지 2</span>
									</div>
									<div class="board-date">
										<span>2022-08-12</span>
									</div>
								</a></li>
							<li><a href="#" class="content">
									<div class="board-title">
										<span class="circle">공지 3</span>
									</div>
									<div class="board-date">
										<span>2022-08-12</span>
									</div>
								</a></li>

						</ul>
					</div>
				</section>
			</div>
		</div>
		<footer id="footer">
			<ul class="footer-wrap">
				<li><a href="#" class="footer-nav">이용약관</a></li>
				<li><a href="#" class="footer-nav color-point">개인정보처리방침</a></li>
			</ul>
			<div class="container">
				<section class="content">
					<h1 class="skip">사이트 이용정보</h1>
					<ul class="footer-company">
						<li>EKA</li>
						<li>팀 브라보</li>
						<li><a href="tel:053-1234-1234">고객센터 053-1234-1234</a></li>
						<li><a href="mailto:bravoTeam@bravoTeam.co.kr">이메일 bravoTeam@bravoTeam.co.kr</a></li>
						<li>대구광역시 중구 반월당</li>
					</ul>
				</section>
			</div>
		</footer>
	</div>

	<div id="modal-wrap" class="modal-wrap" style="display: hidden;">
		<div class="modal-head">
			<button type="button" class="bt-icon close float-right">닫기</button>
			<h3 class="modal-title">검색위치 설정</h3>
			<span class="modal-guide">* 주소검색 또는 지도를 클릭해서 설정할 수 있습니다.</span>
		</div>
		<div class="modal-body">
			<form action="" method="post">
				<div class="flex-wrap flex-center">
					<input hidden="hidden" />
					<input type="text" id="searchText" class="input-text search" name="searchText" placeholder="주소를 입력해주세요.">
					<button type="button" id="searchCusAddr" class="bt-sub accent ic-search mgl-8">주소검색</button>
					<button type="button" id="searchCusLoc" class="bt-sub point ic-gps mgl-12">내위치</button>
				</div>
			</form>

			<div id="config-map"></div>
			<div class="bt-location-wrap">
				<button type="button" class="bt-main point">저장</button>
			</div>
		</div>
	</div>
	</div>

	<script type="text/javascript" src="../resources/js/common.js"></script>
	<script>
		/* main layout init */
		$("#header").addClass("main");
		$(window).scroll(function() {
			scrollPos = this.scrollY || window.pageYOffset;
			if (scrollPos > 0) {
				$("#header").addClass("scrolled");
			} else {
				$("#header").removeClass("scrolled");
			}
		});
		var swiper = new Swiper('.i-eka', {
			slidesPerView : 'auto',
			centeredSlides : true,
			loop : true,
			autoplay : {
				delay : 3000,
				disableOnInteraction : false,
			}
		});

		$(".border-wrap").mouseenter(function() {
			$("#mainCate").val($(this).find("input").val());
		});

		$(".border-wrap").mouseleave(function() {
			$("#mainCate").val("0");
		});

	</script>
</body>

</html>
