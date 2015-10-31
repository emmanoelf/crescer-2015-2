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
        public double Preco { get; private set; }
        public Categoria Categoria { get; private set; }

        public Jogo(string nome, double preco, Categoria categoria)
        {
            this.Nome = nome;
            this.Categoria = categoria;
            this.Preco = preco;
        }

        public bool Equals(Jogo jogo)
        {
            return this.Nome == jogo.Nome &&
                this.Preco == jogo.Preco &&
                this.Categoria == jogo.Categoria;
        }
    }
}
