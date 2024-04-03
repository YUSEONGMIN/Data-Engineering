쿼리 순서: from - join - where - group - ...
에어플로우 경험
ETL 툴
배치, 스케줄링
흐름 스케줄링을 위해 배치 파일 개발
데이터 분석과 엔지니어 차이
크롤링 셀레니움
sql 실무 경험
join 최대 몇번까지 했는지
DA, 데싸, 분석가와 협업을 하게될텐데
주전은 엔지니어인데 부전은 뭐인것같나
서브 쿼리 튜닝 경험
직무 엔지니어 동기
RDMS 툴 써본경험 mysql 오라클 포스텍
시각화 bi 툴 경험
자바 사용경험


>Maven initial 사이트와 동일
버전
언어는 자바가 많음
com.example: 회사명
artifact, name: 프로젝트명
Packaging: Jar
add dependency 설정하면 pom.xml로 자동으로 라이브러리 설치

<!-- https://mvnrepository.com/artifact/com.mysql/mysql-connector-j -->
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <version>8.0.33</version>
</dependency>



// https://mvnrepository.com/artifact/com.mysql/mysql-connector-j
implementation 'com.mysql:mysql-connector-j:8.0.33'

.gradle : 빌드 저장되는 곳
.vscode : 프로젝트를 인식하고 작동되도록 세팅
build : 빌드 결과물 class (컴퓨터 언어로)
wrapper : jar 압축파일 -> 실행
src : 소스파일
src는 main과 test로 구분

DTO: data transfer object
클라이언트: 브라우저
dto는 클라이언트 사이에 존재
브라우저와 컨트롤러가 소통할 때 dto를 사용함
컨트롤러에서 작업할 때 사용하는 데이터를 담구는 바구니
dto 자료형

컨트롤러: 클라이언트가 요청한 것을 적절하게 서비스한테 전달
컨트롤러에는 비즈니스 로직이 들어가면 안됨
컨트롤러는 오직 올바른 요청인지만 확인
데이터를 서비스에게 전달하고 뷰 객체만 생성
소통하는 역할만. request와 response

비즈니스 로직은 서비스에
쇼핑몰 물건 팔 때 어떤 것을 팔 것인지
고객에게 무엇을 파는지 전달
고객에게 옷을 요청 받으면 올바른 요청 확인 후
옷 정보를 전달
고기를 요청 받으면 잘못된 요청

dto는 클라이언트가 ui 화면을 보고 요청함
테이블에 저장된 데이터 구조는 다름
dao는 mysql 등 테이블만 이해할 수 있음

서비스는 dto (ui)도 이해하고
엔티티(데이터베이스)도 이해함
서비스는 dao에 엔티티 정보를 요청
전달받으면 컨트롤러에게 dto (ui)로 바꾼 후 전달
클라이언트가 이해할 수 있도록

ORM은 sql을 쓰지 않아도 쿼리를 사용 할 수 있음
자바로도 가능하도록 한게 스프링 부트의 JPA

컨트롤러 폴더: http 통신 처리역할 request와 response
비즈니스 로직은 서비스 폴더에
데이터베이스는 모델 폴더에

http 관련 문제는 컨트롤러
데이터베이스 문제는 모델
비즈니스적 문제는 서비스


yaml 설정하기
model 폴더에 dao, dto, entity, repository 만들기
entity 만들기
repository 만들기
dao, dto 만들기
service 폴더 만들기. 파일 만들기