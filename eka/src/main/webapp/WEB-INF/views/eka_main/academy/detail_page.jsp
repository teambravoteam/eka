<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width" />
<title>EKA! Every K-Academy</title>

<link rel="shortcut icon" href="../resources/img/logo.jpg" type="image/x-icon">
<link href="../resources/css/swiper.css" type="text/css" rel="stylesheet">
<link href="../resources/css/aos.css" rel="stylesheet">
<link href="../resources/css/common.css" rel="stylesheet">
<link href="../resources/css/font.css" type="text/css" rel="stylesheet">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap" rel="stylesheet">

<script type="text/javascript" src="../resources/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="../resources/js/jquery-ui-1.12.1.min.js"></script>
<script type="text/javascript" src="../resources/js/swiper.min.js"></script>
<script type="text/javascript" src="../resources/js/aos.js"></script>
</head>

<body data-aos-easing="ease" data-aos-duration="1200" data-aos-delay="0">
	<div id="wrap" role="main">
		<header id="header" role="navigation">
			<%@ include file="../common/header.jsp"%>
		</header>
		<a href="#wrap" class="bt-top hashLink">
			<img src="https://skycatcher.co.kr/image/ic_arrow_up_24px.png" alt="맨위로"> <span>맨위로</span>
		</a>
		<a href="https://pf.kakao.com/_sjxnTxb/chat" class="bt-kakao" target="_blank">
			<img src="https://skycatcher.co.kr/image/ic_kakao_24px.png" alt="카톡상담"> <span>문의</span>
		</a>

		<form method="get" action="academy/update_detail_page">
			<div id="academy-wrap">
				<div class="container">
					<div class="academy-bg dragBlock">
						<img src="../resources/img/academymain.jpg" alt="메인사진">
					</div>
					<div class="content academy-header">
						<div class="shadow-wrap">
							<div class="flex-wrap">
								<div class="border-wrap logo-wrap">
									<img src="../resources/img/academylogo.png" alt="학원로고">
								</div>
								<div class="flex-glow-1 summary-wrap">
									<button class="bt-like float-right" data-uaid="40943" data-like="0"></button>
									<h1 class="academy-title">${academy.name}</h1>
									<div class="academy-review">
										학생 리뷰 <span>(예정)</span> 학부모 리뷰 <span>(예정)</span>
									</div>
									<div class="academy-teacher-review">
										학원장 댓글 <span>(예정)</span>
									</div>
								</div>
							</div>
							<div class="flex-wrap info-wrap">
								<ul class="flex-shrink-0 flex-glow-1">
									<li>
										<strong>개원일</strong> <span>${academy.openingday}</span>
									</li>
									<li>
										<strong>개설과목</strong> <span>${academy.field1.replace('/','')} ${academy.field2.replace('/','')} ${academy.field3.replace('/','')}</span>
									</li>
									<li>
										<strong>상담전화</strong>
										<a href="tel:${academy.phone}">${academy.phone}</a>
									</li>
								</ul>
								<div class="flex-shrink-0 flex-glow-0 bt-wrap">
									<input type="hidden" name="academyAid" value="${academy.aid}">
									<c:if test="${checkManager == 1}">
										<button id="onBtn" type="button" class="bt-main point bt-apply">상담신청</button>
									</c:if>
									<c:if test="${checkManager == 0}">
										<button type="button" class="bt-main point bt-apply" onclick="location.href='../eka_main/add_academy'">학원수정</button>
									</c:if>
									<button type="button" class="bt-main white bt-share">
										<img src="https://skycatcher.co.kr/image/ic_share_12px.png" alt="공유">공유
									</button>
								</div>
							</div>
						</div>
					</div>
					<nav class="section-tab-wrap">
						<ul class="sctb">
							<li class="sctb-item current">
								<button type="button" class="bt-tab" data-sec="sec-intro">소개</button>
							</li>
							<li class="sctb-item">
								<button type="button" class="bt-tab" data-sec="sec-info">정보</button>
							</li>
							<!-- 	            <li class="sctb-item">
	              <button type="button" class="bt-tab" data-sec="sec-notice">공지</button>
	            </li> -->
							<li class="sctb-item">
								<button type="button" class="bt-tab" data-sec="sec-review">리뷰</button>
							</li>
						</ul>
					</nav>
					<section class="sec-tab" id="sec-intro" style="">
						<div class="academy-content-wrap ">
							<button type="button" class="bt-sec-header">
								<h1 class="content">학원 소개</h1>
							</button>
							<div class="content editorView">
								<p>${academy.introduction}</p>
							</div>
						</div>
						<div class="academy-content-wrap ">
							<button type="button" class="bt-sec-header">
								<h1 class="content">뱃지</h1>
							</button>
							<div class="content badge-wrap">
								<ul class="academy-badge-list">
									<c:forEach var="academyservice" items="${academy.academyservice.split(',')}">
										<li>
											<div class="badge-image">
												<img src="../resources/img/service2/${academyservice}.png">
											</div>
											<span class="badge-name">${academyservice}</span>
										</li>
									</c:forEach>
								</ul>
							</div>
						</div>
						<div class="academy-content-wrap ">
							<button type="button" class="bt-sec-header">
								<h1 class="content">수업</h1>
							</button>
							<div class="academy-class-wrap">
								<ul class="academy-class-list">
									<li class="content">
										<%-- <c:forEach var="priceList" items="${academy.priceList.split('/')}">
											<div>
												<div class="class-title">${priceList.split(":")[0]}</div>
												<p class="class-summary">수업 정원 : ${academy.personnel}명</p>
												<div class="class-price">1개월 : ${priceList.split(":")[1]}</div>
											</div>
										</c:forEach> --%>
										<c:forEach var="academylist" items="${lecture}">
											<div class="content statis-wrap">
												<table class="statis-table">
													<tbody>
														<div class="class-title">강의명 : ${academylist.name}</div>
														<tr>
															<td class="td-title">과목</td>
															<td class="td-content">${academylist.subject}</td>
															<td class="td-title">강사명</td>
															<td class="td-content">${academylist.teacher}</td>
														</tr>
														<tr>
															<td class="td-title">강의대상</td>
															<td class="td-content">${academylist.schoolcate}${academylist.gradecate}</td>
															<td class="td-title">수업정원</td>
															<td class="td-content">${academylist.lectureCapacity}명</td>
														</tr>
														<tr>
															<td class="td-title">강의기간</td>
															<td class="td-content">${academylist.startLectureDate}~${academylist.finishLectureDate}</td>
															<td class="td-title">강의시간</td>
															<td class="td-content">${academylist.startLectureTime.split(":")[0]}:${academylist.startLectureTime.split(":")[1]}~${academylist.finishLectureTime.split(":")[0]}:${academylist.finishLectureTime.split(":")[1]}</td>
														</tr>
														<tr>
															<td class="td-title">강의요일</td>
															<td class="td-content">${academylist.lectureDay}</td>
															<td class="td-title">수강료</td>
															<td class="td-content">
																<fmt:formatNumber value="${academylist.price}" pattern="#,###" />
																원
															</td>
														</tr>
													</tbody>
												</table>
											</div>
										</c:forEach>
									</li>
								</ul>
								<script>
									$('.class-info').on(
											'click',
											function() {
												openModal('picture', $(this)
														.data('image'),
														function() {
														});
											});
								</script>
							</div>
						</div>
						<div class="academy-content-wrap">
							<button type="button" class="bt-sec-header">
								<h1 class="content">대표선생님</h1>
							</button>
							<div class="swiper-container teacher-wrap swiper-container-horizontal">
								<ul class="swiper-wrapper academy-teacher-list" style="transform: translate3d(0px, 0px, 0px);">
									<c:forEach var="teacher" items="${teacher}">
										<li class="swiper-slide shadow-wrap no-pd swiper-slide-active">
											<div class="border-wrap teacher-image">
												<img src="../resources/img/empty_user.png">
											</div>
											<div class="teacher-info">
												<div class="teacher-name">${teacher.name}선생님</div>
												<div class="chip-wrap flex-center teacher-field">
													<span class=" chip-label outline">${teacher.subject}</span>
												</div>
												<div class="teacher-intro ellipsis">${teacher.career}</div>
											</div>
										</li>
									</c:forEach>
								</ul>
								<span class="swiper-notification" aria-live="assertive" aria-atomic="true"></span>
							</div>
							<script>
								var swiper = new Swiper('.teacher-wrap', {
									slidesPerView : 'auto'
								});
							</script>
						</div>
					</section>
					<section class="sec-tab" id="sec-info" style="display: none;">
						<div class="academy-content-wrap">
							<button type="button" class="bt-sec-header">
								<h1 class="content">학원 통계</h1>
							</button>
							<div class="content statis-wrap">
								<table class="statis-table">
									<tbody>
										<tr>
											<td class="td-title">개원일</td>
											<td class="td-content">${academy.openingday}</td>
											<td class="td-title">개설과목</td>
											<td class="td-content">${academy.field1.replace('/','')}${academy.field2.replace('/','')}${academy.field3.replace('/','')}</td>
										</tr>
										<tr>
											<td class="td-title">학생수</td>
											<td class="td-content">${academy.personnel}</td>
											<td class="td-title">강사수</td>
											<td class="td-content">강사인원 합쳐서 표현해야함</td>
										</tr>
										<tr>
											<td class="td-title">전체리뷰수</td>
											<td class="td-content">전체리뷰수 합쳐서 표현해야함</td>
											<td></td>
											<td></td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
						<div class="academy-content-wrap">
							<button type="button" class="bt-sec-header">
								<h1 class="content">학원 정보</h1>
							</button>
							<div class="content detail-wrap">
								<table class="detail-table">
									<tbody>
										<tr>
											<td class="td-title">상담 정보</td>
											<td class="td-title">운영 정보</td>
										</tr>
										<tr>
											<td class="td-content">
												평일 - ${academy.startconsultabletime.split(":")[0]}:${academy.startconsultabletime.split(":")[1]}
												<br>
												주말 - ${academy.endconsultabletime.split(":")[0]}:${academy.endconsultabletime.split(":")[1]}
											</td>
											<td class="td-content">
												평일 - ${academy.startruntime.split(":")[0]}:${academy.startruntime.split(":")[1]}
												<br>
												주말 - ${academy.endruntime.split(":")[0]}:${academy.endruntime.split(":")[1]}
											</td>
										</tr>
									</tbody>
								</table>
								<table class="detail-table">
									<tbody>
										<tr>
											<td class="td-title">대표자명</td>
											<td class="td-content" colspan="3">정보없음</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</section>

					<section class="sec-tab" id="sec-review" style="display: none;">
						<div class="academy-content-wrap ">
							<button type="button" class="bt-sec-header">
								<h1 class="content">리뷰 공지</h1>
							</button>
							<div class="content review-notice-wrap">
								[리뷰이벤트]
								<br>
								<br>
								리뷰 작성 시, 원하시는 분들께 부족한 과목(택1) 단기 특강을 무료로 해드립니다! (*주1회 1시간)
								<br>
								<br>
								1) 국어 2) 수학 3) 영어
								<br>
								<br>
								* 솔직한 리뷰 작성 부탁드립니다~!! *
							</div>
						</div>
						<div class="academy-content-wrap ">
							<button type="button" class="bt-sec-header">
								<h1 class="content">리뷰</h1>
							</button>
							<div class="content review-wrap">
								<div class="shadow-wrap">
									<div class="flex-wrap">
										<div class="flex-shrink-0 flex-glow-0 rating-wrap">
											<span class="rating-score">5.0</span> <span class="rating-star rating-star-5"></span>
										</div>
										<div class="flex-shrink-1 flex-glow-1 rating-count-wrap">
											<ul>
												<li class="flex-center">
													<span class="flex-shrink-0">5점</span>
													<div class="flex-glow-1 rating-bar">
														<div style="width: 100%"></div>
													</div>
													<span class="flex-shrink-0">3</span>
												</li>
												<li class="flex-center">
													<span class="flex-shrink-0">4점</span>
													<div class="flex-glow-1 rating-bar">
														<div style="width:"></div>
													</div>
													<span class="flex-shrink-0">0</span>
												</li>
												<li class="flex-center">
													<span class="flex-shrink-0">3점</span>
													<div class="flex-glow-1 rating-bar">
														<div style="width:"></div>
													</div>
													<span class="flex-shrink-0">0</span>
												</li>
												<li class="flex-center">
													<span class="flex-shrink-0">2점</span>
													<div class="flex-glow-1 rating-bar">
														<div style="width:"></div>
													</div>
													<span class="flex-shrink-0">0</span>
												</li>
												<li class="flex-center">
													<span class="flex-shrink-0">1점</span>
													<div class="flex-glow-1 rating-bar">
														<div style="width:"></div>
													</div>
													<span class="flex-shrink-0">0</span>
												</li>
											</ul>
										</div>
									</div>
								</div>
							</div>
							<div class="content review-count-wrap">
								<div class="flex-wrap">
									<div class="flex-shrink-0 flex-glow-1 review-total">
										학생 리뷰 <span>2개</span> 학부모 리뷰 <span>1개</span> 학원장 댓글 <span>1개</span>
									</div>
								</div>
							</div>
							<div class="content review-list-wrap">
								<ul class="review-list">
									<li>
										<div class="flex">
											<div class="flex-shrink-0 review-profile">
												<img src="https://k.kakaocdn.net/dn/Sjdjz/btqF2R93QM9/Vtab4IEVQDXRIA9lXHroFk/img_110x110.jpg" alt="">
											</div>
											<div class="flex-glow-1 review-info">
												<div class="review-writer">
													<span class="writer-id">양**</span><span class="writer-type">학생</span>
												</div>
												<div class="review-rating">
													<span class="rating-star rating-star-5"></span><span class="review-date">1970-01-01</span>
												</div>
												<div class="review-content">수학성적이 많이올랐습니다 짱입니다</div>
												<div class="review-title">고등수학 (심화)</div>
											</div>
										</div>
									</li>
								</ul>
							</div>
						</div>
					</section>
				</div>
			</div>
		</form>
		<input type="hidden" id="uaid" value="40943">

		<%@ include file="../common/footer.jsp"%>
	</div>
	<!-- 로그인 안되어있을때 Modal 시작 -->
	<%-- <c:if test="${checkManager == 0}"> --%>
		<div class="modal-back">
			<div id="modal-wrap" class="modal-wrap width-s" style="display:none">
			    <div class="modal-head">
			        <button type="button" class="bt-icon close float-right">닫기</button>
			        <h3 class="modal-title">상담신청</h3>
			        <span class="modal-guide"></span>
			    </div>
			    <div class="modal-body">
				    <div id="academy-register-wrap">
					    <form name="???" action="???" method="POST">
					        <input type="hidden" name="uaid" value="40943">
					        <input type="hidden" name="parentId" value="">
					        <!-- 학생정보 시작 -->
					        <div class="student-wrap">
					            <h3>학생정보</h3>
					            <div class="border-wrap info-wrap">
					                <ul class="input-wrap">
					                    <li>
					                        <label for="studentName" class="label-text">이름</label>
					                        <div class="flex-wrap">
					                            <input type="text" name="studentName" id="studentName" class="input-text" value="" placeholder="이름을 입력해주세요">
					                        </div>
					                    </li>
					                    <li>
					                        <label for="studentPhone" class="label-text">휴대폰번호</label>
					                        <div class="flex-wrap">
					                            <input type="text" name="studentName" id="studentName" class="input-text" value="" placeholder="휴대폰번호를 입력해주세요 (-)포함">
					                        </div>
					                    </li>
					                    <li>
					                        <label for="studentSchool" class="label-text">상담내용</label>
					                        <div class="flex-wrap">
					                            <input type="text" name="studentSchool" id="studentSchool" class="input-text" value="">
					                        </div>
					                    </li>
					                </ul>
					            </div>
					        </div>
					        <!-- 학생정보 끝 -->
					        <div class="bt-modal-wrap">
					            <button type="submit" class="bt-label color-point">등록하기</button>
					        </div>
					    </form>
					</div>
				</div>
			</div>
		</div>
	<%-- </c:if> --%>
	<!-- 로그인 안되어있을때 Modal 끝 -->
	
	<!-- 로그인 되어있을때 Modal 시작 -->
	<%-- <c:if test="${checkManager == 1}">
		<div class="modal-back">
			<div id="modal-wrap" class="modal-wrap width-s" style="display:none">
			    <div class="modal-head">
			        <button type="button" class="bt-icon close float-right">닫기</button>
			        <h3 class="modal-title">상담신청</h3>
			        <span class="modal-guide"></span>
			    </div>
			    <div class="modal-body">
				    <div id="academy-register-wrap">
					    <form name="???" action="???" method="POST">
					        <input type="hidden" name="uaid" value="40943">
					        <input type="hidden" name="parentId" value="">
					        <!-- 학생정보 시작 -->
					        <div class="student-wrap">
					            <h3>학생정보</h3>
					            <div class="border-wrap info-wrap">
					                <ul class="input-wrap">
					                    <li>
					                        <label for="studentName" class="label-text">이름</label>
					                        <div class="flex-wrap">
					                            <input type="text" name="studentName" id="studentName" class="input-text" value="${checkStudent.name}" placeholder="이름을 입력해주세요">
					                        </div>
					                    </li>
					                    <li>
					                        <label for="studentPhone" class="label-text">휴대폰번호</label>
					                        <div class="flex-wrap">
					                            <input type="text" name="studentName" id="studentName" class="input-text" value="${checkStudent.phone}" placeholder="휴대폰번호를 입력해주세요 (-)포함">
					                        </div>
					                    </li>
					                    <li>
					                        <label for="studentSchool" class="label-text">상담내용</label>
					                        <div class="flex-wrap">
					                            <input type="text" name="studentSchool" id="studentSchool" class="input-text" value="">
					                        </div>
					                    </li>
					                </ul>
					            </div>
					        </div>
					        <!-- 학생정보 끝 -->
					        <div class="bt-modal-wrap">
					            <button type="submit" class="bt-label color-point">등록하기</button>
					        </div>
					    </form>
					</div>
				</div>
			</div>
		</div>
	</c:if> --%>
	<!-- 로그인 되어있을때 Modal 끝 -->
	
	<script type="text/javascript" src="<c:url value='/resources/js/common.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/detail.js'/>"></script>
</body>
</html>