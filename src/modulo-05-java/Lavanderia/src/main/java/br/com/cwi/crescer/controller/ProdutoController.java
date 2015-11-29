package br.com.cwi.crescer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cwi.crescer.service.MaterialService;
import br.com.cwi.crescer.service.ProdutoService;
import br.com.cwi.crescer.service.ServicoService;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    private ProdutoService produtoService;
    private ServicoService servicoService;
    private MaterialService materialService;

    @Autowired
    public ProdutoController(ProdutoService produtoService, ServicoService servicoService, MaterialService materialService) {
        this.produtoService = produtoService;
        this.servicoService = servicoService;
        this.materialService = materialService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView listar() {
        return new ModelAndView("produto/lista", "produtos", produtoService.listarProdutos());
    }
}
