
CREATE SCHEMA IF NOT EXISTS `controlminio` DEFAULT CHARACTER SET utf8 ;
USE `controlminio` ;

-- -----------------------------------------------------
-- Table `controlminio`.`Condominio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `controlminio`.`Condominio` (
  `idCondominio` INT NOT NULL AUTO_INCREMENT,
  `endereco` VARCHAR(255) NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `cidade` VARCHAR(45) NOT NULL,
  `bairro` VARCHAR(45) NOT NULL,
  `numero` INT NOT NULL,
  PRIMARY KEY (`idCondominio`));


-- -----------------------------------------------------
-- Table `controlminio`.`Edificio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `controlminio`.`Edificio` (
  `idEdificio` INT NOT NULL AUTO_INCREMENT,
  `numero` INT NOT NULL,
  `cor` VARCHAR(45) NOT NULL,
  `quantidadeAndar` INT NOT NULL,
  `idCondominio` INT NOT NULL,
  PRIMARY KEY (`idEdificio`),
  INDEX `FK_Condominio_idCondominio_idx` (`idCondominio` ASC),
  CONSTRAINT `FK_Condominio_idCondominio`
    FOREIGN KEY (`idCondominio`)
    REFERENCES `controlminio`.`Condominio` (`idCondominio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `controlminio`.`Pessoa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `controlminio`.`Pessoa` (
  `idPessoa` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `cpf` CHAR(11) NOT NULL,
  `rg` VARCHAR(15) NOT NULL,
  `sexo` ENUM('M', 'F') NOT NULL,
  `nascimento` DATE NOT NULL,
  `idApartamento` INT NULL,
  PRIMARY KEY (`idPessoa`),
  INDEX `FK_Apartamento_idApartamento_idx` (`idApartamento` ASC));


-- -----------------------------------------------------
-- Table `controlminio`.`Apartamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `controlminio`.`Apartamento` (
  `idApartamento` INT NOT NULL AUTO_INCREMENT,
  `idEdificio` INT NOT NULL,
  `andar` INT NOT NULL,
  `numero` INT NOT NULL,
  `tipo` ENUM('PADRAO', 'LUXO') NOT NULL,
  `idProprietario` INT NULL,
  PRIMARY KEY (`idApartamento`),
  INDEX `FK_Edificio_idEdificio_idx` (`idEdificio` ASC),
  INDEX `FK_Pessoa_idProprietario_idx` (`idProprietario` ASC),
  CONSTRAINT `FK_Edificio_idEdificio`
    FOREIGN KEY (`idEdificio`)
    REFERENCES `controlminio`.`Edificio` (`idEdificio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_Pessoa_idProprietario`
    FOREIGN KEY (`idProprietario`)
    REFERENCES `controlminio`.`Pessoa` (`idPessoa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `controlminio`.`ApartamentoLuxo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `controlminio`.`ApartamentoLuxo` (
  `idApartamentoLuxo` INT NOT NULL AUTO_INCREMENT,
  `idApartamento` INT NOT NULL,
  `luminaria` VARCHAR(45) NULL,
  `geladeira` TINYINT NOT NULL,
  `fogao` TINYINT NOT NULL,
  PRIMARY KEY (`idApartamentoLuxo`),
  INDEX `FK_Apartamento_idApartamento_idx` (`idApartamento` ASC),
  CONSTRAINT `FK_ApartamentoLuxo_idApartamento`
    FOREIGN KEY (`idApartamento`)
    REFERENCES `controlminio`.`Apartamento` (`idApartamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `controlminio`.`ApartamentoPadrao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `controlminio`.`ApartamentoPadrao` (
  `idApartamentoPadrao` INT NOT NULL AUTO_INCREMENT,
  `idApartamento` INT NOT NULL,
  `armario` VARCHAR(45) NULL,
  `piso` VARCHAR(45) NULL,
  PRIMARY KEY (`idApartamentoPadrao`),
  INDEX `FK_ApartamentoPadrao_idApartamento_idx` (`idApartamento` ASC),
  CONSTRAINT `FK_ApartamentoPadrao_idApartamento`
    FOREIGN KEY (`idApartamento`)
    REFERENCES `controlminio`.`Apartamento` (`idApartamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
ALTER TABLE Pessoa 
	ADD CONSTRAINT `FK_Apartamento_idApartamento`
    FOREIGN KEY (`idApartamento`)
    REFERENCES `controlminio`.`Apartamento` (`idApartamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;
