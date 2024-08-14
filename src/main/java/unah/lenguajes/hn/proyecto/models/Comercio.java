package unah.lenguajes.hn.proyecto.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="comercios")
@Data
public class Comercio {
    @Id
    @Column(name="id")
    private String id;
    
    @Column(name="nombre")
    private String nombre;

    @Column(name="imagen")
    private String imagen;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="ID_Ubicacion", referencedColumnName = "id")
    private Ubicacion ubicacion;

    @OneToMany(mappedBy = "comercio")
    private List<Orden> orden;

    @ManyToMany(mappedBy = "comercios")
    private List<Producto> productos;

}
