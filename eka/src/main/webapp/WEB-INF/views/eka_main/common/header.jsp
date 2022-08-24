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
				<form action="myPage" method="post">
					<input type="hidden" name="academyId" value="${manager.academyId}" />
					<input type="hidden" name="ekauserId" value="${ekauser.userId}" />
					<input type="submit" class="bt-sub coral" value="마이페이지" />
				</form>
			</li>
			<li>
				<form action="logOut" method="post">
					<input type="submit" class="bt-sub point" value="로그아웃" />
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
	<ul class="gnb point">
		<div class="join-guide">
			<a href="#">
				<h4>회원가입</h4>
			</a>
		</div>
		<li>
			<a href="#">로그인</a>
		</li>
		<li>
			<a href="notice">공지사항</a>
		</li>
		<li>
			<a href="add_academy">학원신청</a>
		</li>
	</ul>
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
