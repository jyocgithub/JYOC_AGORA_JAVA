/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package burguerKing_con_pools;


import java.util.concurrent.Callable;

/**
 *
 * @author cristiandiaz
 */
public class Coche implements Callable<Boolean> {

    private int id;
    private BurgerKing bg;

    public Coche(int id, BurgerKing bg) {
        this.id = id;
        this.bg = bg;
    }

    public int getIdCoche() {
        return id;
    }

    public Boolean call() {
        bg.acceder(this);
        try {
            Thread.sleep(3000);
            bg.salir(this);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        return null;

    }

}
