DROP TABLE IF EXISTS USUARIO;

CREATE TABLE USUARIO (
	CONTA_ID CHAR(10) NOT NULL PRIMARY KEY,
	NOME VARCHAR(50) NOT NULL,
	CONTA_VALOR NUMERIC(19,2) NOT NULL,
	SENHA VARCHAR(255) NOT NULL
);