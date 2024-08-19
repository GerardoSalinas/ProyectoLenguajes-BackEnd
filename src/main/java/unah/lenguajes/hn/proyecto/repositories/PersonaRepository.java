package unah.lenguajes.hn.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import unah.lenguajes.hn.proyecto.models.Persona;

public interface PersonaRepository extends JpaRepository<Persona, String> {
    
    public Boolean existsByCorreo(String correo);
    
    public Persona findByCorreo(String correo);
}
