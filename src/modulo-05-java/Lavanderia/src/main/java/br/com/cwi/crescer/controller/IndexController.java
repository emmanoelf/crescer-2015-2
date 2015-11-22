package br.com.cwi.crescer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.cwi.crescer.service.ProdutoService;

@Controller
public class IndexController {

    // private CidadeService cidadeService;
    // private ServicoService servicoService;
    // private MaterialService materialService;
    // private ClienteService clienteService;
    private ProdutoService produtoService;

    @Autowired
    public IndexController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @RequestMapping({ "/", "/index" })
    public ModelAndView Index() {
        ModelAndView modelView = new ModelAndView("index");
        String mensagem = "Bem vindo, Lavanderia Crescer";
        Long descricao = produtoService.buscarPeloId(1L);
        modelView.addObject("mensagem", mensagem);
        modelView.addObject("descricao", descricao);
        return modelView;
    }

    //    @RequestMapping({ "/", "/index" })
    //    public String index(Model model) {
    //        IndexModel indexModel = new IndexModel();
    //        String mensagem = "Mensagem de teste";
    //        String nome = servicoService.buscarPorDescricao(1L);
    //        indexModel.setMensagem(mensagem);
    //        indexModel.setNome(nome);
    //        model.addAttribute("model", indexModel);
    //        return "index";
    //    }

}
