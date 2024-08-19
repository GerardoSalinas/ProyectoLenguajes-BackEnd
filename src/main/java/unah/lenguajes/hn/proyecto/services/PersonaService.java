package unah.lenguajes.hn.proyecto.services;

import java.util.ArrayList;
import java.util.List;

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

    public String crear(Persona nvaPersona){
        if (!this.personaRepository.existsById(nvaPersona.getDni())){
            Usuario usuarioActual = nvaPersona.getUsuario();
            Persona personaActual = new Persona();
            if (!this.usuarioRepository.existsByNombre(usuarioActual.getNombre())){
                usuarioActual.setPersona(nvaPersona);
                usuarioActual.setTipoUsuario(tipoUsuarioRepository.findById( (long) 2).get() );
                this.usuarioRepository.save(usuarioActual);
                personaActual = this.personaRepository.save(nvaPersona);
            }
            return "se creo correctamente";
        }
        return "Ya existe Cliente con ese DNI";
    }

    public List<Persona> obtenerTodos(){
        return this.personaRepository.findAll();
    }

    public List<Persona> obtenerClientes(){
        List<Persona> personas = this.personaRepository.findAll();
        List<Persona> clientes = new ArrayList<>();

        for(Persona persona:personas){
            if(persona.getUsuario().getTipoUsuario().getTipo().equalsIgnoreCase("cliente")){
                clientes.add(persona);
            }
        }
        return clientes;
    }

    public Persona editarPersona(String dni, Persona nvaPersona){
        if (this.personaRepository.existsById(dni)){
            Persona personaActual = this.personaRepository.findById(dni).get();
            personaActual.setPrimerNombre(nvaPersona.getPrimerNombre());
            personaActual.setSegundoNombre(nvaPersona.getSegundoNombre());
            personaActual.setPrimerApellido(nvaPersona.getPrimerApellido());
            personaActual.setSegundoApellido(nvaPersona.getSegundoApellido());
            personaActual.setTelefono(nvaPersona.getTelefono());
            personaActual.setCorreo(nvaPersona.getCorreo());
            personaActual.setUbicacion(nvaPersona.getUbicacion());
            return this.personaRepository.save(personaActual);
        }
        return null;
    }

    public  String eliminar(String dni){
        if (this.personaRepository.existsById(dni)){
            Persona personaEliminar = this.personaRepository.findById(dni).get();
            this.personaRepository.delete(personaEliminar);
            return "Registro eliminado correctamente";
        }
        return "No se pudo eliminar el registro";
    }

    public Persona obtenerPersona (String dni){
        if (this.personaRepository.existsById(dni)){
            return this.personaRepository.findById(dni).get();
        }
        return null;
    }
}
