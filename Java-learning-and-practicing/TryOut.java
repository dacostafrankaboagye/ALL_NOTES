import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Formatter;
import java.util.Scanner;

public class TryOut {

    public static void main(String[] args) {

        PrintStream printer = System.out;

        InputStream sender = System.in;

        /*        
        try{

            int bytedata = sender.read();
            printer.println(((int)bytedata));

        } catch(IOException e){
            printer.println(e.getMessage());
        }
        printer.println(System.currentTimeMillis());
        printer.println(System.getProperties());
        
                Formatter formatter = new Formatter();
                System.out.println(formatter.format("%4$2s %3$2s %2$2s %1$2s", "a", "b", "c", "d"));

                InputStream myInputStream = System.in;
        
                Scanner myScanner = new Scanner(myInputStream);
                
                        myScanner.useDelimiter(",");  // anytime it see , -> it recognises that a new pieoce of info is coming
                        myScanner.useDelimiter("\n");  // anytime it see 'a new line' -> it recognises that a new pieoce of info is coming
        */
        
        Scanner myScanner = new Scanner(System.in);
        
        System.out.println("Enter here: ");

        String data = myScanner.nextLine();

        System.out.println(data + "\n");



    }
}


