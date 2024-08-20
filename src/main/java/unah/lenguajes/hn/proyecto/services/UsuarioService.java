package unah.lenguajes.hn.proyecto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.lenguajes.hn.proyecto.repositories.PersonaRepository;
import unah.lenguajes.hn.proyecto.repositories.UsuarioRepository;

@Service
public class UsuarioService {
        @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public String validarUsuario(String correo, String contrasenia){
        if(this.personaRepository.existsByCorreo(correo)){
            if(contrasenia.equals(this.personaRepository.findByCorreo(correo).getUsuario().getContrasenia())){
                return "validado";
            }
            return "contrasenia incorrecta";
        }
        return "No existe";
    }
}
