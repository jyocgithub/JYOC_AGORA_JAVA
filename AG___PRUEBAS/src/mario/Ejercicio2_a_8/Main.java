package mario.Ejercicio2_a_8;

public class Main
{
    public static void main(String[] args)
    {
        Tartas cocinero1 = new Tartas();
        Tartas cocinero2 = new Tartas();
        Tartas cocinero3 = new Tartas();
        Tartas cocinero4 = new Tartas();
        cocinero1.setName("1");
        cocinero2.setName("2");
        cocinero3.setName("3");
        cocinero4.setName("4");

        cocinero1.start();
        cocinero2.start();
        cocinero3.start();
        cocinero4.start();

        try {
            cocinero1.join();
            cocinero2.join();
            cocinero3.join();
            cocinero4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("TODAS LAS TARTAS ESTÁN ACABADAS");
    }
}
