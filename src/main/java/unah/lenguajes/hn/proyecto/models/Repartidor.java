package unah.lenguajes.hn.proyecto.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="Repartidores")
@Data
public class Repartidor {
    @Id
    @Column(name="DNI")
    private String dni;

    @Column(name="primerNombre")
    private String primerNombre;

    @Column(name="segundoNombre")
    private String segundoNombre;

    @Column(name="primerApellido")
    private String primerApellido;

    @Column(name="segundoApellido")
    private String segundoApellido;

    @Column(name="telefono")
    private String telefono;

    @Column(name="correo")
    private String correo;
    
    @Column(name="disponible")
    private boolean disponible;
    
    @Column(name="habilitado")
    private boolean hailitado;
    
    @Column(name="puntaje_Promedio")
    private float puntajePromedio;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="ID_Ubicacion", referencedColumnName = "ID")
    private Ubicacion ubicacion;

    @JsonIgnore
    @OneToMany(mappedBy = "repartidor")
    private List<Orden> ordenes;
}
