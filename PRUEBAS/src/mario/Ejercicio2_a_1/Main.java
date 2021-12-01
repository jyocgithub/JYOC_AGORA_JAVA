package mario.Ejercicio2_a_1;

public class Main
{
    public static void main(String[] args)
    {
        Thread hilo1 = new Thread(new LanzarHilos());
        Thread hilo2 = new Thread(new LanzarHilos());
        Thread hilo3 = new Thread(new LanzarHilos());
        Thread hilo4 = new Thread(new LanzarHilos());
        Thread hilo5 = new Thread(new LanzarHilos());
        hilo1.setName("1");
        hilo2.setName("2");
        hilo3.setName("3");
        hilo4.setName("4");
        hilo5.setName("5");
        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
        hilo5.start();
    }
}
