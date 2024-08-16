package unah.lenguajes.hn.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import unah.lenguajes.hn.proyecto.models.TipoUsuario;

public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario,Long> {
    
}
