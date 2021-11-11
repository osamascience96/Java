-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 11, 2021 at 09:25 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `otpproject`
--

-- --------------------------------------------------------

--
-- Table structure for table `registrations`
--

CREATE TABLE `registrations` (
  `RegistrationId` int(10) UNSIGNED NOT NULL,
  `AssesseId` int(10) UNSIGNED NOT NULL,
  `EmailId` varchar(40) DEFAULT NULL,
  `BillNo` varchar(20) DEFAULT NULL,
  `RegisterdDateTime` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `Remarks` varchar(255) DEFAULT NULL,
  `mobileno1` varchar(45) DEFAULT NULL,
  `mobileno2` varchar(45) DEFAULT NULL,
  `otp` int(10) UNSIGNED NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `registrations`
--

INSERT INTO `registrations` (`RegistrationId`, `AssesseId`, `EmailId`, `BillNo`, `RegisterdDateTime`, `Remarks`, `mobileno1`, `mobileno2`, `otp`) VALUES
(3, 79007, 'sanji@gmail.com', NULL, '2018-09-11 12:17:52', NULL, NULL, NULL, 1234),
(23354, 12345, 'osamahu96@gmail.com', NULL, '2021-06-17 12:52:05', NULL, '3364179686', '336148976', 1234),
(23355, 12345, 'ali_raza88@gmailcom', NULL, '2021-06-17 12:59:01', NULL, '3364179686', '3365768483', 1234);

-- --------------------------------------------------------

--
-- Table structure for table `user_login_accounts`
--

CREATE TABLE `user_login_accounts` (
  `LoginId` int(10) UNSIGNED NOT NULL,
  `UserId` varchar(15) NOT NULL,
  `Password` varchar(15) NOT NULL,
  `RoleId` int(10) UNSIGNED NOT NULL,
  `RegistrationOrUserId` varchar(20) DEFAULT NULL,
  `AccessibilityStatus` varchar(45) NOT NULL DEFAULT 'N',
  `CreatedBy` varchar(45) DEFAULT NULL,
  `CreatedDateTime` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `EnabledBy` varchar(15) DEFAULT NULL,
  `EnabledDateTime` datetime DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_login_accounts`
--

INSERT INTO `user_login_accounts` (`LoginId`, `UserId`, `Password`, `RoleId`, `RegistrationOrUserId`, `AccessibilityStatus`, `CreatedBy`, `CreatedDateTime`, `EnabledBy`, `EnabledDateTime`) VALUES
(23559, '239329', '>¼6>3Áð', 3, '23346', 'N', 'SELF', '2018-01-03 11:17:11', NULL, NULL),
(23566, '23354', 'saphire54321', 3, '23354', 'Y', 'SELF', '2021-06-17 12:57:42', NULL, NULL),
(23567, '23355', '', 3, '23355', 'Y', 'SELF', '2021-06-17 12:59:20', NULL, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `registrations`
--
ALTER TABLE `registrations`
  ADD PRIMARY KEY (`RegistrationId`) USING BTREE,
  ADD KEY `FK_registrations_1` (`AssesseId`);

--
-- Indexes for table `user_login_accounts`
--
ALTER TABLE `user_login_accounts`
  ADD PRIMARY KEY (`LoginId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `registrations`
--
ALTER TABLE `registrations`
  MODIFY `RegistrationId` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23356;

--
-- AUTO_INCREMENT for table `user_login_accounts`
--
ALTER TABLE `user_login_accounts`
  MODIFY `LoginId` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23568;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
