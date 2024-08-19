package unah.lenguajes.hn.proyecto.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import unah.lenguajes.hn.proyecto.models.Persona;
import unah.lenguajes.hn.proyecto.services.PersonaService;




@RestController
@RequestMapping("/api/persona")
@Tag(name = "Persona", description = "CRUD para Administradores y Clientes")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @PostMapping("/crear")
        @Operation(summary = "Crear", description = "Funcion Encargada de crear Personas")
    public String crearPersona(@RequestBody Persona nvaPersona) {
        return this.personaService.crear(nvaPersona);
    }

    @GetMapping("/todos")
    @Operation(summary = "Obtener", description = "Funcion Encargada de obtener todos las personas registradas en la base de datos.")
    public List<Persona> obtenerTodos() {
        return this.personaService.obtenerTodos();
    }

    @GetMapping("/clientes/todos")
    @Operation(summary = "Obtener", description = "Funcion Encargada de obtener todos los clientes registradas en la base de datos.")

    public List<Persona> obtenerClientes() {
        return this.personaService.obtenerClientes();
    }
    

    @GetMapping("/{dni}")
    @Operation(summary = "Obtener", description = "Funcion Encargada de obtener una persona en específico, dandole busqueda mediante su dni(PrimaryKey).")
    public Persona obtenerPersona(@PathVariable String dni) {
        return this.personaService.obtenerPersona(dni);
    }
    
    
    @PutMapping("/editar/{dni}")
    @Operation(summary = "Editar", description = "Funcion Encargada de editar una persona en específico, recibe un dni(PrimaryKey) para buscar la persona y un objeto nvaPersona que contiene los nuevos cambios para esta Persona")
    public Persona editar(@PathVariable String dni, @RequestBody Persona nvaPersona) {        
        return this.personaService.editarPersona(dni,nvaPersona);
    }

    @DeleteMapping("/eliminar/{dni}")
    @Operation(summary = "Eliminar", description = "Funcion Encargada de eliminar una persona en específico por medio de su dni(PrimaryKey)")
    public String eliminar(@PathVariable String dni){
        return this.personaService.eliminar(dni);
    }
}
