package co.edu.um.tallerProg.Modelo;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: jucagut94
 * Date: 16/08/13
 * Time: 8:34
 * To change this template use File | Settings | File Templates.
 */
public class DataBaseTest {
    /*@Test
    public void testSacarDB() throws Exception {
     DataBase db=new DataBase();
        System.out.println("Prueba base de datos  .." + db.sacarDB().toString());
    }
    @Test
    public void testInsertarDB() throws Exception {
        DataBase db=new DataBase();
        ListaLibros<String> lista=new ListaLibros();
        lista.insertarEnFin("232-w","Pompy viaja a la ciudad", "23/3/13","Moñobanana");
        lista.insertarEnFin("234-w","Pompy muere en la ciudad", "25/3/13","Moñobanana");
        lista.insertarDespues("334-t","Pompy deja caer su pc", "31/12/13","Alberto", "232-w");
        Assert.assertNotNull(lista);
        Assert.assertNotNull(db);
        db.insertarDB(lista);
        System.out.println("Prueba base de datos despues de llenar  .."+db.sacarDB().toString());
    }   */
    @Test
    public void testEliminarDB() throws Exception {
        DataBase db=new DataBase();
        db.eliminarDB();
        System.out.println("Prueba base de datos despues de eliminar  .."+db.sacarDB().toString());
    }
    /*
    @Test
    public void testEditarDB() throws Exception {
        DataBase db=new DataBase();
        db.editarDB("654-q","ola k dice","Godzila","11/11/11","987-q");
        System.out.println("Prueba base de datos despues de editar  .."+db.sacarDB().toString());
    }  */
}
