-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1

-- Tiempo de generación: 07-12-2023 a las 07:32:58

-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd_hoteleria`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `accommodation_contract`
--

CREATE TABLE `accommodation_contract` (
  `id` int(11) NOT NULL,
  `status` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `admin`
--

CREATE TABLE `admin` (
  `admin_id` int(11) NOT NULL,
  `user` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `admin`
--

INSERT INTO `admin` (`admin_id`, `user`, `email`, `password`) VALUES
(1, 'admin', 'admin@gmail.com', '123456');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `checkin`
--

CREATE TABLE `checkin` (
  `check_in_id` int(11) NOT NULL,
  `reservation_id` int(11) DEFAULT NULL,
  `check_in_time` time DEFAULT NULL,
  `check_in_date` date DEFAULT NULL,
  `guests_count` int(11) DEFAULT NULL,
  `guest_first_name` varchar(255) DEFAULT NULL,
  `guest_last_name` varchar(255) DEFAULT NULL,
  `additional_comments` text DEFAULT NULL,
  `id_assigned_room` int(11) DEFAULT NULL,
  `name_student` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `checkin`
--

INSERT INTO `checkin` (`check_in_id`, `reservation_id`, `check_in_time`, `check_in_date`, `guests_count`, `guest_first_name`, `guest_last_name`, `additional_comments`, `id_assigned_room`, `name_student`) VALUES
(3, NULL, '15:30:00', '2023-10-01', 2, 'Juan', 'Pérez', 'Ninguno por el momento', 101, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `checkout`
--

CREATE TABLE `checkout` (
  `check_out_id` int(11) NOT NULL,
  `check_in_id` int(11) DEFAULT NULL,
  `check_out_date` date DEFAULT NULL,
  `guests_count` int(11) DEFAULT NULL,
  `guest_first_name` varchar(255) DEFAULT NULL,
  `guest_last_name` varchar(255) DEFAULT NULL,
  `room_status` varchar(255) DEFAULT NULL,
  `total_cost` int(11) DEFAULT NULL,
  `final_comments` text DEFAULT NULL,
  `name_student` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `group_instructions`
--

CREATE TABLE `group_instructions` (
  `id_group_instructions` int(11) NOT NULL,
  `name_group` varchar(50) NOT NULL,
  `pay` int(11) NOT NULL,
  `view` varchar(200) NOT NULL,
  `food_plan` varchar(200) NOT NULL,
  `name_owner_group` varchar(50) NOT NULL,
  `extra_account` tinyint(1) NOT NULL,
  `master_account` tinyint(1) NOT NULL,
  `arrival` date NOT NULL,
  `arrival_time` time NOT NULL,
  `output` date NOT NULL,
  `output_time` time NOT NULL,
  `old_count` int(11) DEFAULT NULL,
  `young_count` int(11) DEFAULT NULL,
  `total` double DEFAULT NULL,
  `simple_count` int(11) DEFAULT NULL,
  `double_count` int(11) DEFAULT NULL,
  `twin_count` int(11) DEFAULT NULL,
  `simple_paid` double NOT NULL,
  `double_paid` double NOT NULL,
  `twin_paid` double NOT NULL,
  `name_student` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `group_instructions`
--

INSERT INTO `group_instructions` (`id_group_instructions`, `name_group`, `pay`, `view`, `food_plan`, `name_owner_group`, `extra_account`, `master_account`, `arrival`, `arrival_time`, `output`, `output_time`, `old_count`, `young_count`, `total`, `simple_count`, `double_count`, `twin_count`, `simple_paid`, `double_paid`, `twin_paid`, `name_student`) VALUES
(1, 'Grupo A', 0, '', '', 'Propietario', 1, 0, '2023-09-22', '10:30:00', '2023-09-25', '12:45:00', 5, 10, 250.5, 8, 6, 4, 150.75, 200, 100.25, 'Estudiante1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `hotel_registration`
--

CREATE TABLE `hotel_registration` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `nationality` varchar(50) NOT NULL,
  `direction` varchar(50) NOT NULL,
  `city` varchar(50) NOT NULL,
  `country` varchar(50) NOT NULL,
  `tel` varchar(200) NOT NULL,
  `transport` varchar(50) NOT NULL,
  `arrive` date NOT NULL,
  `out-customer` date NOT NULL,
  `reservation` varchar(50) NOT NULL,
  `typeid` varchar(200) NOT NULL,
  `identification` varchar(200) NOT NULL,
  `oficio` varchar(200) NOT NULL,
  `empresa` varchar(200) NOT NULL,
  `telefono-empresa` varchar(200) NOT NULL,
  `reason_for_travel` varchar(50) NOT NULL,
  `provenance` varchar(50) NOT NULL,
  `stay` varchar(50) NOT NULL,
  `destination` varchar(50) NOT NULL,
  `signature` varchar(50) NOT NULL,
  `accept_accommodation_contract` varchar(200) NOT NULL,
  `room_rate` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `hotel_registration`
--

INSERT INTO `hotel_registration` (`id`, `name`, `nationality`, `direction`, `city`, `country`, `tel`, `transport`, `arrive`, `out-customer`, `reservation`, `typeid`, `identification`, `oficio`, `empresa`, `telefono-empresa`, `reason_for_travel`, `provenance`, `stay`, `destination`, `signature`, `accept_accommodation_contract`, `room_rate`) VALUES
(1, 'jhon', 'colombia', 'calle 129 sur', 'ibague', 'colombia', '3005131873', '', '2023-11-28', '2023-11-30', 'Hotel', 'C.C', '1110452096', 'dev', 'globant', '3005131873', 'Negocios', 'melgar', 'aqui', 'no se', 'prada es gay', '', 20000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `outlet_pass`
--

CREATE TABLE `outlet_pass` (
  `id_outlet_pass` int(11) NOT NULL,
  `name_customer` varchar(50) NOT NULL,
  `date` date NOT NULL,
  `id_assigned_room` int(11) NOT NULL,
  `guests_count` int(11) NOT NULL,
  `key_room` tinyint(1) NOT NULL,
  `name_student` varchar(50) NOT NULL,
  `cashier` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `outlet_pass`
--

INSERT INTO `outlet_pass` (`id_outlet_pass`, `name_customer`, `date`, `id_assigned_room`, `guests_count`, `key_room`, `name_student`, `cashier`) VALUES
(11, 'Jhon', '2023-11-23', 101, 2, 1, 'asdsadsa', NULL);

-- --------------------------------------------------------


-- Estructura de tabla para la tabla `pay`


CREATE TABLE `pay` (
  `id_pay` int(11) NOT NULL,
  `descuentos` int(11) NOT NULL,
  `name_customer` varchar(200) NOT NULL,
  `number` int(11) NOT NULL,
  `date` date NOT NULL,
  `room` varchar(200) NOT NULL,
  `people` int(11) NOT NULL,
  `cambio` int(11) NOT NULL,
  `balance` int(11) NOT NULL,
  `seguro` int(11) NOT NULL,
  `tmo` int(11) NOT NULL,
  `restaurante` int(11) NOT NULL,
  `consumo` int(11) NOT NULL,
  `minibar` int(11) NOT NULL,
  `gastostel` int(11) NOT NULL,
  `miscelaneos` int(11) NOT NULL,
  `lavanderia` int(11) NOT NULL,
  `totalcargos` int(11) NOT NULL,
  `abonos` int(11) NOT NULL,
  `ncaja` varchar(200) NOT NULL,
  `totalpagar` int(11) NOT NULL,
  `observaciones` varchar(200) NOT NULL,
  `identificacion` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Estructura de tabla para la tabla `rack_reservation`
--

CREATE TABLE `rack_reservation` (
  `id_rack` int(11) NOT NULL,
  `company_name` varchar(50) NOT NULL,
  `no_rooms` int(11) NOT NULL,
  `room` int(11) NOT NULL,
  `month` varchar(200) NOT NULL,
  `day` int(31) NOT NULL,
  `name_student` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `rack_reservation`
--

INSERT INTO `rack_reservation` (`id_rack`, `company_name`, `no_rooms`, `room`, `month`, `day`, `name_student`) VALUES
(1, 'globant', 2, 301, 'Marzo', 18, '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `record_reservations`
--

CREATE TABLE `record_reservations` (
  `id_record` int(11) NOT NULL,
  `full_name` varchar(50) NOT NULL,
  `arrival_date` date NOT NULL,
  `direction` varchar(200) NOT NULL,
  `phone` varchar(200) NOT NULL,
  `reservation` int(11) NOT NULL,
  `departure_date` date NOT NULL,
  `type_room` varchar(50) NOT NULL,
  `guests_count` int(11) NOT NULL,
  `deposit` double NOT NULL,
  `deadline_date` date NOT NULL,
  `rate` double NOT NULL,
  `receipt_number` int(11) NOT NULL,
  `name_employe` varchar(50) NOT NULL,
  `date` date NOT NULL,
  `remarks` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `record_reservations`
--

INSERT INTO `record_reservations` (`id_record`, `full_name`, `arrival_date`, `direction`, `phone`, `reservation`, `departure_date`, `type_room`, `guests_count`, `deposit`, `deadline_date`, `rate`, `receipt_number`, `name_employe`, `date`, `remarks`) VALUES
(9, 'asdasdas', '2023-11-09', 'asdasdsa', '3005131873', 20, '2023-11-08', 'STE', 24, 1000, '2023-11-09', 2, 134555, 'asdasd', '2023-11-17', 'xd');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `report _checkin`
--

CREATE TABLE `report _checkin` (
  `id_report_checkin` int(11) NOT NULL,
  `date` date DEFAULT NULL,
  `id_assigned_room` int(11) DEFAULT NULL,
  `id_reservation` int(11) DEFAULT NULL,
  `id_checkin` int(11) DEFAULT NULL,
  `id_checkout` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reservations`
--

CREATE TABLE `reservations` (
  `reservation_id` int(11) NOT NULL,
  `reservation_date` date DEFAULT NULL,
  `check_in_date` date DEFAULT NULL,
  `check_out_date` date DEFAULT NULL,
  `contact_first_name` varchar(255) DEFAULT NULL,
  `contact_last_name` varchar(255) DEFAULT NULL,
  `contact_email` varchar(255) DEFAULT NULL,
  `contact_phone` varchar(255) DEFAULT NULL,
  `guests_total` int(11) DEFAULT NULL,
  `reservation_status` varchar(255) DEFAULT NULL,
  `special_requests` text DEFAULT NULL,
  `id_assigned_room` int(11) DEFAULT NULL,
  `nights_count` int(11) NOT NULL,
  `type_reservation` tinyint(1) NOT NULL,
  `name_student` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `reservations`
--

INSERT INTO `reservations` (`reservation_id`, `reservation_date`, `check_in_date`, `check_out_date`, `contact_first_name`, `contact_last_name`, `contact_email`, `contact_phone`, `guests_total`, `reservation_status`, `special_requests`, `id_assigned_room`, `nights_count`, `type_reservation`, `name_student`) VALUES
(8, '0010-04-14', '0034-04-14', '0020-04-13', 'yon', 'castro', 'e@gmail.com', '3005131873', 5, 'gud', 'sdfgdfjsd', 101, 5, 1, 'yon'),
(9, '0026-04-14', '0027-04-14', '0020-04-13', 'yon', 'asdas', 'e@gmail.com', '3005131873', 5, 'gud', 'xd', 203, 8, 1, 'yon');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rooms`
--

CREATE TABLE `rooms` (
  `id_assigned_room` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `rooms`
--

INSERT INTO `rooms` (`id_assigned_room`) VALUES
(101),
(102),
(103),
(104),
(105),
(106),
(107),
(108),
(109),
(110),
(201),
(202),
(203),
(204),
(205),
(206),
(207),
(208),
(209),
(210),
(301),
(302),
(303),
(304),
(305),
(306),
(307),
(308),
(309),
(310),
(401);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `room_list_group`
--

CREATE TABLE `room_list_group` (
  `id_room_list` int(11) NOT NULL,
  `arrival_date` date NOT NULL,
  `departure_date` date NOT NULL,
  `name_customer` varchar(50) NOT NULL,
  `count_room` int(11) NOT NULL,
  `type_room` varchar(50) NOT NULL,
  `no_room` varchar(50) NOT NULL,
  `name_student` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `room_list_group`
--

INSERT INTO `room_list_group` (`id_room_list`, `arrival_date`, `departure_date`, `name_customer`, `count_room`, `type_room`, `no_room`, `name_student`) VALUES
(1, '2023-09-15', '2023-09-20', 'John Doe', 2, 'Suite', '101', '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `student`
--

CREATE TABLE `student` (
  `id_student` int(11) NOT NULL,
  `name_student` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user`
--

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
  `name_email` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `user`
--

INSERT INTO `user` (`user_id`, `name_email`, `password`) VALUES
(1, 'g@gmail.com', '123456');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `accommodation_contract`
--
ALTER TABLE `accommodation_contract`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`admin_id`);

--
-- Indices de la tabla `checkin`
--
ALTER TABLE `checkin`
  ADD PRIMARY KEY (`check_in_id`),
  ADD UNIQUE KEY `reservation_id` (`reservation_id`,`id_assigned_room`),
  ADD KEY `id_assigned_room` (`id_assigned_room`);

--
-- Indices de la tabla `checkout`
--
ALTER TABLE `checkout`
  ADD PRIMARY KEY (`check_out_id`),
  ADD UNIQUE KEY `check_in_id` (`check_in_id`);

--
-- Indices de la tabla `group_instructions`
--
ALTER TABLE `group_instructions`
  ADD PRIMARY KEY (`id_group_instructions`);

--
-- Indices de la tabla `hotel_registration`
--
ALTER TABLE `hotel_registration`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `outlet_pass`
--
ALTER TABLE `outlet_pass`
  ADD PRIMARY KEY (`id_outlet_pass`),
  ADD UNIQUE KEY `id_assigned_room` (`id_assigned_room`);

--
-- Indices de la tabla `rack_reservation`
--
ALTER TABLE `rack_reservation`
  ADD PRIMARY KEY (`id_rack`);

--
-- Indices de la tabla `record_reservations`
--
ALTER TABLE `record_reservations`
  ADD PRIMARY KEY (`id_record`);

--
-- Indices de la tabla `report _checkin`
--
ALTER TABLE `report _checkin`
  ADD PRIMARY KEY (`id_report_checkin`);

--
-- Indices de la tabla `reservations`
--
ALTER TABLE `reservations`
  ADD PRIMARY KEY (`reservation_id`),
  ADD UNIQUE KEY `id_assigned_room` (`id_assigned_room`);

--
-- Indices de la tabla `rooms`
--
ALTER TABLE `rooms`
  ADD PRIMARY KEY (`id_assigned_room`);

--
-- Indices de la tabla `room_list_group`
--
ALTER TABLE `room_list_group`
  ADD PRIMARY KEY (`id_room_list`);

--
-- Indices de la tabla `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`id_student`);

--
-- Indices de la tabla `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `accommodation_contract`
--
ALTER TABLE `accommodation_contract`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `admin`
--
ALTER TABLE `admin`
  MODIFY `admin_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `checkin`
--
ALTER TABLE `checkin`
  MODIFY `check_in_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `checkout`
--
ALTER TABLE `checkout`
  MODIFY `check_out_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `group_instructions`
--
ALTER TABLE `group_instructions`
  MODIFY `id_group_instructions` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `hotel_registration`
--
ALTER TABLE `hotel_registration`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `outlet_pass`
--
ALTER TABLE `outlet_pass`
  MODIFY `id_outlet_pass` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `rack_reservation`
--
ALTER TABLE `rack_reservation`
  MODIFY `id_rack` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `record_reservations`
--
ALTER TABLE `record_reservations`
  MODIFY `id_record` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `report _checkin`
--
ALTER TABLE `report _checkin`
  MODIFY `id_report_checkin` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `reservations`
--
ALTER TABLE `reservations`
  MODIFY `reservation_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `room_list_group`
--
ALTER TABLE `room_list_group`
  MODIFY `id_room_list` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `student`
--
ALTER TABLE `student`
  MODIFY `id_student` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `checkin`
--
ALTER TABLE `checkin`
  ADD CONSTRAINT `checkin_ibfk_1` FOREIGN KEY (`id_assigned_room`) REFERENCES `rooms` (`id_assigned_room`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `checkin_ibfk_2` FOREIGN KEY (`reservation_id`) REFERENCES `reservations` (`reservation_id`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Filtros para la tabla `checkout`
--
ALTER TABLE `checkout`
  ADD CONSTRAINT `checkout_ibfk_1` FOREIGN KEY (`check_in_id`) REFERENCES `checkin` (`check_in_id`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Filtros para la tabla `reservations`
--
ALTER TABLE `reservations`
  ADD CONSTRAINT `reservations_ibfk_1` FOREIGN KEY (`id_assigned_room`) REFERENCES `rooms` (`id_assigned_room`) ON DELETE SET NULL ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
