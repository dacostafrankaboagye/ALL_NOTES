
## object class

calling / printing the object = it calls the toString class
you see by default objectName@someHash / someadress


ANOTHER APPROACH IS THERE - BUT FOR UNDERSTANDING SAKE

    by dfault the class extends the object class - even if you do not explicitly define it

```java
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




```



## use generate Hashcode and equals - > with what you want to compare

```java
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

```

``` java

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


```


## abstract class vs concrete class (normal class without abstract keyword)

    abstract key word
        you cannot create object of an abstract class
        but you can create a reference of it
        any method that has abstract -> the class should also be abstract
        abstratct methods are the be implemented - its just a way of telling that - i am giving an 
        abstract idea, you should be the one to implement it. and you have to implement it

```java
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

```
 
## inner class

```java

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



```


## anonymous inner class

    anonymous inner class
    we override theName method
    we know will will do it once 

```java
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


```

## abstract and anonymous inner class

    if you want to implement the interface or abstract class only once
    use the abstract and anonymous inner class

```java

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

```

## the need for interface

```java
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


```

## replace with interface

```java
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


```

### interface
    if you end up implementing only abstract method in your abstract class: use interface
    by default -  every method in the interface is: "public abstract"

```java
interface Computer{
    public abstract void code();
    public abstract void configure();
}

// same as 

interface Computer{
    void code();
    void configure();
}


```


## cannot instantiate interface

    what is the solution?
        we create interface so that we can design something
        for interface
        they tell you what methods you need,
        but you have to implement theminterface will show you the design - implement them (how? create a class which implements the interface))
        implement all the methods in the interface else - make your class abstractany variable in the interface is - final and static
        so you have to initialise the variable
```java
interface Computer{
    void code();
    void configure();
}

```

## a class can implement multiple interfaces

```java
// this works

interface A{
    void theName();
}

interface B extends A{
    void theAge();
}


```

Note

    when you implent - interface B - in a class, you should define all the methods in both interfaces


## enums  - enumeration - named constant
```java

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


```

```java

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


```

## more on enums

    by default - enums extends an enum class - use - getClass() getSuperClass()

```java
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


}

public class TryOut{

    public static void main(String[] args) {

        Laptop myLaptop = Laptop.MacBook;
        
        System.out.println(myLaptop + " : " + myLaptop.getPrice());

    }
}


*/

```

### Note

    you can create a default constructor
        so that even if you do not specify the price -> you can just use it
        
    if you have say, 4 objects in the eums -> 
        it will call the constructor - 4 times - according to the number that have the constructor - being it default
            try it with this
            MacBook(50_000), MacBookPro(45_000), Vostro, ThinkPad(10_000);
            with a default constructor - only one call
            with a priced constructor - 3 calls



## Annotation

    meta data
    
    we want to supply some data to the complier 

```java
class A{

    public void giveOut(){
        System.out.println("For A");
    }

}


class B extends A{

    @Override
    public void giveOut(){
        System.out.println("This is B");
    }
}

class TryOut{

    public static void main(String[] args) {

        B myB = new B();
        myB.giveOut();
        
    }
}


```

## Functional Interface
    interface with only one method
    SAM Interface = single abstract method interface
    or the functional interface 
```java
interface A{

    void show();
}

```    

Note

    by adding the @FuctionalInterface, we make sure that it is a SAM interface

    we can use anonymous inner class 
    instead of creating new class and implementing it like this

```java
@FunctionalInterface
interface A{

    void show();
}

class TryOut{

    public static void main(String[] args) {

        A myA = new A() {
            public void show(){
                System.out.println("demo");
            }
        };

        myA.show();
        
    }
}

```


### Note
    
    we can use lamda expressions only with functional  interface 


## lambda
```java

@FunctionalInterface
interface A{
    void show();
}

@FunctionalInterface
interface B{
    void printOut(int i);
}

class TryOut{

    public static void main(String[] args) {

        A myA = () ->{
            System.out.println("demo");
        };
        myA.show();

        // even better - when you have one statement
        A myOtherA = () -> System.out.println("demo2");
        myOtherA.show();

        // what of a parameter
        B myB = (int i) -> System.out.println("the var is " + i); 
        myB.printOut(4);

        // even better, you do not have to mention the type -> its already in the SAM
        B myOtherB = (i) -> System.out.println("this is it: "+i);
        myOtherB.printOut(348);

        // even better -> no brackets
        B myOtherB2 = i -> System.out.println(" this is " + i);
        myOtherB2.printOut(43);

  
        
    }
}

```

### Note

    lamda with a return value
    lambda expersions only works with functional Interface

```java

@FunctionalInterface
interface MathTool{
    int multiplyThem(int a, int b);
}

class TryOut{
    public static void main(String[] args) {

        MathTool myMath = (a, b) ->{
            return a * b;
        };

        int result = myMath.multiplyThem(23, 2);

        System.out.println(result);

        // even better - removing the return key word
        MathTool myOtherMathTool = (a, b) -> a * b;
        System.out.println(myOtherMathTool.multiplyThem(23, 11));
        

    }
}


```

## Types of interfaces

- Normal Interface
    - has more methods

- Functional Interface / SAM
    - SAM
        - has only one method

- Marker Interface
    - no methods - blank
    - use case: maybe you want to update something to the complier
        - serialisation : loading data to memory - take an object and store that data on the harddrive
        - deserialsation: retreiving values 
        - by default evey object is not allowed to do that 
            - you have the give the permissions 
                - create a class and give the permissons via marker interface



## error

    compile time error 
    run time error = exceptions = handle them
    logical error

    java throws exceptions as object
    catch them as objects
    
    make sure the parent exception is at the buttom


    hierarchy


                                    object
                                        |
                                    Throwable
                                    /       \
                                    /         \     
        (you cannot handle)    Error          Exception - you can handle
                                /                \
        IO Error, Virtual Machine Error,
        OutOfMemory


```java

import java.util.stream.Stream;

public class TryOut {

    public static void main(String[] args) {

        Stream<String> myFruit = Stream.of("apple", "banana", "pear", "kiwi", "orange");


        try {
            myFruit.forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("failed");
        }

        int i = 2, j = 1;
        int[] a = {2,4, 9};
        int[] b = {7,0, 9};
         
    

        try {
            int result = a[i]/ b[j];
        } catch (ArithmeticException e) {
            System.out.println("cannot divide by 0");
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("cannot access element");
        } catch (Exception e) {
            System.out.println("an error occured");
        }
        
  

    }
}



```

## throw -> exception
```java

import java.util.stream.Stream;

public class TryOut {

    public static void main(String[] args) {

        Stream<String> myFruit = Stream.of("apple", "banana", "pear", "kiwi", "orange");

        // infinite stream of random numbers

        Stream<Double> infiniteRandomNumbers = Stream.generate(Math::random);

        infiniteRandomNumbers.limit(10).forEach(System.out::println);

        int i = 0, j = 30;
     

        try {
            j = 18 / i;
            if(j == 0) {
                throw new ArithmeticException("this is a new error");
            }
        } catch (ArithmeticException e) {
            System.out.println("error :"  + e);
            
        }


  
         
  

    }
}


```





