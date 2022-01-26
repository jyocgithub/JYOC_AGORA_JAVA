package plantilla_dao;


import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class GestorBBDD {

    private static String conexionDB = "jdbc:mysql://localhost:3306/";  // esto es para usar MySql
    private static String nombreBD = "PRUEBAS_PELICULAS";  // aqui viene el nombre de la base de datos
    private static String usuarioDB = "root";  // usuariode bbdd
    private static String passwordDB = "rootroot";   // pwd de la bbdd
    private static String opcionesBD = "";  // opcional
    private static Connection miConexion;
    private static DatabaseMetaData dbmd;

    /****************************************************************************************************************
     * CONECTAR
     * Establece una conexion a la bbdd y la asigna al atributo conexion
     * Usa los atributos antes indicados para configurar correctamente la conexion
     */
    public void conectar() {
        try {
            miConexion = DriverManager.getConnection(conexionDB + nombreBD + opcionesBD, usuarioDB, passwordDB);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /****************************************************************************************************************
     * DESCONECTAR
     */
    public void desconectar() {
        try {
            miConexion.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /****************************************************************************************************************
     * getNuevoIdPelicula
     * Devuelve el valor máximo de un campo de una tabla
     * Se puede usar para saber el valor maximo de una clave cuando no es autoincremental
     * y se necesita saber la proximo clave a insertar
     * @return
     */
    public int getNuevoIdPelicula() {
        int nuevo = 0;
        try {
            conectar();
            String sql = "SELECT max(cod_peli) FROM pelicula";
            ResultSet rs = miConexion.createStatement().executeQuery(sql);
            if (rs.next()) {
                return rs.getInt(1) + 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            desconectar();
        }
        return nuevo;
    }


    /****************************************************************************************************************
     * ALTATABLAS
     */
    public void altaTablas() {
        String sqlCrearTablaPelicula = "CREATE TABLE IF NOT EXISTS pelicula ( "
                + "cod_peli int NOT NULL ,  "
                + "titulo varchar(20) , "
                + "fechaestreno DATE , "
                + "PRIMARY KEY (cod_peli))";

        conectar();
        try {
            Statement instruccion = miConexion.createStatement();
            instruccion.execute(sqlCrearTablaPelicula);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            desconectar();
        }
    }


    /****************************************************************************************************************
     * ALTAPELICULA
     * @param miPelicula  pelicula con los nuevos datos
     */
    public void altaPelicula(Pelicula miPelicula) {
        conectar();
        try {
            String sql = "INSERT INTO PELICULA VALUES (?,?,?)  ";

            PreparedStatement instruccion = miConexion.prepareStatement(sql);
            instruccion.setInt(1, getNuevoIdPelicula());
            instruccion.setString(2, miPelicula.getTitulo());

            java.util.Date fechautil = miPelicula.getFechaestreno();
            java.sql.Date fechasql = dateUTILtoSQL(fechautil);
            instruccion.setDate(3, fechasql);

            instruccion.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            desconectar();
        }
    }


    /****************************************************************************************************************
     * BORRARUNAPELICULA
     * @param codigobuscado  id de la pelicula a borrar
     * @return
     */
    public boolean borrarUnaPeliculas(int codigobuscado) {
        conectar();

        Pelicula pelicula = null;
        try {
            String sql = "DELETE FROM PELICULA WHERE COD_PELI = ? ";

            PreparedStatement instruccion = miConexion.prepareStatement(sql);
            instruccion.setInt(1, codigobuscado);

            int f = instruccion.executeUpdate();
            if (f == 1) {

                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            desconectar();
        }
        return false;
    }


    /****************************************************************************************************************
     * MODIFICARUNAPELICULA
     * @param miPelicula  pelicula son los nuevos datos
     */
    public void modificarUnaPelicula(Pelicula miPelicula) {
        conectar();
        try {
            String sql = "UPDATE PELICULA SET titulo=?, FECHAESTRENO=?  ";

            PreparedStatement instruccion = miConexion.prepareStatement(sql);
            instruccion.setString(1, miPelicula.getTitulo());

            java.util.Date fechautil = miPelicula.getFechaestreno();
            java.sql.Date fechasql = dateUTILtoSQL(fechautil);
            instruccion.setDate(2, fechasql);

            instruccion.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            desconectar();
        }
    }


    /****************************************************************************************************************
     * consultarPeliculas
     * @param codigobuscado
     * @return lista de peliculas, puede estar vacia si no hay peliculas
     */
    public ArrayList<Pelicula> consultarPeliculas(int codigobuscado) {
        conectar();
        ArrayList<Pelicula> peliculas = new ArrayList<>();
        try {
            String sql = "SELECT * FROM PELICULA";
            PreparedStatement instruccion = miConexion.prepareStatement(sql);
            ResultSet registros = instruccion.executeQuery();
            while (registros.next()) {
                int cod = registros.getInt("cod_peli");
                String titulo = registros.getString("titulo");
                // no es necesario convertir de java.sql.Date a java.util.Date
                Date fechaestreno = registros.getDate("fechaestreno");
                Pelicula nuevaPelicula = new Pelicula(cod, titulo, fechaestreno);
                peliculas.add(nuevaPelicula);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            desconectar();
        }
        return peliculas;
    }

    /****************************************************************************************************************
     * consultarUnaPelicula
     * @param codigobuscado
     * @return Objeto pelicula obtenido, o null si no existe
     */
    public Pelicula consultarUnaPelicula(int codigobuscado) {
        conectar();
        Pelicula pelicula = null;
        try {
            String sql = "SELECT * FROM PELICULA WHERE COD_PELI  = ? ";
            PreparedStatement instruccion = miConexion.prepareStatement(sql);
            instruccion.setInt(1, codigobuscado);
            ResultSet registros = instruccion.executeQuery();
            if (registros.next()) {
                int cod = registros.getInt("cod_peli");
                String titulo = registros.getString("titulo");
                // no es necesario convertir de java.sql.Date a java.util.Date
                Date fechaestreno = registros.getDate("fechaestreno");
                pelicula = new Pelicula(cod, titulo, fechaestreno);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            desconectar();
        }
        return pelicula;
    }


    /****************************************************************************************************************
     * borrarRepetidosDeUnaPelicula
     * @param titulorepetido  titulo que queremoe buscar y djar SOLO UNA OCURRENCIA
     * @return
     */
    public void borrarTitulosRepetidos(String titulorepetido) {
        // BORRA TODOS MENOS UNO DE LOS TITULOS REPETIDOS
        // seleccionamos todos los registros que queremos borrar, por ejemplo, los de cierto titulo

        String sql = "SELECT * FROM PELICULA WHERE TITULO  = ? ";
        conectar();
        try {
            PreparedStatement instruccion = miConexion.prepareStatement(sql);
            instruccion.setString(1, titulorepetido);
            ResultSet registros = instruccion.executeQuery();

            if (registros.next()) {   // si hay un primer registro, lo saltamos
                while (registros.next()) {   // borramos el resto de registro, si existen

                    int idPeliculaABorrar = registros.getInt("cod_peli");  // ahora debemos saber el id (PK) de lo que vamos a borrar

                    String sql2 = "DELETE FROM PELICULA WHERE COD_PELI = ? ";
                    PreparedStatement instruccion2 = miConexion.prepareStatement(sql2);
                    instruccion2.setInt(1, idPeliculaABorrar);
                    instruccion2.executeUpdate();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        desconectar();
    }


    /****************************************************************************************************************
     * dateUTILtoSQL
     * Convierte un objerto DATE-JAVA al correspondiente DATE-SQL
     * Se necesita para guardar en una bbdd un campo DATE de java
     * La operacion inversa (guardar un objeto DATE-SQL en un DATE-JAVA) no es necesaria,
     * hace un casting automatico, no hace fatla hacer nada
     * @return
     */
    public static java.sql.Date dateUTILtoSQL(java.util.Date fechaEnUtil) {
        if (fechaEnUtil == null) {
            return null;
        }
        java.sql.Date fechaEnSql = null;
        fechaEnSql = new java.sql.Date(fechaEnUtil.getTime());
        return fechaEnSql;
    }


    /****************************************************************************************************************
     /***********************   METADATA    **************************************************************************
     /****************************************************************************************************************

     /****************************************************************************************************************
     * existeLaBBDD
     * @return
     */
    public boolean existeLaBBDD() {
        ResultSet result = null;
        try {
            miConexion = DriverManager.getConnection(conexionDB + nombreBD + opcionesBD, usuarioDB, passwordDB);
            Statement instruccion = miConexion.createStatement();
            String sql = "SELECT SCHEMA_NAME FROM INFORMATION_SCHEMA.SCHEMATA WHERE SCHEMA_NAME = '" + nombreBD + "'";
            result = instruccion.executeQuery(sql);
            if (result.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.err.println(e.getLocalizedMessage());
        } finally {
            try {
                result.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /****************************************************************************************************************
     * informacionDeLaBBDD
     * @return
     */
    public void informacionDeLaBBDD() {
        try {
            dbmd = miConexion.getMetaData();
            String nombre = dbmd.getDatabaseProductName();// Información sobre el servidor de la BD
            String driver = dbmd.getDriverName(); // Nombre del controldor/Driver de la BD
            String url = dbmd.getURL(); // URL donde se aloja la BD actual
            String usuario = dbmd.getUserName(); // Nombre del usuario actual de la BD
            System.out.println("INFORMACIÓN SOBRE LA BASE DE DATOS\n==================================");
            System.out.println(
                    "Nombre : " + nombre + "\nDriver : " + driver + "\nURL    : " + url + "\nUsuario:" + usuario);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /****************************************************************************************************************
     * informacionDeLasTablas
     * @return
     */
    public void informacionDeLasTablas() {

        String esnulo = null, esautoincremental = null;
        ResultSet result = null;
        Statement instruccion = null;
        try {
            dbmd = miConexion.getMetaData();
            ResultSet todaslastablas = dbmd.getTables(nombreBD, null, "%", null);    // obtenemos un conjunto con todas las tablas
            while (todaslastablas.next()) {                                            // vemos una a una la informacion de CADA tabla
                String catalogo = todaslastablas.getString("TABLE_CAT");               // indica el nombre del catalogo( bbdd)
                String nombreElemento = todaslastablas.getString("TABLE_NAME");        // indica el nombre del elemento (tabla)
                String tipoElemento = todaslastablas.getString("TABLE_TYPE");          // indica el tipo del elemento (que es una TABLE)
                String schema = todaslastablas.getString("TABLE_SCHEM");               // indica el schema del elemento (si lo tiene)
                System.out.println("\n\n-----> BBDD   = " + catalogo);
                System.out.println("-----> SCHEMA = " + schema + "-----> TIPO = " + tipoElemento + "----> NOMBRE = " + nombreElemento);
                instruccion = miConexion.createStatement();                               // vamos a ver el CONTENIDO DE ESTA TABLA
                result = instruccion.executeQuery("SELECT * FROM " + nombreElemento);
                ResultSetMetaData rsmd = result.getMetaData();
                int numeroColumnas = rsmd.getColumnCount();                            // indica cuantas columnas (campos) tiene la tabla
                System.out.println("Numero de columnas : " + numeroColumnas);
                for (int i = 1; i <= numeroColumnas; i++) {
                    System.out.println("Columna :" + i);                               // ordinal del campo
                    System.out.println("\tNombre :" + rsmd.getColumnName(i) + "\n\tTipo " + rsmd.getColumnTypeName(i));   // nombre y tipo del campo
                    if (rsmd.isNullable(i) == 0) {                                     // indica si el campo es null
                        esnulo = "NO";
                    } else {
                        esnulo = "SI";
                    }
                    if (rsmd.isAutoIncrement(i) == true) {                              // indica si el campo es autoincremental
                        esautoincremental = "SI";
                    } else {
                        esautoincremental = "NO";
                    }
                    System.out.println("\tPuede ser nula? " + esnulo);
                    System.out.println("\tMáximo ancho de columna " + rsmd.getColumnDisplaySize(i));    // indica el tamaño del campo
                    System.out.println("\tEste campo es autoincremental?: " + esautoincremental);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                result.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    // Solo para resultset desplazables!!!!
    public static int tamanoDeUnResulSet(ResultSet res) {
        int num = 0;
        try {
            res.last(); // nos posicionamos al final
            num = res.getRow(); // vemos el numero de la ultima fila
            res.beforeFirst(); //nos posicionamos en el primer registro otra vez
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return num;


    }


}
