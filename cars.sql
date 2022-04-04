-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 19, 2021 at 09:03 AM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 7.3.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cars`
--
CREATE DATABASE IF NOT EXISTS `cars` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `cars`;

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `customerid` int(100) NOT NULL,
  `customername` text NOT NULL,
  `customeric` varchar(50) NOT NULL,
  `customerphone` varchar(50) NOT NULL,
  `customeraddress` varchar(100) NOT NULL,
  `customeremail` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`customerid`, `customername`, `customeric`, `customerphone`, `customeraddress`, `customeremail`) VALUES
(100, 'afifah', '990815-02-4563', '012-6542789', 'bukit puteri sungai petani', 'afifah@yes.com'),
(101, 'anis', '960231-56-7896', '017-4646531', 'the zizz, damanasara damai', 'anis@gmail.com'),
(102, 'sara', '991230-02-2356', '011-61442264', 'bagan luar 12/6 Sungai petani', 'sara@gmail.com'),
(103, 'amira', '6000828-02-5880', '012-4347672', 'Sungai Petani, Kedah', 'amira@yahoo.com');

-- --------------------------------------------------------

--
-- Table structure for table `manager`
--

DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `managerid` int(100) NOT NULL,
  `managername` text NOT NULL,
  `managerusername` varchar(50) NOT NULL,
  `managerpassword` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `manager`
--

INSERT INTO `manager` (`managerid`, `managername`, `managerusername`, `managerpassword`) VALUES
(1000, 'samirah', 'amira', 'amira'),
(1002, 'bon', 'sam', 'sam');

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

DROP TABLE IF EXISTS `staff`;
CREATE TABLE `staff` (
  `staffid` int(100) NOT NULL,
  `staffname` text NOT NULL,
  `staffic` varchar(50) NOT NULL,
  `staffphone` varchar(50) NOT NULL,
  `staffemail` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `staff`
--

INSERT INTO `staff` (`staffid`, `staffname`, `staffic`, `staffphone`, `staffemail`) VALUES
(1000, 'amir', '990830-07-5956', '011-61442264', 'amir@gmail.com'),
(1001, 'amirul', '5698-02-4569', '012-4347679', 'amirul@hotmail.com'),
(1002, 'hakim', '12312-02-4563', '012-4563789', 'hakim@yahoo.com'),
(1003, 'luqman', '021352-03-1256', '011-1232563', 'luqman@yes.my'),
(1004, 'sara ali', '99021-15-1230', '012 - 2465632', 'saraali@hotmail.com'),
(1005, 'salmiah', '650111-03-5880', '013-4236589', 'salmi@hotmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `vehicle`
--

DROP TABLE IF EXISTS `vehicle`;
CREATE TABLE `vehicle` (
  `vehicleid` int(100) NOT NULL,
  `customerid` int(100) NOT NULL,
  `customername` text NOT NULL,
  `customeric` varchar(100) NOT NULL,
  `vehiclemodel` varchar(100) NOT NULL,
  `vehiclebrand` varchar(100) NOT NULL,
  `vehiclecolor` text NOT NULL,
  `vehicleyear` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `vehicle`
--

INSERT INTO `vehicle` (`vehicleid`, `customerid`, `customername`, `customeric`, `vehiclemodel`, `vehiclebrand`, `vehiclecolor`, `vehicleyear`) VALUES
(2000, 100, 'afifah', '990815-02-4563', 'toyota', 'avanza', 'red', '2005'),
(2001, 101, 'anis', '960231-56-7896', 'axia', 'perodua', 'soft green', '2019'),
(2002, 102, 'sara', '991230-02-2356', 'myvi', 'perodua', 'grey', '2021'),
(2004, 100, 'afifah', '990815-02-4563', 'satria', 'perodua', ' metallic grey', '2000'),
(2005, 103, 'amira', '6000828-02-5880', 'satria', 'perodua', 'red', '2010'),
(2006, 102, 'sara', '991230-02-2356', 'avanza', 'toyota', 'green ', '2002'),
(2007, 101, 'anis', '960231-56-7896', 'alphat', 'toyota', 'black', '2000');

-- --------------------------------------------------------

--
-- Table structure for table `workorder`
--

DROP TABLE IF EXISTS `workorder`;
CREATE TABLE `workorder` (
  `workorderid` int(100) NOT NULL,
  `staffid` int(100) NOT NULL,
  `customerid` int(100) NOT NULL,
  `vehicleid` int(100) NOT NULL,
  `date` date NOT NULL,
  `problem` varchar(100) NOT NULL,
  `causes` varchar(100) NOT NULL,
  `solution` varchar(100) NOT NULL,
  `payment` float(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `workorder`
--

INSERT INTO `workorder` (`workorderid`, `staffid`, `customerid`, `vehicleid`, `date`, `problem`, `causes`, `solution`, `payment`) VALUES
(1, 1000, 100, 2000, '2021-02-10', 'front mirror', 'accident', 'replaces', 200.00),
(2, 1001, 100, 2000, '2021-02-10', 'tires', 'accident', 'replaces new ', 105.00),
(3, 1003, 101, 2001, '2021-02-10', 'broken side mirror', 'fighting and no insurances', 'replaces', 236.00),
(4, 1000, 101, 2001, '2021-02-13', 'hit n run', 'fighting for no reason', 'repair all', 520.00),
(5, 1000, 101, 2001, '2021-02-14', 'engine problem', 'driving too long', 'change engine', 236.00),
(6, 1000, 102, 2006, '2021-02-14', 'battery problem', 'over heating', 'change battery', 236.00);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`customerid`),
  ADD UNIQUE KEY `customeric` (`customeric`);

--
-- Indexes for table `manager`
--
ALTER TABLE `manager`
  ADD PRIMARY KEY (`managerid`);

--
-- Indexes for table `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`staffid`);

--
-- Indexes for table `vehicle`
--
ALTER TABLE `vehicle`
  ADD PRIMARY KEY (`vehicleid`),
  ADD KEY `customerid` (`customerid`),
  ADD KEY `customeric` (`customeric`);

--
-- Indexes for table `workorder`
--
ALTER TABLE `workorder`
  ADD PRIMARY KEY (`workorderid`),
  ADD KEY `staffid` (`staffid`),
  ADD KEY `customerid` (`customerid`),
  ADD KEY `vehicleid` (`vehicleid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `customerid` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=111;

--
-- AUTO_INCREMENT for table `staff`
--
ALTER TABLE `staff`
  MODIFY `staffid` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1006;

--
-- AUTO_INCREMENT for table `vehicle`
--
ALTER TABLE `vehicle`
  MODIFY `vehicleid` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2009;

--
-- AUTO_INCREMENT for table `workorder`
--
ALTER TABLE `workorder`
  MODIFY `workorderid` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `vehicle`
--
ALTER TABLE `vehicle`
  ADD CONSTRAINT `vehicle_ibfk_1` FOREIGN KEY (`customerid`) REFERENCES `customer` (`customerid`),
  ADD CONSTRAINT `vehicle_ibfk_2` FOREIGN KEY (`customeric`) REFERENCES `customer` (`customeric`);

--
-- Constraints for table `workorder`
--
ALTER TABLE `workorder`
  ADD CONSTRAINT `workorder_ibfk_1` FOREIGN KEY (`staffid`) REFERENCES `staff` (`staffid`),
  ADD CONSTRAINT `workorder_ibfk_2` FOREIGN KEY (`customerid`) REFERENCES `customer` (`customerid`),
  ADD CONSTRAINT `workorder_ibfk_3` FOREIGN KEY (`vehicleid`) REFERENCES `vehicle` (`vehicleid`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
