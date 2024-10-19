-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 19, 2024 at 11:02 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `greenlightstatementsdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `accounts`
--

CREATE TABLE `accounts` (
  `id` bigint(20) NOT NULL,
  `active` bit(1) NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `current_balance` decimal(38,2) DEFAULT NULL,
  `is_parent` bit(1) DEFAULT NULL,
  `name` varchar(225) NOT NULL,
  `notes` varchar(225) DEFAULT NULL,
  `start_balance` decimal(38,2) DEFAULT NULL,
  `start_balance_status` int(11) NOT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `account_type` bigint(20) DEFAULT NULL,
  `added_by` bigint(20) DEFAULT NULL,
  `parent_account_number` bigint(20) DEFAULT NULL,
  `updated_by` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `accounts`
--

INSERT INTO `accounts` (`id`, `active`, `created_at`, `current_balance`, `is_parent`, `name`, `notes`, `start_balance`, `start_balance_status`, `updated_at`, `account_type`, `added_by`, `parent_account_number`, `updated_by`) VALUES
(2, b'1', '2024-10-12 18:27:37.000000', 0.00, b'0', 'mahmoud bdran', 'this is the my note', 0.00, 3, '2024-10-12 18:27:37.000000', 3, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `account_types`
--

CREATE TABLE `account_types` (
  `id` bigint(20) NOT NULL,
  `active` bit(1) NOT NULL,
  `name` varchar(255) NOT NULL,
  `relatediternalaccounts` bit(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `account_types`
--

INSERT INTO `account_types` (`id`, `active`, `name`, `relatediternalaccounts`) VALUES
(1, b'1', 'رأس المال', b'0'),
(2, b'1', 'مورد', b'1'),
(3, b'1', 'عميل', b'1'),
(4, b'1', 'مندوب', b'1'),
(5, b'1', 'موظف', b'1'),
(6, b'1', 'بنكي', b'0'),
(7, b'1', 'مصروفات', b'0'),
(8, b'1', 'قسم داخلي', b'1'),
(9, b'1', 'عام', b'0');

-- --------------------------------------------------------

--
-- Table structure for table `admins`
--

CREATE TABLE `admins` (
  `id` bigint(20) NOT NULL,
  `email` varchar(100) NOT NULL,
  `is_account_non_expired` bit(1) NOT NULL,
  `is_account_non_locked` bit(1) NOT NULL,
  `is_credentials_non_expired` bit(1) NOT NULL,
  `is_enabled` bit(1) NOT NULL,
  `name` varchar(100) NOT NULL,
  `password` varchar(225) NOT NULL,
  `username` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `company`
--

CREATE TABLE `company` (
  `id` bigint(20) NOT NULL,
  `active` bit(1) NOT NULL,
  `address` varchar(250) DEFAULT NULL,
  `created_at` datetime(6) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `notes` varchar(225) DEFAULT NULL,
  `phones` varchar(50) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `account_id` bigint(20) DEFAULT NULL,
  `added_by` bigint(20) DEFAULT NULL,
  `updated_by` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `contractor`
--

CREATE TABLE `contractor` (
  `id` bigint(20) NOT NULL,
  `active` bit(1) NOT NULL,
  `address` varchar(250) DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `notes` varchar(225) DEFAULT NULL,
  `phones` varchar(50) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `account_id` bigint(20) DEFAULT NULL,
  `added_by` bigint(20) DEFAULT NULL,
  `updated_by` bigint(20) DEFAULT NULL,
  `current_balance` decimal(38,2) DEFAULT NULL,
  `start_balance` decimal(38,2) DEFAULT NULL,
  `start_balance_status` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `contractor`
--

INSERT INTO `contractor` (`id`, `active`, `address`, `created_at`, `name`, `notes`, `phones`, `updated_at`, `account_id`, `added_by`, `updated_by`, `current_balance`, `start_balance`, `start_balance_status`) VALUES
(1, b'1', 'Matrouh , Marsa Matrouh', '2024-10-12 18:27:37.000000', 'mahmoud bdran', 'this is the my note', '01205057427', '2024-10-12 18:27:37.000000', 2, NULL, NULL, 0.00, 0.00, 3);

-- --------------------------------------------------------

--
-- Table structure for table `invoice`
--

CREATE TABLE `invoice` (
  `id` bigint(20) NOT NULL,
  `amount` decimal(38,2) DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `invoice_date` date DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `account_id` bigint(20) DEFAULT NULL,
  `added_by` bigint(20) DEFAULT NULL,
  `company_id` bigint(20) DEFAULT NULL,
  `contractor_id` bigint(20) DEFAULT NULL,
  `owner_id` bigint(20) DEFAULT NULL,
  `updated_by` bigint(20) DEFAULT NULL,
  `invoice_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `job_type`
--

CREATE TABLE `job_type` (
  `id` bigint(20) NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `job_type_date` date DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `added_by` bigint(20) DEFAULT NULL,
  `company_id` bigint(20) DEFAULT NULL,
  `owner_id` bigint(20) DEFAULT NULL,
  `updated_by` bigint(20) DEFAULT NULL,
  `jobtype_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `owner`
--

CREATE TABLE `owner` (
  `id` bigint(20) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `account_id` bigint(20) DEFAULT NULL,
  `added_by` bigint(20) DEFAULT NULL,
  `updated_by` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `roles`
--

CREATE TABLE `roles` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tables`
--

CREATE TABLE `tables` (
  `id` bigint(20) NOT NULL,
  `made_in_period` decimal(38,2) DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `finished_till_now` decimal(38,2) DEFAULT NULL,
  `item_price` decimal(38,2) DEFAULT NULL,
  `last_made` decimal(38,2) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `percentage` decimal(38,2) DEFAULT NULL,
  `total_price` decimal(38,2) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `inovice_id` bigint(20) DEFAULT NULL,
  `unit_id` bigint(20) DEFAULT NULL,
  `added_by` bigint(20) DEFAULT NULL,
  `updated_by` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `unit`
--

CREATE TABLE `unit` (
  `id` bigint(20) NOT NULL,
  `unit` varchar(255) DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `added_by` bigint(20) DEFAULT NULL,
  `updated_by` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `users_roles`
--

CREATE TABLE `users_roles` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `accounts`
--
ALTER TABLE `accounts`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKfewvxe4khtqi148b7v7cj1o49` (`account_type`),
  ADD KEY `FKk1datdiu7myu9m45ir80cggid` (`added_by`),
  ADD KEY `FK70mh6nn5ow6yliuaeaq0kje9y` (`parent_account_number`),
  ADD KEY `FKcjt0qyitfg2qb2mmpgjm4r5xo` (`updated_by`);

--
-- Indexes for table `account_types`
--
ALTER TABLE `account_types`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `admins`
--
ALTER TABLE `admins`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `company`
--
ALTER TABLE `company`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_tq5kr7wfeog5tjjr1eqtww5oh` (`account_id`),
  ADD KEY `FKml1anj2h45vdlu7bofwdab80l` (`added_by`),
  ADD KEY `FKjitgebm5ktdkhfngwewjxseyq` (`updated_by`);

--
-- Indexes for table `contractor`
--
ALTER TABLE `contractor`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_a7b0w4debbwljplpim32skmmx` (`account_id`),
  ADD KEY `FKldf3mnu4ifbdf6wp4bgfggcn5` (`added_by`),
  ADD KEY `FK2u9vkpikr15mmur3b870hwxfv` (`updated_by`);

--
-- Indexes for table `invoice`
--
ALTER TABLE `invoice`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_gqf8jc7qmukdqpr60mahwohkf` (`account_id`),
  ADD KEY `FKm79bilqxrulfn5rr7lsufjs13` (`added_by`),
  ADD KEY `FKaslug8pfl346tbeuslh98n7k5` (`company_id`),
  ADD KEY `FKd3ig3yw7nfi41ul3hsvpeuu5a` (`contractor_id`),
  ADD KEY `FKqkhdidjn05sm5ij3rx7541i9g` (`owner_id`),
  ADD KEY `FKn23j37tfydmexnfpeksxt7cd4` (`updated_by`),
  ADD KEY `FKbuulovdg2uc8ljj60joeeqgjh` (`invoice_id`);

--
-- Indexes for table `job_type`
--
ALTER TABLE `job_type`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKe29nw5y7ut8xwqoemokahhfq` (`added_by`),
  ADD KEY `FKgd2ymndgtnt1n0m8jd932uf38` (`company_id`),
  ADD KEY `FKlfjheo4i5qgoqnfosxawsuujc` (`owner_id`),
  ADD KEY `FKi0cf4krfr07nei4u7jfp4ebkt` (`updated_by`),
  ADD KEY `FKfskdummxelw9iu0ch04jg9yne` (`jobtype_id`);

--
-- Indexes for table `owner`
--
ALTER TABLE `owner`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_t50krnhvn992lfm8i3gcio7r` (`account_id`),
  ADD KEY `FKny1tegkqko54r8t487mvahvtu` (`added_by`),
  ADD KEY `FKgj9t0oq2lma0wpu8q7tr1lehk` (`updated_by`);

--
-- Indexes for table `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_nb4h0p6txrmfc0xbrd1kglp9t` (`name`);

--
-- Indexes for table `tables`
--
ALTER TABLE `tables`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKskehccp2sptq3c20miy7y43qg` (`inovice_id`),
  ADD KEY `FK46pakm4434bfqx07vo5h3g6sh` (`unit_id`),
  ADD KEY `FKg0j8tatx6e1qcbdn9ah2637nw` (`added_by`),
  ADD KEY `FKh79je24xar6appbwdgm1jcjcp` (`updated_by`);

--
-- Indexes for table `unit`
--
ALTER TABLE `unit`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK9y5fei8ocohoqhoj2qmy1q8p0` (`added_by`),
  ADD KEY `FKmbcg2x9rjy4yo2cf7e8vio3g3` (`updated_by`);

--
-- Indexes for table `users_roles`
--
ALTER TABLE `users_roles`
  ADD PRIMARY KEY (`user_id`,`role_id`),
  ADD KEY `FKj6m8fwv7oqv74fcehir1a9ffy` (`role_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `accounts`
--
ALTER TABLE `accounts`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `account_types`
--
ALTER TABLE `account_types`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `admins`
--
ALTER TABLE `admins`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `company`
--
ALTER TABLE `company`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `contractor`
--
ALTER TABLE `contractor`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `invoice`
--
ALTER TABLE `invoice`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `job_type`
--
ALTER TABLE `job_type`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `owner`
--
ALTER TABLE `owner`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `roles`
--
ALTER TABLE `roles`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tables`
--
ALTER TABLE `tables`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `unit`
--
ALTER TABLE `unit`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `accounts`
--
ALTER TABLE `accounts`
  ADD CONSTRAINT `FK70mh6nn5ow6yliuaeaq0kje9y` FOREIGN KEY (`parent_account_number`) REFERENCES `accounts` (`id`),
  ADD CONSTRAINT `FKcjt0qyitfg2qb2mmpgjm4r5xo` FOREIGN KEY (`updated_by`) REFERENCES `admins` (`id`),
  ADD CONSTRAINT `FKfewvxe4khtqi148b7v7cj1o49` FOREIGN KEY (`account_type`) REFERENCES `account_types` (`id`),
  ADD CONSTRAINT `FKk1datdiu7myu9m45ir80cggid` FOREIGN KEY (`added_by`) REFERENCES `admins` (`id`);

--
-- Constraints for table `company`
--
ALTER TABLE `company`
  ADD CONSTRAINT `FKewnnevmicu60dcbm658bd0haa` FOREIGN KEY (`account_id`) REFERENCES `accounts` (`id`),
  ADD CONSTRAINT `FKjitgebm5ktdkhfngwewjxseyq` FOREIGN KEY (`updated_by`) REFERENCES `admins` (`id`),
  ADD CONSTRAINT `FKml1anj2h45vdlu7bofwdab80l` FOREIGN KEY (`added_by`) REFERENCES `admins` (`id`);

--
-- Constraints for table `contractor`
--
ALTER TABLE `contractor`
  ADD CONSTRAINT `FK2u9vkpikr15mmur3b870hwxfv` FOREIGN KEY (`updated_by`) REFERENCES `admins` (`id`),
  ADD CONSTRAINT `FKcf7sus07y92nsp8ta170dru8n` FOREIGN KEY (`account_id`) REFERENCES `accounts` (`id`),
  ADD CONSTRAINT `FKldf3mnu4ifbdf6wp4bgfggcn5` FOREIGN KEY (`added_by`) REFERENCES `admins` (`id`);

--
-- Constraints for table `invoice`
--
ALTER TABLE `invoice`
  ADD CONSTRAINT `FK50k7usua8osmcapalh3wgcudn` FOREIGN KEY (`account_id`) REFERENCES `accounts` (`id`),
  ADD CONSTRAINT `FKaslug8pfl346tbeuslh98n7k5` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`),
  ADD CONSTRAINT `FKbuulovdg2uc8ljj60joeeqgjh` FOREIGN KEY (`invoice_id`) REFERENCES `owner` (`id`),
  ADD CONSTRAINT `FKd3ig3yw7nfi41ul3hsvpeuu5a` FOREIGN KEY (`contractor_id`) REFERENCES `contractor` (`id`),
  ADD CONSTRAINT `FKm79bilqxrulfn5rr7lsufjs13` FOREIGN KEY (`added_by`) REFERENCES `admins` (`id`),
  ADD CONSTRAINT `FKn23j37tfydmexnfpeksxt7cd4` FOREIGN KEY (`updated_by`) REFERENCES `admins` (`id`),
  ADD CONSTRAINT `FKqkhdidjn05sm5ij3rx7541i9g` FOREIGN KEY (`owner_id`) REFERENCES `owner` (`id`);

--
-- Constraints for table `job_type`
--
ALTER TABLE `job_type`
  ADD CONSTRAINT `FKe29nw5y7ut8xwqoemokahhfq` FOREIGN KEY (`added_by`) REFERENCES `admins` (`id`),
  ADD CONSTRAINT `FKfskdummxelw9iu0ch04jg9yne` FOREIGN KEY (`jobtype_id`) REFERENCES `owner` (`id`),
  ADD CONSTRAINT `FKgd2ymndgtnt1n0m8jd932uf38` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`),
  ADD CONSTRAINT `FKi0cf4krfr07nei4u7jfp4ebkt` FOREIGN KEY (`updated_by`) REFERENCES `admins` (`id`),
  ADD CONSTRAINT `FKlfjheo4i5qgoqnfosxawsuujc` FOREIGN KEY (`owner_id`) REFERENCES `owner` (`id`);

--
-- Constraints for table `owner`
--
ALTER TABLE `owner`
  ADD CONSTRAINT `FKgj9t0oq2lma0wpu8q7tr1lehk` FOREIGN KEY (`updated_by`) REFERENCES `admins` (`id`),
  ADD CONSTRAINT `FKixi1xkup8hobptk7ji1b58ct6` FOREIGN KEY (`account_id`) REFERENCES `accounts` (`id`),
  ADD CONSTRAINT `FKny1tegkqko54r8t487mvahvtu` FOREIGN KEY (`added_by`) REFERENCES `admins` (`id`);

--
-- Constraints for table `tables`
--
ALTER TABLE `tables`
  ADD CONSTRAINT `FK46pakm4434bfqx07vo5h3g6sh` FOREIGN KEY (`unit_id`) REFERENCES `unit` (`id`),
  ADD CONSTRAINT `FKg0j8tatx6e1qcbdn9ah2637nw` FOREIGN KEY (`added_by`) REFERENCES `admins` (`id`),
  ADD CONSTRAINT `FKh79je24xar6appbwdgm1jcjcp` FOREIGN KEY (`updated_by`) REFERENCES `admins` (`id`),
  ADD CONSTRAINT `FKskehccp2sptq3c20miy7y43qg` FOREIGN KEY (`inovice_id`) REFERENCES `invoice` (`id`);

--
-- Constraints for table `unit`
--
ALTER TABLE `unit`
  ADD CONSTRAINT `FK9y5fei8ocohoqhoj2qmy1q8p0` FOREIGN KEY (`added_by`) REFERENCES `admins` (`id`),
  ADD CONSTRAINT `FKmbcg2x9rjy4yo2cf7e8vio3g3` FOREIGN KEY (`updated_by`) REFERENCES `admins` (`id`);

--
-- Constraints for table `users_roles`
--
ALTER TABLE `users_roles`
  ADD CONSTRAINT `FK8sns6t0fr1thabomy9r5dhd96` FOREIGN KEY (`user_id`) REFERENCES `admins` (`id`),
  ADD CONSTRAINT `FKj6m8fwv7oqv74fcehir1a9ffy` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
