package ej_psp_5_a_4_cena_filosofos_sin_semaforos;

public class CenaFilosofos {
    public static void main(String args[]) {
        System.out.println("Cena de los Filosofos");
        Cena cena = new Cena();
        for (int i = 0; i < 5; i++) {
            Filosofo pensante = new Filosofo(i, cena);
        }
    }

}

//////// monitor
class Cena {

    Tenedor tenedores[];
    int parametro = 5;         //numero de filosofos y tenedores

    //constructor cena
    public Cena() {
        tenedores = new Tenedor[parametro];
        for (int i = 0; i < 5; i++) {
            tenedores[i] = new Tenedor(i);
        }
    }

    public Tenedor getTenedor(int x) {
        return tenedores[x];
    }

    public int getTenedorDer(int x) {
        return (x + 1) % parametro;
    }

    public int getTenedorIzq(int x) {
        return x;
    }

}

///////////////////////clase Tenedor

class Tenedor {

    int numero;
    boolean enUso;

    public Tenedor(int x) {
        numero = x;
    }

    synchronized public void usar() { // synchronized : para no usar este metodo simultaneamente
        if (enUso) {
            System.out.println("Tenedor " + numero + " esta en uso, espera");
        } else {
            enUso = true;
            System.out.println("Se esta usando el tenedor " + numero);
        }
    }

    synchronized public void dejar() {
        enUso = false;
        System.out.println("Tenedor " + numero + " esta ahora disponible");
    }

}

////////////////////// clase hilo Filosofo
class Filosofo implements Runnable {

    private Thread hilo;
    protected Cena cena;
    protected int tizq, tder;
    protected int numero;

    public Filosofo(int x, Cena cena) {
        this.numero = x;
        this.cena = cena;
        tizq = cena.getTenedorIzq(numero);
        tder = cena.getTenedorDer(numero);
        hilo = new Thread(this);
        hilo.start();
    }

    public void run() {
        while (true) {
            pensar();
            tomarTenedores();
            comer();
            dejarTenedores();
        }
    }

    public void pensar() {
        try {
            System.out.println("Filosofo " + numero + " pensando");
            int espera = (int) (Math.random() * 400);
            hilo.sleep(espera);
            System.out.println("Filosofo " + numero + " tiene hambre");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void tomarTenedores() {
        System.out.println("Tomando tenedores");
        Tenedor t1 = cena.getTenedor(tizq);
        Tenedor t2 = cena.getTenedor(tder);
        t1.usar();
        t2.usar();
    }

    public void comer() {
        try {
            System.out.println("Filosofo " + numero + " esta comiendo");
            int espera = (int) (Math.random() * 600);
            hilo.sleep(espera);
            System.out.println("Filosofo " + numero + " esta satisfecho");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected void dejarTenedores() {
        System.out.println("Soltando los tenedores.");
        Tenedor t1 = cena.getTenedor(tizq);
        Tenedor t2 = cena.getTenedor(tder);
        t1.dejar();
        t2.dejar();
    }


}
