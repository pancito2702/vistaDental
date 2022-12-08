package com.vistaDental.dao;

import com.vistaDental.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteDao extends JpaRepository<Cliente, Long> {

    public Cliente findByUsuario(String username);
    

    
    
}
