DROP DATABASE `reactmovieplanetdatabase`;
CREATE DATABASE  IF NOT EXISTS `reactmovieplanetdatabase`;
USE `reactmovieplanetdatabase`;

-- 创建用户表
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
    `user_id` INT AUTO_INCREMENT,
    `user_email` VARCHAR(255) NOT NULL UNIQUE,
    `user_name` VARCHAR(255) NOT NULL,
    `password` VARCHAR(255) NOT NULL,
    `role` VARCHAR(20),
    PRIMARY KEY (`user_id`),
    UNIQUE INDEX (`user_email`)  -- 为 user_email 创建唯一索引
);

-- 创建电影表
DROP TABLE IF EXISTS `movies`;
CREATE TABLE `movies` (
    `movie_id` INT AUTO_INCREMENT,
    `title` VARCHAR(255) NOT NULL,
    `description` TEXT,
    `release_date` DATE,
    `cover_image` VARCHAR(255),
    `type` VARCHAR(255),
    `region` VARCHAR(255),
    `creators` TEXT,
    `vip` INT,
    `price` DOUBLE,
    `stars` DOUBLE,
    `week_ranking` INT,
    `month_ranking` INT,
    `total_ranking` INT,
    `reviews_ranking` INT,
    PRIMARY KEY (`movie_id`)
);

-- 评论表，存储用户对电影的评论
DROP TABLE IF EXISTS `movie_review`;
CREATE TABLE `movie_review` (
    `review_id` INT NOT NULL AUTO_INCREMENT,
    `user_id` INT,
    `movie_id` INT,
    `user_email` VARCHAR(255),
    `user_name` VARCHAR(255),
    `date` DATETIME DEFAULT NULL,
    `rating` DOUBLE DEFAULT NULL,
    `review_description` TEXT DEFAULT NULL,
    PRIMARY KEY (`review_id`),
    FOREIGN KEY (`user_id`) REFERENCES `users`(`user_id`),
    FOREIGN KEY (`movie_id`) REFERENCES `movies`(`movie_id`)
);


-- 创建用户收藏表
DROP TABLE IF EXISTS `user_favorites`;
CREATE TABLE `user_favorites` (
    `favorite_id` INT AUTO_INCREMENT,
    `user_id` INT,
    `movie_id` INT,
    PRIMARY KEY (`favorite_id`),
    FOREIGN KEY (`user_id`) REFERENCES `users`(`user_id`),
    FOREIGN KEY (`movie_id`) REFERENCES `movies`(`movie_id`)
);

DROP TABLE IF EXISTS `watch_history`;
-- 电影观看记录表，存储用户观看电影的记录和进度
CREATE TABLE `watch_history` (
  `history_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `user_email` VARCHAR(255) NOT NULL,
  `movie_id` INT,
  `watch_date` DATETIME DEFAULT NULL,
  `title` VARCHAR(255) NOT NULL,
    `description` TEXT,
    `release_date` DATE,
    `cover_image` VARCHAR(255),
    `type` VARCHAR(255),
    `region` VARCHAR(255),
    `creators` TEXT,
    `stars` DOUBLE,
  PRIMARY KEY (`history_id`),
  FOREIGN KEY (`user_email`) REFERENCES `users`(`user_email`),
  FOREIGN KEY (`movie_id`) REFERENCES `movies`(`movie_id`)
);

DROP TABLE IF EXISTS `cart`;
-- 购物车表，记录用户的购物车信息
CREATE TABLE `cart` (
  `cart_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `user_id` INT,
  `movie_id` INT,
  `quantity` INT(11) DEFAULT NULL,
  PRIMARY KEY (`cart_id`),
  FOREIGN KEY (`user_id`) REFERENCES `users`(`user_id`),
  FOREIGN KEY (`movie_id`) REFERENCES `movies`(`movie_id`)

);

DROP TABLE IF EXISTS `checkout`;
-- 购买记录表，记录用户的购买历史
CREATE TABLE `checkout` (
  `checkout_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `user_id` INT,
  `movie_id` INT,
  `user_email` VARCHAR(255),
  `checkout_date` DATETIME DEFAULT NULL,
  PRIMARY KEY (`checkout_id`),
  FOREIGN KEY (`user_id`) REFERENCES `users`(`user_id`),
  FOREIGN KEY (`movie_id`) REFERENCES `movies`(`movie_id`)
  
);

DROP TABLE IF EXISTS `messages`;
CREATE TABLE `messages` (
  `messages_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `user_email` VARCHAR(45) DEFAULT NULL,
  `title` VARCHAR(45) DEFAULT NULL,
  `question` TEXT DEFAULT NULL,
  `admin_email` VARCHAR(45) DEFAULT NULL,
  `response` TEXT DEFAULT NULL,
  `closed` TINYINT(1) DEFAULT 0,
  PRIMARY KEY (`messages_id`)
) 

