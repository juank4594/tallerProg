package co.edu.um.tallerProg.Vista;


import co.edu.um.tallerProg.Modelo.*;
import co.edu.um.tallerProg.Controlador.*;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;

/**
 * Clase Ventana Principal donde se muestra la lista de libros actual en la biblioteca, se muestran las opciones de
 * añadir un libro, y además el buscador de libros, que permite la posterior edición o eliminación del elemento buscado.
 */
public class Vprincipal extends JFrame implements ActionListener, KeyListener, WindowListener{
    /*
     * Atributos de la clase Vprincipal: elementos de interfaz gráfica.
     */
    ListaLibros<String> lista=new ListaLibros<String>();
    Navegacion navegacion;
    JLabel titulo=new JLabel("Página Principal");
    JLabel tituloListaLibros=new JLabel("Lista de libros");
    JTable table;
    JScrollPane tablePane;
    JTextField buscarField=new JTextField();
    JLabel buscarLabel= new JLabel("Buscar");
    JButton addButton;
    JLabel tituloInfoLibro=new JLabel("Información libro");
    JLabel labelIsbn=new JLabel("ISBN:");
    JLabel labelTitulo=new JLabel("Título:");
    JLabel labelAutor=new JLabel("Autor:");
    JLabel labelFecha=new JLabel("Fecha de publicación:");
    JLabel labelNumExistencias=new JLabel();
    JTextField fieldIsbn=new JTextField();
    JTextField fieldTitulo=new JTextField();
    JTextField fieldAutor=new JTextField();
    JTextField fieldFecha=new JTextField();
    JTextField fieldNumExistencias=new JTextField();
    JDesktopPane ImagenFondoVentana;
    JPanel consultaBox;
    JLabel labelError=new JLabel("El libro no se encontró");
    JButton editButton;
    JButton deleteButton;
    JLabel labelNumPorLibro=new JLabel("Existencias");


    /**
     * Bob el constructor de ventanas: Construye la ventana principal, inicializando todos los elementos gráficos y los
     * objetos del controlador correspondiente.
     * @param lista Objeto de la clase ListaLibros donde se almacena la lista de los libros de la biblioteca.
     * @throws HeadlessException
     */
    public Vprincipal(ListaLibros<String> lista) throws HeadlessException {
        //Asignación del atributo lista
        this.lista=lista;

        //Caracteristicas de tamaño y distribución de la ventana
        setSize(1280,700);
        setLayout(null);

        /*
         * Imagen de fondo
         */
        ImagenFondoVentana= new DesktopConFondo();
        ((DesktopConFondo)ImagenFondoVentana).setImagen("/images/background.jpg");
        setContentPane(ImagenFondoVentana);

        /*
         * Iconos para los botones
         */
        Icon iconoBuscar= new ImageIcon(getClass().getResource("/images/adicionar.png"));
        Icon iconoModificar= new ImageIcon(getClass().getResource("/images/Modificar.png"));
        Icon iconoEliminar=new ImageIcon(getClass().getResource("/images/Borrar2.png"));
        Icon iconoDialog=new ImageIcon(getClass().getResource("/images/AcercaDE.png"));

        addButton=new JButton(iconoBuscar);
        editButton=new JButton(iconoModificar);
        deleteButton=new JButton(iconoEliminar);

        /*
         * Fuentes de los JLabels donde:
         * h1: titulo grande principal.
         * tableContentFont: fuente del contenido de la tabla
         * h2: subtitulo
         * h3: texto
         */
        Font h1 = new Font("SANS_SERIF",Font.BOLD,30);
        Font tableContentFont= new Font("SANS_SERIF", Font.CENTER_BASELINE,12);
        Font h2 = new Font("MONOSPACED",Font.ITALIC,20);
        Font h3= new Font("SANS",Font.PLAIN,15);

        //Asignación del texto del numero de libros totales.
        labelNumExistencias.setText("Número total de libros:  "+lista.totalLibros);

        /*
         * Definicion de la tabla y del scrollPane de la tabla
         */
        TablaLibros tablaLibros=new TablaLibros(lista);
        tablaLibros.verificarNumTotalLibros();
        String columnas[]={"ISBN","Título","Autor","Fecha de publicación","Ejemplares"};
        String rows[][]= tablaLibros.llenarMatrizTabla();
        DefaultTableModel model = new DefaultTableModel(rows,columnas);
        table = new JTable(model);
        tablePane= new JScrollPane(table);
        Dimension dim = new Dimension(20,1);
        table.setIntercellSpacing(new Dimension(dim));
        SetRowHight(table);
        table.setColumnSelectionAllowed(true);
        JTableHeader header = table.getTableHeader();
        header.setBackground(Color.yellow);
        table.setEnabled(false);
        table.setShowGrid(true);
        table.setShowVerticalLines(true);
        table.setBackground(Color.BLACK);
        table.setForeground(Color.white);
        table.setFont(tableContentFont);

         //Definición del panel de consulta
        consultaBox=new JPanel(new GridLayout(0,2));

        /*
         * posición
         */
        titulo.setBounds(10,10,400,40);
        tablePane.setBounds(10,100,900,300);
        tituloListaLibros.setBounds(10,60,200,30);
        buscarLabel.setBounds(970,100,80,30);
        buscarField.setBounds(1050,100,200,30);
        addButton.setBounds(860,400,50,50);
        tituloInfoLibro.setBounds(970,180,250,30);
        consultaBox.setBounds(940,230,300,150);
        labelError.setBounds(940,230,300,150);
        editButton.setBounds(1145,380,50,50);
        deleteButton.setBounds(1193,380,50,50);
        labelNumExistencias.setBounds(10,400,300,40);


        /*
         * Asignación de colores a los elementos
         */
        titulo.setForeground(Color.black);
        tituloListaLibros.setForeground(Color.BLACK);
        buscarLabel.setForeground(Color.black);
        buscarField.setForeground(Color.white);
        buscarField.setBackground(Color.black);
        labelError.setForeground(Color.RED);
        labelNumExistencias.setForeground(Color.BLACK);

        /*
         * Se agrgan las fuentes a los componentes
         */
        titulo.setFont(h1);
        tituloListaLibros.setFont(h2);
        tituloInfoLibro.setFont(h2);
        labelIsbn.setFont(h3);
        labelTitulo.setFont(h3);
        labelError.setFont(h2);
        labelError.setFont(h2);


        /*
         * Se añaden los componentes al panel de consulta.
         */
        consultaBox.add(labelIsbn);
        consultaBox.add(fieldIsbn);
        consultaBox.add(labelTitulo);
        consultaBox.add(fieldTitulo);
        consultaBox.add(labelAutor);
        consultaBox.add(fieldAutor);
        consultaBox.add(labelFecha);
        consultaBox.add(fieldFecha);
        consultaBox.add(labelNumPorLibro);
        consultaBox.add(fieldNumExistencias);

        //Propiedad de edición deshabilitada para los campos del panel de consulta
        fieldIsbn.setEditable(false);
        fieldTitulo.setEditable(false);
        fieldAutor.setEditable(false);
        fieldFecha.setEditable(false);
        fieldNumExistencias.setEditable(false);

        //Manejo de la visibilidad de los elementos
        tituloInfoLibro.setVisible(false);
        consultaBox.setVisible(false);
        labelError.setVisible(false);
        editButton.setVisible(false);
        deleteButton.setVisible(false);

        //Adición de los Listener
        buscarField.addKeyListener(this);
        addKeyListener(this);
        editButton.addActionListener(this);
        addButton.addActionListener(this);
        deleteButton.addActionListener(this);
        addWindowListener(this);

        //Adición de los elementos a la ventana
        add(titulo);
        add(tituloListaLibros);
        add(tablePane);
        add(buscarLabel);
        add(buscarField);
        add(addButton);
        add(tituloInfoLibro);
        add(consultaBox);
        add(labelError);
        add(editButton);
        add(deleteButton);
        add(labelNumExistencias);

    }

    /**
     * Método que permite actualizar los datos de la ventana principal.
     */
    public void refresh(){
        Vprincipal newV=new Vprincipal(lista);
        newV.setVisible(true);
        this.setVisible(false);
    }
    /**
     * Método que asigna las dimensiones de las filas en la tabla donde se muestra la lista de los libros.
     * @param table elemento JTable donde se muestran los libros de la lista.
     */
    public void SetRowHight(JTable table){
        int height = table.getRowHeight();
        table.setRowHeight(height+10);
    }
    /**
     * Método que define la serie de eventos por botones en la ventana. Se encuentran las condiciones del boton editar,
     * adicionar y eliminar; con la creación de los objetos del controlador pertinentes y lacaptura de datos desde los
     * elementos de la página.
     * @param actionEvent
     */
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource()==editButton){
            String refIsbn= fieldIsbn.getText();
            navegacion=new Navegacion(lista,refIsbn);
            navegacion.abrirVedit();

        }
        if (actionEvent.getSource()==addButton){
            navegacion=new Navegacion(lista,"");
            navegacion.abrirVadd();
        }
        if (actionEvent.getSource()==deleteButton){
            Icon iconoDialog=new ImageIcon(getClass().getResource("/images/AcercaDE.png"));
            String refIsbn= fieldIsbn.getText();
            DeleteControl deleteControl=new DeleteControl(lista,refIsbn);
            deleteControl.eliminar();
            JOptionPane.showMessageDialog(new JPanel(), "El libro se ha eliminado", "Atención", JOptionPane.INFORMATION_MESSAGE,iconoDialog);
            refresh();
        }
    }
    /**
     *
     * @param keyEvent
     */
    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }
    /**
     * Método que maneja los eventos provenientes de presionar una tecla determinada. En este caso el evento se define
     * cuando se presiona la letra enter en el campo de búsqueda.
     * @param keyEvent
     */
    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if (keyEvent.getSource()==buscarField){
            if (keyEvent.getKeyCode()==KeyEvent.VK_ENTER){

                String valorConsulta= buscarField.getText();
                ConsultaControl consulta=new ConsultaControl(lista,valorConsulta);


                String arregloDatos[] =consulta.obtenerDatosConsulta();


                if (arregloDatos!=null){
                    fieldIsbn.setText(arregloDatos[0]);
                    fieldTitulo.setText(arregloDatos[1]);
                    fieldAutor.setText(arregloDatos[2]);
                    fieldFecha.setText(arregloDatos[3]);
                    fieldNumExistencias.setText(arregloDatos[4]);

                    tituloInfoLibro.setVisible(true);
                    consultaBox.setVisible(true);
                    editButton.setVisible(true);
                    labelError.setVisible(false);
                    deleteButton.setVisible(true);
                }else {
                    labelError.setVisible(true);
                    consultaBox.setVisible(false);
                    tituloInfoLibro.setVisible(false);
                    editButton.setVisible(false);
                    deleteButton.setVisible(false);
                }

            }

        }
    }
    /**
     *
     * @param keyEvent
     */
    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
    /**
     *
     * @param windowEvent
     */
    @Override
    public void windowOpened(WindowEvent windowEvent) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
    /**
     *
     * @param windowEvent
     */
    @Override
    public void windowClosing(WindowEvent windowEvent) {

    }
    /**
     *
     * @param windowEvent
     */
    @Override
    public void windowClosed(WindowEvent windowEvent) {

    }
    /**
     *
     * @param windowEvent
     */
    @Override
    public void windowIconified(WindowEvent windowEvent) {
    }
    /**
     *
     * @param windowEvent
     */
    @Override
    public void windowDeiconified(WindowEvent windowEvent) {
    }
    /**
     *
     * @param windowEvent
     */
    @Override
    public void windowActivated(WindowEvent windowEvent) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
    /**
     *
     * @param windowEvent
     */
    @Override
    public void windowDeactivated(WindowEvent windowEvent) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
    /**
     * Método que maneja el evento proveniente de intentar cerrar la ventana principal. En este caso crea una ventana
     * de dialogo donde permite elegir si guardar o no los cambios de la sesión.
     * @param e Evento de tipo WindowEvent.
     */
    protected void processWindowEvent(WindowEvent e) {

        if (e.getID() == WindowEvent.WINDOW_CLOSING) {
            Icon iconoGuardar=new ImageIcon(getClass().getResource("/images/Salir.png"));

            int exit = JOptionPane.showConfirmDialog(this, "Desea Guardar los cambios?","Atención",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.YES_NO_CANCEL_OPTION,iconoGuardar);
            if (exit == JOptionPane.YES_OPTION) {
                DataBaseControl dbc=new DataBaseControl(lista);
                dbc.guardarEnDB();
                System.exit(0);
            }
            if (exit== JOptionPane.NO_OPTION){
                System.exit(0);
            }

        } else {



            super.processWindowEvent(e);
        }
    }

}
