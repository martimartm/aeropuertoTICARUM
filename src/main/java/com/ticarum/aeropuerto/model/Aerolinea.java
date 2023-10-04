package com.ticarum.aeropuerto.model;
import jakarta.persistence.*;
import org.hibernate.annotations.Formula;

@Entity
@Table(name="Aerolinea")

public class Aerolinea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_aerolinea", nullable = false)
    private Long id_aerolinea;

    @Column(name="name_aerolinea", nullable = false, unique = true)
    private String name_aerolinea;

    @Formula("SELECT COUNT(*) FROM Avion x WHERE x.id_aerolinea = id_aerolinea")
    private Long count_aviones;


    public Aerolinea(){}
    public Aerolinea (String name_aerolinea ){
        this.name_aerolinea=name_aerolinea;
    }

    
    public Long getId_aerolinea() {
        return id_aerolinea;
    }
    public void setId_aerolinea(Long id_aerolinea) {
        this.id_aerolinea = id_aerolinea;
    }
    public String getName_aerolinea() {
        return name_aerolinea;
    }
    public void setName_aerolinea(String name_aerolinea) {
        this.name_aerolinea = name_aerolinea;
    }
    public Long getCount_aviones() {
        return count_aviones;
    }
    public void setCount_aviones(Long count_aviones) {
        this.count_aviones = count_aviones;
    }

    
}