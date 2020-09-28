/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author alvar
 */
@Entity
@Table(name = "planta_materia_prima", catalog = "planta", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlantaMateriaPrima.findAll", query = "SELECT p FROM PlantaMateriaPrima p")
    , @NamedQuery(name = "PlantaMateriaPrima.findByIdplantaMateriaPrima", query = "SELECT p FROM PlantaMateriaPrima p WHERE p.idplantaMateriaPrima = :idplantaMateriaPrima")
    , @NamedQuery(name = "PlantaMateriaPrima.findByCantidadTotal", query = "SELECT p FROM PlantaMateriaPrima p WHERE p.cantidadTotal = :cantidadTotal")})
public class PlantaMateriaPrima implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idplanta_materia_prima", nullable = false)
    private Integer idplantaMateriaPrima;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cantidad_total", precision = 22)
    private Double cantidadTotal;
    @JoinColumn(name = "id_materia_prima", referencedColumnName = "idmateria_prima")
    @ManyToOne(fetch = FetchType.EAGER)
    private MateriaPrima idMateriaPrima;
    @JoinColumn(name = "id_planta", referencedColumnName = "id_plantas")
    @ManyToOne(fetch = FetchType.EAGER)
    private Planta idPlanta;

    public PlantaMateriaPrima() {
    }

    public PlantaMateriaPrima(Integer idplantaMateriaPrima) {
        this.idplantaMateriaPrima = idplantaMateriaPrima;
    }

    public Integer getIdplantaMateriaPrima() {
        return idplantaMateriaPrima;
    }

    public void setIdplantaMateriaPrima(Integer idplantaMateriaPrima) {
        this.idplantaMateriaPrima = idplantaMateriaPrima;
    }

    public Double getCantidadTotal() {
        return cantidadTotal;
    }

    public void setCantidadTotal(Double cantidadTotal) {
        this.cantidadTotal = cantidadTotal;
    }

    public MateriaPrima getIdMateriaPrima() {
        return idMateriaPrima;
    }

    public void setIdMateriaPrima(MateriaPrima idMateriaPrima) {
        this.idMateriaPrima = idMateriaPrima;
    }

    public Planta getIdPlanta() {
        return idPlanta;
    }

    public void setIdPlanta(Planta idPlanta) {
        this.idPlanta = idPlanta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idplantaMateriaPrima != null ? idplantaMateriaPrima.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlantaMateriaPrima)) {
            return false;
        }
        PlantaMateriaPrima other = (PlantaMateriaPrima) object;
        if ((this.idplantaMateriaPrima == null && other.idplantaMateriaPrima != null) || (this.idplantaMateriaPrima != null && !this.idplantaMateriaPrima.equals(other.idplantaMateriaPrima))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidadades.PlantaMateriaPrima[ idplantaMateriaPrima=" + idplantaMateriaPrima + " ]";
    }
    
}
