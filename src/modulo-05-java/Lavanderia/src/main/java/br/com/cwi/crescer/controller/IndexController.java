package br.com.cwi.crescer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @RequestMapping("/")
    public ModelAndView Index() {
        ModelAndView modelView = new ModelAndView("index");
        String mensagem = "Bem vindo, Lavanderia Crescer";
        modelView.addObject("mensagem", mensagem);
        return modelView;
    }
}
