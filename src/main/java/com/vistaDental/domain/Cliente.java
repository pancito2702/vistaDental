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
@Table(name="cliente")
public class Cliente implements Serializable {

    private final static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private long idCliente;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "primer_apellido")
    private String primerApellido;

    @Column(name = "segundo_apellido")
    private String segundoApellido;

    @Column(name = "usuario", unique = true)
    private String usuario;

    @Column(name = "contra")
    private String contra;

    @Column(name = "correo", unique = true)
    private String correo;
    
    @Column(name = "telefono")
    private String telefono;

    public Cliente() {
    }

    public Cliente(String nombre, String primerApellido, String segundoApellido, String usuario, String contra, String correo, String telefono) {
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.usuario = usuario;
        this.contra = contra;
        this.correo = correo;
        this.telefono = telefono;
    }
    
    
    
}
