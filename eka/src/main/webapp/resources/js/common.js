function countAnimation(element, from, to, time, duration) {
  //애니메이션 큐제거
  target = $(element).stop();

  //천단위 콤마제거
  if (from == null) {
    var from = target.text();
  }
  target.text(from.toLocaleString());
  from = parseInt(from.replace(/,/g, ""));
  to = parseInt(to.replace(/,/g, ""));

  setTimeout(function() {
    var target = $(element);
    target.animate({
      val: to
    }, {
      duration: duration,
      easing: "easeOutSine",
      step: function() {
        target.text(Math.floor(this.val).toLocaleString());
      },
      complete: function() {
        target.text(Math.floor(this.val).toLocaleString());
      }
    });
  }, time);
}

function checkStrength(password) {
  var strength = 0;
  if (password.length == 0) return -1;
  if (password.length < 8 || password.length > 16) return 0;
  if (password.match(/([a-z].*[A-Z])|([A-Z].*[a-z])/)) strength += 1;
  if (password.match(/([a-zA-Z])/) && password.match(/([0-9])/)) strength += 1;
  if (password.match(/([!%&@#$^*?_~-])/)) strength += 1;
  if (password.match(/(.*[!%&@#$^*?_~-].*[!%&@#$^*?_~-])/)) strength += 1;
  return strength;
}

function getCookieValue(key) {
  var cookieKey = key + "=";
  var result = "";
  var cookieArr = document.cookie.split(";");

  for (let i = 0; i < cookieArr.length; i++) {
    if (cookieArr[i][0] === " ") {
      cookieArr[i] = cookieArr[i].substring(1);
    }

    if (cookieArr[i].indexOf(cookieKey) === 0) {
      result = cookieArr[i].slice(cookieKey.length, cookieArr[i].length);
      return result;
    }
  }
  return result;
}

/* datepicker addon */
function getDate(element) {
  var date;
  try {
    date = $.datepicker.parseDate(dateFormat, element.value);
  } catch (error) {
    date = null;
  }
  return date;
}

let openOverlay = function(marker) {
  var $target = $('.academy-list [data-uaid="' + marker.uaid + '"]').eq(0);
  var adType = $target.closest("ul").parent().data("color");
  var html = '<div class="academy-overlay-wrap ' + adType + '">';
  html += $target.children("a").html();
  html += '</div>';
  academyLocation.customOverlay.setContent(html);
  academyLocation.customOverlay.setPosition(marker.getPosition());
  var mapDistance = 0.0003 * (academyLocation.map.getLevel() - 1);
  academyLocation.map.panTo(new kakao.maps.LatLng(marker.getPosition().getLat() + mapDistance, marker.getPosition().getLng()));
  academyLocation.customOverlay.setMap(academyLocation.map);
};

let closeOverlay = function() {
  academyLocation.customOverlay.setMap(null);
};

$(function() {
  /* GNB SETTING */
  $('.header-menu').on('click', function() {
    $(this).toggleClass('pressed');
    $('#header').toggleClass('open');
  });

  $('.header-side').on('touchend', function() {
    $('.header-menu').trigger('click');
  });

  $('.header-side .gnb').on('touchend', function(e) {
    e.stopPropagation();
  });

  /* Hashtag scrollEvent */
  $('.hashLink').on('click', function(e) {
    e.preventDefault();
    if ($('#header').hasClass('open')) {
      $('.header-menu').trigger('click');
    }
    $('html, body').stop().animate({
      scrollTop: $(this.hash).offset().top
    }, 500);
  });

  $(".hasChild").on("click", function(e) {
    e.stopPropagation();
    var target = $(this);
    if (target.data('folding')) {
      return false;
    }
    target.data('folding', true);
    target.toggleClass("open");
    target.closest("li").children("ul").slideToggle(function() {
      target.data('folding', false);
    });
  });

  // 분야 select 박스 선택 스크립트
  $('#academyField').change(function() {
    var selected = $("#academyField option:selected").val();
    if (selected == "교과목") {
      $(".schoolSubject").removeClass("hidden2");

      if ($(".activeSubject").hasClass("hidden2") == false) {
        $(".activeSubject").addClass("hidden2");
      }
      if ($(".foreignSubject").hasClass("hidden2") == false) {
        $(".foreignSubject").addClass("hidden2");
      }
      if ($(".etcSubject").hasClass("hidden2") == false) {
        $(".etcSubject").addClass("hidden2");
      }

    } else if (selected == "예체능") {
      $(".activeSubject").removeClass("hidden2");

      if ($(".schoolSubject").hasClass("hidden2") == false) {
        $(".schoolSubject").addClass("hidden2");
      }
      if ($(".foreignSubject").hasClass("hidden2") == false) {
        $(".foreignSubject").addClass("hidden2");
      }
      if ($(".etcSubject").hasClass("hidden2") == false) {
        $(".etcSubject").addClass("hidden2");
      }

    } else if (selected == "제2외국어") {
      $(".foreignSubject").removeClass("hidden2");

      if ($(".activeSubject").hasClass("hidden2") == false) {
        $(".activeSubject").addClass("hidden2");
      }
      if ($(".schoolSubject").hasClass("hidden2") == false) {
        $(".schoolSubject").addClass("hidden2");
      }
      if ($(".etcSubject").hasClass("hidden2") == false) {
        $(".etcSubject").addClass("hidden2");
      }

    } else {
      $(".etcSubject").removeClass("hidden2");

      if ($(".activeSubject").hasClass("hidden2") == false) {
        $(".activeSubject").addClass("hidden2");
      }
      if ($(".foreignSubject").hasClass("hidden2") == false) {
        $(".foreignSubject").addClass("hidden2");
      }
      if ($(".schoolSubject").hasClass("hidden2") == false) {
        $(".schoolSubject").addClass("hidden2");
      }

    }
  });

  /* Modal close */
  $(".modal-head .close").on("click", function() {
    $(this).closest(".modal-wrap").hide();
    $("#wrap").removeClass("transparent");
  });

  let options = {
    enableHighAccuracy: true,
    timeout: 5000,
    maximumAge: 0
  };

  function success(pos) {
    let crd = pos.coords;
    console.log('위도 : ' + crd.latitude);
    console.log('경도: ' + crd.longitude);
    lat = crd.latitude;
    lon = crd.longitude;
  };

  function error(err) {
    console.warn('ERROR(' + err.code + '): ' + err.message);
  };

  navigator.geolocation.getCurrentPosition(success, error, options);

  // 현재 위치 설정
  function setAddr1(lat, lon) {
    let geocoder = new kakao.maps.services.Geocoder();

    let coord = new kakao.maps.LatLng(lat, lon);
    let callback = function(result, status) {
      if (status === kakao.maps.services.Status.OK) {
        if (result[0].road_address == null) {
          console.log(result[0].address.address_name);
          $(".userAddr").text(result[0].address.address_name);
          $("#mainAddr").val(result[0].address.address_name);
          $("#mainLat").val(lat);
          $("#mainLon").val(lon);

        } else {
          console.log(result[0].road_address.address_name);
          $(".userAddr").text(result[0].road_address.address_name);
          $("#mainAddr").val(result[0].road_address.address_name);
          $("#mainLat").val(lat);
          $("#mainLon").val(lon);
        }
      }
    }
    geocoder.coord2Address(coord.getLng(), coord.getLat(), callback);
  }

  // 지도 페이지에 현재 위치 설정
  function setAddr2(lat, lon) {
    var moveLatLon = new kakao.maps.LatLng(lat, lon);
    map.setCenter(moveLatLon);

    let geocoder = new kakao.maps.services.Geocoder();

    let coord = new kakao.maps.LatLng(lat, lon);
    let callback = function(result, status) {
      if (status === kakao.maps.services.Status.OK) {
        if (result[0].road_address == null) {
          console.log(result[0].address.address_name);
          $(".input-text.search").val(result[0].address.address_name);
          $("#mainAddr").val(result[0].address.address_name);
          $("#mainLat").val(lat);
          $("#mainLon").val(lon);

        } else {
          console.log(result[0].road_address.address_name);
          $(".input-text.search").val(result[0].road_address.address_name);
          $("#mainAddr").val(result[0].road_address.address_name);
          $("#mainLat").val(lat);
          $("#mainLon").val(lon);
        }
      }
    }
    geocoder.coord2Address(coord.getLng(), coord.getLat(), callback);
  }


  // 학원 리스트 현재 위치 설정
  function setAddr3(lat, lon) {
    let geocoder = new kakao.maps.services.Geocoder();

    let coord = new kakao.maps.LatLng(lat, lon);
    let callback = function(result, status) {
      if (status === kakao.maps.services.Status.OK) {
        if (result[0].road_address == null) {
          console.log(result[0].address.address_name);
          $("#listAddr1").text(result[0].address.address_name);
          $("#listAddr2").val(result[0].address.address_name);
          $("#listLat").val(lat);
          $("#listLon").val(lon);

        } else {
          console.log(result[0].road_address.address_name);
          $("#listAddr1").text(result[0].road_address.address_name);
          $("#listAddr2").val(result[0].road_address.address_name);
          $("#listLat").val(lat);
          $("#listLon").val(lon);
        }
      }
    }
    geocoder.coord2Address(coord.getLng(), coord.getLat(), callback);
  }

  // 메인 페이지 현재 위치 설정
  $("#bt-config-loc").click(function() {
    navigator.geolocation.getCurrentPosition(success, error, options);
    setAddr1(lat, lon);
  })

  // 메인 페이지 지도로 위치 설정
  $("#bt-config-map").click(function() {

    // 지도 api
    var mapContainer = document.getElementById('config-map'), // 지도를 표시할 div
      mapOption = {
        center: new kakao.maps.LatLng(lat, lon), // 지도의 중심좌표
        level: 5 // 지도의 확대 레벨
      };

    map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

    // 마커가 표시될 위치입니다
    var markerPosition = new kakao.maps.LatLng(lat, lon);

    // 마커를 생성합니다
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

    // 지도를 움직이고 난 후 해당 위치의 주소 검색
    kakao.maps.event.addListener(map, 'tilesloaded', displayLocation);

    function displayLocation() {
      // 지도의 중심좌표를 얻어옵니다
      var latlng = map.getCenter();

      // 현재 위치를 지도중심으로 설정합니다
      setAddr2(latlng.getLat(), latlng.getLng());
      // 아래 코드는 최초 한번만 타일로드 이벤트가 발생했을 때 어떤 처리를 하고
      // 지도에 등록된 타일로드 이벤트를 제거하는 코드입니다
      // kakao.maps.event.removeListener(map, 'tilesloaded', displayMarker);
    }

    $("#modal-wrap").css('display', 'block');
    $("#wrap").addClass('transparent');

    navigator.geolocation.getCurrentPosition(success, error, options);
    map.relayout();
  })

  function searchCusAddr(addr) {
    // 주소-좌표 변환 객체를 생성합니다
    var geocoder = new kakao.maps.services.Geocoder();

    // 주소로 좌표를 검색합니다
    geocoder.addressSearch(addr, function(result, status) {

      // 정상적으로 검색이 완료됐으면
      if (status === kakao.maps.services.Status.OK) {

        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

        // 결과값으로 받은 위치로 마커를 이동시킵니다
        marker.setPosition(coords);

        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
        map.setCenter(coords);
      }
    });
  }

  // 지도 페이지 현재 위치 설정
  $("#searchCusLoc").click(function() {
    navigator.geolocation.getCurrentPosition(success, error, options);
    setAddr2(lat, lon);
  });

  // 지도 페이지 주소 검색
  $("#searchCusAddr").click(function() {
    searchCusAddr($(this).prev().val());
  });

  $(".bt-main.point").click(function() {
    $(this).closest(".modal-wrap").hide();
    $("#wrap").removeClass("transparent");
    $(".userAddr").text($(".input-text.search").val());
    $("#mainAddr").val($(".input-text.search").val());
  });

  /* toggle Like */
  $(document).on("click", ".bt-like", function(e) {
    e.stopPropagation();
    e.preventDefault();
    var uaid = $(this).attr("data-uaid");
    var state = $(this).attr("data-like");
    toggleLike(uaid, state);
  });

  //학원 리스트 현재 위치 설정
  $("#bt-config-loc2").click(function() {
    navigator.geolocation.getCurrentPosition(success, error, options);
    setAddr3(lat, lon);
    var moveLatLon = new kakao.maps.LatLng(lat, lon);
    // 지도 중심을 이동 시킵니다
    map.setCenter(moveLatLon);
  })

});
