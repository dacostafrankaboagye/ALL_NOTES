import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

    public static void pickName(final List<String> names, final String startingLetter){
        String foundName = null;
        for(String name: names){
            if(name.startsWith(startingLetter)){
                foundName = name;
                break;
            }
        }
        System.out.println(String.format("A name starting with %s: ",  startingLetter));

        if(foundName != null){
            System.out.println(foundName);
        }else{
            System.out.println("No name found");
        }

       
    }


    public static void main(String[] args) {
        
        final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
    }

}
