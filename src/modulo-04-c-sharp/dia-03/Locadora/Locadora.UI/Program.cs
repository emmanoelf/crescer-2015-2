using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.UI
{
    class Program
    {
        //opções do menu principal
        public const string ESCOLHA = "Escolha uma opção do menu a seguir";
        public const string CADASTRAR_JOGO = "1 - Cadastrar Jogo";
        public const string PESQUISAR_JOGO = "2 - Pesquisar Jogo";
        public const string EDITAR_JOGO = "3 - Editar Jogo";
        public const string SAIR = "Sair";
        //opções do submenu editar
        public const string EDITAR_JOGO_NOME = "1 - Editar Nome";
        public const string EDITAR_JOGO_PRECO = "2 - Editar Preco";
        public const string EDITAR_JOGO_CATEGORIA = "3 - Editar Categoria";
        public const string EDITAR_JOGO_TODOS_CAMPOS = "4 - Editar todos os campos";
        //mensagens submenu editar
        public const string MSG_EDITAR_JOGO_PROCURAR_JOGO = "Digite o nome do jogo a ser editado";
        public const string MSG_EDITAR_JOGO_NOME = "Digite o novo nome";
        public const string MSG_EDITAR_JOGO_PRECO = "Digite o novo preco";
        public const string MSG_EDITAR_JOGO_CATEGORIA = "Digite a nova categoria";
        public const string MSG_EDITAR_JOGO_SUCESSO = "Jogo alterado com sucesso.";
        //mensagens do case 1 - Cadastrar
        public const string MSG_CADASTRAR_JOGO_NOME = "Digite o nome do novo jogo";
        public const string MSG_CADASTRAR_JOGO_PRECO = "Digite o preco do jogo";
        public const string MSG_CADASTRAR_JOGO_CATEGORIA = "Escolha a categoria pertencente ao jogo";
        public const string MSG_CADASTRAR_JOGO_SUCESSO = "O jogo foi cadastrado com sucesso";
        //mensgens do case 2 - Pesquisar
        public const string MSG_PESQUISA_JOGO = "Digite o nome do jogo que procuras";
        public const string MSG_PESQUISA_CONTINUAR = "Pressione a tecla Enter para concluir a busca";
        //mensagem case 3 - Relatório
        public const string MSG_GERAR_RELATORIO = "Relatorio gerado com sucesso.";
        //mensagem case 4 - Editar Jogo
        public const string ESCOLHA_CATEGORIA_RPG = "1 - RPG";
        public const string ESCOLHA_CATEGORIA_AVENTURA = "2 - Aventura";
        public const string ESCOLHA_CATEGORIA_ESTRATEGIA = "3 - Estrategia";
        public const string ESCOLHA_CATEGORIA_SHOOTER = "4 - Shooter";
        public const string ESCOLHA_CATEGORIA_CORRIDA = "5 - Corrida";
        public const string ESCOLHA_CATEGORIA_LUTA = "6 - Luta";
        //CATCH
        public const string MSG_OPCAO_INVALIDA = "Opcao invalida";
        public const string MSG_CATCH = "Ocorreu um erro inesperado. Por favor tente novamente ou entre em contato com o administrador do sistema.";
        public const string MSG_EDITAR_JOGO_CATCH = "Registro nao encontrado.";

        static Categoria SelecionarCategoria()
        {
            Console.WriteLine(ESCOLHA_CATEGORIA_RPG);
            Console.WriteLine(ESCOLHA_CATEGORIA_AVENTURA);
            Console.WriteLine(ESCOLHA_CATEGORIA_ESTRATEGIA);
            Console.WriteLine(ESCOLHA_CATEGORIA_SHOOTER);
            Console.WriteLine(ESCOLHA_CATEGORIA_CORRIDA);
            Console.WriteLine(ESCOLHA_CATEGORIA_LUTA);
            int categoriaSelecionada = int.Parse(Console.ReadLine());
            Categoria categoriaAlteradaPara = Categoria.RPG;
            if(categoriaSelecionada == 1)
            {
                categoriaAlteradaPara = Categoria.RPG;
            }else if(categoriaSelecionada == 2)
            {
                categoriaAlteradaPara = Categoria.AVENTURA;
            }else if(categoriaSelecionada == 3)
            {
                categoriaAlteradaPara = Categoria.ESTRATEGIA;
            }else if(categoriaSelecionada == 4)
            {
                categoriaAlteradaPara = Categoria.SHOOTER;
            }else if(categoriaSelecionada == 5)
            {
                categoriaAlteradaPara = Categoria.CORRIDA;
            }else if(categoriaSelecionada == 6)
            {
                categoriaAlteradaPara = Categoria.LUTA;
            }
            return categoriaAlteradaPara;
        }

        static void EditarNomeJogo(string nomeJogo)
        {
            BaseDeDados bd = new BaseDeDados();
            Console.WriteLine(MSG_EDITAR_JOGO_NOME);
            string nomeEditado = Console.ReadLine();
            bd.EditarNomeJogo(nomeJogo, nomeEditado);
        }

        static void EditarPrecoJogo(string nomeJogo)
        {
            BaseDeDados bd = new BaseDeDados();
            Console.WriteLine(MSG_EDITAR_JOGO_PRECO);
            string valor = Console.ReadLine();
            double valorJogo = Convert.ToDouble(valor);
            bd.EditarPrecoJogo(nomeJogo, valorJogo);
        }

        static void EditarCategoriaJogo(string nomeJogo)
        {
            BaseDeDados bd = new BaseDeDados();
            Console.WriteLine(MSG_EDITAR_JOGO_CATEGORIA);
            Categoria categoria = SelecionarCategoria();
            bd.EditarCategoriaJogo(nomeJogo, categoria);
        }

        static void Main(string[] args)
        {
            BaseDeDados bd = new BaseDeDados();
            int escolha = 0;
            do
            {
                try
                {
                    Console.Clear();
                    Console.WriteLine(ESCOLHA);
                    Console.WriteLine("1 - Cadastrar Jogo");
                    Console.WriteLine("2 - Pesquisar Jogo Pelo Nome");
                    Console.WriteLine("3 - Editar Jogo");
                    Console.WriteLine("4 - Sair");
                    escolha = Convert.ToInt32(Console.ReadLine());
                    Console.Clear();
                    switch (escolha)
                    {
                        case 1:
                            try
                            {
                                Console.WriteLine(MSG_CADASTRAR_JOGO_NOME);
                                string nomeJogo = Console.ReadLine();
                                Console.WriteLine(MSG_CADASTRAR_JOGO_PRECO);
                                string valor = Console.ReadLine();
                                double valorJogo = Convert.ToDouble(valor);
                                Console.WriteLine(MSG_CADASTRAR_JOGO_CATEGORIA);
                                Categoria categoria = SelecionarCategoria();
                                Jogo novoJogo = new Jogo(nomeJogo, valorJogo, categoria);
                                bd.AdicionarJogo(novoJogo);
                                Console.WriteLine(MSG_CADASTRAR_JOGO_SUCESSO);
                                Console.WriteLine(MSG_PESQUISA_CONTINUAR);
                                Console.ReadLine();
                                Console.Clear();
                            }
                            catch
                            {
                                Console.WriteLine(MSG_CATCH);
                            }
                            break;
                        case 2:
                            try
                            {
                                Console.WriteLine(MSG_PESQUISA_JOGO);
                                string nomeJogo = Console.ReadLine();
                                Console.Clear();
                                List<Jogo> listaDeJogos = bd.PesquisarJogoPeloNome(nomeJogo);
                                foreach (var jogo in listaDeJogos)
                                {
                                    Console.WriteLine("------------------------------------");
                                    Console.WriteLine("Nome: " + jogo.Nome);
                                    Console.WriteLine("Preco: " + jogo.Preco);
                                    Console.WriteLine("Categoria: " + jogo.Categoria);
                                    Console.WriteLine("------------------------------------");
                                }
                                Console.WriteLine(MSG_PESQUISA_CONTINUAR);
                                Console.ReadLine();
                                Console.Clear();
                            }
                            catch
                            {
                                Console.WriteLine(MSG_CATCH);
                            }
                            break;
                        case 3:

                            try
                            {
                                Console.WriteLine(ESCOLHA);
                                Console.WriteLine(EDITAR_JOGO_NOME);
                                Console.WriteLine(EDITAR_JOGO_PRECO);
                                Console.WriteLine(EDITAR_JOGO_CATEGORIA);
                                Console.WriteLine(EDITAR_JOGO_TODOS_CAMPOS);
                                int opcaoEditar = int.Parse(Console.ReadLine());
                                Console.Clear();
                                Console.WriteLine(MSG_EDITAR_JOGO_PROCURAR_JOGO);
                                string nomeJogo = Console.ReadLine();
                                if (opcaoEditar == 1)
                                {
                                    EditarNomeJogo(nomeJogo);
                                } else if (opcaoEditar == 2)
                                {
                                    EditarPrecoJogo(nomeJogo);
                                } else if (opcaoEditar == 3)
                                {
                                    EditarCategoriaJogo(nomeJogo);
                                }  else if (opcaoEditar == 4)
                                {
                                    EditarNomeJogo(nomeJogo);
                                    EditarPrecoJogo(nomeJogo);
                                    EditarCategoriaJogo(nomeJogo);
                                }
                                Console.WriteLine(MSG_EDITAR_JOGO_SUCESSO);
                                Console.WriteLine(MSG_PESQUISA_CONTINUAR);
                                Console.ReadLine();
                            }
                            catch (Exception)
                            {
                                Console.WriteLine(MSG_EDITAR_JOGO_CATCH);
                                Console.ReadLine();
                            }
                            break;
                        default:
                            Console.WriteLine(MSG_OPCAO_INVALIDA);
                            break;
                    }
                }
                catch (Exception)
                {
                    Console.Clear();
                    Console.WriteLine("Digite apenas numeros!");
                    Console.WriteLine();
                }
            } while (escolha !=4);
        }

    }
}
