-- grant all on test_dev.* to dev@"127.0.0.1" Identified by "12345678";
-- grant all on test_prod.* to prod@"127.0.0.1" Identified by "12345678";


drop table if exists `user`;
CREATE TABLE IF NOT EXISTS `user`(
  `id`  int unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(16) CHARACTER SET utf8mb4 NOT NULL,
  `age` int NOT NULL,
  PRIMARY KEY (`id`),
  unique key uniq_name(`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_bin;
