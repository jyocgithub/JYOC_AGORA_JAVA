import envio_ficheros_udp.ProcesarUDP;

public class ReceptorUDP {


    public static void main(String[] args) {

       Escuela s = (Escuela) new ProcesarUDP().recibirObjectUDP("localhost",7000);

       System.out.println(s);
    }
}
