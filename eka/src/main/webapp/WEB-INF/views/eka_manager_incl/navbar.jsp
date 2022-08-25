<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
@import url('https://fonts.googleapis.com/css2?family=Nanum+Pen+Script&display=swap');

.eka_logo {
font-family: 'Julietta';
text-transform: lowercase;
font-size: 50px;
font-weight: normal;
}
</style>
<link href="../resources/css/font.css" type="text/css" rel="stylesheet">
</head>
<body>
<ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

            <!-- 상단 로고 영역 -->
            <!-- <a class="sidebar-brand d-flex align-items-center justify-content-center" href="main">
                <div class="sidebar-brand-icon rotate-n-15">
                    <i class="fas fa-laugh-wink"></i>
                </div>
               <div class="sidebar-brand-text mx-3">EKA<sup>manager</sup></div>
            </a> -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="main">
                <div class="sidebar-brand-icon rotate-n-15">
                </div>
                <div class="eka_logo">eka</div>
            </a>

            <!-- Divider -->
            <hr class="sidebar-divider my-0">

            <!-- Nav Item - Dashboard -->
            <li class="nav-item active">
                <a class="nav-link" href="main">
                    <i class="fas fa-fw fa-tachometer-alt"></i>
                    <span>캘린더</span></a>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider">

            <!-- Heading -->
            <div class="sidebar-heading">
                academy
            </div>

            <!-- 왼쪽 사이드 메뉴 -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="" data-toggle="collapse" data-target="#collapseTwo"
                    aria-expanded="true" aria-controls="collapseTwo">
                    <i class="fas fa-fw fa-cog"></i>
                    <span>강좌관리</span>
                </a>
                <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <a class="collapse-item" href="lecture_add">강좌 등록</a>
                        <a class="collapse-item" href="lecture_edit">강좌 조회/수정</a>
                        <a class="collapse-item" href="lecture_student">수강생 관리</a>
                    </div>
                </div>
            </li>

            <li class="nav-item">
                <a class="nav-link collapsed" href="" data-toggle="collapse" data-target="#collapseUtilities"
                    aria-expanded="true" aria-controls="collapseUtilities">
                    <i class="fas fa-fw fa-wrench"></i>
                    <span>강사관리</span>
                </a>
                <div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities"
                    data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <a class="collapse-item" href="teacher_add">강사 등록</a>
                        <a class="collapse-item" href="teacher_edit">강사 조회/수정</a>
                    </div>
                </div>
            </li>

            <li class="nav-item">
                <a class="nav-link collapsed" href="" data-toggle="collapse" data-target="#collapseConsulting"
                    aria-expanded="true" aria-controls="collapseUtilities">
                    <i class="fas fa-fw fa-wrench"></i>
                    <span>상담관리</span>
                </a>
                <div id="collapseConsulting" class="collapse" aria-labelledby="headingUtilities"
                    data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                     	<a class="collapse-item" href="consulting_eka">EKA회원상담신청</a>
                        <a class="collapse-item" href="consulting_unuser">비회원신청</a>
                        <a class="collapse-item" href="consulting_edit">상담관리</a>
                    </div>
                </div>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider">

            <!-- Heading -->
            <div class="sidebar-heading">
                student
            </div>

            <!-- Nav Item - Pages Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="student_edit.html" data-toggle="collapse" data-target="#collapsePages"
                    aria-expanded="true" aria-controls="collapsePages">
                    <i class="fas fa-fw fa-folder"></i>
                    <span>원생관리</span>
                </a>
                <div id="collapsePages" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <a class="collapse-item" href="student_add">학원생 등록</a>
                        <a class="collapse-item" href="student_edit">학원생 조회 / 수정</a>
                    </div>
                </div>
            </li>

            <!-- Nav Item - Charts -->
            <li class="nav-item">
              <a class="nav-link collapsed" href="" data-toggle="collapse" data-target="#collapseScore"
                  aria-expanded="true" aria-controls="collapseScore">
                  <i class="fas fa-fw fa-folder"></i>
                  <span>성적관리</span>
              </a>
              <div id="collapseScore" class="collapse" aria-labelledby="headingScore" data-parent="#accordionSidebar">
                  <div class="bg-white py-2 collapse-inner rounded">
                      <a class="collapse-item" href="score_add_academy">학원 성적 등록</a>
                      <!-- <a class="collapse-item" href="score_add_school">학교 성적 등록</a> -->
                      <!-- <a class="collapse-item" href="score_edit">성적 조회 / 수정</a> -->
                  </div>
              </div>
            </li>

            <!-- Nav Item - Tables -->
             <li class="nav-item">
                <a class="nav-link collapsed" href="" data-toggle="collapse" data-target="#collapseAttendance"
                    aria-expanded="true" aria-controls="collapseUtilities">
                    <i class="fas fa-fw fa-table"></i>
                    <span>출결관리</span>
                </a>
                <div id="collapseAttendance" class="collapse" aria-labelledby="headingUtilities"
                    data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                     	<a class="collapse-item" href="attendance_page">출석하기</a>
                        <a class="collapse-item" href="attendance_edit">강의출석관리</a>
                       
                    </div>
                </div>
            </li>            
            
            <li class="nav-item">
                <a class="nav-link" href="student_report">
                    <i class="fas fa-fw fa-table"></i>
                    <span>원생리포트</span>
                </a>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider d-none d-md-block">

            <!-- Sidebar Toggler (Sidebar) -->
            <div class="text-center d-none d-md-inline">
                <button class="rounded-circle border-0" id="sidebarToggle"></button>
            </div>

        </ul>
</body>
</html>