package unah.lenguajes.hn.proyecto.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import unah.lenguajes.hn.proyecto.models.Repartidor;

public interface RepartidorRepository extends JpaRepository<Repartidor, String> {

    // @Query("SELECT r FROM repartidores  r WHERE r.disponible = 1")
    // public List<Repartidor> obtenerDisponibles();
    // public List<Repartidor> findAllByDisponible();
    public List<Repartidor> findByDisponibleTrue();
}
