package socketUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class ClienteEmisorUDP {

	public static void main (String[] args) {

		int puertoUDP = 25000;
		InetAddress ipDireccion;
		DatagramSocket socketUDP = null;

		try {
			String datos = "Mensaje que se envia";

			// creo un objeto direccion ip
			ipDireccion = InetAddress.getByName ("localhost");
			// creo un socket UDP
			socketUDP = new DatagramSocket ();
			// creo un datagrama para enciarlo por el socket UDP
			// en este constructor pongo el array de bytes a enviar, el tamaño del mismo, la direcion IP y el puerto
			DatagramPacket datagrama = new DatagramPacket (datos.getBytes (), datos.getBytes ().length, ipDireccion, puertoUDP);
			// enviar datagrama
			socketUDP.send (datagrama);
			for (;;)
				;
		}
		catch (UnknownHostException e1) {
			e1.printStackTrace ();
		}
		catch (SocketException e) {
			e.printStackTrace ();
		}
		catch (IOException e) {
			e.printStackTrace ();
		}
		finally {
			socketUDP.close ();
		}
	}
}
