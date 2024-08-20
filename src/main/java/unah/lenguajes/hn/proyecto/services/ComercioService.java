package unah.lenguajes.hn.proyecto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.lenguajes.hn.proyecto.models.Comercio;
import unah.lenguajes.hn.proyecto.models.Persona;
import unah.lenguajes.hn.proyecto.models.Producto;
import unah.lenguajes.hn.proyecto.models.Ubicacion;
import unah.lenguajes.hn.proyecto.repositories.ComercioRepository;
import unah.lenguajes.hn.proyecto.repositories.ProductoRepository;
import unah.lenguajes.hn.proyecto.repositories.UbicacionRepository;

@Service
public class ComercioService {
    @Autowired
    private ComercioRepository comercioRepository;

    @Autowired
    private UbicacionRepository ubicacionRepository;

    @Autowired
    private ProductoRepository productoRepository;

    public String crearComercio(Comercio comercio){
        if (!this.comercioRepository.existsById(comercio.getId())){
            if (this.ubicacionRepository.findByLatitud(comercio.getUbicacion().getLatitud()) != null){
                List<Ubicacion> ubicacionesLatitud = this.ubicacionRepository.findByLatitud(comercio.getUbicacion().getLatitud());
                for (Ubicacion ubicacionActual : ubicacionesLatitud) {
                    if (ubicacionActual.getLongitud() == comercio.getUbicacion().getLongitud()){
                        return  "{\"status\":false,\"message\":\"El comercio debe tener una ubicacion unica.\",\"alert\":\"danger\"}";
                    }
                }
                this.ubicacionRepository.save(comercio.getUbicacion());
            }
            this.comercioRepository.save(comercio);
            return "{\"status\":true,\"message\":\"Comercio creado correctamente.\",\"alert\":\"success\"}";
        }
        return "{\"status\":false,\"message\":\"Codigo de comercio Existente.\",\"alert\":\"danger\"}";
    }

    public List<Comercio> obtenerTodos(){
        return this.comercioRepository.findAll();
    }

    public Comercio obtenerComercio(String id){
        if (this.comercioRepository.existsById(id)){
            return this.comercioRepository.findById(id).get() ;
        }
        return null;
    }

    public String editarComercio(String id, Comercio nvoComercio){
        if (this.comercioRepository.existsById(id)){
            Comercio comercioActual = this.comercioRepository.findById(id).get();
            comercioActual.setNombre(nvoComercio.getNombre());
            comercioActual.setImagen(nvoComercio.getImagen());
            comercioActual.setUbicacion(nvoComercio.getUbicacion()); 
            this.comercioRepository.save(comercioActual);       
            return "{\"status\":true,\"message\":\"Comercio editado correctamente.\",\"alert\":\"success\"}" ;
        }
        return "{\"status\":false,\"message\":\"No existe tal comercio.\",\"alert\":\"danger\"}";
    }

    public String eliminar(String id){
        if (this.comercioRepository.existsById(id)){
            Comercio comercioActual = this.comercioRepository.findById(id).get();
            this.comercioRepository.delete(comercioActual);
            return "Comercio eliminado correctamente";
        }
        return "No se pudo eliminar el comercio";
    }

    public List<Producto> obtenerProductosPorComercio(String id){
        if(this.comercioRepository.findById(id).get().getProductos() != null){
        List<Producto> productos = this.comercioRepository.findById(id).get().getProductos();
        return productos;
        }else{
            return null;
        }
    }
}
