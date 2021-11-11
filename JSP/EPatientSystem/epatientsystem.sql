-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 11, 2021 at 09:20 AM
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
-- Database: `epatientsystem`
--

-- --------------------------------------------------------

--
-- Table structure for table `appointments`
--

CREATE TABLE `appointments` (
  `id` int(11) NOT NULL,
  `patient_id` int(11) NOT NULL,
  `doctor_id` int(11) NOT NULL,
  `appointment_details` text NOT NULL,
  `date` datetime NOT NULL,
  `status` int(11) NOT NULL DEFAULT 0,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `plan`
--

CREATE TABLE `plan` (
  `id` int(11) NOT NULL,
  `doctor_id` int(11) NOT NULL,
  `avaiabledate` date NOT NULL,
  `fromtime` time NOT NULL,
  `totime` time NOT NULL,
  `apointments_count` int(11) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `plan`
--

INSERT INTO `plan` (`id`, `doctor_id`, `avaiabledate`, `fromtime`, `totime`, `apointments_count`, `created_at`) VALUES
(1, 15, '2021-07-11', '12:26:00', '13:26:00', 3, '2021-07-11 18:26:14'),
(5, 15, '2021-07-12', '12:40:00', '18:40:00', 5, '2021-07-11 18:42:13');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `fullname` text NOT NULL,
  `username` text NOT NULL,
  `email` text NOT NULL,
  `phone` varchar(12) NOT NULL,
  `password` text NOT NULL,
  `profession` text DEFAULT NULL,
  `role` varchar(7) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `fullname`, `username`, `email`, `phone`, `password`, `profession`, `role`, `created_at`) VALUES
(1, 'Admin', 'eadminpatient', 'eadminpatient@epatient.com', '27100003352', 'eadminlogin', NULL, 'admin', '2021-07-06 04:54:02'),
(2, 'Osama Ahmed', 'osamaahmed886', 'osamahu96@gmail.com', '03364179686', 'saphire', NULL, 'patient', '2021-07-06 04:54:08'),
(3, 'Ali Raza', 'aliraza88', 'chettyrobo123@gmail.com', '22100003351', 'saphire', NULL, 'patient', '2021-07-06 04:54:16'),
(5, 'Haris Sohail', 'haris776', 'haris_sohail85@gmail.com', '21100003351', 'saphire54321', NULL, 'patient', '2021-07-06 04:54:11'),
(8, 'Tony Stark', 'tonystark88', 'tonystark88@gmail.com', '20100003359', 'saphire123', NULL, 'patient', '2021-07-06 04:54:20'),
(11, 'Ibrahim', 'ibrahimahmed77', 'ibrahimahmed77@gmail.com', '23100003354', 'saphire54321', NULL, 'patient', '2021-07-06 04:53:26'),
(13, 'Nick Jonas', 'nickjonas12', 'nickjonas12@gmail.com', '23100003359', 'saphirenick123', NULL, 'patient', '2021-07-06 05:01:28'),
(15, 'Natasha Romanoff', 'natasharomanoff84', 'natasharomanoff84@gmail.com', '23100003300', 'saphirenatasha', 'Pathologist', 'doctor', '2021-07-07 17:57:21');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `appointments`
--
ALTER TABLE `appointments`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `plan`
--
ALTER TABLE `plan`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `appointments`
--
ALTER TABLE `appointments`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `plan`
--
ALTER TABLE `plan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
