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
            //implementar maior preco, menor preco, jogo mais caro, jogo mais barato, quantidade de jogos
            return View(relatorioModel);
        }
    }
}