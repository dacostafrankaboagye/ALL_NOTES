import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TryOut {

    public static void main(String[] args) {

        try {
            File myFile = new File("./testerFile.txt");
            // reading
            Scanner myReader = new Scanner(myFile);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();

        } catch (FileNotFoundException e) {
        }

    }
}

/*
 * try {
 * File myFileObj = new File("./testerFile2.txt");
 * if (myFileObj.createNewFile()) {
 * System.out.println("File Created: " + myFileObj.getName() );
 * }else{
 * System.out.println("File exits");
 * }
 * 
 * } catch (IOException e) {
 * 
 * System.out.println("Error occured");
 * e.printStackTrace();
 * 
 * }
 * 
 * 
 * File myFile = new File("./testerFile.txt");
 * if (myFile.exists()) {
 * System.out.println("absolute path: " + myFile.getAbsolutePath());
 * System.out.println("name : " + myFile.getName());
 * System.out.println("Writable: " + myFile.canWrite());
 * System.out.println("Length : " + myFile.length());
 * }
 * 
 * 
 * // writing
 * try{
 * 
 * FileWriter myWriter = new FileWriter("./testerFile.txt");
 * myWriter.write("Studying file system");
 * myWriter.close();
 * 
 * } catch(IOException e){
 * System.out.println("error occured");
 * e.printStackTrace();
 * }
 * 
 * }
 */
