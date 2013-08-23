package co.edu.um.tallerProg.Vista;

import co.edu.um.tallerProg.Controlador.EditControl;
import co.edu.um.tallerProg.Controlador.Navegacion;
import co.edu.um.tallerProg.Modelo.ListaLibros;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Ventana de edición donde después de buscar un libro de la lista, se puede modificar su información, mostrando un
 * formulario con los atributos propios del libro.
 */
public class Vedit extends JFrame implements ActionListener{
    /*
     * Atributos de la clase ventana de edición de libro, donde están los elementos gráficos, la lista de los libros
     * y los datos de la referencia del libro sobre el cual se va a hacer la modificación.
     */
    String refIsbn;
    ListaLibros lista;
    JDesktopPane ImagenFondoVentana;
    JLabel tituloPag=new JLabel("Modificar libro");
    JLabel labelIsbn=new JLabel("Isbn:");
    JLabel labelTitulo=new JLabel("Título:");
    JLabel labelAutor=new JLabel("Autor:");
    JLabel labelFecha=new JLabel("Fecha de publicación");
    JTextField fieldIsbn=new JTextField();
    JTextField fieldTitulo=new JTextField();
    JTextField fieldAutor=new JTextField();
    JTextField fieldFecha=new JTextField();
    JButton aceptarButton;
    JButton cancelarButton;
    JLabel errorLabel=new JLabel("Por favor ingrese TODOS los datos");

    /**
     * Bob el constructor de ventana editar: Construye una ventana de edición donde puede modificar un libro de la lista.
     * @param refIsbn Variable de tipo String que corresponde al isbn del libro que se quiere modificar.
     * @param lista Objeto de la clase ListaLibros con la que se trabaja en la sesión.
     * @throws HeadlessException
     */
    public Vedit(String refIsbn, ListaLibros<String> lista) throws HeadlessException {
        //Inicialización de los atributos referencia Isbn y la lista que llegan de los parámetros.
        this.refIsbn=refIsbn;
        this.lista=lista;
        setSize(420,300);
        setLocation(300,300);

        /*
         * Fuentes de los JLabels donde:
         * h1: titulo grande principal.
         * tableContentFont: fuente del contenido de la tabla
         * h2: subtitulo
         * h3: texto
         */
        Font h1 = new Font("SANS_SERIF",Font.BOLD,30);
        Font h2 = new Font("MONOSPACED",Font.ITALIC,20);
        Font h3= new Font("SANS",Font.PLAIN,15);

        /*
         * Imagen de fondo
         */
        ImagenFondoVentana= new DesktopConFondo();
        ((DesktopConFondo)ImagenFondoVentana).setImagen("/images/container.jpg");
        setContentPane(ImagenFondoVentana);

        /*
         * Iconos para los botones
         */
        Icon iconoAceptar= new ImageIcon(getClass().getResource("/images/Aceptar2.png"));
        Icon iconoCancelar= new ImageIcon(getClass().getResource("/images/Cancelar.png"));

        aceptarButton=new JButton(iconoAceptar);
        cancelarButton=new JButton(iconoCancelar);

        /*
         * Asignación de las fuentes a los JLabel
         */
        tituloPag.setFont(h1);
        labelIsbn.setFont(h3);
        labelAutor.setFont(h3);
        labelTitulo.setFont(h3);
        labelFecha.setFont(h3);
        errorLabel.setFont(h2);


        /*
         * Asignación del color de fondo para los JTextField
         */
        fieldIsbn.setBackground(Color.BLACK);
        fieldTitulo.setBackground(Color.BLACK);
        fieldAutor.setBackground(Color.BLACK);
        fieldFecha.setBackground(Color.BLACK);

        /*
         * Asignación del color de letra para los JLabel y JTextField
         */
        tituloPag.setForeground(Color.WHITE);
        labelIsbn.setForeground(Color.WHITE);
        labelTitulo.setForeground(Color.WHITE);
        labelAutor.setForeground(Color.WHITE);
        labelFecha.setForeground(Color.WHITE);
        fieldIsbn.setForeground(Color.white);
        fieldTitulo.setForeground(Color.white);
        fieldAutor.setForeground(Color.white);
        fieldFecha.setForeground(Color.white);
        errorLabel.setForeground(Color.red);


        /*
         * Asignación de tamaños y posiciones en la ventana
         */
        tituloPag.setBounds(10,10,400,40);
        labelIsbn.setBounds(10,70,100,30);
        labelTitulo.setBounds(10,110,100,30);
        labelAutor.setBounds(10,150,100,30);
        labelFecha.setBounds(10, 190, 150, 30);
        fieldIsbn.setBounds(200,70,200,30);
        fieldTitulo.setBounds(200,110,200,30);
        fieldAutor.setBounds(200,150,200,30);
        fieldFecha.setBounds(200,190,200,30);
        aceptarButton.setBounds(200,240,60,30);
        cancelarButton.setBounds(260,240,60,30);
        errorLabel.setBounds(10,40,400,40);

        //Manejo de la visibilidad delmensaje de error
        errorLabel.setVisible(false);

        /*
         * Adición de los elementos a la ventana
         */
        add(tituloPag);
        add(labelIsbn);
        add(labelTitulo);
        add(labelAutor);
        add(labelFecha);
        add(fieldIsbn);
        add(fieldTitulo);
        add(fieldAutor);
        add(fieldFecha);
        add(aceptarButton);
        add(cancelarButton);
        add(errorLabel);

        /*
         * Adición de los ActionListener
         */
        aceptarButton.addActionListener(this);
        cancelarButton.addActionListener(this);
    }

    /**
     * Método que define la edición del libro a partir del botón acpetar y cancelar de la ventana. Este método valida
     * que el formulario esté bien diligenciado y conecta con el objeto del controlador para hacer la edición.
     * @param actionEvent evento proveniente del botón aceptar de la ventana.
     */
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource()==aceptarButton){
            String isbn, titulo, autor, fecha;
            isbn=fieldIsbn.getText();
            titulo=fieldTitulo.getText();
            autor=fieldAutor.getText();
            fecha=fieldFecha.getText();

            if (isbn.length()==0||titulo.length()==0||autor.length()==0||fecha.length()==0){
                errorLabel.setVisible(true);
            } else {

            EditControl editControl=new EditControl(lista,isbn,titulo,autor,fecha,refIsbn);
            editControl.edicionLibro();
            Navegacion navegacion=new Navegacion(lista,"");
            navegacion.abrirVprincipal();
            this.setVisible(false);
            }
        }


        if (actionEvent.getSource()==cancelarButton){

            this.setVisible(false);
        }
    }
}
