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

    }
}
