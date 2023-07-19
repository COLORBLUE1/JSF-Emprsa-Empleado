/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import entidad.Productos;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Abel
 */
@Stateless
public class ProductosFacade extends AbstractFacade<Productos> {

    @PersistenceContext(unitName = "Abel_projectPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductosFacade() {
        super(Productos.class);
    }
     /*Consultar los productos de la tabla productos.*/
    public List<Productos> obtenerusuario(String cadena) {
        Query q = em.createNativeQuery("SELECT * FROM productos where nombre LIKE '%" + cadena + "%';", Productos.class);
        List<Productos> lst = q.getResultList();
        return lst;

    }

    /*Consultar los productos que su precio esta entre
    los 10.000 y 100.000 pesos*/
    public List<Productos> mayores() {
        Query q = em.createNativeQuery("SELECT * FROM productos  WHERE precio >= 10000 AND precio <= 100000", Productos.class);
        List<Productos> lst = q.getResultList();
        return lst;

    }

    /*Eliminar un producto de la tabla productos
    mediante el ID*/
     public void eliminarid(int id) {
       Productos entidad = em.find(Productos.class, id);
        if (entidad != null) {
            em.remove(entidad);
        }
     }
    /*Consultar los productos que tienen menos de 10
    elementos en la cantidad.*/
     public List<Productos> menosde10() {
        Query q = em.createNativeQuery("SELECT * FROM productos  WHERE cantidad < 10", Productos.class);
        List<Productos> lst = q.getResultList();
        return lst;

    }
     /*Actualizar base de datos*/
      public List<Productos> actualizar() {
        Query q = em.createNativeQuery("SELECT * FROM productos ", Productos.class);
        List<Productos> lst = q.getResultList();
        return lst;

    }
}
