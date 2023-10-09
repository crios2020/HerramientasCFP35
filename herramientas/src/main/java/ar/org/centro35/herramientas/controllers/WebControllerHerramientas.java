package ar.org.centro35.herramientas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ar.org.centro35.herramientas.entities.Herramienta;
import ar.org.centro35.herramientas.enums.HerramientaEstado;
import ar.org.centro35.herramientas.enums.HerramientaTipo;
import ar.org.centro35.herramientas.repositories.HerramientaRepository;
import ar.org.centro35.herramientas.repositories.PrestamoRepository;

@Controller
public class WebControllerHerramientas {

    private HerramientaRepository hr=new HerramientaRepository(); 
    private PrestamoRepository pr=new PrestamoRepository();
    private String mensajeHerramienta = "Ingrese una nueva herramienta!";

    @GetMapping("/herramientas")
    public String getHerramientas(@RequestParam(name="buscar", defaultValue = "", required = false) String buscar, Model model) {
        model.addAttribute("tipos", HerramientaTipo.values());
        model.addAttribute("estados", HerramientaEstado.values());
        model.addAttribute("mensajeHerramienta", mensajeHerramienta);
        model.addAttribute("herramienta", new Herramienta());
        model.addAttribute("likeDescripcion", hr.getLikeDescripcion(buscar));
        return "herramientas";
    }

    @PostMapping("/herramientasSave")
    public String herramientasSave(@ModelAttribute Herramienta herramienta) {
        try {
            hr.save(herramienta);
            if(herramienta.getId()>0){
                mensajeHerramienta="Se guardo la herramienta id:"+herramienta.getId();
            }else{
                mensajeHerramienta="No se pudo guardar la herramienta!";
            }
        } catch (Exception e) {
            System.out.println("*************************************************************");
            System.out.println(e);
            System.out.println("*************************************************************");
            mensajeHerramienta = "Ocurrio un error!";
        }
        return "redirect:herramientas";
    }

    @PostMapping("herramientasRemove")
    public String herramientasRemove(@RequestParam(name="idBorrar", defaultValue = "0", required = false) int idBorrar){
        // if(pr.getCantidadPrestamos(idBorrar)==0){
        //     hr.remove(hr.getById(idBorrar)); 
        //     mensajeHerramienta = "Se borro la herramienta id: "+idBorrar+"!";   
        // }else{
        //     mensajeHerramienta = "No se pudo borrar la herramienta id: "+idBorrar+", por que tiene prestamos activos!";
        // }

        hr.remove(hr.getById(idBorrar)); 
        mensajeHerramienta = "Se borro la herramienta id: "+idBorrar+"!";   
        return "redirect:herramientas";     
    }
}
