CREATE DATABASE test; # control + enter 실행
# 데이터베이스들 확인
SHOW DATABASES;
# 사용할 데이터베이스 선택
USE test;

# 계정생성
## 로컬 계정
CREATE user scott@localhost IDENTIFIED BY 'tiger';
CREATE user scott@'%' IDENTIFIED BY 'tiger';

## 등록된 사용자 계정 조회
SELECT user, host from mysql.user;

# scott 계정에 권한 부여 - grant *.* 모든 DB, 모든 테이블
GRANT ALL PRIVILEGES on *.* to scott@localhost;
GRANT ALL PRIVILEGES on *.* to scott@'%';

# DB 선택
USE test;

# 테이블 생성
CREATE TABLE member (
	ID VARCHAR(10) PRIMARY KEY,
    PASSWORD VARCHAR(10) NOT NULL,
    NAME VARCHAR(50) NOT NULL,
    EMAIL VARCHAR(100) UNIQUE, -- 중복된 값을 가질 수 없다. 
    AGE INT NOT NULL CHECK(AGE > 0),
    CREATE_AT TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP 
    -- 값이 들어가는 시점의 일시를 디폴트 값으로 저장 
);

-- 테이블들 확인
SHOW TABLES;
-- 테이블의 컬럼 등 정보조회
DESC member;

-- 테이블 삭제
DROP TABLE member;
DROP TABLE IF EXISTS member;

SHOW TABLES;

-- INSERT
INSERT INTO member VALUES ('id-1','11111','이순신','lee@a.com',30,'2010-10-05 12:10:20');
-- INSERT INTO member VALUES ('id-2','11111','이순신','lee1@a.com',30,'2010-10-05 12:10:20');

-- 일부 컬럼에만 값을 넣을 경우 컬럼명을 지정
INSERT INTO member (ID, PASSWORD, NAME, EMAIL, AGE)
	VALUES ('id-100', '3333', '강감찬', 'kang@a.com', 20);

INSERT INTO member (ID, PASSWORD, NAME, AGE)
	VALUES ('id-101', '3333', '강감찬', 20);

COMMIT;

-- 확인
SELECT * FROM member;