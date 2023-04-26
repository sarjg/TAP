package pl;

import bl.AdministradorImp;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;

@Named
@SessionScoped
public class LoginBean implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
    private String password;
    private String errorMessage;

    @EJB
    private AdministradorImp AdministradorImp;

    public void login() throws IOException {
        if (AdministradorImp.findByUsernameAndPassword(username, password) != null) { //si coincide el login con un usaurio existente
            ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext(); 
            externalContext.getSessionMap().put("username", username); //guardan el nombre de usuario en la sesión HTTP del usuario 
            externalContext.redirect("seleccion_supermercado.xhtml");
        } else {
            setErrorMessage("Invalid username or password.");
        }
    }

    public void doLogout() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        externalContext.getSessionMap().remove("username");
        externalContext.invalidateSession();
        externalContext.redirect("login.xhtml");
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

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}


