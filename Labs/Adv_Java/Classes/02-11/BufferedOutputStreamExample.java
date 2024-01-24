import java.io.*;
public class BufferedOutputStreamExample {
    public static void main(String args[]) throws Exception {
        FileOutputStream fout = new FileOutputStream("testout.txt");
        BufferedOutputStream bout = new BufferedOutputStream(fout);
        String s = "Welcome !!";
	 // Use getBytes() of the String and read it into a byte array
	 // Use the write() of the bos to write it to the file
        byte b[] = s.getBytes();
        bout.write(b);
        bout.flush();         
        bout.close();
        fout.close();
        System.out.println("success");
    }
}
