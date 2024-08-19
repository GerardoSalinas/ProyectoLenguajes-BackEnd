package unah.lenguajes.hn.proyecto.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import unah.lenguajes.hn.proyecto.models.Comercio;
import unah.lenguajes.hn.proyecto.models.Persona;
import unah.lenguajes.hn.proyecto.services.ComercioService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/comercio")
public class ComercioController {
    
    @Autowired
    private ComercioService comercioService;

    @PostMapping("/crear")
    public String crearComercio(@RequestBody Comercio comercio) {
        return this.comercioService.crearComercio(comercio);
    }
    
    @GetMapping("/todos")
    public List<Comercio> obtenerTodos() {
        return this.comercioService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Comercio obtenerComercio(@PathVariable String id) {
        return this.comercioService.obtenerComercio(id);
    }
    
    @PutMapping("/editar/{id}")
    public String editar(@PathVariable String id, @RequestBody Comercio nvoComercio) {        
        return this.comercioService.editarComercio(id,nvoComercio);
    }

    @DeleteMapping("/eliminar/{id}")
    public String eliminar(@PathVariable String id){
        return this.comercioService.eliminar(id);
    }
}
