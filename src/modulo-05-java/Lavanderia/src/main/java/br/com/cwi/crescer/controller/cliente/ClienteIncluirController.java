package br.com.cwi.crescer.controller.cliente;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cwi.crescer.dto.ClienteDTO;
import br.com.cwi.crescer.service.CidadeService;
import br.com.cwi.crescer.service.ClienteService;

@Controller
@RequestMapping("/clientes/incluir")
public class ClienteIncluirController extends ClienteController {

    @Autowired
    public ClienteIncluirController(ClienteService clienteService, CidadeService cidadeService) {
        super(clienteService, cidadeService);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView incluir() {
        return new ModelAndView("cliente/novo", "cliente", new ClienteDTO());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView incluir(
            @Valid @ModelAttribute("cliente") ClienteDTO dto, BindingResult result,
            final RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return new ModelAndView("cliente/novo");
        }
        clienteService.incluir(dto);
        redirectAttributes.addFlashAttribute("mensagem", "Cliente cadastrado com sucesso");
        return new ModelAndView("redirect:/clientes/lista");
    }
}
