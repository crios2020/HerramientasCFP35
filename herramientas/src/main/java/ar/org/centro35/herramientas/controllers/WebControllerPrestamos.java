package ar.org.centro35.herramientas.controllers;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ar.org.centro35.herramientas.entities.Herramienta;
import ar.org.centro35.herramientas.entities.Prestamo;
import ar.org.centro35.herramientas.entities.Socio;
import ar.org.centro35.herramientas.enums.PrestamoEstado;
import ar.org.centro35.herramientas.enums.PrestamoTipo;
import ar.org.centro35.herramientas.repositories.HerramientaRepository;
import ar.org.centro35.herramientas.repositories.PrestamoRepository;
import ar.org.centro35.herramientas.repositories.SocioRepository;
import ar.org.centro35.herramientas.utils.properties.SystemProperties;

@Controller
public class WebControllerPrestamos {

    private PrestamoRepository pr=new PrestamoRepository();
    private HerramientaRepository hr=new HerramientaRepository();
    private SocioRepository sr=new SocioRepository();
    private String mensajePrestamo = "Ingrese una nuevo prestamo!";

    @GetMapping("/prestamos")
    public String getPrestamos( @RequestParam(name="buscarDescripcion", defaultValue = "", required = false) String buscarDescripcion, 
                                @RequestParam(name="buscarSocio", defaultValue = "", required = false) String buscarSocio,
                                @RequestParam(name="buscar", defaultValue = "", required = false) String buscar,
                                Model model) {
        model.addAttribute("mensajePrestamo", mensajePrestamo);
        model.addAttribute("herramientas", hr.getAll());
        model.addAttribute("likeDescripcion", hr.getLikeDescripcion(buscarDescripcion));
        model.addAttribute("socios", sr.getAll());
        model.addAttribute("likeApellido", sr.getLikeApellido(buscarSocio));
        model.addAttribute("prestamo", new Prestamo());
        model.addAttribute("tipoPrestamos", PrestamoTipo.values());
        model.addAttribute("prestamos", pr.getPrestamosPendientes());
        model.addAttribute("prestamosPatron", pr.getPrestamosPendientes(buscar));
        Map<Integer, Herramienta> mapaHerramientas=new LinkedHashMap();
        hr
            .getAllXL()
            .forEach(h->mapaHerramientas.put(h.getId(), h));
        model.addAttribute("mapaHerramientas", mapaHerramientas);
        Map<Integer, Socio> mapaSocios=new LinkedHashMap();
        sr
            .getAllXL()
            .forEach(s->mapaSocios.put(s.getId(), s));
        model.addAttribute("mapaSocios", mapaSocios);
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
        mensajePrestamo = "Se actualizo el prestamo id: "+idDevolver+"!"; 
        return "redirect:prestamos";     
    }

    @PostMapping("prestamosRemove")
    public String prestamosRemove(@RequestParam(name="idBorrar", defaultValue = "0", required = false) int idBorrar){
        pr.remove(pr.getById(idBorrar));
        mensajePrestamo = "Se borro el prestamo id: "+idBorrar+"!";   
        return "redirect:prestamos";     
    }

}
