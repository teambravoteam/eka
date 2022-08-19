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
          <h1 class="h3 mb-2 text-gray-800">상담요청 리스트</h1>
          <p class="mb-4">상담요청 리스트입니다. 상담이 완료되면 추가버튼을 눌러 상담테이블에 추가해주세요.
          </p>
          
          <div class="card shadow mb-4">
                <div class="card-body">
                        <table id="consulting_add">
                        <form method="post" action="update_consulting">
                         <tr>
                            <th>신청자이름</th>
                            <td><input type="text" name = "name" value="${applyConsult.name}"></td>
                            <th>연락처</th>
                            <td>
                              <select class="phone" name="">
                                <option value="">010</option>
                                <option value="">011</option>
                              </select>
                              - <input type="text" name="phone2" class="phone" value="${applyConsult.phone2}"> - <input type="text" name="phone3" class="phone" value="${applyConsult.phone3}">
                          </td>
                          </tr>
                          <tr>
                            <th>신청일자</th>
                            <td><input type="date" name="applyDate" value="${applyConsult.applyDate }"></td>
                            <th>상담일자</th>
                            <td><input type="date" name="registDate"></td>                                                         
                          </tr>
                          <tr>
                           <th>상담유형</th>
                          <td>                              
                              <input type="text" name="consultCategory" value="${applyConsult.consultCategory.category}">
                            </td>                                                  
                          </tr>  
                          <tr>
                           <th>상담내용</th>
                          <td>                              
                             <textarea rows="40" cols="3" name="consultContent" style="width:400px; height:150px;"></textarea>
                            </td>                                                  
                          </tr>                                                 
                        </table>
                        <button class="btn btn-primary btn-sm submit" type="submit" name="button">
                          <span>등록하기</span>
                        </button>
                        </form>
                       </div>
                    </div>
          

          <div class="card shadow mb-4">
            <div class="card-body">   
              <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                  <thead>
                    <tr>
                      <th>No</th>
                      <th>신청자성함</th>
                      <th>연락처</th>
                      <th>상담유형</th>
                      <th>신청내용</th>                      
                      <th>신청일자</th>                     
                      <th>확인</th>
                    </tr>
                  </thead>
                  <tbody>                 
					<c:forEach var="applyConsulting" items="${applyConsultingList}" varStatus="status">
					<form action="applyconsulting_select" method="post">
					 <tr>
                      <td>${status.count}</td>
                      <td>${applyConsulting.name}</td>
                      <input type ="hidden" name="name" value="${applyConsulting.name}" />
                      <td><a href="tel:">${applyConsulting.phone}</a></td>
                      <td>${applyConsulting.consultCategory.category }</td>
                      <td>${applyConsulting.consultDatail}</td>                     
                      <td>${applyConsulting.applyDate}</td>
                      <input type ="hidden" name="applyDate" value="${applyConsulting.applyDate}" />
                      <input type ="hidden" name="consultType" value="${applyConsulting.consultType}" />                      
                      <td>
                        <button type="submit" name="button" class="btn btn-light btn-sm">추가</button>
                      </td>
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