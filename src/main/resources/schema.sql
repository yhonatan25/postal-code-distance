-- --------------------------------------------------------

--
-- Table structure for table `postal_locations`
--

CREATE TABLE IF NOT EXISTS `postal_locations` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `postal_code` varchar(8) NOT NULL,
  `latitude` decimal(18,15) NOT NULL,
  `longitude` decimal(18,15) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE (`postal_code`)
) AUTO_INCREMENT=1;
