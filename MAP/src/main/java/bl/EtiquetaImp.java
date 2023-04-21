package bl;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dl.Etiqueta;

@Stateless 
@LocalBean
public class EtiquetaImp {

    @PersistenceContext
    private EntityManager em;
    
    public Etiqueta obtenerEtiquetaPorId(int id) {
        return em.find(Etiqueta.class, id);
    }

    public void crearEtiqueta(Etiqueta etiqueta) {
        em.persist(etiqueta);
    }

    public void actualizarEtiqueta(Etiqueta etiqueta) {
        em.merge(etiqueta);
    }

    public void eliminarEtiqueta(Etiqueta etiqueta) {
        em.remove(em.merge(etiqueta));
    }

}
