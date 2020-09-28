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
@Table(name = "numero_identificacion", catalog = "planta", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NumeroIdentificacion.findAll", query = "SELECT n FROM NumeroIdentificacion n")
    , @NamedQuery(name = "NumeroIdentificacion.findByIdNumeroIdentificacion", query = "SELECT n FROM NumeroIdentificacion n WHERE n.idNumeroIdentificacion = :idNumeroIdentificacion")
    , @NamedQuery(name = "NumeroIdentificacion.findByNombre", query = "SELECT n FROM NumeroIdentificacion n WHERE n.nombre = :nombre")
    , @NamedQuery(name = "NumeroIdentificacion.findByDescripcion", query = "SELECT n FROM NumeroIdentificacion n WHERE n.descripcion = :descripcion")})
public class NumeroIdentificacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_numero_identificacion", nullable = false)
    private Integer idNumeroIdentificacion;
    @Size(max = 45)
    @Column(name = "nombre", length = 45)
    private String nombre;
    @Size(max = 45)
    @Column(name = "descripcion", length = 45)
    private String descripcion;
    @OneToMany(mappedBy = "idNumeroIdentificacionFk", fetch = FetchType.EAGER)
    private List<MateriaPrima> materiaPrimaList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idNumeroIdentificacionFk", fetch = FetchType.EAGER)
    private Insumos insumos;

    public NumeroIdentificacion() {
    }
    
    

    public NumeroIdentificacion(Integer idNumeroIdentificacion, @Size(max = 45) String nombre,
			@Size(max = 45) String descripcion) {
		super();
		this.idNumeroIdentificacion = idNumeroIdentificacion;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}



	public NumeroIdentificacion(Integer idNumeroIdentificacion) {
        this.idNumeroIdentificacion = idNumeroIdentificacion;
    }

    public Integer getIdNumeroIdentificacion() {
        return idNumeroIdentificacion;
    }

    public void setIdNumeroIdentificacion(Integer idNumeroIdentificacion) {
        this.idNumeroIdentificacion = idNumeroIdentificacion;
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

    @XmlTransient
    public List<MateriaPrima> getMateriaPrimaList() {
        return materiaPrimaList;
    }

    public void setMateriaPrimaList(List<MateriaPrima> materiaPrimaList) {
        this.materiaPrimaList = materiaPrimaList;
    }

    public Insumos getInsumos() {
        return insumos;
    }

    public void setInsumos(Insumos insumos) {
        this.insumos = insumos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNumeroIdentificacion != null ? idNumeroIdentificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NumeroIdentificacion)) {
            return false;
        }
        NumeroIdentificacion other = (NumeroIdentificacion) object;
        if ((this.idNumeroIdentificacion == null && other.idNumeroIdentificacion != null) || (this.idNumeroIdentificacion != null && !this.idNumeroIdentificacion.equals(other.idNumeroIdentificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidadades.NumeroIdentificacion[ idNumeroIdentificacion=" + idNumeroIdentificacion + " ]";
    }
    
}
