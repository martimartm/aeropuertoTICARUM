package com.ticarum.aeropuerto.model;
import java.time.LocalDateTime;

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
  @Column(name = "entrada")
private LocalDateTime entrada;
public LocalDateTime getEntrada() {
    return entrada;
}
public void setEntrada(LocalDateTime entrada) {
    this.entrada = entrada;
}



private LocalDateTime salida;

    public LocalDateTime getSalida() {
    return salida;
}
public void setSalida(LocalDateTime salida) {
    this.salida = salida;
}
    public Vuelo(){
        entrada= LocalDateTime.now();
    }
    public Vuelo(Avion avion){
        this.avion=avion;
    }
        public Vuelo(Avion avion, Aerolinea aerolinea){
        this.avion=avion;
        this.aerolinea = aerolinea;
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
    public void setCreatedDateTime(LocalDateTime now) {
    }

}