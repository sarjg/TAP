package bl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dl.Adiminstrador;

@Stateless //EJB clase sin estado el bean no mantiene infomracion del estado entre llamadas del metodo
@LocalBean
public class AdministradorImp{

    @PersistenceContext //crear y adminisntrar las instancias del entinty
    private EntityManager entityManager; //interactuar con la base de datos

    public List<Adiminstrador> obtenerAdministradores() {
        return entityManager.createQuery("SELECT a FROM Administrador a", Adiminstrador.class).getResultList();
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
