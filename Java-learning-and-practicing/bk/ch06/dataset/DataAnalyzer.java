
import java.util.Scanner;

/**
 * This program computes the average and the maximum of
 * a set of input values
 */

public class DataAnalyzer {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        DataSet_1 data = new DataSet_1();

        boolean done = false;

        while (!done) {
            System.out.print("Enter value, Q to quit: ");

            String input = in.next();

            if (input.equalsIgnoreCase("Q")) {

                done = true;

            } else {

                double x = Double.parseDouble(input);
                data.add(x);

            }
        }

        System.out.println("Average = " + data.getAverage());
        System.out.println("Maximum = " + data.getMaximum());

    }

}
