CREATE TABLE dbo.Selo
(    
    Id               INT             NOT NULL CONSTRAINT PK_IdSelo PRIMARY KEY,
    Descricao        VARCHAR(250)    NOT NULL
)

ALTER TABLE Jogo ADD Descricao VARCHAR(MAX) NOT NULL DEFAULT 'Melhor jogo';
ALTER TABLE Jogo ADD Imagem VARCHAR(MAX)
ALTER TABLE Jogo ADD Video VARCHAR(MAX)
