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
			<%@ include file="common/header.jsp"%>

		</header>

		<a href="#wrap" class="bt-top hashLink">
			<img src="../resources/img/ic_arrow_up_24px.png" alt="?????????"> <span>?????????</span>
		</a>
		<a href="http://pf.kakao.com/_IxjQZxj/chat" class="bt-kakao" target="_blank">
			<img src="../resources/img/ic_kakao_24px.png" alt="????????????"> <span>??????</span>
		</a>
		<div id="i-main">
			<div class="container">
				<section class="content">
					<div class="main-logo dragBlock">
						<h1 data-aos="fade-right" class="aos-init">eka</h1>
						<h2 data-aos="fade-right" class="aos-init">????????? ??????</h2>
					</div>
					<form action="./list_academy" method="post" id="mainSubmit">
						<div class="shadow-wrap big-r flex-wrap flex-center m1 aos-init aos-animate" data-aos="fade-up" data-aos-delay="200">
							<div class="userAddr-wrap flex-glow-1">
								<span class="guide">?????? ????????????</span>
								<label for="bt-config-loc" class="userAddr">??????????????? ?????? ??????????????? 670</label>
							</div>
							<button type="button" id="bt-config-loc" class="bt-sub point ic-gps mgl-12">???????????? ??????</button>
							<button type="button" id="bt-config-map" class="bt-sub accent ic-map mgl-12">?????? ??????</button>
							<input type="hidden" id="mainAddr" name="addr" value="??????????????? ?????? ??????????????? 670">
							<input type="hidden" id="mainLat" name="lat" value="35.8582000811537">
							<input type="hidden" id="mainLon" name="lon" value="128.630629788584">
							<input type="hidden" id="mainCate" name="categoryNum" value="0">
							<input type="submit" class="bt-sub green ic-search mgl-12" value="?????? ????????????">
						</div>
						<div class="shadow-wrap big-r m1 aos-init" data-aos="fade-up" data-aos-delay="400">
							<ul class="i-category">
								<li class="border-wrap">
									<a href="#" onclick="document.getElementById('mainSubmit').submit();">
										<input type="hidden" value="1">
										<span class="dragBlock">??????????????????</span>
									</a>
								</li>
								<li class="border-wrap">
									<a href="#" onclick="document.getElementById('mainSubmit').submit();">
										<input type="hidden" value="2">
										<span class="dragBlock">????????????????????</span>
									</a>
								</li>
								<li class="border-wrap">
									<a href="#" onclick="document.getElementById('mainSubmit').submit();">
										<input type="hidden" value="3">
										<span class="dragBlock">??????</span>
									</a>
								</li>
								<li class="border-wrap">
									<a href="#" onclick="document.getElementById('mainSubmit').submit();">
										<input type="hidden" value="4">
										<span class="dragBlock">??????</span>
									</a>
								</li>
								<li class="border-wrap">
									<a href="#" onclick="document.getElementById('mainSubmit').submit();">
										<input type="hidden" value="5">
										<span class="dragBlock">??????</span>
									</a>
								</li>
								<li class="border-wrap">
									<a href="#" onclick="document.getElementById('mainSubmit').submit();">
										<input type="hidden" value="6">
										<span class="dragBlock">?????????</span>
									</a>
								</li>
								<li class="border-wrap">
									<a href="#" onclick="document.getElementById('mainSubmit').submit();">
										<input type="hidden" value="7">
										<span class="dragBlock">?????????(?????????)</span>
									</a>
								</li>
								<li class="border-wrap">
									<a href="#" onclick="document.getElementById('mainSubmit').submit();">
										<input type="hidden" value="8">
										<span class="dragBlock">????????????</span>
									</a>
								</li>
								<li class="border-wrap">
									<a href="#" onclick="document.getElementById('mainSubmit').submit();">
										<input type="hidden" value="9">
										<span class="dragBlock">??????????????????</span>
									</a>
								</li>
								<li class="border-wrap">
									<a href="#" onclick="document.getElementById('mainSubmit').submit();">
										<input type="hidden" value="10">
										<span class="dragBlock">???????????????</span>
									</a>
								</li>
								<li class="border-wrap">
									<a href="#" onclick="document.getElementById('mainSubmit').submit();">
										<input type="hidden" value="11">
										<span class="dragBlock">??????????????????</span>
									</a>
								</li>
								<li class="border-wrap">
									<a href="#" onclick="document.getElementById('mainSubmit').submit();">
										<input type="hidden" value="12">
										<span class="dragBlock">??????</span>
									</a>
								</li>
								<li class="border-wrap">
									<a href="#" onclick="document.getElementById('mainSubmit').submit();">
										<input type="hidden" value="13">
										<span class="dragBlock">?????????</span>
									</a>
								</li>
								<li class="border-wrap">
									<a href="#" onclick="document.getElementById('mainSubmit').submit();">
										<input type="hidden" value="14">
										<span class="dragBlock">????????????</span>
									</a>
								</li>
								<li class="border-wrap">
									<a href="#" onclick="document.getElementById('mainSubmit').submit();">
										<input type="hidden" value="15">
										<span class="dragBlock">???????????????</span>
									</a>
								</li>
								<li class="border-wrap">
									<a href="#" onclick="document.getElementById('mainSubmit').submit();">
										<input type="hidden" value="16">
										<span class="dragBlock">????????????</span>
									</a>
								</li>
								<li class="border-wrap">
									<a href="#" onclick="document.getElementById('mainSubmit').submit();">
										<input type="hidden" value="17">
										<span class="dragBlock">?????????</span>
									</a>
								</li>
								<li class="border-wrap ready">
									<span class="ready dragBlock">?????????</span>
								</li>
								<li class="border-wrap ready">
									<span class="ready dragBlock">?????????</span>
								</li>
								<li class="border-wrap ready">
									<span class="ready dragBlock">?????????</span>
								</li>
								<li class="border-wrap ready">
									<span class="ready dragBlock">?????????</span>
								</li>
								<li class="border-wrap ready">
									<span class="ready dragBlock">?????????</span>
								</li>
								<li class="border-wrap ready">
									<span class="ready dragBlock">?????????</span>
								</li>
								<li class="border-wrap ready">
									<span class="ready dragBlock">?????????</span>
								</li>
							</ul>
						</div>
					</form>
					<form action="find_academy" method="post">
						<div class="shadow-wrap big-r flex-wrap flex-center m2">
							<input type="hidden" id="findLat" name="lat" value="">
							<input type="hidden" id="findLon" name="lon" value="">
							<input type="search" class="input-text" name="keyword" placeholder="???????????? ???????????????." required="">
							<button type="submit" class="bt-sub green ic-search mgl-12">????????????</button>
						</div>
					</form>
				</section>
				<div class="m2">
					<div class="content">
						<h2 class="circle-point">?????? EKA ??????</h2>
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
						<h2 class="circle-point">????????????</h2>
					</div>
					<div id="notice-container">
						<ul class="notice-list">
							<li>
								<a href="#" class="content">
									<div class="board-title">
										<span class="circle">?????? 1</span>
									</div>
									<div class="board-date">
										<span>2022-08-12</span>
									</div>
								</a>
							</li>
							<li>
								<a href="#" class="content">
									<div class="board-title">
										<span class="circle">?????? 2</span>
									</div>
									<div class="board-date">
										<span>2022-08-12</span>
									</div>
								</a>
							</li>
							<li>
								<a href="#" class="content">
									<div class="board-title">
										<span class="circle">?????? 3</span>
									</div>
									<div class="board-date">
										<span>2022-08-12</span>
									</div>
								</a>
							</li>

						</ul>
					</div>
				</section>
			</div>
		</div>

		<%@ include file="common/footer.jsp"%>
	</div>

	<div id="modal-wrap" class="modal-wrap" style="display: hidden;">
		<div class="modal-head">
			<button type="button" class="bt-icon close float-right">??????</button>
			<h3 class="modal-title">???????????? ??????</h3>
			<span class="modal-guide">* ???????????? ?????? ????????? ???????????? ????????? ??? ????????????.</span>
		</div>
		<div class="modal-body">
			<form action="" method="post">
				<div class="flex-wrap flex-center">
					<input type="text" id="searchText" class="input-text search" name="searchText" placeholder="????????? ??????????????????.">
					<button type="button" id="searchCusAddr" class="bt-sub green ic-search mgl-8">????????????</button>
					<button type="button" id="searchCusLoc" class="bt-sub point ic-gps mgl-12">?????????</button>
				</div>
			</form>

			<div id="config-map"></div>
			<div class="bt-location-wrap">
				<button type="button" class="bt-main point">??????</button>
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

		setTimeout(function() {
			$('#bt-config-loc').trigger('click');
		}, 500)
	</script>
</body>

</html>
