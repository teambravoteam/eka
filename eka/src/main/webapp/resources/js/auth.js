$('#userId').on('keyup', function() {
  var id = $(this).val();
  if (id.length == 0) {
    $('#userIdGuide').text('');
  } else if (id.match(/^[a-z0-9_-]{5,20}$/)) {
    verifyService("userId", id, function(verify) {
      if (verify) {
        $('#userIdGuide').removeClass('warning').addClass('safe').text('사용가능한 아이디입니다.');
      } else {
        $('#userIdGuide').removeClass('safe').addClass('warning').text('이미 사용중이거나 탈퇴한 아이디입니다.');
      }
    });
  } else {
    $('#userIdGuide').removeClass('safe').addClass('warning').text('5~20자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능합니다.');
  }
});
$('#userPass').on('keyup', function() {
  var strength = checkStrength($(this).val());
  $('#userPassConfirm').trigger("keyup");
  if (strength == -1) {
    $(this).removeClass('warning safe');
    $('#userPassGuide').text('');
  } else if (strength < 2) {
    $(this).removeClass('safe').addClass('warning');
    $('#userPassGuide').removeClass('safe').addClass('warning').text('8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.');
  } else if (strength == 2) {
    $(this).removeClass('warning').addClass('safe');
    $('#userPassGuide').removeClass('warning').addClass('safe').text('사용가능한 비밀번호입니다.');
  } else {
    $(this).removeClass('warning').addClass('safe');
    $('#userPassGuide').removeClass('warning').addClass('safe').text('안전한 비밀번호입니다.');
  }
});
$('#userPassConfirm').on('keyup', function() {
  if ($(this).val().length == 0) {
    $(this).removeClass('warning checked');
    $('#userPassConfirmGuide').text('');
  } else if ($(this).val() != $('#userPass').val()) {
    $(this).removeClass('checked').addClass('warning');
    $('#userPassConfirmGuide').addClass('warning').text('일치하지 않습니다.');
  } else {
    $(this).removeClass('warning').addClass('checked');
    $('#userPassConfirmGuide').text('');
  }
});
$('#userEmail').on('keyup', function() {
  var email = $(this).val();
  if (email.length == 0) {
    $('#userEmailGuide').text('');
  } else if (email.match(/^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/)) {
    $('#userEmailGuide').removeClass('warning').addClass('safe').text('사용가능한 이메일입니다.');
  } else {
    $('#userEmailGuide').removeClass('safe').addClass('warning').text('올바른 이메일 형식을 입력해주세요.');
  }
});
$('#userPhone').on('keyup', function() {
  var phone = $(this).val();
  verifyTimer.fnStop();
  $("#userPhoneVerify").val('');
  if (phone.length == 0) {
    $('#userPhoneGuide').text('');
  } else if (phone.match(/^(01[016789])([1-9]{1}[0-9]{2,3})([0-9]{4})$/)) {
    verifyService("userPhone", phone, function(verify) {
      if (verify) {
        $('#userPhoneGuide').removeClass('warning').addClass('safe').text('사용가능한 번호입니다.');
      } else {
        $('#userPhoneGuide').removeClass('safe').addClass('warning').text('이미 사용중인 번호입니다.');
      }
    });
  } else {
    $('#userPhoneGuide').removeClass('safe').addClass('warning').text('올바른 휴대폰번호를 입력해주세요. (-)제외');
  }
});
for (i = new Date().getFullYear() - 14; i > 1900; i--) {
  $('#bday-year').append($('<option />').val(i).html(i));
}
for (i = 1; i < 13; i++) {
  $('#bday-month').append($('<option />').val(i).html(i));
}
(updateNumberOfDays = function() {
  day = $('#bday-day').html('');
  month = $('#bday-month').val();
  year = $('#bday-year').val();
  days = new Date(year, month, 0).getDate();
  for (i = 1; i < days + 1; i++) {
    day.append($('<option />').val(i).html(i));
  }
})();
$('#bday-year, #bday-month').on("change", function() {
  updateNumberOfDays();
});