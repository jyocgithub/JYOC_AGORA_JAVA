package mario.Ejercicio2_a_8;

import java.util.Random;

public class Tartas extends Thread
{
    @Override
    public void run() 
    {
        Random r = new Random();
        r.nextInt(2000);
        String parseado = r.toString();

        long tiempoInicioTarta = System.currentTimeMillis();
        for (int i = 0; i < 1; i++)
        {
            System.out.println("El Cocinero " + Thread.currentThread().getName() + " ha acabado su tarta y ha tardado " + parseado);
            
        }
        long tiempoFinalTarta = System.currentTimeMillis();
        System.out.println("El cocinero " + Thread.currentThread().getName() + " ha acabado y ha tardado: " + (tiempoFinalTarta - tiempoInicioTarta));
    }
}
