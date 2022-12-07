USE helpr;

CREATE DATABASE bkp_helpr;
 
CREATE TABLE bkp_helpr.bkp_cargos(
    id_cargo INTEGER PRIMARY KEY AUTO_INCREMENT,
    descricao VARCHAR(120) NOT NULL,
    nome VARCHAR(50) NOT NULL,
    salario DOUBLE NOT NULL
);

DELIMITER //

CREATE TRIGGER tg_bkp_cargos
BEFORE DELETE ON cargo
FOR EACH ROW
BEGIN
    INSERT INTO bkp_helpr.bkp_cargos VALUES (OLD.id_cargo, OLD.descricao, OLD.nome, OLD.salario);
END//