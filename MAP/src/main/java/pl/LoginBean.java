package pl;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import bl.AdministradorImp;

@Named
@RequestScoped
public class LoginBean {

	@EJB
    private AdministradorImp admii;
	
    private String username;
    private String password;

    public String login() {
    	//ESTO NO ES LO QUE NOS INTERESA
        if (username.equals("admin") && password.equals("1234")) {
            return "seleccion_supermercado.xhtml";
        } else {
            return "login.xhtml";
        }
    }

    // Getters y Setters
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
}

