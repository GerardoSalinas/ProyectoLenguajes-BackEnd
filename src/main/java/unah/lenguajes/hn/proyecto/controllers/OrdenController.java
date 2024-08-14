package unah.lenguajes.hn.proyecto.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import unah.lenguajes.hn.proyecto.models.Orden;
import unah.lenguajes.hn.proyecto.services.OrdenService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/orden")
public class OrdenController {
    
    @Autowired
    private OrdenService ordenService;

    @GetMapping("/todos")
    public List<Orden> obtenerOrdenes() {
        return this.ordenService.obtenerOrdenes();
    }
    
}
