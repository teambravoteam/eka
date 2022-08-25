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
<link href="../resources/manager/custom/css/attendance.css"
	rel="stylesheet">

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
						<h1 class="h3 mb-0 text-gray-800 content-title">출석하기</h1>
					</div>

					<!-- 출석부조회 -->
					<div class="card shadow mb-4">
						<div class="card-body">
							<form class="" action="find_lecture_student" method="post">
								<table id="attendance">
									<tr>
										<th>강좌</th>
										<td><select class="" name="lectureName">
												<c:forEach var="lecture" items="${lecture}"
													varStatus="status">
													<option value="${lecture.name}">${lecture.name}</option>
												</c:forEach>
										</select></td>
										<th>날짜</th>
										<td><input type="date" name="" value=""> <!-- js로 오늘 날짜 기본값으로 설정 -->
											<button class="btn btn-primary btn-sm submit" type="submit"
												name="button">
												<span>조회하기</span>
											</button></td>
									</tr>
								</table>
							</form>
							<table>

							</table>

						</div>
					</div>

					<!-- 출석테이블 -->
					<div class="card shadow mb-4">
						<div class="card-body">
							<div
								class="d-sm-flex align-items-center justify-content-between mb-2">
								<h5>출석부</h5>
								<form action="attendance_finish" method="post">
									<button class="btn btn-primary btn-sm submit" type="submit"
										name="button">
										<span>출석부 저장</span>
									</button>
								</form>
							</div>

							<table class="table table-bordered">
								<thead>
									<tr>
										<th>No</th>
										<th>이름</th>
										<th>출결</th>
										<th>출석상황</th>
										<th>특이사항</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="lectureStudent" items="${lectureStudentList}"
										varStatus="status">
										<tr>
											<td>${status.count}</td>
											<td>${lectureStudent.student.name}</td>
											<td>
												<form action="attendance_check" method="post"
													style="display: inline-block;">
													<input type="hidden" name="studentId"
														value="${lectureStudent.student.sid}">
													<button class="btn btn-primary btn-sm submit" type="submit"
														name="button">
														<span>출석</span>
													</button>
												</form>
												<form action="absence_check" method="post"
													style="display: inline-block;">
													<input type="hidden" name="studentId"
														value="${lectureStudent.student.sid}">
													<button class="btn btn-primary btn-sm submit" type="submit"
														name="button">
														<span>결석</span>
													</button>
												</form>
												<form action="late_check" method="post"
													style="display: inline-block;">
													<input type="hidden" name="studentId"
														value="${lectureStudent.student.sid}">
													<button class="btn btn-primary btn-sm submit" type="submit"
														name="button">
														<span>지각</span>
													</button>
												</form>

											</td>
											<td>${lectureStudent.attendanceType }</td>
											<td><input type="text" name="" value=""></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
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