package unah.lenguajes.hn.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import unah.lenguajes.hn.proyecto.models.Factura;

public interface FacturaRepository extends JpaRepository<Factura,Long> {
    
}
