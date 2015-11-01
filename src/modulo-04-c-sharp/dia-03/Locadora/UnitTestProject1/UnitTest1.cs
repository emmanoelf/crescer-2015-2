using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Locadora.Dominio;

namespace UnitTestProject1
{
    [TestClass]
    public class UnitTest1
    {
        [TestMethod]
        public void AdicionandoJogo()
        {
            var bd = new BaseDeDados();
            Jogo jogo = new Jogo("Maskara", 70.00, Categoria.AVENTURA);
            bd.AdicionarJogo(jogo);
            Assert.AreEqual(jogo.Nome, bd.PesquisarJogoPeloNome("Maskara")[0].Nome);
            Assert.AreEqual(jogo.Preco, bd.PesquisarJogoPeloNome("Maskara")[0].Preco);
            Assert.AreEqual(jogo.Categoria, bd.PesquisarJogoPeloNome("Maskara")[0].Categoria);
        }

        [TestMethod]
        public void EditarNomeJogo()
        {
            var bd = new BaseDeDados();
            bd.EditarNomeJogo("Maskara", "Tetris");
            Assert.AreEqual("Tetris", bd.PesquisarJogoPeloNome("Tetris")[0].Nome);
        }

        [TestMethod]
        public void EditarPrecoJogo()
        {
            var bd = new BaseDeDados();
            bd.EditarPrecoJogo("Aladdin", 27);
            Assert.AreEqual(27, bd.PesquisarJogoPeloNome("Aladdin")[0].Preco);
        }
        [TestMethod]
        public void EditarCategoriaJogo()
        {
            var bd = new BaseDeDados();
            bd.EditarCategoriaJogo("Donkey Kong Country", Categoria.RPG);
            Assert.AreEqual(Categoria.RPG, bd.PesquisarJogoPeloNome("Donkey Kong Country")[0].Categoria);
        }

    }
}
