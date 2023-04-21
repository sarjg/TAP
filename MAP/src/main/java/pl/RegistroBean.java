package pl;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import bl.AdministradorImp;
import dl.Adiminstrador;
import dl.Supermercado;

import java.io.Serializable;

@Named
@RequestScoped
public class RegistroBean implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idAdiminstradores;
	private String apellido;
	private String contraseña;
	private String correo;
	private String dni;
	private String login;
	private String nombre;
	private String tipo;
	private Supermercado supermercado; //que hago yo con esto problema

	@EJB
    private AdministradorImp admii;
    
    public String registrar() {
    	Supermercado supe = new Supermercado();
    	Adiminstrador admin = new Adiminstrador(idAdiminstradores, apellido, contraseña, correo, dni,
    			login, nombre, tipo);
    	admii.crearAdministrador(admin);
      
        return "login.xhtml?faces-redirect=true";
    }
    
    public String actualizar() {
    	Adiminstrador admin = new Adiminstrador(idAdiminstradores, apellido, contraseña, correo, dni,
    			login, nombre, tipo);
    	admii.actualizarAdministrador(admin);
      
        return "login.xhtml?faces-redirect=true";
    }
    
    public String eliminar() {
    	Adiminstrador admin = new Adiminstrador(idAdiminstradores, apellido, contraseña, correo, dni,
    			login, nombre, tipo);
    	admii.eliminarAdministrador(admin);
      
        return "login.xhtml?faces-redirect=true";
    }
    

    // Getters y setters

}
