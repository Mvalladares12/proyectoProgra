package modelo;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author mario_5ymtv0r
 */
@Entity
@Table(name="clientes")
public class Cliente implements Serializable{
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idUsuario;    
    @Column(name="apellido")
    private String apellido;
    @Column(name="nombre")
    private String nombre;
    
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.idUsuario;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (this.idUsuario != other.idUsuario) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cliente{" + "idUsuario=" + idUsuario + '}';
    }
    
    
}
