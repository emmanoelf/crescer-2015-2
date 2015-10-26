using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace ConsoleApp.Testes
{
    [TestClass]
    public class AgendaTestes
    {
        [TestMethod]
        public void AgendaTemUmContato()
        {
            var agenda = new Agenda();
            var contato = new Contato() { Nome = "Júlio Cesar", Numero = 123456789 };
            agenda.AdicionarContato(contato);
            Assert.AreEqual(agenda.QuantidadeContatos, 1);
        }
    }
}
