package com.aluracursos.forohub.controller.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Este método es fundamental: busca al usuario por su login
    // y lo devuelve en un formato que Spring Security entiende (UserDetails)
    UserDetails findByLogin(String login);
}