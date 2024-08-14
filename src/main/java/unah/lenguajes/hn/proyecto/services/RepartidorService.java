package unah.lenguajes.hn.proyecto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.lenguajes.hn.proyecto.models.Comercio;
import unah.lenguajes.hn.proyecto.models.Persona;
import unah.lenguajes.hn.proyecto.models.Repartidor;
import unah.lenguajes.hn.proyecto.models.Ubicacion;
import unah.lenguajes.hn.proyecto.repositories.RepartidorRepository;
import unah.lenguajes.hn.proyecto.repositories.UbicacionRepository;

@Service
public class RepartidorService {
    @Autowired
    private RepartidorRepository repartidorRepository;

    @Autowired
    private UbicacionRepository ubicacionRepository;

    public List<Repartidor> obtenerTodos(){
        return this.repartidorRepository.findAll();
    }

    public Repartidor obtenerRepartidor(String dni){
        if (this.repartidorRepository.existsById(dni)){
            return this.repartidorRepository.findById(dni).get();
        }
        return null;
    }

    public Repartidor crearRepartidor(Repartidor nvoRepartidor){
        if (!this.repartidorRepository.existsById(nvoRepartidor.getDni())){
            if (nvoRepartidor.getUbicacion() != null){
                Ubicacion nvaUbicacion = nvoRepartidor.getUbicacion();
                if (this.ubicacionRepository.findByLatitud(nvaUbicacion.getLatitud()) != null){
                    List<Ubicacion> ubicacionesLatitud = this.ubicacionRepository.findByLatitud(nvaUbicacion.getLatitud());
                    for (Ubicacion ubicacionActual : ubicacionesLatitud) {
                        if (ubicacionActual.getLongitud() == nvaUbicacion.getLongitud()){
                            return null;
                        }
                    }
                    this.ubicacionRepository.save(nvaUbicacion);
                }
                this.repartidorRepository.save(nvoRepartidor);
            }
            
        }
        return null;
    }

    public String eliminar(String dni){
        if (this.repartidorRepository.existsById(dni)){
            Repartidor repartidorActual = this.repartidorRepository.findById(dni).get();
            this.repartidorRepository.delete(repartidorActual);
            return "Comercio eliminado correctamente";
        }
        return "No se pudo eliminar el comercio";
    }

    public Repartidor editar(String dni, Repartidor nvoRepartidor){
        if (this.repartidorRepository.existsById(dni)){
            Repartidor repartidorActual = this.repartidorRepository.findById(dni).get();
            repartidorActual.setPrimerNombre(nvoRepartidor.getPrimerNombre());
            repartidorActual.setSegundoNombre(nvoRepartidor.getSegundoNombre());
            repartidorActual.setPrimerApellido(nvoRepartidor.getPrimerApellido());
            repartidorActual.setSegundoApellido(nvoRepartidor.getSegundoApellido());
            repartidorActual.setTelefono(nvoRepartidor.getTelefono());
            repartidorActual.setCorreo(nvoRepartidor.getCorreo());
            repartidorActual.setCorreo(nvoRepartidor.getCorreo());
            repartidorActual.setHailitado(true);
            repartidorActual.setDisponible(true);
            return this.repartidorRepository.save(repartidorActual);
        }
        return null;
    }

}
