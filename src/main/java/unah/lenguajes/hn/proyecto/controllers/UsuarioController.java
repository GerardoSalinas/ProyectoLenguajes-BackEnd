package unah.lenguajes.hn.proyecto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import unah.lenguajes.hn.proyecto.services.UsuarioService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/usuario")
@Tag(name = "Usuarios", description = "Validacion de Usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/validar")
    @Operation(summary = "validar", description = "Valida la existencia del correo y contraseña del usuario")
    public String validarUsuario(@RequestParam String correo, @RequestParam String contrasenia) {
        return this.usuarioService.validarUsuario(correo, contrasenia);
    }

}
