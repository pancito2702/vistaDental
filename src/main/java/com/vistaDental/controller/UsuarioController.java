

package com.vistaDental.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@Slf4j
public class UsuarioController {
    
    @GetMapping("/usuario/nuevo")
    public String inicio() {
        return "nuevoUsuario";
    }
    
    
}
