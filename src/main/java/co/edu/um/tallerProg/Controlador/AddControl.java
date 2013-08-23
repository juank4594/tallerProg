package co.edu.um.tallerProg.Controlador;

import co.edu.um.tallerProg.Modelo.*;

/**
 * Clase del controlador que permite la adición de libros a la lista. Se encarga de conectar la información obtenida en
 * la vista e invocar los métodos en el modelo para añadir el nuevo libro.
 */
public class AddControl {
    /**
     * Atributos: Objeto de la clase ListaLibros.
     */
    ListaLibros lista;

    /**
     * Bob el constructor de controlador de adición: Construye un objeto de esta clase asignándole al atributo lista
     * la lista que llega del parámetro.
     * @param lista Objeto de la clase ListaLibros con los libros de la biblioteca.
     */
    public AddControl(ListaLibros lista) {
        this.lista = lista;
    }

    /**
     * Método que permite adicionar un libro con la información introducida en los parámetros, en la posición según lo
     * designado por el usuario en la vista. Se invocan distintos métodos de la clase ListaLibros de acuerdo
     * con el tipo de adición del libro.
     * @param isbn String con el isbn del libro a añadir
     * @param titulo String con el título del libro a añadir
     * @param autor String con el autor del libro a añadir
     * @param fecha String con la fecha del libro a añadir
     * @param tipoAdd String con el tipo de adición (final, inicio, antes de, o después de)
     * @param refIsbn String con el isbn de referencia para los métodos que lo necesiten
     */
    public void addLibro(String isbn, String titulo, String autor, String fecha, String tipoAdd, String refIsbn){

        if (tipoAdd=="Inicio"){
            lista.insertarInicio(isbn,titulo,fecha,autor);
        }
        if (tipoAdd=="Final"){
            lista.insertarEnFin(isbn,titulo,fecha,autor);
        }
        if (tipoAdd=="Después de"){
            lista.insertarDespues(isbn,titulo,fecha,autor,refIsbn);
        }
        if (tipoAdd=="Antes de"){
            lista.insertarAntes(isbn,titulo,fecha,autor,refIsbn);
        }

    }

    /**
     * Método que retorna al JComboBox de la ventana Vadd los ítems que este debe tener. Esto se hace porque el usuario
     * sólo puede seleccionar un isbn de referencia según los isbn existentes.
     * @return Vector String con los isbn de todos los libros que están en la lista.
     */
    public String[] llenarCombo(){
        Libro aux = lista.primero;
        String datos[]=new String[lista.totalLibros];
        int i=0;
        while (aux!=null){
            datos[i]=String.valueOf(aux.getIsbn());
            i++;
            aux=aux.siguiente;
        }
        return datos;
    }
}
