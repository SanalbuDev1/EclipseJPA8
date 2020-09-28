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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author alvar
 */
@Entity
@Table(name = "materia_prima", catalog = "planta", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MateriaPrima.findAll", query = "SELECT m FROM MateriaPrima m")
    , @NamedQuery(name = "MateriaPrima.findByIdmateriaPrima", query = "SELECT m FROM MateriaPrima m WHERE m.idmateriaPrima = :idmateriaPrima")})
public class MateriaPrima implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmateria_prima", nullable = false)
    private Integer idmateriaPrima;
    @JoinColumn(name = "id_numero_identificacion_fk", referencedColumnName = "id_numero_identificacion")
    @ManyToOne(fetch = FetchType.EAGER)
    private NumeroIdentificacion idNumeroIdentificacionFk;
    @OneToMany(mappedBy = "idMateriaPrima", fetch = FetchType.EAGER)
    private List<PlantaMateriaPrima> plantaMateriaPrimaList;

    public MateriaPrima() {
    }

    public MateriaPrima(Integer idmateriaPrima) {
        this.idmateriaPrima = idmateriaPrima;
    }

    public Integer getIdmateriaPrima() {
        return idmateriaPrima;
    }

    public void setIdmateriaPrima(Integer idmateriaPrima) {
        this.idmateriaPrima = idmateriaPrima;
    }

    public NumeroIdentificacion getIdNumeroIdentificacionFk() {
        return idNumeroIdentificacionFk;
    }

    public void setIdNumeroIdentificacionFk(NumeroIdentificacion idNumeroIdentificacionFk) {
        this.idNumeroIdentificacionFk = idNumeroIdentificacionFk;
    }

    @XmlTransient
    public List<PlantaMateriaPrima> getPlantaMateriaPrimaList() {
        return plantaMateriaPrimaList;
    }

    public void setPlantaMateriaPrimaList(List<PlantaMateriaPrima> plantaMateriaPrimaList) {
        this.plantaMateriaPrimaList = plantaMateriaPrimaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmateriaPrima != null ? idmateriaPrima.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MateriaPrima)) {
            return false;
        }
        MateriaPrima other = (MateriaPrima) object;
        if ((this.idmateriaPrima == null && other.idmateriaPrima != null) || (this.idmateriaPrima != null && !this.idmateriaPrima.equals(other.idmateriaPrima))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidadades.MateriaPrima[ idmateriaPrima=" + idmateriaPrima + " ]";
    }
    
}
