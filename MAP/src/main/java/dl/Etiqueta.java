package dl;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Etiquetas database table.
 * 
 */
@Entity
@Table(name="Etiquetas")
@NamedQuery(name="Etiqueta.findAll", query="SELECT e FROM Etiqueta e")
public class Etiqueta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idEtiquetas;

	private int estanteria;

	private int pasillo;

	//uni-directional many-to-one association to Producto
	@ManyToOne
	@JoinColumn(name="Productos_idProductos")
	private Producto producto;

	//uni-directional many-to-one association to Supermercado
	@ManyToOne
	@JoinColumn(name="Supermercados_idSupermercados")
	private Supermercado supermercado;

	public Etiqueta() {
	}
	

	public Etiqueta(int idEtiquetas, int estanteria, int pasillo, Producto producto, Supermercado supermercado) {
		super();
		this.idEtiquetas = idEtiquetas;
		this.estanteria = estanteria;
		this.pasillo = pasillo;
		this.producto = producto;
		this.supermercado = supermercado;
	}


	public int getIdEtiquetas() {
		return this.idEtiquetas;
	}

	public void setIdEtiquetas(int idEtiquetas) {
		this.idEtiquetas = idEtiquetas;
	}

	public int getEstanteria() {
		return this.estanteria;
	}

	public void setEstanteria(int estanteria) {
		this.estanteria = estanteria;
	}

	public int getPasillo() {
		return this.pasillo;
	}

	public void setPasillo(int pasillo) {
		this.pasillo = pasillo;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Supermercado getSupermercado() {
		return this.supermercado;
	}

	public void setSupermercado(Supermercado supermercado) {
		this.supermercado = supermercado;
	}

}