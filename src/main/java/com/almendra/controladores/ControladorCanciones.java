package com.almendra.controladores;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.almendra.modelos.Cancion;
import com.almendra.servicios.ServicioCanciones;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.validation.BindingResult;
import jakarta.validation.Valid;

@Controller
public class ControladorCanciones {

    @Autowired
    private ServicioCanciones servicio;

    @GetMapping("/canciones")
    public String desplegarCanciones(Model model) {
        List<Cancion> listaCanciones = servicio.obtenerTodasLasCanciones();
        model.addAttribute("listaCanciones", listaCanciones);
        return "canciones";
    }
    
    @GetMapping("/canciones/detalle/{id}")
    public String verDetalle(@PathVariable("id") Long id, Model model) {
        Cancion cancion = servicio.obtenerCancionPorId(id);
        model.addAttribute("cancion", cancion);
        return "detalleCancion"; 
    }
 
    @GetMapping("/canciones/formulario/agregar/{idCancion}")
    public String formularioAgregarCancion(@PathVariable("idCancion") Long idCancion, @ModelAttribute("cancion") Cancion cancion) {
        return "agregarCancion";
    }

    @PostMapping("/canciones/procesa/agregar")
    public String procesarAgregarCancion(@Valid @ModelAttribute("cancion") Cancion cancion, BindingResult result) {
        if (result.hasErrors()) {
            return "agregarCancion";
        }
        servicio.agregarCancion(cancion);
        return "redirect:/canciones";
    }

  
    @GetMapping("/canciones/formulario/editar/{idCancion}")
    public String formularioEditarCancion(@PathVariable("idCancion") Long idCancion, Model model) {
        Cancion cancion = servicio.obtenerCancionPorId(idCancion);
        model.addAttribute("cancion", cancion);
        return "editarCancion";
    }

   
    @PostMapping("/canciones/procesa/editar/{id}")
    public String procesarEditarCancion(@PathVariable("id") Long id, @Valid @ModelAttribute("cancion") Cancion cancion, BindingResult result) {
        if (result.hasErrors()) {
            return "editarCancion";
        }
        cancion.setId(id); 
        servicio.actualizaCancion(cancion);
        return "redirect:/canciones";
    }
}