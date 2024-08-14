package unah.lenguajes.hn.proyecto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.lenguajes.hn.proyecto.models.Persona;
import unah.lenguajes.hn.proyecto.models.TipoUsuario;
import unah.lenguajes.hn.proyecto.models.Usuario;
import unah.lenguajes.hn.proyecto.repositories.PersonaRepository;
import unah.lenguajes.hn.proyecto.repositories.TipoUsuarioRepository;
import unah.lenguajes.hn.proyecto.repositories.UsuarioRepository;

@Service
public class PersonaService {
    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;

    public Persona crear(Persona nvaPersona){
        if (!this.personaRepository.existsById(nvaPersona.getDni())){
            Usuario usuarioActual = nvaPersona.getUsuario();
            Persona personaActual = new Persona();
            if (!this.usuarioRepository.existsByNombre(usuarioActual.getNombre())){
                usuarioActual.setPersona(nvaPersona);
                usuarioActual.setTipoUsuario(tipoUsuarioRepository.findById( (long) 2).get() );
                this.usuarioRepository.save(usuarioActual);
                personaActual = this.personaRepository.save(nvaPersona);
            }
            return personaActual;
        }
        return null;
    }
}
