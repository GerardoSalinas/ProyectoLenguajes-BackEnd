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
import unah.lenguajes.hn.proyecto.models.Repartidor;
import unah.lenguajes.hn.proyecto.services.RepartidorService;




@RestController
@RequestMapping("/api/repartidor")
@Tag(name = "Repartidor", description = "CRUD para Administradores")

public class RepartidorController {
    @Autowired
    private RepartidorService repartidorService;

    @GetMapping("/todos")
    @Operation(summary = "Obtener", description = "Funcion Encargada de obtener todos los Repartidores registradas en la base de datos.")

    public List<Repartidor> obtenerTodos() {
        return this.repartidorService.obtenerTodos();
    }
    
    @GetMapping("/{dni}")
    @Operation(summary = "Obtener", description = "Funcion Encargada de obtener un Repartidor en específico, dandole busqueda mediante su dni(PrimaryKey).")
    public Repartidor obtenerRepartidor(@PathVariable String dni) {
        return this.repartidorService.obtenerRepartidor(dni);
    }

    @GetMapping("/todos/disponibles")
    @Operation(summary = "Obtener", description = "Funcion Encargada de obtener los Repartidores que se encuentran disponibles")
    public List<Repartidor> obtenerDisponibles() {
        return this.repartidorService.obtenerDisponibles();
    }
    
    @GetMapping("/mascercano/{comercioID}")
    @Operation(summary = "Obtener", description = "Funcion Encargada de obtener el repartidor que se encuentra mas cercano, dandole busqueda mediante su id(PrimaryKey) del comercio que se encuentra mas cerca del repartidor en un determinado momento.")
    public Repartidor obtenerRepartidorMasCercano(@PathVariable(name="comercioID") String comercioID) {
        return this.repartidorService.obtenerRepartidorMasCercano(comercioID);
    }
    

    @PostMapping("/crear")
    @Operation(summary = "Crear", description = "Funcion Encargada de crear un Repartidor")
    public Repartidor crear(@RequestBody Repartidor nvoRepartidor) {
        return this.repartidorService.crearRepartidor(nvoRepartidor);
    }
    
    @DeleteMapping("/eliminar/{dni}")
    @Operation(summary = "Eliminar", description = "Funcion Encargada de eliminar un Repartidor en específico por medio de su dni(PrimaryKey)")
    public String eliminar(@PathVariable String dni){
        return this.repartidorService.eliminar(dni);
    }

    @PutMapping("/editar/{dni}")
    @Operation(summary = "Editar", description = "Funcion Encargada de editar un Repartidor en específico, recibe un dni(PrimaryKey) para buscar el repartidor y un objeto nvoRepartidor que contiene los nuevos cambios para este Repartidor")
    public Repartidor editar(@PathVariable String dni, @RequestBody Repartidor nvoRepartidor) {        
        return this.repartidorService.editar(dni,nvoRepartidor);
    }
    
}
