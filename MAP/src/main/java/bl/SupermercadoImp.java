package bl;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dl.Supermercado;

import java.util.ArrayList;
import java.util.List;

@Stateless //EJB clase sin estado el bean no mantiene infomracion del estado entre llamadas del metodo
@LocalBean
public class SupermercadoImp {

    @PersistenceContext
    private EntityManager em;

    public Supermercado obtenerSupermercadoPorId(int id) {
        return em.find(Supermercado.class, id);
    }

    public List<Supermercado> obtenerSupermercados() {
        return em.createQuery("SELECT s FROM Supermercado s", Supermercado.class).getResultList();
    }
    
    public List<String> obtenerNombresSupermercados() {
        List<Supermercado> supermercados = obtenerSupermercados();
        List<String> nombres = new ArrayList<>();
        for (Supermercado s : supermercados) {
            nombres.add(s.getDireccion());
        }
        return nombres;
    }


    public void crearSupermercado(Supermercado supermercado) {
        em.persist(supermercado);
    }

    public void actualizarSupermercado(Supermercado supermercado) {
        em.merge(supermercado);
    }

    public void eliminarSupermercado(Supermercado supermercado) {
        em.remove(em.contains(supermercado) ? supermercado : em.merge(supermercado));
    }
}

