package br.com.cwi.crescer.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cwi.crescer.domain.Material;
import br.com.cwi.crescer.domain.Servico;
import br.com.cwi.crescer.dto.ProdutoDTOEditar;
import br.com.cwi.crescer.dto.ProdutoDTOIncluir;
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

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(path = "/novo", method = RequestMethod.GET)
    public ModelAndView incluir() {
        return new ModelAndView("produto/novo", "produto", new ProdutoDTOIncluir());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(path = "/novo", method = RequestMethod.POST)
    public ModelAndView incluir(
            @Valid @ModelAttribute("produto") ProdutoDTOIncluir dto, BindingResult result,
            final RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return new ModelAndView("produto/novo");
        }
        produtoService.incluir(dto);
        redirectAttributes.addFlashAttribute("mensagem", "Produto adicionado com sucesso");
        return new ModelAndView("redirect:/produtos");
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(path = "/editar/{id}", method = RequestMethod.GET)
    public ModelAndView edita(@PathVariable("id") Long id) {
        return new ModelAndView("produto/editar", "produto", produtoService.buscarPorId(id));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(path = "/editar", method = RequestMethod.POST)
    public ModelAndView editar(
            @Valid @ModelAttribute("produto") ProdutoDTOEditar dto, BindingResult result,
            final RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return new ModelAndView("produto/editar");
        }
        redirectAttributes.addFlashAttribute("mensagem", "Produto editado com sucesso");
        produtoService.atualizar(dto);
        return new ModelAndView("redirect:/produtos");
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
