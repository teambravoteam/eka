<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>EKA Manager</title>
<!-- Custom fonts for this template-->
<link
	href="../resources/manager/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- 나눔고딕 font -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@400;700;800&display=swap"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="../resources/manager/css/sb-admin-2.min.css"
	rel="stylesheet">
<link href="../resources/manager/custom/css/student_add.css"
	rel="stylesheet">
<!-- jQuery  -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
    $(function() {
      
        $('#mainselect').change(function() {
          var result = $('#mainselect option:selected').val();

          if (result == '초등학교') {
            $('.초등학교').show();
            $('.중학교').hide();
            $('.고등학교').hide();
          } else if (result=='중학교'){
            $('.초등학교').hide();
            $('.중학교').show();
            $('.고등학교').hide();
          } else if (result='고등학교') {
            $('.초등학교').hide();
            $('.중학교').hide();
            $('.고등학교').show();
          }
        });

    });
  </script>


</head>
<style>
body {
	font-family: 'Nanum Gothic', sans-serif !important;
}
</style>
<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- 왼쪽 메뉴바 start -->
		<%@ include file="../eka_manager_incl/navbar.jsp"%>
		<!-- 왼쪽 메뉴바 end -->

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">

				<%@ include file="../eka_manager_incl/header.jsp"%>

				<!-- 컨텐츠 영역 -->
				<div class="container-fluid">

					<!-- Page Heading -->
					<div
						class="d-sm-flex align-items-center justify-content-between mb-4">
						<h1 class="h3 mb-0 text-gray-800 content-title">신규 원생 등록</h1>
					</div>
					<div class="card shadow mb-4">
						<div class="card-body">
							<form class="" action="student_add" method="post">
								<h5>학생정보</h5>
								<table id="student_add">
									<tr>
										<th>학생명</th>
										<td><input type="text" name="name"> 
										<input type="radio" name="gender" value="남" class="radio"><span>남</span>
										<input type="radio" name="gender" value="여" class="radio"><span>여</span></td>
										<th>교과과정</th>
										<td><select class="category" name="schoolcate" id="mainselect">
												<option>선택</option>
												<c:forEach var="school" items="${school}">
													<option value="${school.schoolcate}">${school.schoolcate}</option>
												</c:forEach>
										</select> <select class="category" name="gradecate">
												<option>선택</option>
												<c:forEach var="grade" items="${grade}" >
													<option class="${grade.schoolcate}" value="${grade.gradecate}">${grade.gradecate}</option>
												</c:forEach>
										</select></td>
									</tr>
									<tr>
										<th>생년월일</th>
										<td><input type="date" class="eka-id" name="ssn"></td>
										<th>연락처</th>
										<td><select class="phone" name="phone1">
												<option value="010">010</option>
												<option value="011">011</option>
										</select> - <input type="text" class="phone" name="phone2"> - <input
											type="text" class="phone" name="phone3"></td>
									</tr>
									<tr>
										<th>eka 아이디(선택)</th>
										<td colspan="3"><input type="text" name="ekaUserId" class="eka-id"></td>
									</tr>
								</table>

								<h5>학부모정보(선택)</h5>
								<table id="student_add_parent">
									<tr>
										<th>학부모명</th>
										<td><input type="text" name="parentName"> 
										<input type="radio" class="radio" name="parentType" value="부">부 
										<input type="radio" class="radio" name="parentType" value="모">모
										</td>
									</tr>
									<tr>
										<th>연락처</th>
										<td><select class="phone" name="parentPhone1">
												<option value="010">010</option>
												<option value="011">011</option>
										</select> - <input type="text" class="phone" name="parentPhone2"> - <input
											type="text" class="phone" name="parentPhone3"></td>
									</tr>
								</table>

								<button class="btn btn-primary btn-sm submit" type="submit"
									name="button">
									<span>등록하기</span>
								</button>

							</form>

						</div>
					</div>
				</div>
				<!-- 컨텐츠 영역 끝-->

			</div>
			<!-- End of Main Content -->

			<!-- Footer -->
			<%@ include file="../eka_manager_incl/footer.jsp"%>

			<!-- End of Footer -->

		</div>
		<!-- End of Content Wrapper -->

	</div>
	<!-- End of Page Wrapper -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>

	<!-- Logout Modal-->
	<%@ include file="../eka_manager_incl/logout_modal.jsp"%>

	<!-- Bootstrap core JavaScript-->
	<script src="../resources/manager/vendor/jquery/jquery.min.js"></script>
	<script
		src="../resources/manager/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script
		src="../resources/manager/vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="../resources/manager/js/sb-admin-2.min.js"></script>

	<!-- Page level plugins -->
	<script src="../resources/manager/vendor/chart.js/Chart.min.js"></script>

	<!-- Page level custom scripts -->
	<script src="../resources/manager/js/demo/chart-area-demo.js"></script>
	<script src="../resources/manager/js/demo/chart-pie-demo.js"></script>

</body>

</html>