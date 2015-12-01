package br.com.cwi.crescer.controller.produto;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cwi.crescer.dto.ProdutoDTOIncluir;
import br.com.cwi.crescer.service.MaterialService;
import br.com.cwi.crescer.service.ProdutoService;
import br.com.cwi.crescer.service.ServicoService;

@Controller
@RequestMapping("/produtos/incluir")
public class ProdutoIncluirController extends ProdutoController {

    @Autowired
    public ProdutoIncluirController(ProdutoService produtoService, ServicoService servicoService, MaterialService materialService) {
        super(produtoService, servicoService, materialService);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView incluir() {
        return new ModelAndView("produto/novo", "produto", new ProdutoDTOIncluir());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView incluir(
            @Valid @ModelAttribute("produto") ProdutoDTOIncluir dto, BindingResult result,
            final RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return new ModelAndView("produto/novo");
        }
        produtoService.incluir(dto);
        redirectAttributes.addFlashAttribute("mensagem", "Produto adicionado com sucesso");
        return new ModelAndView("redirect:/produtos/listar");
    }

}
