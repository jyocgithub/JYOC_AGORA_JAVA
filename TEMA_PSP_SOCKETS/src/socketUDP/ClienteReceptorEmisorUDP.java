package socketUDP;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;



public class ClienteReceptorEmisorUDP {


	public static void main (String[] args) {

		int puertoUDP = 25000;
		InetAddress ipDireccion;
		InetSocketAddress isAdress;
		DatagramSocket socketUDP = null;

		try {
			// RECIBIR MENSAJE
			// creo un objeto "direccion de socket" pues para recibir necesito saber de donde
			isAdress = new InetSocketAddress ("localhost", puertoUDP);

			// creo el socket UDP, pero diciendole de donde ha de leer 
			socketUDP = new DatagramSocket (isAdress);

			// creo u array de bytes para que meta ahi lo que lea
			byte[] mensajeRecibido = new byte[100];

			// creo un datagrama donde recibir el mensaje
			// en este caso el constructor lleva el array de bytes y el tamaño del mismo
			DatagramPacket datagramaRecibido = new DatagramPacket (mensajeRecibido, 100);

			// recibir mensaje
			socketUDP.receive (datagramaRecibido);
			// convierto el array de bytes recibido en un String
			String mensajeRecibidoEnString = new String (mensajeRecibido);
			System.out.println ("Mensaje recibido" + mensajeRecibidoEnString);

			//ENVIAR MENSAJE RECIBIDO
			// creo un objeto direccion ip
			ipDireccion = InetAddress.getByName ("localhost");
			// creo un datagrama para enciarlo por el socket UDP
			// en este constructor pongo el array de bytes a enviar, el tamaño del mismo, la direcion IP y el puerto			
			DatagramPacket datagramaParaEnviar = new DatagramPacket (mensajeRecibido, mensajeRecibido.length, ipDireccion, puertoUDP);
			// envio el datagrama
			socketUDP.send (datagramaParaEnviar);
		}
		catch (IOException e) {
			e.printStackTrace ();
		}

		finally {
			socketUDP.close ();
		}

	}

}
