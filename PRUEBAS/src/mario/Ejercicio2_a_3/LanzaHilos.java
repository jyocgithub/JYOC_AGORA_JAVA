package mario.Ejercicio2_a_3;


public class LanzaHilos implements Runnable
{
    @Override
    public void run(){
        long tiempoinicialCoche = System.currentTimeMillis();

        {
            for (int i = 0; i < 1000; i++) {
                System.out.println("El hilo " + Thread.currentThread().getName() + " va por la vuelta " + i);

            }
        }

        long tiempofinalCoche = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName().equals("Coche1") + " ha acabado y ha tardado : " + (tiempofinalCoche - tiempoinicialCoche));
        System.out.println(Thread.currentThread().getName().equals("Coche2") + " ha acabado y ha tardado : " + (tiempofinalCoche - tiempoinicialCoche));
        System.out.println(Thread.currentThread().getName().equals("Coche3") + " ha acabado y ha tardado : " + (tiempofinalCoche - tiempoinicialCoche));
        System.out.println(Thread.currentThread().getName().equals("Coche4") + " ha acabado y ha tardado : " + (tiempofinalCoche - tiempoinicialCoche));
        System.out.println(Thread.currentThread().getName().equals("Coche5") + " ha acabado y ha tardado : " + (tiempofinalCoche - tiempoinicialCoche));
        System.out.println("Ya han acabado todos los coches");
    }
}
