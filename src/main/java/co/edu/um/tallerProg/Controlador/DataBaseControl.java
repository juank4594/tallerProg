package co.edu.um.tallerProg.Controlador;

import co.edu.um.tallerProg.Modelo.DataBase;
import co.edu.um.tallerProg.Modelo.ListaLibros;

/**
 * Clase del controlador que permite hacer las operaciones pertinentes con la base de datos y la vista.
 */
public class DataBaseControl {
    /**
     * Atributos: Objeto de la clase ListaLibros con los libros de la biblioteca
     *            Objeto de la clase DataBase que conecta con la base de datos.
     */
    ListaLibros<String> lista=new ListaLibros<String>();
    DataBase db=new DataBase();

    /**
     * Bob el constructor de controlador de base de datos: Construye un objeto de esta clas e asignando al atributo lista
     * el parámetro de clase ListaLibros.
     * @param lista Objeto de la clase ListaLibros que contiene los libros de la biblioteca.
     */
    public DataBaseControl(ListaLibros<String> lista) {
        this.lista = lista;
    }

    /**
     * Método que se encarga primero de limpiar la base de datos, y luego ingresa los datos de la lista de los libros
     * después de la sesión. Este proceso se invoca siempre antes de cerrar el programa y se le atribuye a guardar los
     * cambios.
     */
    public void guardarEnDB(){
        db.eliminarDB();
        db.insertarDB(lista);
    }
}
