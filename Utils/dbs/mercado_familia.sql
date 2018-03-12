drop database if exists mercado_familia;

create database mercado_familia;

use mercado_familia;

create table usuario (
	id int primary key not null auto_increment,
    nome varchar (45) not null,
    dataNascimento date not null,
    senha varchar (45) not null
);

create table produto (
	id int primary key not null auto_increment,
    nome varchar (45) not null,
    preco decimal (12, 2) not null,
	dataCadastro date not null,
    idUsuario int not null,
    
    constraint foreign key (idUsuario) references usuario (id)
);
  
insert into usuario set nome = "admin" ,dataNascimento = curdate(), senha = "admin";
select * from usuario, produto;
select * from produto;
select * from usuario;