<%@page import="org.apache.taglibs.standard.tag.common.xml.IfTag"%>
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

			<c:if test="${empty manager && ! empty ekauser}">
				<script>
					location.href = "main";
					alert("학원 원장이 아닙니다.");
				</script>
			</c:if>

			<c:if test="${empty manager && empty ekauser}">
				<script>
					location.href = "managerlogin";
					alert("학원 원장 로그인이 필요합니다.");
				</script>
			</c:if>
		</header>

		<a href="#wrap" class="bt-top hashLink">
			<img src="../resources/img/ic_arrow_up_24px.png" alt="맨위로"> <span>맨위로</span>
		</a>
		<a href="http://pf.kakao.com/_IxjQZxj/chat" class="bt-kakao" target="_blank">
			<img src="../resources/img/ic_kakao_24px.png" alt="카톡상담"> <span>문의</span>
		</a>
		<div id="customer-wrap" class="container">
			<!-- 학원신청 상단 시작 -->
			<div class="customer-top content">
				<h2>학원신청</h2>
				<div class="shadow-wrap tel-wrap">
					<a href="tel:053-1234-1234">
						<span>EKA 학원신청</span>053-1234-1234
					</a>
				</div>
			</div>
			<!-- 학원신청 상단 끝 -->
			<!-- 학원신청 내용 시작 -->
			<div class="customer-content content">
				<div class="shadow-wrap ">
					<h3>학원신청 양식</h3>
					<p>학원의 정보를 입력해주세요</p>
					<ul class="input-wrap">
						<form action="./select_academies_by_address" class="customer-form" method="POST">
							<li>
								<input class="bt-sub accent" type="button" onclick="sample5_execDaumPostcode()" value="주소 찾기">
								<input class="bt-sub green" type="submit" value="주소로 학원찾기">
								<br>
								<div class="flex-wrap">
									<input type="text" name="address" class="input-text" id="sample5_address" placeholder="주소" required>
								</div>
								<div id="map" style="width: 300px; height: 300px; margin-top: 10px; display: none"></div>
							</li>

						</form>


						<form action="./signed_eka_academy" class="customer-form" method="POST">
							<li>
								<label for="name" class="label-text">학원명</label>
								<input type="hidden" name="address" value="${address}">
								<div class="flex-wrap grid">
									<select class="selbox" name="name" required>
										<c:forEach var="academy" items="${academyList}">
											<option value="${academy.name}" selected>${academy.name}</option>
										</c:forEach>
									</select>
								</div>
							</li>
							<li>
								<label for="phone" class="label-text">전화번호</label>
								<div class="flex-wrap grid">
									<select class="selbox" name="phone1" required>
										<option value="" disabled selected>선택</option>
										<option value="010">010</option>
										<option value="02">02</option>
										<option value="053">053</option>
										<option value="direct">직접입력</option>
									</select>
									<input type="tel" name="phone1" class="inquiryPhone2 input-text" pattern="\d{3}">
									<input type="tel" name="phone2" class="inquiryPhone3 input-text" pattern="\d{4}" required>
									<input type="tel" name="phone3" class="inquiryPhone4 input-text" pattern="\d{4}" required>
								</div>
							</li>
							<li>
								<label for="inquiryEmail" class="label-text">이메일</label>
								<div class="flex-wrap">
									<input type="email" name="email" id="inquiryEmail" class="input-text" required="" placeholder="(@)를 포함해서 입력해주세요">
								</div>
							</li>


							<div class="flex-wrap grid justify"></div>



							<li>
								<label for="inquirySubject" class="label-text">학원 제공 서비스</label>
								<div class="flex-wrap subject">
									<div class="shadow-wrap big-r m1">
										<ul class="i-category">
											<li class="border-wrap toggleCheck">
												<img src="../resources/img/service/icons8-bus-64.png" alt="academyBus"> <span class="dragBlock">학원차량운행</span>
												<input type="checkbox" class="hidden2" name="service" value="학원차량운행">
											</li>
											<li class="border-wrap toggleCheck">
												<img src="../resources/img/service/icons8-air-conditioner-64.png" alt="academyAir-Con"> <span class="dragBlock">냉난방</span>
												<input type="checkbox" class="hidden2" name="service" value="냉난방">
											</li>
											<li class="border-wrap toggleCheck">
												<img src="../resources/img/service/icons8-air-purifier-64.png" alt="academyPurifier"> <span class="dragBlock">공기청정기</span>
												<input type="checkbox" class="hidden2" name="service" value="공기청정기">
											</li>
											<li class="border-wrap toggleCheck">
												<img src="../resources/img/service/icons8-desk-64.png" alt="academyStudyRoom"> <span class="dragBlock">자습실</span>
												<input type="checkbox" class="hidden2" name="service" value="자습실">
											</li>
											<li class="border-wrap toggleCheck">
												<img src="../resources/img/service/icons8-teacher-64.png" alt="academyPresidentTeach"> <span class="dragBlock">원장직강</span>
												<input type="checkbox" class="hidden2" name="service" value="원장직강">
											</li>
											<li class="border-wrap toggleCheck">
												<img src="../resources/img/service/icons8-locker-64.png" alt="academyLocker"> <span class="dragBlock">개인사물함</span>
												<input type="checkbox" class="hidden2" name="service" value="개인사물함">
											</li>
											<li class="border-wrap toggleCheck">
												<img src="../resources/img/service/icons8-snack-64.png" alt="academySnack"> <span class="dragBlock">간식제공</span>
												<input type="checkbox" class="hidden2" name="service" value="간식제공">
											</li>
											<li class="border-wrap toggleCheck">
												<img src="../resources/img/service/icons8-tutor-64.png" alt="academyTutor"> <span class="dragBlock">과외식</span>
												<input type="checkbox" class="hidden2" name="service" value="과외식">
											</li>
											<li class="border-wrap toggleCheck">
												<img src="../resources/img/service/icons8-projector-64.png" alt="academyProjector"> <span class="dragBlock">빔프로젝트</span>
												<input type="checkbox" class="hidden2" name="service" value="빔프로젝트">
											</li>
											<li class="border-wrap toggleCheck">
												<img src="../resources/img/service/icons8-foreigner-64.png" alt="academyForeigner"> <span class="dragBlock">원어민강사</span>
												<input type="checkbox" class="hidden2" name="service" value="원어민강사">
											</li>
											<li class="border-wrap toggleCheck">
												<img src="../resources/img/service/icons8-desk-64.png" alt="academyDesk"> <span class="dragBlock">독서실책상</span>
												<input type="checkbox" class="hidden2" name="service" value="독서실책상">
											</li>
											<li class="border-wrap toggleCheck">
												<img src="../resources/img/service/icons8-test-64.png" alt="academyTest"> <span class="dragBlock">자체모의고사</span>
												<input type="checkbox" class="hidden2" name="service" value="자체모의고사">
											</li>
											<li class="border-wrap toggleCheck">
												<img src="../resources/img/service/icons8-scholarship-64.png" alt="academyScholarship"> <span class="dragBlock">자체장학제도</span>
												<input type="checkbox" class="hidden2" name="service" value="자체장학제도">
											</li>
											<li class="border-wrap toggleCheck">
												<img src="../resources/img/service/icons8-online-learning-64.png" alt="academyE-Learning"> <span class="dragBlock">인터넷강의</span>
												<input type="checkbox" class="hidden2" name="service" value="인터넷강의">
											</li>
											<li class="border-wrap toggleCheck">
												<img src="../resources/img/service/icons8-attendance-64.png" alt="academyAttendance"> <span class="dragBlock">출결시스템</span>
												<input type="checkbox" class="hidden2" name="service" value="출결시스템">
											</li>
										</ul>
									</div>
								</div>
							</li>

							<li>
								<label for="inquiryMaDay" class="label-text">운영 요일</label>
								<div class="flex-wrap day">
									<div class="shadow-wrap big-r m1">
										<ul class="i-category">
											<li class="border-wrap toggleCheck">
												<span class="dragBlock">월</span>
												<input type="checkbox" name="runDay" value="월">
											</li>
											<li class="border-wrap toggleCheck">
												<span class="dragBlock">화</span>
												<input type="checkbox" name="runDay" value="화">
											</li>
											<li class="border-wrap toggleCheck">
												<span class="dragBlock">수</span>
												<input type="checkbox" name="runDay" value="수">
											</li>
											<li class="border-wrap toggleCheck">
												<span class="dragBlock">목</span>
												<input type="checkbox" name="runDay" value="목">
											</li>
											<li class="border-wrap toggleCheck">
												<span class="dragBlock">금</span>
												<input type="checkbox" name="runDay" value="금">
											</li>
											<li class="border-wrap toggleCheck">
												<span class="dragBlock">토</span>
												<input type="checkbox" name="runDay" value="토">
											</li>
											<li class="border-wrap toggleCheck">
												<span class="dragBlock">일</span>
												<input type="checkbox" name="runDay" value="일">
											</li>
										</ul>
									</div>
								</div>
							</li>

							<li>
								<label for="inquiryMaTime" class="label-text">운영 시간</label>
								<div class="flex-wrap time">
									<span class="item_inp"> <label class="lab_g">
											<span> <input type="radio" class="inp_g" value="single" name="maTimeCheck" checked>
											</span>모든 요일에 동일한 시간
										</label>
								</div>

								<div class="flex-wrap time grid single ma">
									<input type="time" name="startRunTime">
									<span> ~ </span>
									<input type="time" name="endRunTime">
								</div>
							</li>

							<li>
								<label for="inquiryCoDay" class="label-text">상담가능 요일</label>
								<div class="flex-wrap day">
									<div class="shadow-wrap big-r m1">
										<ul class="i-category">
											<li class="border-wrap toggleCheck">
												<span class="dragBlock">월</span>
												<input type="checkbox" name="coDay" value="월">
											</li>
											<li class="border-wrap toggleCheck">
												<span class="dragBlock">화</span>
												<input type="checkbox" name="coDay" value="화">
											</li>
											<li class="border-wrap toggleCheck">
												<span class="dragBlock">수</span>
												<input type="checkbox" name="coDay" value="수">
											</li>
											<li class="border-wrap toggleCheck">
												<span class="dragBlock">목</span>
												<input type="checkbox" name="coDay" value="목">
											</li>
											<li class="border-wrap toggleCheck">
												<span class="dragBlock">금</span>
												<input type="checkbox" name="coDay" value="금">
											</li>
											<li class="border-wrap toggleCheck">
												<span class="dragBlock">토</span>
												<input type="checkbox" name="coDay" value="토">
											</li>
											<li class="border-wrap toggleCheck">
												<span class="dragBlock">일</span>
												<input type="checkbox" name="coDay" value="일">
											</li>
										</ul>
									</div>
								</div>
							</li>

							<li>
								<label for="inquiryCoTime" class="label-text">상담가능 시간</label>
								<div class="flex-wrap time">
									<span class="item_inp"> <label class="lab_g">
											<span> <input type="radio" class="inp_g" value="single" name="coTimeCheck" checked>
											</span>모든 요일에 동일한 시간
										</label>
								</div>

								<div class="flex-wrap time grid single co">
									<input type="time" name="startCoTime">
									<span> ~ </span>
									<input type="time" name="endCoTime">
								</div>
							</li>

							<li>
								<label for="inquiryMemo" class="label-text">소개글</label>
								<div class="flex-wrap">
									<textarea name="introduction" id="inquiryMemo" cols="30" rows="10" class="input-text" required="" placeholder="내용을 입력해주세요"></textarea>
								</div>
							</li>
					</ul>
					<button type="submit" class="bt-sub point">보내기</button>
					</form>
				</div>
			</div>
			<!-- 학원신청 내용 끝 -->
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
							<a href="tel:053-1234-1234">학원신청 053-1234-1234</a>
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

<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="//dapi.kakao.com/v2/maps/sdk.js?appkey=fc2120b8ad3fcff0b18376b88b35a6f5&libraries=services"></script>
<script type="text/javascript" src="../resources/js/common.js"></script>
<script>
	$(function() {
		//직접입력 인풋박스 기존에는 숨어있다가
		$(".inquiryPhone2").hide();
		$(".selbox").change(function() {

			//직접입력을 누를 때 나타남
			if ($(".selbox").val() == "direct") {
				$(".inquiryPhone2").show().attr("required", true);
			} else {
				$(".inquiryPhone2").hide().attr("required", false);
			}
		})

		//과목 체크
		$('.toggleCheck').click(
				function() {
					$(this).toggleClass('checked').find('input:checkbox').prop(
							'checked', function() {
								return !$(this).prop('checked');
							});
				});

		$("input[name='coTimeCheck']").change(function() {
			var test = $("input[name='coTimeCheck']:checked").val();

			if (test == "single") {
				$('.time.grid.single.co').removeClass('hidden2');
				$('.time.grid.week.co').addClass('hidden2');
			} else {
				$('.time.grid.week.co').removeClass('hidden2');
				$('.time.grid.single.co').addClass('hidden2');
			}
		});

		$("input[name='maTimeCheck']").change(function() {
			var test = $("input[name='maTimeCheck']:checked").val();

			if (test == "single") {
				$('.time.grid.single.ma').removeClass('hidden2');
				$('.time.grid.week.ma').addClass('hidden2');
			} else {
				$('.time.grid.week.ma').removeClass('hidden2');
				$('.time.grid.single.ma').addClass('hidden2');
			}
		});

	})

	var mapContainer = document.getElementById('map'), // 지도를 표시할 div
	mapOption = {
		center : new daum.maps.LatLng(37.537187, 127.005476), // 지도의 중심좌표
		level : 5
	// 지도의 확대 레벨
	};

	//지도를 미리 생성
	var map = new daum.maps.Map(mapContainer, mapOption);
	//주소-좌표 변환 객체를 생성
	var geocoder = new daum.maps.services.Geocoder();
	//마커를 미리 생성
	var marker = new daum.maps.Marker({
		position : new daum.maps.LatLng(37.537187, 127.005476),
		map : map
	});

	function sample5_execDaumPostcode() {
		new daum.Postcode({
			oncomplete : function(data) {
				var addr = data.address; // 최종 주소 변수

				// 주소 정보를 해당 필드에 넣는다.
				document.getElementById("sample5_address").value = addr;
				// 주소로 상세 정보를 검색
				geocoder.addressSearch(data.address, function(results, status) {
					// 정상적으로 검색이 완료됐으면
					if (status === daum.maps.services.Status.OK) {

						var result = results[0]; //첫번째 결과의 값을 활용

						// 해당 주소에 대한 좌표를 받아서
						var coords = new daum.maps.LatLng(result.y, result.x);
						// 지도를 보여준다.
						mapContainer.style.display = "block";
						map.relayout();
						// 지도 중심을 변경한다.
						map.setCenter(coords);
						// 마커를 결과값으로 받은 위치로 옮긴다.
						marker.setPosition(coords)
					}
				});
			}
		}).open();
	}
</script>

</html>
