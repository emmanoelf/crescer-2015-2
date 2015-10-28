using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio
{
    public class Jogo
    {
        public string Nome { get; set; }
        public Genero Genero { get; set; }
        public double Preco { get; private set; }

        public Jogo(string nome, Genero genero, double preco)
        {
            this.Nome = nome;
            this.Genero = genero;
            this.Preco = preco;
        }
    }
}
