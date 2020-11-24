create database IF NOT EXISTS dbFilmes ;

USE dbFilmes;

create table IF NOT EXISTS titulos(
Codigo int AUTO_INCREMENT PRIMARY KEY,
Nome_do_titulo varchar(25),
Tipo varchar(20),
Locado char(1))
AUTO_INCREMENT=0;

insert into titulos(Codigo,Nome_do_titulo,Tipo,Locado)values(Codigo,'Vingadores: Ultimato','Acao',0);

select * from titulos;