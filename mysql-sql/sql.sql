CREATE SCHEMA `person-sign-up-springboot` ;

SELECT * from person;

INSERT INTO `mydb`.`user` (`id`, `user_name`, `full_name`, `password`, `account_non_expired`, `account_non_locked`, `credentials_non_expired`, `actived`) VALUES (NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

set @u = unhex(replace(uuid(),'-',''));
set @o = unhex(replace(uuid(),'-',''));
INSERT INTO `user`
(`id`, `user_name`, `full_name`, `password`, `account_non_expired`, `account_non_locked`, `credentials_non_expired`, `enabled`) VALUES
    (concat(substr(@u, 7, 2), substr(@u, 5, 2),substr(@u, 1, 4), substr(@u, 9, 8)), 'ricardo', 'Ricardo Corrent', '$2a$16$9qr2tv0HmXbHBsx.TZFjfux742wCZM32a8Wi6iBqwIqaizlHPuxHS', '1', '1', '1', '1'),
    (concat(substr(@o, 7, 2), substr(@o, 5, 2),substr(@o, 1, 4), substr(@o, 9, 8)), 'admin', 'Sys admin', '$2a$16$h4yDQCYTy62R6xrtFDWONeMH3Lim4WQuU/aj8hxW.dJJoeyvtEkhK', '1', '1', '1', '1');


select * from user;

INSERT INTO `permission` (`id`,`description`) VALUES ("8e77f5eb-fe54-41d5-8eb2-503d391b7cd7","ADMIN");
INSERT INTO `permissipermissionon` (`id`,`description`) VALUES ("917c5a58-b800-4ccd-aba7-ab80bd1cf37b", "MANAGER");
INSERT INTO `permission` (`id`,`description`) VALUES ("28ed22bb-f681-4794-b12b-004a6cc84077", "COMMON_USER");

select uuid();
