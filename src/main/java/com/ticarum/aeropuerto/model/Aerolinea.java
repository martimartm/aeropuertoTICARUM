package com.ticarum.aeropuerto.model;
import jakarta.persistence.*;
import org.hibernate.annotations.Formula;

@Entity
@Table(name="Aerolinea")

public class Aerolinea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idaerolinea", nullable = false)
    private Long idaerolinea;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column
    @Formula("SELECT COUNT(*) FROM Avion WHERE id_aerolinea = aerolineaid")
    private Long count_aviones;


    public Aerolinea(){
    }

    public Aerolinea (Long id_aerolinea, String name, Long count_aviones ){
        this.idaerolinea = id_aerolinea;
        this.name=name;
        this.count_aviones = count_aviones;
    }

    public Aerolinea ( String name ){
    this.name=name;
    }

    public Long getId_aerolinea() {
        return idaerolinea;
    }
    public void setId_aerolinea(Long id_aerolinea) {
        this.idaerolinea = id_aerolinea;
    }
    public String getName() {
        return name;
    }

    public Long getCount_aviones() {
        return count_aviones;
    }
    public void setCount_aviones(Long count_aviones) {
        this.count_aviones = count_aviones;
    }

    @Override
	public String toString() {
		return "Aerolinea [id=" + idaerolinea + ", name=" + name + ", aviones=" + count_aviones+"]";
	}
    
}