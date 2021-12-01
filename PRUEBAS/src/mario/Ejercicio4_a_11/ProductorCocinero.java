package mario.Ejercicio4_a_11;

public class ProductorCocinero extends Thread {
    String nombre;
    MonitorOlla monitorOlla;

    public ProductorCocinero(String nombre, MonitorOlla monitorOlla) {
        this.nombre = nombre;
        this.monitorOlla = monitorOlla;
    }

    @Override
    public void run()
    {
        for (int i = 0; i < 20; i++)
        {
            monitorOlla.añadirMsionero(nombre);
        }
    }
}
