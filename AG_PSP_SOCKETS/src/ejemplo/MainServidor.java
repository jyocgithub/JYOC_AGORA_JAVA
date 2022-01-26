package ejemplo;
import java.io.*;
import java.net.*;
import java.util.Iterator;
import java.util.TreeSet;

public class MainServidor
{
	public static void main(String[] args)
	{
		ServerSocket serverSocket = null;
		Socket socket = null;
		DataOutputStream salida = null;
		DataInputStream entrada = null;

		try
		{
			serverSocket = new ServerSocket(5555);
			socket = serverSocket.accept();
			System.out.println("Entró un cliente.");

			boolean parar = false;
			TreeSet<Integer> ts = new TreeSet<Integer>();

			while (!parar)
			{
				entrada = new DataInputStream(socket.getInputStream());
				String dato = entrada.readUTF();
				System.out.println("Cliente dice: " + dato);

				if (dato.equalsIgnoreCase("parar"))
					parar = true;
				else ts.add(Integer.parseInt(dato));
			}

			String cadenaOrdenada = "";
			Iterator<Integer> it = ts.iterator();

			while (it.hasNext())
			{
				cadenaOrdenada += it.next() + " ";
			}

			salida = new DataOutputStream(socket.getOutputStream());
			salida.writeUTF("La cadena ordenada es " + cadenaOrdenada);

		}
		catch (IOException e)
		{
			System.out.println("Error de comunicación.");
		}
		finally
		{
			try
			{
				entrada.close();
				socket.close();
				salida.close();
				serverSocket.close();
			}
			catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
