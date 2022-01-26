package AeropuertoProCon;

import java.util.Random;

public class Aeropuerto {
    public static void main(String[] args) {
        Cinta c = new Cinta();
        Thread prod1 = new Thread(new CamionProductor(1, c));
        Thread prod2 = new Thread(new CamionProductor(2, c));
        Thread prod3 = new Thread(new CamionProductor(3, c));
        Thread con = new Thread(new CamionConsumidor(1, c));
        prod1.start();
        prod2.start();
        prod3.start();
        con.start();
    }
}


class Cinta {

    int numMaletas;

    public Cinta() {
        numMaletas = 0;
    }

    public synchronized void meterMaleta(int idcon) {
        while (numMaletas >= 10) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("soy " + idcon + " y  hay" + numMaletas);
        numMaletas++;
        notifyAll();
    }

    public synchronized void sacarMaleta() {

        while (numMaletas == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("soy consunmidor y  hay" + numMaletas);

        numMaletas--;
        notifyAll();
    }

}


class CamionProductor implements Runnable {

    int idconsumikdor;
    Cinta cc;

    public CamionProductor(int id, Cinta cc) {
        this.idconsumikdor = id;
        this.cc = cc;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cc.meterMaleta(idconsumikdor);
        }
    }
}

class CamionConsumidor implements Runnable {

    int id;
    Cinta cc;

    public CamionConsumidor(int id, Cinta cc) {
        this.id = id;
        this.cc = cc;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cc.sacarMaleta();
        }
    }
}
