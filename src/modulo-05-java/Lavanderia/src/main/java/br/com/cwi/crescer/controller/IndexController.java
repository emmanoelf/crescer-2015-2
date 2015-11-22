package br.com.cwi.crescer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.cwi.crescer.service.CidadeService;

@Controller
public class IndexController {

    private CidadeService cidadeService;

    @Autowired
    public IndexController(CidadeService cidadeService) {
        this.cidadeService = cidadeService;
    }

    @RequestMapping({ "/", "/index" })
    public ModelAndView Index() {
        ModelAndView modelView = new ModelAndView("index");
        String mensagem = "Bem vindo, Lavanderia Crescer";
        String nome = cidadeService.buscarPorNome(1L);
        modelView.addObject("mensagem", mensagem);
        modelView.addObject("nome", nome);
        return modelView;
    }

    // @RequestMapping({ "/", "/index" })
    // public String index(Model model) {
    // IndexModel indexModel = new IndexModel();
    // String mensagem = "Mensagem de teste";
    // String nome = cidadeService.buscarPorNome(1L);
    // indexModel.setMensagem(mensagem);
    // indexModel.setNome(nome);
    // model.addAttribute("model", indexModel);
    // return "index";
    // }

}
