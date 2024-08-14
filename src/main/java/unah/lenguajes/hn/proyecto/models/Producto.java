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
@Table(name="Productos")
@Data
public class Producto {
    @Id
    @Column(name="ID")
    private String id;

    @Column(name="Nombre")
    private String nombre;
    
    
    @Column(name="Descripcion")
    private String descripcion;
    
    
    @Column(name="Precio")
    private double precio;
    
    
    @Column(name="Imagen")
    private String imagen;

    @ManyToMany
    @JoinTable(
        name = "Productos_Comercios",
        joinColumns = @JoinColumn(name="ID_Producto"),
        inverseJoinColumns = @JoinColumn(name="ID_Comercio")
    )
    private List<Comercio> comercios;

    @ManyToMany
    @JoinTable(
        name = "Productos_Ordenes",
        joinColumns = @JoinColumn(name="ID_Producto"),
        inverseJoinColumns = @JoinColumn(name="ID_Orden")
    )
    private List<Orden> ordenes; 


}
