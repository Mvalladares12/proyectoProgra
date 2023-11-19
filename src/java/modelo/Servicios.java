/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author mario_5ymtv0r
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Servicios.findAll", query = "SELECT s FROM Servicios s ORDER BY s.idServicios"),
    @NamedQuery(name = "Servicios.findByIdServicios", query = "SELECT s FROM Servicios s WHERE s.idServicios = :idServicios"),
    @NamedQuery(name = "Servicios.findByNombre", query = "SELECT s FROM Servicios s WHERE s.nombre = :nombre"),
    @NamedQuery(name = "Servicios.findByPrecio", query = "SELECT s FROM Servicios s WHERE s.precio = :precio"),
    @NamedQuery(name = "Servicios.findByImagen", query = "SELECT s FROM Servicios s WHERE s.imagen = :imagen"),
    @NamedQuery(name = "Servicios.findByDescrip", query = "SELECT s FROM Servicios s WHERE s.descrip = :descrip"),
    @NamedQuery(name = "Servicios.findByRating", query = "SELECT s FROM Servicios s WHERE s.rating = :rating")})
public class Servicios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idServicios;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    private String nombre;
    @Basic(optional = false)
    @NotNull
    private double precio;
    @Size(max = 300)
    private String imagen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    private String descrip;
    private Integer rating;

    public Servicios() {
    }

    public Servicios(Integer idServicios) {
        this.idServicios = idServicios;
    }

    public Servicios(Integer idServicios, String nombre, double precio, String descrip) {
        this.idServicios = idServicios;
        this.nombre = nombre;
        this.precio = precio;
        this.descrip = descrip;
    }

    public Integer getIdServicios() {
        return idServicios;
    }

    public void setIdServicios(Integer idServicios) {
        this.idServicios = idServicios;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idServicios != null ? idServicios.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Servicios)) {
            return false;
        }
        Servicios other = (Servicios) object;
        if ((this.idServicios == null && other.idServicios != null) || (this.idServicios != null && !this.idServicios.equals(other.idServicios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Servicios[ idServicios=" + idServicios + " ]";
    }
    
}
