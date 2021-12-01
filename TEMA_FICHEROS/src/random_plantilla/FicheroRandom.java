package random_plantilla;

import java.io.*;

public class FicheroRandom {


    private File fichero;
    private RandomAccessFile flujo;
    private int numRegistros;
    private long tamRegistro = 60; // no es int, es long, que eslo ue devuelve .length()

    public FicheroRandom(File fichero) {
        this.fichero = fichero;

        try {
            flujo = new RandomAccessFile(fichero, "rw"); //en modo lectura/escritura
            long numBytes = flujo.length();

            numRegistros = (int) Math.ceil((double) numBytes / (double) tamRegistro);
        } catch (IOException error) {
            System.out.println(error.getMessage());
        }
    }


    public Registro leerRegistro(int posicion) {

        if (posicion >= 0 && posicion < numRegistros) {

            try {
                //nos situamos en la posicion:
                flujo.seek(posicion * tamRegistro);

                //devuelve lo q hay en el registro (como son 3 cadenas necesitamos 3 read)
                String codigo = flujo.readUTF();
                String nombre = flujo.readUTF();
                String precio = flujo.readUTF();
                Registro reg = new Registro(codigo, nombre, precio);
                return reg;
            } catch (IOException error) {
                System.out.println(error.getMessage());
            }
        }
        return null;
    }

    private boolean escribirRegistro(int posicion, Registro nuevo) {

        // este metodo es llamado solo por anadirRegistro y modificarRegistro

        if (posicion >= 0 && posicion <= numRegistros) {
            try {
                flujo.seek(posicion * tamRegistro);
                //escribimos:
                flujo.writeUTF(nuevo.getCodigo());
                flujo.writeUTF(nuevo.getNombre());
                flujo.writeUTF(nuevo.getPrecio());

                return true;
            } catch (IOException error) {
                System.out.println(error.getMessage());
            }
        }
        return false;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////
    public boolean anadirRegistro(Registro nuevo) {

        if (escribirRegistro(numRegistros, nuevo)) { //xa q a�ada al final
            numRegistros++;
            return true;
        }
        return false;
    }

    public boolean modificarRegistro(int posicion, Registro nuevo) {
        if (posicion >= 0 && posicion <= numRegistros) {
            if (escribirRegistro(posicion, nuevo)) {
                return true;
            }
        }
        return false;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////
    public int buscar(String codigo) {

        //recorremos los registros:
        for (int i = 0; i < numRegistros; i++) {
            //creamos objeto de tipo Registro y lo leemos con el m�todo leer
            Registro registro = leerRegistro(i);
            //comparamos el codigo q le hemos pasado como par�metro con el codigo del objeto registro:
            if (codigo.equals(registro.getCodigo()))
                return i;
        }
        return -1;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////
    public void eliminar() {

        //xa borrarlo lo marcamos (ej con cadena vac�a
        //creamos un fichero aux, recorro la original y a�ado de la original lo q vale
        //metodo delete
        //metodo renamingTo xa cambiar nombre


    }


}
