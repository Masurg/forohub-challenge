package com.aluracursos.forohub.controller.usuario;

import jakarta.validation.constraints.NotBlank;

/**
 * Este Record sirve para recibir los datos del formulario de Login.
 * Solo transporta el nombre de usuario y la contraseña.
 */
public record DatosAutenticacionUsuario(
        @NotBlank
        String login,

        @NotBlank
        String clave
) {
}