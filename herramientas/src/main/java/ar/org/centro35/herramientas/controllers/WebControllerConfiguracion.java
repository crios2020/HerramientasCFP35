package ar.org.centro35.herramientas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ar.org.centro35.herramientas.connectors.Connector;
import ar.org.centro35.herramientas.entities.Socio;
import ar.org.centro35.herramientas.repositories.HerramientaRepository;
import ar.org.centro35.herramientas.repositories.PrestamoRepository;
import ar.org.centro35.herramientas.repositories.SocioRepository;
import ar.org.centro35.herramientas.utils.files.FileText;
import ar.org.centro35.herramientas.utils.properties.SystemProperties;

@Controller
public class WebControllerConfiguracion {

    private PrestamoRepository pr=new PrestamoRepository();
    private HerramientaRepository hr=new HerramientaRepository();
    private SocioRepository sr=new SocioRepository();
    private String mensajeConfiguracion = "Es posible descargar un backup en formato .cvs";

    @GetMapping("/configuracion")
    public String getConfiguracion(Model model){
        SystemProperties sp=new SystemProperties();
        model.addAttribute("mensajeConfiguracion", mensajeConfiguracion);
        model.addAttribute("system", sp.getSystem());
        model.addAttribute("java", sp.getJava());
        model.addAttribute("user", sp.getUser());
        model.addAttribute("ubicacion", sp.getUbicacion());
        model.addAttribute("fecha", sp.getFecha());
        model.addAttribute("url", Connector.getUrl());
        return "configuracion";
    }

    @GetMapping("/sociosBackup")
    public String sociosBackup() {
        String file="socios-"+new SystemProperties().getFechaSQL()+".csv";
        FileText fText=new FileText(file);
        fText.clear();
        fText.addLine("id,nombre,apellido,tipo_documento,numero_documento,dirección,celular,teléfono_linea,email,comentarios");
        for(Socio socio: sr.getAll()){
            fText.addLine(  
                socio.getId()+","+
                ((socio.getNombre()==null)?",":socio.getNombre().replace(",", "-")+",")+
                ((socio.getApellido()==null)?",":socio.getApellido().replace(",", "-")+",")+
                socio.getTipo_documento()+","+
                ((socio.getNumero_documento()==null)?",":socio.getNumero_documento().replace(",", "-")+",")+
                ((socio.getDireccion()==null)?",":socio.getDireccion().replace(",", "-")+",")+
                ((socio.getCelular()==null)?",":socio.getCelular().replace(",", "-")+",")+
                ((socio.getTelefono_linea()==null)?",":socio.getTelefono_linea().replace(",", "-")+",")+
                ((socio.getEmail()==null)?",":socio.getEmail().replace(",", "-")+",")+
                ((socio.getComentarios()==null)?",":socio.getComentarios().replace(",", "-"))
            );
        }
        mensajeConfiguracion="Se realizo el backup de entidad socios, archivo: "+file;
        return "redirect:configuracion";
    }

}
