package paqueteweb;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;

public class HiloDelServidorWeb implements Runnable {
	OutputStream escritor;
	BufferedReader lector;
	Socket socket;
	private int timeout;
	ArrayList<String> lineasDeLaPeticion;

	public HiloDelServidorWeb(Socket socket, int timeout) {
		super();
		this.timeout = timeout;
		this.socket = socket;
		lineasDeLaPeticion = new ArrayList<>();

	}

	@Override
	public void run() {
		String tipocontenido = "";
		// String peticion = "";
		// String peticion2 = "";
		// URL unaurl = null;
		String respuestaHttp = "";
		System.out.println("En el hilo servidor");

		try {
			// soTimeOut es el tiempo que se espera desde que se hace la conexion hasta que se recibe la primera
			// lectura. Este tiempo en conexioes de red inestables puede ser mas largo, y si llega al limite
			// establecido, provoca una SocketTimeoutException
			// En nuestro ejemplo, no va a pasar, pues al ser el mismo equipo, desde que se crea el socket
			// hasta que se hace la primera lectura es tiempo casi inmediato.
			socket.setSoTimeout(timeout);
			// creamos los canales para leer y escribir del socket
			escritor = socket.getOutputStream();
			lector = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			// leemos todas las lineas de las peticion y las guardamos en un arraylist
			// aqui es donde se empieza a leer del socket, y donde ya se cancela el soTimeOut hablado antes
			String linea = lector.readLine();
			while (!linea.isEmpty()) {
				lineasDeLaPeticion.add(linea);
				linea = lector.readLine();
			}
			// aunque se leen todas las lineas de la peticion, solo hacemos caso a la primera
			String linea1 = lineasDeLaPeticion.get(0);

			// en este ejemplo, solo hacemos caso de las peticiones GET
			if (linea1.toUpperCase().startsWith("GET")) {
				int pos1 = linea1.indexOf("/"); // posision del primer caracter /
				int pos2 = linea1.indexOf(" ", pos1); // posicion del primer espacio, despues de la pos1
				// sabiendo donde esta el primer / y el primer espacio, entre medias, esta el nombre del fichero solicitado
				String ficheropedido = linea1.substring(pos1 + 1, pos2);
				ficheropedido = ficheropedido.toLowerCase();
				System.out.println("He recibido la peticion: " + linea1);
				System.out.println("El fichero pedido es  " + ficheropedido);

				// creamos un objeto File con el directorio donde estamos "sirviendo" contenidos
				// y el nombre del fichero que no han pedido
				// Si el fichero lo tenemos, lo devolveremos
				File objetoFileDelficheroQueSePide = new File(ServidorWebJYOC2019.Directorioraizdepaginas,
						ficheropedido);

				// si el fichero no existe...
				if (objetoFileDelficheroQueSePide.exists() == false) {
					// creamos una cabecera de respuesta con error 404, y la escribimos en el socket
					respuestaHttp = "HTTP/1.0 404 Not Found\r\n\r\n FICHERO NO ENCONTRADO, ERROR 404. ";
					// para escribir en el socket un String, lo convertimos a array de bytes
					escritor.write(respuestaHttp.getBytes("UTF-8"));
				} else {

					respuestaHttp = "HTTP/1.1 200 OK\r\n"; // analizar antes si es o no OK
					String extensionDelArchivo = ficheropedido.substring(ficheropedido.lastIndexOf(".") + 1);
					extensionDelArchivo = extensionDelArchivo.toUpperCase();
					switch (extensionDelArchivo) {
					case "HTML":
					case "HTM":
					case "CSS":
					case "TXT":
					case "JAVA":
						tipocontenido = "TEXTO";
						respuestaHttp += "Content-type: text/plain charset=utf-8\r\n\r\n";
						BufferedReader bfdefich = new BufferedReader(new FileReader(objetoFileDelficheroQueSePide));
						String linfich = bfdefich.readLine();
						while (linfich != null) {
							respuestaHttp += linfich;
							linfich = bfdefich.readLine();
						}
						bfdefich.close();
						escritor.write(respuestaHttp.getBytes("UTF-8"));
						break;
					case "AVI":
					case "MP4":
						tipocontenido = "VIDEO";
						byte[] imagenEnArrayDeBytes = leerFileYDevolverArrayDeBytes(objetoFileDelficheroQueSePide);
						respuestaHttp = "HTTP/1.1 200 OK\r\nContent-type: video/" + extensionDelArchivo + "\r\n\r\n";
						escritor.write(respuestaHttp.getBytes("UTF-8"));
						escritor.write(imagenEnArrayDeBytes);
						break;
					case "PNG":
					case "JPG":
					case "GIF":
					case "JPEG":
						tipocontenido = "IMAGEN";
						byte[] imagenEnArrayDeBytes2 = leerFileYDevolverArrayDeBytes(objetoFileDelficheroQueSePide);
						respuestaHttp = "HTTP/1.1 200 OK\r\nContent-type: image/" + extensionDelArchivo + "\r\n\r\n";
						escritor.write(respuestaHttp.getBytes("UTF-8"));
						escritor.write(imagenEnArrayDeBytes2);
						break;
					default:
						respuestaHttp = "HTTP/1.0 415 Unsupported Media Type\r\n\r\n FORMATO NO SOPORTADO, ERROR 415";
						escritor.write(respuestaHttp.getBytes("UTF-8"));
					} // fin del if de seleccion de tipo de fichero

				}
			} // fin del if de no existe el fichero
			System.out.println("-- TIPO MENSAJE DEVUELTO: " + respuestaHttp);
		} catch (SocketTimeoutException ex) {
			System.err.println("La conexión ha caducado (20 segundos desde conexion sin recibir nada)");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (escritor != null) escritor.close();
				if (lector != null) lector.close();
				if (socket != null) {
					socket.close();
					System.err.println("La conexión se ha cerrado");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private byte[] leerFileYDevolverArrayDeBytes(File objetoFileDelficheroQueSePide) {
		FileInputStream fis = null;
		int tamanodelfichero = (int) objetoFileDelficheroQueSePide.length();
		byte[] arrayDeBytesConTantosBytesComoTamanoDelFichero = new byte[tamanodelfichero];
		try {
			fis = new FileInputStream(objetoFileDelficheroQueSePide);
			fis.read(arrayDeBytesConTantosBytesComoTamanoDelFichero);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fis != null) try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return arrayDeBytesConTantosBytesComoTamanoDelFichero;
	}
}
