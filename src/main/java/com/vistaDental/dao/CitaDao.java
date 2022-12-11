package com.vistaDental.dao;

import com.vistaDental.domain.Cita;
import com.vistaDental.domain.Cliente;
import com.vistaDental.domain.Hora;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CitaDao extends JpaRepository<Cita, Long> {
    
    public List<Cita> findByCliente(Cliente cliente);
    
    public Hora findByHora(Hora hora);
    
    
}
