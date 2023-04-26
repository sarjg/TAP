package bl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import dl.Producto;
import dl.Supermercado;

@Stateless //EJB clase sin estado el bean no mantiene infomracion del estado entre llamadas del metodo
@LocalBean
public class ProductoImp {
    
    @PersistenceContext
    EntityManager em;

    public Producto obtenerProductoPorNombre(String nombre) {
        Producto producto = null;
        try {
            producto = em.createQuery("SELECT p FROM Producto p WHERE p.nombre LIKE :nombre", Producto.class)
                .setParameter("nombre", nombre)
                .getSingleResult();//solo un producto
        } catch (NoResultException e) {
            // No se encontró ninguna entidad que cumpla con los criterios de búsqueda
            // Seteamos el producto a null y mostramos un mensaje de error al usuario 
            producto = null;
        }
        return producto;
    }
    
    public List<Producto> buscarProductosPorNombreYSupermercado(String nombre, Supermercado supermercado) {
        List<Producto> productos = null;
        try {
            TypedQuery<Producto> query = em.createQuery("SELECT p FROM Producto p WHERE p.nombre = :nombre AND p.supermercado = :supermercado", Producto.class);
            query.setParameter("nombre", nombre);
            query.setParameter("supermercado", supermercado);
            productos = query.getResultList();
        } finally {
            em.close();
        }
        return productos;
    }


}
