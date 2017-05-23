-- grant all on test_dev.* to dev@"127.0.0.1" Identified by "12345678";
-- grant all on test_prod.* to prod@"127.0.0.1" Identified by "12345678";


drop table if exists `user`;
CREATE TABLE IF NOT EXISTS `user`(
  `id`  int unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(16) CHARACTER SET utf8mb4 NOT NULL,
  `age` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_bin;

insert into user(name,age) value ("张三", 11);
insert into user(name,age) value ("李四", 22);
insert into user(name,age) value ("王五", 55);
