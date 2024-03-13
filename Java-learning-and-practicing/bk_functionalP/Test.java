
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Test {

    public static void main(String[] args) {
        // immutable collection of list of names
        final List<String> friends = Arrays.asList("Spencer", "James", "Lindsay", "Lesly");

        final List<String> upperCaseNames = new ArrayList<>();

        // next 
        friends.stream()
               .map(name -> name.toUpperCase())
               .forEach(name -> System.out.print(name + " "));

        System.out.println();
        

    }

}
