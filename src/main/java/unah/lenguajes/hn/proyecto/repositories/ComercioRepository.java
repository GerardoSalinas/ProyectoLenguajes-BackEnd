package unah.lenguajes.hn.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import unah.lenguajes.hn.proyecto.models.Comercio;

public interface ComercioRepository extends JpaRepository<Comercio, String> {
    
}
