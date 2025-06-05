-- -----------------------------------------------------
-- Datos tabla ReferentesCI
-- -----------------------------------------------------

INSERT INTO mydb.referenteci (codreferente, nombre, email, telefonoInterno, celular) VALUES
(1, 'Carlos Gomez', 'carlos.gomez@andor.com', 3482, '116789012'), -- Buenos Aires
(2, 'Mariana Lopez', 'mariana.lopez@andor.com', 5821, '2616789013'), -- Mendoza
(3, 'Jorge Fernandez', 'jorge.fernandez@andor.com', 4176, '3416789014'), -- Rosario (Santa Fe)
(4, 'Sofia Rodriguez', 'sofia.rodriguez@andor.com', 9254, '3516789015'), -- Córdoba
(5, 'Lucas Alvarez', 'lucas.alvarez@andor.com', 7361, '3816789016'), -- Tucumán
(6, 'Fernanda Morales', 'fernanda.morales@andor.com', 1039, '2996789017'), -- Neuquén
(7, 'Martin Castro', 'martin.castro@andor.com', 8973, '3796789018'), -- Corrientes
(8, 'Valentina Ruiz', 'valentina.ruiz@andor.com', 2567, '2946789019'), -- Bariloche (Río Negro)
(9, 'Alejandro Peña', 'alejandro.pena@andor.com', 6748, '3876789020'), -- Salta
(10, 'Natalia Soto', 'natalia.soto@andor.com', 4820, '2956789021'), -- La Pampa
(11, 'Hector Bustos', 'hector.bustos@andor.com', 3915, '2646789022'), -- San Juan
(12, 'Camila Espinoza', 'camila.espinoza@andor.com', 7639, '2216789023'), -- La Plata (Buenos Aires)
(13, 'Rodrigo Vera', 'rodrigo.vera@andor.com', 2158, '3856789024'), -- Santiago del Estero
(14, 'Andrea Meza', 'andrea.meza@andor.com', 5290, '3756789025'), -- Misiones
(15, 'Ignacio Fuentes', 'ignacio.fuentes@andor.com', 6374, '3486789026'), -- San Nicolás (Buenos Aires)
(16, 'Paula Herrera', 'paula.herrera@andor.com', 4528, '3436789027'), -- Entre Ríos
(17, 'Esteban Cabrera', 'esteban.cabrera@andor.com', 9812, '2966789028'), -- Santa Cruz
(18, 'Romina Paredes', 'romina.paredes@andor.com', 7235, '2806789029'), -- Chubut
(19, 'Diego Navarro', 'diego.navarro@andor.com', 8496, '2326789030'), -- Mercedes (Buenos Aires)
(20, 'Lorena Rojas', 'lorena.rojas@andor.com', 3127, '3836789031'); -- Catamarca

-- -----------------------------------------------------
-- Datos tabla ReferentesProveedores
-- -----------------------------------------------------

INSERT INTO mydb.referenteproveedor (codigoreferente, nombre, email, telefono) VALUES
(1, 'Juan Pérez', 'juan.perez@gasnor.com.ar', '3816789012'),
(2, 'María Rodríguez', 'maria.rodriguez@metrogas.com.ar', '1167890123'),
(3, 'Carlos Fernández', 'carlos.fernandez@naturgy.com.ar', '114567890123'),
(4, 'Ana Gómez', 'ana.gomez@camuzzi.com.ar', '29546789012'),
(5, 'Ricardo López', 'ricardo.lopez@distribuidoranorte.com.ar', '387678901234'),
(6, 'Lorena Suárez', 'lorena.suarez@redengas.com.ar', '34367890123'),
(7, 'Martín Castillo', 'martin.castillo@ecoigas.com.ar', '261678901234'),
(8, 'Sandra Torres', 'sandra.torres@gaspamp.com.ar', '29547890123'),
(9, 'Diego Herrera', 'diego.herrera@ecogas.com.ar', '35167890123'),
(10, 'Romina Vargas', 'romina.vargas@naturgy.com.ar', '112345678901'),
(11, 'Guillermo Acosta', 'guillermo.acosta@camuzzi.com.ar', '29956789012'),
(12, 'Laura Medina', 'laura.medina@metrogas.com.ar', '11678901234'),
(13, 'Fernando Ríos', 'fernando.rios@redengas.com.ar', '343678901234'),
(14, 'Paola Cáceres', 'paola.caceres@gaspamp.com.ar', '295467890123'),
(15, 'Javier Molina', 'javier.molina@ecoigas.com.ar', '26167890123'),
(16, 'Valeria Peralta', 'valeria.peralta@naturgy.com.ar', '114567890123'),
(17, 'Esteban Funes', 'esteban.funes@camuzzi.com.ar', '299678901234'),
(18, 'Verónica Vázquez', 'veronica.vazquez@ecogas.com.ar', '351678901234'),
(19, 'Hernán Ortega', 'hernan.ortega@distribuidoranorte.com.ar', '38767890123'),
(20, 'Liliana Campos', 'liliana.campos@metrogas.com.ar', '116789012345');

-- -----------------------------------------------------
-- Datos tabla Cuenca
-- -----------------------------------------------------

INSERT INTO `mydb`.`cuenca` (`codigoCuenca`, `denominacion`, `sigla`) VALUES 
('1', 'Norte', 'NOA'),
('2', 'Neuquina', 'NQN').
('3', 'Tierra del Fuego', 'TDF'),
('4', 'Santa Cruz', 'SRC'),
('5', 'Chubut', 'CHU');

-- -----------------------------------------------------
-- Datos tabla ComplejoIndustrial
-- -----------------------------------------------------

INSERT INTO mydb.complejoindustrial (codigoci, razonSocial, ubicacion, codReferente) VALUES
(1001, 'Andor S.A. - Complejo Buenos Aires', 'Buenos Aires', 5),
(1002, 'Andor S.A. - Complejo Córdoba', 'Córdoba', 12),
(1003, 'Andor S.A. - Complejo Patagónico', 'Bariloche', 8),
(1004, 'Andor S.A. - Complejo Mendoza', 'Mendoza', 17),
(1005, 'Andor S.A. - Complejo Rosario', 'Rosario', 3),
(1006, 'Andor S.A. - Complejo NOA', 'Salta', 19),
(1007, 'Andor S.A. - Complejo Litoral', 'Santa Fe', 1),
(1008, 'Andor S.A. - Complejo Austral', 'Ushuaia', 14),
(1009, 'Andor S.A. - Complejo Tucumano', 'San Miguel de Tucumán', 9),
(1010, 'Andor S.A. - Complejo Pampeano', 'La Pampa', 6),
(1011, 'Andor S.A. - Complejo Chaco', 'Resistencia', 11),
(1012, 'Andor S.A. - Complejo Entre Ríos', 'Paraná', 4),
(1013, 'Andor S.A. - Complejo Formosa', 'Formosa', 18),
(1014, 'Andor S.A. - Complejo Misiones', 'Posadas', 7),
(1015, 'Andor S.A. - Complejo San Juan', 'San Juan', 15),
(1016, 'Andor S.A. - Complejo Neuquén', 'Neuquén', 10),
(1017, 'Andor S.A. - Complejo San Luis', 'San Luis', 2),
(1018, 'Andor S.A. - Complejo Catamarca', 'Catamarca', 16),
(1019, 'Andor S.A. - Complejo Río Negro', 'Viedma', 13),
(1020, 'Andor S.A. - Complejo Jujuy', 'San Salvador de Jujuy', 20);17:12 17/5/2025

-- -----------------------------------------------------
-- Datos tabla ComplejoIndustrial
-- -----------------------------------------------------

INSERT INTO proveedor (codigoproveedor, razonsocial, tipoproveedor, codigoreferente) VALUES
(2001, 'Gas Natural BAN S.A.', 'Distribuidora', 5),
(2002, 'Metrogas S.A.', 'Distribuidora', 12),
(2003, 'Camuzzi Gas Pampeana S.A.', 'Distribuidora', 8),
(2004, 'Camuzzi Gas del Sur S.A.', 'Distribuidora', 17),
(2005, 'Distribuidora de Gas del Centro S.A.', 'Distribuidora', 3),
(2006, 'Litoral Gas S.A.', 'Distribuidora', 19),
(2007, 'Gasnor S.A.', 'Distribuidora', 1),
(2008, 'Transportadora de Gas del Norte S.A.', 'Transportista', 14),
(2009, 'Transportadora de Gas del Sur S.A.', 'Transportista', 9),
(2010, 'Enarsa - Integración Energética', 'Comercializadora', 6),
(2011, 'YPF Gas', 'Comercializadora', 11),
(2012, 'Pampa Energía S.A.', 'Comercializadora', 4),
(2013, 'Gas Patagonia S.A.', 'Comercializadora', 18),
(2014, 'GASNOR Comercialización', 'Comercializadora', 7),
(2015, 'Roch S.A.', 'Comercializadora', 15),
(2016, 'Total Austral S.A.', 'Comercializadora', 10),
(2017, 'Refinor S.A.', 'Comercializadora', 2),
(2018, 'Pluspetrol S.A.', 'Comercializadora', 16),
(2019, 'TGN Comercialización S.A.', 'Comercializadora', 13),
(2020, 'TGS Comercialización S.A.', 'Comercializadora', 20);

-- -----------------------------------------------------
-- Datos tabla mixCuenca
-- -----------------------------------------------------

INSERT INTO mixcuenca (codigoproveedor, codigocuenca, porcentaje) VALUES
(2001, 1, 40),
(2001, 2, 60),
(2002, 2, 50),
(2002, 4, 30),
(2002, 5, 20),
(2003, 2, 30),
(2003, 3, 40),
(2003, 5, 30),
(2004, 4, 25),
(2004, 5, 35),
(2004, 2, 40),
(2005, 1, 50),
(2005, 2, 50),
(2006, 1, 40),
(2006, 4, 30),
(2006, 3, 30),
(2007, 1, 70),
(2007, 2, 30);

-- -----------------------------------------------------
-- Datos tabla contrato
-- -----------------------------------------------------

INSERT INTO contrato (numerocontrato, tipoContrato, codigoproveedor, codigoci, fechadesde, fechahasta, precio, volumenmin, volumenmax) VALUES
(1, 'Firme', 2001, 1001, '2024-01-01', '2025-12-31', 3.50, 15000, 45000),
(2, 'City Gate', 2002, 1002, '2023-07-15', '2025-06-30', 3.75, 20000, 55000),
(3, 'Interrumpible', 2003, 1003, '2024-03-01', '2026-02-28', 4.00, 18000, 48000),
(4, 'Firme', 2004, 1004, '2023-09-01', '2025-08-31', 3.80, 16000, 42000),
(5, 'Firme', 2005, 1005, '2024-05-10', '2026-04-30', 4.10, 25000, 60000),
(6, 'Firme', 2006, 1006, '2023-12-01', '2025-11-30', 3.60, 15500, 43500),
(7, 'Firme', 2007, 1007, '2024-06-01', '2026-05-31', 3.90, 23000, 52000),
(8, 'City Gate', 2008, 1008, '2023-10-01', '2025-09-30', 4.20, 27000, 57000),
(9, 'Firme', 2009, 1009, '2024-02-01', '2026-01-31', 3.95, 19000, 46000),
(10, 'Firme', 2010, 1010, '2023-08-01', '2025-07-31', 4.25, 24000, 56000);

-- -----------------------------------------------------
-- Datos tabla nominacionTpte
-- -----------------------------------------------------

INSERT INTO nominaciontpte (numero, fecha, codigoci) VALUES
(1, '2025-05-19', 1001),
(2, '2025-05-19', 1002),
(3, '2025-05-19', 1003),
(4, '2025-05-19', 1004),
(5, '2025-05-19', 1005),
(6, '2025-05-20', 1001),
(7, '2025-05-20', 1002),
(8, '2025-05-20', 1003),
(9, '2025-05-20', 1004),
(10, '2025-05-21', 1005),
(11, '2025-05-22', 1006),
(12, '2025-05-22', 1007),
(13, '2025-05-22', 1014),
(14, '2025-05-20', 1012),
(15, '2025-05-20', 1013),
(16, '2025-05-25', 1020),
(17, '2025-05-30', 1015),
(18, '2025-05-26', 1016),
(19, '2025-05-24', 1008),
(20, '2025-05-24', 1009);

-- -----------------------------------------------------
-- Datos tabla nominacionIny
-- -----------------------------------------------------

INSERT INTO nominacioniny (numeroIny, fecha, codigoci) VALUES
(1, '2025-05-19', 1001),
(2, '2025-05-19', 1002),
(3, '2025-05-19', 1003),
(4, '2025-05-19', 1004),
(5, '2025-05-19', 1005),
(6, '2025-05-20', 1001),
(7, '2025-05-20', 1002),
(8, '2025-05-20', 1003),
(9, '2025-05-20', 1004),
(10, '2025-05-21', 1005),
(11, '2025-05-22', 1006),
(12, '2025-05-22', 1007),
(13, '2025-05-22', 1014),
(14, '2025-05-20', 1012),
(15, '2025-05-20', 1013),
(16, '2025-05-25', 1020),
(17, '2025-05-30', 1015),
(18, '2025-05-26', 1016),
(19, '2025-05-24', 1008),
(20, '2025-05-24', 1009);

-- -----------------------------------------------------
-- Datos tabla detalleNonTpte
-- -----------------------------------------------------

INSERT INTO detallenomtpte (idDetalleNomTpte, numeroNom, prioridad, numeroContrato, volumenSolicitado, codigoProveedor) VALUES
(1, 1, 1, 1, 10000, 2001),
(2, 2, 1, 2, 20000, 2005),
(3, 3, 1, 3, 25000, 2010),
(4, 4, 1, 4, 15000, 2020),
(5, 5, 1, 5, 45000, 2002),
(6, 6, 1, 6, 50000, 2019),
(7, 7, 1, 7, 5000, 2003),
(8, 8, 1, 8, 7000, 2018),
(9, 9, 1, 9, 55000, 2004),
(10, 10, 1, 10, 7000, 2017),
(11, 11, 1, 11, 3000, 2006),
(12, 12, 1, 12, 25000, 2016),
(13, 13, 1, 13, 70000, 2007),
(14, 14, 1, 14, 150000, 2015),
(15, 15, 1, 15, 120000, 2008),
(16, 16, 1, 16, 850000, 2014),
(17, 17, 1, 17, 90000, 2009),
(18, 18, 1, 18, 8000, 2013),
(19, 19, 1, 19, 10000, 2011),
(20, 20, 1, 20, 10000, 2012);

-- -----------------------------------------------------
-- Datos tabla detalleNonTpte
-- -----------------------------------------------------

INSERT INTO detallenominy (numeronomIny, numeronom, numeroContrato, codigoProveedor, codigoCuenca, 
prioridad, volumenSolicitado, volumenAutorizado, tipoGas,precio) VALUES
(1, 1, 1, 2001, 1, 1, 10000, 10000, 'Firme', 2.05),
(2, 2, 2, 2002, 2, 1, 20000, 10000, 'Firme', 4.66),
(3, 3, 3, 2003, 3, 1, 25000, 10000, 'Spot', 3.57),
(4, 4, 4, 2004, 4, 1, 15000, 10000, 'Firme', 2.05),
(5, 5, 5, 2005, 5, 1, 45000, 10000, 'Firme', 1.99),
(6, 6, 6, 2006, 1, 1, 50000, 10000, 'Firme', 3.85),
(7, 7, 7, 2007, 2, 1, 5000, 10000, 'Spot', 3.64),
(8, 8, 8, 2008, 3, 1, 7000, 10000, 'Firme', 3.52),
(9, 9, 9, 2009, 4, 1, 55000, 10000, 'Firme', 4.55),
(10, 10, 10, 2010, 5, 1, 7000, 10000, 'Spot', 4.20),
(11, 11, 1, 2011, 1, 1, 3000, 10000, 'Firme', 2.30),
(12, 12, 2, 2012, 2, 1, 25000, 10000, 'Firme', 2.75),
(13, 13, 3, 2013, 3, 1, 70000, 10000, 'Firme', 1.99),
(14, 14, 4, 2014, 4, 1, 150000, 10000, 'Spot', 2.02),
(15, 15, 5, 2015, 5, 1, 120000, 10000, 'Firme', 3.46),
(16, 16, 6, 2016, 1, 1, 85000, 10000, 'Firme', 4.45),
(17, 17, 7, 2017, 2, 1, 90000, 10000, 'Spot', 3.68),
(18, 18, 8, 2018, 3, 1, 8000, 10000, 'Firme', 5.26),
(19, 19, 9, 2019, 4, 1, 10000, 10000, 'Firme', 2.33),
(20, 20, 10, 2020, 5, 1, 10000, 10000, 'Spot', 2.45);

