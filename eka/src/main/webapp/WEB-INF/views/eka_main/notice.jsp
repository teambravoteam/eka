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
		<div id="board-list-wrap" class="container">
			<!-- 게시물 리스트 상단 시작 -->
			<div class="board-list-top content">
				<h2 class="circle-point">eka 공지사항</h2>
			</div>
			<!-- 게시물 리스트 상단 끝 -->

			<!-- 게시물 리스트 내용 시작 -->
			<div class="board-list-content">
				<ul class="board-list">
					<li>
						<a href="#" class="content">
							<div class="board-title">
								<span class="circle">안녕하세요, 저희는 코리아IT Bravo 팀입니다.</span>
							</div>
							<div class="board-date">
								<span>2022-08-12</span>
							</div>
						</a>
					</li>
					<li>
						<a href="#" class="content">
							<div class="board-title">
								<span class="circle">저희가 이번에 구현하게 된 프로젝트의 컨셉은</span>
							</div>
							<div class="board-date">
								<span>2022-08-12</span>
							</div>
						</a>
					</li>
					<li>
						<a href="#" class="content">
							<div class="board-title">
								<span class="circle">언텍트 사회에서의 IT 관리의 필요성과 프로그램이 없는 학원을 대상으로 한 관리 프로그램 제공입니다.</span>
							</div>
							<div class="board-date">
								<span>2022-08-12</span>
							</div>
						</a>
					</li>
					<li>
						<a href="#" class="content">
							<div class="board-title">
								<span class="circle">주요 기능을 설명하겠습니다.</span>
							</div>
							<div class="board-date">
								<span>2022-08-12</span>
							</div>
						</a>
					</li>

					<li>
						<a href="#" class="content">
							<div class="board-title">
								<span class="circle">저희만의 학원 데이터베이스를 기반으로 대구 시의 학원을 전부 찾을 수 있고,</span>
							</div>
							<div class="board-date">
								<span>2022-08-12</span>
							</div>
						</a>
					</li>
					<li>
						<a href="#" class="content">
							<div class="board-title">
								<span class="circle">회원가입을 통해 EKA 유저는 학원을 등록하고, 원장은 학원을 신청할 수 있는 기능이 있습니다.</span>
							</div>
							<div class="board-date">
								<span>2022-08-12</span>
							</div>
						</a>
					</li>
					<li>
						<a href="#" class="content">
							<div class="board-title">
								<span class="circle">또한, 신청한 정보를 토대로 등록한 학원의 관리를 시작할 수 있으며,</span>
							</div>
							<div class="board-date">
								<span>2022-08-12</span>
							</div>
						</a>
					</li>
					<li>
						<a href="#" class="content">
							<div class="board-title">
								<span class="circle">학원 관리 페이지를 통해 학원의 과목/강사/점수/출석/상담/리뷰/학생 등을 관리할 수 있습니다.</span>
							</div>
							<div class="board-date">
								<span>2022-08-12</span>
							</div>
						</a>
					</li>
					<li>
						<a href="#" class="content">
							<div class="board-title">
								<span class="circle">감사합니다 :)</span>
							</div>
							<div class="board-date">
								<span>2022-08-12</span>
							</div>
						</a>
					</li>
					<li>
						<a href="https://github.com/teambravoteam/eka" class="content">
							<div class="board-title">
								<span class="circle">GitHub : https://github.com/teambravoteam/eka</span>
							</div>
							<div class="board-date">
								<span>2022-08-12</span>
							</div>
						</a>
					</li>
				</ul>
			</div>
			<!-- 게시물 리스트 내용 끝 -->

			<!-- 게시물 리스트 하단 시작 -->
			<div class="board-list-bottom content">
				<ul class="pagination">
					<li class="page-item">
						<a href="#" class="page-link current">1</a>
					</li>
				</ul>
			</div>
			<!-- 게시물 리스트 하단 끝 -->
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
