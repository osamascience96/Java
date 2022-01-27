-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 27, 2022 at 03:04 PM
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
-- Database: `therapion`
--

-- --------------------------------------------------------

--
-- Table structure for table `appointment`
--

CREATE TABLE `appointment` (
  `id` int(11) NOT NULL,
  `p_id` int(11) NOT NULL,
  `t_id` int(11) NOT NULL,
  `status` text NOT NULL,
  `is_active` tinyint(1) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `faq`
--

CREATE TABLE `faq` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `first_name` text NOT NULL,
  `last_name` text DEFAULT NULL,
  `email` text NOT NULL,
  `message` text NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `faq`
--

INSERT INTO `faq` (`id`, `user_id`, `first_name`, `last_name`, `email`, `message`, `created_at`) VALUES
(1, 5, 'Osama', 'Ahmed', 'osamahu96@gmail.com', 'How this system works?', '2022-01-27 07:57:56'),
(2, 0, 'Ali ', 'Raza', 'aliraza88@gmail.com', 'This is Ali Raza, how can i register to your website?', '2022-01-27 07:59:35');

-- --------------------------------------------------------

--
-- Table structure for table `gender`
--

CREATE TABLE `gender` (
  `id` int(11) NOT NULL,
  `name` text NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `gender`
--

INSERT INTO `gender` (`id`, `name`, `created_at`) VALUES
(1, 'Male', '2022-01-20 13:41:33'),
(2, 'Female', '2022-01-20 13:41:33'),
(3, 'Transgender', '2022-01-20 13:42:04'),
(4, 'Other', '2022-01-26 17:47:18');

-- --------------------------------------------------------

--
-- Table structure for table `identity`
--

CREATE TABLE `identity` (
  `id` int(11) NOT NULL,
  `name` text NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `identity`
--

INSERT INTO `identity` (`id`, `name`, `created_at`) VALUES
(1, 'Straight', '2022-01-20 13:42:51'),
(2, 'Gay', '2022-01-20 13:42:51'),
(3, 'Lesbian', '2022-01-20 13:43:15'),
(4, 'Prefer Not to Say', '2022-01-20 13:43:15'),
(5, 'Other', '2022-01-26 17:47:12');

-- --------------------------------------------------------

--
-- Table structure for table `questionaire`
--

CREATE TABLE `questionaire` (
  `id` int(11) NOT NULL,
  `patient_id` int(11) NOT NULL,
  `gender_id` int(11) NOT NULL,
  `age` int(11) NOT NULL,
  `identity_id` int(11) NOT NULL,
  `source` text NOT NULL,
  `country` text NOT NULL,
  `language` text NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `questionaire`
--

INSERT INTO `questionaire` (`id`, `patient_id`, `gender_id`, `age`, `identity_id`, `source`, `country`, `language`, `created_at`) VALUES
(1, 5, 1, 26, 1, 'Mostly via messaging', 'Pakistan', 'Urdu', '2022-01-27 07:09:51');

-- --------------------------------------------------------

--
-- Table structure for table `religion`
--

CREATE TABLE `religion` (
  `id` int(11) NOT NULL,
  `name` text NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `religion`
--

INSERT INTO `religion` (`id`, `name`, `created_at`) VALUES
(1, 'Islam', '2022-01-20 13:39:21'),
(2, 'Christianity', '2022-01-20 13:39:21'),
(3, 'Judaism', '2022-01-20 13:39:33'),
(4, 'Hinduism', '2022-01-20 13:39:33'),
(5, 'Buddism', '2022-01-20 13:40:06'),
(6, 'Other', '2022-01-26 17:47:03');

-- --------------------------------------------------------

--
-- Table structure for table `therapist`
--

CREATE TABLE `therapist` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `religion_id` int(11) NOT NULL,
  `background` text NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `therapist`
--

INSERT INTO `therapist` (`id`, `user_id`, `religion_id`, `background`, `created_at`) VALUES
(1, 6, 2, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Orci, diam a tincidunt tortor donec pharetra, aliquam eget. Faucibus ornare lectus libero, ac eget erat id. Tempus, vitae in elementum sagittis, nec, facilisis arcu.', '2022-01-27 09:02:52');

-- --------------------------------------------------------

--
-- Table structure for table `timeslots`
--

CREATE TABLE `timeslots` (
  `id` int(11) NOT NULL,
  `t_id` int(11) NOT NULL,
  `time` datetime NOT NULL,
  `date` date NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `type`
--

CREATE TABLE `type` (
  `id` int(11) NOT NULL,
  `user_type` text NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `type`
--

INSERT INTO `type` (`id`, `user_type`, `created_at`) VALUES
(1, 'admin', '2022-01-20 13:30:59'),
(2, 'patient', '2022-01-20 13:30:59'),
(3, 'therapist', '2022-01-20 13:32:02');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `name` text NOT NULL,
  `type_id` int(11) NOT NULL,
  `image_addr` text DEFAULT NULL,
  `gender_id` int(11) NOT NULL,
  `dob` date NOT NULL,
  `address` text NOT NULL,
  `email` text NOT NULL,
  `password` text NOT NULL,
  `phone` text NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `name`, `type_id`, `image_addr`, `gender_id`, `dob`, `address`, `email`, `password`, `phone`, `created_at`) VALUES
(5, 'osamaahmed886', 2, NULL, 1, '1996-10-26', 'House No.43, Street No.102, Farooq Street, Krishan Nagar, Lahore, Pakistan', 'osamahu96@gmail.com', '8ecaa2f7db2fc4bf2cc944c5e01ab49ea841b21e60ccc56d5d3316680eb44a83', '03364172345', '2022-01-27 07:09:13'),
(6, 'Dr. Leslie Alexander', 3, 'f8c98fac-28e6-44d2-943d-a017a2cf2ab8.png', 2, '1986-10-26', 'House No.43, Street No.102, Washington Street, USA', 'lesliealexdar86@gmail.com', '8ecaa2f7db2fc4bf2cc944c5e01ab49ea841b21e60ccc56d5d3316680eb44a83', '03321252345', '2022-01-27 09:04:31');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `appointment`
--
ALTER TABLE `appointment`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `faq`
--
ALTER TABLE `faq`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `gender`
--
ALTER TABLE `gender`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `identity`
--
ALTER TABLE `identity`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `questionaire`
--
ALTER TABLE `questionaire`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `religion`
--
ALTER TABLE `religion`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `therapist`
--
ALTER TABLE `therapist`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `timeslots`
--
ALTER TABLE `timeslots`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `type`
--
ALTER TABLE `type`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `appointment`
--
ALTER TABLE `appointment`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `faq`
--
ALTER TABLE `faq`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `gender`
--
ALTER TABLE `gender`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `identity`
--
ALTER TABLE `identity`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `questionaire`
--
ALTER TABLE `questionaire`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `religion`
--
ALTER TABLE `religion`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `therapist`
--
ALTER TABLE `therapist`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `timeslots`
--
ALTER TABLE `timeslots`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `type`
--
ALTER TABLE `type`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
