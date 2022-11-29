package com.vistaDental.controller;

import com.vistaDental.domain.Cliente;
import com.vistaDental.service.ClienteService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/admin")
    public String inicioAdmin(Model model) {
        List clientes = clienteService.getClientes();
        model.addAttribute("clientes", clientes);
        return "admin";
    }

    @GetMapping("/cliente/nuevo")
    public String nuevoCliente(Cliente cliente) {
        return "/cliente/nuevoCliente";
    }

    @PostMapping("/cliente/guardar")
    public String guardarCliente(Cliente cliente, @RequestParam("Usuario") String usuario, Model model) {
        clienteService.save(cliente);
        return "redirect:/";
    }
}
