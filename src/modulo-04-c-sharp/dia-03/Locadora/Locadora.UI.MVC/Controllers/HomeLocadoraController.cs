using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Locadora.UI.MVC.Controllers
{
    public class HomeLocadoraController : Controller
    {
        // GET: Locadora
        public ActionResult Index()
        {
            return View();
        }
    }
}