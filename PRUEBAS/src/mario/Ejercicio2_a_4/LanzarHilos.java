package mario.Ejercicio2_a_4;

public class LanzarHilos implements Runnable
{

    @Override
    public void run()
    {

        for (int i = 0; i < 20; i++)
        {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("El corredor " + Thread.currentThread().getName() + " va por la vuelta " + i);
        }
        System.out.println("El corredor " + Thread.currentThread().getName() + " ha terminado");
    }

}
