package mario.Ejercicio4_a_2;

public class Consumidor extends Thread {
    int TIEMPO_MESA = 500;
    String nombre;
    MonitorAlmacen monitorAlmacen;

    public Consumidor(String nombre, MonitorAlmacen monitorAlmacen) {
        this.nombre = nombre;
        this.monitorAlmacen = monitorAlmacen;
    }

    @Override
    public void run() 
    {

        try {
            Thread.sleep(TIEMPO_MESA);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 2; i++)
        {
            monitorAlmacen.retirarPatas(nombre);
        }

        for (int i = 0; i < 1; i++)
        {
            monitorAlmacen.retirarTableros(nombre);
        }


        System.out.println("Emsamblador ha hecho una mesa");
    }
}
