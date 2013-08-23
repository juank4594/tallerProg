package co.edu.um.tallerProg.Controlador;
import co.edu.um.tallerProg.Modelo.*;
import co.edu.um.tallerProg.Controlador.*;
import co.edu.um.tallerProg.Vista.*;

/**
 * La clase Navegacion es el controlador que se encarga de abrir las ventanas según las órdenes del usuario.
 */
public class Navegacion {
    /**
     * Atributos de la clase: La lista de los libros que se tienen en la biblioteca, isbn de referencia.
     */
    public ListaLibros<String> lista;
    String refIsbn;

    /**
     * Bob el constructor de navegación: Construye un objeto de esta clase asignando los atributos de lista y
     * referencia isbn según los parámetros recibidos.
     * @param lista Objeto de la clase ListaLibros con los libros de la biblioteca.
     * @param refIsbn String que almacena el isbn del libro referencia
     */
    public Navegacion(ListaLibros<String> lista,String refIsbn ) {
        this.lista=lista;
        this.refIsbn=refIsbn;
    }
    /**
     * Método que crea un objeto de la clase Vedit que corresponde a una nueva ventana de edición, y la muestra.
     */
    public void abrirVedit(){
        Vedit ventana=new Vedit(refIsbn, lista);
        ventana.setVisible(true);
    }
    /**
     * Método que crea un objeto de la clase Vprincipal que corresponde a una nueva ventana principal, y la muestra.
     */
    public void abrirVprincipal(){
        Vprincipal ventana=new Vprincipal(lista);
        ventana.setVisible(true);
    }
    /**
     * Método que crea un objeto de la clase Vadd que corresponde a una nueva ventana de adición, y la muestra.
     */
    public void abrirVadd(){
        VaddLibro ventana=new VaddLibro(lista);
        ventana.setVisible(true);
    }

}
