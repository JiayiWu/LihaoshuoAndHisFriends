CREATE TABLE `user` (
  `id` INT unsigned NOT NULL AUTO_INCREMENT,
  `username` VARCHAR (255)  NOT NULL ,
  `nickname` VARCHAR (255)  ,
  `telephone` VARCHAR (255)  ,
  `password` VARCHAR (255)  NOT NULL,
  `type` INT ,
  PRIMARY KEY (`id`)
)

CREATE TABLE `room` (
  `id` INT unsigned NOT NULL AUTO_INCREMENT,
  `cinemaId` INT NOT NULL ,
  `name` VARCHAR (255)  NOT NULL ,
  `sits` TEXT  NOT NULL ,
  `status` INT DEFAULT 0,
  `modelNum` INT ,
  PRIMARY KEY (`id`)
)

CREATE TABLE `orders` (
  `id` INT unsigned NOT NULL AUTO_INCREMENT,
  `ticketNum` VARCHAR (255)  NOT NULL,
  `gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `gmt_modify` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `userid` INT NOT NULL ,
  `cinemaId` INT NOT NULL ,
  `movieId` INT NOT NULL ,
  `roomId` INT NOT NULL ,
  `status` INT DEFAULT 0,
  PRIMARY KEY (`id`)
)

CREATE TABLE `movie` (
  `id` INT unsigned NOT NULL AUTO_INCREMENT,
  `name` VARCHAR (255)  NOT NULL,
  `logoUrl` TEXT  NOT NULL,
  `description` TEXT  NOT NULL,
  `type` VARCHAR(255)  NOT NULL,
  `timeOfMovie` INT NOT NULL ,
  `status` INT DEFAULT 0,
  PRIMARY KEY (`id`)
)

CREATE TABLE `arranging` (
   `id` INT unsigned NOT NULL AUTO_INCREMENT,
   `cinemaId` INT NOT NULL ,
  `movieId` INT NOT NULL ,
  `roomId` INT NOT NULL ,
  `startTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `endTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `price` FLOAT DEFAULT 0,
  `status` INT DEFAULT 0,
  PRIMARY KEY (`id`)
)