package mario.Ejercicio4_a_2;

import java.util.ArrayList;

public class MonitorAlmacen {

    ArrayList<String> mesa = new ArrayList<>();

    int MAX_NUM_PATAS = 50;
    int MAX_NUM_TABLEROS = 100;

    public synchronized void añadirPatas(String nombre){
        // CONTROLAMOS SI HEMOS DE PARARNOS CON UN WHILE, Y SI HEMOS DE PARARNOS, WAIT
        while(mesa.size()== MAX_NUM_PATAS){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // HACEMOS NUESTRAS COSAS
        mesa.add("1 pata");
        System.out.println("Productor " + nombre + " ha puesto una pata");

        // LIBRERAMOS A OTROS
        notifyAll();

    }

    public synchronized void retirarPatas(String nombre){

        // CONTROLAMOS SI HEMOS DE PARARNOS CON UN WHILE, Y SI HEMOS DE PARARNOS, WAIT
        while(mesa.size()==0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // HACEMOS NUESTRAS COSAS
        String patasQueQuedan = mesa.remove(0);
        System.out.println("El prodcutor de patas " + nombre + " ha sacado : " + patasQueQuedan);

        // LIBRERAMOS A OTROS
        notifyAll();


    }

    public synchronized void añadirTableros(String nombre){
        // CONTROLAMOS SI HEMOS DE PARARNOS CON UN WHILE, Y SI HEMOS DE PARARNOS, WAIT
        while(mesa.size()== MAX_NUM_TABLEROS){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // HACEMOS NUESTRAS COSAS
        mesa.add( "1 tablero");
        System.out.println("Productor " + nombre + " ha puesto una pata");

        // LIBRERAMOS A OTROS
        notifyAll();

    }

    public synchronized void retirarTableros(String nombre){

        // CONTROLAMOS SI HEMOS DE PARARNOS CON UN WHILE, Y SI HEMOS DE PARARNOS, WAIT
        while(mesa.size()==0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // HACEMOS NUESTRAS COSAS
        String patasQueQuedan = mesa.remove(0);
        System.out.println("El prodcutor de patas " + nombre + " ha sacado : " + patasQueQuedan);

        // LIBRERAMOS A OTROS
        notifyAll();


    }



}
