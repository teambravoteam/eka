//아이디
$('#userId').on('keyup', function() {
  var id = $(this).val();
  if (id.match(/^[a-z0-9_-]{5,20}$/)) {
    $('#userIdGuide').text('');
  } else if (!id.match(/^[a-z0-9_-]{5,20}$/)) {
    $('#userIdGuide').removeClass('safe').addClass('warning').text('5~20자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능합니다.');
  }
});

//비밀번호
$('#userPass').on('keyup', function() {
  var pw = $(this).val();
  if (pw.match(/^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{5,20}$/)) {
	$(this).removeClass('warning').addClass('safe');
    $('#userPassGuide').removeClass('warning').addClass('safe').text('사용가능한 비밀번호입니다.');
  } else if (!pw.match(/^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{5,20}$/)) {
	$(this).removeClass('safe').addClass('warning');
    $('#userPassGuide').removeClass('safe').addClass('warning').text('5~20자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능합니다.');
  }
});
$('#userPassConfirm').on('keyup', function () {
    if($(this).val().length == 0){
        $(this).removeClass('warning checked');
        $('#userPassConfirmGuide').text('');
    }else if($(this).val() != $('#userPass').val()){
        $(this).removeClass('checked').addClass('warning');
        $('#userPassConfirmGuide').addClass('warning').text('일치하지 않습니다.');
    }else{
        $(this).removeClass('warning').addClass('checked');
        $('#userPassConfirmGuide').text('');
    }
});

//이메일
$('#userEmail').on('keyup', function() {
  var email = $(this).val();
  if (email.match(/^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/)) {
    $('#userEmailGuide').text('');
  } else if (!email.match(/^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/)) {
    $('#userEmailGuide').removeClass('safe').addClass('warning').text('올바른 이메일을 입력해주세요 (@)포함');
  }
});

//주민번호
$('#userSsn').on('keyup', function() {
  var ssn = $(this).val();
  if (ssn.match(/^(?:[0-9]{2}(?:0[1-9]|1[0-2])(?:0[1-9]|[1,2][0-9]|3[0,1]))-[1-8][0-9]{6}$/)) {
    $('#userSsnGuide').removeClass('warning').addClass('safe').text('');
  } else if (!ssn.match(/^(?:[0-9]{2}(?:0[1-9]|1[0-2])(?:0[1-9]|[1,2][0-9]|3[0,1]))-[1-8][0-9]{6}$/)) {
    $('#userSsnGuide').removeClass('safe').addClass('warning').text('올바른 주민등록번호를 입력해주세요 (-)포함');
  }
});

//폰번호
$('#userPhone').on('keyup', function() {
  var phone = $(this).val();
  if (phone.match(/^\d{3}-\d{3,4}-\d{4}$/)) {
    $('#userPhoneGuide').removeClass('warning').addClass('safe').text('사용가능한 번호입니다.');
  } else if (!phone.match(/^\d{3}-\d{3,4}-\d{4}$/)) {
    $('#userPhoneGuide').removeClass('safe').addClass('warning').text('올바른 휴대폰번호를 입력해주세요. (-)포함');
  }
});

