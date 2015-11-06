using Locadora.Dominio.Repositorio;
using Locadora.Web.MVC.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Locadora.Web.MVC.Controllers
{
    public class JogoController : Controller
    {
        private IJogoRepositorio repositorio = new Repositorio.ADO.JogoRepositorio();
        public ActionResult DetalhesJogo(int id)
        {
            var jogoRetornado = repositorio.BuscarPorId(id);
            DetalhesJogoModel detalheJogoModel = new DetalhesJogoModel();
            detalheJogoModel.Nome = jogoRetornado.Nome;
            detalheJogoModel.Preco = jogoRetornado.Preco;
            detalheJogoModel.Categoria = jogoRetornado.Categoria.ToString();
            detalheJogoModel.Id = jogoRetornado.Id;
            detalheJogoModel.Imagem = jogoRetornado.Imagem;
            detalheJogoModel.Video = jogoRetornado.Video;
            detalheJogoModel.Descricao = jogoRetornado.Descricao;
            detalheJogoModel.Selo = jogoRetornado.Selo.ToString();
            return View(detalheJogoModel);
        }
    }
}