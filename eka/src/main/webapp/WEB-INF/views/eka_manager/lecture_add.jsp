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
<link href="../resources/manager/custom/css/lecture_add.css" rel="stylesheet">

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
          <div class="d-sm-flex align-items-center justify-content-between mb-4">
            <h1 class="h3 mb-0 text-gray-800">강좌 등록</h1>
          </div>

          <div class="card shadow mb-4">
            <div class="card-body">
              <form class="" action="lecture_add" method="post">
                <table id="lecture_add">
                  <tr>
                    <th>강좌명</th>
                    <td>
                      <input type="text" class="title" name="name">
                    </td>
                    <th>과목</th>
                    <td>
                    <select id="mainselect" name="schoolcate">
                        <c:forEach var="school" items="${school}" varStatus="status">
                        	<option value="${school.schoolcate}">${school.schoolcate}</option>						
						</c:forEach>
                      </select>
                      <select class="" name="gradecate">
                        <c:forEach var="grade" items="${grade}" varStatus="status">
                        	<option class="${grade.schoolcate}" value="${grade.gradecate}">${grade.gradecate}</option>						
						</c:forEach>
                      </select>
                      <select class="" name="subject">
                        <c:forEach var="subject" items="${subject}" varStatus="status">
                        	<option value="${subject.subjectcate}">${subject.subjectcate}</option>						
						</c:forEach>
                        <!-- <option value="null">직접입력</option> -->
                        <!-- 직접입력으로 입력하면 카테고리에 추가, input 활성화 -->
                      </select>
                      <!-- <input type="text" name="subject" disabled> -->
                    </td>
                  </tr>
                  <tr>
                    <th>기간</th>
                    <td><input type="date" name="startLectureDate">&nbsp~
                    <input type="date" name="finishLectureDate"></td>
                    <th>시간</th>
                    <td><input type="time" name="startLectureTime">&nbsp~
                    <input type="time" name="finishLectureTime"></td>
                  </tr>
                  <tr>
                    <th>요일</th>
                    <td>
                      <input type="checkbox" class="checkbox" name="lectureDay" value="월">월</input>
                      <input type="checkbox" class="checkbox" name="lectureDay" value="화">화</input>
                      <input type="checkbox" class="checkbox" name="lectureDay" value="수">수</input>
                      <input type="checkbox" class="checkbox" name="lectureDay" value="목">목</input>
                      <input type="checkbox" class="checkbox" name="lectureDay" value="금">금</input>
                      <input type="checkbox" class="checkbox" name="lectureDay" value="토">토</input>
                      <input type="checkbox" class="checkbox" name="lectureDay" value="일">일</input>
                    </td>
                    <th>담당강사</th>
                    <td>
                      <select class="" name="teacher">
                        <option value="null">선택안함</option>
                        <c:forEach var="teacher" items="${teacher}" varStatus="status">
                        	<option value="${teacher.name}">${teacher.name}</option>						
						</c:forEach>
                      </select>
                    </td>
                  </tr>
                  <tr>
                    <th>정원</th>
                    <td><input type="number" class="number" name="lectureCapacity" value="0">&nbsp명</td>
                    <th>가격</th>
                    <td><input type="number" class="price" name="price" value="0">&nbsp원</td>
                  </tr>
                </table>
                <button class="btn btn-primary btn-sm submit" type="submit" name="button">
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