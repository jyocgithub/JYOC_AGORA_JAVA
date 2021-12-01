package videoclubsql;

import socketsUDP_conSwing.DatosNoEncontradosException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BBDDVideoClub {

    Connection conexion;

    public void insertarCliente(Cliente miCliente) {
        conectar();
        try {
        String ss = "INSERT INTO ALUMNO (NOMBRE, EDAD) VALUES (?,?)";
            String sql = "INSERT INTO alumno ( NOMBRE, EDAD) VALUES ( ?,?)  "; //no aparece cod_cliente por ser autoincrementable
//            String sql = "INSERT INTO alumno ( NOMBRE, EDAD) VALUES ( 'ramon',33)  "; //no aparece cod_cliente por ser autoincrementable
            PreparedStatement instruccion = conexion.prepareStatement(ss);//            instruccion.setInt(1, miCliente.getCod_cliente()); //empieza en posicion 1 y no 0
            instruccion.setString(1, "Javi");
            instruccion.setInt(2, 33);

//            String sql = "INSERT INTO CLIENTE ( NOMBRE, DIRECCION, TELEFONO ) VALUES ( ?,?,?)  "; //no aparece cod_cliente por ser autoincrementable
//            PreparedStatement instruccion = conexion.prepareStatement(sql);//            instruccion.setInt(1, miCliente.getCod_cliente()); //empieza en posicion 1 y no 0
//            instruccion.setString(1, miCliente.getNombre());
//            instruccion.setString(2, miCliente.getDireccion());
//            instruccion.setString(3, miCliente.getTelefono());



            instruccion.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(BBDDVideoClub.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            desconectar();
        }

    }

    public void insertarPelicula(Pelicula peli) {

    }

    public ArrayList<Cliente> consultarClientes() {

        conectar();

        ArrayList<Cliente> clientes = new ArrayList<>();
        try {
            String sql = "SELECT * FROM CLIENTE "; //no aparece cod_cliente por ser autoincrementable

            PreparedStatement instruccion = conexion.prepareStatement(sql);

            ResultSet registros = instruccion.executeQuery();

            while (registros.next()) {
                int cod = registros.getInt("cod_cliente");
                String nom = registros.getString("nombre");
                String dir = registros.getString("direccion");
                String tel = registros.getString("telefono");

                Cliente nuevocliente = new Cliente(cod, nom, dir, tel);

                clientes.add(nuevocliente);

            }

        } catch (SQLException ex) {
            Logger.getLogger(BBDDVideoClub.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            desconectar();

        }
        return clientes;
    }

    public ArrayList<Pelicula> consultarPeliculas() {
return null;
    }

    public Cliente consultarUnCliente(int codigo) throws DatosNoEncontradosException {

        conectar();

        Cliente cliente = null;
        try {
            String sql = " SELECT * FROM CLIENTE WHERE COD_CLIENTE = ?"; //no aparece cod_cliente por ser autoincrementable

            PreparedStatement instruccion = conexion.prepareStatement(sql);
            instruccion.setInt(1, codigo);
            ResultSet registros = instruccion.executeQuery();

            if (registros.next()) {
                int cod = registros.getInt("cod_cliente");
                String nom = registros.getString("nombre");
                String dir = registros.getString("direccion");
                String tel = registros.getString("telefono");

                cliente = new Cliente(cod, nom, dir, tel);
            } else {
                DatosNoEncontradosException mierror = new DatosNoEncontradosException();
                throw mierror;
            }

        } catch (SQLException ex) {
            Logger.getLogger(BBDDVideoClub.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            desconectar();

        }
        return cliente;
    }

    public boolean alquilarPeli(int codcli, int codpeli) {
        boolean res = true;

        int dis = 0;
        conectar();

        Cliente cliente = null;
        try {
            // VER SI EHY EXISTENCUAS
            String sql = " SELECT DISPONIBLES FROM PELICULA WHERE COD_PELI = ?"; //no aparece cod_cliente por ser autoincrementable

            PreparedStatement instruccion = conexion.prepareStatement(sql);
            instruccion.setInt(1, codpeli);
            ResultSet registros = instruccion.executeQuery();

            if (registros.next()) {
                dis = registros.getInt("disponibles");
            }
//            else {
//                DatosNoEncontradosException mierror = new DatosNoEncontradosException();
//                throw mierror;
//            }

            if (dis <= 0) {
                res = false;
            } else {
                // SI LAS HAUY ALQUIALR: GUARDAR EN ALQUILERES

                // VER SI EHY EXISTENCUAS
                String sql2 = " INSERT INTO ALQUILER VALUES ( ?, ?) ";

                PreparedStatement instruccion2 = conexion.prepareStatement(sql2);
                instruccion2.setInt(1, codcli);
                instruccion2.setInt(2, codpeli);
                instruccion2.executeUpdate();
                // ACTUALIZAR EXISTENCIAS
                
                                String sql3 = " UPDATE PELICULA SET DISPONIBLES = ? WHERE COD_PELI = ? ";

                PreparedStatement instruccion3 = conexion.prepareStatement(sql3);
                instruccion3.setInt(1, codcli);
                instruccion3.setInt(2, codpeli);
                instruccion3.executeUpdate();
                

            }

        } catch (SQLException ex) {
            Logger.getLogger(BBDDVideoClub.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            desconectar();

        }

        return res;

    }

    public void conectar() {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "root");
        } catch (SQLException ex) {
            Logger.getLogger(BBDDVideoClub.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void desconectar() {
        try {
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(BBDDVideoClub.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void crearTablaCliente() {

    }

    public void crearTablaPelicula() {

    }

    public void crearTablaAlquiler() {

    }

}
