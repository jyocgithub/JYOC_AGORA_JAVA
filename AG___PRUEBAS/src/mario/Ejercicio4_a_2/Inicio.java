package mario.Ejercicio4_a_2;

public class Inicio
{
    public static void main(String[] args)
    {
        MonitorAlmacen monitorAlmacen = new MonitorAlmacen();

        ProductorTableros productorTableros1 = new ProductorTableros("Tableros Pepe", monitorAlmacen);
        ProductorTableros productorTableros2 = new ProductorTableros("Tableros Oscar", monitorAlmacen);

        ProductorPatas productorPatas1 = new ProductorPatas("Patas Manuel", monitorAlmacen);
        ProductorPatas productorPatas2 = new ProductorPatas("Patas Jose", monitorAlmacen);
        ProductorPatas productorPatas3 = new ProductorPatas("Patas Alberto", monitorAlmacen);
        ProductorPatas productorPatas4 = new ProductorPatas("Patas Eduardo", monitorAlmacen);


        productorTableros1.start();
        productorTableros2.start();
        productorPatas1.start();
        productorPatas2.start();
        productorPatas3.start();
        productorPatas4.start();
    }
}
