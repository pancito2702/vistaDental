package com.vistaDental.service;

import com.vistaDental.Dao.TratamientoDao;
import com.vistaDental.domain.Tratamiento;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TratamientoServiceImpl implements TratamientoService {

    @Autowired
    private TratamientoDao tratamientoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Tratamiento> getTratamientos() {
        return (List<Tratamiento>) tratamientoDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Tratamiento getTratamiento(Tratamiento tratamiento) {
        return tratamientoDao.findById(tratamiento.getIdTratamiento()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Tratamiento tratamiento) {
        tratamientoDao.save(tratamiento);
    }

    @Override
    @Transactional
    public void delete(Tratamiento tratamiento) {
        tratamientoDao.delete(tratamiento);
    }
    

}
