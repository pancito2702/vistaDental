package com.vistaDental.service;

import com.vistaDental.dao.HoraDao;
import com.vistaDental.domain.Hora;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HoraServiceImpl implements HoraService {

    @Autowired
    private HoraDao horaDao;
    @Autowired 
    private CitaService citaService;
    
    @Override
    @Transactional(readOnly = true)
    public List<Hora> getHoras() {
        return (List<Hora>) horaDao.findAll();
    }
    
  
    
    
    
}
