package com.ticarum.aeropuerto.model;
import jakarta.persistence.*;

@Entity
@Table(name="Vuelo")

public class Vuelo{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_vuelo", nullable = false)
    private Long id_vuelo;

    @ManyToOne
    @JoinColumn(name = "id_aerolinea")
    private Aerolinea aerolinea;

    @ManyToOne
    @JoinColumn(name = "id_avion")
    private Avion avion;

    public Vuelo(Avion avion){
        this.avion=avion;
    }

    
    public Long getId_vuelo() {
        return id_vuelo;
    }

    public void setId_vuelo(Long id_vuelo) {
        this.id_vuelo = id_vuelo;
    }

    public Aerolinea getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(Aerolinea aerolinea) {
        this.aerolinea = aerolinea;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    
}