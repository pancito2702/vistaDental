package com.vistaDental.controller;

import com.vistaDental.domain.Cliente;
import com.vistaDental.domain.Rol;
import com.vistaDental.service.ClienteService;
import com.vistaDental.service.RolService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    @Autowired
    private RolService rolService;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @GetMapping("/admin")
    public String inicioAdmin(Model model) {
        List clientes = clienteService.getClientes();
        model.addAttribute("clientes", clientes);
        return "admin";
    }

    @GetMapping("/cliente/nuevo")
    public String nuevoCliente(Cliente cliente, Model model) {
        return "/cliente/nuevoCliente";
    }

    @PostMapping("/cliente/guardar")
    public String guardarCliente(Cliente cliente, @RequestParam("contra") String contra, Model model) {
        try {
            String encriptado = encoder.encode(contra);
            cliente.setContra(encriptado);
            List<Rol> roles = rolService.getRoles();
            Rol rol = null;
            for (Rol r : roles) {
                rol = roles.get(1);
            }
            cliente.setRol(rol);
            clienteService.save(cliente);
        } catch (Exception ex) {
            return "redirect:/errores/usuario";
        }
        return "redirect:/login";
    }

    @GetMapping("/cliente/eliminar/{idCliente}")
    public String eliminarCliente(Cliente cliente) {
        clienteService.delete(cliente);
        return "redirect:/admin";
    }

    @GetMapping("/cliente/modificar/{idCliente}")
    public String modificarCliente(Cliente cliente, Model model) {
        cliente = clienteService.getCliente(cliente);
        model.addAttribute("cliente", cliente);
        return "cliente/modificarCliente";
    }

}
