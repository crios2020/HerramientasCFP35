package ar.org.centro35.herramientas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ar.org.centro35.herramientas.entities.Prestamo;
import ar.org.centro35.herramientas.repositories.HerramientaRepository;
import ar.org.centro35.herramientas.repositories.PrestamoRepository;

@Controller
public class WebControllerPrestammos {

    private PrestamoRepository pr=new PrestamoRepository();
    private HerramientaRepository hr=new HerramientaRepository();
    private String mensajePrestamo = "Ingrese una nuevo prestamo!";

    @GetMapping("/prestamos")
    public String getPrestamos(Model model) {
        model.addAttribute("mensajePrestamo", mensajePrestamo);
        model.addAttribute("herramientas", hr.getAll());
        model.addAttribute("prestamo", new Prestamo());
        return "prestamos";
    }

    @PostMapping("/prestamosSave")
    public String prestamosSave(@ModelAttribute Prestamo prestamo) {
        System.out.println("----------------------------------------------------");
        System.out.println(prestamo);
        System.out.println("----------------------------------------------------");
        try {
            pr.save(prestamo);
            if(prestamo.getId()>0){
                mensajePrestamo="Se guardo el prestamo id:"+prestamo.getId();
            }else{
                mensajePrestamo="No se pudo guardar el prestamo!";
            }
        } catch (Exception e) {
            System.out.println("*************************************************************");
            System.out.println(e);
            System.out.println("*************************************************************");
            mensajePrestamo = "Ocurrio un error!";
        }
        return "redirect:prestamos";
    }

}
