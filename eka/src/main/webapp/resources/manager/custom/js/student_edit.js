$(function() {
	console.log("하이");

	$(".btn-list").click(function(){
		
		console.log("상세정보보기 버튼 클릭");

	var str = "";
	var detailbtn = $(this);
	var tr = detailbtn.parent().parent().parent();
	var td = tr.children();

	console.log(tr.text());

	var name = td.eq(1).text();
	var phone = td.eq(2).a.text();
	var ssn = td.eq(3).text();
	var ekaid = td.eq(5).text();
	var parentname = td.eq(6).text();
	var parenttype = td.eq(7).text();
	var parentphone = td.eq(8).a.text();

	str += "<table>"
		+ "<tr>"
		+ "<th>이름</th>"
		+ "<td>" + name + "</td>"
		+ "</tr>"
		+ "<tr>"
		+ "<th>연락처</th>"
		+ "<td><a href=" + tel + ">" + phone + "</a></td>"
		+ "</tr>"
		+ "<tr>"
		+ "<th>생년월일</th>"
		+ "<td>" + ssn + "</td>"
		+ "</tr>"
		+ "<tr>"
		+ "<th>eka 아이디</th>"
		+ "<td>" + ekaid + "</td>"
		+ "<tr>"
		+ "</table>"
		+ "<br> 학부모정보"
		+ "<table>"
		+ "<tr>"
		+ "<th>이름</th>"
		+ "<td>" + parentname + "</td>"
		+ "</tr>"
		+ "<tr>"
		+ "<th>관계</th>"
		+ "<td>" + parenttype + "</td>"
		+ "</tr>"
		+ "<tr>"
		+ "<th>관계</th>"
		+ "<td>" + parenttype + "</td>"
		+ "</tr>"
		+ "<tr>"
		+ "<th>연락처</th>"
		+ "<td><a href=" + tel + ">" + parentphone + "</a></td>"

	$("#detail_list").html(str);
		
		
	})




})