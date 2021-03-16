CREATE TABLE gabarito (
    id_da_questao INT NOT NULL AUTO_INCREMENT,
    resposta_correta VARCHAR(1),
    PRIMARY KEY (id_da_questao)
)

INSERT INTO gabarito (resposta_correta) VALUES ("A")
INSERT INTO gabarito (resposta_correta) VALUES ("B")
INSERT INTO gabarito (resposta_correta) VALUES ("C")
INSERT INTO gabarito (resposta_correta) VALUES ("D")
INSERT INTO gabarito (resposta_correta) VALUES ("E")