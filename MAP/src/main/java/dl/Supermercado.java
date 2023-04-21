package dl;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Supermercados database table.
 * 
 */
@Entity
@Table(name="Supermercados")
@NamedQuery(name="Supermercado.findAll", query="SELECT s FROM Supermercado s")
public class Supermercado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idSupermercados;

	private String direccion;

	private String nombre;

	public Supermercado() {
	}

	public Supermercado(int idSupermercados, String direccion, String nombre) {
		super();
		this.idSupermercados = idSupermercados;
		this.direccion = direccion;
		this.nombre = nombre;
	}

	public int getIdSupermercados() {
		return this.idSupermercados;
	}

	public void setIdSupermercados(int idSupermercados) {
		this.idSupermercados = idSupermercados;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}