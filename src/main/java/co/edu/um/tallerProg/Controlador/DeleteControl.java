package co.edu.um.tallerProg.Controlador;

import co.edu.um.tallerProg.Modelo.ListaLibros;

/**
 * Clase del controlador que permite la eliminación de libros de la lista. Obtiene el isbn referencia del libro a
 * eliminar e invoca el método de la clase ListaLibros para la eliminación de dicho libro.
 */
public class DeleteControl {
    /**
     * Atributos: lista de ListaLibros donde se almacenan los libros de la biblioteca, String con el isbn del libro
     * a eliminar.
     */
    ListaLibros lista=new ListaLibros();
    String refIsbn;

    /**
     * Bob el constructor de controlador de eliminación: Construye un objeto de esta clase inicializando los atributos
     * según los parámetros dados.
     * @param lista Objeto de la clase ListaLibros con los libros de la biblioteca.
     * @param refIsbn String con el isbn del libro a eliminar.
     */
    public DeleteControl(ListaLibros lista, String refIsbn) {
        this.lista = lista;
        this.refIsbn = refIsbn;
    }

    /**
     * Método que se encarga de invocar la función eliminar() del objeto lista. Así se elimina el libro dado de la lista.
     */
    public void eliminar(){
        lista.eliminar(refIsbn);
    }
}
