package unah.lenguajes.hn.proyecto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.lenguajes.hn.proyecto.models.Comercio;
import unah.lenguajes.hn.proyecto.models.Producto;
import unah.lenguajes.hn.proyecto.repositories.ComercioRepository;
import unah.lenguajes.hn.proyecto.repositories.ProductoRepository;
import unah.lenguajes.hn.proyecto.repositories.UbicacionRepository;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private ComercioRepository comercioRepository;

    @Autowired
    private UbicacionRepository ubicacionRepository;

    public Producto crear(Producto nvoProducto){
        if (!this.productoRepository.existsById(nvoProducto.getId())){
            if (nvoProducto.getComercios() != null){
                List<Comercio> comercios =  nvoProducto.getComercios();
                for (Comercio  comercioActual: comercios) {
                    if (!this.comercioRepository.existsById(comercioActual.getId())){
                        this.ubicacionRepository.save(comercioActual.getUbicacion());
                        this.comercioRepository.save(comercioActual);
                    }
                }
            }
            return this.productoRepository.save(nvoProducto);
        }
        return null;
    }
}
