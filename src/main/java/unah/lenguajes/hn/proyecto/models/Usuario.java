package unah.lenguajes.hn.proyecto.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="usuarios")
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="nombre")
    private String nombre ;

    @Column(name="contrasenia")
    private String contrasenia;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="ID_Tipo_Usuario", referencedColumnName = "id")
    private TipoUsuario tipoUsuario;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="ID_Persona", referencedColumnName = "dni")
    private Persona persona;
}
