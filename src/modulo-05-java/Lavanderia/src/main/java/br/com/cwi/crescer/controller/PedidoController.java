package br.com.cwi.crescer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cwi.crescer.dto.ClienteResumoDTO;
import br.com.cwi.crescer.dto.PedidoDTO;
import br.com.cwi.crescer.service.ClienteService;
import br.com.cwi.crescer.service.MaterialService;
import br.com.cwi.crescer.service.PedidoService;
import br.com.cwi.crescer.service.ServicoService;

@Controller
@RequestMapping("pedidos")
public class PedidoController {

    private PedidoService pedidoService;
    private ClienteService clienteService;
    private MaterialService materialService;
    private ServicoService servicoService;

    @Autowired
    public PedidoController(PedidoService pedidoService, ClienteService clienteService, MaterialService materialService, ServicoService servicoService) {
        this.pedidoService = pedidoService;
        this.clienteService = clienteService;
        this.materialService = materialService;
        this.servicoService = servicoService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView listar() {
        return new ModelAndView("pedido/lista", "pedidos", pedidoService.listarPedidosListaDTO());
    }

    @RequestMapping(path = ("/novo"), method = RequestMethod.GET)
    public ModelAndView novo() {
        return new ModelAndView("pedido/novo", "pedido", new PedidoDTO());
    }

    // @RequestMapping(path = ("/novo"), method = RequestMethod.POST)
    // public ModelAndView novo(
    // @Valid @ModelAttribute("pedido") PedidoDTO pedido, BindingResult result,
    // RedirectAttributes redirectAttributes) {
    // if (result.hasErrors()) {
    // return new ModelAndView("pedido/novo");
    // }
    // redirectAttributes.addFlashAttribute("mensagem", "Pedido adicionado com sucesso");
    // pedidoService.incluir(pedido);
    // return new ModelAndView("redirect:/pedidos");
    // }

    @ModelAttribute("clientes")
    public List<ClienteResumoDTO> comboClientes() {
        return clienteService.listarClientesAtivos();
    }
}
