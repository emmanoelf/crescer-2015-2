using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp
{
    public class Agenda
    {
        private List<Contato> contatos = new List<Contato>();

        public int QuantidadeContatos { get { return contatos.Count; } }

        public void AdicionarContato(Contato contato)
        {
            contatos.Add(contato);
        }

        //public void RemoverContato(string nomeContato)
        //{
        //    foreach (var contato in contatos)
        //    {
        //        if (contato.Nome == nomeContato)
        //        {
        //            contatos.Remove(contato);
        //            break;
        //        }
        //    }
        //}

        public void RemoverContato(string nomeContato)
        {
            var contatosASeremRemovidos = new List<Contato>();
            for (int i = 0; i < contatos.Count; i++)
            {
                if (contatos[i].Nome == nomeContato)
                {
                    contatosASeremRemovidos.Add(contatos[i]);
                }
            }
            foreach (var contato in contatosASeremRemovidos)
            {
                contatos.Remove(contato);
            }
        }

        public void RemoverContatoPeloNumero(int numeroContato)
        {
            var numerosASeremRemovidos = new List<Contato>();
            for(int i = 0; i < contatos.Count; i++)
            {
                if(contatos[i].Numero == numeroContato)
                {
                    numerosASeremRemovidos.Add(contatos[i]);
                }
            }
            foreach(var contato in numerosASeremRemovidos)
            {
                contatos.Remove(contato);
            }
        }

        public void ListarContatosOrdenadosPorNome()
        {
            contatos.OrderBy(contato => contato.Nome).ToList();
            
        }

        public void ListarContatos()
        {
            foreach (var contato in contatos)
            {
                //System.Console.WriteLine(contato.Nome + "-" + contato.Numero);
            }
        }
    }
}
