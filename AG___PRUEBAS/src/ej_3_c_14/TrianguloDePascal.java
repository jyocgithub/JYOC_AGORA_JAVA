package ej_3_c_14;

import java.util.Scanner;


public class TrianguloDePascal {


    public static void main(String[] args) {

        System.out.println("Indica el numero a procesar");
        int n = new Scanner(System.in).nextInt();

        pascal(n);


    }


    public static void pascal( int nfilas) {

        int[] filaanterior = new int[1];
        for (int i = 1; i <= nfilas; i++) {
            int[] filaactual = new int[i];
            for (int j = 0; j < i; j++) {
                if (j == 0 || j == (i - 1)) {  //es el primer o ultimo numero de cada fila
                    filaactual[j] = 1;
                } else {                       // es un numero intermedio de cada fila
                    filaactual[j] = filaanterior[j] + filaanterior[j - 1];
                }
                System.out.print(filaactual[j] + "\t");
            }
            filaanterior = filaactual;
            System.out.println();
        }
    }

}
