package co.edu.um.tallerProg.Modelo;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Clase Test que permite probar los métodos de la clase ListaLibros del Modelo
 */
public class ListaLibrosTest {
    /**
     * Prueba del método toString(), donde se crea un objeto de la clase ListaLibros<String> y se añaden 3 nodos a la
     * lista de tipo Libro<String> , se hace el Assert para comprobar que no sea nulo el objeto de tipo lista, y se
     * invoca el método a testear..
     * @throws Exception
     */
    @Test
    public void testToString() throws Exception {
        ListaLibros<String> lista=new ListaLibros<String>();
        lista.insertarInicio("232-w","Pompy viaja a la ciudad", "23/3/13","Moñobanana");
        lista.insertarInicio("234-w","Pompy muere en la ciudad", "25/3/13","Moñobanana");
        Assert.assertNotNull(lista);
        System.out.println(lista.toString());
    }
    /**
     * Prueba del método insertarInicio(), donde se crea un objeto de la clase ListaLibros<String> y se añaden 2 nodos a la
     * lista de tipo Libro<String> mediante el método a testear, se hace el Assert para comprobar que no sea nulo el
     * objeto de tipo lista, y se imprime la misma con el método toString().
     * @throws Exception
     */
    @Test
    public void testInsertarInicio() throws Exception {
        ListaLibros<String> lista=new ListaLibros<String>();
        lista.insertarInicio("232-w","Pompy viaja a la ciudad", "23/3/13","Moñobanana");
        lista.insertarInicio("234-w","Pompy muere en la ciudad", "25/3/13","Moñobanana");
       Assert.assertNotNull(lista);
        System.out.println(lista.toString());
    }
    /**
     * Prueba del método insertarFin(), donde se crea un objeto de la clase ListaLibros<String> y se añaden 2 nodos a la
     * lista de tipo Libro<String> mediante el método a testear, se hace el Assert para comprobar que no sea nulo el
     * objeto de tipo lista, y se imprime la misma con el método toString().
     * @throws Exception
     */
    @Test
    public void testInsertarEnFin() throws Exception {
         ListaLibros<String> lista=new ListaLibros<String>();
         lista.insertarEnFin("232-w","Pompy viaja a la ciudad", "23/3/13","Moñobanana");
         lista.insertarEnFin("234-w", "Pompy muere en la ciudad", "25/3/13", "Moñobanana");
         Assert.assertNotNull(lista);
         System.out.println(lista.toString());
    }
    /**
     * Prueba del método insertarDespues(), donde se crea un objeto de la clase ListaLibros<String> y se añaden 2 nodos a la
     * lista de tipo Libro<String>, posteriormente se añade un libro después de otro, mediante el método a testear,
     * se hace el Assert para comprobar que no sea nulo el objeto de tipo lista, y se imprime la misma con el método toString().
     * @throws Exception
     */
    @Test
    public void testInsertarDespues() throws Exception {
        ListaLibros<String> lista=new ListaLibros<String>();
        lista.insertarEnFin("232-w","Pompy viaja a la ciudad", "23/3/13","Moñobanana");
        lista.insertarEnFin("234-w","Pompy muere en la ciudad", "25/3/13","Moñobanana");
        lista.insertarDespues("334-t","Pompy deja caer su pc", "31/12/13","Alberto", "232-w");
        Assert.assertNotNull(lista);
        System.out.println(lista.toString());
    }
    /**
     * Prueba del método insertarAntes(), donde se crea un objeto de la clase ListaLibros<String> y se añaden 2 nodos a la
     * lista de tipo Libro<String>, posteriormente se añade un libro antes de otro, mediante el método a testear,
     * se hace el Assert para comprobar que no sea nulo el objeto de tipo lista, y se imprime la misma con el método toString().
     * @throws Exception
     */
    @Test
    public void testInsertarAntes() throws Exception {
        ListaLibros<String> lista=new ListaLibros<String>();
        lista.insertarInicio("232-w", "Pompy viaja a la ciudad", "23/3/13", "Moñobanana");
        lista.insertarInicio("234-w", "Pompy muere en la ciudad", "25/3/13", "Moñobanana");
        lista.insertarAntes("334-t", "Pompy deja caer su pc", "31/12/13", "Alberto", "232-w");
        Assert.assertNotNull(lista);
        System.out.println(lista.toString());
    }
    /**
     * Prueba del método eliminar(), donde se crea un objeto de la clase ListaLibros<String> y se añaden 3 nodos a la
     * lista de tipo Libro<String> , se elimina uno de los libros agregados mediante el método a testear, se hace el
     * Assert para comprobar que no sea nulo el objeto de tipo lista, y se imprime la misma con el método toString().
     * @throws Exception
     */
    @Test
    public void testEliminar() throws Exception {
        ListaLibros<String> lista=new ListaLibros<String>();
        lista.insertarInicio("232-w","Pompy viaja a la ciudad", "23/3/13","Moñobanana");
        lista.insertarInicio("234-w","Pompy muere en la ciudad", "25/3/13","Moñobanana");
        lista.insertarAntes("334-t", "Pompy deja caer su pc", "31/12/13", "Alberto", "232-w");
        lista.eliminar("334-t");
        Assert.assertNotNull(lista);
        System.out.println(lista.toString());
    }
    /**
     * Prueba del método consultar(), donde se crea un objeto de la clase ListaLibros<String> y se añaden 3 nodos a la
     * lista de tipo Libro<String> , se busca uno de los libros agregados mediante el método a testear, se hace el
     * Assert para comprobar que no sea nulo el objeto de tipo lista, y se imprimen los datos del libro consultado..
     * @throws Exception
     */
    @Test
    public void testConsultar() throws Exception {
        ListaLibros<String> lista=new ListaLibros<String>();
        lista.insertarInicio("232-w","Pompy viaja a la ciudad", "23/3/13","Moñobanana");
        lista.insertarInicio("234-w","Pompy muere en la ciudad", "25/3/13","Moñobanana");
        lista.insertarAntes("334-t","Pompy deja caer su pc", "31/12/13","Alberto", "232-w");
        Assert.assertNotNull(lista);
        System.out.println("El libro consultado es: "+lista.consultar("234-w").getTitulo());
    }
    /**
     * Prueba del método eliminar(), donde se crea un objeto de la clase ListaLibros<String> y se añaden 3 nodos a la
     * lista de tipo Libro<String> , se edita uno de los libros agregados mediante el método a testear, se hace el
     * Assert para comprobar que no sea nulo el objeto de tipo lista, y se imprime la misma con el método toString().
     * @throws Exception
     */
    @Test
    public void testEditar() throws Exception {
        ListaLibros<String> lista=new ListaLibros<String>();
        lista.insertarInicio("232-w","Pompy viaja a la ciudad", "23/3/13","Moñobanana");
        lista.insertarInicio("234-w", "Pompy muere en la ciudad", "25/3/13", "Moñobanana");
        lista.insertarAntes("334-t", "Pompy deja caer su pc", "31/12/13", "Alberto", "232-w");
        Assert.assertNotNull(lista);
        lista.editar("232-w","Pompy viaja al campo","2/3/13","Yo","232-w");
        System.out.println("La lista es: "+ lista.toString());
    }
}
