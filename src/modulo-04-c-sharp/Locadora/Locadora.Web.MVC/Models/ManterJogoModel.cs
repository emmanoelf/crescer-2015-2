using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace Locadora.Web.MVC.Models
{
    public class ManterJogoModel
    {
        public int?  Id { get; set; }

        [Required]
        public string Nome { get; set; }

        [Required]
        public Categoria? Categoria { get; set; }

        [Required]
        [DisplayName("Descrição")]
        public string Descricao { get; set; }

        [Required]
        public Selo? Selo { get; set; }

        public string Imagem { get; set; }

        [DisplayName("Vídeo")]
        public string Video { get; set; }
    }
}