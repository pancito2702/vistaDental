package com.vistaDental.controller;

import com.vistaDental.domain.Tratamiento;
import com.vistaDental.service.TratamientoService;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@Slf4j
public class TratamientoController {

    @Autowired
    private TratamientoService tratamientoService;

    @GetMapping("/tratamiento/listado")
    public String tratamientoListado(Model model, Tratamiento tratamiento) {
        List tratamientos = tratamientoService.getTratamientos();
        model.addAttribute("tratamientos", tratamientos);
        return "/tratamiento/listadoTratamientos";
    }

    @GetMapping("/tratamiento/nuevo")
    public String nuevoTratamiento(Tratamiento tratamiento) {
        return "/tratamiento/nuevoTratamiento";
    }

    @PostMapping("/tratamiento/guardar")
    public String guardarTratamiento(Tratamiento tratamiento, @RequestParam("archivo") MultipartFile file) {
        String path = "\\images";
        String ubicacion = path+"\\"+file.getOriginalFilename();
        System.out.println(ubicacion);
        tratamiento.setImagen(ubicacion);   
        tratamientoService.save(tratamiento);
        return "redirect:/admin";
    }
}
