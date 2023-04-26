package bl;


import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import dl.Adiminstrador;

@Stateless //EJB clase sin estado el bean no mantiene infomracion del estado entre llamadas del metodo
@LocalBean
public class AdministradorImp{

    @PersistenceContext //crear y adminisntrar las instancias del entinty
    private EntityManager entityManager; //interactuar con la base de datos


    public Adiminstrador findByUsernameAndPassword(String login, String contraseña) {
        TypedQuery<Adiminstrador> query = entityManager.createQuery("SELECT a FROM Adiminstrador a WHERE a.login = :login AND a.contraseña = :contraseña", Adiminstrador.class);
        query.setParameter("login", login);
        query.setParameter("contraseña", contraseña);
        
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    
    public Adiminstrador findByUsername(String login) {
        Query query = entityManager.createQuery("SELECT u FROM Adiminstrador u WHERE u.login = :login");
        query.setParameter("login", login);
        
        try {   
            return (Adiminstrador) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } 
    }

    public Adiminstrador obtenerAdministradorPorId(int id) {
        return entityManager.find(Adiminstrador.class, id);
    }

    public void crearAdministrador(Adiminstrador administrador) {
        entityManager.persist(administrador);
    }

    public void actualizarAdministrador(Adiminstrador administrador) {
        entityManager.merge(administrador);
    }

    public void eliminarAdministrador(Adiminstrador administrador) {
        entityManager.remove(entityManager.merge(administrador));
    }
}
