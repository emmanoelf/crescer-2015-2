using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio
{
    public class Locacao
    {
        public int IdJogo { get; set; }
        public int IdCliente { get; set; }
        public DateTime DataLocacao { get; set; }
        public decimal PrecoLocacao { get; set; }
        public Jogo Jogo { get; set; }
        public Cliente Cliente { get; set; }
        
        public Locacao(Cliente cliente, Jogo jogo)
        {
            this.IdCliente = cliente.Id;
            this.IdJogo = jogo.Id;
            CalcularPrecoJogo();
        }

        public void CalcularPrecoJogo()
        {
            if(Jogo.Selo == Selo.BRONZE)
            {
                PrecoLocacao = 5;
                DataLocacao.AddDays(3);
            }
            else if(Jogo.Selo == Selo.PRATA)
            {
                PrecoLocacao = 10;
                DataLocacao.AddDays(2);
            }
            else
            {
                PrecoLocacao = 15;
                DataLocacao.AddDays(1);
            }
        }
    }
}
