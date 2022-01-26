import java.util.Scanner;

public class ClaseMetodos {




    public static void sumar(int a, int b) {
        int suma = a + b;
        System.out.println(suma);
    }

    public static int sumar2(int a, int b) {
        int suma = a + b;
        return suma;
    }

    public static int sumar2(int a, int b, int c) {
        int suma = a + b + c;
        return suma;
    }





    public static void hacercosas(int x){

    }


    public static String leerCadena(String mensaje) {
        System.out.println(mensaje);
        Scanner sc = new Scanner(System.in);
        String texto = sc.nextLine();
        return texto;
    }



    public static int leerInt(String mensaje) {
        System.out.println(mensaje);
        Scanner sc = new Scanner(System.in);
        int res = sc.nextInt();
        return res;
    }



    public static void multiplicar(int a, int b) {
        int suma = a * b;
        System.out.println(suma);
    }



    public static void main(String[] args) {

        String cad1 = leerCadena("dime el primer numero");
        String cad2 = leerCadena("dime el segundo numero");
        String cad3 = leerCadena("dime un numero");

        System.out.println("instruccion antes de llamar a sumar");

        System.out.println(5+8);
        System.out.println(452345234);
        System.out.println("qwefqerf");
        System.out.println(5+8);
//        System.out.println(s);

        sumar(542345,9626244);

        int s0 = sumar2(5452345,963456);
        int s1 = sumar2(5452345,963456,346543);



//        System.out.println(s);


//        sumar(6,1);
//        sumar(8,2);
//
//        int x=12;
//        int k = 45;
//        sumar(x,k);
//
//        multiplicar(4,8);
//
//        System.out.println("instruccion tras llamar a sumar");



//        Scanner entrada = new Scanner(System.in);
//        int a =-1 , b = -1, c = -1, suma = 0;
//
//        while (a < 0) {
//            System.out.println("Dime un numero");
//            a = entrada.nextInt();
//            if (a < 0) {
//                System.out.println("no puede ser negativo");
//            }
//        }
//        suma = suma + a;
//
//
//        while (b < 0) {
//            System.out.println("Dime un número");
//            b = entrada.nextInt();
//            if (b < 0) {
//                System.out.println("no puede ser negativo");
//            }
//        }
//        suma = suma + b;
//
//
//
//        while (c < 0) {
//            System.out.println("Dime un número");
//            c = entrada.nextInt();
//            if (c < 0) {
//                System.out.println("no puede ser negativo");
//            }
//        }
//        suma = suma + c;
//
//
//        System.out.println("la suma de los tres es " + suma);

    }


}

