package mx.com.gm.sga.domain;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "usuario")
@NamedQueries({ @NamedQuery(name = "Usuario.findAll", query = "SELECT p FROM Usuario p ORDER BY p.idUsuario") })
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private long idUsuario;

	@ManyToOne
	@JoinColumn(name = "id_persona", referencedColumnName = "idpersona")
	private Persona idPersona;

	private String username;
	private String password;

	public Usuario() {
	}

	public Usuario(Persona idPersona, String username, String password) {
		super();
		this.idPersona = idPersona;
		this.username = username;
		this.password = password;
	}

	public Usuario(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Persona getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Persona idPersona) {
		this.idPersona = idPersona;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
