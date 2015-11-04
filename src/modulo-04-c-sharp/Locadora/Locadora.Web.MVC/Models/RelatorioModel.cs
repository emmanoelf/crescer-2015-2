using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Locadora.Web.MVC.Models
{
    public class RelatorioModel
    {
        public List<Jogos> ListaJogos { get; set; }
        public int QuantidadeJogos { get; set; }
        public string Nome { get; set; }
        public string Categoria { get; set; }
        public decimal Preco { get; set; }

        public RelatorioModel()
        {
            var jogos = new List<Jogos>();
        }
    }
}