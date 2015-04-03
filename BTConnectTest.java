import java.io.*;
import javax.bluetooth.*;
import lejos.nxt.*;
import lejos.nxt.comm.*;

public class BTConnectTest {
  public static void main(String[] args) throws Exception {
    String name = "NXT 12";
    LCD.drawString("Connecting...", 0, 0);
    RemoteDevice btrd = Bluetooth.getKnownDevice(name);

    if (btrd == null) {
      LCD.clear();
      LCD.drawString("No se encuentra", 0, 0);
      Button.waitForAnyPress();
      System.exit(1);
    }

    BTConnection btc = Bluetooth.connect(btrd);

    if (btc == null) {
      LCD.clear();
      LCD.drawString("Conexion fallida", 0, 0);
      Button.waitForAnyPress();
      System.exit(1);
    }
  
    LCD.clear();
    LCD.drawString("Conectado", 0, 0);
    LCD.drawString("Finished",3, 4);
    Button.waitForAnyPress();
  }
}