import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

public class TryOut {

    public static void main(String[] args) {

        PrintStream printer = System.out;
        String[] fruits = {"mango", "guava"};


        String[] another = Arrays.copyOf(fruits, fruits.length * 2);

        for(String x : another){
            printer.println(x);
        }
    }
}