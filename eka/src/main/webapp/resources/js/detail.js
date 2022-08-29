$(".bt-tab").on("click", function() {
  $this = $(this);
  $(".sctb-item").removeClass("current");
  $(".sec-tab").hide();
  $this.parent().addClass("current");
  $("#" + $this.data("sec")).show();
});
$(".bt-sec-header").on("click", function() {
  $(this).parent().toggleClass("close");
});

$("#onBtn").on("click", function() {
	$(".modal-back").addClass('on');
	var con = document.getElementById("modal-wrap");
	if (con.style.display == "none") {
	  con.style.display = "block";
	}
});
/*
$(".bt-notSame").on("click", function() {
	elert("본인 소유의 학원만 수정이 가능합니다");
});
*/
$(".bt-icon.close").on("click", function() {
	$(".modal-back").removeClass('on');
})

$(".bt-share").on("click", function() {
  if (typeof webkit != 'undefined' && typeof webkit.messageHandlers != 'undefined' && typeof webkit.messageHandlers.HybridBridge != 'undefined') {
    webkit.messageHandlers.HybridBridge.postMessage({
      'funcType': 'shareText',
      'text': window.location.href
    });
  } else {
    var dummy = document.createElement("textarea");
    document.body.appendChild(dummy);
    dummy.value = window.location.href;
    dummy.select();
    document.execCommand("copy");
    document.body.removeChild(dummy);
    alert("클립보드로 주소가 복사되었습니다");
  }
});

$('.academy-picture-list li').on('click', function() {
  openModal('imageView', $(this).data('view'), function() {

  });
});

$('.bt-more').on('click', function() {
  $target = $(this).parent().prev().find("li");
  if ($(this).hasClass("hide")) {
    $target.each(function(i, elmt) {
      if (i > 11) {
        $target.eq(i).addClass("hide");
      }
    });
    $(this).removeClass("hide").text("더보기");
  } else {
    $target.removeClass("hide");
    $(this).addClass("hide").text("숨기기");
  }
});

$('.academy-document-list li').on('click', function() {
  openModal('picture', $(this).find('img').attr('src'), function() {

  });
});
