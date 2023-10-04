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
}