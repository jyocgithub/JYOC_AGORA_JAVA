package mario.Ejercicio2_a_4;

public class Main
{
    public static void main(String[] args)
    {
        Thread corredor1 = new Thread(new LanzarHilos());
        Thread corredor2 = new Thread(new LanzarHilos());
        Thread corredor3 = new Thread(new LanzarHilos());
        Thread corredor4 = new Thread(new LanzarHilos());
        Thread corredor5 = new Thread(new LanzarHilos());
        Thread corredor6 = new Thread(new LanzarHilos());
        Thread corredor7 = new Thread(new LanzarHilos());
        Thread corredor8 = new Thread(new LanzarHilos());

        corredor1.setName("1");
        corredor2.setName("2");
        corredor3.setName("3");
        corredor4.setName("4");
        corredor5.setName("5");
        corredor6.setName("6");
        corredor7.setName("7");
        corredor8.setName("8");

        corredor1.start();
        corredor2.start();
        corredor3.start();
        corredor4.start();
        corredor5.start();
        corredor6.start();
        corredor7.start();
        corredor8.start();

        System.out.println("HAN SALIDO TODOS LOS CORREDORES");

        try {
            corredor1.join();
            corredor2.join();
            corredor3.join();
            corredor4.join();
            corredor5.join();
            corredor6.join();
            corredor7.join();
            corredor8.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("SE ACABÓ LA CARRERA");
    }
}
