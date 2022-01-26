import java.util.ArrayList;
import java.util.Scanner;

// CLASE
public class FernandoMetodos {


    // METODOS - miniprograma
    public static void main(String[] args) {

//
//        int j = 2;
//        Integer i = new Integer(345);
//        j = i;
//        i = j;
//
//        ArrayList<Integer> lista = new ArrayList<>();
//
//        lista.add(1);
//        lista.add(2);
//        lista.add(3);
//        int k = 34;
//        lista.add(34);
//        lista.add(2, 346);
//        lista.remove(2);
//        int h = lista.get(1);
//        //  lista.clear();
//        lista.contains(33);
//        lista.isEmpty();
//        lista.size();
//        lista.set(3,234);
//
//        for (int s = 0; s < lista.size(); s++) {
//
//            int kkk = lista.get(s);
//            System.out.println(kkk);
//
//        }
//
//        for ( Integer www   :  lista    ){
//            System.out.println(www);
//        }
//
//
//
//        // SETS
//
//        TreeSet<String> conj = new TreeSet<>();
//        conj.size();
//        conj.add("svfdfv ");
//        conj.add("dtfgr ");
//        conj.add("rf we ");
//        conj.add("d fgb ");
//        conj.add("d gfb ");
//        boolean hePodido =  conj.remove("kaa");
//        conj.contains("Pepa");
//
//        for ( String ww   :  conj    ){
//            System.out.println(ww);
//        }


        System.out.println("Hola");
        System.out.print("Hola");

        Scanner sc = new Scanner(System.in);
        String lin = sc.nextLine();  // leer un String
        int i = sc.nextInt();  // leer un int
        sc.nextLine();   // limpiar el buffer tras leer un int



    }



    public void pintar(ArrayList<Integer> lista){
        for (int s = 0; s < lista.size(); s++) {
            System.out.println(lista.get(s));
        }
    }



}