

## Maven

- Apache에서 개발한 자바 프로젝트의 빌드 자동화 도구
- 라이브러리 의존성 관리를 위해 사용된다.
    - 필요한 라이브러리들을 POM.xml에 정의하면 프로젝트에 주입해줌
    - POM: Project Object Model

### pom.xml 주요 속성

```xml
<project>
  <!-- 스프링부트 -->
  <parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>3.1.3</version>
    <relativePath/> <!-- lookup parent from repository -->
  </parent>

  <!-- 프로젝트 정보 -->
  <groupId>com.example</groupId>
  <artifactId>basic</artifactId>
  <version>0.0.1-SNAPSHOT</version> 
  <name>basic</name>
  <description>Demo project for Spring Boot</description>

  <!-- 프로젝트 자바버전  -->
  <properties>
    <java.version>17</java.version>
  </properties>

  <!-- 라이브러리들 -->
  <dependencies>
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    ...
  </dependencies>

  <!-- 빌드 설정  -->
  <build>
    ...
  </build>
</project>
```

### 라이브러리 의존성 주입

1. [Maven Repository](https://mvnrepository.com/) 접속
- mysql connector 검색
2. 알맞은 라이브러리 버전 선택
- 가장 많이 사용된 버전 위주
3. Maven 설정 복사 및 pom.xml 붙여넣기
```xml
<!-- https://mvnrepository.com/artifact/com.mysql/mysql-connector-j -->
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <version>8.0.33</version>
</dependency>
```