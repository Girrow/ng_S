CREATE TABLE `userH` (
	`userNo` INT(11) NOT NULL AUTO_INCREMENT,
	`username` VARCHAR(30) NOT NULL COLLATE 'utf8mb4_unicode_ci',
	`password` VARCHAR(30) NOT NULL COLLATE 'utf8mb4_unicode_ci',
	PRIMARY KEY (`userNo`)
)
COLLATE='utf8mb4_unicode_ci'
ENGINE=InnoDB
;

CREATE TABLE `post` (
	`pno` INT(11) NOT NULL AUTO_INCREMENT,
	`comment` VARCHAR(50) NOT NULL COLLATE 'utf8mb4_unicode_ci',
	`writer` VARCHAR(30) NOT NULL COLLATE 'utf8mb4_unicode_ci',
	`delYn` CHAR(1) NULL DEFAULT 'N' COLLATE 'utf8mb4_unicode_ci',
	PRIMARY KEY (`pno`)
)
COLLATE='utf8mb4_unicode_ci'
ENGINE=InnoDB
;

