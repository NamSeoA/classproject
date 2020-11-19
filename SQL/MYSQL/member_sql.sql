SELECT `member`.`idx`,
    `member`.`userid`,
    `member`.`password`,
    `member`.`username`,
    `member`.`regdate`
FROM `project`.`member`;
INSERT INTO `project`.`member`
(`userid`, `password`, `username`)
VALUES
('king', '1111', 'KING')
;

UPDATE `project`.`member`
SET
`idx` = <{idx: }>,
`userid` = <{userid: }>,
`password` = <{password: }>,
`username` = <{username: }>,
`regdate` = <{regdate: CURRENT_TIMESTAMP}>
WHERE `idx` = <{expr}>;

UPDATE `project`.`member`
SET
`password` = '1234',
`username` = 'COOL'
WHERE `idx` = 1;

DELETE FROM `project`.`member`
WHERE idx=1;

select * from project.member;

rollback;

commit;