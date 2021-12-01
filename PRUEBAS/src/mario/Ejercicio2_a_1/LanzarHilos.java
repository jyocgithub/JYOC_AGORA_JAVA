package mario.Ejercicio2_a_1;

public class LanzarHilos implements Runnable
{
    @Override
    public void run()
    {
        if(Thread.currentThread().getName().equals("1"))
        {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println( "Soy " + Thread.currentThread().getName() + " Hola mundo");
        }
        if(Thread.currentThread().getName().equals("2"))
        {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println( "Soy " + Thread.currentThread().getName() + " Hola mundo");
        }
        if(Thread.currentThread().getName().equals("3"))
        {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println( "Soy " + Thread.currentThread().getName() + " Hola mundo");
        }
        if(Thread.currentThread().getName().equals("4"))
        {
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Soy " + Thread.currentThread().getName() + " Hola mundo");
        }
        if(Thread.currentThread().getName().equals("5"))
        {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Soy " + Thread.currentThread().getName() + " Hola mundo");
        }

    }
}
