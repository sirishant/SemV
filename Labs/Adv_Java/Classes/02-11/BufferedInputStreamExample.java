import java.io.*;
public class BufferedInputStreamExample {
    public static void main(String args[]) {
        try {
            FileInputStream fin = new FileInputStream("test.txt");
            BufferedInputStream bin = new BufferedInputStream(fin);
            
            int read = bin.read();
            char read_char;
            // Use the read() of bin in a loop and print till the value returned is not -1
            do {
                read_char = (char)read;
                System.out.print(read_char);
            }while((read=bin.read())!=-1);

            bin.close();
            fin.close();
        } catch(Exception e){System.out.println(e);}
    }
}