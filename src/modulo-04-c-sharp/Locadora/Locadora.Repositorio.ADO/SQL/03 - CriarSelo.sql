CREATE TABLE dbo.Selo
(    
    Id               INT             NOT NULL CONSTRAINT PK_IdSelo PRIMARY KEY,
    Descricao        VARCHAR(250)    NOT NULL
)

INSERT INTO Selo (Id, Descricao) VALUES (1, 'OURO');
INSERT INTO Selo (Id, Descricao) VALUES (2, 'PRATA');
INSERT INTO Selo (Id, Descricao) VALUES (3, 'BRONZE');