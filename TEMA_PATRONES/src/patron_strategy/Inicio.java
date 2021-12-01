package patron_strategy;

import java.util.ArrayList;
import java.util.List;




/*

Propone usar clases distintas, unida por herencia de una interfaz, a distintos comportamientos
que ha de tomar el programa
En el ejemplo un catalogo de vehiculos se puede escribir en pantarlla linea a linea, o tres vehiculos por linea
Pintamos el catalogo con el método dibuja() de VistaCatalogo, a quien al construirse, le pasamos un objeto de una clase
distinta segun como deseemos pintar

 */



public class Inicio {
    public static void main(String[] args) {

        VistaCatalogo vistaCatalogo1 = new VistaCatalogo(new DibujaTresVehiculosPorLinea());
        vistaCatalogo1.dibuja();

        VistaCatalogo vistaCatalogo2 = new VistaCatalogo(new  DibujaUnVehiculoPorLinea());
        vistaCatalogo2.dibuja();
    }
}


//******************************************************************************
//******************************************************************************

class VistaCatalogo {

    protected List<VistaVehiculo> contenido = new ArrayList<VistaVehiculo>();

    protected DibujaCatalogo dibujo;

    public VistaCatalogo(DibujaCatalogo dibujo) {
        contenido.add(new VistaVehiculo("vehiculo economico"));
        contenido.add(new VistaVehiculo("vehiculo amplio"));
        contenido.add(new VistaVehiculo("vehiculo rapido"));
        contenido.add(new VistaVehiculo("vehiculo confortable"));
        contenido.add(new VistaVehiculo("vehiculo deportivo"));
        this.dibujo = dibujo;
    }

    public void dibuja() {
        dibujo.dibuja(contenido);
    }
}


//******************************************************************************
//******************************************************************************

class VistaVehiculo {

    protected String descripcion;

    public VistaVehiculo(String descripcion) {
        this.descripcion = descripcion;
    }

    public void dibuja() {
        System.out.print(descripcion);
    }

}


//******************************************************************************
//******************************************************************************
interface DibujaCatalogo {
    void dibuja(List<VistaVehiculo> contenido);
}

//******************************************************************************
//******************************************************************************
class DibujaUnVehiculoPorLinea implements DibujaCatalogo {

    public void dibuja(List<VistaVehiculo> contenido) {
        System.out.println("Dibuja los vehiculos mostrando un vehiculo por linea");
        for (VistaVehiculo vistaVehiculo : contenido) {
            vistaVehiculo.dibuja();
            System.out.println();
        }
    }
}

//******************************************************************************
//******************************************************************************
class DibujaTresVehiculosPorLinea implements DibujaCatalogo {

    public void dibuja(List<VistaVehiculo> contenido) {
        System.out.println("Dibuja los vehiculos mostrando tres vehiculos por linea");
        int contador = 0;
        for (VistaVehiculo vistaVehiculo : contenido) {
            vistaVehiculo.dibuja();
            contador++;
            if (contador % 3 == 0) {
                System.out.println();
            } else
                System.out.print(" ");
        }
        System.out.println();
    }
}

//******************************************************************************
//******************************************************************************
