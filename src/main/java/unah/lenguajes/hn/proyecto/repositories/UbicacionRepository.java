package unah.lenguajes.hn.proyecto.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import unah.lenguajes.hn.proyecto.models.Ubicacion;

public interface UbicacionRepository extends JpaRepository<Ubicacion, Long>{
    public List<Ubicacion> findByLatitud(double latitud);

    public List<Ubicacion> findByLongitud(double longitud);

}
