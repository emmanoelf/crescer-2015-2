using System;
using System.Collections;
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
            xml.Add(new XElement("categoria", jogos.Categoria));
            XElement arquivoXml = XElement.Load(arquivoCaminho);
            arquivoXml.Add(xml);
            arquivoXml.Save(arquivoCaminho);
        }

        public List<Jogo> PesquisarJogoPeloNome(string nome)
        {
            List<Jogo> listaDeJogos = new List<Jogo>();
            XElement xml = XElement.Load(arquivoCaminho);
            var query = from jogos in xml.Elements()
                        where jogos.Element("nome").Value.Contains(nome)
                        select jogos;
            foreach (var jogo in query)
            {
                listaDeJogos.Add(ConverterXElementParaJogo(jogo));
            }
            return listaDeJogos;
        }

        public void EditarNomeJogo(string nome, string nomeEditado)
        {
            XElement xml = XElement.Load(arquivoCaminho);
            var jogoSelecionado = xml.Elements("jogo").FirstOrDefault(jogo => jogo.Element("nome").Value == nome);
            jogoSelecionado.Element("nome").SetValue(nomeEditado);
            xml.Save(arquivoCaminho);
        }

        public void EditarPrecoJogo(string nome, double preco)
        {
            XElement xml = XElement.Load(arquivoCaminho);
            var jogoSelecionado = xml.Elements("jogo").FirstOrDefault(jogo => jogo.Element("nome").Value == nome);
            jogoSelecionado.Element("preco").SetValue(preco);
            xml.Save(arquivoCaminho);
        }

        public void EditarCategoriaJogo(string nome, Categoria categoria)
        {
            XElement xml = XElement.Load(arquivoCaminho);
            var jogoSelecionado = xml.Elements("jogo").FirstOrDefault(jogo => jogo.Element("nome").Value == nome);
            jogoSelecionado.Element("categoria").SetValue(categoria);
            xml.Save(arquivoCaminho);
        }

        private Jogo ConverterXElementParaJogo(XElement jogo)
        {
            return new Jogo(jogo.Element("nome").Value,
                    Convert.ToDouble(jogo.Element("preco").Value),
                    (Categoria)Enum.Parse(typeof(Categoria), jogo.Element("categoria").Value));
        }

    }
}
