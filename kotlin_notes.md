



# Kotlin 

- released in 2016 by JetBrains
- In 2016, the first official stable version was released (Kotlin v1.0)
- Being a general-purpose programming language
-  a statically typed language for the JVM, Android and the browser.
- offers developers the ability to extend the functionality of classes without having to use inheritance.
- Kotlin offers type inference
- used for:
    - Android development
    - web development
    - data science, and more. 
- In 2019, Google announced Kotlin as their preferred language for Android development.

The following applications use Kotlin in their tech stack:
- Netflix
- Duolingo
- Pinterest
- The .kt extension signifies that the file contains Kotlin code.


    Chet Haase, the chief advocate for Android, said: "We understand that not 
    everybody is on Kotlin right now, but we believe that you should get there".

- Application platforms for Kotlin: JVM, Android, JS, Native
- developers can use Kotlin as the only language for their projects without Java at all.
- create mobile applications for Android, server-side development,
   develop client-side web applications( run them in a browser)
- Kotlin is designed as a pragmatic language, which means that its main purpose is
   solving real-world problems rather than completing research purposes

-  supports multiple programming paradigms, such as imperative programming,
  object-oriented programming, generic programming, functional programming, and more
- offers tools like anonymous functions and higher-order functions,
  which allow developers to easily create abstractions over existing code
- all popular types of development tools, such as IntelliJ IDEA, Eclipse,
  and Android Studio, are compatible with it
- kt will aloow you to
    - Write server-side and desktop applications
    - Develop frameworks and libraries
    - Write mobile applications


  
---


# Types

    Int
    String
    Double

    2.toDouble()
    Math.sqrt(Math.pow(oppositeValue,2.toDouble()))





# println, print
```kt 

fun main(){
    println()  # creates a new line after outputing a value
    print()

}

```

---

A compiler translates our Kotlin code -> something that can be read by the Java Virtual Machine (JVM). 
The JVM is responsible for executing code as instructions.

---

# comment 

    //  single line comment

    /*

    block comment
    
    */

--- 

# variables 

    read-only variables with val >> recommended == value

    mutable variables with var >> meaning it can be reassigned >> decalre as var only when necessary == varaible

    top level variables - Variables can be declared outside the main() 
    function at the beginning of your program

    val x = 12  // read only - type is inferred
    val y:Int = 23  // read only
    var c:Int
    var d:Int = 0 // can be reassigned
    d = 90 
    c = 89
    
    print(x+y+d+c )

    // top level
    var PI = 20 
    val c=  9

    fun main() {
        val theRadius = 2
        val theArea = 2*PI*theRadius
        print(theArea)
    }


---

# Basics

```kt

fun main(){
    val greetings: String = "Hello, " 
    val name: String = "Frank"
    var result: String = greetings.plus(name)
    println(result)
}

```

-  basic literals in Kotlin: integer numbers, characters, and strings.
-  Kotlin has many other literals too


## Intgers
    0, 1, 2, 1_000_000, 1__000_000, 1_2_3
```kt
val monthlySalary: Int = 10_000_000 
print(monthlySalary)
```
## Characters
    wrap a symbol in single quotes
    A', 'z', '0', '1',' ','$'
    A character cannot include two or 
    more digits or letters because it represents a single symbol.

## Strings
     wrap characters in double quotes

---


# Function

```kt

    fun main(args:Array<String>){
        print(args.contentToString())
        
    }

    fun sum(a:Int, b:Int):Int{
        return a+b
    }

    fun multiply(a:Int, b:Int) = a* b  // return type is inferred


    // the function returns no value 

    fun justNormal(firstName:String, lastName:String, age:Int):Unit{
        
        println("My name is $firstName $lastName.Ten years from now I will be ${age+110}")
        
    }

    ->> the Unit can be omitted


```

--- 

# classes 

    Properties of a class can be listed in its declaration or body.
    The default constructor with parameters listed in the class declaration is available automatically

```kt
    class Pythagoras(var oppositeValue:Double, var adjascentValue:Double){
        var hypothenus = Math.sqrt(Math.pow(oppositeValue,2.toDouble())+ Math.pow(adjascentValue,2.toDouble()))
    }

    fun main(){
        val theP = Pythagoras(2.0,4.0)
        println("${theP.hypothenus}")
    }
```

    Inheritance between classes is declared by a colon (:). Classes are final by default; to make a class inheritable, mark it as open.


```kt
    open class Shape

    class Rectangle(var height: Double, var length: Double): Shape() {
        var perimeter = (height + length) * 2
    }

```

# String Templates
    - val customers = 10
    - println("There are $customers customers")

	
	
	
	+=, -=, *=, /=, and %= are augmented assignment operators
	
	
	Integers  = Byte, Short, Int, Long
	Unsigned integers = UByte, UShort, UInt, ULong
	Floating-point numbers = Float, Double
	Booleans = Boolean
	Characters =  Char
	Strings =  String
	
	    val a:Int = 1000
	    val b:String = "log message"
	    val c:Double = 3.14
	    val d:Long = 100_000_000_000_000
	    val e:Boolean = false
	    val f:Char = '\n'

---

# Collections  
	(each collection can be mutable or read only)
	Lists  = Ordered collections of items
	Sets  = Unique unordered collections of items
	Maps  = Sets of key-value pairs where keys are unique and map to only one value

---

# List
	read only list = use  listOf 
	mutableList = use  mutableListOf
	Kotlin can infer the type of items stored. add the type within angled brackets <>
```kt
    //read only list
    val myCourses:List<String> = listOf("E-math", "English")
    
    //mutable
    val theAges:MutableList<Int> = mutableListOf(2, 55)

    // from mutable to read only === assign the mutable to a list(declare a new one)  === in a way == you are doing casting 

    val myCourses:List<String> = listOf("E-math", "English")
    
    print(myCourses[0])


    # Extension Function

    val myCourses:List<String> = listOf("E-math", "English")
    
    print(myCourses.first())
    print(myCourses.last())


    count
    print(myCourses.count())  


    # check 
    print("E-math" in myCourses)   // false


    # add or remove fromr - note:: mutable list

    // mutable list 
    val firstNames: MutableList<String> = mutableListOf()
    
    // add 
    firstNames.add("Frank")
    firstNames.add("Ben")
    firstNames.add("Prince")
    
    println(firstNames.count())  // 3
    println(firstNames) // [Frank, Ben, Prince]
    
    // remove 
    firstNames.remove("Ben")  // [Frank, Prince]
    println("Ben" in firstNames)  // false

```

---

# Set

	sets are unordered, you can't access an item at a particular index

```kt
    // read only Set 
    val mySetOfNumbers: Set<Int> = setOf(1,4,6,7)
    
    // mutable 
    val mySetOfFruits: MutableSet<String> = mutableSetOf("Banana", "Guava", "orange")
    
    
    println(mySetOfNumbers.count())
    println(mySetOfNumbers.first())
    println(mySetOfNumbers.last())
    println(mySetOfNumbers)
    println("===")
    println(mySetOfFruits)
    println("Guava" in mySetOfFruits)
    mySetOfFruits.add("Pineapple")
    mySetOfFruits.remove("Guava")
    println(mySetOfFruits)

    // read only Set 
        val mySetOfNumbers: Set<Int> = setOf(1,4,6,7,4)
    
    println(mySetOfNumbers)  // [1,2,6,7]  the other 4 was dropped

        type casting

    val fruit: MutableSet<String> = mutableSetOf("apple", "banana", "cherry", "cherry")
	val fruitLocked: Set<String> = fruit 
    
    fruit.add("Guava")
    println("fruits  = $fruit")  // [apple, banana, cherry, Guava]
    println("fruits locked = $fruitLocked") // [apple, banana, cherry, Guava]

```

---


# Map

```kt
    // read only 
    val nameToGpa: Map<String, Double> = mapOf("Frank" to 3.5, 
                                               "Ben" to 4.0, 
                                               "King" to 3.7
                                              )
    
    println(nameToGpa)
    
    // mutable 
    val gradeToDescription: MutableMap<Char, String> = mutableMapOf('A' to "Excellent",
                                                                   'B' to "Very Good",
                                                                   'C' to "Good")
    
    print(gradeToDescription)


    // type casting 
    val accountBalances: MutableMap<Int, Int> = mutableMapOf(1 to 100, 2 to 100, 3 to 100)
    val accountBalancesLocked: Map<Int, Int> = accountBalances

	
	//sampleStart
	    val readOnlyAccountBalances = mapOf(1 to "A", 2 to "B", 3 to "C")
	    println("${readOnlyAccountBalances[2]}")


     # put and remove
    val accountBalances: MutableMap<Int, String> = mutableMapOf(1 to "A", 2 to "B", 3 to "C")
    
    accountBalances.put(5,"E")
    accountBalances.put(25,"p")
    accountBalances.put(90,"V")
    
    println(accountBalances)  // {1=A, 2=B, 3=C, 5=E, 25=p, 90=V}
    
    accountBalances.remove(3)  // you remove the key
    
    println(accountBalances)  // {1=A, 2=B, 5=E, 25=p, 90=V}



    check 
    println(accountBalances.containsKey(90))  // true  

    val readOnlyAccountBalances = mapOf(1 to 100, 2 to 100, 3 to 100)
	println(2 in readOnlyAccountBalances.keys)




    // obtain key , value 
	   println(accountBalances.keys) // [1, 2, 5, 25, 90]
	     println(accountBalances.values)  // [A, B, E, p, V]

```

# uppercase
	val sentence = "I am going to school"
    println(sentence.uppercase()) //I AM GOING TO SCHOOL


# Control flow










