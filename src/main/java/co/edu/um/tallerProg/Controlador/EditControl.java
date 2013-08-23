package co.edu.um.tallerProg.Controlador;

import co.edu.um.tallerProg.Modelo.ListaLibros;

/**
 * Esta clase corresponde al controlador para la edición de los libros en la lista. Se encarga de invocar el método
 * de edición propio de ListaLibros.
 */
public class EditControl {
    /**
     * Atributos: lista de la clase ListaLibros donde se almacenan los libros de la biblioteca y las variables String
     * con el isbn del libro a editar y los nuevos datos ya editados.
     */
    ListaLibros<String> lista;
    String eIsbn, eTitulo, eAutor, eFecha, refIsbn;

    /**
     * Bob el constructor de controlador de edición: Construye un objeto de esta clase asignándole a los atributos
     * los datos provenientes de los parámetros.
     * @param lista Objeto de la clase ListaLibros con los libros de la biblioteca.
     * @param eIsbn String con el isbn ya editado
     * @param eTitulo String con el título ya editado
     * @param eAutor String con el autor ya editado
     * @param eFecha String con la fecha ya editada
     * @param refIsbn String con el isbn del libro a editar
     */
    public EditControl(ListaLibros<String> lista, String eIsbn, String eTitulo, String eAutor, String eFecha,String refIsbn) {
        this.lista = lista;
        this.eIsbn = eIsbn;
        this.eTitulo = eTitulo;
        this.eAutor = eAutor;
        this.eFecha = eFecha;
        this.refIsbn=refIsbn;
    }

    /**
     * Método que invoca el método de edición de la clase lista, pasándo como parámtros los atributos de esta clase.
     */
    public void edicionLibro(){
        lista.editar(eIsbn,eTitulo,eFecha,eAutor,refIsbn);
    }
}
