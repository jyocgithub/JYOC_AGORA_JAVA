package plantilla_dao;


import java.util.Calendar;
import java.util.Date;

public class Pruebas {


    public static void main(String[] args) {

        Calendar cc = Calendar.getInstance();
        Date hoyEnDate = cc.getTime();


        GestorBBDD gestor = new GestorBBDD();

//        gestor.altaTablas();

        gestor.altaPelicula(new Pelicula(1,"EL PADRINO",gestor.dateUTILtoSQL(hoyEnDate)));
        gestor.borrarTitulosRepetidos("EL PADRINO");





    }
}
