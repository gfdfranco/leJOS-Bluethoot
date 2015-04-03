//LIBRERIAS NECESARIAS.............
import lejos.nxt.addon.*;   //Para sensor infrarrojo y compas
import lejos.util.*; // Para delay
import lejos.nxt.*; // Para motores y sensores en general
import lejos.nxt.comm.*;
import javax.bluetooth.*;
import java.io.*;
//..................................

public class Esclavo {
    public static void main(String[] args) throws Exception {
         LCD.clear();
         LCD.drawString("Receiver wait...", 0, 0);
         LCD.refresh();
         DataInputStream input;
         int answer1;
         BTConnection connection;
      try{

            while(true)
            {
                connection = Bluetooth.waitForConnection();

                 if (connection == null)
               throw new IOException("Connect fail");

                    LCD.drawString("Connected.", 1, 1);
                 input = connection.openDataInputStream();
            

            answer1 = input.readInt();
            LCD.drawString("1st = " + answer1, 2,2);
     
                     
            input.close();
     
            connection.close();
            LCD.drawString("Bye ...", 5,5);
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