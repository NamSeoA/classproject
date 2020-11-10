-- 2020.11.10
-- 함수

-- 단일행, 집합함수

-- 단일행 함수 : 숫자, 문자, 날짜, 변환

desc dual;

-- 숫자 함수 
select ABS(-15.5) from dual;  -- 절대값
select floor(15.7) from dual;  -- 정수값
select round(15.193) from dual;  -- 정수타입으로 반올림
select round(15.193,3) from dual;  -- 몇째자리까지 표현할지(,숫자)
select log(10, 100) from dual;     -- 지수
select POWER(3,2) from dual;       -- 제곱


-- 문자 함수 
select CONCAT('나는 ', '손흥민 입니다.')from dual;  -- 문자열 붙여줌
select concat('저의 이름은 ', ename) from emp where job='MANAGER';
select LOWER('MR. SCOTT MCMILLAN') "Lowercase" FROM DUAL;  -- 대문자 -> 소문자
select lower(ename) from emp;
select LPAD('Page 1',15,'*') from dual; -- 전체 문자열 15자리를 만드는데 9자리는 *로 채운 후 Page 1 입력
select RPAD('001212-1',14,'*') from dual; -- 전체 문자열 15자리를 만드는데 숫자 입력 후 나머지 자리는 *로 채운다
select SUBSTR('ABCDEFG',3,4) FROM DUAL;   -- 3번째 자리부터 4개

-- 주민등록번호 출력시 개인정보 보호를 위해 뒷자리는 첫째자리를 제외하고 지워야함 (rpad, substr 활용)
-- select RPAD('001212-301247',14,'*') from dual; 
select RPAD(substr('001212-301247',1,8),14,'*') from dual; -- 뒷자리 3을 제외한 나머지 번호는 *처리

select Ltrim('  =from=', '  =') from dual;  -- LEFT에서 지우고 싶은 공백, 문자 입력 시 지워줌
select Rtrim('  =from=======    ', '   ') from dual;
select trim('=' from  '======From=====') as "from" from dual; -- 지워질 대상 앞쪽에
select trim(' ' from  '     ======From=====     ') as "from" from dual;

-- 문자를 바꾸고 싶을 때 자바에서 STRING으로 할 것인지 
-- 오라클에서 REPLACE로 할 것인지 둘 중 하나 선택해서 사용하면 됨
select REPLACE('JACK and JUE','J','BL') from dual;  -- J를 찾아 BL로 교체
select REPLACE('000000-000000','-','') from dual;  

-- 날짜 함수
select sysdate from dual;
select sysdate+14 from dual;
select sysdate+21 from dual;

select add_months(sysdate, 4) from dual;  -- +개월
select last_day(sysdate) from dual;       -- 그 달에 마지막 날


-- 변환 함수
-- TO_CHAR : 날짜->문자, 숫자->문자

-- 날짜 -> 문자
select sysdate, to_char(sysdate, 'YYYY.MM.DD DAY DY AM PM HH HH24 MI SS') from dual;
-- 2020.11.10 화요일 화 오전 오전 11 11 56 38
select to_char(sysdate, 'YYYY.MM.DD. HH24:MI') from dual;

-- 숫자 -> 문자
select to_char(100000.123, '000,000.00') from dual;  -- 100,000.12
select to_char(100000.123, 'L000,000.00') from dual;  --        ￦100,000.12

-- 다시 보기
select sal, to_char(sal*1100, 'L00,000,000') from emp;
select sal, to_char(sal*1100, 'L99,999,999') from emp;
select ename, job, sal, to_char(sal*1100*12+nvl(comm,0)*1100, 'L99,999,999') as "연봉" from emp order by sal desc;

-- 문자 -> 날짜
-- 2020.11.01.
select TO_DATE('2009/09/05', 'YYYY/MM/DD') from dual;
select TO_DATE('2020.11.01.', 'YYYY.MM.DD.') from dual;

-- 오늘이 2020년에 1월 1일에서 몇일이 지났는지 확인
select trunc(sysdate - to_date('20-01-01','YY-MM-DD')) from dual;

-- 내가 몇일을 살았는지 확인
select trunc(sysdate - to_date('97-10-27','YY-MM-DD')) from dual;  

-- 문자 -> 숫자
select TO_NUMBER('100.00', '999.99') * TO_NUMBER('100.00', '999.99') from dual;


-- decode 함수 : 자바의 switch 문과 비슷하다.
-- 사원이름, 부서번호, 부서이름 출력
select ename, deptno,
decode( deptno ,
        10, 'ACCOUNTING',  --DEPTNO=10이면 
        20, 'RESEARCH',   --DEPTNO=20이면
        30, 'SALES',      --DEPTNO=30이면
        40, 'OPERATIONS'  --DEPTNO=40이면
        ) AS NAME
from emp order by deptno
;


-- 직급에 따라 급여를 인상하도록 하자
--  ANALYST 인 사원은 5%
--  SALESMAN 인 사원은 10%
--  MANAGER 인 사원은 15%
--  CLERK 인 사원은 20%

select ename, sal,
decode ( job,
        'ANALIST', sal*1.05,
        'SALESMAN', sal*1.1,
        'MANAGER', sal*1.15,
        'CLERK', sal*1.20
        ) as upsal
from emp
order by sal
;

select distinct job from emp;

select ename as name, deptno as deno,
       case 
            when deptno=10 then 'ACCOUNTING'
            when deptno=20 then 'RESEARCH'
            when deptno=30 then 'SALES'
            when deptno=40 then 'OPERATIONS'
       end as dname
from emp
order by deptno
;

select comm from emp;


-- 그룹함수 : 하나의 행의 컬럼을 대상이 아닌 행의 그룹의 컬럼들을 묶어 그룹화하고 연산하는 함수
-- 그룹함수 : SUM, AVG, COUNT, MAX, MIN

select
        to_char(sum(sal)*1100, 'L999,999,999') as "월 급여 총액",  -- 매달 이정도의 금액이 직원들의 월급으로 나가는구나  
        round(avg(sal))*1100 as "월 급여 평균",   -- round 반올림
        count(sal) as "급여 전체 사원의 수",   --급여를 받는 전체 사원의 수
        count(comm) as "커미션 수",           -- 커미션을 받는 사원의 수
        max(sal) as "가장 많은 금여액",        -- 가장 많은 금여액
        min(sal) as "가장 적은 금액"
from emp
;


select
        sum(comm),
        avg(comm),
        count(nvl(comm, 0)),
        max(comm),
        min(comm)
from emp
;

-- 전체 행을 구하기
select 
        count(*) as "Manager의 수", 
        avg(sal) as "매니저의 평균 급여",
        max(sal) ,
        min(sal)
from emp
where job='MANAGER'
;

-- 직무의 개수
select count( distinct job )
from emp
order by job
;


-- 특정 컬럼을 기준으로 그룹핑 : group by 컬럼
select deptno, comm
from emp
group by deptno, comm
;

select * from emp order by deptno;


-- 각 부서의 소속 인원을 구하자
select deptno, count (*)  as "cnt"
from emp
group by deptno
-- order by count(*) desc
order by deptno
;

-- 각 부서별 총 급여액 출력
-- group by deptno : 부서별로 그룹핑
select deptno, sum(sal)
from emp
group by deptno
order by deptno
;

-- 부서별 급여 평균
select deptno, round(avg(sal))
from emp
group by deptno
order by deptno
;

-- 부서별 급여 최고 금액과 최소 금액을 출력
select deptno, max(sal), min(sal) , max(sal)-min(sal)
from emp
group by deptno
order by deptno
;

-- 부서별로 그룹지은 후,
-- 그룹 지어진 부서별 평균 급여
-- 평균 급여가 2000 이사인 (HAVING)
-- 부서번호와 부서별 평균 급여를 출력
select deptno, avg(sal)
from emp
group by deptno
-- having not (avg(sal) >= 2000)
having avg(sal) >= 2000
order by deptno
;

-- 부서별 최대값과 최소값을 구하되 최대 급여가 2900이상인 부서만 출력합니다
select deptno, max(sal), min(sal)
from emp
group by deptno
having max(sal) >= 2900
order by deptno
;


-- 직무별 지표 : 사원의 수, 급여의 총합, 평균 급여, 최대급여, 최소급여 
select job, 
    count(*)||'명' as "사원의 수", 
    to_char(sum(sal)*1100, 'L999,999,999') as "급여의 총합",
    to_char(avg(sal)*1100, 'L999,999,999') as "평균 급여", 
    to_char(max(sal), 'L999,999,999') as "최대 급여",
    to_char(min(sal), 'L999,999,999') as "최소 급여"
from emp
where job != 'PRESIDENT'  -- 그룹하기 위한 행을 선택하는 기준
group by job
order by job
;


-- SQL select 추가 문제
select bookname
from book
where bookid = 1
;

select bookname
from book
where price >= 20000
;

select sum(saleprice)
from orders
where custid=1
;

select count(orderid)
from orders
where custid=1
;

select count(bookid)
from book
;


select count(distinct publisher)
from book
;

select name, address 
from customer
;

select orderid
from orders
where orderdate between '2014/07/04' and '2014/07/07'
;

select orderid
from orders
where not orderdate between '2014/07/04' and '2014/07/07'
;

select name, address
from customer
where name like '김%'
;

select name, address
from customer
where name like '김%아'
;




-- 단일행 함수, 집합함수 문제
select ename, substr(hiredate, 1,5)
from emp;

select ename
from emp
where substr(hiredate, 4,2) = 04
;

select ename
from emp
where mod(empno,2) = 0
;


select to_char(hiredate,'YY.MM.DY')
from emp
;

select trunc(sysdate - to_date('20-01-01','YY-MM-DD')) from dual;



select empno, ename, nvl2(mgr, mgr ,0)
from emp
;


select ename, job, sal,
decode (job,
        'ANALIST',  sal+200,
        'SALESMAN', sal+180,
        'MANAGER',  sal+150,
        'CLERK',  sal+100
        ) as raisesal
from emp
;


select max(sal), min(sal), sum(sal), round(avg(sal))
from emp
;

select job,
    max(sal),
    min(sal),
    sum(sal),
    round(avg(sal))
from emp
group by job
order by job
;


select job,
    count(*)
from emp
group by job
;

select count(mgr)
from emp
;

select max(sal)-min(sal)
from emp
;

select job,
    min(sal)
from emp
where mgr is not null
having min(sal) > 2000
group by job
order by min(sal) desc
;

select deptno as "부서번호",
       count(ename) as "사원 수",
       round(avg(sal),2) as "모든 사원의 평균 급여"
from emp
group by deptno
;

select 
decode (deptno, 
         count(*),
         round(avg(sal)))
from emp
group by deptno
;
         
select job, deptno
decode(deptno, 10, sal(sum)) ,
decode(deptno, 20, sal(sum)),


         
         




