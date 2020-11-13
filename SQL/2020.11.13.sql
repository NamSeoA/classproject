-- 2020.11.13

-- Transaction
-- 여러개의 SQL을 하나의 단위로 처리하는 것
-- 트랜잭션이 가지는 모든 작업이 모두 정상 처리 되어야 트랜잭션이 완료되었다고 하는 것
-- 처리과정에서 오류가 발생하면 처음으로 돌아가 다시 트랜잭션을 시작

select * from emp10;
desc emp10;
select * from dept01;


-- 부서 테이블에 데이터 하나를 저장 -- 정상처리
-- 사원 테이블에 새로운 사원을 입력 -- 오류 발생 시켜보기 (rollback)

-- Transaction 시작
insert into dept01 values (50, 'RD', 'SEOUL');
insert into emp10 (empno, ename, job, sal) values('ten', 'TEN', 'MANAGER', 2500);
rollback; -- 오류가 발생하여 초기화 ( 마지막 저장 단계(commit 단계)로 이동
select * from dept01;

-- 새로운 Transaction 시작
insert into dept01 values (50, 'RD', 'SEOUL');
insert into emp10 (empno, ename, job, sal) values(7777, 'SEVEN', 'MANAGER', 2500);
select * from dept01;
select * from emp10;
commit;

-- 새로운 Transaction 시작 
update emp10
set mgr  = (select empno from emp10 where ename = 'KING')
;
select * from emp10;
-- 잘못 처리된 작업이다 !! -> rollback 
ROLLBACK;


-- 가상테이블 VIEW
-- 실제 테이블을 기반으로 논리적인 가상테이블을 -> VIEW
-- Create [or replace] view view_name as subquery

-- 자주 사용되는 30번 부서에 소속된 사원들의 이름과 부서번호를 출력
create view view_emp30
as select empno, ename, deptno from emp where deptno = 30
;
select * from view_emp30;

-- 전사 정보 출력 (사원 정보, 부서정보)
select *
from emp, dept
where emp.deptno = dept.deptno
and emp.deptno=10
;

select * from view_emp_dept
where deptno=10;  -- view를 쓰는 첫번째 목적

create or replace view view_emp_dept
as 
select empno, ename, job, mgr, hiredate, sal, comm, emp.deptno, dname, loc
from emp, dept
where emp.deptno = dept.deptno
;

-- view 정보확인 : user_views 테이블을 통해 확인이 가능, 로그인한 사용자의 view 인스턴스의 정보
select view_name, text from user_views;


-- view_emp30를 통해 insert
insert into view_emp30 values(9999, 'tester', 40);

desc emp;
select * from emp;

rollback;

-- drop : view 삭제(객체를 삭제하는 방식과 동일)
-- drop {table | view } view_name
drop view view_emp_dept;
select * from user_views;


-- view_hire : 입사일 기준으로 오름차순 정렬된 결과를 가상테이블로 정의
select rownum, empno, ename, hiredate 
from emp
order by hiredate
;

create or replace view view_emp_hire
as
select empno, ename, hiredate 
from emp
order by hiredate
;
select rownum, empno, ename, hiredate from view_emp_hire;  -- rownum재정렬됨

select * from view_emp_hire where rownum<=5; -- 입사일이 빠른순


-- 인라인 뷰를 이용해서 가장 최근에 입사한 사원 5명 출력
select * 
from (select * from emp order by hiredate desc)
where rownum<=5
;


-- sequence : 숫자 자동 생성기, 시작값, 증가값, 최대값, 최소값, 반환여부
-- dept 테이블 deptno -> pk 10 -> 20 -> 30 ...
-- deptno에 사용할 sequence를 생성
drop sequence seq_dept_deptno;
create sequence seq_dept_deptno
MINVALUE 10 
MAXVALUE 90
start with 10
INCREMENT BY 10
;

-- emp 테이블의 empno기본키에 사용할 sequence를 생성
create sequence seq_emp_empno
MINVALUE 0
start with 0
INCREMENT BY 1
;

-- sequence 객체로 숫자를 생성, 현재 숫자 읽어오는 명령
-- 숫자 생성 : nextval -> 새로운 숫자를 생성하고 숫자를 반환
-- 현재 숫자 반환 : currval

-- 새롭게 생성하는 숫자를 확인
select seq_dept_deptno.nextval  -- dept deptno 입력시 사용
from dual;

-- 현재 숫자를 확인
select seq_dept_deptno.currval
from dual;

insert into dept01 values (seq_dept_deptno.nextval, 'test', 'test');

select * from dept01;



-- index : 검색을 빠르게 하기 위한 객체
-- create index index_name on target Table_name (column_name)

-- index 확인하는 user_ind_column
desc user_ind_columns;

select index_name, table_name, column_name
from user_ind_columns
;

-- primary key 또는 unique 속성은 자동으로 index 생성

select * from emp10;

insert into emp10 select * from emp10;

insert into emp10 (empno, ename) values (2222, 'COOL');

select empno, ename from emp10 where ename='COOL';
select empno, ename from emp10 where empno= 2222;

-- ename을 인덱스로 정의
create index index_emp10_ename
on emp10(ename);

-- empno indxe로 생성
create index index_emp10_empno
on emp10(empno);

-- 0.243

-- 0.451


commit; 




