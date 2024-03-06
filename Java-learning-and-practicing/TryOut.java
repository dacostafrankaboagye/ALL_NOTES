import java.util.Random;

public class TryOut{

    public static void main(String[] args) {
        // simulate the cast of a die as follows
        /*
         The call generator.nextInt(6) gives you a 
         random number between 0 and 5 (inclusive). 
         Add 1 to obtain a number between 1 and 6.
         */
        
        Random generator = new Random();
        int d = 1 + generator.nextInt(6);

        System.out.println(d);
        

    }
}