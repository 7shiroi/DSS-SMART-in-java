-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 24, 2018 at 02:17 AM
-- Server version: 10.1.28-MariaDB
-- PHP Version: 7.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `smart`
--

-- --------------------------------------------------------

--
-- Table structure for table `alternatif`
--

CREATE TABLE `alternatif` (
  `id` int(11) NOT NULL,
  `NamaPegawai` varchar(255) NOT NULL,
  `LogikaBerpikir` varchar(11) NOT NULL,
  `Ketelitian` varchar(11) NOT NULL,
  `TanggungJawab` varchar(11) NOT NULL,
  `KerjaSama` varchar(11) NOT NULL,
  `Kehatihatian` varchar(11) NOT NULL,
  `IQ` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `alternatif`
--

INSERT INTO `alternatif` (`id`, `NamaPegawai`, `LogikaBerpikir`, `Ketelitian`, `TanggungJawab`, `KerjaSama`, `Kehatihatian`, `IQ`) VALUES
(1, 'Abdul', '80', '75', '98', '75', '70', '80'),
(2, 'Badu', '75', '85', '75', '79', '70', '76'),
(3, 'Cynthia', '95', '98', '98', '95', '95', '98'),
(4, 'Danang', '76', '80', '85', '70', '65', '76'),
(5, 'Edo', '65', '78', '98', '85', '70', '86'),
(7, 'Feli', '80', '90', '80', '75', '80', '90'),
(9, 'Gaga', '80', '90', '90', '80', '67', '80');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `alternatif`
--
ALTER TABLE `alternatif`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `alternatif`
--
ALTER TABLE `alternatif`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
