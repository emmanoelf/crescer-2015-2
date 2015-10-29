using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Linq;

namespace Locadora.Dominio
{
    public class BaseDeDados
    {   
        public string arquivoCaminho { get; private set; }

        public BaseDeDados()
        {
            arquivoCaminho = @"C:\Users\Emmanoel\Documents\game_store.xml";
        }

        public int insereID()
        {
            XElement xml = XElement.Load(arquivoCaminho);
            int lastID = Convert.ToInt32(xml.Elements("jogo").Last().Attribute("id").Value);
            return lastID + 1;
        }

        public void AdicionarJogo(Jogo jogos)
        {
            XElement xml = new XElement("jogo");
            xml.Add(new XAttribute("id", insereID()));
            xml.Add(new XElement("nome", jogos.Nome));
            xml.Add(new XElement("preco", jogos.Preco));
            xml.Add(new XElement("genero", jogos.Genero));
            XElement arquivoXml = XElement.Load(arquivoCaminho);
            arquivoXml.Add(xml);
            arquivoXml.Save(arquivoCaminho);
        }

        /*public Jogo PesquisarPorNome(string nome)
        {
            XElement xml = XElement.Load(arquivoCaminho);
            var resultado = xml.Elements().FirstOrDefault(jogo => jogo.Element("nome").Value == nome);
            return resultado;
        }*/

    }
}
