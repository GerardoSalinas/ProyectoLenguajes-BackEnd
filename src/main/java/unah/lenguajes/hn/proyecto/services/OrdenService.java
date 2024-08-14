package unah.lenguajes.hn.proyecto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.lenguajes.hn.proyecto.models.Orden;
import unah.lenguajes.hn.proyecto.repositories.OrdenRepository;

@Service
public class OrdenService {
    
    @Autowired
    private OrdenRepository ordenRepository;

    public List<Orden> obtenerOrdenes(){
        return this.ordenRepository.findAll();
    }
}
