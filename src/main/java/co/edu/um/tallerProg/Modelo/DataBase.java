package co.edu.um.tallerProg.Modelo;

import java.sql.*;

/**
 * Clase que gestiona los trámites con la base de datos.
 */
public class DataBase {
    /*
     * Instalación del JDBC driver
     */
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    /*
     * Asignación del url de la base de datos.
     */
    static final String DB_URL = "jdbc:mysql://localhost/Biblioteca";

    /*
     * Credenciales de la base de datos: usuario y contraseña.
     */
    static final String USER = "root";    //Nombre de usuario de la BD
    static final String PASS = "";        //Contraseña de la BD


    /**
     * Este método me permite obtener toda la información almacenada en la base de datos, depositándola en un objeto de
     * la clase ListaLibros.
     * @return un objeto de la clase ListaLibros.
     */
    public ListaLibros sacarDB(){
        ListaLibros<String> lista = new ListaLibros<String>();
        Libro aux=lista.primero;
            //STEP 1: Initialize connection and statement variables.
        Connection conn = null;
        Statement stmt = null;
        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();

            String sql = "SELECT * FROM Libros";   //mysql Query
            ResultSet rs = stmt.executeQuery(sql);
            //STEP 5: Extract data from result set
            while(rs.next()){
                //Retrieve by column name
                lista.insertarEnFin(rs.getString("isbn"),rs.getString("titulo"),rs.getString("fecha"),rs.getString("autor"));
            }
            rs.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException se){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        return lista;

    }

    /**
     * Método que permite insertar nuevos elementos en la base de datos. Estos elementos, son cada uno de los libros de
     * la lista con la que se ha trabajado en el programa. De cada libro se obtienen sus atributos, y éstos son
     * almacenados en las celdas de la tabla en la base de datos.
     * @param lista Objeto de la clase ListaLibros que contiene la lista de los libros de la biblioteca.
     */
    public void insertarDB(ListaLibros<String> lista){
        Libro<String> aux=lista.primero;
        String isbn, titulo, autor, fecha;
        int existencias;
            //STEP 1: Initialize connection and statement variables.
        Connection conn = null;
        Statement stmt = null;
        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Inserting records into the table...");
            stmt = conn.createStatement();


            while (aux!=null) {
                isbn=aux.getIsbn();
                titulo=aux.getTitulo();
                autor=aux.getAutor();
                fecha=aux.getFecha();
                existencias=aux.getNumEjem();
                String sql = "INSERT INTO Libros " +
                        "VALUES (NULL, '"+isbn+"', '"+titulo+"', '"+autor+"','"+fecha+"','"+existencias+"')";
                stmt.executeUpdate(sql);
                aux=aux.siguiente;

            }

            System.out.println("Inserted records into the table...");

        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException se){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");

    }

    /**
     * Método que limpia la base de datos, eliminando los valores que existan en la tabla correspondiente de la
     * base de datos. Esto se hace con el fin de limpiar la base de datos y volverla a llenar con los valores
     * modificados después de la sesión.
     */
    public void eliminarDB(){
            //STEP 1: Initialize connection and statement variables.
        Connection conn = null;
        Statement stmt = null;
        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query

            stmt = conn.createStatement();

            String sql = "DELETE FROM Libros";
            stmt.executeUpdate(sql);


        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException se){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");

    }
}
