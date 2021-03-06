-- 2020.11.16

-- PhoneBook DDL : 테이블 정의서를 참고해서 DDL을 작성한다.

CREATE table phoneInfor_basic (
    idx NUMBER(6) constraint pi_basic_idx_PK primary key,
    fr_name VARCHAR2(20) not null,
    fr_phonenumber VARCHAR2(20) not null,
    fr_email VARCHAR2(20),
    fr_address VARCHAR2(20),
    fr_redate date default sysdate
)
;

desc phoneInfor_basic;

-- 제약 조건 확인 user_constraints
desc user_constraints;

select constraint_name, constraint_type
from user_constraints
where table_name = 'PHONEINFOR_BASIC'
;


-- 시퀀스 : 숫자 재생기
CREATE SEQUENCE SEQ_PIBASIC_IDX
MINVALUE 0
START WITH 0
INCREMENT BY 1
;

-- 질의 : READ
SELECT * FROM PHONEINFOR_BASIC;

-- INSERT : CREATE
INSERT INTO PHONEINFOR_BASIC 
VALUES (1, 'SCOTT', '010-0000-0000', 'SCOTT@GMAIL.COM', '서울', SYSDATE);


INSERT INTO PHONEINFOR_BASIC 
VALUES (SEQ_PIBASIC_IDX.nextval, 'SCOTT', '010-0000-0000', 'SCOTT@GMAIL.COM', '서울', SYSDATE);


INSERT INTO PHONEINFOR_BASIC (IDX, fr_name, fr_phonenumber)
VALUES (SEQ_PIBASIC_IDX.nextval, 'KING', '010-9999-9999');

-- 데이터 삭제 : DELETE
DELETE FROM phoneinfor_basic; -- 모든 행 대상

-- 데이터 업데이트 : UDATE
UPDATE phoneinfor_basic
SET fr_email = 'KING@NAVER.COM', fr_address = '부산'
where IDX = 7
;


-- C(CREATE), R(READ), U(UPDATE), D(DELETE)
-- INSERT, SELECT, UPDATE, DELETE


-- PhoneInfor_univ

drop table phoneinfor_univ;

create table phoneinfor_univ (
    idx number(6),
    fr_u_major VARCHAR2(20) default 'N',
    fr_u_year number(1) default 1 check (fr_u_year between 1 and 4),
    fr_ref number(6) not null,
    CONSTRAINT pi_univ_idx_PK PRIMARY key (idx), 
    CONSTRAINT pi_univ_ref_FK FOREIGN key (fr_ref) REFERENCES phoneInfor_basic (idx)
);

desc phoneinfor_univ;

select * from user_constraints where table_name = 'PHONEINFOR_UNIV';


-- CRUD
-- create : 대학친구 입력
-- 기본정보
INSERT INTO PHONEINFOR_BASIC (IDX, fr_name, fr_phonenumber)
VALUES (SEQ_PIBASIC_IDX.nextval, 'KING', '010-9999-9999');
-- 대학정보
insert into phoneinfor_univ values (3, 'computer', 2, SEQ_PIBASIC_IDX.currval);

-- read
select * from phoneinfor_univ;


select * 
from phoneinfor_basic pb, phoneinfor_univ pu
where pb.idx = pu.fr_ref
;

-- update : phoneInfor_univ where idx=3;
update phoneinfor_univ
set fr_u_major = '체육', fr_u_year=4
where idx=1;


-- delete : idx = 10 행을 삭제

delete phoneInfor_univ where fr_ref=7;
delete phoneinfor_basic where idx=7;


-- phoneInfor_com
create table phoneinfor_com (
    idx number(6) constraint pi_com_idx_PK primary key,
    fr_c_company VARCHAR2(20) default 'N',
    fr_ref number(6)not null constraint pi_com_ref_FK references phoneinfor_basic (idx) 
);


-- 회사 친구 정보 입력
-- 기본 정보
INSERT INTO PHONEINFOR_BASIC (IDX, fr_name, fr_phonenumber)
VALUES (SEQ_PIBASIC_IDX.nextval, '손흥민', '010-1111-1111');

-- 회사 정보 입력
insert into phoneinfor_com values(1, '토트넘', SEQ_PIBASIC_IDX.currval);

-- read
-- 회사 친구
select *
from phoneinfor_basic b, phoneinfor_com c
where b.idx=c.fr_ref
and b.fr_name='손흥민'
;

-- update
update phoneinfor_com
set fr_c_company = '레알'
where idx = 1
;

-- delete
-- 자식테이블의 행부터 삭제하고 부모테이블 행을 삭제
delete from phoneinfor_com where fr_ref=10;
delete from phoneinfro_basic where idx=10;




select *
from phoneinfor_basic pb, phoneinfor_univ pu, phoneinfor_com pc;










