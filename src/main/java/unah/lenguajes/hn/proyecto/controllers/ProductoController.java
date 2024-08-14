package unah.lenguajes.hn.proyecto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import unah.lenguajes.hn.proyecto.models.Producto;
import unah.lenguajes.hn.proyecto.services.ProductoService;

@RestController
@RequestMapping("/api/producto")
public class ProductoController {
    
    @Autowired
    private ProductoService productoService;

    @PostMapping("/crear")
    public Producto crear(@RequestBody Producto nvoProducto){
        return this.productoService.crear(nvoProducto);
    }

    // @DeleteMapping("/eliminar/{codigo}")
}
