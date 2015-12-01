package br.com.cwi.crescer.controller.produto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cwi.crescer.domain.Material;
import br.com.cwi.crescer.domain.Servico;
import br.com.cwi.crescer.service.MaterialService;
import br.com.cwi.crescer.service.ProdutoService;
import br.com.cwi.crescer.service.ServicoService;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    protected ProdutoService produtoService;
    protected ServicoService servicoService;
    protected MaterialService materialService;

    @Autowired
    public ProdutoController(ProdutoService produtoService, ServicoService servicoService, MaterialService materialService) {
        this.produtoService = produtoService;
        this.servicoService = servicoService;
        this.materialService = materialService;
    }

    @ModelAttribute("servicos")
    public List<Servico> comboServicos() {
        return servicoService.listar();
    }

    @ModelAttribute("material")
    public List<Material> comboMaterial() {
        return materialService.listar();
    }
}
