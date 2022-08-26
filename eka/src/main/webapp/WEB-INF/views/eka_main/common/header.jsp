<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<nav class="header-wrap">
	<ul>
		<li>
			<a href="main" class="header-logo">
				<h1>eka</h1>
			</a>
		</li>
		<li class="hide-m">
			<a href="notice" class="header-nav">공지사항</a>
		</li>
		<li class="hide-m">
			<a href="add_academy" class="header-nav">학원신청</a>
		</li>
		<c:if test="${! empty manager && empty ekauser}">
			<li class="hide-m">
				<a href="../eka_manager/main" class="header-nav">학원관리</a>
			</li>
		</c:if>
	</ul>
	<ul class="hide-m">
		<c:if test="${empty manager && empty ekauser}">
			<li>
				<a href="managerlogin" class="header-nav">로그인</a>
			</li>
			<li>
				<a href="register_main" class="bt-sub point">회원가입</a>
			</li>
		</c:if>
		<c:if test="${! empty manager || ! empty ekauser}">
			<li>
				<span class="header-nav"> <c:if test="${! empty manager && empty ekauser}">
						<p>${manager.name}님</p>
					</c:if> <c:if test="${! empty ekauser && empty manager}">
						<p>${ekauser.name}님</p>
					</c:if>
				</span>
			</li>
			<li>
				<c:if test="${! empty manager && empty ekauser}">
					<form action="myPage" method="post">
						<input type="hidden" name="academyId" value="${manager.academyId}" />
						<input type="submit" class="bt-sub coral" value="마이페이지" />
					</form>
				</c:if>

				<c:if test="${! empty ekauser && empty manager}">
					<form action="myPage" method="post">
						<input type="hidden" name="ekauserId" value="${ekauser.userId}" />
						<input type="submit" class="bt-sub coral" value="마이페이지" />
					</form>
				</c:if>
			</li>
			<li>
				<form action="logOut" method="post">
					<input type="submit" id="logOutBtn" class="bt-sub point" value="로그아웃" />
				</form>

			</li>
		</c:if>
	</ul>
	<ul class="show-m">
		<li>
			<button class="header-menu" title="메뉴">
				<span></span>
			</button>
		</li>
	</ul>
</nav>
<nav class="show-m header-side">
	<c:if test="${empty manager && empty ekauser}">
		<ul class="gnb point">
			<div class="join-guide">
				<a href="register_main">
					<h4>회원가입</h4>
				</a>
			</div>
			<li>
				<a href="managerlogin">로그인</a>
			</li>
			<li>
				<a href="notice">공지사항</a>
			</li>
			<li>
				<a href="add_academy">학원신청</a>
			</li>
		</ul>
	</c:if>

	<c:if test="${! empty manager || ! empty ekauser}">
		<ul class="gnb point">
			<div class="shadow-wrap profile-wrap">
				<div class="flex-wrap">
					<div class="border-wrap flex-shrink-0 profile-image">
						<img src="../resources/img/empty_user.png" alt="${manager.name}">
					</div>
					<div class="flex-glow-1 profile-info">
						<c:if test="${! empty manager && empty ekauser}">
							<span class="chip-label accent float-right">원장</span>
							<h4>${manager.name}님</h4>
						</c:if>
						<c:if test="${! empty ekauser && empty manager}">
							<span class="chip-label point float-right">학생</span>
							<h4>${ekauser.name}님</h4>
						</c:if>
					</div>
				</div>
			</div>
			<li class="current">
				<c:if test="${! empty manager && empty ekauser}">
					<form action="myPage" method="post">
						<input type="hidden" name="academyId" value="${manager.academyId}" />
						<input type="submit" value="마이페이지" />
					</form>
				</c:if>

				<c:if test="${! empty ekauser && empty manager}">
					<form action="myPage" method="post">
						<input type="hidden" name="ekauserId" value="${ekauser.userId}" />
						<input type="submit" value="마이페이지" />
					</form>
				</c:if>
			</li>
			<li>
				<a href="notice">공지사항</a>
			</li>
			<li>
				<form action="logOut" method="post">
					<input type="submit" id="logOutBtn" value="로그아웃" />
				</form>
			</li>
		</ul>
	</c:if>
</nav>

<script>
	(function() {
		var nowPage = location.href.split('?')[0];
		var navTarget = $(".gnb a[href='" + nowPage + "']").parent().addClass(
				"current");
		var navParent = navTarget.parent();
		if (navParent.hasClass("depth2")) {
			navParent.show().parent().addClass("current");
		}
		if (navParent.hasClass("depth3")) {
			navParent.show().parent().addClass("current").parent().show()
					.parent().addClass("current");
		}
	})();
</script>

<c:if test="${! empty manager && ! empty ekauser}">
	<script>
		location.href = "main";
		alert("세션 중복 발생, 로그아웃을 진행합니다.");
		document.getElementById('logOutBtn').click();
	</script>
</c:if>
