package cap03;

import java.util.Scanner;

/**
 * Ejercicios de Guiones de Curso Java SE
 * <p>
 * @author Iñaki Martin
 */

/**
 * Programa que lee por teclado números,  de manera continua,
 * hasta que se introducen dos números iguales seguidos.
 */
public class Jyoc_Ejercicio_3_a_16 {

     public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          boolean seguir = true;
          int n;
          System.out.println("Indique un numero:");
          n = sc.nextInt();
          int anterior=n;
          while (seguir) {
               System.out.println("Indique un numero:");
               n = sc.nextInt();
               if (n == anterior) {
                    seguir=false;
               }
               anterior=n;
          }
     }
}
