import java.util.Arrays;
import java.util.Scanner;

public class TryOut {

    public static void printNumberOfArguments(int... numbers) {
        System.out.println(Arrays.toString(numbers));
    }

    public static void testMethod(int[] array, int... vararg) {
        System.out.println("array : " + Arrays.toString(array));
        System.out.println("vararg : " + Arrays.toString(vararg));
        System.err.println();
    }

    public static void main(String[] args) {

    final Scanner scanner = new Scanner(System.in); // 1
    final int a;                                    // 2
    final int b = scanner.nextInt() + a;            // 3
    final int c = 0;                                // 4
    c = b;                                          // 5
    System.out.println(c + 1);                      // 6

    }
}