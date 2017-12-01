CREATE TABLE IF NOT EXISTS `postal_locations` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `postal_code` varchar(8) NOT NULL,
  `latitude` decimal(18,15) NOT NULL,
  `longitude` decimal(18,15) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE (`postal_code`)
) AUTO_INCREMENT=1;

CREATE TABLE IF NOT EXISTS `distance_requests` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `initial_postal_code` varchar(8) NOT NULL,
  `final_postal_code` varchar(8) NOT NULL,
  `request_time` timestamp NOT NULL,
  `creation_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) AUTO_INCREMENT=1;
