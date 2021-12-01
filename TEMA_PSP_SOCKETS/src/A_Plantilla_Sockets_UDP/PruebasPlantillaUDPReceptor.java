package A_Plantilla_Sockets_UDP;

public class PruebasPlantillaUDPReceptor {
    public static void main(String[] args) {
        ProcesarUDP p = new ProcesarUDP();
        Object o = p.recibirObjectUDP("localhost", 22001);
        Alumno alumno = (Alumno) o;
        System.err.println(alumno.nombre);
    }
}