package unah.lenguajes.hn.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import unah.lenguajes.hn.proyecto.models.Repartidor;

public interface RepartidorRepository extends JpaRepository<Repartidor, String> {
    
}
