package mario.Ejercicio4_a_2;

public class ProductorPatas extends Thread {
    int MAX_NUM_PATAS = 5;
    int TIEMPO_PATA = 500;
    String nombre;
    MonitorAlmacen monitorAlmacen;

    public ProductorPatas(String nombre, MonitorAlmacen monitorAlmacen) {
        this.nombre = nombre;
        this.monitorAlmacen = monitorAlmacen;
    }

    @Override
    public void run()
    {
        try {
            Thread.sleep(TIEMPO_PATA);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 4; i++)
        {
            monitorAlmacen.añadirPatas(nombre);
        }

    }
}
