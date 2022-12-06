CREATE DATABASE bkp_helpr;

USE bkp_helpr;

USE helpr;


CREATE TABLE bkp_helpr.cargosBackup(
	id_Cargo INTEGER PRIMARY KEY AUTO_INCREMENT,
	descricao VARCHAR(120) NOT NULL,
	nome VARCHAR(50) NOT NULL,
    salario DOUBLE NOT NULL
);

DROP TABLE bkp_helpr.cargosBackup;

SELECT * FROM helpr.cargo;

SELECT * FROM bkp_helpr.cargosBackup;

DELETE FROM helpr.cargo WHERE id_cargo = 5;

INSERT INTO cargo (descricao, nome, salario) VALUES ("Gerencia a empresa", "Diretor Geral", 30000 );

DROP TRIGGER bkp_cargo;

DELIMITER //

CREATE TRIGGER bkp_cargo
BEFORE DELETE ON cargo
FOR EACH ROW
BEGIN
	INSERT INTO bkp_helpr.cargosBackup VALUES (OLD.id_cargo,OLD.descricao,OLD.nome,OLD.salario);
END//



