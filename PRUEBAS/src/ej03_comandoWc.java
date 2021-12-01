import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class ej03_comandoWc {

	public static void main(String[] args) {

//		try {
//			if (args.length == 1) {

				File fichero = new File("TETXO.TXT");
				if (fichero.exists()) {
					contar(fichero);
				} else {
//					throw new FicheroNoExiste();
				}
//			} else {
//				throw new ErrorArgs();
//			}
//		} catch (FicheroNoExiste error) {
//			System.err.println("El fichero no existe.");
//		} catch (ErrorArgs e) {
//			System.err.println("El fichero tiene mal los argumentos.");
//		}




	}

	public static void contar(File fichero) {

		int contChar = 0;
		int contLinea = 0;
		int contEspacios = 0;

		FileReader fr = null;

		try {
			fr = new FileReader(fichero);
			char salir = (char) -1;
			char c = (char) fr.read();

			while (c != salir) {

				if(c == '\n') {
					contLinea++;
				}
				if(c == ' ') {
					contEspacios++;
				}
//				if(c != '\n' && c != '\t' && c != ' ') {
				if( (c>='a'&& c<='z') || (c>='A'&& c<='Z')){
					contChar++;
				}
				
				System.out.print(c);
				c = (char) fr.read();

			}
			int lineas = contLinea + 1;
			System.out.println("\n hay " + contChar + " letras");
			System.out.println("\n hay " + (contEspacios + lineas) + " palabras");
			System.out.println("\n hay " + lineas + " lineas");

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fr != null) {
					fr.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
class FicheroNoExiste extends Exception {
	public FicheroNoExiste() {
		super();
	}
}
class ErrorArgs extends Exception {
	public ErrorArgs() {
		super();
	}
}