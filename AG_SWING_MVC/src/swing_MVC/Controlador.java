package swing_MVC;

import javax.swing.*;
import java.util.ArrayList;

public class Controlador {

    Modelo modelo;

    public Controlador() {
        this.modelo = new Modelo();
    }

    public boolean accesocorrecto(String nom, String pass) {
        if (nom.equals("pepe") && pass.equals("123")) {
            return true;
        }
        return false;
    }


    public String[][] crearDatosTabla() {

        // CREAR ARRAYLIST CON LOS DATOS
        ArrayList<Empleado> lista = modelo.leerEmpleados();

        // CREAR MATRIZ CON LOS DATOS DEL ARRAYLIST
        String[][] mat = new String[lista.size()][2];
        for (int f = 0; f < lista.size(); f++) {
            for (int c = 0; c < 2; c++) {
                mat[f][0] = lista.get(f).getNIF();
                mat[f][1] = lista.get(f).getNombre() + "";
            }
        }
        return mat;

    }

    public String[] crearCabeceraTabla() {
        // CREAR ARRAY DE CABECERAS
        String[] cabeceras = {"1", "2"};
        return cabeceras;
    }


}
