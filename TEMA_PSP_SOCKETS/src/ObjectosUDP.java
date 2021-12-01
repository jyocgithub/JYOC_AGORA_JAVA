import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class ObjectosUDP {

    public void enviarObjetoUDP(Object o, String hostName, int desPort) {
        try {
            //ENVIAR MENSAJE OBJETO
            // Preparar el objeto a enviar como un array de bytes
            // Para ello lo escribimos en un ByteArrayOutpuStream, y de ahi lo convertimos en el byte[]
            ByteArrayOutputStream baos = new ByteArrayOutputStream(5000);
            ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(baos));
            oos.flush();
            oos.writeObject(o);
            oos.flush();
            // convertimos el objeto escrito en el byte[]
            byte[] arrayConElObjeto = baos.toByteArray();

            // enviamos el byte[] como un Datagram normal
            InetAddress address = InetAddress.getByName(hostName);
            DatagramPacket dpacket = new DatagramPacket(arrayConElObjeto, arrayConElObjeto.length, address, desPort);
            DatagramSocket dSocket = new DatagramSocket();
            dSocket.send(dpacket);
            oos.close();  // mejor en un finally, aqui ahora por ahorro de espacio
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Object recibirObjectUDP(String hostName, int puerto) {
        try {
            // RECIBIR MENSAJE OBJETO
            // Preparar una array de bytes donde recibir un datagrama
            byte[] arrayDondeRecibir = new byte[5000];
            // Recibir un datagrama
            DatagramPacket packet = new DatagramPacket(arrayDondeRecibir, arrayDondeRecibir.length);
            InetAddress address = InetAddress.getByName(hostName);
            DatagramSocket dSocket = new DatagramSocket(puerto, address);
            dSocket.receive(packet);
            // Convertir el datagrama leido como byte[] en un objeto
            // Para ello escribimos el byte[]  en un ByteArrayInpuStream, y de ahi lo convertimos en Object
            ByteArrayInputStream byteStream = new ByteArrayInputStream(arrayDondeRecibir);
            ObjectInputStream is = new ObjectInputStream(new BufferedInputStream(byteStream));
            Object objetoLeido = is.readObject();   // posteriormente se debe hacer casting para modelar el objeto leido
            is.close(); // mejor en un finally, aqui ahora por ahorro de espacio
            return (objetoLeido);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (null);
    }
}




