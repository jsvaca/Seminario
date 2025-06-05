-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`ReferenteCI`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`ReferenteCI` (
  `codReferente` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NULL,
  `telefonoInterno` INT(4) NULL,
  `celular` VARCHAR(15) NULL,
  PRIMARY KEY (`codReferente`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`ComplejoIndustrial`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`ComplejoIndustrial` (
  `CodigoCI` INT NOT NULL,
  `razonSocial` VARCHAR(45) NULL,
  `ubicacion` VARCHAR(45) NULL,
  `codReferente` INT NULL,
  PRIMARY KEY (`CodigoCI`),
  INDEX `referente_idx` (`codReferente` ASC) VISIBLE,
  CONSTRAINT `referente`
    FOREIGN KEY (`codReferente`)
    REFERENCES `mydb`.`ReferenteCI` (`codReferente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`ReferenteProveedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`ReferenteProveedor` (
  `codigoReferente` INT NOT NULL,
  `nombre` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `telefono` VARCHAR(15) NULL,
  PRIMARY KEY (`codigoReferente`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Proveedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Proveedor` (
  `codigoProveedor` INT NOT NULL,
  `razonSocial` VARCHAR(45) NULL,
  `tipoProveedor` VARCHAR(20) NULL,
  `codigoReferente` INT NULL,
  PRIMARY KEY (`codigoProveedor`),
  INDEX `referente_idx` (`codigoReferente` ASC) VISIBLE,
  CONSTRAINT `referenteproveedor`
    FOREIGN KEY (`codigoReferente`)
    REFERENCES `mydb`.`ReferenteProveedor` (`codigoReferente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Cuenca`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Cuenca` (
  `codigoCuenca` INT NOT NULL,
  `denominacion` VARCHAR(45) NULL,
  `sigla` VARCHAR(3) NULL,
  PRIMARY KEY (`codigoCuenca`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`MixCuenca`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`MixCuenca` (
  `codigoProveedor` INT NOT NULL,
  `codigoCuenca` INT NOT NULL,
  `porcentaje` DECIMAL(2) NULL,
  PRIMARY KEY (`codigoProveedor`, `codigoCuenca`),
  INDEX `cuenca_idx` (`codigoCuenca` ASC) VISIBLE,
  CONSTRAINT `proveedor`
    FOREIGN KEY (`codigoProveedor`)
    REFERENCES `mydb`.`Proveedor` (`codigoProveedor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `cuenca`
    FOREIGN KEY (`codigoCuenca`)
    REFERENCES `mydb`.`Cuenca` (`codigoCuenca`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`NominacionTpte`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`NominacionTpte` (
  `numero` INT NOT NULL,
  `fecha` DATE NULL,
  `codigoCI` INT NULL,
  PRIMARY KEY (`numero`),
  INDEX `CI_idx` (`codigoCI` ASC) VISIBLE,
  CONSTRAINT `CI`
    FOREIGN KEY (`codigoCI`)
    REFERENCES `mydb`.`ComplejoIndustrial` (`CodigoCI`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '	';


-- -----------------------------------------------------
-- Table `mydb`.`Contrato`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Contrato` (
  `numeroContrato` INT NOT NULL,
  `codigoCI` INT NULL,
  `codigoProveedor` INT NULL,
  `tipoContrato` VARCHAR(20) NULL,
  `volumenMax` INT NULL,
  `volumenMin` INT NULL,
  `fechaDesde` DATE NULL,
  `fechaHasta` DATE NULL,
  `precio` DECIMAL(4,2) NULL,
  PRIMARY KEY (`numeroContrato`),
  INDEX `complejoInd_idx` (`codigoCI` ASC) VISIBLE,
  INDEX `proveedores_idx` (`codigoProveedor` ASC) VISIBLE,
  CONSTRAINT `complejoInd`
    FOREIGN KEY (`codigoCI`)
    REFERENCES `mydb`.`ComplejoIndustrial` (`CodigoCI`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `proveedores`
    FOREIGN KEY (`codigoProveedor`)
    REFERENCES `mydb`.`Proveedor` (`codigoProveedor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`DetalleNomTpte`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`DetalleNomTpte` (
  `idDetalleNomTpte` INT NOT NULL,
  `numeroNom` INT NULL,
  `prioridad` INT NULL,
  `numeroContrato` INT NULL,
  `volumenSolicitado` INT NULL,
  `codigoProveedor` INT NULL,
  PRIMARY KEY (`idDetalleNomTpte`),
  INDEX `nominacion_idx` (`numeroNom` ASC) VISIBLE,
  INDEX `cont_idx` (`numeroContrato` ASC) VISIBLE,
  INDEX `proveedor_idx` (`codigoProveedor` ASC) VISIBLE,
  CONSTRAINT `nominacionxdetalle`
    FOREIGN KEY (`numeroNom`)
    REFERENCES `mydb`.`NominacionTpte` (`numero`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `contrato`
    FOREIGN KEY (`numeroContrato`)
    REFERENCES `mydb`.`Contrato` (`numeroContrato`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `proveedorxdetalle`
    FOREIGN KEY (`codigoProveedor`)
    REFERENCES `mydb`.`Proveedor` (`codigoProveedor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`nominacionIny`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`nominacionIny` (
  `numeroIny` INT NOT NULL,
  `fecha` DATE NULL,
  `codigoCI` INT NULL,
  PRIMARY KEY (`numeroIny`),
  INDEX `nomCI_idx` (`codigoCI` ASC) VISIBLE,
  CONSTRAINT `nomCI`
    FOREIGN KEY (`codigoCI`)
    REFERENCES `mydb`.`ComplejoIndustrial` (`CodigoCI`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '	';


-- -----------------------------------------------------
-- Table `mydb`.`DetalleNomIny`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`DetalleNomIny` (
  `numeronomIny` INT NOT NULL,
  `numeronom` INT NULL,
  `numeroContrato` INT NULL,
  `codigoProveedor` INT NULL,
  `codigoCuenca` INT NULL,
  `prioridad` INT NULL,
  `volumenSolicitado` INT NULL,
  `volumenAutorizado` INT NULL,
  `tipoGas` VARCHAR(12) NULL,
  `precio` DECIMAL(4,2) NULL,
  PRIMARY KEY (`numeronomIny`),
  INDEX `nominacion_idx` (`numeronom` ASC) VISIBLE,
  INDEX `provedorxcuenca_idx` (`codigoProveedor` ASC, `codigoCuenca` ASC) VISIBLE,
  INDEX `contrato_idx` (`numeroContrato` ASC) VISIBLE,
  CONSTRAINT `nominacion`
    FOREIGN KEY (`numeronom`)
    REFERENCES `mydb`.`nominacionIny` (`numeroIny`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `provedorxcuenca`
    FOREIGN KEY (`codigoProveedor` , `codigoCuenca`)
    REFERENCES `mydb`.`MixCuenca` (`codigoProveedor` , `codigoCuenca`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `contratoxiny`
    FOREIGN KEY (`numeroContrato`)
    REFERENCES `mydb`.`Contrato` (`numeroContrato`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
