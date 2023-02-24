create database imageUploader;
use imageUploader;
CREATE TABLE IF NOT EXISTS `image`(
                                      `image_id` INT UNSIGNED AUTO_INCREMENT,
                                      `image_label` VARCHAR(40) NOT NULL,
    `image_url` varchar(120) not null,
    PRIMARY KEY ( `image_id` )
    )ENGINE=InnoDB DEFAULT CHARSET=utf8;