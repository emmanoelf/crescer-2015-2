package br.com.cwi.crescer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.cwi.crescer.service.PedidoService;

@Controller
public class IndexController {

    // private CidadeService cidadeService;
    // private ServicoService servicoService;
    // private MaterialService materialService;
    // private ClienteService clienteService;
    // private ProdutoService produtoService;
    private PedidoService pedidoService;

    @Autowired
    public IndexController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @RequestMapping({ "/", "/index" })
    public ModelAndView Index() {
        ModelAndView modelView = new ModelAndView("index");
        String mensagem = "Bem vindo, Lavanderia Crescer";
        Long descricao = pedidoService.buscarPorId(3L);
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
