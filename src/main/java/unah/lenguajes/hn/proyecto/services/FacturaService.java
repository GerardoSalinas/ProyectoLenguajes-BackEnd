package unah.lenguajes.hn.proyecto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.lenguajes.hn.proyecto.models.Factura;
import unah.lenguajes.hn.proyecto.repositories.FacturaRepository;
import unah.lenguajes.hn.proyecto.repositories.OrdenRepository;

@Service
public class FacturaService {
    @Autowired
    private FacturaRepository facturaRepository;

    @Autowired
    private OrdenRepository ordenRepository;

    public Factura crearFactura(Factura nvaFactura){
        if (nvaFactura.getOrden() != null){
            this.ordenRepository.save(nvaFactura.getOrden());
        }
        return this.facturaRepository.save(nvaFactura);
    }
}
