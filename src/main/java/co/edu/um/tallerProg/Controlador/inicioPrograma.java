package co.edu.um.tallerProg.Controlador;

import co.edu.um.tallerProg.Modelo.DataBase;
import co.edu.um.tallerProg.Modelo.ListaLibros;
import co.edu.um.tallerProg.Vista.Vprincipal;

/**
 * Esta clase del controlador permite iniciar todos los procesos del programa.
 */
public class inicioPrograma {
    /**
     * Función Main del programa donde se crea un objeto de la clase ListaLibros para que sea la lista de los libros
     * dela biblioteca durante el programa. Esta lista se llena a partir de la información que hay en la base de datos
     * gracias al objeto de la clase DataBase, invocando el metodo sacarDB().
     * @param args
     */
    public static void main(String[] args) {
        DataBase db = new DataBase();
        ListaLibros<String> lista=db.sacarDB();

        Vprincipal a=new Vprincipal(lista);
        a.setVisible(true);
    }
}
