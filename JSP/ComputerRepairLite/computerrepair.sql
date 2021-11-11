-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 11, 2021 at 09:16 AM
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
-- Database: `computerrepair`
--

-- --------------------------------------------------------

--
-- Table structure for table `feedback`
--

CREATE TABLE `feedback` (
  `id` int(11) NOT NULL,
  `name` text NOT NULL,
  `country` text NOT NULL,
  `phone` text NOT NULL,
  `email` text NOT NULL,
  `subject` text NOT NULL,
  `type` text NOT NULL,
  `Message` text NOT NULL,
  `creation_datetime` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `feedback`
--

INSERT INTO `feedback` (`id`, `name`, `country`, `phone`, `email`, `subject`, `type`, `Message`, `creation_datetime`) VALUES
(1, 'Osama Ahmed', 'Pakistan', '923364179686', 'osamahu96@gmail.com', 'PC New Session Error', 'laptop', 'I have taken the device last night, but its giving me the error of session expired. Can you kindly solve this issue. Thank You.', '2021-03-30 09:29:29'),
(2, 'Muhammad Riaz', 'Pakistan', '923365787654', 'muhammad_riaz@gmail.com', 'Laptop Repair and General Services.', 'laptop', 'What is the procedure of general service of my laptop? Urgent Reply.', '2021-03-30 12:39:17'),
(3, 'Osama Ahmed', 'Pakistan', '03364179686', 'osamahu96@gmail.com', 'Not Wokring', 'Desktop', 'Please make it work', '2021-04-09 07:14:59'),
(4, 'Ali Raza', 'Pakistan', '0336478675', 'ali_raza88@gmail.com', 'Windows Crashed', 'Laptop', 'My windows is not getting boot after 2 attempts to direct power restart.', '2021-04-09 07:18:07'),
(5, 'Osama Ahmed', 'Pakistan', '03364179686', 'osamahu96@gmail.com', 'Memory Card', 'Desktop', 'The memory card you fixed was the best work.', '2021-04-14 07:45:52'),
(6, 'Amjad Mului', 'Saudi Arabia', '03364578643', 'amjad1122@gmail.com', 'Laptop Screen', 'Laptop', 'The Laptop Screen you fixed was awsome.', '2021-04-14 07:52:21');

-- --------------------------------------------------------

--
-- Table structure for table `request`
--

CREATE TABLE `request` (
  `id` int(11) NOT NULL,
  `computer_owner` text NOT NULL,
  `computer_serial_number` text NOT NULL,
  `type` text NOT NULL,
  `model` text NOT NULL,
  `memory_gb` int(11) NOT NULL,
  `harddisk_gb` int(11) NOT NULL,
  `problems` text NOT NULL,
  `repair_cost` double NOT NULL DEFAULT 100,
  `repair_status` text NOT NULL DEFAULT 'Progress',
  `repair_finish_datetime` text DEFAULT 'N/A',
  `repair_delievery_datetime` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `request`
--

INSERT INTO `request` (`id`, `computer_owner`, `computer_serial_number`, `type`, `model`, `memory_gb`, `harddisk_gb`, `problems`, `repair_cost`, `repair_status`, `repair_finish_datetime`, `repair_delievery_datetime`) VALUES
(2, 'Osama Ahmed', '734388-97423874823-234234234', 'laptop', 'HP', 8, 256, 'Its not working.', 100, 'Progress', 'N/A', '2021-03-30 13:40:48'),
(4, 'Samray Zahra', '234234-63453453-34534534', 'tablet', 'Dell', 8, 256, 'I can\'t watch Osama on my Screen.', 100, 'Progress', 'N/A', '2021-03-30 17:35:00'),
(5, 'Muhammad Azam', '56675-4645534-234234', 'laptop', 'Acer', 4, 120, 'The ASIC devices, either external and internal are both not responding, in short my motherboard is destroyed.', 100, 'Progress', 'N/A', '2021-03-30 17:35:53'),
(6, 'Osama Ahmed', '423842387423784823', 'Desktop', 'HP', 8, 256, 'Its not working', 100, 'Progress', 'N/A', '2021-04-09 12:13:58'),
(7, 'Muhammad Ahmed', '423498239429349234', 'Hybrid', 'Dell', 10, 1000, 'The screen is blank not working at all.', 100, 'Progress', 'N/A', '2021-04-09 12:15:59'),
(8, 'Osama Ahmed', '54545345897345353543', 'Desktop', 'HP', 8, 256, 'Its not working', 100, 'Progress', 'N/A', '2021-04-14 12:43:57'),
(9, 'Amjad Mului', '5748754837583478534', 'Laptop', 'Dell', 8, 256, 'The Screen is not working', 100, 'Progress', 'N/A', '2021-04-14 12:51:11');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `fullname` text NOT NULL,
  `username` text NOT NULL,
  `email` text NOT NULL,
  `password` text NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `fullname`, `username`, `email`, `password`, `created_at`) VALUES
(1, 'Osama Ahmed', 'osamahu96', 'osamahu96@gmail.com', 'saphire54321', '2021-04-14 04:38:19'),
(2, 'Amjad Mului', 'amjad1122', 'amjad1122@gmail.com', 'saphire54321', '2021-04-14 07:49:57');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `feedback`
--
ALTER TABLE `feedback`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `request`
--
ALTER TABLE `request`
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
-- AUTO_INCREMENT for table `feedback`
--
ALTER TABLE `feedback`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `request`
--
ALTER TABLE `request`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
