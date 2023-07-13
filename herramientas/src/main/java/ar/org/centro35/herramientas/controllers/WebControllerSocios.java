package ar.org.centro35.herramientas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebControllerSocios {
    
    @GetMapping("/socios")
    public String getSocios(){
        return "socios";
    }

}
