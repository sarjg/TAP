package pl;

import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import bl.AdministradorImp;
import dl.Adiminstrador;
import dl.Supermercado;

import java.io.Serializable;

@Named
@ViewScoped
public class RegistroBean implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @EJB
    private AdministradorImp AdministradorImp;

    private String nombre;
    private String apellido;
    private String email;
    private String username;
    private String password;
    private String mensajeError;

    public String registrar() {
        try {
            Adiminstrador AdmininstradorExistente = AdministradorImp.findByUsername(username); 
            if (AdmininstradorExistente != null) {
                mensajeError = "Ya existe un Admininstrador registrado con ese nombre de Admininstrador.";
                return null;
            }

            Adiminstrador Admininstrador = new Adiminstrador();
            Admininstrador.setNombre(nombre);
            Admininstrador.setApellido(apellido);
            Admininstrador.setCorreo(email);
            Admininstrador.setLogin(username);
            Admininstrador.setContraseña(password);
            Admininstrador.setTipo("Cliente");
            
            Supermercado superm = new Supermercado();
            superm.setIdSupermercados(1);
            Admininstrador.setSupermercado(superm);
            
            AdministradorImp.crearAdministrador(Admininstrador);

            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            session.setAttribute("Admininstrador", Admininstrador);

            return "seleccion_supermercado?faces-redirect=true";
        } catch (Exception e) {
            mensajeError = "Error al registrar el Admininstrador.";
            e.printStackTrace();
            return null;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }
}



