-- 학원 상담
-- 참조테이블
-- 1. 학원테이블 : eka_academy
-- 2. 학원 상담 카테고리 : eka_academy_consulting_category
CREATE TABLE Consulting(
	cid					BIGINT 			PRIMARY KEY AUTO_INCREMENT,
	academyId			BIGINT		 	NOT NULL,
	name				VARCHAR(20)		NOT NULL,
	phone				VARCHAR(13) 	NOT NULL,
	consultCategory		VARCHAR(20)		NOT NULL,
	consultDetail		VARCHAR(100)	NOT NULL,
	consultContent		VARCHAR(300),
	applyDate			DATE 			NOT NULL,
	registDate			DATE,
	consultType			VARCHAR(2)		NOT NULL,
	CONSTRAINT Consulting_academyId_FK FOREIGN KEY(academyId) REFERENCES Academy(aid)
);
INSERT Consulting(academyId, name, phone, consultCategory,
	consultDetail, applyDate,consultType) 
	VALUES(1,"짱","010-1234-1234","입학","입학관련","2022-08-12","신청");
	
INSERT Consulting(academyId, name, phone, consultCategory,
	consultDetail, applyDate,consultType) 
	VALUES(1,"철","010-1235-1235","입학","입학관련","2022-08-13","신청");
	
INSERT Consulting(academyId, name, phone, consultCategory,
	consultDetail, applyDate,consultType) 
	VALUES(1,"맹","010-1236-1236","입학","입학관련","2022-08-13","신청");

	
UPDATE Consulting SET consultContent='누', registDate='2022-08-20', consultType='완료'
WHERE academyId = 2 AND applyDate = '2022-08-13' AND name = '철';	
	
SELECT * FROM Consulting;
DROP TABLE Consulting;  
SELECT * FROM Consulting WHERE academyId =2 AND consultType="신청";		