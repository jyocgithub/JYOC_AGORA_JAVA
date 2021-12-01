package mario.Ejercicio2_a_5;

public class LanzarHilos extends Thread
{
        String nombre;

        static int cuenta = 0;

    public LanzarHilos(String nombre) {
        this.nombre = nombre;
    }

    public void run(){


            {
                for (int i = 0; i < 1; i++) {
                    System.out.println("El hilo " + nombre + " lleva " + cuenta + " vueltas");
                    cuenta++;
                }
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

