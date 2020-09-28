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
@Table(name = "planta_insumos", catalog = "planta", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlantaInsumos.findAll", query = "SELECT p FROM PlantaInsumos p")
    , @NamedQuery(name = "PlantaInsumos.findByIdplantaInsumos", query = "SELECT p FROM PlantaInsumos p WHERE p.idplantaInsumos = :idplantaInsumos")
    , @NamedQuery(name = "PlantaInsumos.findByCantitadTotal", query = "SELECT p FROM PlantaInsumos p WHERE p.cantitadTotal = :cantitadTotal")})
public class PlantaInsumos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idplanta_insumos", nullable = false)
    private Integer idplantaInsumos;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cantitad_total", precision = 22)
    private Double cantitadTotal;
    @JoinColumn(name = "id_insumos_fk", referencedColumnName = "id_insumos")
    @ManyToOne(fetch = FetchType.EAGER)
    private Insumos idInsumosFk;
    @JoinColumn(name = "id_planta_fk", referencedColumnName = "id_plantas")
    @ManyToOne(fetch = FetchType.EAGER)
    private Planta idPlantaFk;

    public PlantaInsumos() {
    }

    public PlantaInsumos(Integer idplantaInsumos) {
        this.idplantaInsumos = idplantaInsumos;
    }

    public Integer getIdplantaInsumos() {
        return idplantaInsumos;
    }

    public void setIdplantaInsumos(Integer idplantaInsumos) {
        this.idplantaInsumos = idplantaInsumos;
    }

    public Double getCantitadTotal() {
        return cantitadTotal;
    }

    public void setCantitadTotal(Double cantitadTotal) {
        this.cantitadTotal = cantitadTotal;
    }

    public Insumos getIdInsumosFk() {
        return idInsumosFk;
    }

    public void setIdInsumosFk(Insumos idInsumosFk) {
        this.idInsumosFk = idInsumosFk;
    }

    public Planta getIdPlantaFk() {
        return idPlantaFk;
    }

    public void setIdPlantaFk(Planta idPlantaFk) {
        this.idPlantaFk = idPlantaFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idplantaInsumos != null ? idplantaInsumos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlantaInsumos)) {
            return false;
        }
        PlantaInsumos other = (PlantaInsumos) object;
        if ((this.idplantaInsumos == null && other.idplantaInsumos != null) || (this.idplantaInsumos != null && !this.idplantaInsumos.equals(other.idplantaInsumos))) {
            return false;
        }
        return true;
    }

	@Override
	public String toString() {
		return "PlantaInsumos [idplantaInsumos=" + idplantaInsumos + ", cantitadTotal=" + cantitadTotal
				+ ", idInsumosFk=" + idInsumosFk + ", idPlantaFk=" + idPlantaFk + "]";
	}

   
    
}
