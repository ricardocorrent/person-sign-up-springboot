set @a = unhex(replace(uuid(),'-',''));
INSERT INTO `permission` (`id`,`description`) VALUES
(concat(substr(@a, 7, 2), substr(@a, 5, 2),substr(@a, 1, 4), substr(@a, 9, 8)),"ADMIN");

set @o = unhex(replace(uuid(),'-',''));
INSERT INTO `permission` (`id`,`description`) VALUES
(concat(substr(@o, 7, 2), substr(@o, 5, 2),substr(@o, 1, 4), substr(@o, 9, 8)), "MANAGER");

set @u = unhex(replace(uuid(),'-',''));
INSERT INTO `permission` (`id`,`description`) VALUES
(concat(substr(@u, 7, 2), substr(@u, 5, 2),substr(@u, 1, 4), substr(@u, 9, 8)), "COMMON_USER");