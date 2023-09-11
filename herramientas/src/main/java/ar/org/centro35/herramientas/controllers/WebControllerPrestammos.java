package ar.org.centro35.herramientas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ar.org.centro35.herramientas.entities.Prestamo;
import ar.org.centro35.herramientas.enums.PrestamoEstado;
import ar.org.centro35.herramientas.enums.PrestamoTipo;
import ar.org.centro35.herramientas.repositories.HerramientaRepository;
import ar.org.centro35.herramientas.repositories.PrestamoRepository;
import ar.org.centro35.herramientas.repositories.SocioRepository;
import ar.org.centro35.herramientas.utils.SystemProperties;

@Controller
public class WebControllerPrestammos {

    private PrestamoRepository pr=new PrestamoRepository();
    private HerramientaRepository hr=new HerramientaRepository();
    private SocioRepository sr=new SocioRepository();
    private String mensajePrestamo = "Ingrese una nuevo prestamo!";

    @GetMapping("/prestamos")
    public String getPrestamos( @RequestParam(name="buscarDescripcion", defaultValue = "", required = false) String buscarDescripcion, 
                                @RequestParam(name="buscarSocio", defaultValue = "", required = false) String buscarSocio,
                                Model model) {
        model.addAttribute("mensajePrestamo", mensajePrestamo);
        model.addAttribute("herramientas", hr.getAll());
        model.addAttribute("likeDescripcion", hr.getLikeDescripcion(buscarDescripcion));
        model.addAttribute("socios", sr.getAll());
        model.addAttribute("likeApellido", sr.getLikeApellido(buscarSocio));
        model.addAttribute("prestamo", new Prestamo());
        model.addAttribute("tipoPrestamos", PrestamoTipo.values());
        model.addAttribute("prestamos", pr.getAll());
        //System.out.println(buscarDescripcion);
        //hr.getLikeDescripcion(buscarDescripcion).forEach(System.out::println);
        return "prestamos";
    }

    @PostMapping("/prestamosSave")
    public String prestamosSave(@ModelAttribute Prestamo prestamo) {
        System.out.println("----------------------------------------------------");
        prestamo.setEstado_devolucion(PrestamoEstado.PENDIENTE);
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

    @PostMapping("/prestamosDevolver")
    public String prestamosDevolver(@RequestParam(name="idDevolver", defaultValue = "0", required = false) int idDevolver){
        Prestamo prestamox=pr.getById(idDevolver);
        prestamox.setEstado_devolucion(PrestamoEstado.TERMINADO);
        prestamox.setFecha_devolucion(new SystemProperties().getFechaSQL());
        pr.update(prestamox);
        return "redirect:prestamos";     
    }

}
