package barriers;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class EsperarEnMainConBarriers2 {
    public static void main(String args[]) {
        Hilo2 t = null;

        Compartida compartida = new Compartida();

        Hilo2[] hilos = new Hilo2[4];

        for (int i = 0; i < 4; i++) {
            t = new Hilo2(i, compartida);
            t.start();
            hilos[i] = t;
        }

        try {
            compartida.barrera.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println("FIN");
    }
}


class Hilo2 extends Thread {
    private int num;
    Compartida compartida;
    public Hilo2(int num, Compartida compartida) {
        this.num = num;
        this.compartida = compartida;
    }

    public void run() {
        try {
            System.out.println("El hilo " + num + " arranca y espera");
            Thread.sleep(new Random().nextInt(1000) + 1000);
            System.out.println("El hilo " + num + " acabo");
            compartida.barrera.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}

class Compartida{
    CyclicBarrier barrera = new CyclicBarrier(5);

}
