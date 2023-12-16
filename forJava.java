 import java.util.Objects;


    class Hello{

        public static void main(String a[]){
    
            byte num1 = 1;

            short num2 = 2;

            int num3 = 3;
        
            long num4 = 4L;

            System.out.println(num1);
            System.out.println(num2);
            System.out.println(num3);
            System.out.println(num4);

            // decimal

            float num5 = 5.3f;

            double num6 = 6.0;

            System.out.println(num5);

            System.out.println(num6);

            // character

            char bestGrade = 'A';

            System.out.println(bestGrade);

            // boolean

            boolean isMarried = false;

            System.out.println(isMarried);



            // unicode
            //char c = '\u1111';
            //char loveHeart = '\u0001';
            //char letter = 'a' + 4 ;

            // note 'a' + 0 => a    'a' + 1 => b    'a' + 4 => e

            //System.out.println(c);
            //System.out.println(Character.toString(loveHeart));

            // System.out.println(letter);

            for (int i = 0; i < 26; i++) {
                char letter = (char) ('A' + i) ;  // same for small letters
                System.out.println(letter);
            }

            

            // for higher precision use - BigDecimal class

            // other  values 

            System.out.println(Float.MAX_VALUE);
            System.out.println(Float.POSITIVE_INFINITY);

            System.out.println(Integer.MIN_VALUE);

            System.out.println(Integer.MAX_VALUE); 


            // conversion - widening , narrowing(for this use, cast)


            // properly compare two Object Long values
            
            
            // true
            
            long num1 = 128l;
            long num2 = 128l;

            System.out.println(num1 == num2);


            // false
            Long num3 = 128l;
            Long num4 = 128l;

            System.out.println(num3 == num4);


            // when using the boxed / Object Long values 

            System.out.println(Objects.equals(num3, num4));  // true

        }
    } 


class Hello{
    public static void main(String[] args) {

        // literals

        // hex
        int num1 = 0x2E;  // 46

        // binary
        int num2 = 0b0101; // 5

        // octal 
        int octalValue = 03; // 3

        // separating with _
        int accountBalance = 99_999_000; // 99999000

        // scientic notation
        double num3 = 21e9; // 2.1E10

 
         


        // null 
        Integer a  = null; 

        // type promotion
        byte abc = 10;
        byte cde = 80;

        int result = abc * cde ;

        // relational
        boolean result2 = 2 < 4;

        boolean result3 = 3 != 3;

        // logical 

        boolean result4 = 3 < 5 && 3 > 9;
        boolean result5 = 3 < 5;
        boolean result6 = !(3 < 5);
     

        System.out.println(result4);






    }
}


class Hello{

    public static void main(String[] args) {
        
        int a = 7;

        //if(a ==  5) System.out.println("The statement is true");

        if(a == 9)System.out.println("works for boolean too - it should just be true");
        else System.out.println("failed to start");

        // more than a single line 

        if(a > 5 && a < 10){
            System.out.println("greater than 5");
            System.out.println("And less than 10");
        }else{
            System.out.println("does not hold");
        }
        

        int a = 4;

        if(a > 2 && a < 5){
            System.out.println("a is greater than 2 and less than 5");
        }else if(a  == 5 && a < 10 ){
            System.out.println("a is equal to 5 and less than 10");
        }else{
            System.out.println("none of the above");
        }

       


        // tenary operator
        int a = 70;
        String result;
        result = a % 2 == 0 ? "even number" : "odd number";

        System.err.println(result);
         


        // switch

        int numDay = 100;
        String result;

        switch (numDay) {
            case 1:
                result = "Monday";
                break;
            case 2:
                result = "Tuesday";
                break;
            case 3:
                result = "Wednesday";
                break;
        
            default:
                result = "Invalid day";
                break;
        }

        System.out.println("The day is = " + result);

        

        // new switch ->, no break

        String dayOfWeek = "Sunday";

        switch(dayOfWeek){
            case "Monday", "Tuesday", "Wednesday" -> System.out.println("wake up at 6 am");
            case "Thursday" -> System.out.println("10 am is the time ");
            default -> System.out.println("relax");
        }

        // new switch - return a value

        int numDay = 20;

        String result = "";

        result = switch(numDay){
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3,4 -> "Wednesday or Thursday";
            default -> "Invalid day";
        };

        System.out.println(result);

        // another way

        int numDay = 2;

        String result = "";

        result = switch(numDay){
            case 1 : yield "Monday";
            case 2 : yield "Tuesday";
            case 3,4 : yield "Wednesday or Thursday";
            default : yield "Invalid day";
        };

        System.out.println(result);


    }

}


class Hello{

    public static void main(String[] args){

        int a = 1;

        
        while(a < 5){
            System.out.println(a);
            a++;

        }
        System.out.println("done");
        System.out.println(a);
        
       
        do{
            System.out.println(a);
            a++;
        }while(a < 5);

         

        for(int i=0; i<=5; i++){
            System.out.println(i);
        }

    }


}




 import java.util.StringJoiner;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

class Hello{
    public static void main(String[] args) {
        
        String username = "frank";
        String firtname = "Frank";
        String lastname = null;
        System.out.println(username.equals(firtname));
        System.out.println(username.equalsIgnoreCase(firtname));

        // null check on both parameters
        boolean result = Objects.equals(lastname, firtname);
        System.out.println("result = "  + result);

        char[] a;

        String b = "My name is Frank Aboagye";

        System.out.println(b);

        a = b.toCharArray();

        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }

        String c = String.valueOf(a);

        System.out.println(c);



        String a = "Frank";

        System.out.println(a.contains("ank"));

        System.out.println(a.indexOf("r"));

        System.out.println(a.toUpperCase());

        

        // split 

        String firstname = "Frank";
        String[] theName = firstname.split("");

        for(int i=0; i < firstname.length(); i++){

            System.out.println(theName[i]);
        }

        // split - regex - one or more space characters 

        String firstname = "Frank is    my               first name            Yh!";
        String[] theName = firstname.split("\\s+");

        for(int i=0; i < theName.length; i++){

            System.out.println(theName[i]);
        }


        // using any of the regex meta character - use either "\\" or Pattern.quote()
        // < > - = ! ( ) [ ] { } \ ^ $ | ? * + .
        // import java.util.regex.Pattern;


        String mySentence = "I am going Home.She is going to school.Yesterday was lit.I havent see her since moonlight!";
        
        String theRegex = Pattern.quote(".");

        String[] statements = mySentence.split(theRegex);
        // also
        String[] statements2 = mySentence.split("\\.");

        for (String string : statements2) {
            System.out.println(string);
        }

        

        // StringTokenizer - twice as fast as split - cos - it has some restrictions

        String sentence = "The big brown fox jumped over the laxy dog";

        StringTokenizer tokenizer = new StringTokenizer(sentence);
        StringTokenizer tokenizerWithDelimeter = new StringTokenizer(sentence, "o");


        while(tokenizer.hasMoreTokens()){
            System.out.println(tokenizer.nextToken());
        }
        System.out.println("+++++++");
        while(tokenizerWithDelimeter.hasMoreTokens()){
            System.out.println(tokenizerWithDelimeter.nextToken());
        }
        

        // joining 
        String[] myFruits = {"mango", "guava", "apple", "strawberry"};

        String allFruits = String.join(" - ", myFruits);
        
        System.out.println(allFruits);
        
        // another way  = StringJoiner
        StringJoiner niceJoin = new StringJoiner(",");
        StringJoiner niceJoin2 = new StringJoiner(",", "[", "]");

        niceJoin.add("mango");
        niceJoin.add("guava");
        niceJoin.add("apple");

        System.out.println(niceJoin);

        // stream of string 



    }
 }





// review split 

 import java.util.StringTokenizer;

class Hello{

    public static void main(String[] args) {
        
        String sentence = "The big brow    fox jumped over the lazy dog";
        
        StringTokenizer tokenizer = new StringTokenizer(sentence);

        while(tokenizer.hasMoreTokens()){
            System.out.println(tokenizer.nextElement());
        }

    }

}




// joining stream of strings

import java.util.stream.Collectors;
import java.util.stream.Stream;

class Hello{

    public static void main(String[] args) {

        Stream<String> fruits = Stream.of("mango", "guava", "apple");

        String allFruits = fruits.collect(Collectors.joining(" , "));

        System.out.println(allFruits);

    }
}



concatenatiom uses string builder under the hood

sometimes - it creates a new string builder instance

so use string builder


 
class Hello{

    public static void main(String[] args) {

        // string builder  - aftr appending - add .toString()   // defauult -empty space of only 16 characters


        
        String firstname = "Frank";
        String middlename = "Kwabena";
        String lastname = "Aboagye";
        String[] othername = {"dacosta", "junior"};

        StringBuilder fullname = new StringBuilder();
        
        StringBuilder allnames = new StringBuilder()

        fullname.append(firstname).append(middlename).append(lastname).toString();

        System.out.println(fullname);

        


        // concat 
        String firstname = "Frank";

        System.out.println("My name is ".concat(firstname));

        // substring 

        System.out.println(firstname.substring(0, 3));

        // reversing string - StringBuilder / StringBuffer

        StringBuilder newString = new StringBuilder(firstname);

        String reversedString = "";

        reversedString = newString.reverse().toString();
        
        System.out.println(reversedString);

        // reverse - char array 

        String textMessage = "I am doing well";
        
        System.out.println(textMessage);

        char[] myArray = textMessage.toCharArray();

        for (int index = 0, mirroedIndex = myArray.length - 1; index < mirroedIndex; index++, mirroedIndex--) {
            char temp = myArray[index];
            myArray[index] = myArray[mirroedIndex];
            myArray[mirroedIndex] = temp;            
        }

        System.out.println(new String(myArray));

        StringBuilder newString = new StringBuilder(textMessage.length());

        for (char c : myArray) {

            newString.append(String.valueOf(c));

        }

        System.out.println(newString.toString());


    }
}



public class Tryout{

    String name;
    int age;

    public Tryout(String name, int age){
        this.name = name;
        this.age = age;
    }

    // we overide the toString
    
    public String toString(){
        return "My name is " + this.name + ". I am " + this.age + " years old.";
    }

    

    public static void main(String[] args){

        Tryout person = new Tryout("Frank ABOAGYE", 20);

        System.out.println(person.toString());

    }
}





// counting the character in a string 




import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tryout{



    public static void main(String[] args){

        Pattern thePattern = Pattern.compile("f");
        
        Matcher matcher = thePattern.matcher("fox fence from frank to canada is from frank");

        int result = 0;

        while(matcher.find()){
            result++;
        }

        System.out.println(result);

        



    }
}




    // method overloading  - paramters and return types 

    public int add(int a, int b){
        return a + b;
    }

    public int add(int a, int b, int c){
        return a + b + c ;
    }




            // every method will have its own stack

        // there is a link between the stack and the heap  - perhaps - using address (links)

        // heaps -expands




 

public class Tryout{

    public static void main(String[] args) {

        // array 
   

        int[] nums = new int[5];  // default - {0, 0, 0, 0, 0}

        nums[0] = 2;
        nums[1] = 10;
        nums[2] = 32;
        nums[3] = 21;
        nums[4] = 7;

        int[] grades = {89, 89, 90, 23};

        for (int i : nums) {
            System.out.println(i);
        } 

        int[] a = {2,3,4};
        
        int[] b = new int[3];
        b[0] = 7; b[1] = 2; b[2] = 3;

        int[] c = new int[] {3, 7, 10};

        int[][] d = {{1,2}, {5, 7}, {6,8}};

        int[][] e = new int[3][2]; 

        e[0][0] = 3;
        e[0][1] = 12;
        e[1][0] = 4;
        e[1][1] = 89;
        e[2][0] = 10;
        e[2][1] = 5;

        int f, g[], h[][];

        // equivalent syntax
        int[] array1 = new int[0];
        int[] array2 = {};

        for (int[] i : e) {
            System.out.print('{');
            System.out.print(i[0]);
            System.out.print(',');
            System.out.print(i[1]);
            System.out.println('}');
        }

        

        int[][] a = {{3, 6, 8}, {10, 3}, {2, 9, 8, 11, 14}};

        for (int i = 0; i < a.length; i++) {
            
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            
               
            }
            System.out.println(" ");




            // the number columns isn't known - Java allows that

            // more like a jagged array

            // we have to specify the number of rows we have - but we donot have to specify the number of columns

            // specify individually the nuumber of columns you have 

            // e.g


            int[][] a = new int[3][];

            a[0] = new int[3];
            a[1] = new int[4];
            a[2] = new int[2];

            for (int[] i : a) {
                for (int j : i) {

                    System.out.print(j + " ");
                    
                }
                System.out.println(" ");
            }


            // draw backs of array / thats what it works - but they work
                //> consumes time - it has to traverse through everytime 
                //> size is fixed. cannot expand
                //> cannot have array of different types -> but there's a solution
                //> for the above -> choose collections


        
        
    }

}





class Student{
    String fullname;
    int age;
 



        // array of objects
        Student[] students = new Student[3];

        Student s1 = new Student();
        s1.fullname = "Frank Aboagye";
        s1.age = 20;

        Student s2 = new Student();
        s2.fullname = "Benjamin Kojo";
        s2.age = 13;

        Student s3 = new Student();
        s3.fullname = "Abena Priscilla";
        s3.age =9;

        students[0] = s1;
        students[1] = s2;
        students[2] = s3;

        for (Student student : students) {
            System.out.println(student.fullname + " - " + student.age);
        }

      







                
        String name = "Frank";

        String s1 = "abena";

        String s2  = "joe";

        name = name + " Aboagye";

        // "Frank" - which is stored in the string pool contant in the heap is eligible for gabbage collection - it will be removed after sometime to save memory
        
        
        
        StringBuffer myFruits = new StringBuffer("this is a list ");

        System.out.println(myFruits.capacity()); // 16

        myFruits.append("Mango");

        System.out.println(myFruits.length());

        // insert
        // delete char at
        // substring
        
        // ensure capacity

        // set length
        


class Tester{
    String name;
    static int age;

    public void show(){
        System.out.println("name = " + name + " <> " + "age = " + age);
    }
}



        // static variable - make it available to all the methods
        // static variable is shared by all teh objects
        // static variable should be called with their class Name
        // you make it a class member

        
        Tester obj1 = new Tester();

        obj1.name = "frank";
        Tester.age = 10;

        Tester obj2 = new Tester();

        obj2.name = "ben";
        


        obj1.show();
        obj2.show();

       








class Tester{
    String name;
    static int age;
    static{
        age = 90;
        System.out.println("called only once");
    }

    public void show(){
        System.out.println("name = " + name + " <> " + "age = " + age);
    }
    
    public static void printOut(){
        System.out.println("this is a static method");
    }

    public static void giveOut(Tester obj){
       System.out.println("name = " + obj.name + " <> " + "age = " + age);
    }
}




        // call static method with class name
        // you use can use a static variable in a static method - aside that no!
            //> but you can pass the obj inside

        // create  a static block for your static variables
            // it will be called once
        Tester.printOut();

        Tester obj1 = new Tester();
        obj1.name = "frank";
        Tester.giveOut(obj1);












// class loaders - in the JVM
// loads class only once
    // any time you load a class, it will call the static block
    // load the object -> instantiated
    // 



 if you do not create the obj, the static will not load.
 
 We can load the static anyways ... using 

 Class.forName("Theclassname")


 

class Tester{
    String name;
    static int age;
    static{
        age = 90;
        System.out.println("called only once");
    }

    public void show(){
        System.out.println("name = " + name + " <> " + "age = " + age);
    }
    
    public static void printOut(){
        System.out.println("this is a static method");
    }

    public static void giveOut(Tester obj){
       System.out.println("name = " + obj.name + " <> " + "age = " + age);
    }
}

class Tryout{

    public static void main(String[] args) throws ClassNotFoundException {

        Class.forName("Tester");


        



    }
}




// encapsulation


class Tester{

    // make instance variable private 

    private String name;
    private int age;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    

    // use methods to access it - get and set


}



class Tester{

    // make instance variable private 

    private String name;
    private int age;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    // this is a key word that represents the current object
    

    // use methods to access it - get and set


}

  

class Tryout{

    public static void main(String[] args) throws ClassNotFoundException {

        Class.forName("Tester");



    }
}





 
 
        Arrays.fill(a, 0, 5, 2);
        
        Arrays.setAll(a, i -> i);  // {0,1,2,3,4}
        Arrays.setAll(a, i -> 1);  // {1,1,1,1,1}

        for(int i : a){
            System.out.println(i);
        }
     

        String[] names = {"frank", "esther", "daniel"};

        for (String string : names) {
            System.out.println(string);
        }

        // to List
        List<String> mynames = new ArrayList<>(Arrays.asList(names)); // when the nmaes is changed, mynames oo changes

        for (String string : mynames) {
            System.out.println(string);
        }
          





import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Tryout{

    public static void main(String[] args) {
        int[] a = new int[5];

        
        Arrays.fill(a, 0, 5, 2);
        
        Arrays.setAll(a, i -> i);  // {0,1,2,3,4}
        Arrays.setAll(a, i -> 1);  // {1,1,1,1,1}

        for(int i : a){
            System.out.println(i);
        }
        

        String[] names = {"frank", "esther", "daniel"};

        for (String string : names) {
            System.out.println(string);
        }

        // to List
        List<String> mynames = new ArrayList<>(Arrays.asList(names)); // when the nmaes is changed, mynames oo changes

        for (String string : mynames) {
            System.out.println(string);
        }



    }
}




Every constructor has a 
method in Java

i.e.

super()

// the first thing it see is the super -> it means call the 
constructor of the super class -> the default one
> pass a parameter in the super if you want it to call the 
parameterized constructor instead

-> even if you do not mention it
> first statement 



Note:

Every class in Java extends the object class

class A extends Object{

}
class B extends A{

}
you can metion it - but it doesnt matter




class Music{


    public Music(){
        System.out.println("This is Music - default");
    }

    public Music(String musicName){
        System.out.println("Music" + musicName);
    }

}

class RecordLabel extends Music {

    public RecordLabel(){
        //super();  // by default calls the default constructor of Music - you can neglet it
        super("Country Music");
        System.out.println("Record Label");
    }
}



public class Tryout{
    public static void main(String[] args) {
        
        //Music myMusic = new Music();

        RecordLabel myRecordLabel = new RecordLabel();



    }
}






Note:

this()

it will execute the constructor of the same class





class Music{


    public Music(){
        System.out.println("This is Music - default");
    }

    public Music(String musicName){
        System.out.println("Music " + musicName);
    }

}

class RecordLabel extends Music {

    public RecordLabel(){
        //super();  // by default calls the default constructor of Music - you can neglet it
        super("Country Music"); 

        System.out.println("Record Label");
    }

    public RecordLabel(String recordLabelName){
        
        this();  // will excute the construct of the class - since no parameter - it will execute default
                
        System.out.println("Record Label " + recordLabelName);
    }
}



public class Tryout{
    public static void main(String[] args) {
        
        //Music myMusic = new Music();

        RecordLabel myRecordLabel = new RecordLabel("DMX");



    }
}



        RecordLabel myRecordLabel = new RecordLabel(); // reference object

        new RecordLabel();  // anonymous object -> you cannot resuse them



  Single level inheritance

  Multi level inheritance

  mulpile inheritance - will not work - why?
   =- can lead to ambiguity - 
   - if say, you hvae the same methods in two parents.. which one should it pick
   */




/* 

poly morphism 

- many
- behaviours


complie time - polymorphism / early binding - overloading examples

run time - poly morphism / late binding - overriding examples



 */



 /*
 

 SAY, 

 if B extends A

 A obj = new B();

> the obj type is A  // you can make the type - Parent 
> the obj implementation is B  // you can make the implementation - Child



  */



 dynamic method dispatch

 - which method it will call, we are not sure- it will be decided at runtime


 
class Music{

    public void showCategory(){
        System.out.println("Music Category");
    }
}

class RecordLabel extends Music {

    public void showCategory(){
        System.out.println("Record label Category");
    }
}

class Album extends Music{

    public void showCategory(){
        System.out.println("Album Category");
    }

}

public class Tryout{
    public static void main(String[] args) {

        // note: 
            // the type is - Music
            // the implementation is different

        Music aSong = new RecordLabel();
        aSong.showCategory();

        aSong = new Album();
        aSong.showCategory();

    }
}






/*


Final Key Word


 */

final class TestThis{
    public void show(){
        System.out.println("in the test section");
    }
}

// cannot extend because the class has the final key word
class AnotherClass extends TestThis{

}



// cannot override final method
class TestThis{
    public final void show(){
        System.out.println("in the test section");
    }
}


class AnotherClass extends TestThis{
    // this will not work
    public void show(){
        System.out.println("in another class");
    }

}


 // cannot reassign final variable

final double myPI = 3.149;




// object class

// -> calling / printing the object = it calls the toString class
// you see by default objectName@someHash / someadress




 // !!!!!! ANOTHER APPROACH IS THERE - BUT FOR UNDERSTANDING SAKE
// by dfault the class extends the object class - even if you do not explicitly define it
class Laptop{

    int price;
    char currency;
    String laptopName;

    // to override 
    // not necessary @Override
    public String toString() {
        return "Hey";
    }

    // the default object.equals - use the hashcode to compare - we want to define our own equals
    public boolean equals(Laptop other) {
        return this.laptopName.equals(other.laptopName);
       
    }


}


public class TryOut {

    public static void main(String[] args) {
        
        Laptop obj = new Laptop();
        obj.price = 7000;
        obj.currency = '$';
        obj.laptopName = "Lenovo";
        
        // same 
        // System.out.println(obj.toString());
        // System.out.println(obj);
        
        Laptop obj2 = new Laptop();
        obj2.price = 7000;
        obj2.currency = '$';
        obj2.laptopName = "Lenovo";

        // comparing obj to obj2
        // System.out.println(obj == obj2); // false
        // System.out.println(obj.equals(obj2)); // false -> using default equals
        
        // now using our equals
        System.out.println(obj.equals(obj2));  // true
        
        
    }
    
}






 // use generate Hashcode and equals - > with what you want to compare

 
class Laptop{

    int price;
    char currency;
    String laptopName;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + price;
        result = prime * result + currency;
        result = prime * result + ((laptopName == null) ? 0 : laptopName.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Laptop other = (Laptop) obj;
        if (price != other.price)
            return false;
        if (currency != other.currency)
            return false;
        if (laptopName == null) {
            if (other.laptopName != null)
                return false;
        } else if (!laptopName.equals(other.laptopName))
            return false;
        return true;
    }

}


public class TryOut {

    public static void main(String[] args) {
        
        Laptop obj = new Laptop();
        obj.price = 7000;
        obj.currency = '$';
        obj.laptopName = "Lenovo";

        
        Laptop obj2 = new Laptop();
        obj2.price = 7000;
        obj2.currency = '$';
        obj2.laptopName = "Lenovo";

        System.out.println(obj.equals(obj2));  
        
    }

}


class Laptop{

    
    int price;
    char currency;
    String laptopName;
    
    @Override
    public String toString() {
        return "Laptop [price=" + price + ", currency=" + currency + ", laptopName=" + laptopName + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + price;
        result = prime * result + currency;
        result = prime * result + ((laptopName == null) ? 0 : laptopName.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Laptop other = (Laptop) obj;
        if (price != other.price)
            return false;
        if (currency != other.currency)
            return false;
        if (laptopName == null) {
            if (other.laptopName != null)
                return false;
        } else if (!laptopName.equals(other.laptopName))
            return false;
        return true;
    }

}


public class TryOut {

    public static void main(String[] args) {
        
        Laptop obj = new Laptop();
        obj.price = 7000;
        obj.currency = '$';
        obj.laptopName = "Lenovo";

        
        Laptop obj2 = new Laptop();
        obj2.price = 7000;
        obj2.currency = '$';
        obj2.laptopName = "Lenovo";

        System.out.println(obj.equals(obj2));  
        System.out.println(obj);
        
    }

}





// abstract class vs concrete class (normal class without abstract keyword)

// abstract key word
    // you cannot create object of an abstract class
    // but you can create a reference of it
    // any method that has abstract -> the class should also be abstract
    // abstratct methods are the be implemented - its just a way of telling that - i am giving an 
        // abstract idea, you should be the one to implement it. and you have to implement it


abstract class Laptop{

    public abstract String laptopName();

    public void printOut(){
        System.out.println("Laptop Abstract class");
    }

}

class Lenovo extends Laptop{

    // you have to define the methods in the abstract class - compulsory
    public String laptopName() {
        return "Lenovo";
    }

}

public class TryOut{

    public static void main(String[] args) {

        // cannot do this
        // Laptop myLaptop = new Laptop();

        //create a reference of it rather
        Laptop myLaptop = new Lenovo();
        System.out.println(myLaptop.laptopName());

        // or
        Lenovo myLenovo = new Lenovo();
        System.out.println(myLenovo.laptopName());
        
    }
}





++++++++++++++++

    public static void main(String[] args) {

        Map<Integer, Integer> myMap = new HashMap<>();

        myMap.put(1, 10);
        myMap.put(2, 4);
        myMap.put(3, 98);
        myMap.put(4, 2);

        // for(Map.Entry<Integer, Integer> cord : myMap.entrySet()){
        //     System.out.println(">>" + cord.getKey() + " >> " + cord.getValue());
        // }
        
        // // another way

        // myMap.forEach((k, v)->{
        //     System.out.println("key : " + k + " value : " + v);
        // });

        System.out.println(myMap.containsValue(98));

        

        
    }


    // ++++++++++

    // inner class


class A{
    int age;

    public void show(){
        System.out.println("in show");
    }

    class B{
        public void config(){
            System.out.println("in config");
        }
    }

    static class C{
        public void setting(){
            System.out.println("setting");
        }
    }
}

public class TryOut{

    public static void main(String[] args) {

        A myA = new A();
        myA.show();

        // calling B
        A.B myB = myA.new B();
        myB.config();

        // C is a static class - see
        A.C myC = new A.C();
        myC.setting();

        // you cannot make an outer class static
        
    }
}








// anonymous inner class



// anonymous inner class
//  we override theName method
// we know will will do it once 

class Computer{

    public void theName(){
        System.out.println("A comupter");
    }
    
}

public class TryOut{

    public static void main(String[] args) {

        Computer myLenovo = new Computer(){
            public void theName(){
                System.out.println("Lenovo Computer");
            }
        };

        myLenovo.theName();

    
    }
}




















// if you want to implement the interface or abstract class only once
//  use the abstract and anonymous inner class

abstract class Library{
    public abstract void theName();
    // can have more methods - but make sure to implement it in the anonymous inner class
}

class FictionBooks extends Library{

    public void theName(){
        System.out.println("Library-Frictional-Books");
    }

    
}

public class TryOut{

    public static void main(String[] args) {

        // you cannot do this - cannaot instantiate it -
        //Library comicBooks = new Library();

            // but you can do this
        Library comicBooks = new Library() {
            public void theName(){
                System.out.println("Libray-Comic-Books");
            }
        };

        comicBooks.theName();


    
    }
}

















// the need for interface

abstract class Computer{
    public abstract void code();
}

class Desktop extends Computer{
    public void code(){
        System.out.println("coding... faster");
    }
}

class Laptop extends Computer{
    public void code(){
        System.out.println("coding....");
    }
}

class Developer{
    public void developApp(Computer comp){
        comp.code();
        System.out.println("developing applications...");
    }
}




public class TryOut{

    public static void main(String[] args) {

        Computer lap = new Laptop();
        Computer desk = new Desktop();

        Developer james = new Developer();
        james.developApp(lap);



    
    }
}





// replace with interface

interface Computer{
    public abstract void code();
}

class Desktop implements Computer{
    public void code(){
        System.out.println("coding... faster");
    }
}

class Laptop implements Computer{
    public void code(){
        System.out.println("coding....");
    }
}

class Developer{
    public void developApp(Computer comp){
        comp.code();
        System.out.println("developing applications...");
    }
}




public class TryOut{

    public static void main(String[] args) {

        Computer lap = new Laptop();
        Computer desk = new Desktop();

        Developer james = new Developer();
        james.developApp(lap);



    
    }
}






















// interface
// if you end up implementing only abstract method in your abstract class: use interface
// by default -  every method in the interface is: "public abstract"

interface Computer{
    public abstract void code();
    public abstract void configure();
}

// same as 

interface Computer{
    void code();
    void configure();
}


























// cannot instantiate interface
    // what is the solution?

    // we create interface so that we can design something

    // for interface
        // they tell you what methods you need,
        // but you have to implement them

    // interface will show you the design - implement them (how? create a class which implements the interface))
        // implement all the methods in the interface else - make your class abstract

    // any variable in the interface is - final and static
        // so you have to initialise the variable

interface Computer{
    void code();
    void configure();
}













// a class can implement multiple interfaces

// this works

interface A{
    void theName();
}

interface B extends A{
    void theAge();
}

// when you implent - interface B - in a class, you should define all the methods in both interfaces










// enums  - enumeration - named constant


// they are also 0-index based
enum Status{
    Running, Pending, Active, Falied, Success, Inactive;
}

// ordinal
// 0 -> Running, 1 -> Pending, ... , 5->Inactive

public class TryOut{

    public static void main(String[] args) {

        Status ec2Instance = Status.Inactive;

        System.out.println(ec2Instance); // Inactive
        System.out.println(ec2Instance.ordinal()); // 5

        // getting all the status
        Status[] myS = Status.values();
        
        for(Status i: myS){
            System.out.println(i);
        }
    
    }
}























enum Status{
    Active, Inactive, Success, Failed, Pending, Stopped;
}

public class TryOut{

    public static void main(String[] args) {

        // conditionals
        Status ec2InstanceStatus = Status.Inactive;
        String message = ">>>";

        if(ec2InstanceStatus == Status.Inactive){
            message += " Cannot Access EC2 Instance";
        }else if(ec2InstanceStatus == Status.Active){
            message += " Valid Access";
        }else if(ec2InstanceStatus == Status.Success){
            message += " EC2 Instance Launced";
        }else{
            message += " EC2 Instance Blocked";
        }

        System.out.println(message);


        // switch

        switch (ec2InstanceStatus) {
            case Inactive -> message += " Cannot Access EC2 Instance";
            case Active -> message += " Valid Access";
            case Success -> message += " EC2 Instance Launced";
            default -> message += " EC2 Instance Blocked";
        }
        System.out.println(message);


    }
}













// more on enums

// by default - enums extends an enum class - use - getClass() getSuperClass()

enum Laptop{
    MacBook(50_000), MacBookPro(45_000), Vostro(30_000), ThinkPad(10_000);
    
    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    private Laptop(int price) {
        this.price = price;
    }

    // you can create a default constructor - so that even if you do not specify the price -> you can just use it
    // if you have say, 4 objects in the eums -> it will call the constructor - 4 times - according to the number that have the constructor - being it default
        //try it with this
        // MacBook(50_000), MacBookPro(45_000), Vostro, ThinkPad(10_000);
        // with a default constructor - only one call
        // with a priced constructor - 3 calls


}

public class TryOut{

    public static void main(String[] args) {

        Laptop myLaptop = Laptop.MacBook;
        
        System.out.println(myLaptop + " : " + myLaptop.getPrice());

    }
}














