/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package burguerKing_con_pools;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author cristiandiaz
 */
public class Main {

    public static void main(String[] args) {
        BurgerKing bg = new BurgerKing();
        ExecutorService piscina = Executors.newFixedThreadPool(10);
        ArrayList<Coche> coches = new ArrayList<>();
        long tiempoInicio = System.currentTimeMillis();

        for (int i = 0; i < 30; i++) {
            Coche c = new Coche(i + 1, bg);
            coches.add(c);

        }

        //Callable w = Executors.callable(h);
        try{
            piscina.invokeAll(coches);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }

        long tiempoFinal = System.currentTimeMillis();
        long tiempoTotal = tiempoFinal - tiempoInicio;
        System.out.println("La ejecucion del programa ha sido: " + tiempoTotal + " Milisegundos.");
        piscina.shutdown();

    }

}
