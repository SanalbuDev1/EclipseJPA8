/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author alvar
 */
@Entity
@Table(name = "sedes", catalog = "planta", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_planta_fk"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sedes.findAll", query = "SELECT s FROM Sedes s")
    , @NamedQuery(name = "Sedes.findByIdSedes", query = "SELECT s FROM Sedes s WHERE s.idSedes = :idSedes")
    , @NamedQuery(name = "Sedes.findByNombre", query = "SELECT s FROM Sedes s WHERE s.nombre = :nombre")
    , @NamedQuery(name = "Sedes.findByDireccion", query = "SELECT s FROM Sedes s WHERE s.direccion = :direccion")
    , @NamedQuery(name = "Sedes.findByDescripcion", query = "SELECT s FROM Sedes s WHERE s.descripcion = :descripcion")})
public class Sedes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_sedes", nullable = false)
    private Integer idSedes;
    @Size(max = 45)
    @Column(name = "nombre", length = 45)
    private String nombre;
    @Size(max = 45)
    @Column(name = "direccion", length = 45)
    private String direccion;
    @Size(max = 45)
    @Column(name = "descripcion", length = 45)
    private String descripcion;
    @JoinColumn(name = "id_planta_fk", referencedColumnName = "id_plantas")
    @OneToOne(fetch = FetchType.EAGER)
    private Planta idPlantaFk;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSedesF", fetch = FetchType.EAGER)
    private List<Planta> plantaList;

    public Sedes() {
    }

    public Sedes(Integer idSedes) {
        this.idSedes = idSedes;
    }

    public Integer getIdSedes() {
        return idSedes;
    }

    public void setIdSedes(Integer idSedes) {
        this.idSedes = idSedes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Planta getIdPlantaFk() {
        return idPlantaFk;
    }

    public void setIdPlantaFk(Planta idPlantaFk) {
        this.idPlantaFk = idPlantaFk;
    }

    @XmlTransient
    public List<Planta> getPlantaList() {
        return plantaList;
    }

    public void setPlantaList(List<Planta> plantaList) {
        this.plantaList = plantaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSedes != null ? idSedes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sedes)) {
            return false;
        }
        Sedes other = (Sedes) object;
        if ((this.idSedes == null && other.idSedes != null) || (this.idSedes != null && !this.idSedes.equals(other.idSedes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Sedes[ idSedes=" + idSedes + " ]";
    }
    
}
