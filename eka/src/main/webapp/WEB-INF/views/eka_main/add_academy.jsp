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
					alert("?????? ????????? ????????????.");
				</script>
			</c:if>

			<c:if test="${empty manager && empty ekauser}">
				<script>
					location.href = "managerlogin";
					alert("?????? ?????? ???????????? ???????????????.");
				</script>
			</c:if>
		</header>

		<a href="#wrap" class="bt-top hashLink">
			<img src="../resources/img/ic_arrow_up_24px.png" alt="?????????"> <span>?????????</span>
		</a>
		<a href="http://pf.kakao.com/_IxjQZxj/chat" class="bt-kakao" target="_blank">
			<img src="../resources/img/ic_kakao_24px.png" alt="????????????"> <span>??????</span>
		</a>
		<div id="customer-wrap" class="container">
			<!-- ???????????? ?????? ?????? -->
			<div class="customer-top content">
				<h2>????????????</h2>
				<div class="shadow-wrap tel-wrap">
					<a href="tel:053-1234-1234">
						<span>EKA ????????????</span>053-1234-1234
					</a>
				</div>
			</div>
			<!-- ???????????? ?????? ??? -->
			<!-- ???????????? ?????? ?????? -->
			<div class="customer-content content">
				<div class="shadow-wrap ">
					<h3>???????????? ??????</h3>
					<p>????????? ????????? ??????????????????</p>
					<ul class="input-wrap">
						<form action="./select_academies_by_address" class="customer-form" method="POST">
							<li>
								<input class="bt-sub accent" type="button" onclick="sample5_execDaumPostcode()" value="?????? ??????">
								<input class="bt-sub green" type="submit" value="????????? ????????????">
								<br>
								<div class="flex-wrap">
									<input type="text" name="address" class="input-text" id="sample5_address" placeholder="??????" required>
								</div>
								<div id="map" style="width: 300px; height: 300px; margin-top: 10px; display: none"></div>
							</li>

						</form>


						<form action="./signed_eka_academy" class="customer-form" method="POST">
							<li>
								<label for="name" class="label-text">?????????</label>
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
								<label for="phone" class="label-text">????????????</label>
								<div class="flex-wrap grid">
									<select class="selbox" name="phone1" required>
										<option value="" disabled selected>??????</option>
										<option value="010">010</option>
										<option value="02">02</option>
										<option value="053">053</option>
										<option value="direct">????????????</option>
									</select>
									<input type="tel" name="phone1" class="inquiryPhone2 input-text" pattern="\d{3}">
									<input type="tel" name="phone2" class="inquiryPhone3 input-text" pattern="\d{4}" required>
									<input type="tel" name="phone3" class="inquiryPhone4 input-text" pattern="\d{4}" required>
								</div>
							</li>
							<li>
								<label for="inquiryEmail" class="label-text">?????????</label>
								<div class="flex-wrap">
									<input type="email" name="email" id="inquiryEmail" class="input-text" required="" placeholder="(@)??? ???????????? ??????????????????">
								</div>
							</li>


							<div class="flex-wrap grid justify"></div>



							<li>
								<label for="inquirySubject" class="label-text">?????? ?????? ?????????</label>
								<div class="flex-wrap subject">
									<div class="shadow-wrap big-r m1">
										<ul class="i-category">
											<li class="border-wrap toggleCheck">
												<img src="../resources/img/service/icons8-bus-64.png" alt="academyBus"> <span class="dragBlock">??????????????????</span>
												<input type="checkbox" class="hidden2" name="service" value="??????????????????">
											</li>
											<li class="border-wrap toggleCheck">
												<img src="../resources/img/service/icons8-air-conditioner-64.png" alt="academyAir-Con"> <span class="dragBlock">?????????</span>
												<input type="checkbox" class="hidden2" name="service" value="?????????">
											</li>
											<li class="border-wrap toggleCheck">
												<img src="../resources/img/service/icons8-air-purifier-64.png" alt="academyPurifier"> <span class="dragBlock">???????????????</span>
												<input type="checkbox" class="hidden2" name="service" value="???????????????">
											</li>
											<li class="border-wrap toggleCheck">
												<img src="../resources/img/service/icons8-desk-64.png" alt="academyStudyRoom"> <span class="dragBlock">?????????</span>
												<input type="checkbox" class="hidden2" name="service" value="?????????">
											</li>
											<li class="border-wrap toggleCheck">
												<img src="../resources/img/service/icons8-teacher-64.png" alt="academyPresidentTeach"> <span class="dragBlock">????????????</span>
												<input type="checkbox" class="hidden2" name="service" value="????????????">
											</li>
											<li class="border-wrap toggleCheck">
												<img src="../resources/img/service/icons8-locker-64.png" alt="academyLocker"> <span class="dragBlock">???????????????</span>
												<input type="checkbox" class="hidden2" name="service" value="???????????????">
											</li>
											<li class="border-wrap toggleCheck">
												<img src="../resources/img/service/icons8-snack-64.png" alt="academySnack"> <span class="dragBlock">????????????</span>
												<input type="checkbox" class="hidden2" name="service" value="????????????">
											</li>
											<li class="border-wrap toggleCheck">
												<img src="../resources/img/service/icons8-tutor-64.png" alt="academyTutor"> <span class="dragBlock">?????????</span>
												<input type="checkbox" class="hidden2" name="service" value="?????????">
											</li>
											<li class="border-wrap toggleCheck">
												<img src="../resources/img/service/icons8-projector-64.png" alt="academyProjector"> <span class="dragBlock">???????????????</span>
												<input type="checkbox" class="hidden2" name="service" value="???????????????">
											</li>
											<li class="border-wrap toggleCheck">
												<img src="../resources/img/service/icons8-foreigner-64.png" alt="academyForeigner"> <span class="dragBlock">???????????????</span>
												<input type="checkbox" class="hidden2" name="service" value="???????????????">
											</li>
											<li class="border-wrap toggleCheck">
												<img src="../resources/img/service/icons8-desk-64.png" alt="academyDesk"> <span class="dragBlock">???????????????</span>
												<input type="checkbox" class="hidden2" name="service" value="???????????????">
											</li>
											<li class="border-wrap toggleCheck">
												<img src="../resources/img/service/icons8-test-64.png" alt="academyTest"> <span class="dragBlock">??????????????????</span>
												<input type="checkbox" class="hidden2" name="service" value="??????????????????">
											</li>
											<li class="border-wrap toggleCheck">
												<img src="../resources/img/service/icons8-scholarship-64.png" alt="academyScholarship"> <span class="dragBlock">??????????????????</span>
												<input type="checkbox" class="hidden2" name="service" value="??????????????????">
											</li>
											<li class="border-wrap toggleCheck">
												<img src="../resources/img/service/icons8-online-learning-64.png" alt="academyE-Learning"> <span class="dragBlock">???????????????</span>
												<input type="checkbox" class="hidden2" name="service" value="???????????????">
											</li>
											<li class="border-wrap toggleCheck">
												<img src="../resources/img/service/icons8-attendance-64.png" alt="academyAttendance"> <span class="dragBlock">???????????????</span>
												<input type="checkbox" class="hidden2" name="service" value="???????????????">
											</li>
										</ul>
									</div>
								</div>
							</li>

							<li>
								<label for="inquiryMaDay" class="label-text">?????? ??????</label>
								<div class="flex-wrap day">
									<div class="shadow-wrap big-r m1">
										<ul class="i-category">
											<li class="border-wrap toggleCheck">
												<span class="dragBlock">???</span>
												<input type="checkbox" name="runDay" value="???">
											</li>
											<li class="border-wrap toggleCheck">
												<span class="dragBlock">???</span>
												<input type="checkbox" name="runDay" value="???">
											</li>
											<li class="border-wrap toggleCheck">
												<span class="dragBlock">???</span>
												<input type="checkbox" name="runDay" value="???">
											</li>
											<li class="border-wrap toggleCheck">
												<span class="dragBlock">???</span>
												<input type="checkbox" name="runDay" value="???">
											</li>
											<li class="border-wrap toggleCheck">
												<span class="dragBlock">???</span>
												<input type="checkbox" name="runDay" value="???">
											</li>
											<li class="border-wrap toggleCheck">
												<span class="dragBlock">???</span>
												<input type="checkbox" name="runDay" value="???">
											</li>
											<li class="border-wrap toggleCheck">
												<span class="dragBlock">???</span>
												<input type="checkbox" name="runDay" value="???">
											</li>
										</ul>
									</div>
								</div>
							</li>

							<li>
								<label for="inquiryMaTime" class="label-text">?????? ??????</label>
								<div class="flex-wrap time">
									<span class="item_inp"> <label class="lab_g">
											<span> <input type="radio" class="inp_g" value="single" name="maTimeCheck" checked>
											</span>?????? ????????? ????????? ??????
										</label>
								</div>

								<div class="flex-wrap time grid single ma">
									<input type="time" name="startRunTime">
									<span> ~ </span>
									<input type="time" name="endRunTime">
								</div>
							</li>

							<li>
								<label for="inquiryCoDay" class="label-text">???????????? ??????</label>
								<div class="flex-wrap day">
									<div class="shadow-wrap big-r m1">
										<ul class="i-category">
											<li class="border-wrap toggleCheck">
												<span class="dragBlock">???</span>
												<input type="checkbox" name="coDay" value="???">
											</li>
											<li class="border-wrap toggleCheck">
												<span class="dragBlock">???</span>
												<input type="checkbox" name="coDay" value="???">
											</li>
											<li class="border-wrap toggleCheck">
												<span class="dragBlock">???</span>
												<input type="checkbox" name="coDay" value="???">
											</li>
											<li class="border-wrap toggleCheck">
												<span class="dragBlock">???</span>
												<input type="checkbox" name="coDay" value="???">
											</li>
											<li class="border-wrap toggleCheck">
												<span class="dragBlock">???</span>
												<input type="checkbox" name="coDay" value="???">
											</li>
											<li class="border-wrap toggleCheck">
												<span class="dragBlock">???</span>
												<input type="checkbox" name="coDay" value="???">
											</li>
											<li class="border-wrap toggleCheck">
												<span class="dragBlock">???</span>
												<input type="checkbox" name="coDay" value="???">
											</li>
										</ul>
									</div>
								</div>
							</li>

							<li>
								<label for="inquiryCoTime" class="label-text">???????????? ??????</label>
								<div class="flex-wrap time">
									<span class="item_inp"> <label class="lab_g">
											<span> <input type="radio" class="inp_g" value="single" name="coTimeCheck" checked>
											</span>?????? ????????? ????????? ??????
										</label>
								</div>

								<div class="flex-wrap time grid single co">
									<input type="time" name="startCoTime">
									<span> ~ </span>
									<input type="time" name="endCoTime">
								</div>
							</li>

							<li>
								<label for="inquiryMemo" class="label-text">?????????</label>
								<div class="flex-wrap">
									<textarea name="introduction" id="inquiryMemo" cols="30" rows="10" class="input-text" required="" placeholder="????????? ??????????????????"></textarea>
								</div>
							</li>
					</ul>
					<button type="submit" class="bt-sub point">?????????</button>
					</form>
				</div>
			</div>
			<!-- ???????????? ?????? ??? -->
		</div>

		<footer id="footer">
			<ul class="footer-wrap">
				<li>
					<a href="#" class="footer-nav">????????????</a>
				</li>
				<li>
					<a href="#" class="footer-nav color-point">????????????????????????</a>
				</li>
			</ul>
			<div class="container">
				<section class="content">
					<h1 class="skip">????????? ????????????</h1>
					<ul class="footer-company">
						<li>EKA</li>
						<li>??? ?????????</li>
						<li>
							<a href="tel:053-1234-1234">???????????? 053-1234-1234</a>
						</li>
						<li>
							<a href="mailto:bravoTeam@bravoTeam.co.kr">????????? bravoTeam@bravoTeam.co.kr</a>
						</li>
						<li>??????????????? ?????? ?????????</li>
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
		//???????????? ???????????? ???????????? ???????????????
		$(".inquiryPhone2").hide();
		$(".selbox").change(function() {

			//??????????????? ?????? ??? ?????????
			if ($(".selbox").val() == "direct") {
				$(".inquiryPhone2").show().attr("required", true);
			} else {
				$(".inquiryPhone2").hide().attr("required", false);
			}
		})

		//?????? ??????
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

	var mapContainer = document.getElementById('map'), // ????????? ????????? div
	mapOption = {
		center : new daum.maps.LatLng(37.537187, 127.005476), // ????????? ????????????
		level : 5
	// ????????? ?????? ??????
	};

	//????????? ?????? ??????
	var map = new daum.maps.Map(mapContainer, mapOption);
	//??????-?????? ?????? ????????? ??????
	var geocoder = new daum.maps.services.Geocoder();
	//????????? ?????? ??????
	var marker = new daum.maps.Marker({
		position : new daum.maps.LatLng(37.537187, 127.005476),
		map : map
	});

	function sample5_execDaumPostcode() {
		new daum.Postcode({
			oncomplete : function(data) {
				var addr = data.address; // ?????? ?????? ??????

				// ?????? ????????? ?????? ????????? ?????????.
				document.getElementById("sample5_address").value = addr;
				// ????????? ?????? ????????? ??????
				geocoder.addressSearch(data.address, function(results, status) {
					// ??????????????? ????????? ???????????????
					if (status === daum.maps.services.Status.OK) {

						var result = results[0]; //????????? ????????? ?????? ??????

						// ?????? ????????? ?????? ????????? ?????????
						var coords = new daum.maps.LatLng(result.y, result.x);
						// ????????? ????????????.
						mapContainer.style.display = "block";
						map.relayout();
						// ?????? ????????? ????????????.
						map.setCenter(coords);
						// ????????? ??????????????? ?????? ????????? ?????????.
						marker.setPosition(coords)
					}
				});
			}
		}).open();
	}
</script>

</html>
