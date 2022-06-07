DROP SCHEMA IF EXISTS dbpetmob;
CREATE SCHEMA dbpetmob;
USE dbpetmob;

CREATE TABLE Usuario(
    cpf_user		    varchar(25) primary key,
	nome_user		    varchar(35),
    sobrenome_user 	    varchar(35),
	sexo			    varchar(20),
	idade			    INT,
    rua_usuario	        VARCHAR(35),
	cidade_usuario	    VARCHAR(35),
	bairro_usuario	    VARCHAR(35),
	cep_usuario 	    VARCHAR(25),
    email_usuario		VARCHAR(50),
	telefone_usuario	VARCHAR(50),
    estado_user         VARCHAR(15),
    numero_casa         INT,
    complemento_user    VARCHAR(35),
    celular_user        VARCHAR(150),
    senha_user          int

);

CREATE TABLE Produto(
    id_produto	int primary key auto_increment not null,
	nome_produto Varchar(30),
	descricao_produto 	varchar(140),
	preco_produto		decimal(8,2)
   
);


CREATE TABLE Compras(
    id_compra INT primary key,
    data_compra	timestamp default current_timestamp,
    comprador   varchar(25),
    foreign key (comprador) references Usuario(cpf_user)
    
);


CREATE TABLE itens_compra(
	id_produto int ,
    foreign key(id_produto) references Produto(id_produto),
    id_compra 	int,
    foreign key(id_compra)	references  Compras(id_compra),
    quantidade int
);


INSERT INTO Produto (nome_produto, descricao_produto, preco_produto) VALUES
('Lava/Seco'	, 'Lavagem do seu animal à seco'			, 40.00),
('Tosa'			, 'Tosa da pelagem do animal'				, 35.00),
('Passeio'		, 'Levamos o animal para passear'			, 25.00),
('Brinquedo'	, 'Brinquedo de material emborrachado'		, 05.50),
('Areia'		, 'Areia sanitária para gatos'				, 10.00),
('Ração'		, 'Ração balanceada para animais domésticos', 15.00),
('Tigela'		, 'Tigela para ração ou água'				, 7.00),
('Coleira'		, 'Coleira de couro sintetico para animais'	, 12.00),
('Casa de pet'	, 'Casa de material reciclado'				, 45.00);