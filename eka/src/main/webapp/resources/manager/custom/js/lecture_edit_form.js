$(function() {
	// 들어온 input값으로 select option 선택
	// 교육과정 카테고리
	var school_cate = $('input[name=schoolcateinput]').val();
	console.log(school_cate);
	$('#school').val(school_cate).prop("selected", true);
	var grade_cate = $('input[name=gradecateinput]').val();
	console.log(grade_cate);
	$('#grade').val(grade_cate).prop("selected", true);
	var subject_cate = $('input[name=subjectcateinput]').val();
	console.log(subject_cate);
	$('#subject').val(subject_cate).prop("selected", true);
	
	// 강사
	var teacher = $('input[name=teacherinput]').val();
	console.log(teacher);
	$('#teacher').val(teacher).prop("selected", true);
	
	// 요일
	var day = $('input[name=dayinput]').val();
	day.split(",");
	
	$('.checkbox').prop('checked', false);
	
	/*for(var checkday in day) {
		$("input[value=" + day[checkday] + "]").prop("checked", true);
	}*/
	
	
	for (var i=0; i<day.length; i++) {
		var dayName = day[i];
		console.log(dayName);
		if (dayName == ",") {
			continue;
		}
		
		$("input:checkbox[value=" + dayName + "]").prop("checked", true);
	}
	
	

});
