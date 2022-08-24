<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, viewport-fit=cover">
<meta charset="UTF-8">

<title>Insert title here</title>

<link href="<c:url value='/resources/css/common.css'/>" rel="stylesheet">
<script type="text/javascript" src="<c:url value='/resources/js/jquery-3.6.0.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/js/swiper.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/js/aos.js'/>"></script>
</head>


<body data-aos-easing="ease" data-aos-duration="1200" data-aos-delay="0">
  <div id="wrap" role="main">
    <header id="header" role="navigation">
      <nav class="header-wrap">
        <ul>
          <li>
            <a href="https://skycatcher.co.kr" class="header-logo">eka</a>
          </li>
          <li class="hide-m"><a href="https://skycatcher.co.kr/notice" class="header-nav">공지사항</a></li>
          <li class="hide-m"><a href="https://skycatcher.co.kr/event" class="header-nav">이벤트</a></li>
          <li class="hide-m"><a href="https://skycatcher.co.kr/customer" class="header-nav">고객센터</a></li>
        </ul>
        <ul class="hide-m">
          <li><a href="https://skycatcher.co.kr/login" class="header-nav">로그인</a></li>
          <li><a href="https://skycatcher.co.kr/join" class="bt-sub point">회원가입</a></li>
        </ul>
        <ul class="show-m">
          <li><button class="header-menu" title="메뉴"><span></span></button></li>
        </ul>
      </nav>
      <nav class="show-m header-side">
        <ul class="gnb point">
          <div class="join-guide">
            <a href="https://skycatcher.co.kr/join">
              <h4>회원가입</h4>
              <p>지금 회원가입하면<br>
                5,000 포인트 지급!</p>
            </a>
          </div>
          <li><a href="https://skycatcher.co.kr/login">로그인</a></li>
          <li><a href="https://skycatcher.co.kr/notice">공지사항</a></li>
          <li><a href="https://skycatcher.co.kr/event">이벤트</a></li>
          <li><a href="https://skycatcher.co.kr/customer">고객센터</a></li>
        </ul>
      </nav>
      <script>
		(function (){
			var nowPage = location.href.split('?')[0];
			var navTarget = $(".gnb a[href='"+nowPage+"']").parent().addClass("current");
			var navParent = navTarget.parent();
			if(navParent.hasClass("depth2")){
				navParent.show().parent().addClass("current");
			}
			if(navParent.hasClass("depth3")){
				navParent.show().parent().addClass("current").parent().show().parent().addClass("current");
			}
		})();
      </script>
    </header>
    <a href="#wrap" class="bt-top hashLink">
      <img src="https://skycatcher.co.kr/image/ic_arrow_up_24px.png" alt="맨위로">
      <span>맨위로</span>
    </a>
    <a href="https://pf.kakao.com/_sjxnTxb/chat" class="bt-kakao" target="_blank">
      <img src="https://skycatcher.co.kr/image/ic_kakao_24px.png" alt="카톡상담">
      <span>문의</span>
    </a>
    
    <form method="get">
	    <div id="academy-wrap">
	      <div class="container">
	        <div class="academy-bg dragBlock">
	          <img src="https://via.placeholder.com/1020x500.jpg" alt="메인사진">
	        </div>
	        <div class="content academy-header">
	          <div class="shadow-wrap">
	            <div class="flex-wrap">
	              <div class="border-wrap logo-wrap">
	                <img src="https://via.placeholder.com/118" alt="학원로고">
	              </div>
	              <div class="flex-glow-1 summary-wrap">
	                <button class="bt-like float-right" data-uaid="40943" data-like="0"></button>
	                <h1 class="academy-title">${academy.name}</h1>
	                <div class="academy-rating">
	                  <span class="rating-star rating-star-5">5.0</span>
	                  <span class="rating-count">(3)</span>
	                </div>
	                <div class="academy-review">학생 리뷰 <span>2개</span> 학부모 리뷰 <span>1개</span></div>
	                <div class="academy-teacher-review">학원장 댓글 <span>1개</span></div>
	              </div>
	            </div>
	            <div class="flex-wrap info-wrap">
	              <ul class="flex-shrink-0 flex-glow-1">
	                <li>
	                  <strong>개원일</strong>
	                  <span>${academy.openingday}</span>
	                </li>
	                <li>
	                  <strong>개설과목</strong>
	                  <span>${academy.field3}</span>
	                </li>
	                <li>
	                  <strong>상담전화</strong>
	                  <a href="tel:${academy.phone}">${academy.phone}</a>
	                </li>
	              </ul>
	
	              <div class="flex-shrink-0 flex-glow-0 bt-wrap">
	                <button type="button" class="bt-main point bt-apply">학원등록</button>
	                <button type="button" class="bt-main white bt-share"><img src="https://skycatcher.co.kr/image/ic_share_12px.png" alt="공유">공유</button>
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
	            <li class="sctb-item">
	              <button type="button" class="bt-tab" data-sec="sec-notice">공지</button>
	            </li>
	            <li class="sctb-item">
	              <button type="button" class="bt-tab" data-sec="sec-review">리뷰</button>
	            </li>
	          </ul>
	        </nav>
	        <section class="sec-tab" id="sec-intro" style="">
	          <div class="academy-content-wrap ">
	            <button class="bt-sec-header">
	              <h1 class="content">학원소개</h1>
	            </button>
	            <div class="content editorView">
	              <p>${academy.introduction}</p>
	            </div>
	          </div>
	          <div class="academy-content-wrap ">
	            <button class="bt-sec-header">
	              <h1 class="content">뱃지</h1>
	            </button>
	            <div class="content badge-wrap">
	              <ul class="academy-badge-list">
	                <li>
	                  <div class="badge-image">
	                    <img src="https://via.placeholder.com/150" alt="학원차량운행">
	                  </div>
	                  <span class="badge-name">학원차량운행</span>
	                </li>
	                <li>
	                  <div class="badge-image">
	                    <img src="https://via.placeholder.com/150" alt="냉난방">
	                  </div>
	                  <span class="badge-name">냉난방</span>
	                </li>
	                <li>
	                  <div class="badge-image">
	                    <img src="https://via.placeholder.com/150" alt="공기청정기">
	                  </div>
	                  <span class="badge-name">공기청정기</span>
	                </li>
	                <li>
	                  <div class="badge-image">
	                    <img src="https://via.placeholder.com/150" alt="자습실">
	                  </div>
	                  <span class="badge-name">자습실</span>
	                </li>
	                <li>
	                  <div class="badge-image">
	                    <img src="https://via.placeholder.com/150" alt="원장직강">
	                  </div>
	                  <span class="badge-name">원장직강</span>
	                </li>
	                <li>
	                  <div class="badge-image">
	                    <img src="https://via.placeholder.com/150" alt="개인사물함">
	                  </div>
	                  <span class="badge-name">개인사물함</span>
	                </li>
	                <li>
	                  <div class="badge-image">
	                    <img src="https://via.placeholder.com/150" alt="간식제공">
	                  </div>
	                  <span class="badge-name">간식제공</span>
	                </li>
	                <li>
	                  <div class="badge-image">
	                    <img src="https://via.placeholder.com/150" alt="과외식">
	                  </div>
	                  <span class="badge-name">과외식</span>
	                </li>
	                <li>
	                  <div class="badge-image">
	                    <img src="https://via.placeholder.com/150" alt="빔프로젝터">
	                  </div>
	                  <span class="badge-name">빔프로젝터</span>
	                </li>
	                <li>
	                  <div class="badge-image">
	                    <img src="https://via.placeholder.com/150" alt="원어민강사">
	                  </div>
	                  <span class="badge-name">원어민강사</span>
	                </li>
	                <li>
	                  <div class="badge-image">
	                    <img src="https://via.placeholder.com/150" alt="독서실책상">
	                  </div>
	                  <span class="badge-name">독서실책상</span>
	                </li>
	                <li>
	                  <div class="badge-image">
	                    <img src="https://via.placeholder.com/150" alt="자체모의고사">
	                  </div>
	                  <span class="badge-name">자체모의고사</span>
	                </li>
	                <li>
	                  <div class="badge-image">
	                    <img src="https://via.placeholder.com/150" alt="자체장학제도">
	                  </div>
	                  <span class="badge-name">자체장학제도</span>
	                </li>
	                <li>
	                  <div class="badge-image">
	                    <img src="https://via.placeholder.com/150" alt="인터넷강의">
	                  </div>
	                  <span class="badge-name">인터넷강의</span>
	                </li>
	                <li>
	                  <div class="badge-image">
	                    <img src="https://via.placeholder.com/150" alt="출결시스템">
	                  </div>
	                  <span class="badge-name">출결시스템</span>
	                </li>
	              </ul>
	            </div>
	          </div>
	          <div class="academy-content-wrap ">
	            <button class="bt-sec-header">
	              <h1 class="content">수업</h1>
	            </button>
	            <div class="academy-class-wrap">
	              <ul class="academy-class-list">
	                <li class="content">
	                <c:forEach var="priceList" items="${academy.priceList.split('/')}">
	               	  <div>	                  
	                	<div class="class-title">${priceList.split(":")[0]}</div>
	                    <div class="class-time">총 교습시간 : 몰?루</div>
	                    <p class="class-summary">수업 정원 : ${academy.personnel}명</p>
	                    <div class="class-price">1개월 : ${priceList.split(":")[1]}</div>
                  	  </div>
	                </c:forEach>	                 
	                </li>
	              </ul>
	              <script>
	                $('.class-info').on('click', function() {
	                  openModal('picture', $(this).data('image'), function() {});
	                });
	              </script>
	            </div>
	          </div>
	          <div class="academy-content-wrap ">
	            <button class="bt-sec-header">
	              <h1 class="content">대표선생님</h1>
	            </button>
	            <div class="swiper-container teacher-wrap swiper-container-horizontal">
	              <ul class="swiper-wrapper academy-teacher-list" style="transform: translate3d(0px, 0px, 0px);">
	                <li class="swiper-slide shadow-wrap no-pd swiper-slide-active">
	                  <div class="border-wrap teacher-image">
	                    <img src="https://via.placeholder.com/220x236.jpg" alt="주시경">
	                  </div>
	                  <div class="teacher-info">
	                    <div class="teacher-name">주시경 선생님</div>
	                    <div class="chip-wrap flex-center teacher-field">
	                      <span class=" chip-label outline">
	                        국어 </span>
	                    </div>
	                    <div class="teacher-intro ellipsis">
	                      現) 스카이 학원 국어 대표 강사<br>卒) 서울대 국어교육과 </div>
	                  </div>
	                </li>
	                <li class="swiper-slide shadow-wrap no-pd swiper-slide-next">
	                  <div class="border-wrap teacher-image">
	                    <img src="https://via.placeholder.com/220x236.jpg" alt="방정식">
	                  </div>
	                  <div class="teacher-info">
	                    <div class="teacher-name">방정식 선생님</div>
	                    <div class="chip-wrap flex-center teacher-field">
	                      <span class=" chip-label outline">
	                        수학 </span>
	                    </div>
	                    <div class="teacher-intro ellipsis">
	                      現) 스카이 학원 수학 대표 강사<br>卒) 고려대 수학교육과 </div>
	                  </div>
	                </li>
	                <li class="swiper-slide shadow-wrap no-pd">
	                  <div class="border-wrap teacher-image">
	                    <img src="https://via.placeholder.com/220x236.jpg" alt="원어민">
	                  </div>
	                  <div class="teacher-info">
	                    <div class="teacher-name">원어민 선생님</div>
	                    <div class="chip-wrap flex-center teacher-field">
	                      <span class=" chip-label outline">
	                        영어 </span>
	                    </div>
	                    <div class="teacher-intro ellipsis">
	                      現) 스카이 학원 영어 대표 강사 <br>卒) 연세대 영어교육과 </div>
	                  </div>
	                </li>
	              </ul>
	              <span class="swiper-notification" aria-live="assertive" aria-atomic="true"></span>
	            </div>
	            <script>
	              var swiper = new Swiper('.teacher-wrap', {
	                slidesPerView: 'auto'
	              });
	            </script>
	          </div>
	        </section>
	        <section class="sec-tab" id="sec-info" style="display: none;">
	          <div class="academy-content-wrap">
	            <button class="bt-sec-header">
	              <h1 class="content">학원 통계</h1>
	            </button>
	            <div class="content statis-wrap">
	              <table class="statis-table">
	                <tbody>
	                  <tr>
	                    <td class="td-title">개원일</td>
	                    <td class="td-content">${academy.openingday}</td>
	                    <td class="td-title">개설과목</td>
	                    <td class="td-content">과목내용입력</td>
	                  </tr>
	                  <tr>
	                    <td class="td-title">학생수</td>
	                    <td class="td-content">비공개</td>
	                    <td class="td-title">강사수</td>
	                    <td class="td-content">1명</td>
	                  </tr>
	                  <tr>
	                    <td class="td-title">전체리뷰수</td>
	                    <td class="td-content">3</td>
	                    <td></td>
	                    <td></td>
	                  </tr>
	                </tbody>
	              </table>
	            </div>
	          </div>
	          <div class="academy-content-wrap">
	            <button class="bt-sec-header">
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
	                    <td class="td-content">평일 - 시작시간정보<br>
	                      주말 - 종료시간정보</td>
	                    <td class="td-content">평일 - 시간정보<br>
	                      주말 - 시간정보</td>
	                  </tr>
	                </tbody>
	              </table>
	              <table class="detail-table">
	                <tbody>
	                  <tr>
	                    <td class="td-title">대표자명</td>
	                    <td class="td-content" colspan="3">정보없음</td>
	                  </tr>
	                  <tr>
	                    <td class="td-title">사업자주소</td>
	                    <td class="td-content" colspan="3">주소입력칸</td>
	                  </tr>
	                </tbody>
	              </table>
	            </div>
	          </div>
	        </section>
	        <section class="sec-tab" id="sec-notice" style="display: none;">
	          <div class="academy-content-wrap ">
	            <button class="bt-sec-header">
	              <h1 class="content">공지사항</h1>
	            </button>
	            <div class="content editorView">
	              <p><img src="/data/company/40943/1da1f17212bd38b23682331d9861ac65.jpg" alt="" width="966" height="1366"></p>
	            </div>
	          </div>
	          <div class="academy-content-wrap close">
	            <button class="bt-sec-header">
	              <h1 class="content">이벤트</h1>
	            </button>
	            <div class="content editorView">
	            </div>
	          </div>
	        </section>
	        <section class="sec-tab" id="sec-review" style="display:none;">
	          <div class="academy-content-wrap ">
	            <button class="bt-sec-header">
	              <h1 class="content">리뷰공지</h1>
	            </button>
	            <div class="content review-notice-wrap">
	              [리뷰이벤트]<br>
	              <br>
	              리뷰 작성 시, 원하시는 분들께 부족한 과목(택1) 단기 특강을 무료로 해드립니다! (*주1회 1시간)<br>
	              <br>
	              1) 국어 2) 수학 3) 영어<br>
	              <br>
	              * 솔직한 리뷰 작성 부탁드립니다~!! *
	            </div>
	          </div>
	          <div class="academy-content-wrap ">
	            <button class="bt-sec-header">
	              <h1 class="content">리뷰</h1>
	            </button>
	            <div class="content review-wrap">
	              <div class="shadow-wrap">
	                <div class="flex-wrap">
	                  <div class="flex-shrink-0 flex-glow-0 rating-wrap">
	                    <span class="rating-score">5.0</span>
	                    <span class="rating-star rating-star-5"></span>
	                  </div>
	                  <div class="flex-shrink-1 flex-glow-1 rating-count-wrap">
	                    <ul>
	                      <li class="flex-center">
	                        <span class="flex-shrink-0">5점</span>
	                        <div class="flex-glow-1 rating-bar">
	                          <div style="width:100%"></div>
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
	                <div class="flex-shrink-0 flex-glow-1 review-total">학생 리뷰 <span>2개</span> 학부모 리뷰 <span>1개</span> 학원장 댓글 <span>1개</span></div>
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
	                      <div class="review-writer"><span class="writer-id">양**</span><span class="writer-type">학생</span></div>
	                      <div class="review-rating"><span class="rating-star rating-star-5"></span><span class="review-date">1970-01-01</span></div>
	                      <div class="review-content">수학성적이 많이올랐습니다 짱입니다
	                      </div>
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

    <footer id="footer">
      <ul class="footer-wrap">
        <li><a href="https://skycatcher.co.kr/policy" class="footer-nav">이용약관</a></li>
        <li><a href="https://skycatcher.co.kr/privacy" class="footer-nav color-point">개인정보처리방침</a></li>
      </ul>
      <div class="container">
        <section class="content">
          <h1 class="skip">사이트 이용정보</h1>
          <ul class="footer-company">
            <li>스카이캐처</li>
            <li>대표 박유건 | 사업자등록번호 239-08-01729 | 통신판매업신고번호 2020-경북경산-0589</li>
            <li><a href="tel:053-295-9876">고객센터 053-295-9876</a></li>
            <li><a href="mailto:help@skycatcher.co.kr">이메일 help@skycatcher.co.kr</a></li>
            <li>경산북도 경산시 대학로 280, 영남대학교 생산과학기술연구원, 303</li>
          </ul>
        </section>
      </div>
    </footer>
  </div>
  <div id="modal-wrap" class="modal-wrap">
    <div class="modal-head">
      <button type="button" class="bt-icon close float-right">닫기</button>
      <h3 class="modal-title"></h3>
      <span class="modal-guide"></span>
    </div>
    <div class="modal-body"></div>
  </div>
  <div id="modal-filter-wrap" class="modal-wrap">
    <div class="modal-head">
      <button type="button" class="bt-icon close float-right">닫기</button>
      <h3 class="modal-title">필터선택</h3>
    </div>
    <div class="modal-body">
    </div>
  </div>
  <div id="ajax-loading" style="display: none;"></div>
  
<script type="text/javascript" src="<c:url value='/resources/js/common.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/js/detail.js'/>"></script>
</body>
</html>