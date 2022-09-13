# eka (every k-academy)
참여자 : 이송이, 최수현, 고정욱, 박강산, 이영재<br>
수행기간 : 2022.08.08 ~ 2022.08.31

# 1. 프로젝트 소개
eka는 코로나19로 인한 학원가의 피해를 줄이기 위해 만든 프로젝트입니다. 
학생은 학원을 직접 방문해 발품을 팔아 학원 정보를 얻고 학원은 전단지를 사용해서 학원을 홍보합니다.
언택트시대에 발맞춰 이런 문제점을 IT적으로 해결하기 위해 학원과 학생의 연결고리가 되어주는 플랫폼입니다.
학생들에게는 학원정보를 제공하고 학원측에는 학원 자체 관리 프로그램을 제공합니다.

## 1.1 프로젝트 개요
학원 찾기 기능(eka main)
```
:지도를 기반으로 현재위치, 검색어를 통해 근처에 있는 학원을 찾을 수 있습니다.
학원측에서 등록한 학원에 대한 정보를 확인하여 상담신청을 할 수 있고 eka학생 회원은 본인이 등록한 학원에 대해
리뷰를 남길 수 있습니다.
```
학원관리 시스템(eka manager)
```
:eka원장 회원은 학원신청을 통해 등록한 학원을 관리하는 관리시스템을 사용할 수 있습니다.
강좌, 강사, 원생, 상담, 성적 등을 관리할 수 있어 eka를 사용하는 유저는 학원 홍보, 관리를 모두 경험할 수 있습니다.
```
# 2. 프로젝트 구조
## 2.1 요구사항

모든 유저
> - 학원검색
> - 현재 위치 기반 가까운 학원 찾기
> - 학원 정보 보기
> - 학원 상담 신청

학생 유저
> - 학생 회원가입
> - 리뷰 작성

원장 유저
> - 원장 회원가입
> - 학원 신청, 학원 정보 

원장 유저
> - 학원 관리페이지 접속
> - 강사 관리
> - 강좌 관리
> - 원생 관리
> - 강좌별 출석체크
> - 상담 관리
> - 성적 관리
> - 원생별 리포트 보기

## 2.2 클래스 다이어그램
![class](https://user-images.githubusercontent.com/90902468/189823161-e3787cf2-6d3e-411a-ac55-41d2697c6e5f.png)

## 2.3 개발도구
> - JAVA
> - Spring
> - Mysql
> - tomcat Server
> - HTML, CSS
> - javaScript, Jquery
> - JSP
> - BootStrap

## 2.4 프로젝트 수행 일정
![image](https://user-images.githubusercontent.com/90902468/189824026-0397183f-0b68-495b-ac2f-414a3152eefb.png)

## 3. 주요 상세 페이지
- eka 메인페이지
![eka main](https://user-images.githubusercontent.com/90902468/189824155-024ee6a9-f51a-42b6-843e-11400a9874d3.png)
- 학원 검색 결과 페이지
![eka_main1](https://user-images.githubusercontent.com/90902468/189824190-b2bf7f99-ee77-4c3d-98de-7a4632e1fd5c.png)
- 학원 상세정보 페이지
![eka_main2](https://user-images.githubusercontent.com/90902468/189824237-a9cef07b-0f5a-4767-b62c-57f9680c5ecc.png)
- eka 학원 관리 시스템 메인 페이지
![image](https://user-images.githubusercontent.com/90902468/189824339-e2e0e64c-2b6a-42f6-bc05-2a6885360fea.png)
- eka 수강생 관리 페이지
![eka_manager2](https://user-images.githubusercontent.com/90902468/189824442-43f16425-8dd9-41b8-85e8-e562927e1b2b.png)
- 원생별 리포트 페이지
![eka_manager1](https://user-images.githubusercontent.com/90902468/189824560-ab7db75d-53fc-4ce3-aa57-aff846e67a37.png)



