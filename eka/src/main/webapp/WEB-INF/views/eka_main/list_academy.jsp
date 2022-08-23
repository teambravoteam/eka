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
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin="crossorigin">
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
			<nav class="header-wrap">
				<ul>
					<li><a href="main" class="header-logo">
							<h1>eka</h1>
						</a></li>
					<li class="hide-m"><a href="notice.html" class="header-nav">공지사항</a></li>
					<li class="hide-m"><a href="add_academy.html" class="header-nav">학원신청</a></li>
				</ul>
				<ul class="hide-m">
					<li><a href="#" class="header-nav">로그인</a></li>
					<li><a href="#" class="bt-sub point">회원가입</a></li>
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
					<li><a href="notice.html">공지사항</a></li>
					<li><a href="academy.html">학원신청</a></li>
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
			<div class="header-loc">
				<div class="shadow-wrap flex-wrap flex-center flex-glow-1">
					<div class="userAddr-wrap flex-glow-1">
						<form id="academyListForm" action="./list_academy" method="post">
							<span class="guide">현재 검색위치</span> <label for="bt-config-loc2" id="listAddr1" class="userAddr">${user_address}</label>
							<input type="hidden" id="listAddr2" name="addr" value="${user_address}">
							<input type="hidden" id="listLat" name="lat" value="${user_lat}">
							<input type="hidden" id="listLon" name="lon" value="${user_lon}">
							<input type="hidden" id="listCate" name="categoryNum" value="0">
							<input type="submit" class="bt-sub green ic-gps mgl-12" value="학원검색">
						</form>
					</div>
					<button type="button" id="bt-config-loc2" class="bt-sub point ic-gps mgl-12">현재위치 이동</button>
				</div>
				<button type="button" class="bt-extra navi pressed"></button>
				<button type="button" class="bt-extra filter"></button>
			</div>
			<div class="header-category">
				<div class="hdtb-wrap">
					<button type="button" class="bt-hdtb prev"></button>
					<ul class="hdtb">
						<li class="hdtb-item"><a href="#" onclick="document.getElementById('academyListForm').submit();" data-cid="0">
								<span class="dragBlock current">전체</span>
							</a></li>
						<li class="hdtb-item"><a href="#" onclick="document.getElementById('academyListForm').submit();" data-cid="1">
								<span class="dragBlock">간호보조기술</span>
							</a></li>
						<li class="hdtb-item"><a href="#" onclick="document.getElementById('academyListForm').submit();" data-cid="2">
								<span class="dragBlock">경영·사무관리</span>
							</a></li>
						<li class="hdtb-item"><a href="#" onclick="document.getElementById('academyListForm').submit();" data-cid="3">
								<span class="dragBlock">국제</span>
							</a></li>
						<li class="hdtb-item"><a href="#" onclick="document.getElementById('academyListForm').submit();" data-cid="4">
								<span class="dragBlock">기예</span>
							</a></li>
						<li class="hdtb-item"><a href="#" onclick="document.getElementById('academyListForm').submit();" data-cid="5">
								<span class="dragBlock">기타</span>
							</a></li>
						<li class="hdtb-item"><a href="#" onclick="document.getElementById('academyListForm').submit();" data-cid="6">
								<span class="dragBlock">독서실</span>
							</a></li>
						<li class="hdtb-item"><a href="#" onclick="document.getElementById('academyListForm').submit();" data-cid="7">
								<span class="dragBlock">독서실(일반인)</span>
							</a></li>
						<li class="hdtb-item"><a href="#" onclick="document.getElementById('academyListForm').submit();" data-cid="8">
								<span class="dragBlock">보통교과</span>
							</a></li>
						<li class="hdtb-item"><a href="#" onclick="document.getElementById('academyListForm').submit();" data-cid="9">
								<span class="dragBlock">산업기반기술</span>
							</a></li>
						<li class="hdtb-item"><a href="#" onclick="document.getElementById('academyListForm').submit();" data-cid="10">
								<span class="dragBlock">산업서비스</span>
							</a></li>
						<li class="hdtb-item"><a href="#" onclick="document.getElementById('academyListForm').submit();" data-cid="11">
								<span class="dragBlock">산업응용기술</span>
							</a></li>
						<li class="hdtb-item"><a href="#" onclick="document.getElementById('academyListForm').submit();" data-cid="12">
								<span class="dragBlock">예체능</span>
							</a></li>
						<li class="hdtb-item"><a href="#" onclick="document.getElementById('academyListForm').submit();" data-cid="13">
								<span class="dragBlock">외국어</span>
							</a></li>
						<li class="hdtb-item"><a href="#" onclick="document.getElementById('academyListForm').submit();" data-cid="14">
								<span class="dragBlock">인문사회</span>
							</a></li>
						<li class="hdtb-item"><a href="#" onclick="document.getElementById('academyListForm').submit();" data-cid="15">
								<span class="dragBlock">일반서비스</span>
							</a></li>
						<li class="hdtb-item"><a href="#" onclick="document.getElementById('academyListForm').submit();" data-cid="16">
								<span class="dragBlock">진학지도</span>
							</a></li>
						<li class="hdtb-item"><a href="#" onclick="document.getElementById('academyListForm').submit();" data-cid="17">
								<span class="dragBlock">컴퓨터</span>
							</a></li>
					</ul>
					<button type="button" class="bt-hdtb next"></button>
				</div>
			</div>
			<input type="hidden" id="uaLat" value="35.8582000811537">
			<input type="hidden" id="uaLng" value="128.630629788584">
			<input type="hidden" id="cid" value="1">
			<script>

			// 카테고리 영역 선택
			var cateIndex = ${categoryNum};
			$(".hdtb").children().eq(cateIndex).addClass('current')

				/* init pos */
				$(".hdtb").scrollLeft(
						$(".hdtb .current").offset().left
								- $(".hdtb-item:eq(0)").offset().left);
				/* pc scroll button */
				$(".bt-hdtb").on("click", function() {
					var $target = $(".hdtb");
					if ($(this).hasClass("prev")) {
						$target.stop().animate({
							scrollLeft : $target.scrollLeft() - 1060
						}, 300);
					} else {
						$target.stop().animate({
							scrollLeft : $target.scrollLeft() + 1060
						}, 300);
					}
				});
				/* category button replace */
				$(".hdtb-item a").on("click", function(e) {
					e.preventDefault();
					$this = $(this);
					var href = $this.attr("href");
					var cid = $this.data("cid");
					history.replaceState(null, null, href);
					$("#cid").val(cid);
					$(".hdtb-item").removeClass("current");
					$this.parent().addClass("current");
					academyLocation.searchAcademy();
				});
				/* map view control */
				$(".bt-extra.navi").on("click", function() {
					$('html, body').scrollTop(0);
					$(this).toggleClass("pressed");
					$("#academy-list-wrap").toggleClass("navi");
				});
				$(".bt-extra.filter").on("click", function() {
					$("#wrap").addClass("on-modal");
					$("#modal-filter-wrap").toggle();
				});
			</script>
		</header>
		<a href="#wrap" class="bt-top hashLink">
			<img src="../resources/img/ic_arrow_up_24px.png" alt="맨위로"> <span>맨위로</span>
		</a>
		<a href="https://pf.kakao.com/_sjxnTxb/chat" class="bt-kakao" target="_blank">
			<img src="../resources/img/ic_kakao_24px.png" alt="카톡상담"> <span>문의</span>
		</a>
		<div id="academy-list-wrap" class="container navi">
			<div class="academy-map-wrap">
				<div id="academy-map"></div>
			</div>
			<div id="academy-list" class="academy-list">
				<div class="list-default">
					<ul id="list-default">
					</ul>
				</div>
				<div class="list-empty" style="display: none;">
					<h3 class="content text-center">검색된 학원이 없습니다.</h3>
				</div>
			</div>
		</div>

		<script type="text/javascript" src="../resources/js/common.js"></script>
		<script>

// 마커를 담을 배열입니다
var markers = [];

var mapContainer = document.getElementById('academy-map'), // 지도를 표시할 div
    mapOption = {
        center: new kakao.maps.LatLng(${user_lat}, ${user_lon}), // 지도의 중심좌표
        level: 5 // 지도의 확대 레벨
    };

// 지도를 생성합니다
var map = new kakao.maps.Map(mapContainer, mapOption);

// 검색 결과 목록이나 마커를 클릭했을 때 장소명을 표출할 인포윈도우를 생성합니다
var infowindow = new kakao.maps.InfoWindow({zIndex:1});

// 검색 목록과 마커를 표출합니다
displayPlaces();

// 검색 결과 목록과 마커를 표출하는 함수입니다
function displayPlaces() {

    var listEl = document.getElementById('list-default'),
    menuEl = document.getElementById('academy-list'),
    fragment = document.createDocumentFragment(),
    bounds = new kakao.maps.LatLngBounds(),
    listStr = '';

    // 검색 결과 목록에 추가된 항목들을 제거합니다
    removeAllChildNods(listEl);

    // 지도에 표시되고 있는 마커를 제거합니다
    removeMarker();

		nameList = [];
		addrList = [];
		detailAddrList = [];

		<c:forEach var="name" items="${nameList}" varStatus="status">
				nameList.push("${name}");
				addrList.push("${addressList[status.index]}");
				detailAddrList.push("${detailAddressList[status.index]}");

        // 마커를 생성하고 지도에 표시합니다
        var placePosition = new kakao.maps.LatLng(${latList[status.index]}, ${lonList[status.index]}),
            marker = addMarker(placePosition, ${status.index}),
            itemEl = getListItem(${status.index}); // 검색 결과 항목 Element를 생성합니다

        // 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해
        // LatLngBounds 객체에 좌표를 추가합니다
        bounds.extend(placePosition);

        // 마커와 검색결과 항목에 mouseover 했을때
        // 해당 장소에 인포윈도우에 장소명을 표시합니다
        // mouseout 했을 때는 인포윈도우를 닫습니다
        (function(marker, title, addr, detailAddr) {
            kakao.maps.event.addListener(marker, 'mouseover', function() {
                displayInfowindow(marker, title, addr, detailAddr);
            });

            // kakao.maps.event.addListener(marker, 'mouseout', function() {
            //     infowindow.close();
            // });

            itemEl.onmouseover =  function () {
                displayInfowindow(marker, title, addr, detailAddr);
            };

            itemEl.onmouseout =  function () {
                infowindow.close();
            };
        })(marker, "${name}", "${addressList[status.index]}", "${detailAddressList[status.index]}");

        fragment.appendChild(itemEl);

		</c:forEach>

    // 검색결과 항목들을 검색결과 목록 Element에 추가합니다
    listEl.appendChild(fragment);
    menuEl.scrollTop = 0;

    // 검색된 장소 위치를 기준으로 지도 범위를 재설정합니다
//     map.setBounds(bounds);
}

// 검색결과 항목을 Element로 반환하는 함수입니다
function getListItem(index) {
    var el = document.createElement('li'),
    itemStr =		'<span class="markerbg marker_' + (index+1) + '"></span>' +
		 						'<a href="./academyDetail?'+nameList[index]+'">' +
								'<div class="item-content">' +
								'<button class="bt-like float-right"></button>' +
								'<div>' +
								'<span class="a-title">'+nameList[index]+'</span>' +
								'</div>' +
								'</div>' +
								'</a>';

    el.innerHTML = itemStr;
    el.className = 'list-item';

    return el;
}

// 마커를 생성하고 지도 위에 마커를 표시하는 함수입니다
function addMarker(position, idx) {
    var imageSrc = 'https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_number_blue.png', // 마커 이미지 url, 스프라이트 이미지를 씁니다
        imageSize = new kakao.maps.Size(36, 37),  // 마커 이미지의 크기
        imgOptions =  {
            spriteSize : new kakao.maps.Size(36, 691), // 스프라이트 이미지의 크기
            spriteOrigin : new kakao.maps.Point(0, (idx*46)+10), // 스프라이트 이미지 중 사용할 영역의 좌상단 좌표
            offset: new kakao.maps.Point(13, 37) // 마커 좌표에 일치시킬 이미지 내에서의 좌표
        },
        markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imgOptions),
            marker = new kakao.maps.Marker({
            position: position, // 마커의 위치
            image: markerImage
        });

    marker.setMap(map); // 지도 위에 마커를 표출합니다
    markers.push(marker);  // 배열에 생성된 마커를 추가합니다

    return marker;
}

// 지도 위에 표시되고 있는 마커를 모두 제거합니다
function removeMarker() {
    for ( var i = 0; i < markers.length; i++ ) {
        markers[i].setMap(null);
    }
    markers = [];
}

// 검색결과 목록 또는 마커를 클릭했을 때 호출되는 함수입니다
// 인포윈도우에 장소명을 표시합니다

function displayInfowindow(marker, title, addr, detailAddr) {
    var content =

		'<div id="academyList-wrap" class="academy-overlay-wrap undefined">' +
		'<div class="item-content">' +
		'<button class="bt-like float-right" data-uaid="83877" data-like="0"></button>' +
		'<div><span class="a-title">'+title+'</span>' +
		'<span class="a-distance hide-overlay">0.1km</span></div>' +
		'<div><span class="a-review-rating">0.0</span><span class="a-review-count">(0)</span></div>' +
		'<div class="show-overlay"><span class="a-addr-default">'+addr+'</span><span class="a-addr-detail">'+detailAddr+'</span></div>' +
		'<div class="bt-modal-wrap show-overlay">' +
		'<button class="bt-label" onclick="location.href=./academyDetail?'+title+'">학원보기</button>' +
		'</div></div></div>';

    infowindow.setContent(content);
    infowindow.open(map, marker, title, addr, detailAddr);
}

 // 검색결과 목록의 자식 Element를 제거하는 함수입니다
function removeAllChildNods(el) {
    while (el.hasChildNodes()) {
        el.removeChild (el.lastChild);
    }
}

// 중심 마커가 표시될 위치입니다
var markerPosition = new kakao.maps.LatLng(${user_lat}, ${user_lon});

// 중심 마커를 생성합니다
marker = new kakao.maps.Marker({
	position: markerPosition
});
marker.setMap(map);

// 지도가 이동, 확대, 축소로 인해 중심좌표가 변경되면 마지막 파라미터로 넘어온 함수를 호출하도록 이벤트를 등록합니다
kakao.maps.event.addListener(map, 'center_changed', function() {

	// 지도의 중심좌표를 얻어옵니다
	var latlng = map.getCenter();

	marker.setPosition(latlng);
});

// 지도 드래그 이벤트
		kakao.maps.event.addListener(map, 'dragend', function() {
		console.log("지도 이동됨!");

    var latlng = map.getCenter();

		setAddr3(latlng.getLat(), latlng.getLng());

		function setAddr3(lat, lon) {
			var moveLatLon = new kakao.maps.LatLng(lat, lon);
			map.setCenter(moveLatLon);

			let geocoder = new kakao.maps.services.Geocoder();

			let coord = new kakao.maps.LatLng(lat, lon);
			let callback = function(result, status) {
				if (status === kakao.maps.services.Status.OK) {
					if (result[0].road_address == null) {
						$("#listAddr1").text(result[0].address.address_name);
						$("#listAddr2").val(result[0].address.address_name);
						$("#listLat").val(lat);
						$("#listLon").val(lon);

					} else {
						$("#listAddr1").text(result[0].road_address.address_name);
						$("#listAddr2").val(result[0].road_address.address_name);
						$("#listLat").val(lat);
						$("#listLon").val(lon);
					}
				}
			}
			geocoder.coord2Address(coord.getLng(), coord.getLat(), callback);
		}
    map.relayout();
});


// 검색 값이 없을 때 나타낼 지도
if (nameList?.length == false) {
	var mapContainer = document.getElementById('academy-map'), // 지도를 표시할 div
    mapOption = {
        center: new kakao.maps.LatLng(${user_lat}, ${user_lon}), // 지도의 중심좌표
        level: 5 // 지도의 확대 레벨
    };

	// 지도를 생성합니다
	var map = new kakao.maps.Map(mapContainer, mapOption);


	// 중심 마커가 표시될 위치입니다
	var markerPosition = new kakao.maps.LatLng(${user_lat}, ${user_lon});

	// 중심 마커를 생성합니다
	marker = new kakao.maps.Marker({
		position: markerPosition
	});
	marker.setMap(map);

	// 지도가 이동, 확대, 축소로 인해 중심좌표가 변경되면 마지막 파라미터로 넘어온 함수를 호출하도록 이벤트를 등록합니다
	kakao.maps.event.addListener(map, 'center_changed', function() {

		// 지도의 중심좌표를 얻어옵니다
		var latlng = map.getCenter();

		marker.setPosition(latlng);
	});

	// 지도 드래그 이벤트
	kakao.maps.event.addListener(map, 'dragend', function() {
	console.log("지도 이동됨!");

	var latlng = map.getCenter();

	setAddr3(latlng.getLat(), latlng.getLng());

	function setAddr3(lat, lon) {
		var moveLatLon = new kakao.maps.LatLng(lat, lon);
		map.setCenter(moveLatLon);

		let geocoder = new kakao.maps.services.Geocoder();

		let coord = new kakao.maps.LatLng(lat, lon);
		let callback = function(result, status) {
			if (status === kakao.maps.services.Status.OK) {
				if (result[0].road_address == null) {
					$("#listAddr1").text(result[0].address.address_name);
					$("#listAddr2").val(result[0].address.address_name);
					$("#listLat").val(lat);
					$("#listLon").val(lon);

				} else {
					$("#listAddr1").text(result[0].road_address.address_name);
					$("#listAddr2").val(result[0].road_address.address_name);
					$("#listLat").val(lat);
					$("#listLon").val(lon);
				}
			}
		}
		geocoder.coord2Address(coord.getLng(), coord.getLat(), callback);
	}
	    map.relayout();
	});

	alert("해당 위치에 학원이 없습니다.");
}

$(".hdtb-item a").mouseenter(function() {
	$("#listCate").val($(this).attr("data-cid"));
});

$(".hdtb-item a").mouseleave(function() {
	$("#listCate").val("0");
});

		</script>
	</div>
</body>

</html>
