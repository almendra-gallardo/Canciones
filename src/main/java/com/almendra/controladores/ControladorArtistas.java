package com.almendra.controladores;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.almendra.modelos.Artista;
import com.almendra.servicios.ServicioArtistas;
import jakarta.validation.Valid;

@Controller
public class ControladorArtistas {

    @Autowired
    private ServicioArtistas servicioArtistas;


    @GetMapping("/artistas")
    public String desplegarArtistas(Model model) {
        List<Artista> listaArtistas = servicioArtistas.obtenerTodosLosArtistas();
        model.addAttribute("listaArtistas", listaArtistas);
        return "artistas";
    }

   
    @GetMapping("/artistas/detalle/{idArtista}")
    public String desplegarDetalleArtista(@PathVariable("idArtista") Long idArtista, Model model) {
        Artista artista = servicioArtistas.obtenerArtistaPorId(idArtista);
        model.addAttribute("artista", artista);
        return "detalleArtista";
    }

    
    @GetMapping("/artistas/formulario/agregar/{idArtista}")
    public String formularioAgregarArtista(@PathVariable("idArtista") Long idArtista, @ModelAttribute("artista") Artista artista) {
        return "agregarArtista";
    }

   
    @PostMapping("/artistas/procesa/agregar")
    public String procesarAgregarArtista(@Valid @ModelAttribute("artista") Artista artista, BindingResult result) {
        if (result.hasErrors()) {
            return "agregarArtista";
        }
        servicioArtistas.agregarArtista(artista);
        return "redirect:/artistas";
    }
 
}