package unah.lenguajes.hn.proyecto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.lenguajes.hn.proyecto.models.Comercio;
import unah.lenguajes.hn.proyecto.models.Persona;
import unah.lenguajes.hn.proyecto.models.Ubicacion;
import unah.lenguajes.hn.proyecto.repositories.ComercioRepository;
import unah.lenguajes.hn.proyecto.repositories.UbicacionRepository;

@Service
public class ComercioService {
    @Autowired
    private ComercioRepository comercioRepository;

    @Autowired
    private UbicacionRepository ubicacionRepository;

    public String crearComercio(Comercio comercio){
        if (!this.comercioRepository.existsById(comercio.getId())){
            if (this.ubicacionRepository.findByLatitud(comercio.getUbicacion().getLatitud()) != null){
                List<Ubicacion> ubicacionesLatitud = this.ubicacionRepository.findByLatitud(comercio.getUbicacion().getLatitud());
                for (Ubicacion ubicacionActual : ubicacionesLatitud) {
                    if (ubicacionActual.getLongitud() == comercio.getUbicacion().getLongitud()){
                        return "El comercio debe tener una ubicacion unica";
                    }
                }
                this.ubicacionRepository.save(comercio.getUbicacion());
            }
            this.comercioRepository.save(comercio);
            return "Comercio creado correctamente";
        }
        return "No se pudo crear el comercio";
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

    public Comercio editarComercio(String id, Comercio nvoComercio){
        if (this.comercioRepository.existsById(id)){
            Comercio comercioActual = this.comercioRepository.findById(id).get();
            comercioActual.setNombre(nvoComercio.getNombre());
            comercioActual.setImagen(nvoComercio.getImagen());
            comercioActual.setUbicacion(nvoComercio.getUbicacion());
            comercioActual.setProductos(nvoComercio.getProductos());
            return this.comercioRepository.save(comercioActual);
        }
        return null;
    }

    public String eliminar(String id){
        if (this.comercioRepository.existsById(id)){
            Comercio comercioActual = this.comercioRepository.findById(id).get();
            this.comercioRepository.delete(comercioActual);
            return "Comercio eliminado correctamente";
        }
        return "No se pudo eliminar el comercio";
    }
}
