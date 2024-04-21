### [전체 목차](../../README.md)
### [이전 페이지](../README.md)

# 10 일차

- 집계함수(Aggregation)
- 그룹함수(GROUP BY)
-  
HAVING
다중행 함수

## 목차

- [집계함수](#집계함수)
- [그룹함수](#그룹함수)
- [having 절](#having-절)
- [서브쿼리](#서브쿼리)
 

## [집계함수](#목차)

인수(argument)는 컬럼
- sum(): 전체합계
- avg(): 평균
- min(): 최소값
- max(): 최대값
- stddev(): 표준편차
- variance(): 분산
- count(): 개수
    - 컬럼명: null을 제외한 값들의 개수.
    -  *: 총 행수 - null과 관계 없이 센다.
- count(distinct 컬럼명): 고유값의 개수.

**count(*)를 제외한 모든 집계함수들은 null을 제외하고 집계한다.**
> avg, stddev, variance 주의  
> 전체 개수가 아니라 null을 제외한 값들의 평균, 분산, 표준편차값이 된다.

- `avg(ifnull(컬럼, 0))`

문자타입/일시타입: `max()`, `min()`, `count()`만 사용가능
- 문자열 컬럼
  - max(): 사전식 배열에서 가장 마지막 문자열
  - min(): 첫번째 문자열
- 일시타입 컬럼은 오래된 값일 수록 작은 값이다.

```sql
SELECT 	COUNT(comm_pct), COUNT(emp_id),
		AVG(comm_pct), AVG(IFNULL(comm_pct, 0))
FROM    emp;

SELECT COUNT(DISTINCT job) FROM emp;

-- 급여의 총합계, 평균, 최소값, 최대값, 표준편차, 분산, 총직원수를 조회 
SELECT 
SUM(salary)                      "총합계",
ROUND(AVG(salary), 2)            "평균", -- null을 제거하고 계산
ROUND(AVG(IFNULL(salary, 0)), 2) "평균2", -- null을 0으로 바꾼 뒤 계산
MIN(salary)                      "최소값",
MAX(salary)                      "최대값",
ROUND(STDDEV(salary), 2)         "표준편차",
ROUND(VARIANCE(salary), 2)       "분산",
COUNT(salary)                    "급여가 있는 행수",
COUNT(*)                         "총 행수"
FROM   emp; 

-- EMP 테이블에서 가장 최근 입사일과 가장 오래된 입사일을 조회
SELECT 	MIN(hire_date), 
		MAX(hire_date)
FROM emp;

SELECT 'a' < 'b';
SELECT CAST('2020-10-10' AS DATE) > CAST('2022-10-10' AS DATE);

-- EMP 테이블의 부서의 개수를 조회
SELECT  COUNT(dept_name),
		COUNT(IFNULL(dept_name, '미배치')),
        COUNT(*)
FROM	emp;

-- EMP 테이블에서 job 종류의 개수 조회
SELECT COUNT(DISTINCT job) FROM emp;
```

### [그룹함수](#목차)

group by 절
- 특정 컬럼(들)의 값별로 행들을 나누어 집계할 때 기준컬럼을 지정하는 구문.
	- 예) 업무별 급여평균. 부서-업무별 급여 합계. 성별 나이평균
- 구문: group by 컬럼명 [, 컬럼명]
	- 컬럼: 범주형 컬럼을 사용 - 부서별 급여 평균, 성별 급여 합계
	- select의 where 절 다음에 기술한다.
	- select 절에는 group by 에서 선언한 컬럼들만 집계함수와 같이 올 수 있다.

```sql
-- 업무별 급여의 총합계, 평균, ..., 분산, 직원수를 조회
-- 집계할 때 select 절에 그룹으로 묶을 때 사용한 컬럼만 가능
select 	job,
		SUM(salary) "합계",
		ROUND(AVG(salary), 2) '평균',
        MIN(salary) '최소',
		MAX(salary) '최대',
		ROUND(STDDEV(salary), 2) "표준편차",
		ROUND(VARIANCE(salary), 2) "분산",
		COUNT(*) "직원수-행수"
FROM	emp
GROUP BY job;
-- 업무별 집계 => job 컬럼의 값이 같은 행들이 하나의 그룹으로 묶인다.

-- 입사연도별 직원들의 급여 평균.
SELECT round(avg(salary), 2) '평균급여',
		year(hire_date) '입사년도'
FROM emp
GROUP BY year(hire_date)
ORDER BY 1;

-- 부서명이 'Sales'이거나 'Purchasing'인 직원들의 업무별 직원수를 조회
select job, count(*)
from emp
where dept_name in ('Sales', 'Purchasing')
group by job;

-- 부서, 업무별 최대, 평균급여를 조회.
select dept_name, 
	   job,
	   avg(salary)
from emp
group by dept_name, job;

-- 급여 범위별 직원수를 출력. 급여 범위는 10000 미만,  10000 이상.
select 	if(salary >= 10000, '만달러 이상', '만달러 미만'),
		avg(salary)
from emp
group by if(salary >= 10000, '만달러 이상', '만달러 미만');
```

### [having 절](#목차)

- group by로 나뉜 그룹을 filtering 하기 위한 조건을 정의하는 구문.
- group by 다음 order by 전에 온다.
- 구문
    having 제약조건  
		- 연산자는 where절의 연산자를 사용한다. 
		- 피연산자는 집계함수의 결과
		
**where절은 행을 filtering한다.**  
**having절은 group by로 묶인 그룹들을 filtering한다.**

```sql
-- 직원수가 10 이상인 부서의 부서명(dept_name)과 직원수를 조회
select 
    dept_name, count(*) '직원수'
from
    emp
group by dept_name
having count(*) >= 10;

-- 직원수가 10명 이상인 부서의 부서명과 그 부서 직원들의 평균 급여를 조회.
select 
    dept_name, avg(salary) as '평균급여'
from
    emp
group by dept_name
having count(*) >= 10;
```

## [서브쿼리](#목차)

- 쿼리 안에서 select 쿼리를 사용하는 것.
- 서브쿼리가 사용되는 구
  - select절, from절, where절, having절
 
서브쿼리의 종류
- 어느 구절에 사용되었는지에 따른 구분
    - 스칼라 서브쿼리: select 절에 사용.
    - 인라인 뷰: from 절에 사용되어 테이블의 역할을 한다.

- 서브쿼리 조회결과 행수에 따른 구분
    - 단일행 서브쿼리: 서브쿼리의 조회결과 행이 한 행인 것.
    - 다중행 서브쿼리: 서브쿼리의 조회결과 행이 여러행인 것.

- 동작 방식에 따른 구분
    - 비상관 서브쿼리: 서브쿼리에 메인쿼리의 컬럼이 사용되지 않는다.
    - 상관 서브쿼리: 서브쿼리에서 메인쿼리의 컬럼을 사용한다. 

- 서브쿼리는 반드시 ()로 묶어줘야 한다.

```sql
-- 직원_ID가 120번인 직원과 같은 업무를 하는 직원의 id, ..., 급여 조회
select emp_id, emp_name, job_id, salary from emp
where job_id = (select job_id from emp where emp_id=120);

select 'ST_MAN';
select (select job_id from emp where emp_id=120);

select * from (select * from emp where dept_id=100) e;

-- 직원_id(emp.emp_id)가 115번인 직원과 같은 업무(emp.job_id)를 하고 같은 부서(emp.dept_id)에 속한 직원들을 조회하시오.
select * from emp
where (job_id, dept_id) = (select job_id, dept_id from emp where emp_id=115);
-- pair subquery

select * from emp where (job_id, dept_id) = ('PU_MAN', 30); -- 다른 DB 언어에서 안될수도 있음

-- 직원들 중 급여(emp.salary)가 전체 직원의 평균 급여보다 적은 직원들의 id(emp.emp_id), 이름(emp.emp_name), 급여(emp.salary)를 조회. 
select emp_id, emp_name, salary from emp
where salary < (select avg(salary) from emp)
order by salary desc;

select avg(salary) from emp;

-- 부서직원들의 평균이 전체 직원의 평균(emp.salary) 이상인 부서의 이름(dept.dept_name), 평균 급여(emp.salary) 조회.
-- 평균급여는 소숫점 2자리까지 나오고 통화표시($)와 단위 구분자 출력
select 
    dept_id, dept_name, concat('$', sal) '평균급여'
from
    (select 
        d.dept_id, d.dept_name, round(avg(e.salary), 2) 'sal'
    from
        emp e
    left join dept d ON e.dept_id = d.dept_id
    group by d.dept_id , d.dept_name
    having avg(salary) > (select 
            avg(salary)
        from
            emp)
    order by 3) t;











/* ----------------------------------------------
 다중행 서브쿼리
 - 서브쿼리의 조회 결과가 여러행인 경우
 - where절 에서의 연산자
	- in
	- 비교연산자 any : 조회된 값들 중 하나만 참이면 참 (where 컬럼 > any(서브쿼리) )
	- 비교연산자 all : 조회된 값들 모두와 참이면 참 (where 컬럼 > all(서브쿼리) )
------------------------------------------------*/
-- 'Alexander' 란 이름(emp.emp_name)을 가진 관리자(emp.mgr_id)의 부하 직원들의 ID(emp_id), 이름(emp_name), 업무(job_id), 입사년도(hire_date-년도만출력), 급여(salary)를 조회
select emp_id, emp_name, job_id, year(hire_date) "입사년도", salary
from emp
where mgr_id in (select emp_id from emp where emp_name = 'Alexander');


-- 직원 ID(emp.emp_id)가 101, 102, 103 인 직원들 보다 급여(emp.salary)를 많이 받는 직원의 모든 정보를 조회.
select * from emp
where salary > all (select salary from emp where emp_id in (101,102,103));

select * from emp
where salary > (select max(salary) from emp where emp_id in (101,102,103));

-- 직원 ID(emp.emp_id)가 101, 102, 103 인 직원들 중 급여가 가장 적은 직원보다 급여를 많이 받는 직원의 모든 정보를 조회.
select * from emp
where salary > any (select salary from emp where emp_id in (101,102,103))
order by salary;

select * from emp
where salary > (select min(salary) from emp where emp_id in (101,102,103))
order by salary;

-- TODO : 부서 위치(dept.loc) 가 'New York'인 부서에 소속된 직원의 ID(emp.emp_id), 이름(emp.emp_name), 부서_id(emp.dept_id) 를 sub query를 이용해 조회.
select emp_id, emp_name, dept_id from emp
where dept_id in (select dept_id from dept where loc = "New York");

select *
from emp e join dept d on e.dept_id = d.dept_id
where d.loc = "New York";

                  
-- TODO : 최대 급여(job.max_salary)가 6000이하인 업무를 담당하는  직원(emp)의 모든 정보를 sub query를 이용해 조회.
select * from emp
where job_id in (select job_id from job where max_salary <= 6000);

-- TODO: 전체 직원들중 부서_ID(emp.dept_id)가 20인 부서의 모든 직원들 보다 급여(emp.salary)를 많이 받는 직원들의 정보를 sub query를 이용해 조회.
select * from emp
where salary > all (select salary from emp where dept_id = 20);


/* *************************************************************************************************
상관(연관) 쿼리
- 메인쿼리문 테이블의 값을 where절의 subquery에서 참조한다.
	- 메인 쿼리의 where실행에서 한 행씩 조회 대상인지 검사하면서 subquery가 실행되는데 이때 현재 검사중인 그 행의 컬럼값을 subquery가 사용한다.
* *************************************************************************************************/
-- 부서별(DEPT)에서 급여(emp.salary)를 가장 많이 받는 직원들의 id(emp.emp_id), 이름(emp.emp_name), 연봉(emp.salary), 소속부서ID(dept.dept_id) 조회
select 
    *
from
    emp e
where
    salary = (select 
            max(salary)
        from
            emp
        where
            ifnull(dept_id, 0) = ifnull(e.dept_id, 0)) -- ifnull() dept_id가 null인 행 조회
order by dept_id;
-- where salary = 그 직원 소속된 부서의 직원들의 max salary



/* **************************************************************************************
EXISTS, NOT EXISTS 연산자 (상관(연관)쿼리와 같이 사용된다)
-- 서브쿼리의 결과를 만족하는 값이 존재하는지 여부를 확인하는 조건. 
-- 조건을 만족하는 행이 여러개라도 한행만 있으면 더이상 검색하지 않는다.

- 보통 데이터테이블의 값이 이력테이블(Transaction TB)에 있는지 여부를 조회할 때 사용된다.
	- 메인쿼리: 데이터테이블
	- 서브쿼리: 이력테이블
	- 메인쿼리에서 조회할 행이 서브쿼리의 테이블에 있는지(또는 없는지) 확인
	
고객(데이터) 주문(이력) -> 특정 고객이 주문을 한 적이 있는지 여부
장비(데이터) 대여(이력) -> 특정 장비가 대여 된 적이 있는지 여부
************************************************************************************* */
-- 직원이 한명이상 있는 부서의 부서ID(dept.dept_id)와 이름(dept.dept_name), 위치(dept.loc)를 조회
select dept_id, dept_name, loc from dept
where exists (select dept_id from emp where dept_id = dept.dept_id);


-- 직원이 한명도 없는 부서의 부서ID(dept.dept_id)와 이름(dept.dept_name), 위치(dept.loc)를 조회
select dept_id, dept_name, loc from dept
where not exists (select * from emp where dept_id = dept.dept_id);


### [목차로 돌아가기](#목차)
## [이전 페이지](../README.md)
