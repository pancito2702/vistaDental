package com.vistaDental.service;

import com.vistaDental.domain.Tratamiento;
import java.util.List;

public interface TratamientoService {

    public List<Tratamiento> getTratamientos();

    public Tratamiento getTratamiento(Tratamiento tratamiento);

    public void save(Tratamiento tratamiento);

    public void delete(Tratamiento tratamiento);
    
    public Tratamiento findById(Long idTratamiento);
}
