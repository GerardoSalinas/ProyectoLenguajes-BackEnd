package unah.lenguajes.hn.proyecto.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="productos")
@Data
public class Producto {
    @Id
    @Column(name="id")
    private String id;

    @Column(name="nombre")
    private String nombre;
    
    
    @Column(name="descripcion")
    private String descripcion;
    
    
    @Column(name="precio")
    private double precio;
    
    
    @Column(name="imagen")
    private String imagen;

    @ManyToMany
    @JoinTable(
        name = "productos_comercios",
        joinColumns = @JoinColumn(name="ID_Producto"),
        inverseJoinColumns = @JoinColumn(name="ID_Comercio")
    )
    private List<Comercio> comercios;

    @ManyToMany
    @JoinTable(
        name = "productos_ordenes",
        joinColumns = @JoinColumn(name="ID_Producto"),
        inverseJoinColumns = @JoinColumn(name="ID_Orden")
    )
    private List<Orden> ordenes; 


}
