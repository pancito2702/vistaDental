package com.vistaDental.service;

import com.vistaDental.dao.RolDao;
import com.vistaDental.domain.Rol;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RolServiceImpl implements RolService {

    @Autowired
    private RolDao rolDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Rol> getRoles() {
        return (List<Rol>) rolDao.findAll();
    }

}
