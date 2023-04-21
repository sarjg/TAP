package bl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import dl.Producto;
import dl.Supermercado;

@Stateless //EJB clase sin estado el bean no mantiene infomracion del estado entre llamadas del metodo
@LocalBean
public class ProductoImp {
    
    @PersistenceContext
    EntityManager em;

    public void crearProducto(Producto producto) {
        em.persist(producto);
    }

    public void actualizarProducto(Producto producto) {
        em.merge(producto);
    }

    public void eliminarProducto(Producto producto) {
        em.remove(em.merge(producto));
    }

    public Producto obtenerProductoPorId(int id) {
        return em.find(Producto.class, id);
    }

    public Producto obtenerProductoPorNombre(String nombre) {
        return (Producto) em.createQuery("SELECT p FROM Producto p WHERE p.nombre LIKE :nombre", Producto.class)
            .setParameter("nombre", nombre).getResultStream();
    }

    public List<Producto> obtenerProductosPorTipo(int idTipo) {
        return em.createQuery("SELECT p FROM Producto p WHERE p.tipo.id = :idTipo", Producto.class)
            .setParameter("idTipo", idTipo)
            .getResultList();
    }

    public List<Producto> obtenerProductosPorSupermercado(int idSupermercado) {
        return em.createQuery("SELECT p FROM Producto p WHERE p.supermercado.id = :idSupermercado", Producto.class)
            .setParameter("idSupermercado", idSupermercado)
            .getResultList();
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
