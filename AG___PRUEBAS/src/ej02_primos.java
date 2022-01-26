import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class ej02_primos {

    public static void main(String[] args) {

        File fichero = new File("ficheroPrimos.datos");
        escribirPrimos(fichero);
        leerBinario(fichero);
    }

    public static void escribirPrimos(File fichero) {

        FileOutputStream fos = null;
        DataOutputStream dos = null;

        int contador = 0;

        try {
            fos = new FileOutputStream(fichero);
            dos = new DataOutputStream(fos);

            for (int i = 0; i < 10; i++) {
                int num = i;
                if (esprimo(num)) {
                    contador++;
                    dos.writeInt(num);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        leerBinario(fichero);
    }

    public static boolean esprimo(int num) {

        int cont = 0;
        if (num == 1) {
            return true;
        }
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                cont++;
            }
        }
        if (cont == 2) {
            return true;
        }
        return false;
    }

    public static void leerBinario(File fichero) {

        FileInputStream fis = null;
        DataInputStream dis = null;

        try {
            fis = new FileInputStream(fichero);
            dis = new DataInputStream(fis);

            while (true) {
                System.out.println(dis.readInt());
            }

        } catch (EOFException e) {

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
                dis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}






























