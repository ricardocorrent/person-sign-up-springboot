set @r = unhex(replace(uuid(),'-',''));
set @s = unhex(replace(uuid(),'-',''));
INSERT INTO `user`
(`id`, `user_name`, `full_name`, `password`, `account_non_expired`, `account_non_locked`, `credentials_non_expired`, `enabled`) VALUES
    (concat(substr(@r, 7, 2), substr(@r, 5, 2),substr(@r, 1, 4), substr(@r, 9, 8)), 'ricardo', 'Ricardo Corrent', '$2a$16$9qr2tv0HmXbHBsx.TZFjfux742wCZM32a8Wi6iBqwIqaizlHPuxHS', '1', '1', '1', '1'),
    (concat(substr(@s, 7, 2), substr(@s, 5, 2),substr(@s, 1, 4), substr(@s, 9, 8)), 'admin', 'Sys admin', '$2a$16$h4yDQCYTy62R6xrtFDWONeMH3Lim4WQuU/aj8hxW.dJJoeyvtEkhK', '1', '1', '1', '1');
