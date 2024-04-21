### [전체 목차](../../README.md)
### [이전 페이지](../README.md)

# 9 일차

- SELECT 기본구문: `WHERE 절`, `order by`
- 함수: `문자열`, `숫자`, `날짜`, `조건 처리`, `타입 변환`, `CASE 문`

## 목차

- [SELECT 기본구문](#select-기본구문)
- [산술 연산](#산술-연산)
- [WHERE 절](#where-절)
- [order by](#order-by)
- [문자열 관련 함수](#문자열-관련-함수)
- [숫자 관련 함수](#숫자-관련-함수)
- [날짜 관련 함수](#날짜-관련-함수)
- [조건 처리함수](#조건-처리함수)
- [타입 변환함수](#타입-변환함수)
- [CASE 문](#case-문)



## [SELECT 기본구문](#목차)

> select 컬럼명 [as 별칭], 컬럼명 [, .....] : 조회할 컬럼 지정   
> select * : 모든 컬럼  
> from 테이블명 : 조회할 테이블 지정  
> distinct 컬럼명 : 중복된 결과를 제거한다.  

```sql
-- EMP 테이블의 모든 컬럼의 모든 항목을 조회.
SELECT * FROM test.emp;
USE test;
SELECT * FROM emp;

-- EMP 테이블의 직원 ID, 직원 이름, 업무 컬럼의 값을 조회.
SELECT 	emp_id, emp_name, job
FROM emp;

-- 동일한 값은 하나씩만 조회되도록 처리.
SELECT DISTINCT job -- , dept_name DISTINCT는 하나만
FROM emp;

-- 별칭으로 조회 결과를 출력한다.
SELECT 	emp_id AS 직원ID,
		emp_name "직원 이름", 
        hire_date "입사일",
        salary "급여",
        dept_name "소속부서"
FROM	emp;
```

## [산술 연산](#목차)

```sql
SELECT 10 + 10 AS "결과"; -- FROM DUAL for Oracle
SELECT	10 / 4, 10 DIV 4, -- div: 몫
        10 % 3, 10 MOD 3;

-- 문자열 합치기 
SELECT concat('나이', 30);

-- null과 number, date를 연산하면 결과는 null
SELECT 1 + 20 * 30 + NULL;
SELECT NOW() + NULL;
SELECT concat("이름", NULL);

-- EMP 테이블에서 직원의 이름, 급여, 급여 + 1000 한 값을 조회.
SELECT salary * 12 "연봉" FROM emp;
SELECT salary "월급", salary * 12 "연봉" FROM emp;
SELECT salary, comm_pct, salary * comm_pct FROM emp;
SELECT emp_name, salary + 1000 FROM emp;
```

## [WHERE 절](#목차)

- mysql은 비교시 대소문자를 가리지 않는다.

```sql
select * from emp where emp_name = 'steven'; 
-- Steven 조회된다.

-- 대소문자 구별해서 비교하게 하려면 컬럼명 앞에 BINARY를 붙인다.
where BINARY emp_name = 'Steven'
  and BINARY job_id='aD_PRES';
```

- where 절을 이용한 행 선택 

```sql
-- EMP 테이블에서 직원_ID가 110인 직원의 이름과 부서명을 조회
SELECT 	emp_name, dept_name 
FROM	emp
WHERE	emp_id = 110;
 
-- 'Sales' 부서에 속하지 않은 직원들의 ID, 이름, 부서명을 조회.
SELECT 	emp_id, emp_name, dept_name 
FROM	emp
WHERE BINARY dept_name <> 'sales';
-- WHERE	dept_name != 'Sales';

-- EMP 테이블에서 급여가 $10,000를 초과인 직원의 ID, 이름과 급여를 조회
SELECT	emp_id, emp_name, salary
FROM	emp
WHERE	salary > 10000;
 
-- 커미션 비율이 0.2 ~ 0.3 사이인 직원의 ID, 이름, 커미션 비율을 조회.
SELECT	emp_id, emp_name, comm_pct
FROM	emp
WHERE	comm_pct BETWEEN 0.2 AND 0.3;
-- WHERE	comm_pct NOT BETWEEN 0.2 AND 0.3;

-- 업무가 'IT_PROG' 거나 'ST_MAN' 인 직원의 ID, 이름, 업무를 조회.
SELECT	emp_id, emp_name, job
FROM	emp
WHERE	job IN ("IT_PROG","ST_MAN");
-- WHERE	job = "IT_PROG" OR job = "ST_MAN";

-- EMP 테이블에서 직원 이름이 S로 시작하는 직원의 ID, 이름을 조회.
SELECT	emp_id, emp_name
FROM	emp
WHERE	emp_name LIKE 'S%'; # 0개 이상의 아무 글자

-- EMP 테이블에서 직원 이름의 세 번째 문자가 “e”인 사원의 이름을 조회
SELECT	emp_name
FROM	emp
WHERE	emp_name LIKE '__e%'; -- _: 1개의 아무글자

-- 직원의 이름에 '%' 가 들어가는 직원의 ID, 직원이름 조회
SELECT	emp_id, emp_name
FROM	emp
WHERE	emp_name LIKE '%)%%' ESCAPE ')'; # ESCAPE 문자 지정

-- EMP 테이블에서 부서명이 null인 직원의 ID, 이름, 부서명을 조회.
SELECT	emp_id, emp_name, dept_name
FROM	emp
WHERE	dept_name IS NULL;
-- WHERE	dept_name IS NOT NULL;
```

- WHERE 조건이 여러 개인 경우 AND 나 OR 로 조건들을 묶어준다.
 
> 연산 우선순위: AND > OR  
> - where 조건1 and 조건2 or 조건3  
>   1. 조건 1 and 조건2  
>   2. 1결과 or 조건3
>
> or를 먼저 하려면 where 조건1 and (조건2 or 조건3)  

```sql
-- 업무가 'SA_REP' 이고 급여가 $9,000인 직원 조회.
SELECT	emp_id,emp_name,job,salary
FROM 	emp
WHERE 	job = 'SA_REP'
AND 	salary = 9000;
```

## [order by](#목차)

order by를 이용한 정렬
- order by절은 select문의 마지막 구문으로 온다.
- order by 정렬기준컬럼 정렬방식 [, ...]

> 문자열 오름차순: 숫자 -> 대문자 -> 소문자 -> 한글  
Date 오름차순: 과거 -> 미래  
null 오름차순: null이 먼저 나온다.  
*(오라클 DB는 null이 마지막에 나온다.)*

```sql
order by salary asc, emp_id desc
-- salary로 전체 정렬하고 salary가 같은 행은 emp_id로 정렬.

-- 직원들의 전체 정보를 직원 ID가 큰 순서대로 정렬해 조회
SELECT * FROM emp ORDER BY emp_id DESC;

-- 직원들의 id, 이름, 업무, 급여를 업무 순서대로 조회하고
-- 업무가 같은 직원들은 급여가 높은 순서대로 2차 정렬해서 조회.
SELECT	emp_id, emp_name, job, salary
FROM	emp
-- ORDER BY job ASC, salary DESC;
ORDER BY 3, 4 DESC, 2 DESC;

-- 부서명의 오름차순으로 정렬해 조회하시오.
SELECT * FROM emp ORDER BY dept_name;
```

## [함수](#목차)

단일행 함수
- 행별로 처리하는 함수. 문자/숫자/날짜/변환 함수 
- 단일행은 select, where절에 사용가능

다중행 함수
- 여러행을 묶어서 한번에 처리하는 함수 => 집계함수, 그룹함수라고 한다.
- 다중행은 where절에는 사용할 수 없다. (sub query 이용) 

### [문자열 관련 함수](#목차)

- `char_length(v)`: v의 글자수 반환  
- `concat(v1, v2[, ..])`: 값들을 합쳐 하나의 문자열로 반환
- `format(숫자, 소수부 자릿수)`
  - 정수부에 "," 를 표시하고 지정한 소수부 자리까지만 문자열로 반환
- `upper(v)`, `lower(v)`: v를 모두 대문자/소문자로 변환
- `insert(기준문자열, 위치, 길이, 삽입문자열)`
  - 기준문자열의 위치부터 길이까지 지우고 삽입문자열을 넣는다.
- `replace(기준문자열, 원래문자열, 바꿀문자열)`
  - 기준문자열의 원래문자열을 바꿀문자열로 바꾼다.
- `left(기준문자열, 길이)`, `right()`
  - 기준문자열에서 왼쪽, 오른쪽의 길이만큼의 문자열을 반환한다.
- `substring(기준문자열, 시작위치, 길이)`
  - 기준문자열에서 시작위치부터 길이 개수의 글자만큼 잘라서 반환한다.
- `substring_index(기준문자열, 구분자, 개수)`
  - 기준문자열을 구분자를 기준으로 나눈 뒤 개수만큼 반환
- `ltrim(문자열)`, `rtrim()`, `trim()`
  - 문자열에서 왼쪽, 오른쪽, 양쪽의 공백을 제거한다. 중간공백은 유지
- `trim(방향 제거할문자열 from 기준문자열)`
  - 기준문자열에서 방향에 있는 제거할문자열을 제거한다.
  - 방향: both (앞,뒤), leading (앞), trailing (뒤)
- `lpad(기준문자열, 길이, 채울문자열)`, `rpad()`
  - 기준문자열을 길이만큼 늘린 뒤 남는 길이만큼 왼쪽, 오른쪽에 채운다. 
  - 기준문자열 글자수가 길이보다 많을 경우 나머지는 자른다.

```sql
SELECT char_length('abcdefg'); -- 글자수
SELECT upper('aaaaa'), lower('AAAAA'); -- 대소문자 변환
SELECT format(312001000, 0);
SELECT concat('$', format(1020202.982929, 3));
SELECT replace('aaaabbbcccddd', 'aaa', 'AAA');
SELECT left('1234567890', 5); -- 왼쪽(앞에서) 5글자만 조회
SELECT right('1234567890', 5); -- 오른쪽(뒤에서) 5글자만 조회
SELECT substring('1234567890', 4, 3); -- 4번째부터 3글자
SELECT mid('1234567890', 4, 3); -- 4번째부터 3글자

SELECT char_length('   123   ');
-- 공백 제거
SELECT char_length(trim('   123   '));
SELECT char_length(rtrim('   123   '));
SELECT char_length(ltrim('   123   '));

SELECT LPAD('abc', 10, '+'); -- 글자수를 10에 맞춘다. 
SELECT RPAD('abc', 10, '+'); -- 모자라면 오른쪽에 +를 붙인다.
SELECT LPAD(30, 10, '+'); -- 대상이 꼭 문자열이 아니어도 됨.
SELECT LPAD('abcdef', 3, '+'); -- 모자라면 채우고 남으면 제거.

-- EMP 테이블에서 직원의 이름을 모두 대문자, 소문자, 이름 글자수를 조회
SELECT  emp_name,
        UPPER(emp_name),
        LOWER(emp_name),
        CHAR_LENGTH(emp_name)
FROM 	emp
ORDER BY 4; -- char_length(emp_name);
```

### [숫자 관련 함수](#목차)

- `abs(값)`: 절대값 반환
- `round(값, 자릿수)`: 자릿수 이하에서 반올림
  - 양수: 실수부, 음수: 정수부, 기본값: 0
- `truncate(값, 자릿수)`: 자릿수이하에서 절삭-버림
- `ceil(값)`: 값보다 큰 정수중 가장 작은 정수. 소숫점 이하 올린다.
- `floor(값)`: 값보다 작은 정수중 가장 작은 정수. 소숫점 이하 버린다.
- `sign(값)`: 숫자 n의 부호를 정수로 반환 (1:양수, 0, -1:음수)
- `mod(n1, n2)`: n1 % n2

```sql
SELECT ABS(10), ABS(- 10);
SELECT SIGN(10), SIGN(0), SIGN(- 100);

-- 반올림: round()
SELECT ROUND(50.12345, 3); -- 3자리 이하에서 반올림
SELECT ROUND(50.12345, 0); -- 정수 => 0을 기본값
SELECT ROUND(50.12345);
SELECT ROUND(987654, -3); -- 음수 -> 정수부 자릿수

SELECT TRUNCATE(50.9999, 2);
SELECT TRUNCATE(50.9999, 0);
SELECT TRUNCATE(15550.9999, - 2);
```

### [날짜 관련 함수](#목차)

- `now()`: 현재 datetime
- `curdate(`)`: 현재 date
- `curtime()`: 현재 time
- `year(날짜)`, `month(날짜)`, `day(날짜)`
  - 날짜 또는 일시의 년, 월, 일을 반환한다.
- `hour(시간)`, `minute(시간)`, `second(시간)`, `microsecond(시간)`
  - 시간 또는 일시의 시, 분, 초, 밀리초를 반환한다.
- `date()`, `time()`: datetime에서 날짜, 시간만 추출한다.

**날짜 연산**

- `adddate/subdate(DATETIME/DATE/TIME, INTERVAL 값 단위)`
  - 날짜에서 특정 일시만큼 더하고 빼는 함수
  - 단위: SECOND, MINUTE, HOUR, DAY, WEEK, MONTH, QUARTER, YEAR
- `datediff(날짜1, 날짜2)`: 날짜1 – 날짜2 한 일수를 반환
- `timediff(시간1, 시간2)`: 시간1 - 시간2 한 시간을 반환
- `dayofweek(날짜)`: 날짜의 요일을 정수로 반환 (1: 일요일 ~ 7: 토요일)
- `date_format(일시, 형식문자열)`: 일시를 원하는 형식의 문자열로 반환

```sql
-- 실행시점의 일/시를 조회 함수
SELECT NOW();
SELECT CURDATE();
SELECT CURTIME();
-- insert into xxxxx () values (curdate());

-- 날짜 타입에서 년 월 일 조회
SELECT CURDATE(), YEAR(CURDATE()), MONTH(CURDATE()), DAY(CURDATE());

-- 시간 타입에서 시 분 초 조회
SELECT HOUR(CURTIME()), MINUTE(CURTIME()), SECOND(CURTIME());

SELECT month(hire_date) FROM emp;

-- 특정 기간 만큼 전,후의 일시를 조회
-- 오늘 기준 3일 후 날짜
SELECT ADDDATE(CURDATE(), INTERVAL 3 DAY);
SELECT ADDDATE(NOW(), INTERVAL 3 DAY);
-- 2년 전 날짜
SELECT SUBDATE(CURDATE(), INTERVAL 2 YEAR);
SELECT ADDDATE(NOW(), INTERVAL -2 YEAR);
-- 2년 5개월 후의 날짜
SELECT ADDDATE(NOW(), INTERVAL '2-5' YEAR_MONTH);
-- 35시간 25분 전
SELECT SUBDATE(NOW(), INTERVAL '35:25' HOUR_MINUTE);

SELECT DATEDIFF(CURDATE(), '2024-01-10'); -- 두 날짜의 일수 차이
SELECT TIMEDIFF(CURTIME(), '12:30:20');

SELECT DAYOFWEEK(NOW());
SELECT DAYOFWEEK('2000-10-21');

-- 형식 문자: %로 시작
SELECT DATE_FORMAT(NOW(), '%Y년 %m월 %d일 %H시 %i분 %s초 %W %p');
SELECT DATE_FORMAT(NOW(), '%Y%m%d%H%i%s');
```

### [조건 처리함수](#목차)

- `ifnull (기준컬럼(값), 기본값)`
  - 기준컬럼이 NULL이면 기본값을 출력, NULL이 아니면 기준컬럼 값을 출력
- `if (조건수식, 참, 거짓)`: 조건수식이 True이면 참, False이면 거짓 출력

```sql
SELECT IFNULL('a', 0); -- 값('a')이 null면 0을 반환
SELECT IFNULL(null, 0); -- 값이 null 이면 0을 반환

SELECT	IFNULL(comm_pct, 0) * salary
FROM	emp
WHERE emp_id = 100;
```

### [타입 변환함수](#목차)

- `cast(값 as 변환할타입)`, `convert(값, 변환할타입)`

- 변환가능 타입
  - BINARY: binary 데이터로 변환 (blob)
  - SIGNED: 부호있는 정수(64bit)
  - UNSIGNED: 부호없는 정수(64bit)
  - DECIMAL: 실수
  - CHAR: 문자열 타입 
  - DATE: 날짜 
  - TIME: 시간
  - DATATIME: 날짜시간 타입
	- 정수를 날짜, 시간타입으로 변환할 때는 양수만 가능

```sql
-- 시간을 정수형태로 변환   
SELECT '10' + 10;
SELECT CAST(NOW() AS SIGNED); -- 2024/01/12 14:25:21
SELECT CONVERT(CURDATE() , SIGNED);

-- 숫자를 날짜로 변환
SELECT CAST(20231231 AS DATE);
SELECT CONVERT(20231231 , date);

SELECT CAST('2023-12-31' AS DATE);

SELECT * FROM emp 
WHERE hire_date = CAST('2003-06-17' AS DATE);
-- 타입 변환작업이 묵시적으로 처리된다.

SELECT DATEDIFF(NOW(), CAST('2023-10-20' AS DATE));
-- 숫자를 문자열로 변환
SELECT CAST(2000 AS CHAR);
SELECT CONCAT(2000, '원');
SELECT CAST('1000' AS SIGNED) + 3000;
SELECT '1000' + 3000;
```

### [CASE 문](#목차)

- case문 동등비교  
```
case 컬럼 when 비교값 then 출력값
         [when 비교값 then 출력값]
         [else 출력값]
         end
```

- case문 조건문
```
case when 조건 then 출력값
    [when 조건 then 출력값]
    [else 출력값]
    end
```

```sql
"""
dept_name이 'IT'면 '전산실' 출력
            'Finance'면 '회계부' 출력
            'Sales'면 '영업부' 출력
            나머지는 그대로 출력;
"""
SELECT
CASE dept_name	WHEN 'IT' THEN '전산실'
                WHEN 'FINAnce' THEN '회계부'
                WHEN ' Sales' THEN '영업부'
                ELSE IFNULL(dept_name, '미배치') END AS "부서" 
FROM EMP;

-- Sales이면 '영업부' 나머지는 그대로;
SELECT IF(dept_name = 'Sales', '영업부', dept_name) AS "부서명" 
FROM emp;

-- 급여와 급여의 등급을 조회
-- 급여 등급은 10000 이상이면 '1등급', 10000미만이면 '2등급'
SELECT	salary,
CASE WHEN salary >= 10000 THEN "1등급"
     WHEN salary < 10000 THEN "2등급" END AS "급여등급1",
CASE WHEN salary >= 10000 THEN "1등급" ELSE "2등급" END AS "급여등급2"
FROM emp;

SELECT 	salary,
        IF(salary >= 10000, "1등급", "2등급") AS "등급"
FROM emp;
```

### [목차로 돌아가기](#목차)
## [이전 페이지](../README.md)
