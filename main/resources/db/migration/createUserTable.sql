CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `fullname` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `department` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `address` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `role` varchar(25) COLLATE utf8_unicode_ci DEFAULT 'Admin',
  `isTerminated` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0= active, 1 = inactive',
  `createdAt` date NOT NULL,
  `modifiedAt` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=20 ;



INSERT INTO user (username, password, fullname, department, address, role, createdAt)
SELECT * FROM (SELECT 'Krishna', 'admin123', 'Krishna Timilsina', 'JAVA', 'Samakhusi', 'Admin',  DATE(NOW())) AS tmp
WHERE NOT EXISTS (
    SELECT username FROM user WHERE username = 'Krishna'
) LIMIT 1;


