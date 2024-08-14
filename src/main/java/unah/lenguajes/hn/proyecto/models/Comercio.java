package unah.lenguajes.hn.proyecto.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name="Comercios")
@Data
public class Comercio {
    @Id
    @Column(name="ID")
    private String id;
    
    @Column(name="nombre")
    private String nombre;

    @Column(name="imagen")
    private String imagen;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="ID_Ubicacion", referencedColumnName = "ID")
    private Ubicacion ubicacion;

    @JsonIgnore
    @OneToMany(mappedBy = "comercio")
    private List<Orden> orden;

    @ManyToMany(mappedBy = "comercios")
    private List<Producto> productos;

}
