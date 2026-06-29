package com.almendra.modelos;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "canciones")
public class Cancion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 5, message = "El título debe tener al menos 5 caracteres")
    private String titulo;

    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artista_id")
    @NotNull(message = "La canción debe tener un artista asignado")
    private Artista artista;

    @Size(min = 3, message = "El álbum debe tener al menos 3 caracteres")
    private String album;

    @Size(min = 3, message = "El género debe tener al menos 3 caracteres")
    private String genero;

    @Size(min = 3, message = "El idioma debe tener al menos 3 caracteres")
    private String idioma;

    @Column(updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    public Cancion() {
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }

  
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }


    public Artista getArtista() { return artista; }
    public void setArtista(Artista artista) { this.artista = artista; }

    public String getAlbum() { return album; }
    public void setAlbum(String album) { this.album = album; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    public String getIdioma() { return idioma; }
    public void setIdioma(String idioma) { this.idioma = idioma; }

    public Date getCreatedAt() { return createdAt; }
    public Date getUpdatedAt() { return updatedAt; }
}