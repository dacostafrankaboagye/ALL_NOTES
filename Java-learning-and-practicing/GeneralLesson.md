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