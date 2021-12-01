import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor
{
    public static void main(String args[])
    {
        ServerSocket servidor;
        Socket conexion;
        ObjectOutputStream salida;
        ObjectInputStream entrada;
        int num = 0;
        try
        {
            servidor = new ServerSocket(5001); // Creamos un ServerSocket en el puerto 5000
            System.out.println("Servidor Arrancado.");
            while (true)
            {
            System.out.println("Esperando llamada de conexion de algun cliente...");
                conexion = servidor.accept();     // Esperamos una conexión
                num++;
                System.out.println("Conexión nº "+num+" conectado desde: "+conexion.getInetAddress().getHostName());
                entrada = new ObjectInputStream(conexion.getInputStream());  // Abrimos los canales de E/S
                salida  = new ObjectOutputStream(conexion.getOutputStream());
                System.out.println("Canales con el cliente establecidos");
                String mensaje = (String) entrada.readObject();    //Leemos el mensaje del cliente
                System.out.println("Conexión nº "+num+". Mensaje recibido: "+mensaje);
                salida.writeObject("Buenos dias " + mensaje);  // Le respondemos
                conexion.close();                           // Y cerramos la conexión
            }
        } catch (IOException e) {}
          catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
