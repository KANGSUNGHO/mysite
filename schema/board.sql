-- 게시판
ALTER TABLE `board`
	DROP FOREIGN KEY `FK_user_TO_board`; -- 회원 -> 게시판

-- 게시판
DROP TABLE IF EXISTS `board` RESTRICT;

-- 게시판
CREATE TABLE `board` (
	`no`       INT UNSIGNED NOT NULL COMMENT '번호', -- 번호
	`title`    VARCHAR(200) NOT NULL COMMENT '제목', -- 제목
	`content`  TEXT         NOT NULL COMMENT '내용', -- 내용
	`hit`      INT UNSIGNED NOT NULL COMMENT '조회수', -- 조회수
	`reg_date` DATETIME     NOT NULL COMMENT '등록일', -- 등록일
	`group_no` INT UNSIGNED NULL     COMMENT '그룹번호', -- 그룹번호
	`order_no` INT UNSIGNED NULL     COMMENT '순서번호', -- 순서번호
	`depth`    INT UNSIGNED NULL     COMMENT '페이지', -- 페이지
	`user_no`  INT UNSIGNED NOT NULL COMMENT '회원번호' -- 회원번호
)
COMMENT '게시판';

-- 게시판
ALTER TABLE `board`
	ADD CONSTRAINT `PK_board` -- 게시판 기본키
		PRIMARY KEY (
			`no` -- 번호
		);

ALTER TABLE `board`
	MODIFY COLUMN `no` INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '번호';

-- 게시판
ALTER TABLE `board`
	ADD CONSTRAINT `FK_user_TO_board` -- 회원 -> 게시판
		FOREIGN KEY (
			`user_no` -- 회원번호
		)
		REFERENCES `user` ( -- 회원
			`no` -- 번호
		);