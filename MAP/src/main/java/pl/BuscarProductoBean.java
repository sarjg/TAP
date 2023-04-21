package pl;


import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.imageio.ImageIO;
import javax.inject.Named;
//mport org.primefaces.model.DefaultStreamedContent;
//import org.primefaces.model.StreamedContent;

import bl.ProductoImp;
import bl.SupermercadoImp;
import dl.Producto;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

@Named
@ViewScoped
public class BuscarProductoBean implements Serializable {

    private static final long serialVersionUID = 1L;
    @EJB
    private ProductoImp prodi;
    
    private String nombreProducto;
    private String nombreSupermercado = "Eroski";
    private Producto producto;
  //  private StreamedContent imagenProducto;
 //   private String imagenProducto;
    
    @PostConstruct
    public void init() {
//    	cargarNombreSupermercado();
    }

    public void buscarProducto() {
        producto = prodi.obtenerProductoPorNombre(nombreProducto);
        this.nombreProducto = producto.getNombre();
    }
    
    public BufferedImage cargarImagen(String ruta) throws IOException {
		return null;
        /*File archivoImagen = new File(ruta);
        if (archivoImagen.exists()) {
            BufferedImage imagen = ImageIO.read(archivoImagen);
            return imagen;
        } else {
            System.out.println("La imagen no existe en la ruta especificada.");
            return null;
        }*/
    }


    
  /*  public void cargarNombreSupermercado() {
    	this.nombreSupermercado = superb.getSupermercadoSeleccionado();
    }*/

    public void reset() {
        nombreProducto = null;
        nombreSupermercado = null;
        producto = null;
//        imagenProducto = null;
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

 /*   public StreamedContent getImagenProducto() {
        return imagenProducto;
    }

    public void setImagenProducto(StreamedContent imagenProducto) {
        this.imagenProducto = imagenProducto;
    }
*/
}
    

