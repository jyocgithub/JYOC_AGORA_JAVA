/**
 * @author IMS
 * <p>
 * INDICE DE METODOS
 * <p>
 * stringToBoolean () - Devuelve true si el parametro es T, TRUE, S o SI
 * leerIntScanner () - Devuelve un int leido por Scanner por System.in
 * leerStringTeclado (String mens) - Lee String por teclado (BufferedReader)
 */
public class JYOCUtils {


    /**
     * RELLENAR CON BLANCOS
     * <p>
     * Rellena con blancos a la derecha una cadena , hasta el tamaño indicado parametro. Si la el tamaño es mas pequeño que la
     * cadena original recorta esta dejando solo el tamaño solicitado
     * <p>
     * Ejemplos rellenar("hola",4) -> da "hola    " rellenar("",3) -> da "   " rellenar("1234567",4) -> da "1234"
     *
     * @param cadenaARellenar cadena que se desea ampliar tamano
     * @param tamano          tamaño de la cadena final
     */
    static public String rellenarConBlancos(String cadenaARellenar, int tamano) {
        String resultado = cadenaARellenar;
        int cuantos = tamano - cadenaARellenar.length();
        if (cuantos < 1 || tamano < 1) return cadenaARellenar;
        if (cadenaARellenar.length() > tamano) return cadenaARellenar.substring(tamano);
        for (int i = 0; i < cuantos; i++)
            resultado += " ";
        return resultado;
    }


    /**
     * RELLENAR CON PATRON
     * <p>
     * Rellena con UN CARACTER definido a la derecha una cadena , hasta el tamaño indicado parametro. Si la el tamaño es mas pequeño
     * que la cadena original recorta esta dejando solo el tamaño solicitado
     * <p>
     * Ejemplos rellenar("hola",4) -> da "hola    " rellenar("",3) -> da "   " rellenar("1234567",4) -> da "1234"
     *
     * @param cadenaARellenar -> cadena que se desea ampliar
     * @param tamano          -> tamaño de la cadena final
     * @param patron          -> cadena de relleno
     * @param orientacion     -> true rellena por delante de la cadena parametro, false rellena por el final
     * @author Iñaki Martin
     */
    static public String rellenarConPatron(String cadenaARellenar, int tamano, String patron, boolean orientacion) {
        int cuantos = tamano - cadenaARellenar.length();
        if (cuantos < 1 || tamano < 1 || patron.length() > 1) return cadenaARellenar;
        if (cadenaARellenar.length() > tamano) return cadenaARellenar.substring(tamano);
        String relleno = "";
        for (int i = 0; i < cuantos; i++)
            relleno += patron;
        return (orientacion ? relleno + cadenaARellenar : cadenaARellenar + relleno);
    }



    /**
     * Metodo que devuelve un numero con ceros por delante
     *
     * @param : numero original - el numero que se desea convertir
     * @param : numeroDeCharTamanoFinal - el tamaño final de la cadena a devolver, con ceros a la izquierda
     * @author: Iñaki Martin
     * @return: String con el numero con ceros por delante
     * <p>
     * Si el numero a convertir es mayor que el tamaño de la cadena solicitada, devuelve el numero original Ejemplos:
     * stringConCeros(3, 5) -> 00003 stringConCeros(3234, 8)); -> 00003234 stringConCeros(322, 2) -> 322
     */
    static public String stringConCeros(int numeroOriginal, int numeroDeCharTamanoFinal) {
        int intMaximo = (int) Math.pow(10, numeroDeCharTamanoFinal);
        if (numeroOriginal > intMaximo) return Integer.toString(numeroOriginal);
        return Integer.toString(numeroOriginal + (intMaximo)).substring(1);
    }




    /**
     * intAleatorio
     * <p>
     * DEVUELVEN UN ENTERO ALEATORIO EN UN RANGO DETERMINADO
     */
    static public int intAleatorio(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }


    // ****************************************************************
    // ZONA DE PRUEBAS DE LOS METODOS

    public static void main(String[] s) {
    }

}
