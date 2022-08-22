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

<!-- jQuery  -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

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
<link href="../resources/manager/custom/css/teacher_edit.css"
	rel="stylesheet">
 <script type="text/javascript" src="../resources/manager/custom/js/teacher_edit.js"></script>

</head>
<style>
body {
	font-family: 'Nanum Gothic', sans-serif !important;
}
</style>
<body id="page-top">


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
				<h1 class="h3 mb-0 text-gray-800">강사 조회/수정</h1>
			</div>

			<div class="row">

				<!-- 강사 조회영역 -->
				<div class="col-xl-5 col-lg-6">
					<div class="card shadow mb-4">
						<!-- Card Header - Dropdown -->
						<div
							class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
							<h6 class="m-0 font-weight-bold text-primary">검색하기</h6>
						</div>
						<!-- Card Body -->
						<div class="card-body">
						  <form action="teacher_find" method="post">
							<table id="teacher_find">
								<tr>
									<th>과목</th>
									<td>
										<select class="" name="subject">
										<option value="all">--전체--</option>
										<c:forEach var="subject" items="${subject}" varStatus="status">
										<option value="${subject.subjectcate}">${subject.subjectcate}</option>
										</c:forEach>
										</select>
									</td>
									<th>성별</th>
									<td><input type="radio" class="radio" name="gender" value="여">여
										<input type="radio" class="radio" name="gender" value="남">남
										<input type="radio" class="radio" name="gender" value="all" checked>전체
									</td>
								</tr>
								<tr>
									<th>외국인여부</th>
									<td>
									  <input type="checkbox" class="checkbox" name="foreigner" value="true">외국인
									  <input type="checkbox" class="checkbox" name="foreigner" value="false">내국인
									  <input type="checkbox" class="checkbox" name="foreigner" value="all" checked>전체
									  
									  </td>
									  <!-- js로 외국인 check하면 내국인 체크 풀리게 -->
									<th>강사명</th>
									<td>
										<input type="text" name="name">
									</td>
								</tr>
							</table>
							<button class="btn btn-primary btn-sm" type="submit" name="button">
								<span>검색하기</span>
							</button>
							<button class="btn btn-primary btn-sm" type="button" name="button" onclick="location.href='teacher_find_all'">
								<span>전체조회</span>
							</button>
						  </form>
						<!-- 검색결과 테이블 -->
						<div class="table-responsive">
							<table class="table table-bordered" id="dataTable"
								width="100%" cellspacing="0">
								<thead>
									<tr>
										<th>No</th>
										<th>강사명</th>
										<th>담당과목</th>
										<th>성별</th>
										<th>외국인여부</th>
										<th>상세정보</th>
									</tr>
								</thead>
								<tbody>
								<c:forEach var="teacher_list" items="${teacher_list}" varStatus="status">
								<tr>
									<td>${status.index + 1}</td>
									<td>${teacher_list.name}</td>
									<td>${teacher_list.subject}</td>
									<td>${teacher_list.gender}</td>
									<td>${teacher_list.foreigner}</td>
									<td style="display:none">${teacher_list.ssn}</td>
									<td style="display:none">${teacher_list.phone}</td>
									<td style="display:none">${teacher_list.education}</td>
									<td style="display:none">${teacher_list.career}</td>
									<td style="display:none">${teacher_list.image}</td>
									<td style="display:none">${teacher_list.tid}</td>
									<td style="display:none">${teacher_list.academy.aid}</td>
									<td><button type="button" name="button"
										class="btn btn-light btn-sm detailBtn">보기</button>
										<button type="button" name="button"
										class="btn btn-light btn-sm editBtn">수정</button>
									</td>
								</tr>
								</c:forEach>
							</tbody>
							</table>
					</div>
				</div>
			</div>
		</div>

				<!-- 강사 상세정보 영역 -->
				<div class="col-xl-7 col-lg-6">
					<div class="card shadow mb-4">
						<!-- Card Header - Dropdown -->
						<div
							class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
							<h6 class="m-0 font-weight-bold text-primary">강사 상세보기</h6>
						</div>
						<!-- Card Body -->
						<div class="card-body">
							<div id="detail_result">
							<!-- 상세정보 결과 테이블 -->
							</div>
						</div>
					</div>
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