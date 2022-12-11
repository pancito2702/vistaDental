package com.vistaDental.service;

import com.vistaDental.domain.Cita;
import com.vistaDental.domain.Cliente;
import java.util.List;

public interface CitaService {

    public List<Cita> getCitas();

    public Cita getCita(Cita cliente);

    public void save(Cita cliente);

    public void delete(Cita cliente);
    
    public List<Cita> findByCliente(Cliente cliente);
    

}
