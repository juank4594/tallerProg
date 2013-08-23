package co.edu.um.tallerProg.Vista;

import co.edu.um.tallerProg.Controlador.AddControl;
import co.edu.um.tallerProg.Controlador.Navegacion;
import co.edu.um.tallerProg.Modelo.ListaLibros;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.zip.DataFormatException;

/**
 * Clase ventana que permite adicionar nuevos libros a la lista de los libros de la biblioteca. Muestra 4 opciones que
 * le permiten al usuario determinar la posición en que desea adicionar el libro dentro de la lista.
 */
public class VaddLibro extends JFrame implements ActionListener, ItemListener {

    /*
     * Atributos de la clase ventana adicionar que incluyen elementos gráficos, la lista de libros y los objetos del
     * controlador pertinentes.
     */
    ListaLibros lista;
    AddControl addControl;

    JDesktopPane ImagenFondoVentana;
    JLabel tituloPag=new JLabel("Añadir libro");
    JLabel labelIsbn=new JLabel("Isbn:");
    JLabel labelTitulo=new JLabel("Título:");
    JLabel labelAutor=new JLabel("Autor:");
    JLabel labelFecha=new JLabel("Fecha de publicación");
    JLabel labelRefIsbn=new JLabel("Referencia isbn");
    JLabel labelTipoAdd=new JLabel("Añadir libro en:");

    JTextField fieldIsbn=new JTextField();
    JTextField fieldTitulo=new JTextField();
    JTextField fieldAutor=new JTextField();
    JTextField fieldFecha=new JTextField();
    JComboBox fieldRefIsbn=new JComboBox();

    JButton aceptarButton;
    JButton cancelarButton;
    JComboBox tipoAdd=new JComboBox();
    JLabel errorLabel=new JLabel("Por favor ingrese TODOS los datos");

    /**
     * Bob el constructor de Ventana añadir: Construye una ventana para adicionar un nuevo libro.
     * @param lista Objeto de la clase ListaLibros donde están almacenados todos los libros de la bibliotca.
     * @throws HeadlessException
     */
    public VaddLibro(ListaLibros<String> lista) throws HeadlessException {

        //Asignación al atributo lista, la lista que pido como parámtero.
        this.lista=lista;

        //Asignación del tamaño y ubicación de la ventana
        setSize(650,355);
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
        labelRefIsbn.setFont(h3);
        labelTipoAdd.setFont(h3);
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
        labelRefIsbn.setForeground(Color.WHITE);
        labelTipoAdd.setForeground(Color.WHITE);
        fieldIsbn.setForeground(Color.white);
        fieldTitulo.setForeground(Color.white);
        fieldAutor.setForeground(Color.white);
        fieldFecha.setForeground(Color.white);
        fieldRefIsbn.setForeground(Color.BLACK);
        errorLabel.setForeground(Color.red);

        /*
         * Definicion del JComboBox
         */
        tipoAdd.addItem("Inicio");
        tipoAdd.addItem("Final");
        tipoAdd.addItem("Después de");
        tipoAdd.addItem("Antes de");

        addControl=new AddControl(lista);
        String isbnControl[]=addControl.llenarCombo();
        int i=0;
        while (i<lista.totalLibros){
            fieldRefIsbn.addItem(isbnControl[i]);
            i++;
        }


        /*
         * Asignación de tamaños y posiciones en la ventana
         */
        tituloPag.setBounds(10,10,400,40);
        labelIsbn.setBounds(10,120,100,30);
        labelTitulo.setBounds(10,160,100,30);
        labelAutor.setBounds(10,200,100,30);
        labelFecha.setBounds(10, 240, 150, 30);
        fieldIsbn.setBounds(200,120,130,30);
        fieldTitulo.setBounds(200,160,130,30);
        fieldAutor.setBounds(200,200,130,30);
        fieldFecha.setBounds(200,240,130,30);
        aceptarButton.setBounds(480,290,60,30);
        cancelarButton.setBounds(540,290,60,30);
        labelTipoAdd.setBounds(10,80,200,30);
        tipoAdd.setBounds(200,80,130,30);
        fieldRefIsbn.setBounds(490,80,120,30);
        labelRefIsbn.setBounds(360,80,200,30);
        errorLabel.setBounds(240,10,400,40);

         //Manejo de la visibilidad de los elementos
        labelRefIsbn.setVisible(false);
        fieldRefIsbn.setVisible(false);
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
        add(tipoAdd);
        add(labelTipoAdd);
        add(fieldRefIsbn);
        add(labelRefIsbn);
        add(errorLabel);

        /*
         * Adición de los ActionListener
         */
        aceptarButton.addActionListener(this);
        cancelarButton.addActionListener(this);
        tipoAdd.addItemListener(this);
    }

    /**
     * Método que permite manejar los eventos según los botones de la ventana. Define la adición de libros según la
     * elección del JComboBox.
     * @param actionEvent evento proveniente de los botones de la ventana.
     */
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource()==aceptarButton){

                String isbn,titulo,autor,fecha,refIsbn,tipoInsert;
                isbn=fieldIsbn.getText();
                titulo=fieldTitulo.getText();
                autor=fieldAutor.getText();
                fecha=fieldFecha.getText();
                refIsbn=String.valueOf(fieldRefIsbn.getSelectedItem());
                tipoInsert=String.valueOf(tipoAdd.getSelectedItem());

            if (isbn.length()==0||titulo.length()==0||autor.length()==0||fecha.length()==0){
                errorLabel.setVisible(true);
            } else {
                addControl.addLibro(isbn,titulo,autor,fecha,tipoInsert,refIsbn);
                Navegacion navegacion=new Navegacion(lista,"");
                navegacion.abrirVprincipal();
                this.setVisible(false);
            }
        }
        if (actionEvent.getSource()==cancelarButton){
            this.setVisible(false);
        }
    }

    /**
     * Método que permite controlar las acciones derivadas del JComboBox donde se selecciona el tipo de adición.
     * Aquí se muestran ciertos elementos según la elección del usuario.
     * @param itemEvent
     */
    @Override
    public void itemStateChanged(ItemEvent itemEvent) {
        if (itemEvent.getSource()==tipoAdd){
            String valorCombo=String.valueOf(tipoAdd.getSelectedItem());
            if (valorCombo=="Después de" || valorCombo=="Antes de"){

                labelRefIsbn.setVisible(true);
                fieldRefIsbn.setVisible(true);

            }else {
                labelRefIsbn.setVisible(false);
                fieldRefIsbn.setVisible(false);
            }
        }
    }
}
