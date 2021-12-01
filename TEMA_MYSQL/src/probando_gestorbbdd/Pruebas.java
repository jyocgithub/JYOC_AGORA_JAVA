package probando_gestorbbdd;


import java.util.Calendar;
import java.util.Date;

public class Pruebas {


    public static void main(String[] args) {

        Calendar cc = Calendar.getInstance();
        Date hoyEnDate = cc.getTime();


        GestorBBDDCopia gestor = new GestorBBDDCopia();

//        gestor.altaTablas();

        gestor.altaPelicula(new Pelicula(1,"EL PADRINO",gestor.dateUTILtoSQL(hoyEnDate)));
        gestor.borrarTitulosRepetidos("EL PADRINO");





    }
}
