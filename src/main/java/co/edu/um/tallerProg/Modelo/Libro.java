
package co.edu.um.tallerProg.Modelo;

/**
 * La clase libro almacena la información de un libro de la biblioteca.
 * @param <E> Dato genérico que representa el tipo de dato de la información de los atributos del libro.
 */
public class Libro<E> {
    /*
     * Atributos de la clase libro, cada uno almacena información específica de un libro.
     */
    private E isbn;
    private E titulo;
    private E fecha;
    private E autor;
    /*
     * Atributo de tipo libro que representa el enlace referencia hacia otro libro.
     */
    public Libro<E> siguiente;
    /*
     * Atributo entero que se usa como contador, el cual almacena el número de existencias del mismo libro en la
     * biblioteca
     */
    public int numEjem;

    /**
     * Método que retorna el Isbn de un libro de un biblioteca
     * @return el valor de tipo E(Genérico) del atributo isbn.
     */
    public E getIsbn() {
        return isbn;
    }
    /**
     * Asigna un valor  al atributo isbn.
     * @param isbn valor de tipo E(Genérico).
     */
    public void setIsbn(E isbn) {
        this.isbn = isbn;
    }
    /**
     * Método que retorna el Título de un libro de un biblioteca
     * @return el valor de tipo E(Genérico) del atributo título.
     */
    public E getTitulo() {
        return titulo;
    }
    /**
     * Asigna un valor  al atributo titulo.
     * @param titulo valor de tipo E(Genérico).
     */
    public void setTitulo(E titulo) {
        this.titulo = titulo;
    }
    /**
     * Método que retorna el Fecha de un libro de un biblioteca
     * @return el valor de tipo E(Genérico) del atributo fecha.
     */
    public E getFecha() {
        return fecha;
    }
    /**
     * Asigna un valor  al atributo fecha.
     * @param fecha valor de tipo E(Genérico).
     */
    public void setFecha(E fecha) {
        this.fecha = fecha;
    }
    /**
     * Método que retorna el Autor de un libro de un biblioteca
     * @return el valor de tipo E(Genérico) del atributo autor.
     */
    public E getAutor() {
        return autor;
    }
    /**
     * Asigna un valor  al atributo autor.
     * @param autor valor de tipo E(Genérico).
     */
    public void setAutor(E autor) {
        this.autor = autor;
    }
    /**
     * Método que retorna el Isbn de un libro de un biblioteca
     * @return el valor de tipo E(Genérico) del atributo isbn.
     */
    public int getNumEjem() {
        return numEjem;
    }


    /**
     * Bob el Constructor de Libros: Bob construye un libro sólo con los datos del libro, sin especificar el libro
     * referencia al siguiente.
     * @param isbn atributo isbn del libro de tipo E(Genérico).
     * @param titulo atributo título del libro de tipo E(Genérico).
     * @param fecha atributo fecha del libro de tipo E(Genérico).
     * @param autor atributo autor del libro de tipo E(Genérico).
     */
    public Libro(E isbn, E titulo, E fecha, E autor) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.fecha = fecha;
        this.autor = autor;
        this.numEjem = numEjem;
    }

    /**
     * Bob el constructor de libros con siguiente: Bob construye el libro con la información y con la referencia del
     * libro siguiente.
     * @param isbn atributo isbn del libro de tipo E(Genérico).
     * @param titulo atributo título del libro de tipo E(Genérico).
     * @param fecha atributo fecha del libro de tipo E(Genérico).
     * @param autor atributo autor del libro de tipo E(Genérico).
     * @param siguiente atributo referencia al libro siguiente, de tipo Libro.
     */
    public Libro(E isbn, E titulo, E fecha, E autor, Libro<E> siguiente) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.fecha = fecha;
        this.autor = autor;
        this.numEjem = numEjem;
        this.siguiente = siguiente;
    }
}
