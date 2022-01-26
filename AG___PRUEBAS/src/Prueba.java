import envio_ficheros_udp.ProcesarFicherosConBytes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;


public class Prueba {

    public static void main(String[] args) throws IOException {


        String s = "A";
        s = "B";
        String z = s;
        s = "C";
        System.out.println(s);
        System.out.println(z);

        Algo ss = new Algo(3);
        ss.indice = 5;
        Algo zz = ss;
        ss.indice = 21;

        System.out.println(ss.indice);
        System.out.println(zz.indice);


//        String directorioParaLeer = ".";
//        String directorioParaEscribir = "./copia";
//        if (directorioParaLeer.equals(directorioParaEscribir)) {
//            System.out.println("los directorios no pueden ser iguales");
//            return;
//        }
//
//        File directorio = new File(directorioParaLeer);
//        File[] ficherosExistentes = directorio.listFiles();
//
//        for (int f = 0; f < ficherosExistentes.length; f++) {
//            File cadaelementodeldirectorio = ficherosExistentes[f];
//            if (cadaelementodeldirectorio.isFile()) {
//                String nombrefich = cadaelementodeldirectorio.getName();
//                byte[] ficheroleido = ProcesarFicherosConBytes.leerArchivoEnBytes(directorioParaLeer, nombrefich);
//                ProcesarFicherosConBytes.escribirArchivoConBytes(directorioParaEscribir, nombrefich, ficheroleido);
//            }
//        }


//        int x;
//        System.out.println(x=6);
//
//        boolean b;
//        if( b = (5>1)){
//            System.out.println("dentro");
//        }
//
//        BufferedReader br = null;
//        try {
//            br = new BufferedReader(new FileReader("cosas.txt"));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        String lineaLeida ;
//        while ( (lineaLeida = br.readLine()) !=  null){
//            System.out.println( lineaLeida );
//        }
//        Socio soc1 = new Socio();
//        Socio soc2 = new Socio();
//        Socio soc3 = new Socio();
//
//        soc1.setNombre("Angerine");
//        soc1.setAntiguedad(3);
//        soc2.setNombre("Jorge");
//        soc2.setAntiguedad(8);
//        soc3.setNombre("Irene");
//        soc3.setAntiguedad(5);
//        Club club1 = new Club(soc1, soc2, soc3);
//        System.out.println(club1);
//        System.out.println(club1.SocioMayorAntiguedad());

        // AÑADIR UNA FACTURA AL FINAL Y LUEGO LEERLA

        RandomAccessFile raf = null;

        try {

            raf = new RandomAccessFile("pepepote.bin", "rw");
            // ME PONGO AL FINAL
            raf.seek(raf.length());

            String dninuevo = rellenaString("34344545K", 20);
            raf.writeChars(dninuevo);
            raf.writeDouble(7);
            raf.writeChars(dninuevo);
            raf.writeDouble(53);
            raf.writeChars(dninuevo);
            raf.writeDouble(33);
            raf.writeChars(dninuevo);
            raf.writeDouble(1234);
            raf.writeChars(dninuevo);
            raf.writeDouble(123);
            raf.writeChars(dninuevo);
            raf.writeDouble(6456);
            raf.writeChars(dninuevo);
            raf.writeDouble(47877);

            // ahora leo el recien añadido.... el ULTIMO ..........................................
            int cuantosRegistrosHay = (int) (raf.length() / 48);

            int posicionultimoregistro = (cuantosRegistrosHay - 1) * 48;
            raf.seek(posicionultimoregistro);
            String   dni = RAFreadChars(raf,20);
            double importe = raf.readDouble();
            System.out.println("NUEVO DNI : " + dni.trim());
            System.out.println("NUEVO Importe : " + importe);

            // ahora vamos a leer el 5 registro
            int posicion5 = (5 - 1) * 48;
            raf.seek(posicion5);
            dni = RAFreadChars(raf,20);
            importe = raf.readDouble();
            System.out.println("REG 5 DNI : " + dni.trim());
            System.out.println("REG 5 Importe : " + importe);

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {

                raf.close();
            } catch (IOException ex) {
            }
        }


    }


    public static String RAFreadChars(RandomAccessFile raf, int tamano) throws IOException {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < tamano; i++) {
            sb.append(raf.readChar());
        }
        return sb.toString();
    }
    public static String rellenaString(String cadenaoriginal, int tamano) {
        // por simplicidad, no se controla que 'tamano' sea menor
        // que el length de 'cadenaoriginal'     (aunque debería hacerse  :-)
        StringBuilder sb = new StringBuilder(cadenaoriginal);
        sb.setLength(tamano);
        return sb.toString();
    }

}


class Algo {
    int indice;

    public Algo(int indice) {
        this.indice = indice;
    }
}