package unah.lenguajes.hn.proyecto.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.lenguajes.hn.proyecto.models.Persona;
import unah.lenguajes.hn.proyecto.models.TipoUsuario;
import unah.lenguajes.hn.proyecto.models.Ubicacion;
import unah.lenguajes.hn.proyecto.models.Usuario;
import unah.lenguajes.hn.proyecto.repositories.PersonaRepository;
import unah.lenguajes.hn.proyecto.repositories.TipoUsuarioRepository;
import unah.lenguajes.hn.proyecto.repositories.UbicacionRepository;
import unah.lenguajes.hn.proyecto.repositories.UsuarioRepository;

@Service
public class PersonaService {
    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;

    @Autowired
    private UbicacionRepository ubicacionRepository;


    public String crear(Persona nvaPersona) {
        if (!this.personaRepository.existsById(nvaPersona.getDni())) {
            Usuario usuarioActual = nvaPersona.getUsuario();
            
            if (!this.usuarioRepository.existsByNombre(usuarioActual.getNombre())) {
                usuarioActual.setPersona(nvaPersona);
                usuarioActual.setTipoUsuario(tipoUsuarioRepository.findById((long) 2).get());
                this.usuarioRepository.save(usuarioActual);
                this.personaRepository.save(nvaPersona);
                return "{\"status\": true, \"message\": \"Se creó correctamente.\", \"alert\": \"success\"}";
            }
            
            return "{\"status\": false, \"message\": \"Nombre de usuario existente.\", \"alert\": \"danger\"}";
        }
        
        return "{\"status\": false, \"message\": \"Ya existe Cliente con ese DNI.\", \"alert\": \"danger\"}";
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

    public Persona obtenerPorCorreo(String correo){
        if (this.personaRepository.existsByCorreo(correo)){
            return this.personaRepository.findByCorreo(correo);
        }   
        return null;
    }
}
