﻿using Locadora.Dominio.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Locadora.Dominio;
using System.Xml.Linq;

namespace Locadora.Repositorio.XML
{
    public class JogoRepositorio : RepositorioBase, IJogoRepositorio
    {
        protected override string NomeArquivoXml
        {
            get
            {
                return @"C:\Users\Emmanoel\Documents\crescer-2015-2\src\modulo-04-c-sharp\Locadora\Locadora.Repositorio.XML\db_jogos.xml";
            }
        }

        public int Atualizar(Jogo entidade)
        {
            string idBusca = entidade.Id.ToString();
            XElement db = CarregarBaseXml();
            XElement jogoSalvo = db.Elements("jogo")
                                   .First(j => j.Attribute("id").Value == idBusca);

            jogoSalvo.SetElementValue("nome", entidade.Nome);
            jogoSalvo.SetElementValue("preco", entidade.Preco);
            jogoSalvo.SetElementValue("categoria", entidade.Categoria.ToString());
            jogoSalvo.SetElementValue("id_cliente_locacao", entidade.IdClienteLocacao.HasValue ? entidade.IdClienteLocacao.Value.ToString() : "");
            jogoSalvo.SetElementValue("descricao", entidade.Descricao);
            jogoSalvo.SetElementValue("selo", entidade.Selo.ToString());
            jogoSalvo.SetElementValue("imagem", entidade.Imagem);
            jogoSalvo.SetElementValue("video", entidade.Video);

            SalvarDbXml(db);
            return 1;
        }

        public Jogo BuscarPorId(int id)
        {
            IEnumerable<XElement> dbJogos = CarregarBaseXml().Elements("jogo");
            string idPesquisa = id.ToString();

            XElement jogoEncontrado = dbJogos.FirstOrDefault(j => j.Attribute("id").Value == idPesquisa);

            return ConverterXmlEmJogo(jogoEncontrado);
        }

        public IList<Jogo> BuscarPorNome(string nome)
        {
            IEnumerable<XElement> dbJogos = CarregarBaseXml().Elements("jogo");

            dbJogos = dbJogos.Where(jogo => jogo.Element("nome").Value.IndexOf(nome, StringComparison.InvariantCultureIgnoreCase) >= 0);

            return ConverterListaXmlEmEntidades(dbJogos).ToList();
        }

        public IList<Jogo> BuscarTodos()
        {
            IEnumerable<XElement> dbJogos = CarregarBaseXml().Elements("jogo");
            return ConverterListaXmlEmEntidades(dbJogos).ToList();
        }

        public int Criar(Jogo entidade)
        {
            int novoId = BuscarUltimoIdInserido() + 1;

            XElement jogoXml = ConverterJogoEmXml(entidade);
            XElement db = CarregarBaseXml();
            db.Add(jogoXml);

            SalvarDbXml(db);
            return 1;
        }

        public int Excluir(int id)
        {
            XElement dbJogos = CarregarBaseXml();
            string idComparar = id.ToString();
            int registrosEncontrados = 0;

            XElement jogoASerExcluido = dbJogos.Elements("jogo").FirstOrDefault(jogo => jogo.Attribute("id").Value == idComparar);

            if(jogoASerExcluido != null)
            {
                registrosEncontrados = 1;
                jogoASerExcluido.Remove();
                SalvarDbXml(dbJogos);
            }

            return registrosEncontrados;
        }

        private IEnumerable<Jogo> ConverterListaXmlEmEntidades(IEnumerable<XElement> dbJogos)
        {
            foreach (XElement j in dbJogos)
            {
                yield return ConverterXmlEmJogo(j);
            }
        }
        
        private XElement ConverterJogoEmXml(Jogo jogo)
        {
            XElement jogoXml = new XElement("jogo");
            jogoXml.SetAttributeValue("id", jogo.Id);
            jogoXml.SetElementValue("nome", jogo.Nome);
            jogoXml.SetElementValue("preco", jogo.Preco);
            jogoXml.SetElementValue("categoria", jogo.Categoria.ToString());
            jogoXml.SetElementValue("id_cliente_locacao", jogo.IdClienteLocacao.HasValue ? jogo.IdClienteLocacao.Value.ToString() : "");
            jogoXml.SetElementValue("descricao", jogo.Descricao);
            jogoXml.SetElementValue("selo", jogo.Selo.ToString());
            jogoXml.SetElementValue("imagem", jogo.Imagem);
            jogoXml.SetElementValue("video", jogo.Video);

            return jogoXml;
        }

        private Jogo ConverterXmlEmJogo(XElement jogoXml)
        {
            if(jogoXml == null)
            {
                return null;
            }

            var jogo = new Jogo(
                    id: Convert.ToInt32(jogoXml.Attribute("id").Value),
                    idClienteLocacao: jogoXml.Element("id_cliente_locacao").Value.ToNullable<int>()
                    );

            jogo.Nome = jogoXml.Element("nome").Value;
            jogo.Preco = Convert.ToDecimal(jogoXml.Element("preco").Value);
            jogo.Categoria = ConverterXmlCategoriaEmEnum(jogoXml.Element("categoria"));
            jogo.Descricao = jogoXml.Element("descricao").Value;
            jogo.Selo = ConverterXmlSeloEmEnum(jogoXml.Element("selo"));
            jogo.Imagem = jogoXml.Element("imagem").Value;
            jogo.Video = jogoXml.Element("video").Value;
            
            return jogo;
        }

        private Categoria ConverterXmlCategoriaEmEnum(XElement categoriaXml)
        {
            string valorXml = categoriaXml.Value;
            return (Categoria)Enum.Parse(typeof(Categoria), valorXml);
        }

        private Selo ConverterXmlSeloEmEnum(XElement seloXml)
        {
            string valorXml = seloXml.Value;
            return (Selo)Enum.Parse(typeof(Selo), valorXml);
        }
    }
}