//HelloClient.java

package TW10;

import java.rmi.*;

public class HelloClient {
    public static void main(String[] args) {
        try {
            // Lookup the remote object with the name "HelloService"
            HelloInterface helloObj = (HelloInterface) Naming.lookup("rmi://localhost:1099/HelloService");

            // Invoke the remote method and print the result
            String result = helloObj.sayHello();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}