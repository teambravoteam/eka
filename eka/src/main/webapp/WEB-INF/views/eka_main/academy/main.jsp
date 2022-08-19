<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta name="viewport" content="initial-scale=1.0">
<title>Test</title>

<style>
#main_destination {
	border-style: solid;
	border-color: gray;
	border-radius: 5px/5px;
	width: 40%;
	height: 50px;
	float: left;
}

#keyword {
	outline: none;
	border: none;
	background-color: #fff;
	font-family: Roboto;
	font-size: 15px;
	font-weight: 300;
	text-overflow: ellipsis;
	width: 500px;
}
</style>


</head>

<body>
	<div id="map"></div>

	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=fc2120b8ad3fcff0b18376b88b35a6f5&libraries=services"></script>

	<script>
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		mapOption = {
			center : new kakao.maps.LatLng(37.566826, 126.9786567), // 지도의 중심좌표
			level : 3
		// 지도의 확대 레벨
		};

		//지도를 생성합니다    
		var map = new kakao.maps.Map(mapContainer, mapOption);

		//장소 검색 객체를 생성합니다.
		var ps = new kakao.maps.services.Places();

		//검색 결과 목록이나 마커를 클릭했을 때 장소명을 표출할 인포윈도우를 생성합니다
		var infowindow = new kakao.maps.InfoWindow({
			zIndex : 1
		});

		//입력된 키워드에 의한 장소 검색을 요청하는 함수입니다

		function searchPlaces() {

			var kw = document.getElementById('keyword').value;

			if (!kw.replace(/^\s+|\s+$/g, '')) {
				alert('장소를 입력해주세요');

				return false;

			}

			// 장소검색 객체를 통해 키워드로 장소검색을 요청합니다
			ps.keywordSearch(kw, placesSearchCB);

		}

		//장소검색이 완료됐을 때 호출되는 콜백함수 입니다
		function placesSearchCB(data, status) {
			if (status === kakao.maps.services.Status.OK) {

				// 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해
				// LatLngBounds 객체에 좌표를 추가합니다
				var bounds = new kakao.maps.LatLngBounds();

				for (var i = 0; i < 5; i++) {
					displayMarker(data[i]);
					bounds.extend(new kakao.maps.LatLng(data[i].y, data[i].x));
				}
				// 검색된 장소 위치를 기준으로 지도 범위를 재설정합니다. 
				// 정확한 위치라면 해당지점을, 다수의 장소라면 바운드의 중앙값을 기준으로 합니다.

				map.setBounds(bounds);

				document.getElementById("center_lat").value = map.getCenter()
						.getLat();
				document.getElementById("center_lng").value = map.getCenter()
						.getLng();

				setTimeout(function() {
					document.frm.submit();
				}, 500); // 0.5초 뒤에 실행하기

				return;

			} else if (status === kakao.maps.services.Status.ZERO_RESULT) {

				alert('검색 장소가 존재하지 않습니다. 다시 검색해주세요');

				document.getElementById("center_lat").value = 37.566826;
				document.getElementById("center_lng").value = 126.9786567;

				return;

			} else if (status === kakao.maps.services.Status.ERROR) {

				alert('검색 결과 중 오류가 발생했습니다.');
				return;

			}
		}

		// 지도에 마커를 표시하는 함수입니다
		function displayMarker(place) {

			// 마커를 생성하고 지도에 표시합니다
			var marker = new kakao.maps.Marker({
				map : map,
				position : new kakao.maps.LatLng(place.y, place.x)
			});

			// 마커에 클릭이벤트를 등록합니다
			kakao.maps.event.addListener(marker, 'click', function() {
				// 마커를 클릭하면 장소명이 인포윈도우에 표출됩니다
				infowindow
						.setContent('<div style="padding:5px;font-size:12px;">'
								+ place.place_name + '</div>');
				infowindow.open(map, marker);
			});

		}
	</script>

	<script>
		function enterkey() {
			if (window.event.keyCode == 13) {
				// 엔터키가 눌렸을 때 실행할 내용
				searchPlaces();
			}
		}
	</script>

	<form id="frm" name="frm" action="search" method="post">
		<div>원하는 장소를 입력해주세요</div>
		<div id="main_destination">
			<div id="pac-container">
				위치 <br>
				<input hidden="hidden" />
				<input type="text" id="keyword" name="destination_search" onkeyup="enterkey();" value="" placeholder="어디에 계신가요? 관심있는 지역을 입력해주세요">
				<input type="hidden" id="center_lat" name="center_lat" value="">
				<input type="hidden" id="center_lng" name="center_lng" value="">
			</div>
		</div>
		<div id="main_search">
			<input type="button" id="main_search_button" name="main_search_button" onclick="searchPlaces()" value="검색하기">
		</div>
	</form>
</body>
</html>