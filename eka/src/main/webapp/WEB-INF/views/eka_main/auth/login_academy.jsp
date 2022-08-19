<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, viewport-fit=cover">
<meta charset="UTF-8">
<link href="<c:url value='/resources/css/auth.css'/>" rel="stylesheet">

<title>Insert title here</title>
</head>

<body>
  <div id="wrap" role="main">
    <a href="#wrap" class="bt-top hashLink">
      <img src="https://skycatcher.co.kr/image/ic_arrow_up_24px.png" alt="맨위로">
      <span>맨위로</span>
    </a>
    <a href="https://pf.kakao.com/_sjxnTxb/chat" class="bt-kakao" target="_blank">
      <img src="https://skycatcher.co.kr/image/ic_kakao_24px.png" alt="카톡상담">
      <span>문의</span>
    </a>
    <div id="login-bg" class="type2">
      <a href="https://skycatcher.co.kr" class="header-logo">eka</a>
    </div>
    <div id="login-wrap">
      <div class="container small">
        <section class="content">
          <form action="managerlogin" method="post">
            <fieldset class="shadow-wrap">
              <h1 class="title color-accent">학원 로그인<br>
                <span class="comment color-gray">학생 회원은 하단 학생 로그인 바로가기를 눌러주세요.</span>
              </h1>
              <ul class="input-wrap">
                <li class="flex-wrap">
                  <input type="text" name="userId" id="userId" class="input-text" placeholder="아이디" autocomplete="off">
                </li>
                <li class="flex-wrap">
                  <input type="password" name="userPw" id="userPass" class="input-text" placeholder="비밀번호">
                </li>
                <li class="flex-wrap">
                  <input type="submit" value="로그인" class="bt-main accent flex-glow-1">
                </li>
              </ul>
              <div class="login-extra-wrap">
                <ul class="link-wrap float-right">
                  <li class="more"><a href="./find?mode=id" title="아이디 찾기">아이디 찾기</a></li>
                  <li><a href="./find?mode=pw" title="비밀번호 찾기">비밀번호 찾기</a></li>
                </ul>
              </div>
              <div class="join-link-wrap">
                <a href='<c:url value="/eka_main/addmanager"/>'>회원가입</a>
              </div>
              <input type="hidden" name="url" value="https://skycatcher.co.kr/mypage">
              <input type="hidden" name="userType" value="2">
            </fieldset>
          </form>
          <div class="shadow-wrap guide-wrap">
            <h3>학생이신가요?</h3>
            <a href='<c:url value="/eka_main/ekauserlogin"/>'>학생 로그인</a>
          </div>
        </section>
      </div>
    </div>
  </div>
<script src='<c:url value="/resources/js/jquery-3.6.0.js"/>'></script>
<script src='<c:url value="/resources/js/auth.js"/>'></script>
</body>
</html>