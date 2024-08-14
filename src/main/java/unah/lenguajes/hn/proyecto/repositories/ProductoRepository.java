package unah.lenguajes.hn.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import unah.lenguajes.hn.proyecto.models.Producto;

public interface ProductoRepository extends JpaRepository<Producto, String> {
    
}
