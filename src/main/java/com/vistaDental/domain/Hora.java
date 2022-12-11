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
@Table(name = "hora")
public class Hora implements Serializable {

    private final static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_hora")
    private long idHora;
    
    @Column(name = "hora")
    private String hora;
    
    public Hora() {
        
    }
    
    public Hora(String hora) {
        this.hora = hora;
    }
    
    
    
}
