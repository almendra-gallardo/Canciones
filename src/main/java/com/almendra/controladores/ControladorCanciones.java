package com.almendra.controladores;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable; // 👈 ¡ESTE ES EL IMPORT QUE FALTA!
import com.almendra.modelos.Cancion;
import com.almendra.servicios.ServicioCanciones;

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
}