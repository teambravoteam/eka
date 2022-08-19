$(function() {
	
	// 강사 상세보기버튼 클릭이벤트
	$(".detailBtn").click(function() {

		console.log("detail버튼클릭");

		var str = "";
		var detailBtn = $(this);
		var tr = detailBtn.parent().parent();
		var td = tr.children();

		console.log(tr.text());

		var name = td.eq(1).text();
		var subject = td.eq(2).text();
		var gender = td.eq(3).text();
		var foreigner = td.eq(4).text();
		var ssn = td.eq(5).text();
		var phone = td.eq(6).text();
		var education = td.eq(7).text();
		var career = td.eq(8).text();
		var image = td.eq(9).text();
		var tid = td.eq(10).text();
		var aid = td.eq(11).text();

		var imagesrc = "../resources/teacher_img/" + image;

		str += "<table><tr><td rowspan='9'><img class='resultImg' style='width:100px;height:100px' src='" + imagesrc + "'></td>"
			+ "<td><tr><th>이름</th>"
			+ "<td>" + name + "</td></tr>"
			+ "<tr><th>담당과목</th>"
			+ "<td>" + subject + "</td></tr>"
			+ "<tr><th>성별</th>"
			+ "<td>" + gender + "</td></tr>"
			+ "<tr><th>생년월일</th>"
			+ "<td>" + ssn + "</td></tr>"
			+ "<tr><th>연락처</th>"
			+ "<td><a href='tel:'>" + phone + "</a></td></tr>"
			+ "<tr><th>최종학력</th>"
			+ "<td>" + education + "</td></tr>"
			+ "<tr><th>경력사항</th>"
			+ "<td>" + career + "</td></tr>"
			+ "<tr><th>외국인여부</th>"
			+ "<td>" + foreigner + "</tr></td></tr></table>";

		$("#detail_result").html(str);

	});
	
	// 수정버튼 클릭이벤트
	$(".editBtn").click(function() {
		console.log("editBtn버튼클릭");
		
		var str = "";
		var detailBtn = $(this);
		var tr = detailBtn.parent().parent();
		var td = tr.children();
		//console.log(tr.text());
		
		var name = td.eq(1).text();
		var subject = td.eq(2).text();
		var gender = td.eq(3).text();
		var foreigner = td.eq(4).text();
		var ssn = td.eq(5).text();
		var phone = td.eq(6).text();
		var education = td.eq(7).text();
		var career = td.eq(8).text();
		var image = td.eq(9).text();
		var tid = td.eq(10).text();
		var aid = td.eq(11).text();
		var imagesrc = "../resources/teacher_img/" + image;
		
		var deleteBtn = "'teacher_delete'";

		str += '<form class="" action="teacher_edit" method="post">'
			+ "<table><tr><td rowspan='9'><img class='resultImg' style='width:100px;height:100px' src='" + imagesrc + "'></td>"
			+ "<td><tr><th>이름</th>"
			+ "<td><input type='text' name='name' value='" + name + "'></td></tr>"
			+ "<tr><th>담당과목</th>"
			+ "<td><input type='text' name='subject' value='" + subject + "'></td></tr>"
			+ "<tr><th>성별</th>"
			+ "<td><input type='text' name='gender' value='" + gender + "'></td></tr>"
			+ "<tr><th>생년월일</th>"
			+ "<td><input type='text' name='ssn' value='" + ssn + "'></td></tr>"
			+ "<tr><th>연락처</th>"
			+ "<td><input type='text' name='phone' value='" + phone + "'></td></tr>"
			+ "<tr><th>최종학력</th>"
			+ "<td><input type='text' name='education' value='" + education + "'></td></tr>"
			+ "<tr><th>경력사항</th>"
			+ "<td><input type='text' name='career' value='" + career + "'></td></tr>"
			+ "<tr><th>외국인여부</th>"
			+ "<td><input type='text' name='foreigner' value='" + foreigner + "'></td></tr></tr></table>"
			+ "<input type='hidden' name='tid' value='" + tid + "'>"
			+ "<input type='hidden' name='aid' value='" + aid + "'>"
			+ "<input type='hidden' name='image' value='" + image + "'>"
			+ '<button type="submit" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">저장하기</button>'
			+ '<button type="button" name="delete" onclick="location.href=' + deleteBtn + '"'
			+ 'class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"'
			+ 'value="' + tid +'"'
			+ '>삭제하기</button>'
			+ "</form>";
			+ '<form class="" action="teacher_delete" method="post">'
			+ "<input type='hidden' name='tid' value='" + tid + "'>"
			+ "</form>"
			
			
		// button하나 더 만들어서 tid hidden해두고 삭제버튼만들기
		$("#detail_result").html(str);
	});

});
