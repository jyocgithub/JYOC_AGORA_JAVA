
package videoclubsql;

import socketsUDP_conSwing.DatosNoEncontradosException;
import java.util.ArrayList;

public class VideoclubSQL {

    public static void main(String[] args) {
       
        
        try {
            Cliente c = new Cliente(0,"PACO", "CASTELLANA 1", "65656565");
            BBDDVideoClub bbdd = new BBDDVideoClub();

            bbdd.insertarCliente(c);
            
            ArrayList<Cliente> lista = bbdd.consultarClientes();
            for( Cliente cl :  lista){
                System.out.println(cl);
            }
            
            
            Cliente cliente = bbdd.consultarUnCliente(3);
             System.out.println(cliente);
            
        } catch (DatosNoEncontradosException ex) {
             System.out.println(ex.getMessage());;
        }
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
         
        
        
        
    }
    
}
