import java.util.InputMismatchException;
import java.util.Scanner;

public class Strings {

	public static void main(String[] args) {

		System.out.println("Antes de llamar a dividir");

		// double res;
		// try {
		// res = dividir();
		// } catch (Exception e) {
		//
		// e.printStackTrace();
		// }

		boolean respuesta;
		try {
			respuesta = esmenordeedad();
		} catch (EdadNoValidaException e) {
			System.out.println(e.getMessage());
		}

		// System.out.println("Despues de llamar a dividir, dio " + respuesta);

	}

	public static boolean esmenordeedad() throws EdadNoValidaException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Dame tu edad");
		int edad = sc.nextInt();
		if (edad < 0 || edad > 120) {
			EdadNoValidaException err = new EdadNoValidaException();
			throw err;
		}

		if (edad > 17) {
			return true;
		} else {
			return false;
		}
	}

	public static double dividir() throws Exception {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Dame dos numeros:");
			int a = sc.nextInt();
			double b = sc.nextDouble();

			double div = a / b;
			int[] prueba = new int[5];
			prueba[a] = 235;

			return div;
		} catch (InputMismatchException e) {
			System.out.println("Te dije un numero, no letras !!");
		} catch (Exception e) {
			System.out.println("Te has pasado!");
			e.printStackTrace();
		} finally {

			System.out.println("paso por aqui SIEMPRE");
		}
		return 0;
	}

}
