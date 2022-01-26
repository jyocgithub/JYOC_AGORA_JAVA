package ordenar.sin_hilos;
import java.util.Random;

public class Main
{
	public static void main(String[] args)
	{
		final int NUM = 100000;
		int[] numeros1 = new int[NUM];
		int[] numeros2 = new int[NUM];
		long tiempoComienzo, tiempoFinal;

		Random r = new Random();
		System.out.println("Rellenando arrays con aleatorios...");

		for (int i = 0; i < numeros1.length; i++)
		{
			numeros1[i] = r.nextInt(1000) + 1;
			numeros2[i] = r.nextInt(1000) + 1;
		}

		System.out.println("Arrays rellenos");
		System.out.println("Ordenando arrays...");

		tiempoComienzo = System.currentTimeMillis();

		Ordenar.ordenar(numeros1);
		Ordenar.ordenar(numeros2);

		/*
		 * for (int i = 0; i < numeros1.length; i++) {
		 * System.out.println(numeros1[i]); }
		 */

		tiempoFinal = System.currentTimeMillis();

		System.out.println("Ha tardado en ordenar " + (tiempoFinal - tiempoComienzo) + " milisegundos");
	}
}