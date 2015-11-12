using Locadora.Dominio;
using Locadora.Dominio.Repositorio;
using Locadora.Web.MVC.Models;
using Locadora.Web.MVC.Seguranca;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Locadora.Web.MVC.Controllers
{
    [Autorizador]
    public class RelatorioController : Controller
    {
        private IJogoRepositorio repositorio = new Repositorio.EF.JogoRepositorio();

        public ActionResult JogosDisponiveis(string nomeJogo)
        {
            RelatorioModel relatorioModel = new RelatorioModel();
            IList<Jogo> listaJogos;
            if (nomeJogo != null)
            {
                listaJogos = repositorio.BuscarPorNome(nomeJogo);
            }
            else
            {
                listaJogos = repositorio.BuscarTodos();
            }
            if (listaJogos.Count != 0)
            {
                foreach (var jogo in listaJogos)
                {
                    var id = jogo.Id;
                    var nome = jogo.Nome;
                    var categoria = jogo.Categoria.ToString();
                    JogoModel jogoModel = new JogoModel()
                    {
                        Id = id,
                        Nome = nome,
                        Categoria = categoria
                    };
                    relatorioModel.ListaJogos.Add(jogoModel);
                }
                relatorioModel.QuantidadeJogos = relatorioModel.ListaJogos.Count;
            }
            return View(relatorioModel);
        }
    }
}