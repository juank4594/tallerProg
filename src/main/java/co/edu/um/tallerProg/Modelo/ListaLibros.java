package co.edu.um.tallerProg.Modelo;

/**
 * Clase Lista donde se almacena la totalidad de los libros de la biblioteca, enlazados según determinado órden.
 * @param <E> De tipo genérico.
 */
public class ListaLibros<E> {
    /*
     * Atributo de tipo Libro que representa el primer nodo de la lista.
     */
    public Libro<E> primero;
    /*
     * Atributo de tipo entero contador, que almacena la totalidad de los libros en la lista.
     */
    public int totalLibros;

    /**
     * Bob el constructor de listas: Construye una nueva lista que no necesita parámetros e inicializa los atributos
     * primero y totalLibros a null y 0 respectivamente.
     */
    public ListaLibros() {
        this.primero = null;
        this.totalLibros=0;
    }

    /**
     * Método que recorre la lista y retorna todos los datos de cada libro de la lista.
     * @return Variable de tipo String con todos los libros de la lista y sus respectivos datos.
     */
    public String toString(){
        String res = "";
        for (Libro<E> aux = primero; aux!=null;aux=aux.siguiente){
            res += aux.getIsbn().toString()+" "+aux.getAutor().toString()+" "+aux.getFecha().toString()+" "+ aux.getTitulo().toString()+" "+aux.getNumEjem()+"\n";
        }
        return res;
    }
    /**
     * Método que inserta un libro al inicio de la lista.
     * @param isbn Variable de tipo E(Genérico) con el isbn del libro a añadir.
     * @param titulo Variable de tipo E(Genérico) con el título del libro a añadir.
     * @param fecha Variable de tipo E(Genérico) con la fecha del libro a añadir.
     * @param autor Variable de tipo E(Genérico) con el autor del libro a añadir.
     */
    public void insertarInicio(E isbn, E titulo, E fecha, E autor){
        Libro<String> libro=consultar(isbn);
        if (libro==null){
        primero=new Libro<E>(isbn,titulo,fecha,autor,primero);
        primero.numEjem++;
        }else{
            libro.numEjem++;
        }

        this.totalLibros++;
    }
    /**
     * Método que inserta un libro al final de la lista.
     * @param isbn Variable de tipo E(Genérico) con el isbn del libro a añadir.
     * @param titulo Variable de tipo E(Genérico) con el título del libro a añadir.
     * @param fecha Variable de tipo E(Genérico) con la fecha del libro a añadir.
     * @param autor Variable de tipo E(Genérico) con el autor del libro a añadir.
     */
    public void insertarEnFin(E isbn, E titulo, E fecha, E autor){
        Libro<String> libro=consultar(isbn);
        if (libro==null){

            Libro<E> nl=new Libro<E>(isbn,titulo,fecha,autor);
            Libro<E> aux= primero;
            if (aux==null){
                primero=nl;
                primero.numEjem++;
            }
            else {
                while (aux.siguiente!=null) aux=aux.siguiente;
                nl.numEjem++;
                aux.siguiente=nl;

            }
        }else{
            libro.numEjem++;
        }

        this.totalLibros++;

    }
    /**
     * Método que inserta un libro después de un libro de la lista.
     * @param isbn Variable de tipo E(Genérico) con el isbn del libro a añadir.
     * @param titulo Variable de tipo E(Genérico) con el título del libro a añadir.
     * @param fecha Variable de tipo E(Genérico) con la fecha del libro a añadir.
     * @param autor Variable de tipo E(Genérico) con el autor del libro a añadir.
     * @param refIsbn Variable de tipo E(Genérico) con el isbn del libro referencia.
     * @return boolean que define el exito de la operación.
     */
    public boolean insertarDespues(E isbn, E titulo, E fecha, E autor,E refIsbn){
        Libro<String> libro=consultar(isbn);
        if (libro==null){
            Libro<E> aux=primero;
            Libro<E> nuevo= new Libro<E>(isbn,titulo,fecha,autor);
            nuevo.numEjem++;
            while (aux!=null && !aux.getIsbn().equals(refIsbn)){
                aux=aux.siguiente;
            }
            if (aux!=null){
                nuevo.siguiente=aux.siguiente;
                aux.siguiente=nuevo;
                this.totalLibros++;
                return true;
            } else return false;
        }else{
            libro.numEjem++;
            this.totalLibros++;
            return true;
        }
    }
    /**
     * Método que inserta un libro antes de un libro de la lista.
     * @param isbn Variable de tipo E(Genérico) con el isbn del libro a añadir.
     * @param titulo Variable de tipo E(Genérico) con el título del libro a añadir.
     * @param fecha Variable de tipo E(Genérico) con la fecha del libro a añadir.
     * @param autor Variable de tipo E(Genérico) con el autor del libro a añadir.
     * @param refIsbn Variable de tipo E(Genérico) con el isbn del libro referencia.
     * @return boolean que define el exito de la operación.
     */
    public boolean insertarAntes(E isbn, E titulo, E fecha, E autor,E refIsbn){
        Libro<String> libro=consultar(isbn);
        if (libro==null){

            Libro<E> aux=primero;

            while (aux!=null && !aux.getIsbn().equals(refIsbn)){
                aux=aux.siguiente;
            }

            if (aux!=null){

                E tempIsbn= aux.getIsbn();
                E tempTitulo= aux.getTitulo();
                E temFecha= aux.getFecha();
                E tmpAutor= aux.getAutor();

                aux.setIsbn(isbn);
                aux.setTitulo(titulo);
                aux.setFecha(fecha);
                aux.setAutor(autor);

                insertarDespues(tempIsbn,tempTitulo,temFecha,tmpAutor,isbn);

                return true;
            } else return false;
        }else{
            libro.numEjem++;
            this.totalLibros++;
            return true;
        }
    }
    /**
     * Método que permite eliminar un Libro de la lista.
     * @param refIsbn Variable de tipo E(Genérico) que representa el isbn del libro a eliminar.
     * @return boolean que determina el éxito de la operación.
     */
    public boolean eliminar(E refIsbn){

            Libro<E> aux=primero, ant = null;
            while (aux!=null && !aux.getIsbn().equals(refIsbn)){
                ant=aux;
                aux=aux.siguiente;
            }



            if (aux!=null){
                if (aux.numEjem!=1){
                    aux.numEjem--;
                    return true;
                }  else {
                    this.totalLibros--;
                    if (ant==null) primero=aux.siguiente;
                    else ant.siguiente=aux.siguiente;
                    return true;
                }

            }
            return false;

    }
    /**
     * Método que busca un determinado libro en la lista.
     * @param refIsbn variable de tipo E(Genérico) que representa el isbn del libro a buscar.
     * @return un objeto de tipo Libro correspondiente a la búsqueda. Si es null, el libro no se encontró.
     */
    public Libro consultar(E refIsbn){
        Libro<E> aux=primero;
        while (aux!=null && !aux.getIsbn().equals(refIsbn)){
            aux=aux.siguiente;
        }
        return aux;
    }
    /**
     * Método que permite editar la información propia de un libro de la lista.
     * @param isbn Variable de tipo E(Genérico) con el nuevo isbn del libro a editar.
     * @param titulo Variable de tipo E(Genérico) con el nuevo título del libro a editar.
     * @param fecha Variable de tipo E(Genérico) con la nueva fecha del libro a editar.
     * @param autor Variable de tipo E(Genérico) con el nuevo autor del libro a editar.
     * @param refIsbn Variable de tipo E(Genérico) con el isbn del libro editar.
     */
    public void editar(E isbn, E titulo, E fecha, E autor, E refIsbn){
        Libro<E> aux=primero;
        while (aux!=null && !aux.getIsbn().equals(refIsbn)){
            aux=aux.siguiente;
        }
        aux.setIsbn(isbn);
        aux.setTitulo(titulo);
        aux.setAutor(autor);
        aux.setFecha(fecha);
    }



}
