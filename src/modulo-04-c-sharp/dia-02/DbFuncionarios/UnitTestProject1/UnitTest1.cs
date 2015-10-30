using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using DbFuncionarios;
using System.Collections.Generic;

namespace UnitTestProject1
{
    [TestClass]
    public class UnitTest1
    {
        [TestMethod]
        public void PrimeiroCargoEAnalista()
        {
            var bd = new BaseDeDados();
            List<Funcionario> funcionarios = bd.Funcionarios;
            var resultado = bd.BuscarOrdenadosPorCargo();
            Assert.AreEqual("Analista", resultado[0].Cargo.Titulo);
        }

        [TestMethod]
        public void BuscarFuncionarioPorNome()
        {
            var bd = new BaseDeDados();
            List <Funcionario> funcionarios= bd.Funcionarios;
            var resultado = bd.BuscarPorNome("Rafael");
            Assert.AreEqual("Rafael Benetti", resultado[0].Nome);
        }

        [TestMethod]
        public void BuscarFuncionarioPorParteDoNome()
        {
            var bd = new BaseDeDados();
            List<Funcionario> funcionarios = bd.Funcionarios;
            var resultado = bd.BuscarPorNome("nol");
            Assert.AreEqual("Eduardo Arnold", resultado[0].Nome);
        }

        [TestMethod]
        public void BuscarPeloSegundoFuncionarioDoTurnoDaNoite()
        {
            var bd = new BaseDeDados();
            List<Funcionario> funcionarios = bd.Funcionarios;
            var resultado = bd.BuscarPorTurno(TurnoTrabalho.Noite);
            Assert.AreEqual("Lucas Kauer", resultado[1].Nome);
        }

        [TestMethod]
        public void BuscarPeloPrimeiroFuncionarioDoTurnoDaManha()
        {
            var bd = new BaseDeDados();
            List<Funcionario> funcionarios = bd.Funcionarios;
            var resultado = bd.BuscarPorTurno(TurnoTrabalho.Manha);
            Assert.AreEqual("Lucas Leal", resultado[0].Nome);
        }

        [TestMethod]
        public void BuscarFuncinariosQueTenhamIdadesEntre15E25Anos()
        {
            var bd = new BaseDeDados();
            List<Funcionario> funcionarios = bd.Funcionarios;
            var resultado = bd.FiltrarPorIdadeAproximada(20);
            Assert.AreEqual(8, resultado.Count);
        }

        [TestMethod]
        public void BuscarAniversarianteDoMes()
        {
            var bd = new BaseDeDados();
            List<Funcionario> funcionarios = bd.Funcionarios;
            var resultado = bd.AniversariantesDoMes();
            Assert.AreEqual("Margarete Ricardo", resultado[0].Nome);
        }

    }
}
