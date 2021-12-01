package mario.Ejercicio4_a_11;

import java.util.ArrayList;

public class MonitorOlla {

   ArrayList<String> saco = new ArrayList<>();



    public synchronized void añadirMsionero(String nombre){
        // CONTROLAMOS SI HEMOS DE PARARNOS CON UN WHILE, Y SI HEMOS DE PARARNOS, WAIT
        while(saco.size()== 5){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // HACEMOS NUESTRAS COSAS
        saco.add("+1 nuevo misionero");
        System.out.println("Cocinero " + nombre + " ha cocinado un misionero");

        // LIBRERAMOS A OTROS
        notifyAll();

    }

    public synchronized void retirarMisionero(String nombre){

        // CONTROLAMOS SI HEMOS DE PARARNOS CON UN WHILE, Y SI HEMOS DE PARARNOS, WAIT
        while(saco.size()==0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("Olla vacia, despertar al cocinero");
            }
        }

        // HACEMOS NUESTRAS COSAS
        String misionerosRestantes = saco.remove(0);
        System.out.println("El salvaje " + nombre + " ha sacado : " + misionerosRestantes);

        // LIBRERAMOS A OTROS
        notifyAll();


    }

}
