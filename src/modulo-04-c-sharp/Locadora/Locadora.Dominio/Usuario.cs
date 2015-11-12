using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio
{
    public class Usuario : EntidadeBase
    {
        public string NomeCompleto { get; set; }
        public string Email { get; set; }
        public string Senha { get; set; }
        public ICollection<Permissao> Permissoes { get; private set; }

        public Usuario()
        {
            this.Permissoes = new HashSet<Permissao>();
        }

        public bool TemPermissao(string nomePermissao)
        {
            return this.Permissoes.Any(permissoes => permissoes.Nome.Equals(nomePermissao));
        }

        public void AdicionarPermissao(Permissao permissao)
        {
            if(this.Permissoes == null)
            {
                this.Permissoes = new List<Permissao>();
            }

            if (!TemPermissao(permissao.Nome))
            {
                this.Permissoes.Add(permissao);
            }
        }
    }
}
