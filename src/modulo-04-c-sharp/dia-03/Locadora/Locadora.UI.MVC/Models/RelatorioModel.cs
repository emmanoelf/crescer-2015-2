using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Locadora.UI.MVC.Models
{
    public class RelatorioModel
    {
        public int QuantidadeDeJogos { get; set; }
        public double PrecoMedio { get; set; }
        public string JogoMaisCaro { get; set; }
        public string JogoMaisBarato { get; set; }
        public IList<Jogo> listaDeJogos { get; set; }

        public RelatorioModel(IList<Jogo> listaJogos, int quantidadeDeJogos, double precoMedio, string jogoMaisCaro, string jogoMaisBarato)
        {
            listaDeJogos = listaJogos;
            QuantidadeDeJogos = quantidadeDeJogos;
            PrecoMedio = precoMedio;
            JogoMaisCaro = jogoMaisCaro;
            JogoMaisBarato = jogoMaisBarato;
        }
    }
}