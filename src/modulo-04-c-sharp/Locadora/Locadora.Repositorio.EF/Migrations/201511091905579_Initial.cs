namespace Locadora.Repositorio.EF.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class Initial : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.Cliente",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(nullable: false, maxLength: 250),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Jogo",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(nullable: false, maxLength: 250),
                        Preco = c.Decimal(nullable: false, precision: 18, scale: 2),
                        IdCategoria = c.Int(nullable: false),
                        IdClienteLocacao = c.Int(),
                        Descricao = c.String(nullable: false),
                        IdSelo = c.Int(nullable: false),
                        Imagem = c.String(),
                        Video = c.String(),
                    })
                .PrimaryKey(t => t.Id);
        }
        
        public override void Down()
        {
            DropTable("dbo.Jogo");
            DropTable("dbo.Cliente");
        }
    }
}
