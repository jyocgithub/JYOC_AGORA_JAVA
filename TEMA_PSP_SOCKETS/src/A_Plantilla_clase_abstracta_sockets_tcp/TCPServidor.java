package A_Plantilla_clase_abstracta_sockets_tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public abstract class TCPServidor {
	
	private int puerto;
	private ServerSocket serversocket;
	protected DataInputStream lector;
	protected DataOutputStream escritor;
	
	public TCPServidor(int puerto) {
		this.puerto = puerto;
		this.serversocket = null;
		crearServerSocket();
	}


	public void crearServerSocket() {
		
		try {
			serversocket = new ServerSocket(puerto);
			System.out.println("Servidor preparado, esperando algún cliente...");

			Socket manguera = serversocket.accept();
			escritor = new DataOutputStream( manguera.getOutputStream());
			lector = new DataInputStream( manguera.getInputStream());
			System.out.println("Cliente conectado, comienza comunicación:");
			
			comunicacion();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(serversocket != null) {
							serversocket.close();
				}
		
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public abstract void comunicacion();
	
}
