package ar.org.centro35.herramientas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ar.org.centro35.herramientas.enums.HerramientaEstado;
import ar.org.centro35.herramientas.enums.HerramientaTipo;

@Controller
public class WebControllerMain {
    
    @GetMapping("/")
    public String getIndex(){
        return "index";
    }

    @GetMapping("/herramientas")
    public String getHerramientas(Model model){
        model.addAttribute("tipos", HerramientaTipo.values());
        model.addAttribute("estados", HerramientaEstado.values());
        return "herramientas";
    }

    @GetMapping("/socios")
    public String getSocios(){
        return "socios";
    }

    @GetMapping("/prestamos")
    public String getPrestamos(){
        return "prestamos";
    }
}
