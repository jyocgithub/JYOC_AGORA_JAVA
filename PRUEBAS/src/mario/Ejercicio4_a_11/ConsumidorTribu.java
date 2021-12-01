package mario.Ejercicio4_a_11;

public class ConsumidorTribu extends Thread{
    String nombre;
    MonitorOlla monitorOlla;

    public ConsumidorTribu(String nombre, MonitorOlla monitorOlla) {
        this.nombre = nombre;
        this.monitorOlla = monitorOlla;
    }

    @Override
    public void run()
    {
        for (int i = 0; i < 20; i++)
        {
            monitorOlla.retirarMisionero(nombre);
            System.out.println("Un salvaje coge un misionero");
        }

    }
}

