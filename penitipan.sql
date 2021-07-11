-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 11, 2021 at 02:55 PM
-- Server version: 10.4.6-MariaDB
-- PHP Version: 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `penitipan`
--

-- --------------------------------------------------------

--
-- Table structure for table `kendaraan`
--

CREATE TABLE `kendaraan` (
  `id` int(11) NOT NULL,
  `plat` varchar(10) NOT NULL,
  `jenis` varchar(5) NOT NULL,
  `nomor` int(11) NOT NULL,
  `tanggal_masuk` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kendaraan`
--

INSERT INTO `kendaraan` (`id`, `plat`, `jenis`, `nomor`, `tanggal_masuk`) VALUES
(5, 'AD8989OP', 'Mobil', 4, '2021-07-09 06:15:01'),
(8, 'B1NG0', 'Mobil', 2, '2021-07-11 01:52:03'),
(9, 'AD6647TY', 'Motor', 19, '2021-07-11 16:27:04');

-- --------------------------------------------------------

--
-- Table structure for table `riwayat`
--

CREATE TABLE `riwayat` (
  `id` int(11) NOT NULL,
  `plat` varchar(10) NOT NULL,
  `jenis` varchar(5) NOT NULL,
  `nomor` int(11) NOT NULL,
  `tanggal_masuk` datetime NOT NULL,
  `tanggal_keluar` datetime NOT NULL,
  `status_karcis` varchar(6) NOT NULL,
  `lama` varchar(1000) NOT NULL,
  `total` varchar(500) NOT NULL,
  `uang` varchar(500) NOT NULL,
  `kembalian` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `riwayat`
--

INSERT INTO `riwayat` (`id`, `plat`, `jenis`, `nomor`, `tanggal_masuk`, `tanggal_keluar`, `status_karcis`, `lama`, `total`, `uang`, `kembalian`) VALUES
(1, 'B1786LL', 'Motor', 18, '2021-07-10 15:05:24', '2021-07-10 15:36:57', 'Hilang', '0 tahun, 0 hari, 0 jam, 31 menit, 33 detik', 'Rp. 32.000,00', 'Rp. 32.000,00', 'Uang Anda pas'),
(7, 'LA9090L', 'Mobil', 7, '2021-07-10 22:00:04', '2021-07-11 16:32:47', 'Masih', '0 tahun, 0 hari, 18 jam, 32 menit, 3 detik', 'Rp. 90.000,00', 'Rp. 110.000,00', 'Rp. 20.000,00');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `kendaraan`
--
ALTER TABLE `kendaraan`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `riwayat`
--
ALTER TABLE `riwayat`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `kendaraan`
--
ALTER TABLE `kendaraan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
