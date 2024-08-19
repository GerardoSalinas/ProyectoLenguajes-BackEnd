package unah.lenguajes.hn.proyecto.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="Personas")
@Data
public class Persona {
    @Id
    @Column(name="DNI")
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
    
    @JsonIgnore
    @OneToOne(mappedBy = "persona")
    private Orden orden;

    @JsonIgnoreProperties(value = {"persona"})
    @OneToOne(mappedBy = "persona")
    private Usuario usuario;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="ID_Ubicacion", referencedColumnName = "ID")
    private Ubicacion ubicacion;

}
