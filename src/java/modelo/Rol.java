package modelo;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author mario_5ymtv0r
 */

@Entity
@Table(name="rol")
public class Rol implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idRol;
    @Column(name="nRol")
    private String nRol;

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getnRol() {
        return nRol;
    }

    public void setnRol(String nRol) {
        this.nRol = nRol;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.idRol;
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
        final Rol other = (Rol) obj;
        if (this.idRol != other.idRol) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Rol{" + "idRol=" + idRol + '}';
    }
    
    
}
