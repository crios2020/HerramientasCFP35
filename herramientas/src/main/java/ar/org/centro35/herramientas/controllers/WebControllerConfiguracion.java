package ar.org.centro35.herramientas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ar.org.centro35.herramientas.connectors.Connector;
import ar.org.centro35.herramientas.utils.SystemProperties;

@Controller
public class WebControllerConfiguracion {

    @GetMapping("/configuracion")
    public String getConfiguracion(Model model){
        SystemProperties sp=new SystemProperties();
        model.addAttribute("system", sp.getSystem());
        model.addAttribute("java", sp.getJava());
        model.addAttribute("user", sp.getUser());
        model.addAttribute("ubicacion", sp.getUbicacion());
        model.addAttribute("fecha", sp.getFecha());
        model.addAttribute("url", Connector.getUrl());
        return "configuracion";
    }

}
