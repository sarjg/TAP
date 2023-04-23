package dl;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Productos database table.
 * 
 */
@Entity
@Table(name="Productos")
@NamedQuery(name="Producto.findAll", query="SELECT p FROM Producto p")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idProductos;

	private String nombre;

	private float precio;

	//uni-directional many-to-one association to Supermercado
	@ManyToOne
	@JoinColumn(name="Supermercados_idSupermercados")
	private Supermercado supermercado;

	public Producto() {
	}

	public Producto(int idProductos, String imagen, String nombre, float precio, int tiposS_idTiposS) {
		super();
		this.idProductos = idProductos;
		this.nombre = nombre;
		this.precio = precio;
	}

	public int getIdProductos() {
		return this.idProductos;
	}

	public void setIdProductos(int idProductos) {
		this.idProductos = idProductos;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPrecio() {
		return this.precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}


	public Supermercado getSupermercado() {
		return this.supermercado;
	}

	public void setSupermercado(Supermercado supermercado) {
		this.supermercado = supermercado;
	}

}