package cap03;

import java.util.Scanner;

/**
 * Ejercicios de Guiones de Curso Java SE
 * <p>
 *
 * @author Iñaki Martin
 */

/**
 * Capitulo 3 Ejercicio a_2
 * Programa que muestre los números del 1 al 100, pero sin mostrar los múltiplos de 7
 */
public class Jyoc_Ejercicio_3_a_02 {

    public static void main(String[] args) {

        int num = 1;
        while (num <= 100) {
            if (num % 7 != 0) {
                System.out.println(num);
            }
            num++;
        }
    }
}
