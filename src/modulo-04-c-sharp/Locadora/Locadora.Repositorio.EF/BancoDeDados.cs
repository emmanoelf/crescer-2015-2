using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Repositorio.EF
{
    public class BancoDeDados : DbContext
    {
        public DbSet<Jogo> Jogo { get; set; }
        public DbSet<Cliente> Cliente { get; set; }

        public BancoDeDados() : base("LocadoraEF")
        {

        }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Configurations.Add(new ClienteMap());
            modelBuilder.Configurations.Add(new JogoMap());
            base.OnModelCreating(modelBuilder);
        }
    }

    class JogoMap : EntityTypeConfiguration<Jogo>
    {
        public JogoMap()
        {
            ToTable("Jogo");
            HasKey(jogo => jogo.Id);

            Property(jogo => jogo.Nome).IsRequired().HasMaxLength(250);
            Property(jogo => jogo.Preco).IsRequired();
            Property(jogo => jogo.Descricao).IsRequired();
            Property(jogo => jogo.Imagem).IsOptional();
            Property(jogo => jogo.Video).IsOptional();
            Property(jogo => jogo.Categoria).IsRequired().HasColumnName("IdCategoria");
            Property(jogo => jogo.Selo).IsRequired().HasColumnName("IdSelo");
            HasOptional(jogo => jogo.ClienteLocacao).WithOptionalDependent().Map(m => m.MapKey("IdClienteLocacao"));
        }
    }

    class ClienteMap : EntityTypeConfiguration<Cliente>
    {
        public ClienteMap()
        {
            ToTable("Cliente");

            HasKey(cliente => cliente.Id);
            Property(cliente => cliente.Nome).IsRequired().HasMaxLength(250);
        }
    }
}
