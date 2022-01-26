package barriers;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class EsperarEnMainConBarriers {
    public static void main(String args[]) {
        new EsperarEnMainConBarriers();
    }


    public EsperarEnMainConBarriers() {
        CyclicBarrier barrera = new CyclicBarrier(5);
        Hilo t = null;


        Hilo[] hilos = new Hilo[4];

        for (int i = 0; i < 4; i++) {
            t = new Hilo(i, barrera);
            t.start();
            hilos[i] = t;
        }

        try {
            barrera.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println("FIN");
    }
}


class Hilo extends Thread {
    CyclicBarrier barrera;
    private int num;

    public Hilo(int num, CyclicBarrier barrera) {
        this.num = num;
        this.barrera = barrera;
    }

    public void run() {
        try {
            System.out.println("El hilo " + num + " arranca y espera");
            Thread.sleep(new Random().nextInt(1000) + 1000);
            System.out.println("El hilo " + num + " acabo");
            barrera.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}