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
@Table(name="Usuarios")
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private long id;

    @Column(name="Nombre")
    private String nombre ;

    @Column(name="Contrasenia")
    private String contrasenia;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="ID_Tipo_Usuario", referencedColumnName = "ID")
    private TipoUsuario tipoUsuario;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="ID_Persona", referencedColumnName = "DNI")
    private Persona persona;
}
