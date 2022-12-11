package com.vistaDental.controller;

import com.vistaDental.domain.Cita;
import com.vistaDental.domain.Cliente;
import com.vistaDental.domain.Tratamiento;
import com.vistaDental.service.CitaService;
import com.vistaDental.service.ClienteService;
import com.vistaDental.service.FechaService;
import com.vistaDental.service.HoraService;
import com.vistaDental.service.TratamientoService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@Slf4j
public class CitaController {

    @Autowired
    private CitaService citaService;

    @Autowired
    private FechaService fechaService;

    @Autowired
    private HoraService horaService;

    @Autowired
    private TratamientoService tratamientoService;

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/cita/nueva")
    public String nuevaCita(Cita cita, Model model) {
        List fechas = fechaService.getFechas();
        List horas = horaService.getHoras();
        List tratamientos = tratamientoService.getTratamientos();
        model.addAttribute("fechas", fechas);
        model.addAttribute("horas", horas);
        model.addAttribute("tratamientos", tratamientos);
        return "/cita/nuevaCita";
    }
    
    @GetMapping("/cita/listado")
    public String listadoCitas(Model model) {
         Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = "";
        if (principal instanceof UserDetails userDetails) {
            username = userDetails.getUsername();
        }
        Cliente cl = clienteService.findByUsuario(username);
        List citas = citaService.findByCliente(cl);
        model.addAttribute("citas", citas);
        return "cita/listadoCitas";
    }
    
    @PostMapping("/cita/guardar")
    public String guardarCita(Cita cita, @RequestParam("tratamiento") Long idTratamiento) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = "";
        if (principal instanceof UserDetails userDetails) {
            username = userDetails.getUsername();
        }
        Cliente cl = clienteService.findByUsuario(username);
        cita.setCliente(cl);
        Tratamiento tr = tratamientoService.findById(idTratamiento);
        cita.setTotalPagar(tr.getCosto());
        List<Cita> citas = citaService.getCitas();
        citaService.save(cita);
        return "redirect:/";
    }

    @GetMapping("/cita/eliminar/{idCita}")
    public String eliminarCita(Cita cita) {
        citaService.delete(cita);
        return "redirect:/";
    }

    @GetMapping("/cita/modificar/{idCita}")
    public String modificarCita(Cita cita, Model model) {
        cita = citaService.getCita(cita);
        model.addAttribute("cita", cita);
        return "cita/modificarCita";
    }

}
