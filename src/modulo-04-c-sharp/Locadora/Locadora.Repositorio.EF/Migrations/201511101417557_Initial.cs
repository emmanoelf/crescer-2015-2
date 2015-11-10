namespace Locadora.Repositorio.EF.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class Initial : DbMigration
    {
        public override void Up()
        {

            CreateTable(
                "dbo.Selo",
                s => new
                {
                    Id = s.Int(nullable: false, identity: true),
                    Descricao = s.String(nullable: false, maxLength: 250)
                })
                .PrimaryKey(s => s.Id);

            CreateTable(
                "dbo.Categoria",
                c => new
                {
                    Id = c.Int(nullable: false, identity: true),
                    Descricao = c.String(nullable: false, maxLength: 250)
                })
                .PrimaryKey(c => c.Id);

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
                        Descricao = c.String(nullable: false),
                        IdSelo = c.Int(nullable: false),
                        Imagem = c.String(),
                        Video = c.String(),
                        IdClienteLocacao = c.Int(),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Cliente", t => t.IdClienteLocacao)
                .ForeignKey("dbo.Selo", t => t.IdSelo)
                .ForeignKey("dbo.Categoria", t => t.IdCategoria)
                .Index(t => t.IdClienteLocacao)
                .Index(t => t.IdSelo)
                .Index(t => t.IdCategoria);

        }
        
        public override void Down()
        {
            DropForeignKey("dbo.Jogo", "IdClienteLocacao", "dbo.Cliente");
            DropForeignKey("dbo.Jogo", "IdSelo", "dbo.Selo");
            DropForeignKey("dbo.Jogo", "IdCategoria", "dbo.Categoria");
            DropIndex("dbo.Jogo", new[] { "IdClienteLocacao","IdSelo","IdCategoria" });
            DropTable("dbo.Jogo");
            DropTable("dbo.Cliente");
            DropTable("db.Selo");
            DropTable("dbo.Categoria");
        }
    }
}
