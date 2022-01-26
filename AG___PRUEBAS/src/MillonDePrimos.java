import java.io.*;
import java.util.Scanner;

public class MillonDePrimos {

 // ----------------------------------------------------------------------------
    private static final int CUOTA = 120;
    private static final String FICHINDICE = "INDICE.TXT";
    private static final String FICHVALORES = "VALORES.TXT";
    private static int ultimonumerobuscado, totalencontrados, cuantosmas;

 // ----------------------------------------------------------------------------
    public static void main(String[] args) {
        numeroshastaahora();
        System.out.println("Tiene encontrados hasta ahora " + totalencontrados + " numeros primos.");
        System.out.println("¿Cuantos mas desea añadir?");
        Scanner sc = new Scanner(System.in);
        cuantosmas = sc.nextInt();
        if (anadir()) {
            System.out.println("Se han calculado todos los primos, que son:");
            mostrarPrimos();
        }
    }

 // ----------------------------------------------------------------------------
    public static boolean esPrimo(int num) {
        boolean es = true;
        for (int i = 2; i < Math.sqrt(num) && es == true; i++) {
            if (num % i == 0) {
                es = false;
            }
        }
        return es;
    }

 // ----------------------------------------------------------------------------
    public static boolean anadir() {
        boolean acabado = false;
        File findice = new File(FICHINDICE);
        File fvalores = new File(FICHVALORES);

        PrintWriter pwindice = null;
        PrintWriter pwvalores = null;
        try {
            pwindice = new PrintWriter(new FileWriter(findice));
            pwvalores = new PrintWriter(new FileWriter(fvalores, true));
            int x = totalencontrados + cuantosmas;
            while (totalencontrados < x && acabado == false) {
                ultimonumerobuscado++;
                if (esPrimo(ultimonumerobuscado)) {
                    pwvalores.print(ultimonumerobuscado + "");
                    pwvalores.print(",");
                    totalencontrados++;
                }
                if (totalencontrados == CUOTA) {
                    acabado = true;
                }
            }

            pwindice.println(ultimonumerobuscado);
            pwindice.println(totalencontrados);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (pwindice != null) {
                pwindice.close();
            }
            if (pwvalores != null) {
                pwvalores.close();
            }
        }
        return acabado;
    }


 // ----------------------------------------------------------------------------
    public static void numeroshastaahora() {

        File findice = new File(FICHINDICE);
        if (!findice.exists()) {
            return;
        }

        BufferedReader brindice = null;
        try {
            brindice = new BufferedReader(new FileReader(findice));
            String l1 = brindice.readLine();
            String l2 = brindice.readLine();
            ultimonumerobuscado = Integer.parseInt(l1);
            totalencontrados = Integer.parseInt(l2);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (brindice != null) {
                try {
                    brindice.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

 // ----------------------------------------------------------------------------
    public static void mostrarPrimos() {
        String algo;
        File fvalores = new File(FICHVALORES);
        if (!fvalores.exists()) {
            return;
        }

        Scanner sc = new Scanner(System.in);
        BufferedReader brvalores = null;
        try {
            brvalores = new BufferedReader(new FileReader(fvalores));
            String linea = brvalores.readLine();
            String[] trozos = linea.split(",");

            for (int i = 0; i < trozos.length; i++) {
                System.out.println(trozos[i]);
                if (i % 20 == 0 && i!=0) {
                    System.out.println("----> pulse Enter para continuar");
                    algo = sc.nextLine();
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (brvalores != null) {
                try {
                    brvalores.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

 // ----------------------------------------------------------------------------
}
//public class Inicio {
//
//    public static void main(String[] args) {
        // Para ver en el log las consultas SQL que ejecuta Hibernate
//        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.CONFIG);
//
//        ViviendaDAO dao = new ViviendaDAO();
//
//        // BORRAMOS TODOS LOS REGISRTOS PREVIOS PARA PARTIR DE CERO
//        System.out.println("Borrados :" + dao.borrarTodo("VIVIENDA"));
//        System.out.println("Borrados :" + dao.borrarTodo("PERSONA"));
//
//        // CREAMOS EJEMPLOS
//        Persona p1 = new Persona("111111A", "Ana");
//        Persona p2 = new Persona("222222b", "Eva");
//        Persona p3 = new Persona("333333n", "Marta");
//        Persona p4 = new Persona("444444n", "Maria");
//        Persona p5 = new Persona("555555k", "Pepa");
//        Persona p6 = new Persona("666666l", "Isabel");
//
//        Vivienda v1 = new Vivienda("Piso");
//        Vivienda v2 = new Vivienda("Atico");
//        Vivienda v3 = new Vivienda("Entresuelo");
//
//        v1.agregarPersona(p1);
//        v1.agregarPersona(p2);
//        v1.agregarPersona(p3);
//        v2.agregarPersona(p1);
//        v2.agregarPersona(p2);
//        // no hace fala hacerlo todo en las dos direcciones pues cada metodo hace lo suyo
//        // ambos permiten actualizar en ambas direcciones
//        p4.agregarVivienda(v3);
//        p5.agregarVivienda(v3);
//        p6.agregarVivienda(v3);
//
//        // --------- ALTA ------------
//        if (dao.anadirVivienda(v1))
//            System.out.println("--- ALTA CORRECTA");
//        if (dao.anadirVivienda(v2))
//            System.out.println("--- ALTA CORRECTA");
//        if (dao.anadirVivienda(v3))
//            System.out.println("--- ALTA CORRECTA");
//
//        // --------- LISTADO ------------
//        System.out.println("--- LISTADO");
//        ArrayList<Vivienda> lista = dao.listarViviendas();
//        for (Vivienda v : lista) {
//            System.out.println(v);
//        }
//
//        // --------- ACTUALIZAR ------------
//        v1.setTipo("PISO DE LUJO");
//        v1.quitarPersona(p1);
//        v1.agregarPersona(p6);
//        if (dao.actualizarVivienda(v1))
//            System.out.println("--- MODIFICACION CORRECTA");
//
//        // --------- CONSULTA ------------
//        System.out.println("--- CONSULTA");
//        Vivienda v = dao.consultarVivienda(lista.get(0).getId_vivienda());
//        if (v != null)
//            System.out.println(v);
//
//        // --------- BAJA ------------
//        if (dao.borrarVivienda(lista.get(2).getId_vivienda()))
//            System.out.println("--- BAJA CORRECTA");

//    }
//
//}