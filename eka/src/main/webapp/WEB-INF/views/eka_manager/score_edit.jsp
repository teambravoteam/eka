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
<link href="../resources/manager/custom/css/score_add.css" rel="stylesheet">

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
          <div class="d-sm-flex align-items-center justify-content-between mb-4">
            <h1 class="h3 mb-0 text-gray-800 content-title">성적 조회/수정</h1>
          </div>

          <!-- 학원 시험 등록 -->
          <div class="card shadow mb-4">
            <div class="card-body">
              <form class="" action="index.html" method="post">
                <h5>시험정보 등록</h5>
                <table id="student_add">
                  <tr>
                    <th>강좌</th>
                    <td>
                      <select class="" name="">
                        <option value="">현재강의중인강좌리스트</option>
                      </select>
                    </td>
                    <th>시행일자</th>
                    <td>
                      <input type="date" name="" value="">
                    </td>
                    <th>시험명</th>
                    <td>
                      <input type="text">
                      <button class="btn btn-primary btn-sm submit" type="submit" name="button">
                        <span>등록하기</span>
                      </button>
                    </td>
                  </tr>
                </table>
              </form>

            </div>
          </div>


          <div class="row">
            <!-- 시험리스트 조회 -->
            <div class="col-xl-5 col-lg-6">
              <div class="card shadow mb-4">
                <div class="card-body">
                  <form class="" action="index.html" method="post">
                    <table>
                      <tr>
                        <th>강의명</th>
                        <td>
                          <select class="" name="">
                            <option value="">강의리스트</option>
                          </select>
                          <button type="submit" name="button">조회</button>
                        </td>
                      </tr>
                    </table>
                  </form>
                  <table class="table table-bordered">
                    <thead>
                      <tr>
                        <th>No</th>
                        <th>강의명</th>
                        <th>과목</th>
                        <th>시험명</th>
                        <th>시험일자</th>
                        <th>성적입력</th>
                      </tr>
                    </thead>
                    <tbody>
                      <tr>
                        <td>1</td>
                        <td>현대미술의 이해</td>
                        <td>미술</td>
                        <td>단어쪽지시험</td>
                        <td>2022/08/12</td>
                        <td>
                          <button type="submit" name="button" class="btn btn-light btn-sm">입력</button>
                        </td>
                        <!-- 조회 -> 조회만되게
                        입력-> 점수부분 input으로 -->
                      </tr>
                    </tbody>
                  </table>
                </div>
              </div>
            </div>
            <!-- 학생별 시험성적 등록 -->
            <div class="col-xl-7 col-lg-6">
              <div class="card shadow mb-4">
                <div class="card-body">
                  <table class="table table-bordered">
                    <thead>
                      <tr>
                        <th>No</th>
                        <th>학생ID</th>
                        <th>학생명</th>
                        <th>area</th>
                        <th>testType</th>
                        <th>subject</th>
                        <th>점수</th>
                      </tr>
                    </thead>
                    <tbody>
                      <tr>
                        <td>1</td>
                        <td>30</td>
                        <td>철수</td>
                        <td>학원</td>
                        <td>강의명</td>
                        <td>시험이름</td>
                        <td><input type="number"></td>
                      </tr>
                    </tbody>
                  </table>
                  <button type="button" name="button">입력하기</button>


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