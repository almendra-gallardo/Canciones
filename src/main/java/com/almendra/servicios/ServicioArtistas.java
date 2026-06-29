package com.almendra.servicios;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.almendra.modelos.Artista;
import com.almendra.repositorios.RepositorioArtistas;

@Service
public class ServicioArtistas {

    @Autowired
    private RepositorioArtistas repoArtistas;

    
    public List<Artista> obtenerTodosLosArtistas() {
        return repoArtistas.findAll();
    }

   
    public Artista obtenerArtistaPorId(Long id) {
        Optional<Artista> opcional = repoArtistas.findById(id);
        return opcional.orElse(null);
    }

   
    public Artista agregarArtista(Artista artista) {
        return repoArtistas.save(artista);
    }
}