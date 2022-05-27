-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 22, 2022 at 09:52 AM
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
-- Database: `ecommerce_lipstick`
--

-- --------------------------------------------------------

--
-- Table structure for table `cart`
--

CREATE TABLE `cart` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `total_price` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`id`, `user_id`, `quantity`, `total_price`) VALUES
(1, 12, 5, 266),
(2, 19, 2, 100),
(3, 20, 2, 147);

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `id` int(11) NOT NULL,
  `name` text NOT NULL,
  `price` double NOT NULL,
  `description` text NOT NULL,
  `type` text NOT NULL,
  `color_type` text NOT NULL,
  `skin_type` text NOT NULL,
  `image_name` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`id`, `name`, `price`, `description`, `type`, `color_type`, `skin_type`, `image_name`) VALUES
(1, 'NACH FARBE FILTERN', 35, 'Du bist auf der Suche nach der Lippenstiftfarbe, die perfekt zu Dir passt?Du bist auf der Suche nach der Lippenstiftfarbe, die perfekt zu Dir passt?Du bist auf der Suche nach der Lippenstiftfarbe, die perfekt zu Dir passt?Du bist auf der Suche nach der Lippenstiftfarbe, die perfekt zu Dir passt?Du bist auf der Suche nach der Lippenstiftfarbe, die perfekt zu Dir passt?\r\n\r\n', 'matt', 'red', 'bright', '16145946131530993147.jpg'),
(3, 'Froasted', 34, 'Asorem ipsum adipolor sdit amet, consectetur adipisicing elitcf sed do eiusmod tem.Asorem ipsum adipolor sdit amet, consectetur adipisicing elitcf sed do eiusmod tem.Asorem ipsum adipolor sdit amet, consectetur adipisicing elitcf sed do eiusmod tem.Asorem ipsum adipolor sdit amet, consectetur adipisicing elitcf sed do eiusmod tem.Asorem ipsum adipolor sdit amet, consectetur adipisicing elitcf sed do eiusmod tem.\r\n\r\n', 'cream', 'red', 'bright', '16145968091592397303.jpg'),
(5, 'FROSTED', 80, ' adipolor sdit amet, consectetur adipisicing elitcf sed do eiusmod tem. adipolor sdit amet, consectetur adipisicing elitcf sed do eiusmod tem. adipolor sdit amet, consectetur adipisicing elitcf sed do eiusmod tem. adipolor sdit amet, consectetur adipisicing elitcf sed do eiusmod tem. adipolor sdit amet, consectetur adipisicing elitcf sed do eiusmod tem. adipolor sdit amet, consectetur adipisicing elitcf sed do eiusmod tem.\r\n\r\n', 'schimmer', 'red', 'bright', '1614594433337595115.jpg'),
(7, 'FROSTED', 60, ' perfekte Shade und TexturDer Lipstick Finder findet Deine perfekte Shade und Textur perfekte Shade und TexturDer Lipstick Finder findet Deine perfekte Shade und Textur perfekte Shade und TexturDer Lipstick Finder findet Deine perfekte Shade und Textur perfekte Shade und TexturDer Lipstick Finder findet Deine perfekte Shade und Textur perfekte Shade und TexturDer Lipstick Finder findet Deine perfekte Shade und Textur\r\n\r\n', 'matt', 'red', 'medium', '16145943511502558564.jpg'),
(9, 'NACH FARBE FILTERN', 56, 'Du bist auf der Suche nach der Lippenstiftfarbe, die perfekt zu Dir passt?Du bist auf der Suche nach der Lippenstiftfarbe, die perfekt zu Dir passt?Du bist auf der Suche nach der Lippenstiftfarbe, die perfekt zu Dir passt?Du bist auf der Suche nach der Lippenstiftfarbe, die perfekt zu Dir passt?Du bist auf der Suche nach der Lippenstiftfarbe, die perfekt zu Dir passt?\r\n\r\n', 'schimmer', 'red', 'dark', '16145966411056570524.jpg'),
(11, 'Hdpe pipes', 67, ' adipisicing elitcf sed do eiusmod tem. adipisicing elitcf sed do eiusmod tem. adipisicing elitcf sed do eiusmod tem. adipisicing elitcf sed do eiusmod tem. adipisicing elitcf sed do eiusmod tem. adipisicing elitcf sed do eiusmod tem. adipisicing elitcf sed do eiusmod tem. adipisicing elitcf sed do eiusmod tem. adipisicing elitcf sed do eiusmod tem. adipisicing elitcf sed do eiusmod tem.\r\n\r\n', 'cream', 'red', 'medium', '16145942121880153787.jpg'),
(13, 'Matte Lipstick', 55, 'Der Lipstick Finder findet Deine perfekte Shade und TexturDer Lipstick Finder findet Deine perfekte Shade und TexturDer Lipstick Finder findet Deine perfekte Shade und TexturDer Lipstick Finder findet Deine perfekte Shade und TexturDer Lipstick Finder findet Deine perfekte Shade und TexturDer Lipstick Finder findet Deine perfekte Shade und TexturDer Lipstick Finder findet Deine perfekte Shade und Textur\r\n\r\n', 'matt', 'red', 'dark', '16145940151721548188.jpg'),
(15, 'matte pink', 45, 'Der Lipstick Finder findet Deine perfekte Shade und TexturDer Lipstick Finder findet Deine perfekte Shade und TexturDer Lipstick Finder findet Deine perfekte Shade und TexturDer Lipstick Finder findet Deine perfekte Shade und TexturDer Lipstick Finder findet Deine perfekte Shade und Textur\r\n\r\n', 'cream', 'red', 'dark', '16145964721531232933.jpg'),
(17, 'zinc pink', 347, 'Der Lipstick Finder findet Deine perfekte Shade und TexturDer Lipstick Finder findet Deine perfekte Shade und TexturDer Lipstick Finder findet Deine perfekte Shade und TexturDer Lipstick Finder findet Deine perfekte Shade und TexturDer Lipstick Finder findet Deine perfekte Shade und TexturDer Lipstick Finder findet Deine perfekte Shade und TexturDer Lipstick Finder findet Deine perfekte Shade und Textur\r\n\r\n', 'schimmer', 'red', 'dark', '16145938331404792141.jpg'),
(19, 'Lakhme', 77, 'Der Lipstick Finder findet Deine perfekte Shade und TexturDer Lipstick Finder findet Deine perfekte Shade und TexturDer Lipstick Finder findet Deine perfekte Shade und TexturDer Lipstick Finder findet Deine perfekte Shade und TexturDer Lipstick Finder findet Deine perfekte Shade und Textur\r\n\r\n', 'matt', 'pink', 'bright', '16145937171521046806.jpg'),
(21, 'Blue Heaven', 34, 'Der Lipstick Finder findet Deine perfekte Shade und TexturDer Lipstick Finder findet Deine perfekte Shade und TexturDer Lipstick Finder findet Deine perfekte Shade und TexturDer Lipstick Finder findet Deine perfekte Shade und TexturDer Lipstick Finder findet Deine perfekte Shade und Textur\r\n\r\n', 'cream', 'nude', 'bright', '1614593584216110342.jpg'),
(23, 'Bliue Heaven', 77, 'Du bist auf der Suche nach der Lippenstiftfarbe, die perfekt zu Dir passDu bist auf der Suche nach der Lippenstiftfarbe, die perfekt zu Dir passDu bist auf der Suche nach der Lippenstiftfarbe, die perfekt zu Dir passDu bist auf der Suche nach der Lippenstiftfarbe, die perfekt zu Dir passDu bist auf der Suche nach der Lippenstiftfarbe, die perfekt zu Dir passDu bist auf der Suche nach der Lippenstiftfarbe, die perfekt zu Dir pass\r\n\r\n', 'schimmer', 'nude', 'bright', '1614593426698989064.jpg'),
(25, 'lotus', 70, 'Du bist auf der Suche nach der Lippenstiftfarbe, die perfekt zu Dir passDu bist auf der Suche nach der Lippenstiftfarbe, die perfekt zu Dir passDu bist auf der Suche nach der Lippenstiftfarbe, die perfekt zu Dir passDu bist auf der Suche nach der Lippenstiftfarbe, die perfekt zu Dir pass\r\n\r\n', 'matt', 'pink', 'medium', '16145932151343620336.jpg'),
(27, 'Blue Heaven', 67, 'Du bist auf der Suche nach der Lippenstiftfarbe, die perfekt zu Dir passDu bist auf der Suche nach der Lippenstiftfarbe, die perfekt zu Dir passDu bist auf der Suche nach der Lippenstiftfarbe, die perfekt zu Dir passDu bist auf der Suche nach der Lippenstiftfarbe, die perfekt zu Dir pass\r\n\r\n', 'matt', 'nude', 'medium', '1614593126285443355.jpg'),
(29, 'Lotus', 60, 'Du bist auf der Suche nach der Lippenstiftfarbe, die perfekt zu Dir passDu bist auf der Suche nach der Lippenstiftfarbe, die perfekt zu Dir passDu bist auf der Suche nach der Lippenstiftfarbe, die perfekt zu Dir passDu bist auf der Suche nach der Lippenstiftfarbe, die perfekt zu Dir pass\r\n\r\n', 'schimmer', 'pink', 'medium', '1614593024366106271.jpg'),
(31, 'Sugar', 55, 'Du bist auf der Suche nach der Lippenstiftfarbe, die perfekt zu Dir passDu bist auf der Suche nach der Lippenstiftfarbe, die perfekt zu Dir pass\r\n\r\n', 'matt', 'pink', 'dark', '1614592839564987833.jpg'),
(33, 'Blue Heaven', 44, 'Du bist auf der Suche nach der Lippenstiftfarbe, die perfekt zu Dir passDu bist auf der Suche nach der Lippenstiftfarbe, die perfekt zu Dir passDu bist auf der Suche nach der Lippenstiftfarbe, die perfekt zu Dir passDu bist auf der Suche nach der Lippenstiftfarbe, die perfekt zu Dir pass\r\n\r\n', 'cream', 'pink', 'dark', '16145927511035555100.jpg'),
(35, 'Lakhme', 80, 'Du bist auf der Suche nach der Lippenstiftfarbe, die perfekt zu Dir passDu bist auf der Suche nach der Lippenstiftfarbe, die perfekt zu Dir passDu bist auf der Suche nach der Lippenstiftfarbe, die perfekt zu Dir passDu bist auf der Suche nach der Lippenstiftfarbe, die perfekt zu Dir pass\r\n\r\n', 'schimmer', 'pink', 'dark', '1614592446263793600.jpg'),
(37, 'Sugar', 55, 'Du bist auf der Suche nach der Lippenstiftfarbe, die perfekt zu Dir passDu bist auf der Suche nach der Lippenstiftfarbe, die perfekt zu Dir passDu bist auf der Suche nach der Lippenstiftfarbe, die perfekt zu Dir pass\r\n\r\n', 'matt', 'nude', 'bright', '1614592237229636655.jpg'),
(39, 'Lakhme', 50, 'Du bist auf der Suche nach der Lippenstiftfarbe, die perfekt zu Dir passDu bist auf der Suche nach der Lippenstiftfarbe, die perfekt zu Dir passDu bist auf der Suche nach der Lippenstiftfarbe, die perfekt zu Dir passDu bist auf der Suche nach der Lippenstiftfarbe, die perfekt zu Dir pass\r\n\r\n', 'cream', 'pink', 'bright', '16145921321433306138.jpg'),
(41, 'Lotus', 67, 'Du bist auf der Suche nach der Lippenstiftfarbe, die perfekt zu Dir passDu bist auf der Suche nach der Lippenstiftfarbe, die perfekt zu Dir passDu bist auf der Suche nach der Lippenstiftfarbe, die perfekt zu Dir passDu bist auf der Suche nach der Lippenstiftfarbe, die perfekt zu Dir pass\r\n\r\n', 'matt', 'red', 'bright', '16145919891233635318.jpg'),
(43, 'Blue Heaven', 56, 'Du bist auf der Suche nach der Lippenstiftfarbe, die perfekt zu Dir passDu bist auf der Suche nach der Lippenstiftfarbe, die perfekt zu Dir passDu bist auf der Suche nach der Lippenstiftfarbe, die perfekt zu Dir passDu bist auf der Suche nach der Lippenstiftfarbe, die perfekt zu Dir pass\r\n\r\n', 'cream', 'pink', 'dark', '1614591867974390681.jpg'),
(45, 'Oriflame', 77, ' theBalm Cosmetics Meet Matte Hughes Long-Lasting Liquid Lipstick theBalm Cosmetics Meet Matte Hughes Long-Lasting Liquid Lipstick the most popular lipstick brands and their most coveted shades of the year.\r\n\r\n', 'schimmer', 'pink', 'medium', '1614591577411889193.jpg'),
(47, 'Lotus', 50, 'Sheer or Satin. Sheer or satin lipsticks give your lips a soft and hydrated appearance and are perfect for your no-makeup makeup days. Somewhere between satin and matte lies the creamy lipstick makeup theBalm Cosmetics Meet Matte Hughes Long-Lasting Liquid Lipstick.\r\n\r\n', 'schimmer', 'pink', 'medium', '16145950111214100801.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `first_name` text NOT NULL,
  `last_name` text NOT NULL,
  `gender` varchar(7) DEFAULT NULL,
  `address` text NOT NULL,
  `email` text NOT NULL,
  `password` text NOT NULL,
  `balance` double NOT NULL DEFAULT 500
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `first_name`, `last_name`, `gender`, `address`, `email`, `password`, `balance`) VALUES
(2, 'Samray', 'Zahra', 'female', 'House No.43, Street No.119, Farooq Street, Krishan Nagar', 'samrayzahra1@gmail.com', 'saphire54321', 500),
(12, 'Osama', 'Ahmed', 'male', 'House No.43, Street No.119, Farooq Street, Krishan Nagar', 'osama.work96@gmail.com', 'saphire54321', 234),
(15, 'Ali', 'Raza', 'male', 'House No.43, Street No.119, Farooq Street, Krishan Nagar', 'ali_raza88@gmail.com', 'saphire54321', 500),
(17, 'Haris', 'Sohail', 'male', 'House No.43, Street No.119, Farooq Street, Krishan Nagar', 'haris_sohail85@gmail.com', 'saphire54321', 500),
(18, 'Kareena', 'Kapoor', 'female', 'House No.43, Street No.119, Farooq Street, Krishan Nagar', 'kareena_kapoor39@gmail.com', 'saphire54321', 500),
(19, 'Briya', 'Rai', 'male', 'House No.43, Street No.119, Farooq Street, Krishan Nagar', 'briya_rai44@gmail.com', 'saphire54321', 400),
(20, 'Aleena', 'Shahid', 'female', 'House No.43, Street No.119, Farooq Street, Krishan Nagar', 'aleena_shahid22@gmail.com', 'saphire54321', 353);

-- --------------------------------------------------------

--
-- Table structure for table `wishlist`
--

CREATE TABLE `wishlist` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `wishlist`
--

INSERT INTO `wishlist` (`id`, `user_id`, `product_id`) VALUES
(1, 12, 1),
(2, 12, 3),
(3, 12, 7),
(4, 19, 43),
(5, 20, 5);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cart`
--
ALTER TABLE `cart`
  ADD PRIMARY KEY (`id`);

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
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `wishlist`
--
ALTER TABLE `wishlist`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cart`
--
ALTER TABLE `cart`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=49;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `wishlist`
--
ALTER TABLE `wishlist`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
