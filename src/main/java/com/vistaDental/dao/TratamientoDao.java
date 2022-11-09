
package com.vistaDental.Dao;

import com.vistaDental.domain.Tratamiento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TratamientoDao extends JpaRepository<Tratamiento, Long> {
    
}