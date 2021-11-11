-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 11, 2021 at 09:11 AM
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
-- Database: `ats`
--

-- --------------------------------------------------------

--
-- Table structure for table `client`
--

CREATE TABLE `client` (
  `id` int(11) NOT NULL,
  `name` text NOT NULL,
  `address` text NOT NULL,
  `email` text NOT NULL,
  `phone` text NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `client`
--

INSERT INTO `client` (`id`, `name`, `address`, `email`, `phone`, `created_at`, `updated_at`) VALUES
(3, 'Osama Ahmad', 'House No.43, Street No.102, Farooq Street, Krishan Nagar, Lahore, Pakistan', 'osamahu96@gmail.com', '03364179687', '2021-03-18 22:45:27', '2021-04-06 11:24:36'),
(8, 'Ali Raza', 'House No.43, Street No.109, Farooq Street, Krishan Nagar, Lahore, Pakistan', 'chettyrobo123@gmail.com', '18864320091', '2021-04-02 15:54:55', '2021-04-07 15:57:08'),
(12, 'Jay Kishan', 'House No.43, Street No.109, Farooq Street, Krishan Nagar, Lahore, Pakistan', 'jay_kishan887@gmail.com', '12345678901', '2021-04-06 22:32:52', '2021-04-07 15:52:11'),
(15, 'Haris Sohail', 'House No.43 Street No.109 Farooq Street Krishan Nagar Lahore, Punjab, Pakistan', 'haris_sohail85@gmail.com', '12223334567', '2021-04-07 20:46:59', '2021-04-07 15:48:19');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `id` int(11) NOT NULL,
  `team_id` int(11) NOT NULL DEFAULT 0,
  `first_name` text NOT NULL,
  `last_name` text NOT NULL,
  `sin` text NOT NULL,
  `hourly_pay_rate` text NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`id`, `team_id`, `first_name`, `last_name`, `sin`, `hourly_pay_rate`, `created_at`) VALUES
(12, 6, 'Haris', 'Sohail', '134-555-678', '60', '2021-04-03 05:21:44'),
(13, 6, 'Hrithik', 'Roshan', '213-555-009', '65', '2021-04-03 05:21:54'),
(14, 0, 'Ali', 'Raza', '111-000-223', '11.20', '2021-04-05 08:19:08'),
(15, 0, 'Osman', 'Ahmed', '312-45-09', '99.81', '2021-04-05 08:05:39'),
(16, 15, 'Shah Rukh', 'Khan', '221-456-987', '43.12', '2021-04-06 17:42:11'),
(26, 15, 'Jay', 'Kishan', '987-768-234', '100', '2021-04-06 17:42:11');

-- --------------------------------------------------------

--
-- Table structure for table `employeetasks`
--

CREATE TABLE `employeetasks` (
  `id` int(11) NOT NULL,
  `employee_id` int(11) NOT NULL,
  `task_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `employeetasks`
--

INSERT INTO `employeetasks` (`id`, `employee_id`, `task_id`) VALUES
(12, 10, 8),
(16, 10, 12),
(18, 12, 8),
(20, 13, 12);

-- --------------------------------------------------------

--
-- Table structure for table `jobcomments`
--

CREATE TABLE `jobcomments` (
  `id` int(11) NOT NULL,
  `job_id` int(11) NOT NULL,
  `comment` text NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `updated_at` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `jobcomments`
--

INSERT INTO `jobcomments` (`id`, `job_id`, `comment`, `created_at`, `updated_at`) VALUES
(2, 6, 'This job is very important', '2021-04-03 05:02:47', NULL),
(6, 10, 'this is a important job', '2021-04-03 05:34:16', NULL),
(8, 11, 'This is the router configuration task, do it well.', '2021-04-03 18:01:13', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `jobs`
--

CREATE TABLE `jobs` (
  `id` int(11) NOT NULL,
  `team_id` int(11) NOT NULL,
  `client_id` int(11) NOT NULL,
  `description` text NOT NULL,
  `start` datetime NOT NULL,
  `end` datetime NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `jobs`
--

INSERT INTO `jobs` (`id`, `team_id`, `client_id`, `description`, `start`, `end`, `created_at`) VALUES
(10, 6, 3, 'This is a job', '2021-04-12 17:00:00', '2021-04-12 18:34:00', '2021-04-03 05:34:16'),
(11, 6, 3, 'This is a job', '2021-04-12 17:00:00', '2021-04-12 18:34:00', '2021-04-03 05:35:30'),
(21, 15, 8, 'This is the most important job', '2021-04-07 20:55:00', '2021-04-07 21:59:00', '2021-04-07 15:56:28');

-- --------------------------------------------------------

--
-- Table structure for table `jobtasks`
--

CREATE TABLE `jobtasks` (
  `task_id` int(11) NOT NULL,
  `job_id` int(11) NOT NULL,
  `operating_cost` double NOT NULL,
  `operating_revenue` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `jobtasks`
--

INSERT INTO `jobtasks` (`task_id`, `job_id`, `operating_cost`, `operating_revenue`) VALUES
(8, 10, 93.75, 375),
(10, 10, 93.75, 375),
(8, 11, 93.75, 375),
(10, 11, 93.75, 375),
(10, 21, 71.56, 286.24);

-- --------------------------------------------------------

--
-- Table structure for table `tasks`
--

CREATE TABLE `tasks` (
  `id` int(11) NOT NULL,
  `name` text NOT NULL,
  `description` text NOT NULL,
  `duration` int(11) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tasks`
--

INSERT INTO `tasks` (`id`, `name`, `description`, `duration`, `created_at`, `updated_at`) VALUES
(8, 'Router Programming', 'Router Programming includes the configuration and fixing the bugs or refresh the router to function again in reboot mode to clear all the data queued in the ASIC of router.', 45, '2021-03-21 23:40:36', '2021-04-03 05:20:46'),
(10, 'Cable Repair', 'Checking if the cable connected to the network is the supported type or if any technical damage has happened to the wire to the network.', 30, '2021-03-22 00:15:49', '2021-04-04 13:06:22'),
(12, 'Retro Embedded ', 'Retro Embedded is the task that generally is the specified skill to check of the retro tech that is working in the network or handling the network topology in somewhat interesting way.', 60, '2021-04-04 18:06:22', '2021-04-05 07:22:00');

-- --------------------------------------------------------

--
-- Table structure for table `team`
--

CREATE TABLE `team` (
  `id` int(11) NOT NULL,
  `name` text NOT NULL,
  `is_on_call` tinyint(1) NOT NULL DEFAULT 0,
  `team_members` int(11) NOT NULL DEFAULT 2,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `team`
--

INSERT INTO `team` (`id`, `name`, `is_on_call`, `team_members`, `created_at`) VALUES
(6, 'Router Configuration', 0, 7, '2021-04-07 15:28:40'),
(15, 'Lightning Team', 1, 2, '2021-04-07 15:56:28');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `employeetasks`
--
ALTER TABLE `employeetasks`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `jobcomments`
--
ALTER TABLE `jobcomments`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `jobs`
--
ALTER TABLE `jobs`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tasks`
--
ALTER TABLE `tasks`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `team`
--
ALTER TABLE `team`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `client`
--
ALTER TABLE `client`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT for table `employeetasks`
--
ALTER TABLE `employeetasks`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `jobcomments`
--
ALTER TABLE `jobcomments`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `jobs`
--
ALTER TABLE `jobs`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `tasks`
--
ALTER TABLE `tasks`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `team`
--
ALTER TABLE `team`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
