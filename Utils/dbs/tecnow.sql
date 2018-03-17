drop database if exists tecnow;

create database tecnow;

use tecnow;

create table `usuario` (
	id bigint auto_increment primary key,
    nome varchar (60) not null,
    email varchar (60) unique not null,
    senha varchar (20) not null,
    data_nascimento date not null,
	sexo enum ('Feminino', 'Masculino', 'Outro') not null
);

create table `jogo` (
	id bigint auto_increment primary key,
    idUsuario bigint not null,
    nome varchar (40) not null,
    categoria enum ('Tiro', 'RPG', 'Plataforma', 'Hack and Slash', 'Outro') not null,
    data_cadastro date not null,
    
    constraint foreign key (idUsuario) references usuario (id)
);

create table `anime` (
	id bigint auto_increment primary key,
    idUsuario bigint not null,
    nome varchar (40) not null,
	data_cadastro date not null,
    
    constraint foreign key (idUsuario) references usuario (id)
);

select * from usuario;
select * from jogo;
select * from anime;

select * from usuario, jogo, anime;

-- delete from usuario where id = 1;

insert into usuario set nome= 'admin', email = 'admin@email.com', senha = 'admin', data_nascimento = curdate(), sexo = 3;