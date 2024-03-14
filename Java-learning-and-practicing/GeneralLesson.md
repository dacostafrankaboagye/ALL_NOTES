## Know these

    byte = -128 to 127
    short = -32,768 to 32,767
    int = -2,147,483,648 to 2,147,483,647
    long  = -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807 (unsigned)    > (append L / l)
    double = 4.9E-324 to 1.7976931348623157E+308
    float = 1.4E-45 to  3.4028235E38  > (append F/f)




- Number Variables Store numbers . Object Variables store references

- You can convert from a class type to an interface type, provided the class implements the interface

older versions

- An inner class can access surrounding local variables only if they are declared as final.

  - Keep in mind that an object variable is final when the variable
    always refers to the same object. The state of the object can change,
    but the variable can’t refer to a different object

- An inner class can also access instance variables of the surrounding class,
  again with a restriction. The instance variable must belong to the object
  that constructed the inner class object. If the inner class object was created inside a static method, it can only access static variables.

- A subclass has no access to the private instance variables of the superclass
- A subclass method overrides a superclass method if it has the same name and parameter types as a superclass method

- The most frequently used reference types are String, Scanner and arrays

##

    In Java, an array has the following important features:
        - an array is a reference type;
        - all array elements are stored in the memory sequentially;
        - each element of the array is accessed by its numerical index, the first element has the index 0;
        - the last element is accessed by the index equal to array size – 1;
        - it is possible to create an array to store elements of any type.

##

    int[] array; // declaration form 1

    int array[]; // declaration form 2: less used in practice

    int[] numbers = { 1, 2, 3, 4 }; // instantiating and initializing an array of 1, 2, 3, 4

    int a = 1, b = 2, c = 3, d = 4;    
    int[] numbers = { a, b, c, d }; // instantiating and initializing an array of 1, 2, 3, 4

    int n = ...; // n is a length of an array
    int[] numbers = new int[n];

##

    The size of an array cannot be greater than Integer.MAX_VALUE. Actually, it is even slightly smaller than this value.

##

    int[] numbers; // declaration
    numbers = new int[n]; // instantiation and initialization with default values

    float[] floatNumbers; // declaration 
    floatNumbers = new float[] { 1.02f, 0.03f, 4f }; // instantiation and initialization

##
    
    // It takes an array, start index, end index (exclusive) and the value for filling the array
    Arrays.fill(characters, 0, size / 2, 'A'); 
    Arrays.fill(characters, size / 2, size, 'B');

    System.out.println(Arrays.toString(characters)); // it prints [A, A, A, A, A, B, B, B, B, B]

##

    It's possible to pass an arbitrary number of the same type of arguments to a method using a special syntax named varargs (variable-length arguments)

##
    A character can also be created using its hexadecimal code
        char ch = '\u0040'; // it represents '@'

    The char type has a minimum value encoded as '\u0000' and the maximum value encoded as '\uffff'

## 

    A string can be null. It means no value was assigned.

    String nullString = null; // it is null

    String s = null;
    int length = s.length(); // it throws NullPointerException

    strings are immutable in Java

    if say, a = "abc
    >>> a + 8
    >>> "abc8"

    >>> a + false
    >>> "abcfalse"

    System.out.println("2" + 2 + 2); // 222


##

    Since Java 11, it is also possible to use final with var to use automatic type inference for a constant variable.

    final var FINAL_VAR = 10; // int
    final var MSG = "Hello!"; // String

##

    In the world of Java, a compiler (the javac tool for Java or the kotlinc tool for Kotlin) translates source code into an intermediate representation known as Java bytecode stored in files with a .class extension. Computers can't read bytecode without translation, but a system called the Java Virtual Machine (JVM) can execute it.

##

    JVM languages

    The Java Platform allows using more than one programming language to create programs. This is achieved by the design of the JVM: it doesn't know anything about any particular programming language. It only understands Java bytecode. If the tools for a programming language can generate bytecode, programs written in this language can be executed on the JVM. Such languages are often called JVM languages. They include Java itself, Kotlin, Scala, Groovy, Clojure, and others. So, to create programs in the world of Java, you can choose the most convenient language of your choice.

##

    A class body can include fields, methods, and constructors. Fields store data, methods define behavior and constructors allow us to create and initialize new objects of the class. 

---
## Format

     %d integer
     %f real number
     %s string 

     int x = 3;
    int y = -17;
    System.out.printf("x is %d and y is %d\n", x, y);  


    printf width
        %Wd integer, W characters wide, right-aligned
        %-Wd integer, W characters wide, left-aligned
        %Wf real number, W characters wide, right-aligned

```java


        PrintStream printer = System.out;

        String a = "frank";

        printer.printf("%10s", a); // "     frank"

```

    printf precision
        %.Df real number, rounded to D digits after decimal
        %W.Df real number, W chars wide, D digits after decimal
        %-W.Df real number, W wide (left-align), D after decimal


    String.format(".....)

```java

        PrintStream printer = System.out;

        String name = "Frank";
        int age = 21;
        double salary = 5000.2910832;

        String anExample = String.format("My name is %s. I am %d years old. I earn %.4f USD", name, age, salary); 
        
        // My name is Frank. I am 21 years old. I earn 5000.2911 USD

        printer.println(anExample);

```

## String methods

```java

PrintStream printer = System.out;

String anExample = "The little fox jumps over the little dog";

String theReplace = anExample.replace("little", "big"); // The big fox jumps over the big dog
boolean theContains = anExample.contains("bird");// false

printer.println(theReplace);
printer.println(theContains);

```

## Scanner

    Note:
        - nextLine() -> takes the input and the line(the new line character) too -> that too goes as an inout
        - nextInt(),nextDouble() etc., take only numbers as inputs and leaves the new line character in the buffer

        example: Look at this sequence

        name = in.nextLine()  // you put in "frank" and press enter:  >> frank <enter>  
        // both frank and <enter> is taken in
        // output : frank
        
        age = in.nextInt()  // you put in 21 and press enter:  >> 12 <enter>
        // only the 12 is taken in
        // output : 12    ->  <enter> goes to the buffer

        schoolname = in.nextLine() // you put in "MIT" and press enter:  >> MIT <enter>  
        // note that <enter> is in the buffer
        // output : ...nothing...
        // this happens because is reads the <enter> that the user entered : which is in the buffer

        // same for nextDouble, nextFloat ....


    How do we resolve that:
        1. 
            - If you wnat to call nextLine() after a nextInt, or  nextDouble or nextFloat .... put an extra nextLine()
                - this cleans up the input buffer

                
                name = in.nextLine()
                
                age = in.nextInt()  

                in.nextLine() // for cleaning up

                schoolname = in.nextLine() 
        2.
            - Use nextLine() for all your input and do the approprate conversion
                Integer.parseInt()
                Double.parseDouble()

        

        
        




        

```java

Scanner in = new Scanner(System.in);    
PrintStream out = System.out;

// Test
out.print("Enter name : ");
String name = in.nextLine();

out.print("\nEnter Age: ");
int age = in.nextInt();


String mySelf = String.format("Welcome %s. You are %d years old", name, age);
out.println(mySelf);

in.close();
    

```

## Arrays

    Note:
        - Are reference types

```java

PrintStream printer = System.out;

int[] myArr = {3, 6, 0, 1, -2};
Arrays.sort(myArr, 1, 4); // Sort the array from index 1 to index 4 (not inclusive)

printer.println(Arrays.toString(myArr)); // [3, 0, 1, 6, -2]   //  0, 1, 6  is sorted
     



PrintStream printer = System.out;

int[] myArr = {3, 6, 0, 1, -2};
Arrays.sort(myArr);
// search for -2
// we use binarySearch => the arr must be sorted first
    // the binarySearch returns the index of the found element
    // you can also use, start index and stop index for the binary search
int theFoundIndex = Arrays.binarySearch(myArr, -2);
printer.println(Arrays.toString(myArr)); 
printer.println("Found at index : " + theFoundIndex );

// if the element is not found, it will give a nagative output




// filling the array
Arrays.fill(myArr, 0);  // [0, 0, 0, 0, 0]

Arrays.fill(myArr, 1, 4, 0);  // excluding index 4 // [3, 0, 0, 0, 1, 99, 8]



// making copies of an array
    // take note arrays are reference type
    // int numbers[] = {1}; and int[] theCopy = numbers;    -> this will copy the reference -> any changes to numbers[] will affect theCopy[] 

    // do this instead
int[] numbers = {1, 4, 5};
int[] theCopy = Arrays.copyOf(numbers, numbers.length); // [1, 4, 5]
// default values for integers in 0, -> if the new array was larger, the rest will be filled with 0 -> the default value



int[] numbers = {1, 4, 5, 7, 1};

// using starting and stopping index
int[] anotherCopy = Arrays.copyOfRange(numbers, 0, 3); // [1, 4, 5]

```

---

## ArrayList

    - are dynamic -> can add and remove
    - can store anything

```java

ArrayList<Integer> myArr = new ArrayList<>();


myArr.add(3);
myArr.add(4);
myArr.add(19);

myArr.stream()
        .map(element -> element + 2)
        .forEach(element -> System.out.println(element));
        

/* output
    * 5
    * 6 
    * 21
    */




PrintStream printer = System.out;

ArrayList<Integer> myArr = new ArrayList<>();


myArr.add(3);
myArr.add(4);
myArr.add(19);

printer.println(myArr.toString()); // [3, 4, 19]

int myIndex = 0;
printer.println(myArr.get(myIndex)); // 3


myArr.remove(0);  // supply the index

// what if you want to supply the number to remove - say we want to remove the 19
myArr.remove(Integer.valueOf(19));


// make the array list empty
myArr.clear();
printer.println(myArr.toString());


// update an array list
myArr.set(1, Integer.valueOf(99)); // [3, 99, 19]



// 

PrintStream printer = System.out;

ArrayList<Integer> myArr = new ArrayList<>();  

myArr.add(89);
myArr.add(3);
myArr.add(4);
myArr.add(19);
myArr.add(0);
myArr.add(-1);

System.out.println(myArr.toString()); 

// Sort the arraylist
    // in their natural order
myArr.sort(null);  // null means the natural order should be used  // [-1, 0, 3, 4, 19, 89]
// or
myArr.sort(Comparator.naturalOrder()); // [-1, 0, 3, 4, 19, 89]
myArr.sort(Comparator.reverseOrder()); // [89, 19, 4, 3, 0, -1]

System.out.println(myArr.toString());  



System.out.println(myArr.size()); // 6
System.out.println(myArr.contains(Integer.valueOf(9))); // false
myArr.clear();
System.out.println(myArr.isEmpty()); // true


// printing the elements of the array
myArr.forEach(System.out::println);

```

## HashMap

    - key value pair

```java

PrintStream printer = System.out;

HashMap<String, Integer> myHashMap = new HashMap<>();

myHashMap.put("Spencer", 10);
myHashMap.put("SAmos", 7);
myHashMap.put("Lewisky", 0);
myHashMap.put("Henry", 12);

myHashMap.putIfAbsent("Spencer", 22);

myHashMap.replace("Lewisky", 20);

myHashMap.forEach((key, value) -> System.out.println(key + " : " + value) );

System.out.println(myHashMap.getOrDefault("kennedy", -1));  // -1 because there is no Kennedy

System.out.println(myHashMap.toString()); // prints it out  // {SAmos=7, Lewisky=20, Spencer=10, Henry=12}

// clear the hashmap
myHashMap.clear();
System.out.println(myHashMap.toString());  // {}


// size
System.out.println(myHashMap.size()); // 4

// remove
Object value = myHashMap.remove("SAmos"); // return null if key is not in the HashMap

System.out.println(value); // null



```