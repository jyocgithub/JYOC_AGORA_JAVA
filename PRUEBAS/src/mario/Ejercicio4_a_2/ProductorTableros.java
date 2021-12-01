package mario.Ejercicio4_a_2;

public class ProductorTableros extends Thread {
    int MAX_NUM_TABLEROS = 10;
    int TIEMPO_TABLERO = 500;
    String nombre;
    MonitorAlmacen monitorAlmacen;
    
    public ProductorTableros(String nombre, MonitorAlmacen monitorAlmacen) {
        this.nombre = nombre;
        this.monitorAlmacen = monitorAlmacen;
    }

    @Override
    public void run() 
    {
        try {
            Thread.sleep(TIEMPO_TABLERO);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 2; i++)
        {
            monitorAlmacen.añadirTableros(nombre);
        }
    }
}
