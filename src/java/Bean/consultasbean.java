/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import entidad.Productos;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Abel
 */
@Named(value = "consultasbean")
@SessionScoped
public class consultasbean implements Serializable {

    private int id=0;
    private String textobusq = "";
    private List<Productos> Listadatos = new ArrayList<>();

    @EJB
    private ProductosFacade con;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTextobusq() {
        return textobusq;
    }

    public void setTextobusq(String textobusq) {
        this.textobusq = textobusq;
    }

    public List<Productos> getListadatos() {
        return Listadatos;
    }

    public void setListadatos(List<Productos> Listadatos) {
        this.Listadatos = Listadatos;
    }

    /**
     * Creates a new instance of consultasbean
     */
    public consultasbean() {
    }

    public void llenarusu() {
        Listadatos = con.obtenerusuario(textobusq);
    }

    public void llenarusunotext() {
        Listadatos = con.mayores();
    }

    public void llenarsinid() {
        con.eliminarid(id);
    }

    public void menosde10() {
        Listadatos = con.menosde10();
    }

    public void actualizar() {
        Listadatos = con.actualizar();
    }
}
