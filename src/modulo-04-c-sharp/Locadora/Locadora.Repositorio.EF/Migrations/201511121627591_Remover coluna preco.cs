namespace Locadora.Repositorio.EF.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class Removercolunapreco : DbMigration
    {
        public override void Up()
        {
            DropColumn("dbo.Jogo", "Preco");
        }
        
        public override void Down()
        {
            AddColumn("dbo.Jogo", "Preco", c => c.Decimal(nullable: false, precision: 18, scale: 2));
        }
    }
}
