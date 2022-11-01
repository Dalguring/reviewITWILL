SELECT * FROM board;

SELECT * FROM member;

ALTER TABLE member CHANGE email email VARCHAR(50) NOT NULL;

UPDATE member SET auth_status='Y' WHERE id='test33';
ALTER TABLE board CHANGE board_pass board_pass VARCHAR(50) NOT NULL;
ALTER TABLE member CHANGE passwd passwd VARCHAR(100) NOT NULL;
UPDATE member
SET passwd=''
WHERE id='blussm1';