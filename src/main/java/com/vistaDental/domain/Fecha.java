package com.vistaDental.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "fecha")
public class Fecha implements Serializable {

    private final static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_fecha")
    private long idFecha;
    
    @Column(name = "fecha")
    private String fecha;
    
    public Fecha() {
        
    }
    
    public Fecha(String fecha) {
        this.fecha = fecha;
    }
    
    
    
}
