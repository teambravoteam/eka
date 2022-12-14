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
<link href="../resources/manager/custom/css/teacher_add.css"
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
					<div class="d-sm-flex align-items-center justify-content-between mb-4">
						<h1 class="h3 mb-0 text-gray-800">${name}</h1>
					</div>
					
			<!-- 수강중인 강의 리스트 -->
			<div class="card shadow mb-4">
            <div class="card-body">
              <div class="d-sm-flex align-items-center justify-content-between mb-2">
                  <span>수강중인 강의</span>
              </div>
              <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0"
                style="margin-bottom:0;">
                  <thead>
                    <tr>
                      <th>No</th>
                      <th>강좌명</th>
                      <th>과목</th>
                      <th>담당강사</th>
                      <th>강의시간</th>
                      <th>강의기간</th>
                      <th>강의요일</th>
                      <th>정원</th>
                      <th>가격</th>
                      <th>조회</th>
                    </tr>
                  </thead>
                  <tbody>
                  <c:forEach var="lecture" items="${lecture}" varStatus="status">
                  	<form class="" action="student_report_lecture" method="post">
                    <tr>
                      <td>${status.index +1}</td>
                      <td>${lecture.name}</td>
                      <td>${lecture.subject}</td>
                      <td>${lecture.teacher}</td>
                      <td>${lecture.startLectureTime} ~ ${lecture.finishLectureTime}</td>
                      <td>${lecture.startLectureDate} ~ ${lecture.finishLectureDate}</td>
                      <td>${lecture.lectureDay}</td>
                      <td>${lecture.lectureCapacity}</td>
                      <td>${lecture.price}</td>
                      <input type="hidden" name="lid" value=${lecture.lid}>
                      <input type="hidden" name="sid" value=${sid}>
                      <input type="hidden" name="name" value=${name}>
                      <td><button type="submit" name="button" id="chart"
                             class="btn btn-light btn-sm">조회</button></td>
                    </tr>
                    </form>
                    </c:forEach>
                  </tbody>
                </table>
            </div>
             
            </div>
          </div>
          
          <div class="row">
          <!-- 출석현황 -->
          <div class="col-xl-5 col-lg-6">
          <div class="card shadow mb-4">
            <div class="card-body">
              <div class="d-sm-flex align-items-center justify-content-between mb-2">
                  <span>출석현황</span>
              </div>
              <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0"
                style="margin-bottom:0;">
                  <thead>
                    <tr>
                      <th>No</th>
                      <th>강좌명</th>
                      <th>날짜</th>
                      <th>출석현황</th>
                    </tr>
                  </thead>
                  <tbody>
                  <c:forEach var="attendance" items="${attendance}" varStatus="status">
                    <tr>
                      <td>${status.index +1}</td>
                      <td>${attendance.lectureName}</td>
                      <td>${attendance.lectureDate}</td>
                      <td>${attendance.checking}</td>
                    </tr>
                    </c:forEach>
                  </tbody>
                </table>
            </div>
              
            </div>
          </div>
          </div>
          <!-- 성적확인 -->
          <div class="col-xl-7 col-lg-6">
          <div class="card shadow mb-4">
            <div class="card-body">
              <div class="d-sm-flex align-items-center justify-content-between mb-2">
                  <span>성적현황</span>
              </div>
              <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0"
                style="margin-bottom:0;">
                  <thead>
                    <tr>
                      <th>No</th>
                      <th>강좌명</th>
                      <th>시험명</th>
                      <th>시험일자</th>
                      <th>점수</th>
                    </tr>
                  </thead>
                  <tbody id="testTable">
                  <c:forEach var="score" items="${score}" varStatus="status">
                    <tr>
                      <td>${status.index +1}</td>
                      <td id="lectureName">${score.lectureName}</td>
                      <td id="testName">${score.testName}</td>
                      <td id="testDate">${score.testDate}</td>
                      <td id="testScore">${score.testScore}</td>
                    </tr>
                    </c:forEach>
                  </tbody>
                </table>
                <!-- Bar Chart -->
                            <%-- <div class="card shadow mb-4">
                                <div class="card-header py-3">
                                    <!-- <h6 class="m-0 font-weight-bold text-primary">Bar Chart</h6> -->
                                </div>
                                <div class="card-body">
                                    <div class="chart-bar">
                                        <canvas id="myBarChart"></canvas>
                                    </div>
                                    
                                </div>
                            </div> --%>
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
	<script src="../resources/manager/js/demo/chart-bar-demo-test.js"></script>

</body>

</html>