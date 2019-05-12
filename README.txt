-------------------------------------------------------------------------------------
----------------------------- BASE DE DATOS -----------------------------------------
-------------------------------------------------------------------------------------

EJECUTAR SENTENCIAS SQL

* MOTOR USADO MYSQL


CREATE TABLE `cliente` (
  `idCliente` int(11) NOT NULL,
  `nombre` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `apellido1` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `apellido2` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `observaciones` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`idCliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci


CREATE TABLE `factura` (
  `idFactura` int(11) NOT NULL,
  `idCliente` int(11) DEFAULT NULL,
  `idCamarero` int(11) DEFAULT NULL,
  `idMesa` int(11) DEFAULT NULL,
  `fechaFactura` date DEFAULT NULL,
  PRIMARY KEY (`idFactura`),
  KEY `factura_fk_4` (`idCamarero`),
  KEY `factura_fk_2` (`idCliente`),
  KEY `factura_fk_3` (`idMesa`),
  CONSTRAINT `factura_fk` FOREIGN KEY (`idFactura`) REFERENCES `detallefactura` (`iddetallefactura`),
  CONSTRAINT `factura_fk_2` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idcliente`),
  CONSTRAINT `factura_fk_3` FOREIGN KEY (`idMesa`) REFERENCES `mesa` (`idmesa`),
  CONSTRAINT `factura_fk_4` FOREIGN KEY (`idCamarero`) REFERENCES `camarero` (`idcamarero`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci


CREATE TABLE `camarero` (
  `idCamarero` int(11) NOT NULL,
  `nombre` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `apellido1` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `apellido2` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`idCamarero`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci


CREATE TABLE `mesa` (
  `idMesa` int(11) NOT NULL,
  `numeroMaxComensales` int(11) DEFAULT NULL,
  `ubicacion` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`idMesa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='		'


CREATE TABLE `detallefactura` (
  `idDetalleFactura` int(11) NOT NULL AUTO_INCREMENT,
  `idFactura` int(11) DEFAULT NULL,
  `idCocinero` int(11) DEFAULT NULL,
  `plato` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `importe` double DEFAULT NULL,
  PRIMARY KEY (`idDetalleFactura`),
  KEY `detallefactura_fk` (`idCocinero`),
  KEY `detallefactura_fk_1` (`idFactura`),
  CONSTRAINT `detallefactura_fk` FOREIGN KEY (`idCocinero`) REFERENCES `cocinero` (`idcocinero`) ON UPDATE CASCADE,
  CONSTRAINT `detallefactura_fk_1` FOREIGN KEY (`idFactura`) REFERENCES `factura` (`idfactura`)
) ENGINE=InnoDB AUTO_INCREMENT=465457 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='		'


CREATE TABLE `cocinero` (
  `idCocinero` int(11) NOT NULL,
  `nombre` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `apellido1` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `apellido2` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`idCocinero`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci



insert into camarero values (1234, 'Carlos', 'Bedoya', 'Ramirez');
insert into camarero values (5678, 'Luis', 'Rojas', 'Boyaca');
insert into camarero values (91011, 'Pedro', 'Galicia', 'Rodriguez');
insert into camarero values (91213, 'Jose', 'Bedoya', 'Gil');

insert into mesa values (1, 5, 'ventana');
insert into mesa values (2, 4, 'pasillo');
insert into mesa values (3, 2, 'centro');
insert into mesa values (4, 3, 'pared lateral izquierda');

insert into cocinero values (55554, 'Eduard', 'Pereira', 'Nada');
insert into cocinero values (96965, 'Luis', 'Cocinero', 'Profesional');
insert into cocinero values (12023, 'Leonor', 'Ruiz', 'Leon');
insert into cocinero values (12345, 'Luisa', 'Tyson', 'Mosquera');

-------------------------------------------------------------------------------------
----------------------------- EJECUCION DE LA APLICACION ----------------------------
-------------------------------------------------------------------------------------

-------------------------------------------------------------------------------------
---- DESCARGAR FUENTE GIT -----------------------------------------------------------
-------------------------------------------------------------------------------------

SE DEBE DESCARGAR LOS FUENTES DE GIT

RUTA : https://github.com/CbedoyaRamirez/conexiaprueba.git

--------------------------------------------------------------------------------------
------ CAMBIO DE NOMBRE URL ----------------------------------------------------------
--------------------------------------------------------------------------------------

Al momento de ejecutar la aplicacion, se abrira con la siguiente URL

http://localhost:8080/lamejorcocina-web-1.0.0

Cambiarla por :

http://localhost:8080/lamejorcocina/


