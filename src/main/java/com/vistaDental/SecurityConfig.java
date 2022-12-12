package com.vistaDental;

import com.vistaDental.service.CitaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Autowired
    private UserDetailsService userDetailService;
    

    
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/tratamiento/nuevo",
                "/tratamiento/listado", "/tratamiento/modificar/**",
                "/tratamiento/eliminar/**", "/tratamiento/guardar", "/admin"
                ,"/cliente/modificar/**", "/cliente/eliminar/**", "/cliente/listado",
                        "/cita/listado/admin").hasRole("ADMIN")
                .antMatchers("/cita/nueva","/cita/listado","/cita/modificar/**", "cita/eliminar/**").hasAnyRole("USER", "ADMIN")
                .antMatchers("/").permitAll()
                .and().formLogin().loginPage("/login").and()
                .exceptionHandling().accessDeniedPage("/errores/403");
    }
}
