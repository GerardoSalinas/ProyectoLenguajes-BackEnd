package unah.lenguajes.hn.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import unah.lenguajes.hn.proyecto.models.Persona;

public interface PersonaRepository extends JpaRepository<Persona, String> {
    public boolean existsByCorreo(String correo);

    public Persona findByCorreo(String correo);
}
