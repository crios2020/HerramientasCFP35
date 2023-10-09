package ar.org.centro35.herramientas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ar.org.centro35.herramientas.entities.Socio;
import ar.org.centro35.herramientas.enums.TipoDocumento;
import ar.org.centro35.herramientas.repositories.PrestamoRepository;
import ar.org.centro35.herramientas.repositories.SocioRepository;

@Controller
public class WebControllerSocios {
    
    private SocioRepository sr=new SocioRepository();
    private PrestamoRepository pr=new PrestamoRepository();
    private String mensajeSocio = "Ingrese una nuevo Socio!";

    @GetMapping("/socios")
    public String getSocios(@RequestParam(name="buscar", defaultValue = "", required = false) String buscar, Model model){
        model.addAttribute("tipos", TipoDocumento.values());
        model.addAttribute("mensajeSocio", mensajeSocio);
        model.addAttribute("socio", new Socio());
        model.addAttribute("likeApellido", sr.getLikeApellido(buscar));
        return "socios";
    }

    @PostMapping("/sociosSave")
    public String sociosSave(@ModelAttribute Socio socio) {
        System.out.println("----------------------------------------------------");
        System.out.println(socio);
        System.out.println("----------------------------------------------------");
        try {
            sr.save(socio);
            if(socio.getId()>0){
                mensajeSocio="Se guardo el socio id:"+socio.getId();
            }else{
                mensajeSocio="No se pudo guardar el socio!";
            }
        } catch (Exception e) {
            System.out.println("*************************************************************");
            System.out.println(e);
            System.out.println("*************************************************************");
            mensajeSocio = "Ocurrio un error!";
        }
        return "redirect:socios";
    }

    @PostMapping("sociosRemove")
    public String herramientasRemove(@RequestParam(name="idBorrar", defaultValue = "0", required = false) int idBorrar){
        // if(pr.getCantidadPrestamosSocio(idBorrar)==0){
        //     sr.remove(sr.getById(idBorrar)); 
        //     mensajeSocio = "Se borro el socio id: "+idBorrar+"!";   
        // }else{
        //     mensajeSocio = "No se pudo borrar el socio id: "+idBorrar+", por que tiene prestamos activos!";
        // }
        sr.remove(sr.getById(idBorrar)); 
        mensajeSocio = "Se borro el socio id: "+idBorrar+"!";   
        return "redirect:socios";     
    }

}
