package unah.lenguajes.hn.proyecto.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import unah.lenguajes.hn.proyecto.models.Orden;
import unah.lenguajes.hn.proyecto.services.OrdenService;


@RestController
@RequestMapping("/api/orden")
@Tag(name = "Orden", description = "CRUD para Administradores y Clientes")
public class OrdenController {
    
    @Autowired
    private OrdenService ordenService;

    @GetMapping("/todos")
    @Operation(summary = "Obtener", description = "Funcion Encargada de obtener todos los comercios registrados en la base de datos")
    public List<Orden> obtenerOrdenes() {
        return this.ordenService.obtenerOrdenes();
    }
    
}
