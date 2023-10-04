package com.ticarum.aeropuerto.model;
import jakarta.persistence.*;

@Entity
@Table(name="Avion")

public class Avion{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_avion", nullable = false)
    private Long id_avion;

    @Column(name="modelo_avion", nullable = false)
    private String modelo_avion;

    @Column(name="capacidad_avion", nullable = false)
    private Integer capacidad_avion;

    @ManyToOne
    @JoinColumn(name = "id_aerolinea", nullable=false)
    private Aerolinea aerolinea;

    
    public Avion(){}
    public Avion (String modelo_avion, Integer capacidad_avion, Aerolinea aerolinea){
        this.modelo_avion = modelo_avion;
        this.capacidad_avion = capacidad_avion;
        this.aerolinea = aerolinea;
    }

}