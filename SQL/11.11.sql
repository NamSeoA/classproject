-- 과제 
-- 30
select deptno as 부서번호,
    decode(deptno, 10, 'ACCOUNTING',
                   20, 'RESEARCH',
                   30, 'SALES',
                   40, 'OPERATIONS')as 부서이름,
    decode(deptno, 10, 'NEW YORK',
                   20, 'DALLAS',
                   30, 'CHICAGO',
                   40, 'BOSTON')as 지역명,
     count(*) as 사원수,
     round(avg(sal)) as 평균급여
from emp
group by deptno
;
--=======================================================

-- JOIN
-- 32번
select dept.deptno, dname
from emp, dept
where emp.deptno=dept.deptno and ename = 'SCOTT'
;


select *
from emp inner join dept
on emp.deptno = dept.deptno
;


select emp.ename, dept.dname, dept.loc
from emp inner join dept
on emp.deptno = dept.deptno
;


select emp.ename, dept.dname
from emp, dept
where emp.deptno=dept.deptno and ename like '%A%'
;


select e.ename, e.job, d.deptno, d.dname
from emp e, dept d
where e.deptno=d.deptno and d.loc = 'NEW YORK'
;



select e.ename, e.empno, m.ename as manager
from emp e, emp m
where e.mgr = m.empno
;


select e.empno, e.ename, m.ename as manager
from emp e, emp m
where e.mgr = m.empno(+)
order by empno desc
;


select deptno from emp where ename = 'SCOTT';

select ename, empno as coworker
from emp
where deptno = (select deptno from emp where ename = 'SCOTT')
;

select ename, hiredate
from emp
where hiredate > (select hiredate from emp where ename = 'WARD')
;


select e.ename as 사원, e.hiredate as 입사일, m.ename as 관리자, m.hiredate as 입사일
from (select distinct e.empno, e.ename, e.hiredate
from emp e, emp m
where e.empno = m.mgr) e, emp m
where e.empno = m.mgr and e.hiredate < m.hiredate
;
--=====================================================================
