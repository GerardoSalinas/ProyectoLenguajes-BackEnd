package unah.lenguajes.hn.proyecto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import unah.lenguajes.hn.proyecto.models.Producto;
import unah.lenguajes.hn.proyecto.services.ComercioService;
import unah.lenguajes.hn.proyecto.services.ProductoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/producto")
public class ProductoController {
    
    @Autowired
    private ProductoService productoService;

    @Autowired
    private ComercioService comercioService;

    @GetMapping("/todos")
    public List<Producto> obtenerTodos() {
        return this.productoService.obtenerTodos();
    }
    
    @PostMapping("/crear")
    public Producto crear(@RequestBody Producto nvoProducto){
        return this.productoService.crear(nvoProducto);
    }

    @GetMapping("/obtener/comercio/{id}")
    public List<Producto> obtenerProductosPorComercio(@PathVariable String id) {
        return this.comercioService.obtenerProductosPorComercio(id);
    }

    @GetMapping("/obtener/{id}")
    public Producto obtenerProducto(@PathVariable String id) {
        return this.productoService.obtenerProducto(id);
    }

    @PostMapping("/asociar/{id}")
    public Producto asociarProductoAComercio(@PathVariable String id, @RequestBody Producto nvoProducto) {
        return this.productoService.asociarProductoAComercio(id, nvoProducto);
    }
    
    

    // @DeleteMapping("/eliminar/{codigo}")
}
