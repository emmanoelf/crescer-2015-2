using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Repositorio.EF.Maps
{
    class PermissaoMap : EntityTypeConfiguration<Permissao>
    {
        public PermissaoMap()
        {
            ToTable("dbo.Permissao");
            HasKey(p => p.Id);

            Property(p => p.Nome).IsRequired().HasMaxLength(50);
        }
    }
}
