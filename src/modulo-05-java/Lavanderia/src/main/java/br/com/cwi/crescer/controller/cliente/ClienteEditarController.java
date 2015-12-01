package br.com.cwi.crescer.controller.cliente;

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

import br.com.cwi.crescer.dto.ClienteDTO;
import br.com.cwi.crescer.service.CidadeService;
import br.com.cwi.crescer.service.ClienteService;


@Controller
@RequestMapping("/clientes/editar")
public class ClienteEditarController extends ClienteController {

    @Autowired
    public ClienteEditarController(ClienteService clienteService, CidadeService cidadeService) {
        super(clienteService, cidadeService);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(path = "{id}", method = RequestMethod.GET)
    public ModelAndView viewEdita(@PathVariable("id") Long id) {

        return new ModelAndView("cliente/edita", "cliente", clienteService.buscarClientePorId(id));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView editar(@Valid @ModelAttribute("cliente") ClienteDTO clienteDTO, BindingResult result,
            final RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return new ModelAndView("cliente/edita");
        }
        redirectAttributes.addFlashAttribute("mensagem", "Cliente alterado com sucesso.");
        clienteService.atualizar(clienteDTO);
        return new ModelAndView("redirect:/clientes/lista");
    }

}