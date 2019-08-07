--RICARDO
--ADMIN
--ADMIN
--MANAGER

set @r = unhex(replace(uuid(),'-',''));
set @s = unhex(replace(uuid(),'-',''));
set @a = unhex(replace(uuid(),'-',''));
set @o = unhex(replace(uuid(),'-',''));

INSERT INTO `user_permission` (`user_id`, `permission_id`) VALUES
	(concat(substr(@r, 7, 2), substr(@r, 5, 2),substr(@r, 1, 4), substr(@r, 9, 8)), concat(substr(@a, 7, 2), substr(@a, 5, 2),substr(@a, 1, 4), substr(@a, 9, 8))),
	(concat(substr(@s, 7, 2), substr(@s, 5, 2),substr(@s, 1, 4), substr(@s, 9, 8)), concat(substr(@a, 7, 2), substr(@a, 5, 2),substr(@a, 1, 4), substr(@a, 9, 8))),
	(concat(substr(@r, 7, 2), substr(@r, 5, 2),substr(@r, 1, 4), substr(@r, 9, 8)), concat(substr(@o, 7, 2), substr(@o, 5, 2),substr(@o, 1, 4), substr(@o, 9, 8)));

