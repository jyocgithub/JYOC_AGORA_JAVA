package mario.Ejercicio2_a_3;

public class Main
{
    public static void main(String[] args) throws InterruptedException {
        Thread hilo1 = new Thread(new LanzaHilos());
        Thread hilo2 = new Thread(new LanzaHilos());
        Thread hilo3 = new Thread(new LanzaHilos());
        Thread hilo4 = new Thread(new LanzaHilos());
        Thread hilo5 = new Thread(new LanzaHilos());
        hilo1.setName("Coche1");
        hilo2.setName("Coche2");
        hilo3.setName("Coche3");
        hilo4.setName("Coche4");
        hilo5.setName("Coche5");
        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
        hilo5.start();

        hilo1.join();
        hilo2.join();
        hilo3.join();
        hilo4.join();
        hilo5.join();

        System.out.println("Todos los coches han terminado la carrera");
    }
}
