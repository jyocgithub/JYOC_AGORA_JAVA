package A_Plantilla_clase_abstracta_sockets_tcp;

public class Main {

	public static void main(String[] args) {
		TCPTeletipoServidor tcpServidor = new TCPTeletipoServidor(8000);
		TCPTeletipoCliente tcpCliente = new TCPTeletipoCliente("localhost",8000);
	
		
		

	}

}
