﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DbFuncionarios
{
    public class BaseDeDados
    {
        public List<Funcionario> Funcionarios
        {
            get; private set;
        }

        public BaseDeDados()
        {
            CriarBase();
        }

        private void CriarBase()
        {
            Funcionarios = new List<Funcionario>();

            Cargo desenvolvedor = new Cargo("Desenvolvedor", 190);
            Cargo analista = new Cargo("Analista", 250);
            Cargo gerente = new Cargo("Gerente", 550.5);

            Funcionario lucasLeal = new Funcionario(1, "Lucas Leal", new DateTime(1995, 01, 24));
            lucasLeal.Cargo = desenvolvedor;
            lucasLeal.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(lucasLeal);

            Funcionario jeanPinzon = new Funcionario(2, "Jean Pinzon", new DateTime(1991, 04, 25));
            jeanPinzon.Cargo = desenvolvedor;
            jeanPinzon.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(jeanPinzon);

            Funcionario rafaelBenetti = new Funcionario(3, "Rafael Benetti", new DateTime(1991, 08, 15));
            rafaelBenetti.Cargo = desenvolvedor;
            rafaelBenetti.TurnoTrabalho = TurnoTrabalho.Noite;
            Funcionarios.Add(rafaelBenetti);

            Funcionario mauricioBorges = new Funcionario(4, "Maurício Borges", new DateTime(1996, 11, 30));
            mauricioBorges.Cargo = desenvolvedor;
            mauricioBorges.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(mauricioBorges);

            Funcionario leandroAndreolli = new Funcionario(5, "Leandro Andreolli", new DateTime(1990, 03, 07));
            leandroAndreolli.Cargo = desenvolvedor;
            leandroAndreolli.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(leandroAndreolli);

            Funcionario felipeNervo = new Funcionario(6, "Felipe Nervo", new DateTime(1994, 01, 12));
            felipeNervo.Cargo = desenvolvedor;
            felipeNervo.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(felipeNervo);

            Funcionario lucasKauer = new Funcionario(7, "Lucas Kauer", new DateTime(1997, 05, 10));
            lucasKauer.Cargo = desenvolvedor;
            lucasKauer.TurnoTrabalho = TurnoTrabalho.Noite;
            Funcionarios.Add(lucasKauer);

            Funcionario eduardoArnold = new Funcionario(8, "Eduardo Arnold", new DateTime(1989, 09, 16));
            eduardoArnold.Cargo = desenvolvedor;
            eduardoArnold.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(eduardoArnold);

            Funcionario gabrielAlboy = new Funcionario(9, "Gabriel Alboy", new DateTime(1990, 02, 25));
            gabrielAlboy.Cargo = analista;
            gabrielAlboy.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(gabrielAlboy);

            Funcionario carlosHenrique = new Funcionario(10, "Carlos Henrique", new DateTime(1965, 12, 02));
            carlosHenrique.Cargo = analista;
            carlosHenrique.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(carlosHenrique);

            Funcionario margareteRicardo = new Funcionario(11, "Margarete Ricardo", new DateTime(1980, 10, 10));
            margareteRicardo.Cargo = gerente;
            margareteRicardo.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(margareteRicardo);
        }

        public IList<Funcionario> BuscarOrdenadosPorCargo()
        {
            var resultado = Funcionarios.OrderBy(funcionario => funcionario.Cargo.Titulo).ToList();
            return resultado;
        }

        public IList<Funcionario> BuscarPorNome(string nome)
        {
            var resultado = Funcionarios.Where(funcionario => funcionario.Nome.Contains(nome)).OrderBy(funcionario => funcionario.Nome).ToList();
            return resultado;
        }

        public IList<dynamic> BuscaRapida()
        {
            var query = from func in Funcionarios
                        select new
                        {
                            Nome = func.Nome,
                            TituloCargo = func.Cargo.Titulo
                        };
            return query.ToList<dynamic>();
        }

        public IList<Funcionario> BuscarPorTurno(params TurnoTrabalho[] turnos)
        {
            var resultado = Funcionarios.Where(funcionario => turnos.Contains(funcionario.TurnoTrabalho)).ToList();
            return resultado;
        }

        public IList<dynamic> QtdFuncionariosPorTurno()
        {
            var query = from func in Funcionarios
                        group func by func.TurnoTrabalho into f
                        select new
                        {
                            Turno = f.Key,
                            Contador = f.Count()
                        };
            return query.ToList<dynamic>();
        }

        public IList<Funcionario> BuscarPorCargo(Cargo cargo)
        {
            var resultado = Funcionarios.Where(funcionario => funcionario.Cargo.Equals(cargo)).ToList();
            return resultado;
        }

        public IList<Funcionario> FiltrarPorIdadeAproximada(int idade)
        {
            var agora = DateTime.Now;
            var query = from func in Funcionarios
                        where agora.Year - func.DataNascimento.Year >= idade - 5 &&
                        agora.Year - func.DataNascimento.Year <= idade + 5
                        select func;
            return query.ToList();
        }

        public double SalarioMedio(TurnoTrabalho? turno)
        {
            return Funcionarios.Where(func => turno == null || func.TurnoTrabalho == turno).Average(func => func.Cargo.Salario);
        }

        public IList<Funcionario> AniversariantesDoMes()
        {
            var query = from func in Funcionarios
                        where DateTime.Now.Month == func.DataNascimento.Month
                        select func;
            return query.ToList();
        }

        /*public dynamic FuncionarioMaisComplexo()
        {
         TO DO...
        }*/
    }
}
