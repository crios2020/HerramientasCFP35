package ar.org.centro35.herramientas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebControllerMain {
    
    @GetMapping("/")
    public String getIndex(){
        return "index";
    }

    @GetMapping("/herramientas")
    public String getHerramientas(){
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
