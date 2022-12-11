package com.vistaDental.service;

import com.vistaDental.dao.CitaDao;
import com.vistaDental.domain.Cita;
import com.vistaDental.domain.Cliente;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CitaServiceImpl implements CitaService {

    @Autowired
    private CitaDao citaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Cita> getCitas() {
        return (List<Cita>) citaDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Cita getCita(Cita cita) {
        return citaDao.findById(cita.getIdCita()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Cita cita) {
        citaDao.save(cita);
    }

    @Override
    @Transactional
    public void delete(Cita cita) {
        citaDao.delete(cita);
    }

    @Override
    public List<Cita> findByCliente(Cliente cliente) {
        return (List<Cita>) citaDao.findByCliente(cliente);
    }
    
 
    
   

}
