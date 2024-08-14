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
@Table(name="repartidores")
@Data
public class Repartidor {
    @Id
    @Column(name="dni")
    private String dni;

    @Column(name="primernombre")
    private String primerNombre;

    @Column(name="segundonombre")
    private String segundoNombre;

    @Column(name="primerapellido")
    private String primerApellido;

    @Column(name="segundoapellido")
    private String segundoApellido;

    @Column(name="telefono")
    private String telefono;

    @Column(name="correo")
    private String correo;
    
    @Column(name="disponible")
    private boolean disponible;
    
    @Column(name="habilitado")
    private boolean hailitado;
    
    @Column(name="puntajepromedio")
    private float puntajePromedio;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="ID_Ubicacion", referencedColumnName = "id")
    private Ubicacion ubicacion;

    @JsonIgnore
    @OneToMany(mappedBy = "repartidor")
    private List<Orden> ordenes;
}
