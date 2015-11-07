﻿using System;
using System.Globalization;
using System.Text;

namespace Locadora.Dominio
{
    public class Jogo : EntidadeBase
    {
        public string Nome { get; set; }

        public decimal Preco { get; set; }

        public Categoria Categoria { get; set; }

        public int? IdClienteLocacao { get; private set; }

        public string Descricao { get; set; }

        public Selo Selo { get; set; }

        public string Imagem { get; set; }

        public string Video { get; set; }
        
        public Jogo()
        {

        }

        public Jogo(int id, int? idClienteLocacao = null)
        {
            this.Id = id;
            this.IdClienteLocacao = idClienteLocacao;
        }

        public void LocarPara(Cliente cliente)
        {
            this.IdClienteLocacao = cliente.Id;
        }

        public override string ToString()
        {
            var builder = new StringBuilder();
            builder.AppendLine("Id: " + this.Id);
            builder.AppendLine("Nome: " + this.Nome);
            builder.AppendLine("Preço: " + this.Preco.ToString("C", CultureInfo.GetCultureInfo("pt-BR")));
            builder.AppendLine("Categoria: " + this.Categoria);
            builder.AppendLine("Descricao: " + this.Descricao);
            builder.AppendLine("Selo: " + this.Selo);
            builder.AppendLine("Imagem: " + this.Imagem);
            builder.AppendLine("Video: " + this.Video);

            return builder.ToString();
        }

        public override int GetHashCode()
        {
            return base.GetHashCode();
        }

        public override bool Equals(object obj)
        {
            if(obj.GetType() == typeof(Jogo))
            {
                Jogo jogoComp = (Jogo)obj;

                return this.Id == jogoComp.Id
                    && this.Nome == jogoComp.Nome
                    && this.Preco == jogoComp.Preco
                    && this.Categoria == jogoComp.Categoria
                    && this.IdClienteLocacao == jogoComp.IdClienteLocacao
                    && this.Descricao == jogoComp.Descricao
                    && this.Selo == jogoComp.Selo
                    && this.Imagem == jogoComp.Imagem
                    && this.Video == jogoComp.Video;
            }

            return false;
        }
    }
}