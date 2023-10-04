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

}