package talkUDP;

public class Main {

	public static void main(String[] args) {
		
		Vista vista = new Vista();
		Controlador controlador = new Controlador (vista);
		vista.controlador(controlador); // action listener
		
		HiloRecibir hiloRecibir = new HiloRecibir(vista);
		hiloRecibir.start();
	
		
	}
}
