package pl;


import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
//mport org.primefaces.model.DefaultStreamedContent;
//import org.primefaces.model.StreamedContent;

import bl.EtiquetaImp;
import bl.ProductoImp;
import dl.Etiqueta;
import dl.Producto;

import java.io.Serializable;

@Named
@ViewScoped
public class BuscarProductoBean implements Serializable {

    private static final long serialVersionUID = 1L;
    @EJB
    private ProductoImp prodi;
    
    @EJB
    private EtiquetaImp eti;
    
    private String nombreProducto;
    private int pasillo;
    private int estanteria;
    private String warn;
    private String nombreSupermercado;
    private Producto producto;
    
    @PostConstruct
    public void init() {
//    	cargarNombreSupermercado();
    }

    public void buscarProducto() {
        producto = prodi.obtenerProductoPorNombre(nombreProducto); // devuelve el producto buscado ERROR?
        if (producto != null) {
        	setWarn("Producto encontrado!");
        Etiqueta etiqueta = eti.obtenerEtiquetaPorId(producto.getIdProductos()); //idprod y idetiqueta son iguales
        setEstanteria(etiqueta.getEstanteria());
        setPasillo(etiqueta.getPasillo());
        
        } else {
        	setWarn("Producto no encontrado, intentelo otra vez");
        }
    }    

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getNombreSupermercado() {
        return nombreSupermercado;
    }

    public void setNombreSupermercado(String nombreSupermercado) {
        this.nombreSupermercado = nombreSupermercado;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

	public String getWarn() {
		return warn;
	}

	public void setWarn(String warn) {
		this.warn = warn;
	}

	public int getPasillo() {
		return pasillo;
	}

	public void setPasillo(int pasillo) {
		this.pasillo = pasillo;
	}

	public int getEstanteria() {
		return estanteria;
	}

	public void setEstanteria(int estanteria) {
		this.estanteria = estanteria;
	}

}
    

