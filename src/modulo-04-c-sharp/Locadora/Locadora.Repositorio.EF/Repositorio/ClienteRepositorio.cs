using Locadora.Dominio;
using Locadora.Dominio.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Repositorio.EF.Repositorio
{
    public class ClienteRepositorio : IClienteRepositorio
    {
        public IList<Cliente> buscarPorNome(string nome)
        {
            using (var db = new BancoDeDados())
            {
                return db.Cliente.Where(j => j.Nome.Contains(nome)).ToList();
            }
        }
    }
}
