
//LIBRERIAS NECESARIAS.............
import lejos.nxt.addon.*;   //Para sensor infrarrojo y compas
import lejos.util.*; // Para delay
import lejos.nxt.*; // Para motores y sensores en general
import lejos.nxt.comm.*;
import javax.bluetooth.*;
import java.io.*;
//..................................

public class Maestro {
    public static void main(String[] args) throws Exception {
      int numero=0;
         LCD.clear();
         LCD.drawString("Sender wait...", 0, 0);
         LCD.refresh();
         IRSeekerV2 infra = new IRSeekerV2(SensorPort.S1 ,IRSeekerV2.Mode.AC);
         int direccion;
         String name = "NXT 12";
           BTConnection connection; 
           DataOutputStream output; 
         
         
         
      try{

           
       
   
          
            
            LCD.drawString("Connected.", 1, 1);
            while(true)
            {
              direccion = infra.getDirection();
              connection = Bluetooth.connect(name, 0);

                if (connection == null)
               throw new IOException("Connect fail");

              output = connection.openDataOutputStream();
            output.writeInt(direccion);
            
         

            
            output.flush();
            LCD.drawString("Sent data", 4, 2);
            output.close();
            connection.close();
            LCD.drawString("Ir: "+direccion, 5, 0);
            Thread.sleep(100);
             LCD.clear();
            }
          
      }
      catch(Exception ioe)
         {
            LCD.clear();
            LCD.drawString("ERROR", 0, 0);
            LCD.drawString(ioe.getMessage(), 2, 0);
            LCD.refresh();
         }
       
    
    }
   

}