package ejemplo;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class MainCliente
{
	public static void main(String[] args)
	{
		Socket socket = null;
		DataInputStream entrada = null;
		DataOutputStream salida = null;
		Scanner sc = new Scanner(System.in);

		try
		{
			socket = new Socket("127.0.0.1", 5555);
			salida = new DataOutputStream(socket.getOutputStream());

			boolean parar = false;

			while (!parar)
			{
				System.out.print("Cadena a enviar: ");
				String cadena = sc.nextLine();
				salida.writeUTF(cadena);

				if (cadena.equalsIgnoreCase("parar"))
					parar = true;
			}

			entrada = new DataInputStream(socket.getInputStream());
			System.out.println("El servidor dice: " + entrada.readUTF());

		}
		catch (IOException e)
		{
			System.out.println("Error de comunicación.");
		}
		finally
		{
			try
			{
				salida.close();
				entrada.close();
				socket.close();
				sc.close();
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
