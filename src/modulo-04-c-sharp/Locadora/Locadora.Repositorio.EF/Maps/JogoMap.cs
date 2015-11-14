using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Repositorio.EF.Maps
{
    class JogoMap : EntityTypeConfiguration<Jogo>
    {
        public JogoMap()
        {
            ToTable("Jogo");
            HasKey(jogo => jogo.Id);

            Property(jogo => jogo.Nome).IsRequired().HasMaxLength(250);
            Property(jogo => jogo.Descricao).IsRequired();
            Property(jogo => jogo.Imagem).IsOptional();
            Property(jogo => jogo.Video).IsOptional();
            Property(jogo => jogo.Categoria).IsRequired().HasColumnName("IdCategoria");
            Property(jogo => jogo.Selo).IsRequired().HasColumnName("IdSelo");
            HasOptional(jogo => jogo.ClienteLocacao).WithOptionalDependent().Map(m => m.MapKey("IdClienteLocacao"));
        }
    }
}
