package ed_listas_simples;

public class EjemploListaSimple {

    public static void main(String[] args) {
        ListaSimple p = new ListaSimple();


        p.insertarNodoAlFinal(33);
        p.insertarNodoAlFinal(55);
        p.insertarNodoAlFinal(44);
        p.insertarNodoAlFinal(11);
        p.insertarNodoAlFinal(66);
        p.insertarNodoAlFinal(55);
        p.eliminarNodoPorValor(66);

        p.insertarNodoAlFinal(99);
        p.insertarNodoAlFinal(44);
        p.insertarNodoAlFinal(88);
        p.insertarNodoEnPosicion(4, 22);
        p.insertarNodoEnPosicion(6, 11);

        Nodo x1 = p.buscarNodoPorPosicionn(1);
        Nodo x2 = p.buscarNodoPorPosicionn(6);
        Nodo x3 = p.buscarNodoPorPosicionn(8);
        System.out.println(x1);
        System.out.println(x2);
        System.out.println(x3);

//        System.out.println("Nodos Existentes: "+p.tamanoLista());
//        p.mostrarLista();
//        p.mostrarListaInversa();
//
//
//        System.out.println("1-------------------------");
//        p.eliminarPrimerNodo();
//        p.mostrarLista();
//
//        System.out.println("1-------------------------");
//        p.eliminarNodoPorPosicion(24);
        p.mostrarLista();
//
//        System.out.println("1-------------------------");
//        p.eliminarUltimoNodo();
//        p.mostrarLista();
//
//
//
//        System.out.println("1-------------------------");
//        p.eliminarTodo();
//        p.mostrarLista();

    }
}