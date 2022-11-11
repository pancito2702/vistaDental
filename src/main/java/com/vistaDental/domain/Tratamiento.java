package com.vistaDental.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tratamiento")
public class Tratamiento implements Serializable {

    private final static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tratamiento")
    private long idTratamiento;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "costo")
    private double costo;

    @Lob
    @Column(name = "imagen")
    private String imagen;

    public Tratamiento() {
    }

    public Tratamiento(String nombre, double costo, String imagen) {
        this.nombre = nombre;
        this.costo = costo;
        this.imagen = imagen;
    }

    
    
}
