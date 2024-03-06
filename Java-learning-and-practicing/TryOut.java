import java.io.PrintStream;
import java.util.ArrayList;

public class TryOut {

    public static void main(String[] args) {

        PrintStream printer = System.out;

        ArrayList<Integer> a = new ArrayList<>();
        a.add(12);
        a.add(29);
        a.add(48);
        a.add(190);

        a.set(3, 20);

        for (int i : a) {
            printer.println(i);
        }

        printer.println("Size of the Array = " + a.size());

        // get the last element
        int lastElement = a.get(a.size() - 1);
        printer.println("last element  = " + lastElement);

        ArrayList<String> names = new ArrayList<>(10); // initial capacity

    }
}