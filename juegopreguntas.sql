CREATE DATABASE juegopreguntas;
USE juegopreguntas;

-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 02-11-2022 a las 11:56:59
-- Versión del servidor: 10.4.25-MariaDB
-- Versión de PHP: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `juegopreguntas`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `historial`
--

CREATE TABLE `historial` (
  `ID` smallint(6) NOT NULL,
  `Nombre` varchar(100) NOT NULL,
  `NumCorrectas` smallint(4) NOT NULL,
  `NumTotales` smallint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `historial`
--

INSERT INTO `historial` (`ID`, `Nombre`, `NumCorrectas`, `NumTotales`) VALUES
(13, 'g', 2, 4),
(14, 'f', 2, 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `historialpregunta`
--

CREATE TABLE `historialpregunta` (
  `IDPartida` smallint(6) NOT NULL,
  `IDPregunta` smallint(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `historialpregunta`
--

INSERT INTO `historialpregunta` (`IDPartida`, `IDPregunta`) VALUES
(13, 9),
(13, 10),
(13, 11),
(13, 12),
(14, 9),
(14, 10),
(14, 11),
(14, 12);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pregunta`
--

CREATE TABLE `pregunta` (
  `ID` smallint(4) NOT NULL,
  `Pregunta` varchar(200) NOT NULL,
  `Respuesta1` varchar(200) NOT NULL,
  `Respuesta2` varchar(200) NOT NULL,
  `Respuesta3` varchar(200) NOT NULL,
  `Respuesta4` varchar(200) NOT NULL,
  `RespuestaCorrecta` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `pregunta`
--

INSERT INTO `pregunta` (`ID`, `Pregunta`, `Respuesta1`, `Respuesta2`, `Respuesta3`, `Respuesta4`, `RespuestaCorrecta`) VALUES
(9, '¿Quién es el actual CEO de Microsoft?', 'Phil Spencer', 'Satya Nadella', 'Bill Gates', 'Elon Musk', 2),
(10, '¿Cómo es mundialmente conocido Fernando Alonso?', 'Alonso', 'El nano', 'Alpine', 'El bicho', 2),
(11, 'PreguntaDePruebaEditada', 'Rc', 'RI', 'RI', 'Ri', 1),
(12, 'NuevaPregAñadida', 'RC', 'RI', 'RI', 'RI', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `historial`
--
ALTER TABLE `historial`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `historialpregunta`
--
ALTER TABLE `historialpregunta`
  ADD PRIMARY KEY (`IDPartida`,`IDPregunta`),
  ADD KEY `IDPregunta` (`IDPregunta`);

--
-- Indices de la tabla `pregunta`
--
ALTER TABLE `pregunta`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `historial`
--
ALTER TABLE `historial`
  MODIFY `ID` smallint(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de la tabla `pregunta`
--
ALTER TABLE `pregunta`
  MODIFY `ID` smallint(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `historialpregunta`
--
ALTER TABLE `historialpregunta`
  ADD CONSTRAINT `historialpregunta_ibfk_1` FOREIGN KEY (`IDPartida`) REFERENCES `historial` (`ID`),
  ADD CONSTRAINT `historialpregunta_ibfk_2` FOREIGN KEY (`IDPregunta`) REFERENCES `pregunta` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
