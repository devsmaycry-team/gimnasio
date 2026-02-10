-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 10-02-2026 a las 13:23:22
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `sistema_base`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asistencias`
--

CREATE TABLE `asistencias` (
  `id` bigint(20) NOT NULL,
  `fecha_hora` datetime(6) DEFAULT NULL,
  `tipo` varchar(255) DEFAULT NULL,
  `socio_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clase`
--

CREATE TABLE `clase` (
  `id` bigint(20) NOT NULL,
  `cupo_maximo` int(11) NOT NULL,
  `entrenador_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `dias_rutina`
--

CREATE TABLE `dias_rutina` (
  `id` bigint(20) NOT NULL,
  `dia_semana` varchar(255) DEFAULT NULL,
  `rutina_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ejercicio`
--

CREATE TABLE `ejercicio` (
  `id` bigint(20) NOT NULL,
  `equipo` varchar(255) DEFAULT NULL,
  `grupo_mucular` varchar(255) DEFAULT NULL,
  `imagen_url` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `video_url` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `entrenador`
--

CREATE TABLE `entrenador` (
  `id` bigint(20) NOT NULL,
  `especialidad` varchar(255) DEFAULT NULL,
  `matricula` varchar(255) DEFAULT NULL,
  `usuario_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `horarios_clases`
--

CREATE TABLE `horarios_clases` (
  `id` bigint(20) NOT NULL,
  `dia_semana` varchar(255) DEFAULT NULL,
  `hora_fin` date DEFAULT NULL,
  `hora_inicio` date DEFAULT NULL,
  `clase_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inscripcion_clases`
--

CREATE TABLE `inscripcion_clases` (
  `id` bigint(20) NOT NULL,
  `horarios_clases_id` bigint(20) DEFAULT NULL,
  `socio_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mediciones`
--

CREATE TABLE `mediciones` (
  `id` bigint(20) NOT NULL,
  `brazos` double DEFAULT NULL,
  `fecha` datetime(6) DEFAULT NULL,
  `grasa_corporal` double DEFAULT NULL,
  `pecho` double DEFAULT NULL,
  `peso` double DEFAULT NULL,
  `socio_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `membresia`
--

CREATE TABLE `membresia` (
  `id` bigint(20) NOT NULL,
  `estado` bit(1) NOT NULL,
  `fecha_fin` datetime(6) DEFAULT NULL,
  `fecha_inicio` datetime(6) DEFAULT NULL,
  `plan_id` bigint(20) DEFAULT NULL,
  `socio_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pagos`
--

CREATE TABLE `pagos` (
  `id` bigint(20) NOT NULL,
  `fecha` datetime(6) DEFAULT NULL,
  `metodo_pago` varchar(255) DEFAULT NULL,
  `monto` double NOT NULL,
  `referencia` varchar(255) DEFAULT NULL,
  `membresia_id` bigint(20) DEFAULT NULL,
  `socio_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE `persona` (
  `id` bigint(20) NOT NULL,
  `apellido` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `celular` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`id`, `apellido`, `nombre`, `celular`) VALUES
(1, 'Pérez', 'Juan', '1123456789'),
(2, 'González', 'María', '2994457788'),
(3, 'Fernández', 'Lucas', '3516678899'),
(4, 'Garnica', 'Facundo', '2216272337'),
(5, 'Pérez', 'Juan', '123456789'),
(6, 'ribia', 'geralt', '1234'),
(7, 'Garnica', 'Facundo', '1234');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `plan`
--

CREATE TABLE `plan` (
  `id` bigint(20) NOT NULL,
  `clases_incluidas` int(11) NOT NULL,
  `duracion_dias` int(11) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `precio` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `registro_ejercicio`
--

CREATE TABLE `registro_ejercicio` (
  `id` bigint(20) NOT NULL,
  `observacion` varchar(255) DEFAULT NULL,
  `peso_real` double DEFAULT NULL,
  `repeticiones_hechas` int(11) NOT NULL,
  `series_hechas` int(11) NOT NULL,
  `ejercicio_id` bigint(20) DEFAULT NULL,
  `rutina_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

CREATE TABLE `rol` (
  `id` bigint(20) NOT NULL,
  `cargo` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `rol`
--

INSERT INTO `rol` (`id`, `cargo`) VALUES
(1, 'ROLE_ADMIN'),
(2, 'ROLE_CLIENTE');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rutina`
--

CREATE TABLE `rutina` (
  `id` bigint(20) NOT NULL,
  `duracion_semanas` varchar(255) DEFAULT NULL,
  `editable` bit(1) NOT NULL,
  `estado` bit(1) NOT NULL,
  `nivel` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `objetivo` varchar(255) DEFAULT NULL,
  `entrenador_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rutina_ejercicio`
--

CREATE TABLE `rutina_ejercicio` (
  `id` bigint(20) NOT NULL,
  `descanso_seg` varchar(255) DEFAULT NULL,
  `peso_objetivo` varchar(255) DEFAULT NULL,
  `repeticiones` int(11) NOT NULL,
  `series` int(11) NOT NULL,
  `dias_rutina_id` bigint(20) DEFAULT NULL,
  `ejercicio_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `socio`
--

CREATE TABLE `socio` (
  `id` bigint(20) NOT NULL,
  `numero_socio` bigint(20) DEFAULT NULL,
  `observacion_medica` varchar(255) DEFAULT NULL,
  `usuario_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user_rol`
--

CREATE TABLE `user_rol` (
  `id` bigint(20) NOT NULL,
  `rol_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `user_rol`
--

INSERT INTO `user_rol` (`id`, `rol_id`, `user_id`) VALUES
(7, 1, 7);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id` bigint(20) NOT NULL,
  `activo` bit(1) DEFAULT NULL,
  `correo` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `persona_id` bigint(20) DEFAULT NULL,
  `verification_token` varchar(255) DEFAULT NULL,
  `reset_password_token` varchar(255) DEFAULT NULL,
  `reset_password_token_expira` datetime(6) DEFAULT NULL,
  `verification_token_expira` datetime(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `activo`, `correo`, `password`, `persona_id`, `verification_token`, `reset_password_token`, `reset_password_token_expira`, `verification_token_expira`) VALUES
(7, b'1', 'facundogarnica1996@gmail.com', '$2a$10$ScitdDC0DOlftWD1E2DhJuu4xRvHPcV66csQa/Z1NvDttxox0zsAO', 7, NULL, NULL, NULL, NULL);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `asistencias`
--
ALTER TABLE `asistencias`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK31s9xcjf9jfgsmcrx89ba4r8i` (`socio_id`);

--
-- Indices de la tabla `clase`
--
ALTER TABLE `clase`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKbu5yajln47iild7uv753bvxp1` (`entrenador_id`);

--
-- Indices de la tabla `dias_rutina`
--
ALTER TABLE `dias_rutina`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK2hb7di2b7ijf1h6ocpsegfc8x` (`rutina_id`);

--
-- Indices de la tabla `ejercicio`
--
ALTER TABLE `ejercicio`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `entrenador`
--
ALTER TABLE `entrenador`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKop1450umoubj72mrq4mnlnjou` (`usuario_id`);

--
-- Indices de la tabla `horarios_clases`
--
ALTER TABLE `horarios_clases`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKsst6uk8xuho178h66ut96ym0v` (`clase_id`);

--
-- Indices de la tabla `inscripcion_clases`
--
ALTER TABLE `inscripcion_clases`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKbm34ede61bnrth93nrfubhaw3` (`horarios_clases_id`),
  ADD KEY `FKktk1a0ril6i8qp2ot0hqadaoy` (`socio_id`);

--
-- Indices de la tabla `mediciones`
--
ALTER TABLE `mediciones`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK8klyl9ji0uyfqmynoi0dgsxh3` (`socio_id`);

--
-- Indices de la tabla `membresia`
--
ALTER TABLE `membresia`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKn14t9ao1y90cbdvw78kug7ev6` (`plan_id`),
  ADD KEY `FKd0nvfxfjs16hmpnju7g9gkmv7` (`socio_id`);

--
-- Indices de la tabla `pagos`
--
ALTER TABLE `pagos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK9r0f4khl3m8gsdo97aiy49612` (`membresia_id`),
  ADD KEY `FKnyr3y9buopiwnab89ybqi3e8m` (`socio_id`);

--
-- Indices de la tabla `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `plan`
--
ALTER TABLE `plan`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `registro_ejercicio`
--
ALTER TABLE `registro_ejercicio`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKn90laj7hrj08w39aqoqiu6u64` (`ejercicio_id`),
  ADD KEY `FK1rn172e789u3odlbluyvtb667` (`rutina_id`);

--
-- Indices de la tabla `rol`
--
ALTER TABLE `rol`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `rutina`
--
ALTER TABLE `rutina`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKh57ru70mxydioqe300pxo481g` (`entrenador_id`);

--
-- Indices de la tabla `rutina_ejercicio`
--
ALTER TABLE `rutina_ejercicio`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKj14rglipowygw581dt2te2385` (`dias_rutina_id`),
  ADD KEY `FK7v0s69x4cxrhdsx7hj1gnj858` (`ejercicio_id`);

--
-- Indices de la tabla `socio`
--
ALTER TABLE `socio`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKfdj8erxkmnd66pjnkf54wajeh` (`usuario_id`);

--
-- Indices de la tabla `user_rol`
--
ALTER TABLE `user_rol`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKpfraq7jod5w5xd3sxm3m6y1o` (`rol_id`),
  ADD KEY `FKggmqnaahwf98dagwnykujimtt` (`user_id`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKlse7lqghmt3r1sp298ss9s5bc` (`persona_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `asistencias`
--
ALTER TABLE `asistencias`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `clase`
--
ALTER TABLE `clase`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `dias_rutina`
--
ALTER TABLE `dias_rutina`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `ejercicio`
--
ALTER TABLE `ejercicio`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `entrenador`
--
ALTER TABLE `entrenador`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `horarios_clases`
--
ALTER TABLE `horarios_clases`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `inscripcion_clases`
--
ALTER TABLE `inscripcion_clases`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `mediciones`
--
ALTER TABLE `mediciones`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `membresia`
--
ALTER TABLE `membresia`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `pagos`
--
ALTER TABLE `pagos`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `persona`
--
ALTER TABLE `persona`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `plan`
--
ALTER TABLE `plan`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `registro_ejercicio`
--
ALTER TABLE `registro_ejercicio`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `rol`
--
ALTER TABLE `rol`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `rutina`
--
ALTER TABLE `rutina`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `rutina_ejercicio`
--
ALTER TABLE `rutina_ejercicio`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `socio`
--
ALTER TABLE `socio`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `user_rol`
--
ALTER TABLE `user_rol`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `asistencias`
--
ALTER TABLE `asistencias`
  ADD CONSTRAINT `FK31s9xcjf9jfgsmcrx89ba4r8i` FOREIGN KEY (`socio_id`) REFERENCES `socio` (`id`);

--
-- Filtros para la tabla `clase`
--
ALTER TABLE `clase`
  ADD CONSTRAINT `FKbu5yajln47iild7uv753bvxp1` FOREIGN KEY (`entrenador_id`) REFERENCES `entrenador` (`id`);

--
-- Filtros para la tabla `dias_rutina`
--
ALTER TABLE `dias_rutina`
  ADD CONSTRAINT `FK2hb7di2b7ijf1h6ocpsegfc8x` FOREIGN KEY (`rutina_id`) REFERENCES `rutina` (`id`);

--
-- Filtros para la tabla `entrenador`
--
ALTER TABLE `entrenador`
  ADD CONSTRAINT `FKop1450umoubj72mrq4mnlnjou` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`);

--
-- Filtros para la tabla `horarios_clases`
--
ALTER TABLE `horarios_clases`
  ADD CONSTRAINT `FKsst6uk8xuho178h66ut96ym0v` FOREIGN KEY (`clase_id`) REFERENCES `clase` (`id`);

--
-- Filtros para la tabla `inscripcion_clases`
--
ALTER TABLE `inscripcion_clases`
  ADD CONSTRAINT `FKbm34ede61bnrth93nrfubhaw3` FOREIGN KEY (`horarios_clases_id`) REFERENCES `horarios_clases` (`id`),
  ADD CONSTRAINT `FKktk1a0ril6i8qp2ot0hqadaoy` FOREIGN KEY (`socio_id`) REFERENCES `socio` (`id`);

--
-- Filtros para la tabla `mediciones`
--
ALTER TABLE `mediciones`
  ADD CONSTRAINT `FK8klyl9ji0uyfqmynoi0dgsxh3` FOREIGN KEY (`socio_id`) REFERENCES `socio` (`id`);

--
-- Filtros para la tabla `membresia`
--
ALTER TABLE `membresia`
  ADD CONSTRAINT `FKd0nvfxfjs16hmpnju7g9gkmv7` FOREIGN KEY (`socio_id`) REFERENCES `socio` (`id`),
  ADD CONSTRAINT `FKn14t9ao1y90cbdvw78kug7ev6` FOREIGN KEY (`plan_id`) REFERENCES `plan` (`id`);

--
-- Filtros para la tabla `pagos`
--
ALTER TABLE `pagos`
  ADD CONSTRAINT `FK9r0f4khl3m8gsdo97aiy49612` FOREIGN KEY (`membresia_id`) REFERENCES `membresia` (`id`),
  ADD CONSTRAINT `FKnyr3y9buopiwnab89ybqi3e8m` FOREIGN KEY (`socio_id`) REFERENCES `socio` (`id`);

--
-- Filtros para la tabla `registro_ejercicio`
--
ALTER TABLE `registro_ejercicio`
  ADD CONSTRAINT `FK1rn172e789u3odlbluyvtb667` FOREIGN KEY (`rutina_id`) REFERENCES `rutina` (`id`),
  ADD CONSTRAINT `FKn90laj7hrj08w39aqoqiu6u64` FOREIGN KEY (`ejercicio_id`) REFERENCES `ejercicio` (`id`);

--
-- Filtros para la tabla `rutina`
--
ALTER TABLE `rutina`
  ADD CONSTRAINT `FKh57ru70mxydioqe300pxo481g` FOREIGN KEY (`entrenador_id`) REFERENCES `entrenador` (`id`);

--
-- Filtros para la tabla `rutina_ejercicio`
--
ALTER TABLE `rutina_ejercicio`
  ADD CONSTRAINT `FK7v0s69x4cxrhdsx7hj1gnj858` FOREIGN KEY (`ejercicio_id`) REFERENCES `ejercicio` (`id`),
  ADD CONSTRAINT `FKj14rglipowygw581dt2te2385` FOREIGN KEY (`dias_rutina_id`) REFERENCES `dias_rutina` (`id`);

--
-- Filtros para la tabla `socio`
--
ALTER TABLE `socio`
  ADD CONSTRAINT `FKfdj8erxkmnd66pjnkf54wajeh` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`);

--
-- Filtros para la tabla `user_rol`
--
ALTER TABLE `user_rol`
  ADD CONSTRAINT `FKggmqnaahwf98dagwnykujimtt` FOREIGN KEY (`user_id`) REFERENCES `usuario` (`id`),
  ADD CONSTRAINT `FKpfraq7jod5w5xd3sxm3m6y1o` FOREIGN KEY (`rol_id`) REFERENCES `rol` (`id`);

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `FKlse7lqghmt3r1sp298ss9s5bc` FOREIGN KEY (`persona_id`) REFERENCES `persona` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
