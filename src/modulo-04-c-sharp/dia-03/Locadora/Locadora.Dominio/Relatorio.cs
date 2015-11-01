using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio
{
    class Relatorio
    {
        public const string ARQUIVOCAMINHO = @"C:\Users\Emmanoel\Documents\relatorio.txt";
        public const string TITULO = "                        LOCADORA NUNES GAMES                                  ";
        string data = "{0}                                                         {1}";
        public const string RELATORIO = "                     RELATORIO DE JOGOS                                    ";
        public const string IGUALSEPARADOR = "===========================================================================";
        public const string TRACOSEPARADOR = "---------------------------------------------------------------------------";
        public const string COLUNAS = "ID         CATEGORIA            NOME                     PRECO";

        public void GerarRelatorio()
        {

            using (StreamWriter writer = File.AppendText(ARQUIVOCAMINHO))
            {
                
                writer.WriteLine(TITULO);
                writer.WriteLine(string.Format(data, string.Format("{0:dd/MM/yyyy}", DateTime.Now), DateTime.Now.ToString("HH:mm:ss")));
                writer.WriteLine(RELATORIO);
                writer.WriteLine("");
                writer.WriteLine(IGUALSEPARADOR);
                writer.WriteLine(TRACOSEPARADOR);
                writer.Close();
            }
        }

    }
}
