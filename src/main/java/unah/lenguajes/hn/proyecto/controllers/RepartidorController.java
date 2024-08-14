package unah.lenguajes.hn.proyecto.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import unah.lenguajes.hn.proyecto.models.Persona;
import unah.lenguajes.hn.proyecto.models.Repartidor;
import unah.lenguajes.hn.proyecto.services.RepartidorService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/api/repartidor")
public class RepartidorController {
    @Autowired
    private RepartidorService repartidorService;

    @GetMapping("/todos")
    public List<Repartidor> obtenerTodos() {
        return this.repartidorService.obtenerTodos();
    }
    
    @GetMapping("/{dni}")
    public Repartidor obtenerRepartidor(@PathVariable String dni) {
        return this.repartidorService.obtenerRepartidor(dni);
    }

    @PostMapping("/crear")
    public Repartidor crear(@RequestBody Repartidor nvoRepartidor) {
        return this.repartidorService.crearRepartidor(nvoRepartidor);
    }
    
    @DeleteMapping("/eliminar/{dni}")
    public String eliminar(@PathVariable String dni){
        return this.repartidorService.eliminar(dni);
    }

    @PutMapping("/editar/{dni}")
    public Repartidor editar(@PathVariable String dni, @RequestBody Repartidor nvoRepartidor) {        
        return this.repartidorService.editar(dni,nvoRepartidor);
    }
    
}
