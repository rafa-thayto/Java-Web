drop database if exists TecNow;

create database TecNow;

use TecNow;

create table usuario (
	id int primary key auto_increment not null,
    nome varchar (60) not null,
    email varchar (60) not null unique,
    senha varchar (20) not null,
    data_nascimento date not null,
    genero enum ('Masculino', 'Feminino', 'Outro') not null
);

create table jogo (
	id int primary key auto_increment not null,
    nome varchar (40) not null,
	categoria enum ('Tiro', 'RPG', 'Plataforma', 'Esporte', 'Hack_and_slash', 'Outro') not null,
    data_cadastro date not null
);

create table anime (
	id int primary key auto_increment not null,
    nome varchar (40) not null,
    data_cadastro date not null
);

insert into usuario (nome, email, senha, data_nascimento, genero) values ('admin', 'admin@email.com', 'admin', curdate(), 'Outro');

select * from usuario;
select * from anime;
select * from jogo;