package mario.Ejercicio2_a_5;

public class Main
{
    public static void main(String[] args) throws InterruptedException {

        LanzarHilos Corredor1 = new LanzarHilos("1");
        Corredor1.start();
        System.out.println("EMPIEZA LA CARRERA");
        Corredor1.join(3000);

        LanzarHilos Corredor2 = new LanzarHilos("2");
        Corredor2.start();
        System.out.println("Relevo");
        Corredor2.join(3000);

        LanzarHilos Corredor3 = new LanzarHilos("3");
        Corredor3.start();
        System.out.println("Relevo");
        Corredor3.join(3000);

        LanzarHilos Corredor4 = new LanzarHilos("4");
        Corredor4.start();
        System.out.println("Relevo");
        Corredor4.join(3000);



        System.out.println("Todos los hilos terminados");

    }
}
