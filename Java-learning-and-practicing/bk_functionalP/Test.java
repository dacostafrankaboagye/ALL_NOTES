import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Test {

    public static void pickName(List<String> names, String startingLetter) {

        Optional<String> foundName = names.stream()
                .filter(name -> name.startsWith(startingLetter))
                .findFirst();

        // System.out.println(String.format("A name starting with %s: %s",
        // startingLetter, foundName.orElse("No name found")));
        foundName.ifPresent(name -> System.out.println("Hello " + name));
    }

    public static void main(String[] args) {

        List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
        String startingLetter = "N";
        pickName(friends, startingLetter);
    }

}
