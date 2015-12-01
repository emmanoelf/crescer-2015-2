package br.com.cwi.crescer.controller.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cwi.crescer.dto.ClienteDTO;
import br.com.cwi.crescer.service.CidadeService;
import br.com.cwi.crescer.service.ClienteService;

@Controller
@RequestMapping("/clientes/remover")
public class ClienteRemoverController extends ClienteController {

    @Autowired
    public ClienteRemoverController(ClienteService clienteService, CidadeService cidadeService) {
        super(clienteService, cidadeService);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ModelAndView remover(@PathVariable("id") Long id) {
        return new ModelAndView("cliente/remove", "cliente", clienteService.buscarClientePorId(id));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView remover(ClienteDTO dto, final RedirectAttributes redirectAttributes) {
        clienteService.remover(dto.getId());
        redirectAttributes.addFlashAttribute("mensagem", "Cliente removido com sucesso");
        return new ModelAndView("redirect:/clientes/lista");
    }
}
