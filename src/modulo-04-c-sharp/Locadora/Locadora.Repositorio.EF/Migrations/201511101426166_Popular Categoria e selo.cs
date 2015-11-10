namespace Locadora.Repositorio.EF.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class PopularCategoriaeselo : DbMigration
    {
        public override void Up()
        {
            Sql(@"INSERT INTO dbo.Categoria (Descricao) VALUES('RPG')
                  INSERT INTO dbo.Categoria (Descricao) VALUES('Corrida')
                  INSERT INTO dbo.Categoria (Descricao) VALUES('Aventura')
                  INSERT INTO dbo.Categoria (Descricao) VALUES('Luta')
                  INSERT INTO dbo.Categoria (Descricao) VALUES('Esporte')");

            Sql(@"INSERT INTO dbo.Selo (Descricao) VALUES ('Ouro');
                  INSERT INTO dbo.Selo (Descricao) VALUES ('Prata');
                  INSERT INTO dbo.Selo (Descricao) VALUES ('Bronze');");
        }
        
        public override void Down()
        {

        }
    }
}
