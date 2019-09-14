drop database if exists prod_demo ;
create database prod_demo;
use prod_demo;


-- ---
-- Globals
-- ---

-- SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
-- SET FOREIGN_KEY_CHECKS=0;

-- ---
-- Table 'users'
-- ---

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
`id` INT NOT NULL AUTO_INCREMENT,
`uname` VARCHAR(255) NOT NULL,
`pass` VARCHAR(255) NOT NULL,
`employee_id` INT NOT NULL,
PRIMARY KEY (`id`)
);

-- ---
-- Table 'employees'
-- 
-- ---

DROP TABLE IF EXISTS `employees`;

CREATE TABLE `employees` (
`id` INTEGER NOT NULL AUTO_INCREMENT,
`fname` VARCHAR(255) NOT NULL,
`lname` VARCHAR(255) NOT NULL,
`role_id` INTEGER NULL DEFAULT NULL,
PRIMARY KEY (`id`)
);

-- ---
-- Table 'projects'
-- 
-- ---

DROP TABLE IF EXISTS `projects`;

CREATE TABLE `projects` (
`id` INTEGER NOT NULL AUTO_INCREMENT,
`pname` VARCHAR(255) NULL DEFAULT NULL,
PRIMARY KEY (`id`)
);

-- ---
-- Table 'employees_projects'
-- 
-- ---

DROP TABLE IF EXISTS `employees_projects`;

CREATE TABLE `employees_projects` (
`id` INTEGER NOT NULL AUTO_INCREMENT,
`tl_id` INTEGER NOT NULL,
`employee_id` INTEGER NOT NULL,
`project_id` INTEGER NOT NULL,
`date` DATE NOT NULL,
`prod_hours` FLOAT NOT NULL,
PRIMARY KEY (`id`)
);

-- ---
-- Table 'roles'
-- 
-- ---

DROP TABLE IF EXISTS `roles`;

CREATE TABLE `roles` (
`id` INTEGER NOT NULL AUTO_INCREMENT,
`name` VARCHAR(255) NOT NULL,
PRIMARY KEY (`id`)
);





-- ---
-- Foreign Keys 
-- ---

ALTER TABLE `employees` ADD FOREIGN KEY (role_id) REFERENCES `roles` (`id`);
ALTER TABLE `employees_projects` ADD FOREIGN KEY (tl_id) REFERENCES `employees` (`id`);
ALTER TABLE `employees_projects` ADD FOREIGN KEY (employee_id) REFERENCES `employees` (`id`);
ALTER TABLE `employees_projects` ADD FOREIGN KEY (project_id) REFERENCES `projects` (`id`);
ALTER TABLE `users` ADD FOREIGN KEY (employee_id) REFERENCES `employees` (`id`);


-- ---
-- Table Properties
-- ---

-- ALTER TABLE `employees` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `projects` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `employees_projects` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `roles` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ---
-- Test Data
-- ---

-- INSERT INTO `employees` (`id`,`uname`,`pass`,`role_id`) VALUES
-- ('','','','');
-- INSERT INTO `projects` (`id`,`pname`) VALUES
-- ('','');
-- INSERT INTO `employees_projects` (`id`,`employee_id`,`project_id`,`date`,`prod_hours`) VALUES
-- ('','','','','');
-- INSERT INTO `roles` (`id`,`name`) VALUES
-- ('','');