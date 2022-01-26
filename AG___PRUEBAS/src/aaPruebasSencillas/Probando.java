package aaPruebasSencillas;

import sun.jvm.hotspot.tools.SysPropsDumper;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Probando {

    public static void main(String[] args) {
        Scanner palabra = new Scanner(System.in);
        System.out.println("Dime tu nombre");
        String nombre = palabra.nextLine();
        System.out.println("Dime tu primer apellido");
        String apellido_1 = palabra.nextLine();
        System.out.println("Dime tu segundo apellido");
        String apellido_2 = palabra.nextLine();

        String nombreEntero = "";
        nombreEntero = nombreEntero + nombre.charAt(0) + apellido_1.charAt(0) + apellido_2.charAt(0);
        System.out.println("\"" + nombreEntero + "\"");


//        Scanner sc = new Scanner(System.in);
//
//
//        String res = sc.next();
//
//        System.out.println(res);
//
//        ArrayList<String> lista = new ArrayList<>();
//        lista.add("PEPE");
//        lista.add("ANA");
//        lista.add("EVA");
//
//        for (String s : lista) {
//            String cadanombre = s;
//        }


//        System.out.println("primero los numeros al azar-----------");
//        Random maquina = new Random();
//        int[] numeros = new int[10];
//        for (int k = 0; k < 10; k++) {
//            numeros[k] = maquina.nextInt(101);
//        }
//
//        System.out.println("ahora los cuadrados-----------");
//        int[] cuadrado = new int[10];
//        for (int k = 0; k < 10; k++) {
//            cuadrado[k] = numeros[k] * numeros[k];
//        }
//
//        System.out.println("ahora los cubos-----------");
//        int[] cubos = new int[10];
//        for (int k = 0; k < 10; k++) {
//            cubos[k] = numeros[k] * numeros[k] * numeros[k];
//        }
//        System.out.println("ahora los imprimo en columnas -----------");
//        for (int k = 0; k < 10; k++) {
//            System.out.println(numeros[k] + " "+ cuadrado[k] + " " + cubos[k]);
//        }
    }
}




