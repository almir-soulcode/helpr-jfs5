create database bkp_cargos;

use bkp_cargos;

create table table_bkp_cargos(
	idTable_bkp_cargos integer primary key auto_increment,
    id_cargo_bkp integer not null,
    descricao_bkp varchar(120) not null,
    nome_bkp varchar(50) not null,
    salario_bkp double not null
);

select * from table_bkp_cargos;

use helpr;

delimiter //

create trigger lo_bkp_cargos
before delete on cargo
for each row
begin
	insert into bkp_cargos.table_bkp_cargos (idTable_bkp_cargos, id_cargo_bkp, descricao_bkp, nome_bkp, salario_bkp) values (null, old.id_cargo, old.descricao, old.nome, old.salario);
end//

delimiter ;

select * from cargo;

insert into cargo (id_cargo, descricao, nome, salario) values (null, 'novo cargo', 'suporte de metaverso', 0.50);

delete cargo from cargo where id_cargo = 4;

select * from bkp_cargos.table_bkp_cargos;

