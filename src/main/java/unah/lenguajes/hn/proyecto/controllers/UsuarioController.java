package unah.lenguajes.hn.proyecto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import unah.lenguajes.hn.proyecto.services.UsuarioService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/validar")
    public String validarUsuario(@RequestParam String correo, @RequestParam String contrasenia) {
        return this.usuarioService.validarUsuario(correo, contrasenia);
    }

}
