using Locadora.Dominio.Repositorio;
using Locadora.Web.MVC.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Locadora.Web.MVC.Controllers
{
    public class RelatorioController : Controller
    {
        private IJogoRepositorio repositorio = new Repositorio.ADO.JogoRepositorio();

        public ActionResult JogosDisponiveis()
        {
            RelatorioModel relatorioModel = new RelatorioModel();
            var listaJogos = repositorio.BuscarTodos();
            foreach (var jogo in listaJogos)
            {
                var nome = jogo.Nome;
                var preco = jogo.Preco;
                var categoria = jogo.Categoria.ToString();
                JogoModel jogoModel = new JogoModel()
                {
                    Nome = nome,
                    Preco = preco,
                    Categoria = categoria
                };
                relatorioModel.ListaJogos.Add(jogoModel);
            }
            var maisCaro = listaJogos.Max(jogo => jogo.Preco);
            var maisBarato = listaJogos.Min(jogo => jogo.Preco);
            relatorioModel.JogoMaisCaro = listaJogos.First(jogo => jogo.Preco == maisCaro).Nome;
            relatorioModel.JogoMaisBarato = listaJogos.First(jogo => jogo.Preco == maisBarato).Nome;
            relatorioModel.PrecoMedio = listaJogos.Average(jogo => jogo.Preco);
            relatorioModel.QuantidadeJogos = relatorioModel.ListaJogos.Count;
            return View(relatorioModel);
        }
    }
}