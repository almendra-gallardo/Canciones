package com.almendra.servicios;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.almendra.modelos.Cancion;
import com.almendra.repositorios.RepositorioCanciones;

@Service
public class ServicioCanciones {


    private final RepositorioCanciones repoCanciones;

  
    public ServicioCanciones(RepositorioCanciones repoCanciones) {
        this.repoCanciones = repoCanciones;
    }

    
    public Cancion actualizaCancion(Cancion cancion) {
        return repoCanciones.save(cancion);
    }

   
    public List<Cancion> obtenerTodasLasCanciones() {
        return repoCanciones.findAll();
    }
      
    public Cancion obtenerCancionPorId(Long id) {
        Optional<Cancion> opcionalCancion = repoCanciones.findById(id);
        if (opcionalCancion.isPresent()) {
            return opcionalCancion.get();
        } else {
            return null;
        }
    }
   
    public Cancion agregarCancion(Cancion cancion) {
        return repoCanciones.save(cancion);
    }
    public void eliminaCancion(Long id) {
        repoCanciones.deleteById(id);
    }
}