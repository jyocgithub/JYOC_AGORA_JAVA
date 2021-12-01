package paqueteweb;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorWebJYOC2019 {

	static private final Integer PUERTO = 8087;
	static private final Integer TIMEOUT_CLIENTES = 20000; // 20 segundos, se mide en milisegundos
	static private final String DIRECTORIO_DE_CONTENIDOS = "CARPETA_DE_CONTENIDOS";
	static final String Directorioraizdepaginas = "." + File.separator + DIRECTORIO_DE_CONTENIDOS; // File.separator asegura que la
																									// / que se añade sea la de unix
																									// o la de windows, la que le
																									// toque

	public static void main(String[] args) {
		ServerSocket serverSocket;
		Socket socket;

		try {
			serverSocket = new ServerSocket(PUERTO);
			System.out.println("SERVIDOR CREADO ===========");
			while (true) {
				System.out.println("-- Esperando nueva peticion...");
				// En este caso el socket no es una clase cliente que hagamos nosotros,
				// si no que lo genera el navegador (chrome, por ejemplo), al hacer una peticion al puerto correspondiente
				// Se ha de leer del socket lo que pide , y al mismo socket (navegador), devolverle la respuesta
				// con lo que ha pedido.
				// EL navegador sabe procesar lo se le devuelve pintandolo en la pantalla , o descargandolo, o lo que tenga
				// configurado.
				socket = serverSocket.accept();
				System.out.println("-- Cliente conectado, peticion recibida.");
				HiloDelServidorWeb hds = new HiloDelServidorWeb(socket, TIMEOUT_CLIENTES);
				Thread t = new Thread(hds);
				t.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
