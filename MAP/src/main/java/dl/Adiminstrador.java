package dl;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Adiminstradores database table.
 * 
 */
@Entity
@Table(name="Adiminstradores")
@NamedQuery(name="Adiminstrador.findAll", query="SELECT a FROM Adiminstrador a")
public class Adiminstrador implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idAdiminstradores;
	private String apellido;
	private String contraseña;
	private String correo;
	private String dni;
	private String login;
	private String nombre;
	private String tipo;
	private Supermercado supermercado;

	public Adiminstrador() {
	}

	public Adiminstrador(int idAdiminstradores, String apellido, String contraseña, String correo, String dni,
			String login, String nombre, String tipo) {
		super();
		this.idAdiminstradores = idAdiminstradores;
		this.apellido = apellido;
		this.contraseña = contraseña;
		this.correo = correo;
		this.dni = dni;
		this.login = login;
		this.nombre = nombre;
		this.tipo = tipo;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getIdAdiminstradores() {
		return this.idAdiminstradores;
	}

	public void setIdAdiminstradores(int idAdiminstradores) {
		this.idAdiminstradores = idAdiminstradores;
	}


	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getContraseña() {
		return this.contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}


	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}


	@Column(name="DNI")
	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}


	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}


	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	//uni-directional many-to-one association to Supermercado
	@ManyToOne
	@JoinColumn(name="Supermercados_idSupermercados")
	public Supermercado getSupermercado() {
		return this.supermercado;
	}

	public void setSupermercado(Supermercado supermercado) {
		this.supermercado = supermercado;
	}

}