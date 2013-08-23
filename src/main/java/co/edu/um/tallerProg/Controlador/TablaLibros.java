package co.edu.um.tallerProg.Controlador;

import co.edu.um.tallerProg.Modelo.Libro;
import co.edu.um.tallerProg.Modelo.ListaLibros;

/**
 * Clase del controlador que permite la comunicación entre la ventana principal y la clase ListaLibros. Esta clase
 * permite específicamente obtener los datos de todos los libros contenidos en la lista y retornar una matriz de
 * String con toda la información. De esta manera se puede llenar la tabla de la ventana principal.
 */
public class TablaLibros {
    //Variable que cuenta el número de filas de la matriz.
    public int numRows;

    //Atributo donde se almacena la lista de libros de la biblioteca
    ListaLibros<String> lista;

    /**
     * Bob el constructor de tablas: Construye un objeto a partir del parámetro correspondiente a la lista e inicia el
     * contador de filas a 0.
     * @param lista Objeto de la clase ListaLibros que contiene todos los libros de la biblioteca.
     */
    public TablaLibros(ListaLibros<String> lista) {
        numRows=0;
        this.lista=lista;
    }

    /**
     * Método que obtiene todos los datos cada Libro de la Lista y los almacena en una matriz de String, donde cada
     * fila es un libro diferente y cada columna es uno de los 5 atributos del libro.
     * @return Matriz de String.
     */
    public String[][] llenarMatrizTabla(){
        String rows[][]=new String[numRows][5];
        Libro<String> aux;
        int i=0;
        aux=lista.primero;
        while (aux!=null){
            rows[i][0]=aux.getIsbn();
            rows[i][1]=aux.getTitulo();
            rows[i][2]=aux.getAutor();
            rows[i][3]=aux.getFecha();
            rows[i][4]=String.valueOf(aux.numEjem);
            aux=aux.siguiente;
            i++;
        }
        return rows;
    }

    /**
     * Condicional que verifica si el numero total de libros es 0
     */
    public void verificarNumTotalLibros(){
        if(lista.totalLibros==0) numRows=1;
        else numRows=lista.totalLibros;
    }

}
