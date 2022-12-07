create table historico_chamado(
idHistoricoChamado integer primary key auto_increment,
idChamado integer,
idFuncionario integer,
idCliente integer,
columnStatus varchar(255),
titulo varchar(120),
dataAlteracao date
);

describe chamado;

select * from historico_chamado;



delimiter //

create trigger tg_historico_chamado
before update on chamado
for each row
begin
	insert into historico_chamado (idHistoricoChamado, idChamado, idFuncionario, idCliente, columnStatus, titulo, dataAlteracao) values(null, old.id_chamado, old.id_funcionario, old.id_cliente, old.status, old.titulo, current_date());
end//

delimiter ;

select * from chamado;

update chamado set status = 'beterraba' where id_chamado = 2;
update chamado set titulo = 'cenoura' where id_chamado = 2;


select * from historico_chamado;








