-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 08, 2021 at 06:35 PM
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
-- Database: `javashop`
--

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `id` int(11) NOT NULL,
  `product_Id` int(11) NOT NULL,
  `session_id` text NOT NULL,
  `customer_name` text NOT NULL,
  `phone_number` text NOT NULL,
  `address` text NOT NULL,
  `total_price` double NOT NULL,
  `quantity` int(11) NOT NULL,
  `notes` text DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`id`, `product_Id`, `session_id`, `customer_name`, `phone_number`, `address`, `total_price`, `quantity`, `notes`, `created_at`) VALUES
(6, 1, 'E05B1F12F7C9FB7F3A658985125D64EC', 'Osama Ahmed', '0336478675', 'House No.43, Street No.109, Farooq Street, Krishan Nagar, Lahore, Pakistan', 20, 1, NULL, '2021-04-08 16:25:53'),
(7, 2, 'E05B1F12F7C9FB7F3A658985125D64EC', 'Osama Ahmed', '0336478675', 'House No.43, Street No.109, Farooq Street, Krishan Nagar, Lahore, Pakistan', 30, 1, 'Add Cream\nPlease avoid sugar\n', '2021-04-08 16:25:53'),
(8, 1, 'E05B1F12F7C9FB7F3A658985125D64EC', 'Osama Ahmed', '0336478675', 'House No.43, Street No.109, Farooq Street, Krishan Nagar, Lahore, Pakistan', 20, 1, NULL, '2021-04-08 16:26:38'),
(9, 1, 'E05B1F12F7C9FB7F3A658985125D64EC', 'Osama Ahmed', '0336478675', 'House No.43, Street No.109, Farooq Street, Krishan Nagar, Lahore, Pakistan', 20, 1, NULL, '2021-04-08 16:28:26'),
(10, 2, 'ADE855722E9F4BB78267DEF374F4FACA', 'Osama Ahmed', '03364179686', 'osamahu96@gmail.com', 30, 1, 'Add Cream\n', '2021-04-08 16:33:11'),
(11, 7, 'ADE855722E9F4BB78267DEF374F4FACA', 'Osama Ahmed', '03364179686', 'osamahu96@gmail.com', 102, 2, 'No Cream\nPlease add a little extra sugar\n', '2021-04-08 16:33:11');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `id` int(11) NOT NULL,
  `typename` text NOT NULL,
  `price` double NOT NULL,
  `image` text NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`id`, `typename`, `price`, `image`, `created_at`) VALUES
(1, 'Light Coffee', 20, 'coffee1.jpg', '2021-04-08 05:06:01'),
(2, 'Medium Cofee', 30, 'coffee2.jpg', '2021-04-08 05:06:24'),
(3, 'Dark Coffee', 35, 'coffee3.jpg', '2021-04-08 05:06:54'),
(4, 'Extra Dark Coffee', 38, 'coffee4.jpg', '2021-04-08 05:07:23'),
(5, 'Romantic Coffee', 58, 'couplecoffee.jpg', '2021-04-08 05:07:47'),
(6, 'Dark Lattee', 48, 'darklattecoffee.jpg', '2021-04-08 05:48:28'),
(7, 'Emoji Coffee', 51, 'emojicoffee.jpg', '2021-04-08 05:09:13'),
(8, 'Haloween Coffee', 31, 'haloweencoffee.jpg', '2021-04-08 05:10:01'),
(9, 'Harry Potter Coffee', 41, 'harrypottercoffee.jpg', '2021-04-08 05:10:29'),
(10, 'Late', 50, 'lattecoffee1.jpg', '2021-04-08 05:49:15');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
