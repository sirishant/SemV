// HelloServer.java
package TW10;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;

public class HelloServer {
    public static void main(String[] args) {
        try {
            HelloInterface helloObj = new HelloImplementation();

            // Create and export the RMI registry on port 1099
            LocateRegistry.createRegistry(1099);

            // Bind the remote object to the registry with the name "HelloService"
            Naming.rebind("HelloService", (Remote) helloObj);

            System.out.println("Server is ready.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}