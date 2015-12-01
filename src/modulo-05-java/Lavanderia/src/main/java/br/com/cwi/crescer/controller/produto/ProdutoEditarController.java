package br.com.cwi.crescer.controller.produto;

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

import br.com.cwi.crescer.dto.ProdutoDTOEditar;
import br.com.cwi.crescer.service.MaterialService;
import br.com.cwi.crescer.service.ProdutoService;
import br.com.cwi.crescer.service.ServicoService;

@Controller
@RequestMapping("produtos/editar")
public class ProdutoEditarController extends ProdutoController {

    @Autowired
    public ProdutoEditarController(ProdutoService produtoService, ServicoService servicoService, MaterialService materialService) {
        super(produtoService, servicoService, materialService);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ModelAndView editar(@PathVariable("id") Long id) {
        return new ModelAndView("produto/editar", "produto", produtoService.buscarPorId(id));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView editar(
            @Valid @ModelAttribute("produto") ProdutoDTOEditar dto, BindingResult result,
            final RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return new ModelAndView("produto/editar");
        }
        redirectAttributes.addFlashAttribute("mensagem", "Produto editado com sucesso");
        produtoService.atualizar(dto);
        return new ModelAndView("redirect:/produtos/listar");
    }
}
