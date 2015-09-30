--Tarefa1--
create table Governadores(
IDGovernador		int IDENTITY,
Nome				varchar(200) NOT NULL,
CidadeNatal			varchar(50) NOT NULL,
DataNascimento		datetime NOT NULL,
InicioMandato		datetime NOT NULL,
FimMandato			datetime NOT NULL,
constraint PK_IDGovernador Primary Key (IDGovernador));

insert into Governadores 
	(Nome, CidadeNatal, DataNascimento, InicioMandato, FimMandato)
values 
	('João Carlos de Saldanha Oliveira e Daun', 'Lisboa', convert(datetime, '17/11/1770', 103), convert(datetime, '22/02/1822', 103), convert(datetime, '29/08/1822', 103));

insert into Governadores
	(Nome, CidadeNatal, DataNascimento, InicioMandato, FimMandato)
values 
	('João de Deus Mena Barreto, visconde de São Gabriel', 'Rio Pardo', convert(datetime, '02/07/1769', 103), convert(datetime, '29/08/1822', 103), convert(datetime, '29/11/1823', 103));

--data fictícia 07/02/1773--
insert into Governadores
	(Nome, CidadeNatal, DataNascimento, InicioMandato, FimMandato)
values 
	('José Inácio da Silva', 'Desconhecida', convert(datetime, '07/02/1773', 103), convert(datetime, '29/11/1823', 103), convert(datetime, '08/03/1824', 103));

insert into Governadores 
	(Nome, CidadeNatal, DataNascimento, InicioMandato, FimMandato)
values 
	('José Feliciano Fernandes Pinheiro', 'Santos', convert(datetime, '09/05/1774', 103), convert(datetime, '08/03/1824', 103), convert(datetime, '14/01/1826', 103));

insert into Governadores 
	(Nome, CidadeNatal, DataNascimento, InicioMandato, FimMandato)
values 
	('José Egídio Gordilho de Barbuda', 'Chamusca', convert(datetime, '01/08/1787', 103), convert(datetime, '14/01/1826', 103), convert(datetime, '04/11/1826', 103));

select * from Governadores;

select 
    Nome, 
    DATEDIFF(year, DataNascimento, InicioMandato) as Idade_Inicio_Mandato, 
    DATEDIFF(month, InicioMandato, FimMandato) as Tempo_Mandato
from Governadores;