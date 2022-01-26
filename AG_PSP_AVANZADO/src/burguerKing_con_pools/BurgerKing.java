/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package burguerKing_con_pools;

/**
 *
 * @author cristiandiaz
 */
public class BurgerKing {

    //private Semaphore almacen;
    public BurgerKing() {
        //almacen = new Semaphore(10, true);

    }

    public void acceder(Coche coche) {
//        try {
//            //almacen.acquire();
//            System.out.println("Acaba de entrar el coche: "+coche.getIdCoche());
//
//        } catch (InterruptedException ex) {
//
//        }
        System.out.println("Acaba de entrar el coche: " + coche.getIdCoche());

    }

    public void salir(Coche coche) {

        //almacen.release();
        System.out.println("Acaba de salir el coche: " + coche.getIdCoche());

    }

}
