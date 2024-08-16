package unah.lenguajes.hn.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import unah.lenguajes.hn.proyecto.models.Orden;

public interface OrdenRepository extends JpaRepository<Orden, Long> {
    
}
