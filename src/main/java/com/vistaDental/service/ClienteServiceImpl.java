package com.vistaDental.service;

import com.vistaDental.dao.ClienteDao;
import com.vistaDental.domain.Cliente;
import com.vistaDental.domain.Rol;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteServiceImpl implements ClienteService, UserDetailsService {

    @Autowired
    private ClienteDao clienteDao;

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> getClientes() {
        return (List<Cliente>) clienteDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente getCliente(Cliente cliente) {
        return clienteDao.findById(cliente.getIdCliente()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Cliente cliente) {
        clienteDao.save(cliente);
    }

    @Override
    @Transactional
    public void delete(Cliente cliente) {
        clienteDao.delete(cliente);
    }
    
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //Buscar el usuario en la table de usuarios
       Cliente cliente = clienteDao.findByUsuario(username);
       
       //Se verifica que el usuario existe... sino se lanza una excepcion
       if (cliente == null) {
           throw new UsernameNotFoundException(username);
       }
       
       //Se cargan los roles del usuario
       ArrayList roles = new ArrayList<GrantedAuthority>();
       
  
       //Por medio de la asociacion se recuperan los roles de la tabla de roles       
       roles.add(new SimpleGrantedAuthority(cliente.getRol().getNombre()));

       return new User(cliente.getUsuario(), cliente.getContra(), roles);
    }

    @Override
    public Cliente findByUsuario(String username) {
        Cliente cliente = clienteDao.findByUsuario(username);
        return clienteDao.findById(cliente.getIdCliente()).orElse(null);
    }
}
