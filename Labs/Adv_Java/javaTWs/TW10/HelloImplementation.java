//HelloImplementation.java
package TW10;

import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

public class HelloImplementation extends UnicastRemoteObject implements HelloInterface {
    public HelloImplementation() throws RemoteException {
        super();
    }

    @Override
    public String sayHello() throws RemoteException {
        return "Hello, from the server!";
    }

}
