package com.ticarum.aeropuerto.model;
import jakarta.persistence.*;

@Entity
@Table(name="Vuelo")

public class Vuelo{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idvuelo", nullable = false)
    private Long idvuelo;

    @ManyToOne
    @JoinColumn(name = "idaerolinea")
    private Aerolinea aerolinea;

    @ManyToOne
    @JoinColumn(name = "idavion")
    private Avion avion;

    public Vuelo(){}
    public Vuelo(Avion avion){
        this.avion=avion;
    }

    
    public Long getIdvuelo() {
        return idvuelo;
    }

    public void setIdvuelo(Long id_vuelo) {
        this.idvuelo = id_vuelo;
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