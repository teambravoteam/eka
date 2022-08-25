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
<link href="../resources/manager/custom/css/lecture_edit.css"
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
            <h1 class="h3 mb-0 text-gray-800">수강생 등록/삭제</h1>
          </div>

          <div class="card shadow mb-4">
            <!-- <div class="card-body"> -->
              <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0"
                style="margin-bottom:0;">
                  <thead>
                    <tr>
                      <th>강좌명</th>
                      <th>과목</th>
                      <th>담당강사</th>
                      <th>강의시간</th>
                      <th>강의기간</th>
                      <th>강의요일</th>
                      <th>정원</th>
                      <th>가격</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <td>${lecture.name}</td>
                      <td>${lecture.subject}</td>
                      <td>${lecture.teacher}</td>
                      <td>${lecture.startLectureTime} ~ ${lecture.finishLectureTime}</td>
                      <td>${lecture.startLectureDate} ~ ${lecture.finishLectureDate}</td>
                      <td>${lecture.lectureDay}</td>
                      <td>${lecture.lectureCapacity}</td>
                      <td>${lecture.price}</td>
                    </tr>
                  </tbody>
                </table>
            </div>
              <!-- </div> -->
          </div>
          <div class="card shadow mb-4">
            <div class="card-body">
              <div class="d-sm-flex align-items-center justify-content-between mb-2">
                  <!-- <span>학생등록테이블</span> -->
              </div>
              <form action="lecture_student_find" action="index.html" method="post">
                <table id="lecture_find">
                <input type="hidden" name="lid" value="${lecture.lid}">
                  <tr>
                    <th>이름</th>
                    <td>
                      <input type="text" name="name">
                      <button class="btn btn-primary btn-sm submit" type="submit" name="button">
                        <span>검색하기</span>
                      </button>
                    </td>
                  <tr>
                </table>
              </form>
              <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                  <thead>
                    <tr>
                      <th>No</th>
                      <th>이름</th>
                      <th>생년월일</th>
                      <th>연락처</th>
                      <th>추가</th>
                    </tr>
                  </thead>
                  <tbody>
                  <c:forEach var="student" items="${student}" varStatus="status">
                  <form action="lecture_student_add" method="post">
                    <tr>
                      <td>${status.index + 1}</td>
                      <td>${student.name}</td>
                      <td>${student.ssn}</td>
                      <td>${student.phone}</td>
                      <td><button type="submit" name="button"
                             class="btn btn-light btn-sm">추가</button></td>
                      <input type="hidden" name="sid" value="${student.sid}">
                      <input type="hidden" name="lid" value="${lecture.lid}">
                      <input type="hidden" name="aid" value="${lecture.academy.aid}">
                    </tr>
                    </form>
                  </c:forEach>
                  </tbody>
                </table>
              </div>
            </div>
          </div>
          <div class="card shadow mb-4">
            <div class="card-body">
              <div class="d-sm-flex align-items-center justify-content-between mb-2">
                  <span>수강생 목록</span>
              </div>
              <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                  <thead>
                    <tr>
                      <th>No</th>
                      <th>이름</th>
                      <th>생년월일</th>
                      <th>연락처</th>
                      <th>추가</th>
                    </tr>
                  </thead>
                  <tbody>
                  <c:forEach var="lectureStudentList" items="${lectureStudentList}" varStatus="status">
                  <form action="lecture_student_delete" method="post">
                    <tr>
                      <td>${status.index + 1}</td>
                      <td>${lectureStudentList.name}</td>
                      <td>${lectureStudentList.ssn}</td>
                      <td>${lectureStudentList.phone}</td>
                      <input type="hidden" name="sid" value="${lectureStudentList.sid}"/>
                      <input type="hidden" name="lid" value="${lecture.lid}"/>
                      <td><button type="submit" name="button"
                             class="btn btn-light btn-sm">삭제</button></td>
                    </tr>
                     </form>
                  </c:forEach>
                  </tbody>
                </table>
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