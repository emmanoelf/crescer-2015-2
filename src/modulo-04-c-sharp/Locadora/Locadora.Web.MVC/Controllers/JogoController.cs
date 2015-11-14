using Locadora.Dominio;
using Locadora.Dominio.Repositorio;
using Locadora.Web.MVC.Helpers;
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
    public class JogoController : Controller
    {
        private IJogoRepositorio repositorio = new Repositorio.EF.Repositorio.JogoRepositorio();

        [HttpGet]
        public ActionResult DetalhesJogo(int id)
        {
            var jogoRetornado = repositorio.BuscarPorId(id);
            DetalhesJogoModel detalheJogoModel = new DetalhesJogoModel();
            detalheJogoModel.Nome = jogoRetornado.Nome;
            detalheJogoModel.Categoria = jogoRetornado.Categoria.ToString();
            detalheJogoModel.Id = jogoRetornado.Id;
            detalheJogoModel.Imagem = jogoRetornado.Imagem;
            detalheJogoModel.Video = jogoRetornado.Video;
            detalheJogoModel.Descricao = jogoRetornado.Descricao;
            detalheJogoModel.Selo = jogoRetornado.Selo.ToString();
            return View(detalheJogoModel);
        }

        [HttpGet]
        [Autorizador(Roles = Permissao.ADMIN)]
        public ActionResult Manter(int id = 0)
        {
            if (id != 0)
            {
                var jogoRetornado = repositorio.BuscarPorId((int)id);
                var manterJogo = new ManterJogoModel()
                {
                    Id = jogoRetornado.Id,
                    Nome = jogoRetornado.Nome,
                    Categoria = jogoRetornado.Categoria,
                    Descricao = jogoRetornado.Descricao,
                    Selo = jogoRetornado.Selo,
                    Imagem = jogoRetornado.Imagem,
                    Video = jogoRetornado.Video
                };
                return View(manterJogo);
            }
            return View();
        }

        [ValidateAntiForgeryToken]
        [HttpPost]
        public ActionResult Salvar(ManterJogoModel manterJogo)
        {
            if (ModelState.IsValid)
            {
                if (manterJogo.Id != null)
                {
                    Jogo jogo = new Jogo((int)manterJogo.Id)
                    {
                        Nome = manterJogo.Nome,
                        Categoria = manterJogo.Categoria.Value,
                        Descricao = manterJogo.Descricao,
                        Selo = manterJogo.Selo.Value,
                        Imagem = manterJogo.Imagem,
                        Video = manterJogo.Video
                    };
                    repositorio.Atualizar(jogo);
                    TempData["Success"] = "Jogo editado com sucesso.";
                    return RedirectToAction("JogosDisponiveis", "Relatorio");
                }
                else
                {
                    Jogo jogo = new Jogo()
                    {
                        Nome = manterJogo.Nome,
                        Categoria = manterJogo.Categoria.Value,
                        Descricao = manterJogo.Descricao,
                        Selo = manterJogo.Selo.Value,
                        Imagem = manterJogo.Imagem,
                        Video = manterJogo.Video
                    };

                    repositorio.Criar(jogo);
                    TempData["Success"] = "Jogo salvo com sucesso.";

                    return RedirectToAction("JogosDisponiveis", "Relatorio");
                }
            }
            else
            {
                return View("Manter", manterJogo);
            }

        }

        private IList<Jogo> ObterJogoPorFiltro(string nome)
        {
            IJogoRepositorio jogoRepositorio = FabricaDeModulos.CriarJogoRepositorio();
            if (string.IsNullOrWhiteSpace(nome))
            {
                return jogoRepositorio.BuscarTodos();
            }
            else
            {
                return jogoRepositorio.BuscarPorNome(nome);
            }
        }

        public JsonResult JogosAutoComplete(string term)
        {
            IList<Jogo> jogosEncontrados = ObterJogoPorFiltro(term);
            var json = jogosEncontrados.Select(jogos => new { label = jogos.Nome });
            return Json(json, JsonRequestBehavior.AllowGet);
        }

    }
}