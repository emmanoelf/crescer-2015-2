﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Locadora.Web.MVC.Models
{
    public class RelatorioModel
    {
        public IList<JogoModel> ListaJogos { get; set; }
        public int QuantidadeJogos { get; set; }

        public RelatorioModel()
        {
            ListaJogos = new List<JogoModel>();
        }
    }
}