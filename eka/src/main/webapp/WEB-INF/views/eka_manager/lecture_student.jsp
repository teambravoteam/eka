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
            <h1 class="h3 mb-0 text-gray-800">수강생 관리</h1>
          </div>

          <div class="card shadow mb-4">
            <div class="card-body">
              <form action="lecture_student_find_all" method="post">
                <table id="lecture_find">
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
                    <th>강사</th>
                    <td>
                      <select class="" name="teacher">
                        <option value="all">--전체--</option>
		 		 		<c:forEach var="teacher" items="${teacher}" varStatus="status">
						<option value="${teacher.name}">${teacher.name}</option>
						</c:forEach>
                      </select>
                    </td>
                  </tr>
                  <tr>
                    <th>기간</th>
                    <td>
                      <input type="date" name="startLectureDate"> ~ <input type="date" name="finishLectureDate">
                    </td>
                    <th>시간</th>
                    <td><input type="time" name="startLectureTime"> ~ <input type="time" name="finishLectureTime"></td>
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
                      <input type="checkbox" class="checkbox" name="lectureDay" value="all" checked>전체</input>
                    </td>
                    <th>정원</th>
                    <td>
                      <input type="number" name="lectureCapacity" value="0">
                      <select class="" name="type1">
                        <option value="up">이상</option>
                        <option value="down">이하</option>
                      </select>
                    </td>
                  </tr>
                  <tr>
                    <th>강좌료</th>
                    <td>
                      <input type="number" name="price" value="0">
                      <select class="" name="type2">
                        <option value="up">이상</option>
                        <option value="down">이하</option>
                      </select>
                    </td>
                    <th>강좌명</th>
                    <td>
                      <input type="text" class="title" name="name">
                    </td>
                  </tr>
                </table>
                <button class="btn btn-primary btn-sm submit" type="button" name="button"
                onclick="location.href='lecture_student_find_all'">
                  <span>전체조회</span>
                </button>
                <button class="btn btn-primary btn-sm submit" type="submit" name="button">
                  <span>검색하기</span>
                </button>
              </form>
            </div>
          </div>
          <!-- 검색결과 테이블 -->
          <div class="card shadow mb-4">
            <div class="card-body">
              <!-- <div class="d-sm-flex align-items-center justify-content-between mb-2">
                  <span></span>
                  <span>
                    <a href="#" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">수정하기</a>
                    <a href="#" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">저장하기</a>
                  </span>
              </div> -->
              <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                  <thead>
                    <tr>
                      <th>No</th>
                      <th>강좌명</th>
                      <th>대상</th>
                      <th>과목</th>
                      <th>담당강사</th>
                      <th>강의시간</th>
                      <th>강의기간</th>
                      <th>강의요일</th>
                      <th>정원</th>
                      <th>수강생관리</th>
                    </tr>
                  </thead>
                  <tbody>
                     <c:forEach var="lecture" items="${lecture}" varStatus="status">
                     	<form action="lecture_student_edit" method="post">
                     	<tr>
                     	 <td>${status.index + 1}</td>
                     	 <td>${lecture.name}</td>
                     	 <td>${lecture.schoolcate} ${lecture.gradecate}</td>
  	                   	 <td>${lecture.subject}</td>
  	                   	 <td>${lecture.teacher}</td>
    	                 <td>${lecture.startLectureTime} ~ ${lecture.finishLectureTime}</td>
        	             <td>${lecture.startLectureDate} ~ ${lecture.finishLectureDate}</td>
            	         <td>${lecture.lectureDay}</td>
                	     <td>${lecture.lectureCapacity}명</td>
                    	 <input type="hidden" name="name" value="${lecture.name}">
                    	 <input type="hidden" name="schoolcate" value="${lecture.schoolcate}">
                    	 <input type="hidden" name="gradecate" value="${lecture.gradecate}">
                    	 <input type="hidden" name="subject" value="${lecture.subject}">
                    	 <input type="hidden" name="teacher" value="${lecture.teacher}">
                    	 <input type="hidden" name="startLectureTime" value="${lecture.startLectureTime}">
                    	 <input type="hidden" name="finishLectureTime" value="${lecture.finishLectureTime}">
                    	 <input type="hidden" name="startLectureDate" value="${lecture.startLectureDate}">
                    	 <input type="hidden" name="finishLectureDate" value="${lecture.finishLectureDate}">
                    	 <input type="hidden" name="lectureDay" value="${lecture.lectureDay}">
                    	 <input type="hidden" name="lectureCapacity" value="${lecture.lectureCapacity}">
                    	 <input type="hidden" name="lid" value="${lecture.lid}">
                    	 <input type="hidden" name="price" value="${lecture.price}">
                    	 <td><button type="submit" name="button"
							class="btn btn-light btn-sm editBtn">등록/삭제</button></td>
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