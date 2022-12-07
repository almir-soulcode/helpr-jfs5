create table registros_originais_usuarios(
	idRegistros_originais_usuarios integer primary key auto_increment,
    idUsuario_original integer not null,
    nome_original varchar(255) not null,
    perfil_original varchar(255) not null,
    dType_original varchar(255) not null,
    dataAlteracao date
);

select * from registros_originais_usuarios;

delimiter //

create trigger tg_registros_originais_usuarios
after update on usuarios
for each row
begin
	insert into registros_originais_usuarios (idRegistros_originais_usuarios, idUsuario_original, nome_original, perfil_original, dType_original, dataAlteracao) values (null, old.id, old.nome, old.perfil, old.dtype, current_date());
end//

delimiter ;

select * from usuarios;

select * from registros_originais_usuarios;

update usuarios set dtype = 'developer' where id = 1;
update usuarios set nome = 'Einsten' where id = 1;
update usuarios set perfil = 'Ciêntista' where id = 1;
