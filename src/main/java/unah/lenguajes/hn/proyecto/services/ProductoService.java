package unah.lenguajes.hn.proyecto.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.lenguajes.hn.proyecto.models.Comercio;
import unah.lenguajes.hn.proyecto.models.Producto;
import unah.lenguajes.hn.proyecto.repositories.ComercioRepository;
import unah.lenguajes.hn.proyecto.repositories.ProductoRepository;
import unah.lenguajes.hn.proyecto.repositories.UbicacionRepository;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private ComercioRepository comercioRepository;

    @Autowired
    private UbicacionRepository ubicacionRepository;

    public String crear(Producto nvoProducto){
        if (!this.productoRepository.existsById(nvoProducto.getId())) {
            
        if (nvoProducto.getComercios()!=null) {
            List<Comercio> comercios = nvoProducto.getComercios();        
            nvoProducto.setComercios(null);
            List<Comercio> comercioAsociados = new ArrayList<>();
            nvoProducto.setComercios(comercioAsociados);
            for (Comercio comercio : comercios) {
                nvoProducto.getComercios().add(this.comercioRepository.findById(comercio.getId()).get());
            }
           this.productoRepository.save(nvoProducto);
           return "{\"status\":true,\"message\":\"Producto creado correctamente.\",\"alert\":\"success\"}";
        }
        }  return "{\"status\":false,\"message\":\"Codigo de producto existente.\",\"alert\":\"danger\"}";
            
       
    }

    public Producto obtenerProducto(String id){
        return this.productoRepository.findById(id).get();
    }

    public List<Producto> obtenerTodos(){
        return this.productoRepository.findAll();
    }

    public Producto asociarProductoAComercio(String id, Producto nvoProducto){
        Comercio comercioAsociar = this.comercioRepository.findById(id).get();
        comercioAsociar.getProductos().add(nvoProducto);
        this.comercioRepository.save(comercioAsociar);

        Producto productoAgregar = new Producto();
        productoAgregar = nvoProducto;
        List<Comercio> comerciosAsociados = new ArrayList<>();
        comerciosAsociados.add(comercioAsociar);
        productoAgregar.setComercios(comerciosAsociados);
        return this.productoRepository.save(productoAgregar);
    }
    public String editarProducto(String id, Producto nvProducto){
        if (this.productoRepository.existsById(id)) {
            Producto producto = this.productoRepository.findById(id).get();
            producto.setNombre(nvProducto.getNombre());
            producto.setDescripcion(nvProducto.getDescripcion());
            producto.setPrecio(nvProducto.getPrecio());
            producto.setImagen(nvProducto.getImagen());
            List<Comercio> comercios = nvProducto.getComercios();        
            if (comercios != null){
                List<Comercio> nuevosComercios = new ArrayList<>();
                producto.setComercios(nuevosComercios);
                for (Comercio comercio : comercios) {
                
                    producto.getComercios().add(this.comercioRepository.findById(comercio.getId()).get());
                }

            }


            this.productoRepository.save(producto);
            return "{\"status\":true,\"message\":\"Producto editato correctamente.\",\"alert\":\"success\"}";
        
        }  return "{\"status\":false,\"message\":\"No existe Producto.\",\"alert\":\"danger\"}";
            

    }
}
