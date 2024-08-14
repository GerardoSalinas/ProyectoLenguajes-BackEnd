package unah.lenguajes.hn.proyecto.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import unah.lenguajes.hn.proyecto.models.Persona;
import unah.lenguajes.hn.proyecto.services.PersonaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/persona")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @PostMapping("/crear")
    public Persona crearPersona(@RequestBody Persona nvaPersona) {
        return this.personaService.crear(nvaPersona);
    }
    
}
