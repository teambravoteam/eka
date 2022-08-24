$(".bt-tab").on("click", function() {
  $this = $(this);
  $(".sctb-item").removeClass("current");
  $(".sec-tab").hide();
  $this.parent().addClass("current");
  $("#" + $this.data("sec")).show();
});

$(".bt-apply").on("click", function() {
  openModal("apply", $("#uaid").val(), function() {
    $("#modal-wrap").addClass("width-s");
  });
});
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

