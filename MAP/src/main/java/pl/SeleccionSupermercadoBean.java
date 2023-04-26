package pl;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import bl.SupermercadoImp;

import java.io.Serializable;
import java.util.List;

import dl.Supermercado;

@Named
@ViewScoped
public class SeleccionSupermercadoBean implements Serializable {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB  //  
    private SupermercadoImp superi; 
	
    private List<Supermercado> supermercados;
    private List<String> nombreSupermercados;
    private String supermercadoSeleccionado;
        
    @PostConstruct
    public void init() {
    	cargarSupermercados();
    }
    
    public void cargarSupermercados() { 
        this.setNombreSupermercados(superi.obtenerNombresSupermercados());
    }
        
    public List<Supermercado> getSupermercados() {
        return supermercados;
    }

    public void setSupermercados(List<Supermercado> supermercados) {
        this.supermercados = supermercados;
    }	

	public String getSupermercadoSeleccionado() {
		return supermercadoSeleccionado;
	}

	public void setSupermercadoSeleccionado(String supermercadoSeleccionado) {
		this.supermercadoSeleccionado = supermercadoSeleccionado;
	}

	public List<String> getNombreSupermercados() {
		return nombreSupermercados;
	}

	public void setNombreSupermercados(List<String> nombreSupermercados) {
		this.nombreSupermercados = nombreSupermercados;
	}

   
}
