package A_Plantilla_Sockets_UDP;

public class PruebasPlantillaUDPEmisor {
    public static void main(String[] args) {
        Alumno alumno = new Alumno("Ana", 123);
        ProcesarUDP p = new ProcesarUDP();
        p.enviarObjetoUDP(alumno, "localhost", 22001);
    }
}
