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
<link href="../resources/manager/custom/css/student_edit.css" rel="stylesheet">

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
            <h1 class="h3 mb-0 text-gray-800">원생 조회/수정</h1>
          </div>

          <div class="row">

            <!-- 원생 조회영역 -->
            <div class="col-xl-5 col-lg-6">
              <div class="card shadow mb-4">
                <!-- <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                  <h6 class="m-0 font-weight-bold text-primary">검색하기</h6>
                </div> -->
                <!-- Card Body -->
                <!-- eka가입여부, 성별, 학년별, 이름, 전체 -->
                <div class="card-body find_table">
                <form class="" action="index.html" method="post">
                  <table id="student_find">
                    <tr>
                      <th>eka가입여부</th>
                      <td>
                        <input type="radio" class="radio" name="" value="">가입
                        <input type="radio" class="radio" name="" value="">미가입
                      </td>
                      <th>성별</th>
                      <td>
                        <input type="radio" class="radio" name="" value="" >여성
                        <input type="radio" class="radio" name="" value="">남성
                      </td>
                    </tr>
                    <tr>
                      <th>교과과정</th>
                      <td colspan="3">
                        <select class="" name="">
                          <option value="">교과과정1</option>
                        </select>
                        <select class="" name="">
                          <option value="">교과과정2</option>
                        </select>
                      </td>
                    </tr>
                    <tr>
                      <th>이름</th>
                      <td colspan="3">
                        <input type="text" name="" value="">
                        <button class="btn btn-primary btn-sm submit1" type="submit" name="button">
                          검색
                        </button>
                        <button class="btn btn-primary btn-sm submit2" type="button" name="button">
                          전체조회
                        </button>
                      </td>
                    </tr>
                  </table>
                </form>
              </div>
                <div class="card-body">
                  <!-- 검색결과 테이블 -->
                  <p>검색결과</p>
                  <div class="table-responsive">
                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                      <thead>
                        <tr>
                          <th>No</th>
                          <th>이름</th>
                          <th>연락처</th>
                          <th>성별</th>
                          <th>eka가입</th>
                          <th>상세정보</th>
                        </tr>
                      </thead>
                      <tbody>
                        <tr>
                          <form class="" action="index.html" method="post">
                            <td>1</td>
                            <td>훈이</td>
                            <input type="hidden" name="" value="신짱구">
                            <td><a href="tel:">010-6333-3333</a> </td>
                            <input type="hidden" name="" value="미술">
                            <td>남성</td>
                            <td>가입</td>
                            <input type="hidden" name="" value="남성">
                            <td>
                              <button type="submit" name="button"
                              class="btn btn-light btn-sm">보기</button>
                              <!-- 보기 클릭하면 스크립트로 해당하는 데이터의 상세정보 띄우기 -->
                            </td>
                          </form>
                        </tr>
                      </tbody>
                    </table>
                  </div>
                </div>
              </div>
            </div>

            <!-- 원생 상세정보 영역 -->
            <div class="col-xl-7 col-lg-6">
              <div class="card shadow mb-4">
                <!-- Card Header - Dropdown -->
                <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                  <h6 class="m-0 font-weight-bold text-primary">학생정보 상세보기</h6>
                </div>
                <!-- Card Body -->
                <div class="card-body">
                  <!-- 이름, 성별, 생년월일, 연락처, 학부모정보,
                eka가입여부에 따라 + 아이디,이메일 -->
                  <table>
                    <tr>
                      <th>이름</th>
                      <td>김철수</td>
                    </tr>
                    <tr>
                      <th>연락처</th>
                      <td><a href="tel:">010-6333-3333</a></td>
                    </tr>
                    <tr>
                      <th>생년월일</th>
                      <td>000000</td>
                    </tr>
                    <tr>
                      <th>eka 아이디</th>
                      <td>ekaid</td>
                    </tr>
                    <tr>
                      <th>eka email</th>
                      <td><a href="email:">ekahunn@email.com</a></td>
                    </tr>
                  </table>
                  <br>
                  학부모정보
                  <table>
                    <tr>
                      <th>이름</th>
                      <td>철수엄마</td>
                    </tr>
                    <tr>
                      <th>관계</th>
                      <td>모</td>
                    </tr>
                    <tr>
                      <th>연락처</th>
                      <td><a href="tel:">010-6333-3333</a></td>
                    </tr>
                  </table>
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