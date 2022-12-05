package com.vistaDental;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //Autenticacion en Memoria
        auth.inMemoryAuthentication().withUser("juan").
                password("{noop}123")
                .roles("ADMIN", "VENDEDOR", "USER")
                .and()
                .withUser("rebeca").
                password("{noop}456")
                .roles("VENDEDOR")
                .and().withUser("pedro")
                .password("{noop}789")
                .roles("USER");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/tratamiento/nuevo",
                "/tratamiento/listado", "/tratamiento/modificar/**",
                "/tratamiento/eliminar/**", "/tratamiento/guardar" ,"/admin").hasRole("ADMIN")
                .antMatchers("/").permitAll()
                .and().formLogin().loginPage("/login").and()
                .exceptionHandling().accessDeniedPage("/errores/403");
    }
}
