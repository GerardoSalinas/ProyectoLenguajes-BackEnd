package unah.lenguajes.hn.proyecto.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import unah.lenguajes.hn.proyecto.models.Persona;
import unah.lenguajes.hn.proyecto.services.PersonaService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




//@CrossOrigin(origins = "http://localhost:80")
// @CrossOrigin(
//     origins = {
//         "http://localhost:80"
//         },
//     methods = {
//                 RequestMethod.GET,
//                 RequestMethod.PUT,
//                 RequestMethod.POST
// })
@CrossOrigin(origins= {"*"}, maxAge = 4800, allowCredentials = "false" )
@RestController
@RequestMapping("/api/persona")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @PostMapping("/crear")
    public String crearPersona(@RequestBody Persona nvaPersona) {
        return this.personaService.crear(nvaPersona);
    }

    @GetMapping("/todos")
    public List<Persona> obtenerTodos() {
        return this.personaService.obtenerTodos();
    }

    @GetMapping("/clientes/todos")
    public List<Persona> obtenerClientes() {
        return this.personaService.obtenerClientes();
    }
    

    @GetMapping("/{dni}")
    public Persona obtenerPersona(@PathVariable String dni) {
        return this.personaService.obtenerPersona(dni);
    }

    @CrossOrigin(origins="http://localhost:8091/delivery-app/public/inicio/comercio/productos" )
    @GetMapping("/correo/{correo}")
    public Persona obtenerPorCorreo(@PathVariable(name="correo") String correo) {
        return this.personaService.obtenerPorCorreo(correo);
    }
    
    
    @PutMapping("/editar/{dni}")
    public Persona editar(@PathVariable String dni, @RequestBody Persona nvaPersona) {        
        return this.personaService.editarPersona(dni,nvaPersona);
    }

    @DeleteMapping("/eliminar/{dni}")
    public String eliminar(@PathVariable String dni){
        return this.personaService.eliminar(dni);
    }
}
