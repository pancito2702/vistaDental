package com.vistaDental.domain;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "cita")
public class Cita implements Serializable {

    private final static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cita")
    private long idCita;

    @ManyToOne
     @JoinColumn(name = "id_cliente")
    private Cliente cliente;
    
    @ManyToOne
    @JoinColumn(name = "id_fecha")
    private Fecha fecha;

    @ManyToOne
    @JoinColumn(name = "id_hora")
    private Hora hora;
    
    @ManyToOne
    @JoinColumn(name = "id_tratamiento")
    private Tratamiento tratamiento;
    
    @Column(name = "ocupado")
    private boolean ocupado;
    
    @Column(name = "total_pagar")
    private double totalPagar;

    public Cita() {
        
    }

    public Cita(Cliente cliente, Fecha fecha, Hora hora, Tratamiento tratamiento, boolean ocupado, double totalPagar) {
        this.cliente = cliente;
        this.fecha = fecha;
        this.hora = hora;
        this.tratamiento = tratamiento;
        this.ocupado = ocupado;
        this.totalPagar = totalPagar;
    }

    

    

    

    
   

   
    

}
