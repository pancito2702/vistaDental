package com.vistaDental.controller;

import com.vistaDental.service.TratamientoService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class IndexController {
    
    @Autowired 
     private TratamientoService tratamientoService;
    
    @GetMapping("/")
    public String inicio(Model model) {
        List tratamientos = tratamientoService.getTratamientos();
        model.addAttribute("tratamientos", tratamientos);
        return "index";
    }

   

}
