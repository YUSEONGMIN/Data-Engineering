/* **************************************************************************
집계(Aggregation) 함수와 GROUP BY, HAVING
************************************************************************** */

/* ******************************************************************************************
# 집계함수, 그룹함수, 다중행 함수

- 인수(argument)는 컬럼.
  - sum(): 전체합계
  - avg(): 평균
  - min(): 최소값
  - max(): 최대값
  - stddev(): 표준편차
  - variance(): 분산
  - count(): 개수
        - 인수: 
            - 컬럼명: null을 제외한 값들의 개수.
            -  *: 총 행수 - null과 관계 없이 센다.
  - count(distinct 컬럼명): 고유값의 개수.
  
- count(*) 를 제외한 모든 집계함수들은 null을 제외하고 집계한다. 
	- (avg, stddev, variance는 주의)
	- avg(), variance(), stddev()은 전체 개수가 아니라 null을 제외한 값들의 평균, 분산, 표준편차값이 된다.=>avg(ifnull(컬럼, 0))
- 문자타입/일시타입: max(), min(), count()에만 사용가능
	- 문자열 컬럼의 max(): 사전식 배열에서 가장 마지막 문자열, min()은 첫번째 문자열. 
	- 일시타입 컬럼은 오래된 값일 수록 작은 값이다.

******************************************************************************************* */
SELECT 	COUNT(comm_pct), COUNT(emp_id),
		AVG(comm_pct), AVG(IFNULL(comm_pct, 0))
FROM    emp;

SELECT COUNT(DISTINCT job) FROM emp;

-- EMP 테이블에서 급여(salary)의 총합계, 평균, 최소값, 최대값, 표준편차, 분산, 총직원수를 조회 
SELECT SUM(salary)                      "총합계",
       ROUND(AVG(salary), 2)            "평균", -- null을 제거하고 계산
       ROUND(AVG(IFNULL(salary, 0)), 2) "평균2", -- null을 0으로 바꾼 뒤 계산
       MIN(salary)                      "최소값",
       MAX(salary)                      "최대값",
       ROUND(STDDEV(salary), 2)         "표준편차",
       ROUND(VARIANCE(salary), 2)       "분산",
       COUNT(salary)                    "급여가 있는 행수",
       COUNT(*)                         "총 행수"
FROM   emp; 

-- EMP 테이블에서 가장 최근 입사일(hire_date)과 가장 오래된 입사일을 조회
SELECT 	MIN(hire_date), 
		MAX(hire_date)
FROM emp;

SELECT 'a' < 'b';
SELECT CAST('2020-10-10' AS DATE) > CAST('2022-10-10' AS DATE);

-- EMP 테이블의 부서(dept_name) 의 개수를 조회
SELECT  COUNT(dept_name),
		COUNT(IFNULL(dept_name, '미배치')),
        COUNT(*)
FROM	emp;

-- EMP 테이블에서 job 종류의 개수 조회
SELECT COUNT(DISTINCT job) FROM emp;


-- TODO:  커미션 비율(comm_pct)이 있는 직원의 수를 조회
select count(comm_pct) from emp;

-- TODO:  커미션 비율(comm_pct)의 평균을 조회. 
select 
    avg(comm_pct) "값이 있는 사람들의 평균",
    avg(ifnull(comm_pct, 0)) "null -> 0, 전체직원평균"
from
    emp;

-- TODO: 급여(salary)에서 최고 급여액과 최저 급여액의 차액을 출력
select max(salary) - min(salary) from emp;

-- TODO: 가장 긴 이름(emp_name)이 몇글자 인지 조회.
select max(char_length(emp_name)) from emp;

-- TODO: EMP 테이블의 부서(dept_name)가 몇종류가 있는지 조회. 
select 
    count(distinct dept_name),
    count(distinct ifnull(dept_name, '1'))
    -- null도 포함해서 count 할 경우 먼저 null을 값으로 변환
from
    emp;

/* **************
group by 절
- 특정 컬럼(들)의 값별로 행들을 나누어 집계할 때 기준컬럼을 지정하는 구문.
	- 예) 업무별 급여평균. 부서-업무별 급여 합계. 성별 나이평균
- 구문: group by 컬럼명 [, 컬럼명]
	- 컬럼: 범주형 컬럼을 사용 - 부서별 급여 평균, 성별 급여 합계
	- select의 where 절 다음에 기술한다.
	- select 절에는 group by 에서 선언한 컬럼들만 집계함수와 같이 올 수 있다.
	
****************/

-- 업무(job)별 급여의 총합계, 평균, 최소값, 최대값, 표준편차, 분산, 직원수를 조회
-- 집계할 때 select 절에 올 수 있는 컬럼 - 그룹으로 묶을 때 사용한 컬럼만 가능
select 	job,
		SUM(salary) "합계",
		ROUND(AVG(salary), 2) '평균',
        MIN(salary) '최소',
		MAX(salary) '최대',
		ROUND(STDDEV(salary), 2) "표준편차",
		ROUND(VARIANCE(salary), 2) "분산",
		COUNT(*) "직원수-행수"
FROM	emp
GROUP BY job; -- 업무별 집계 => job 컬럼의 값이 같은 행들이 하나의 그룹으로 묶인다.

-- 입사연도 별 직원들의 급여 평균.
SELECT round(avg(salary), 2) '평균급여',
		year(hire_date) '입사년도'
FROM emp
GROUP BY year(hire_date)
ORDER BY 1;

-- 부서명(dept_name) 이 'Sales'이거나 'Purchasing' 인 직원들의 업무별 (job) 직원수를 조회
select job, count(*)
from emp
where dept_name in ('Sales', 'Purchasing')
group by job;

-- 부서(dept_name), 업무(job) 별 최대, 평균급여(salary)를 조회.
select dept_name, 
	   job,
	   avg(salary)
from emp
group by dept_name, job;

-- 급여(salary) 범위별 직원수를 출력. 급여 범위는 10000 미만,  10000이상 두 범주.
select 	if(salary >= 10000, '만달러 이상', '만달러 미만'),
		avg(salary)
from emp
group by if(salary >= 10000, '만달러 이상', '만달러 미만');

-- TODO: 부서별(dept_name) 직원수를 조회
select 
    dept_name, count(*)
from
    emp
group by dept_name
order by 2;

-- TODO: 업무별(job) 직원수를 조회. 직원수가 많은 것부터 정렬.
select 
    job, count(*)
from
    emp
group by job
order by 2 desc;

-- TODO: 부서명(dept_name), 업무(job)별 직원수, 최고급여(salary)를 조회. 부서이름으로 오름차순 정렬.
select 
    dept_name, job, count(*) '직원수', max(salary) '최고급여'
from
    emp
group by dept_name , job
order by 1 desc;

-- TODO: EMP 테이블에서 입사연도별(hire_date) 총 급여(salary)의 합계을 조회. 
-- (급여 합계는 정수부에 자리구분자 , 를 넣고 $를 붙이시오. ex: $2,000,000)
select 
    concat('$', format(sum(salary), 2)) 'salary',
    year(hire_date) '입사년도'
from
    emp
group by year(hire_date)
order by 2;

-- TODO: 같은해 입사해서 같은 업무를 한 직원들의 평균 급여(salary)을 조회
select 
    year(hire_date) "입사년도", job, avg(salary) "평균급여"
from
    emp
group by year(hire_date), job
order by 1;

-- TODO: 부서별(dept_name) 직원수 조회하는데 부서명(dept_name)이 null인 것은 제외하고 조회.
select 
    dept_name, count(*) "직원수"
from
    emp
where
    dept_name is not null
group by dept_name
order by 2;

-- TODO 급여 범위별 직원수를 출력. 급여 범위는 5000 미만, 5000이상 10000 미만, 10000이상 20000미만, 20000이상. 
-- case 문 이용
SELECT 
    CASE
        WHEN salary < 5000 THEN '5000미만'
        WHEN salary BETWEEN 5000 AND 9999.99 THEN '5000~10000'
        WHEN salary BETWEEN 10000 AND 19999.99 THEN '10000~20000'
        ELSE '20000이상'
    END '급여범위',
    COUNT(*) '직원수'
FROM
    emp
GROUP BY 급여범위;

select 
    job, count(*) '직원수'
from
    emp
group by job with ROLLUP;
-- with rollup => group by 하지 않고 집계한 결과를 마지막에 붙여준다.

                      
/* **************************************************************
having 절
- group by 로 나뉜 그룹을 filtering 하기 위한 조건을 정의하는 구문.
    - 집계하려는 그룹을 선택하는 조건 정의
- group by 다음 order by 전에 온다.
- 구문
    having 제약조건  
		- 연산자는 where절의 연산자를 사용한다. 
		- 피연산자는 집계함수(의 결과)
		
** where절은 행을 filtering한다.
   having절은 group by 로 묶인 그룹들을 filtering한다.		
************************************************************** */

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


-- TODO: 20명 이상이 입사한 년도와 (그 해에) 입사한 직원수를 조회.
select 
    year(hire_date), count(*)
    -- avg(salary)
from
    emp
group by year(hire_date)
having count(*) >= 20
order by 1;

-- TODO: 평균 급여가(salary) $5000 이상인 부서의 이름(dept_name)과 평균 급여(salary), 직원수를 조회
select 
    dept_name, avg(salary) '급여평균', count(*) '직원수'
from
    emp
group by dept_name
having avg(salary) >= 5000
order by 2;

-- TODO: 평균급여가 $5,000 이상이고 총급여가 $50,000 이상인 부서의 부서명(dept_name), 평균급여와 총급여를 조회
select 
    dept_name, avg(salary) '평균급여', sum(salary) '총급여'
from
    emp
group by dept_name
having avg(salary) >= 5000
    and sum(salary) >= 50000;

-- TODO  커미션이 있는 직원들의 입사년도별 평균 급여를 조회. 단 평균 급여가 $9,000 이상인 년도분만 조회.
select 
    year(hire_date) '입사년도', avg(salary) '평균급여'
from
    emp
where comm_pct is not null
group by year(hire_date)
having avg(salary) >= 9000;