package ej_3_a_14;
import java.util.Scanner;
public class Inicio {

    public static void main(String[] args) {

        System.out.println("Indica el numero a procesar");
        int n = new Scanner(System.in).nextInt();
        do {
            if (n % 2 == 0) {
                n = n / 2;
                System.out.println(n);
            }else{
                n = n * 3;
                n = n + 1;
                System.out.println(n);
            }
        } while(n!=1);

    }
}
