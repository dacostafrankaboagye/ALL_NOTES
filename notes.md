



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


    class Pythagoras(var oppositeValue:Double, var adjascentValue:Double){
        var hypothenus = Math.sqrt(Math.pow(oppositeValue,2.toDouble())+ Math.pow(adjascentValue,2.toDouble()))
    }

    fun main(){
        val theP = Pythagoras(2.0,4.0)
        println("${theP.hypothenus}")
    }


    Inheritance between classes is declared by a colon (:). Classes are final by default; to make a class inheritable, mark it as open.



    open class Shape

    class Rectangle(var height: Double, var length: Double): Shape() {
        var perimeter = (height + length) * 2
    }



# String Templates
























































