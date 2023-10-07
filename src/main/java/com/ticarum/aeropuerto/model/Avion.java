package com.ticarum.aeropuerto.model;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name="Avion")

public class Avion{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idavion", nullable = false)
    private Long idavion;

    @Column(name="modelo_avion", nullable = false)
    private String modelo_avion;

    @Column(name="capacidad_avion", nullable = false)
    private Integer capacidad_avion;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "aerolineaid", nullable=false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Aerolinea aerolinea;

    
    public Avion(){}
    public Avion (String modelo_avion, Integer capacidad_avion, Aerolinea aerolinea){
        this.modelo_avion = modelo_avion;
        this.capacidad_avion = capacidad_avion;
        this.aerolinea = aerolinea;
    }
    public Long getId_avion() {
        return idavion;
    }
    public void setId_avion(Long id_avion) {
        this.idavion = id_avion;
    }
    public String getModelo_avion() {
        return modelo_avion;
    }
    public void setModelo_avion(String modelo_avion) {
        this.modelo_avion = modelo_avion;
    }
    public Integer getCapacidad_avion() {
        return capacidad_avion;
    }
    public void setCapacidad_avion(Integer capacidad_avion) {
        this.capacidad_avion = capacidad_avion;
    }
    public Aerolinea getAerolinea() {
        return aerolinea;
    }
    public void setAerolinea(Aerolinea aerolineaid) {
        this.aerolinea = aerolinea;
    }


    

}