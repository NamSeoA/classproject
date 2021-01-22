select * from open.member;

select idx, memberid, password from open.member;
select idx, memberid, password, md5(password) from open.member;
#select idx, memberid, password, password(idx) from open.member;
select idx, memberid, password, sha1(password) from open.member;

#암호화
insert into open.member (memberid, password, membername)
values('test1', 
HEX(aes_encrypt('1111', SHA2('key_value', 512))), 
HEX(aes_encrypt('tester', SHA2('key_value', 512)))
);

#복호화
select  memberid,
convert(aes_encrypt(UNHEX(password), SHA2('key_value', 512)) using utf8),
convert(aes_encrypt(UNHEX(membername), SHA2('key_value', 512)) using utf8)
from open.member
where idx=60;
