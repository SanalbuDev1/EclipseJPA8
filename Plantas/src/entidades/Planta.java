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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author alvar
 */
@Entity
@Table(name = "planta", catalog = "planta", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Planta.findAll", query = "SELECT p FROM Planta p")
    , @NamedQuery(name = "Planta.findByIdPlantas", query = "SELECT p FROM Planta p WHERE p.idPlantas = :idPlantas")
    , @NamedQuery(name = "Planta.findByNombre", query = "SELECT p FROM Planta p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Planta.findByDescripcion", query = "SELECT p FROM Planta p WHERE p.descripcion = :descripcion")})
public class Planta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_plantas", nullable = false)
    private Integer idPlantas;
    @Size(max = 45)
    @Column(name = "nombre", length = 45)
    private String nombre;
    @Size(max = 45)
    @Column(name = "descripcion", length = 45)
    private String descripcion;
    @OneToOne(mappedBy = "idPlantaFk", fetch = FetchType.EAGER)
    private Sedes sedes;
    @OneToMany(mappedBy = "idPlantaFk", fetch = FetchType.EAGER)
    private List<PlantaInsumos> plantaInsumosList;
    @OneToMany(mappedBy = "idPlanta", fetch = FetchType.EAGER)
    private List<PlantaMateriaPrima> plantaMateriaPrimaList;
    @JoinColumn(name = "id_maquinas_fk", referencedColumnName = "id_maquina")
    @ManyToOne(fetch = FetchType.EAGER)
    private Maquina idMaquinasFk;
    @JoinColumn(name = "id_sedes_f", referencedColumnName = "id_sedes", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Sedes idSedesF;

    public Planta() {
    }

    public Planta(Integer idPlantas) {
        this.idPlantas = idPlantas;
    }

    public Integer getIdPlantas() {
        return idPlantas;
    }

    public void setIdPlantas(Integer idPlantas) {
        this.idPlantas = idPlantas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Sedes getSedes() {
        return sedes;
    }

    public void setSedes(Sedes sedes) {
        this.sedes = sedes;
    }

    @XmlTransient
    public List<PlantaInsumos> getPlantaInsumosList() {
        return plantaInsumosList;
    }

    public void setPlantaInsumosList(List<PlantaInsumos> plantaInsumosList) {
        this.plantaInsumosList = plantaInsumosList;
    }

    @XmlTransient
    public List<PlantaMateriaPrima> getPlantaMateriaPrimaList() {
        return plantaMateriaPrimaList;
    }

    public void setPlantaMateriaPrimaList(List<PlantaMateriaPrima> plantaMateriaPrimaList) {
        this.plantaMateriaPrimaList = plantaMateriaPrimaList;
    }

    public Maquina getIdMaquinasFk() {
        return idMaquinasFk;
    }

    public void setIdMaquinasFk(Maquina idMaquinasFk) {
        this.idMaquinasFk = idMaquinasFk;
    }

    public Sedes getIdSedesF() {
        return idSedesF;
    }

    public void setIdSedesF(Sedes idSedesF) {
        this.idSedesF = idSedesF;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPlantas != null ? idPlantas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Planta)) {
            return false;
        }
        Planta other = (Planta) object;
        if ((this.idPlantas == null && other.idPlantas != null) || (this.idPlantas != null && !this.idPlantas.equals(other.idPlantas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Planta[ idPlantas=" + idPlantas + " ]";
    }
    
}
