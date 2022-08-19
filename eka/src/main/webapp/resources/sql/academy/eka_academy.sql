
-- 학원유저(원장용)
CREATE TABLE AcademyManager (
	aid				BIGINT 			PRIMARY KEY AUTO_INCREMENT,
	userId			VARCHAR(20) 	NOT NULL,
	userPw			VARCHAR(20) 	NOT NULL,
	name			VARCHAR(20) 	NOT NULL,
	phone			VARCHAR(13) 	NOT NULL,
	ssn				VARCHAR(14) 	NOT NULL,
	regDate			TIMESTAMP		NOT NULL	DEFAULT CURRENT_TIMESTAMP
);

DROP TABLE AcademyManager;

-- 학원
-- 학원 테이블을 만들기 위해 참고 sql 파일
-- 1.주소테이블(addressId) : eka_academy_address_category 
-- 2.학원분류테이블(academyCateogryId) : eka_academy_academycategory  
-- 필요한 column : lat, lon, field1, field2, field3, field4, priceList
CREATE TABLE Academy (
	aid						BIGINT 			PRIMARY KEY AUTO_INCREMENT,		
	name					VARCHAR(50) 	NOT NULL,
	openingday				DATE			NOT NULL, -- 개업일
	address					VARCHAR(100)	NOT NULL, -- 주소
	detailaddress			VARCHAR(100) 	NOT NULL, -- 상세주소
	lat						VARCHAR(20) 	NOT NULL,
	lon						VARCHAR(20) 	NOT NULL,
	personnel				BIGINT			NOT NULL, 
	field1					VARCHAR(100) 	NOT NULL,
	field2					VARCHAR(100) 	NOT NULL,
	field3					VARCHAR(100) 	NOT NULL,
	field4					VARCHAR(100) 	NOT NULL,
	priceList				VARCHAR(1000)	NOT NULL,
	phone					VARCHAR(20),			  -- 전화번호
	introduction			VARCHAR(300), 			  -- 소개글
	academyservice			VARCHAR(150), 			  -- 학원제공서비스
	runday					VARCHAR(50), 			  -- 운영요일 (이슈 하나 여러개 복수 가능)
	startruntime			TIME, 					  -- 시작운영시간 (00:00)
	endruntime				TIME,					  -- 종료운영시간 (00:00)
	consultableday			VARCHAR(50), 			  -- 상담가능요일 (이슈 둘 여러개 복수 가능)
	startconsultabletime	TIME, 					  -- 시작상담가능시간 (00:00)
	endconsultabletime		TIME, 					  -- 종료상담가능시간 (00:00)
	signedacademy			VARCHAR(50)				  -- '리스트는 다 나오는데' or '신청된 학원만 디테일한 정보가 뜨게 이걸로 구분'
);

SELECT * FROM Academy;

DROP TABLE Academy;

DROP TABLE payment;


INSERT INTO Academy(addressId, academyCategoryId, name,	registrationNum, detailaddress,email, phone, openingday,
			academyservice, runday, startruntime, endruntime, consultableday, startconsultabletime,
				endconsultabletime,academyCapacity, introduction)  VALUES(1,1,"코리아id","11-11-11","중앙로3번로","korea@namver.com",
				"010-1111-1111","2022-08-10","에어컨,침대","월,화","09:00","22:00",
				"월,화","09:00","18:00",50,"여기좋음 ㄹㅇ");

				
SELECT a.aid, a.name, a.registrationNum, d.ageCate, c.mainCate, b.subjectCate, f.county, e.city, a.detailaddress, 
a.email, a.phone, a.openingday, a.academyservice, a.runday, a.startruntime, a.endruntime, a.consultableday, a.startconsultabletime, 
a.endconsultabletime,a.academyCapacity, a.introduction 
 FROM Academy a JOIN SubjectCategory b 
 ON b.scid = a.academyCategoryId JOIN MainSubjectCategory c ON c.mcid = b.mainCateId JOIN AgeCategory d ON d.acid = c.ageCateId  
 JOIN CityAddress e ON e.cid = a.addressId JOIN CountyAddress f ON f.cid = e.countyId;
 
--SELECT * FROM Academy;

-- 학원정보를 담기 위한 쿼리문
SELECT a.aid, a.name, a.registrationNum, d.ageCate, c.mainCate, b.subjectCate, f.county, e.city, a.detailaddress FROM Academy a JOIN SubjectCategory b 
ON b.scid = a.academyCategoryId JOIN MainSubjectCategory c ON c.mcid = b.mainCateId JOIN AgeCategory d ON d.acid = c.ageCateId 
JOIN CityAddress e ON e.cid = a.addressId JOIN CountyAddress f ON f.cid = e.countyId;


--test query
INSERT INTO Academy(addressId, academyCategoryId, name, registrationNum, detailaddress)
VALUES(1, 1, '코리아IT', '111-22-11111', '반월당센트럴 10층');
INSERT INTO AcademyManager(userId, userPw, name, phone, ssn) VALUES('sdf', 'sdf', '김철수', '010-3333-3333', '2000-22-22');
--academyManager ssn -> date?