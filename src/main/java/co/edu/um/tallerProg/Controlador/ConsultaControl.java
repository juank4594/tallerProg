package co.edu.um.tallerProg.Controlador;

import co.edu.um.tallerProg.Modelo.Libro;
import co.edu.um.tallerProg.Modelo.ListaLibros;

/**
 * Clase del controlador que permite la realización de consultas.
 */
public class ConsultaControl {
    /**
     * Atributos: Objeto de la clase ListaLibros, variable String con el valor de la búsqueda, vector String con los
     * atributos del libro buscado.
     */
    ListaLibros<String> lista=new ListaLibros<String>();
    String valorBusqueda;
    String[] atributosBuscados=new String[5];

    /**
     * Bob el constructor de controlador de consulta: Construye un objeto de esta clase asignando a los atributos los
     * parámetro que se pasan.
     * @param lista Objeto de la clase ListaLibros con los libros de la biblioteca
     * @param valorBusqueda String con el valor del isbn del libro que se está buscando.
     */
    public ConsultaControl(ListaLibros<String> lista, String valorBusqueda) {
        this.lista=lista;
        this.valorBusqueda=valorBusqueda;
    }

    /**
     * Método que se encarga de obtener los datos del libro buscado en la lista y retornarlos en un vector de String.
     * @return vector String con los atributos del libro buscado.
     */
    public String[] obtenerDatosConsulta(){
        Libro<String> libroBuscado=lista.consultar(valorBusqueda);

        if (libroBuscado!=null){
            atributosBuscados[0]=libroBuscado.getIsbn();
            atributosBuscados[1]=libroBuscado.getTitulo();
            atributosBuscados[2]=libroBuscado.getAutor();
            atributosBuscados[3]=libroBuscado.getFecha();
            atributosBuscados[4]=String.valueOf(libroBuscado.numEjem);
            return atributosBuscados;
        }else return null;
    }
}
