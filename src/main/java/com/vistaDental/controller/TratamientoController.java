package com.vistaDental.controller;

import com.vistaDental.domain.Tratamiento;
import com.vistaDental.service.TratamientoService;

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
        String ubicacion = path + "\\" + file.getOriginalFilename();
        tratamiento.setImagen(ubicacion);
        tratamientoService.save(tratamiento);
        return "redirect:/admin";
    }

    @GetMapping("/tratamiento/eliminar")
    public String eliminarTratamiento(Model model) {
        List tratamientos = tratamientoService.getTratamientos();
        model.addAttribute("tratamientos", tratamientos);
        return "/tratamiento/eliminarTratamiento";
    }

    @GetMapping("/tratamiento/eliminar/{idTratamiento}")
    public String eliminarTratamientoRedirect(Tratamiento tratamiento) {
        tratamientoService.delete(tratamiento);
        return "redirect:/admin";
    }

    @GetMapping("/tratamiento/modificar")
    public String modificarTratamiento(Model model) {
        List tratamientos = tratamientoService.getTratamientos();
        model.addAttribute("tratamientos", tratamientos);
        return "/tratamiento/modificarTratamiento";
    }

    @GetMapping("/tratamiento/modificar/{idTratamiento}")
    public String modificarTratamientoRedirect(Tratamiento tratamiento, Model model) {
        tratamiento = tratamientoService.getTratamiento(tratamiento);
        model.addAttribute("tratamiento", tratamiento);
        return "/tratamiento/editarTratamiento";
    }
}
