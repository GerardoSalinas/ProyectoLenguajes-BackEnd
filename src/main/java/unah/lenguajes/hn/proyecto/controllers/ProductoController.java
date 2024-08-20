package unah.lenguajes.hn.proyecto.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import unah.lenguajes.hn.proyecto.models.Producto;
import unah.lenguajes.hn.proyecto.services.ComercioService;
import unah.lenguajes.hn.proyecto.services.ProductoService;


@RestController
@RequestMapping("/api/producto")
@Tag(name = "Productos", description = "CRUD para Administradores")

public class ProductoController {
    
    @Autowired
    private ProductoService productoService;

    @Autowired
    private ComercioService comercioService;

    @GetMapping("/todos")
    @Operation(summary = "Obtener", description = "Funcion Encargada de obtener todos los Productos registradas en la base de datos.")
     List<Producto> obtenerTodos() {
        return this.productoService.obtenerTodos();
    }
    
    @PostMapping("/crear")
    @Operation(summary = "Crear", description = "Funcion Encargada de crear Productos")
    public String crear(@RequestBody Producto nvoProducto){
        return this.productoService.crear(nvoProducto);
    }

    @GetMapping("/obtener/comercio/{id}")
    @Operation(summary = "Obtener", description = "Funcion Encargada de obtener todos los Productos asociados a un comercio en específico, dandole busqueda mediante su id(PrimaryKey).")
    public List<Producto> obtenerProductosPorComercio(@PathVariable String id) {
        return this.comercioService.obtenerProductosPorComercio(id);
    }

    @GetMapping("/obtener/{id}")
    @Operation(summary = "Obtener", description = "Funcion Encargada de obtener un Productos específico, dandole busqueda mediante su id(PrimaryKey).")
    public Producto obtenerProducto(@PathVariable String id) {
        return this.productoService.obtenerProducto(id);
    }

    @PostMapping("/asociar/{id}")
    @Operation(summary = "Asociar", description = "Funcion Encargada de asociar un Productos a un comercio en específico, dandole busqueda al comercio mediante su id(PrimaryKey) y pasandole el producto que se recibe como parámetro de la función.")
    public Producto asociarProductoAComercio(@PathVariable String id, @RequestBody Producto nvoProducto) {
        return this.productoService.asociarProductoAComercio(id, nvoProducto);
    }

    @PutMapping("/editar/{id}")
    @Operation(summary = "Editar", description = "Funcion Encargada de editar un Producto en específico, recibe un id(PrimaryKey) para buscar el producto y un objeto nvoProducto que contiene los nuevos cambios para este producto")
    public String editarProducto (@PathVariable String id,@RequestBody Producto nvProducto    ){

        return this.productoService.editarProducto(id, nvProducto);

    }
    
    

    // @DeleteMapping("/eliminar/{codigo}")
}
