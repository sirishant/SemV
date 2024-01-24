import java.io.*;
public class DataInputStreamExample {
    public static void main(String[] args) {
        // Similar to "with open()" in Py, try(DataInputStream dis = new ..) will implicitly close the file
        try (DataInputStream dis = new DataInputStream(new FileInputStream("data_output.dat"))) {
            int intValue = dis.readInt();
            double doubleValue = dis.readDouble();
            String stringValue = dis.readUTF();
            
            System.out.println("Read int: " + intValue);
            System.out.println("Read double: " + doubleValue);
            System.out.println("Read string: " + stringValue);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
