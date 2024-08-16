package unah.lenguajes.hn.proyecto.models;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="Ordenes")
@Data
public class Orden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private long id;

    @Column(name="Fecha_Hora")
    private LocalDateTime fechaHora;

    @Column(name="Estado")
    private String estado;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="ID_Comercio", referencedColumnName = "ID")
    private Comercio comercio;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="ID_Repartidor", referencedColumnName = "DNI")
    private Repartidor repartidor;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="ID_Cliente", referencedColumnName = "DNI")
    private Persona persona;

    @ManyToMany(mappedBy = "ordenes")
    private List<Producto> productos;
}
