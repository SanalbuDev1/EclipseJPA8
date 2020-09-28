/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author alvar
 */
@Entity
@Table(name = "insumos", catalog = "planta", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_numero_identificacion_fk"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Insumos.findAll", query = "SELECT i FROM Insumos i")
    , @NamedQuery(name = "Insumos.findByIdInsumos", query = "SELECT i FROM Insumos i WHERE i.idInsumos = :idInsumos")})
public class Insumos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_insumos", nullable = false)
    private Integer idInsumos;
    @JoinColumn(name = "id_numero_identificacion_fk", referencedColumnName = "id_numero_identificacion", nullable = false)
    @OneToOne(optional = false, fetch = FetchType.EAGER)
    private NumeroIdentificacion idNumeroIdentificacionFk;
    @OneToMany(mappedBy = "idInsumosFk", fetch = FetchType.EAGER)
    private List<PlantaInsumos> plantaInsumosList;

    public Insumos() {
    }

    public Insumos(Integer idInsumos) {
        this.idInsumos = idInsumos;
    }

    public Integer getIdInsumos() {
        return idInsumos;
    }

    public void setIdInsumos(Integer idInsumos) {
        this.idInsumos = idInsumos;
    }

    public NumeroIdentificacion getIdNumeroIdentificacionFk() {
        return idNumeroIdentificacionFk;
    }

    public void setIdNumeroIdentificacionFk(NumeroIdentificacion idNumeroIdentificacionFk) {
        this.idNumeroIdentificacionFk = idNumeroIdentificacionFk;
    }

    @XmlTransient
    public List<PlantaInsumos> getPlantaInsumosList() {
        return plantaInsumosList;
    }

    public void setPlantaInsumosList(List<PlantaInsumos> plantaInsumosList) {
        this.plantaInsumosList = plantaInsumosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInsumos != null ? idInsumos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Insumos)) {
            return false;
        }
        Insumos other = (Insumos) object;
        if ((this.idInsumos == null && other.idInsumos != null) || (this.idInsumos != null && !this.idInsumos.equals(other.idInsumos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidadades.Insumos[ idInsumos=" + idInsumos + " ]";
    }
    
}
