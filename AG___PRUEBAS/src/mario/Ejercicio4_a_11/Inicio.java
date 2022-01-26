package mario.Ejercicio4_a_11;
/*
Un panadero va creando barras de pan.
Tarda 100 milisegundos en hacer un pan.
Cuando hace un pan, lo deposita en un cesto.
Por otro lado, un Dependiente va recogiendo una barra de pan del cesto,
y tarda 200 milisegundos en venderla.
Hacer un programa en el que el panadero construya 100 barras de pan,
y el dependiente las venda.
Cada vez que el panadero pone una barra en el cesto imprime un mensaje "he dejado una barra y hay x en el cesto",
y cada vez que el dependiente coge un barra dice "he cogido una barra y quedan x en el cesto"

Tener cuidado, no puede el dependiente sacar panes del cesto, si no hay panes en el cesto,
 y que el panadero no pueda meter mas de 5 panes en el cesto, pues en el cesto en realidad solo van a caber 5 panes.

 Una tribu de salvajes comparte una olla en la que caben X misioneros. Cuando algún salvaje quiere
comer, coge directamente un misionero de la olla, a no ser que esté vacía. Si la olla está vacía, el salvaje
despertará al cocinero y esperará a que éste haya llenado la olla con otros X misioneros. Implementar
la solución teniendo en cuenta que:
• No se debe producir interbloqueo.
• Los salvajes podrán comer siempre que haya comida en la olla.
• Solamente se despertará al cocinero cuando la olla esté vacía.

 */
public class Inicio {


    public static void main(String[] args)
    {

        MonitorOlla monitorOlla = new MonitorOlla();

        ProductorCocinero productorCocinero = new ProductorCocinero("Pepe", monitorOlla);

        ConsumidorTribu consumidorTribu = new ConsumidorTribu("EYYY",monitorOlla);

        productorCocinero.start();
        consumidorTribu.start();
    }
}
