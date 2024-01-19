ALTER TABLE IF EXISTS AGENDAMENTO
DROP CONSTRAINT IF EXISTS FKGUHEPAX6V6KX4V8A8B4QTYH16;

ALTER TABLE IF EXISTS AGENDAMENTO
DROP CONSTRAINT IF EXISTS FK_AGENDAMENTO_STATUS;

DROP TABLE IF EXISTS AGENDAMENTO;

CREATE TABLE AGENDAMENTO(
	ID BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	CONTA_ORIGEM CHAR(10) NOT NULL,
	CONTA_DESTINO CHAR(10) NOT NULL,
	VALOR_TRANSFERENCIA NUMERIC(19,2) NOT NULL,
	TAXA_TRANSFERENCIA FLOAT(1) NOT NULL,
	DATA_TRANSFERENCIA TIMESTAMP NOT NULL,
	DATA_AGENDAMENTO TIMESTAMP NOT NULL,
	STATUS_ID INT DEFAULT 1 NOT NULL,

	CONSTRAINT FK_AGENDAMENTO_STATUS 
    		FOREIGN KEY (STATUS_ID)
    		REFERENCES AGENDAMENTO_STATUS(ID)
);