## Getting Started

    compare the two

```java

        final List<BigDecimal> prices = Arrays.asList(
                new BigDecimal("10"), new BigDecimal("30"), new BigDecimal("17"),
                new BigDecimal("20"), new BigDecimal("15"), new BigDecimal("18"),
                new BigDecimal("45"), new BigDecimal("12")
        );

         // total the prices greater than $20, discounted by 10%.

        //// 1.
                BigDecimal totalDiscount = BigDecimal.ZERO;
                for(BigDecimal price : prices){
                    if(price.compareTo(BigDecimal.valueOf(20)) > 0){
                        totalDiscount = totalDiscount.add(price.multiply(BigDecimal.valueOf(0.9)));
                    }

                }

        //// 2.
                final BigDecimal totalDiscount =
                    prices.stream()
                        .filter(price ->price.compareTo(BigDecimal.valueOf(20)) > 0)
                        .map(price -> price.multiply(BigDecimal.valueOf(0.9)))
                        .reduce(BigDecimal.ZERO, BigDecimal::add);

        System.out.println("Total of dicounted prince: " + totalDiscount);


```

## Look at this

```java

List<Integer> myList = Arrays.asList(2, 4, 6, 7);


List<Integer> result = myList.stream().map(element -> element*2).collect(Collectors.toList());


// System.out.println("Total of dicounted prince: " + totalDiscount);

result.forEach(i->System.out.println(i));

```

## Note

    Two different approaches

```java

// immutable collection of list of names
final List<String> friends = Arrays.asList("Spencer", "James", "Lindsay", "Lesly");

for(int i=0; i<friends.size(); i++){
    System.err.println(friends.get(i));
}

// under the hood -> uses: Iterator interface -> calls into hasNext() and next()
for(String name : friends){
    System.out.println(name);
}


```

    Note:
        - The for loops are inherently sequential and are quite difficult to parallelize

        - Such loops are non-polymorphic; we get exactly what we ask for. We
            passed the collection to for instead of invoking a method (a polymorphic
            operation) on the collection to perform the task.

        -  At the design level, the code fails the "Tell, don’t ask” principle.
        We ask for a specific iteration to be performed instead of leaving the details of the iteration to underlying libraries.

    Note

    The Iterable interface has been enhanced in JDK 8 with a
    special method named forEach(), which accepts a parameter of type Consumer.
    As the name indicates, an instance of Consumer will consume, through its accept() method, what’s given

```java

final List<String> friends = Arrays.asList("Spencer", "James", "Lindsay", "Lesly");


//  we traded in the old for loop for the new internal iterator forEach().

friends.forEach(new Consumer<String>() {
    public void accept(final String name) {
        System.out.println(name);
    }
});


/*
We invoked the forEach() on the friends collection and passed an anonymous
instance of Consumer to it. The forEach() method will invoke the accept() method
of the given Consumer for each element in the collection and let it do whatever
it wants with it. In this example we merely print the given value, which is the
name.
*/

```

    looks a lot more verbose
    we can fix that -> replacing the anonymous inner class with a lambda expression

```java

friends.forEach((final String name) -> System.out.println(name));

/*

we’re able to focus our attention on what we want to achieve
for each element rather than how to sequence through the iteration—it’s
declarative

*/
```

    The standard syntax for lambda expressions expects the parameters to be
    enclosed in parentheses, with the type information provided and comma
    separated. The Java compiler also offers some lenience and can infer the
    types. Leaving out the type is convenient, requires less effort, and is less
    noisy

```java

final List<String> friends = Arrays.asList("Spencer", "James", "Lindsay", "Lesly");

friends.forEach((name)->System.out.println(name));

```

    The Java compiler treats single-parameter lambda expressions as special: we
    can leave off the parentheses around the parameter if the parameter’s type
    is inferred

```java
final List<String> friends = Arrays.asList("Spencer", "James", "Lindsay", "Lesly");

friends.forEach(name->System.out.println(name));

```

     inferred parameters are non-final

```java

// another step
final List<String> friends = Arrays.asList("Spencer", "James", "Lindsay", "Lesly");

friends.forEach(System.out::println);

```


## Task - Suppose we’re asked to convert a list of names to all capital letters.

```java

// immutable collection of list of names
final List<String> friends = Arrays.asList("Spencer", "James", "Lindsay", "Lesly");

final List<String> upperCaseNames = new ArrayList<>();

// imperatiive approach 
for(String name : friends){
    upperCaseNames.add(name.toUpperCase());
}

```

```java
        // first step to move towards functional style
        friends.forEach(name -> upperCaseNames.add(name.toUpperCase()));
```

    using lambda expressions

    Map
    - The Stream’s map() method can map or transform a
     sequence of input to a sequence of output

    - applies the given lambda expression or block of code, within the parenthesis,
     on each element in the Stream

    - the map() method collects the result of running the lambda expression
     and returns the result collection

```java
// next 
final List<String> friends = Arrays.asList("Spencer", "James", "Lindsay", "Lesly");

friends.stream()
        .map(name -> name.toUpperCase())
        .forEach(name -> System.out.println(name + " "));

System.out.println();

```

## element input and output types
    one of the advantages - element types in the input don’t have to match the element types in the output collection.

```java
final List<String> friends = Arrays.asList("Spencer", "James", "Lindsay", "Lesly");

// print the number of characters in the friends

friends.stream()
        .map(name -> name.length())
        .forEach(count -> System.out.print(count + " "));
```

# method reference

    The Java compiler will take either a lambda expression or 
    a reference to a method where an implementation of a functional interface is
    expected.

```java

final List<String> friends = Arrays.asList("Spencer", "James", "Lindsay", "Lesly");

//to upperCase

friends.stream()
        .map(String::toUpperCase)
        .forEach(element -> System.out.println(element));


// we are replacing the lambda expression
.map(element -> element.toUpperCase())  
//with
.map(String::toUpperCase)

```

    Method references can also refer to static methods and methods that take
    parameters

## From a list of names, let’s pick the ones that start with the letter N

### Filter

    The filter() method expects a lambda expression that returns a boolean result
    If the lambda expression returns a true, the element in context while executing
    that lambda expression is added to a result collection; it’s skipped otherwise

    The filter() method returns an iterator just like the map() method does, but the
    similarity ends there. Whereas the map() method returns a collection of the
    same size as the input collection, the filter() method may not (zero to the 
    maximumnumber of elements in the input collection)

```java

final List<String> friends = Arrays.asList("Spencer", "James", "Lindsay", "Lesly", "Nancy");


final List<String> startsWthN = new ArrayList<>();
for(String name : friends){
    if(name.startsWith("N")){
        startsWthN.add(name);
    }
}


final List<String> friends = Arrays.asList("Spencer", "James", "Lindsay", "Lesly", "Nancy");

// see this
final List<String> startsWthN = friends.stream()
                                        .filter(name -> name.startsWith("N"))
                                        .collect(Collectors.toList());


```

## Reusing Lambda Expressions

    Now let’s see how easy it is to fall into the duplication trap when using
    lambda expressions, and consider ways to avoid it

The filter() method
    - takes a reference to a java.util.function.Predicate functional interface
    - the Java compiler works to synthesize an implementation of the Predicate’s test() method from the given lambda expression.

    what does this mean?
    - Rather than asking Java to synthesize the method at the argument-definition location, we can be more explicit

    - store the lambda function in an explicit reference of type Predicate
    - then pass the function to it

```java

final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
final List<String> editors = Arrays.asList("Brian", "Jackie", "John", "Mike");
final List<String> comrades = Arrays.asList("Kate", "Ken", "Nick", "Paula", "Zach");

// 1. 



final long countFriendsStartN = friends.stream().filter(name -> name.startsWith("N")).count();
final long countEditorsStartN = editors.stream().filter(name -> name.startsWith("N")).count();
final long countComradesStartN = comrades.stream().filter(name -> name.startsWith("N")).count();

// 2.

import java.util.function.Predicate;



// Fortunately, we can assign lambda expressions to variables and reuse them,
// just like with objects
final Predicate<String> startsWithN = name -> name.startsWith("N");

final long countFriendsStartN = friends.stream().filter(startsWithN).count();
final long countEditorsStartN = editors.stream().filter(startsWithN).count();
final long countComradesStartN = comrades.stream().filter(startsWithN).count();

System.out.println(countComradesStartN + " " + countEditorsStartN + " " + countFriendsStartN); // 1 0 2


/*
Rather than duplicate the lambda expression several times, we created it once
and stored it in a reference named startsWithN of type Predicate
*/

```

## Using Lexical Scoping and Closures

    We managed to reuse the lambda expression in the previous example; however,
    duplication will sneak in quickly when we bring in another letter to match

    Let’s pick the names that start with N or B from the friends collection of names
```java

        final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");


        // Fortunately, we can assign lambda expressions to variables and reuse them,
        // just like with objects
        final Predicate<String> startsWithN = name -> name.startsWith("N");
        final Predicate<String> startsWithB = name -> name.startsWith("B");

        final long countFriendsStartN = friends.stream().filter(startsWithN).count();
        final long countFriendsStartB = friends.stream().filter(startsWithB).count();

        System.out.println(countFriendsStartB + " " + countFriendsStartN); // 1 2

        //  >>  the two predicates are mere duplicates
```

## Removing Duplication with Lexical Scoping

    Lexical scoping is a powerful technique that lets us cache values
    provided in one context for use later in another contex

```java

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Test {

    public static Predicate<String> checkIfStartWith(final String letter){
        return name -> name.startsWith(letter);
    }

    public static void main(String[] args) {

        final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
        final List<String> editors = Arrays.asList("Brian", "Jackie", "John", "Mike");
        final List<String> comrades = Arrays.asList("Kate", "Ken", "Nick", "Paula", "Zach");



        final long countFriendsStartN = friends.stream().filter(checkIfStartWith("N")).count();
        final long countFriendsStartB = friends.stream().filter(checkIfStartWith("B")).count();

        System.out.println(countFriendsStartB + " " + countFriendsStartN); // 1 2

    }

}

/*

checkIfstartWith

This call immediately returns a lambda expression
that is then passed on to the filter() method

*/

```

## Refactoring to Narrow the Scope

    we don’t want to pollute the class with static methods to cache each variable in the future.
    It would be nice to narrow the function’s scope to where it’s needed. We can
    do that using a Function interface

```java

final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");

final Function<String, Predicate<String>> startsWithLetter = (String letter) -> {
    Predicate<String> checkStarts = (String name) -> name.startsWith(letter);
    return checkStarts;
} ;

final long countFriendsStartN = friends.stream().filter(startsWithLetter.apply("N")).count();
final long countFriendsStartB = friends.stream().filter(startsWithLetter.apply("B")).count();

System.out.println(countFriendsStartB + " " + countFriendsStartN); // 1 2

```
    This lambda expression replaces the static method checkIfStartsWith() and can
    appear within a function, just before it’s needed. The startsWithLetter variable
    refers to a Function that takes in a String and returns a Predicate.

NOW

    Instead
    of explicitly creating the instance of the Predicate and returning it, we can
    replace it with a lambda expression

```java

final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");


final Function<String, Predicate<String>> startsWithLetter = (String letter) -> (String name) -> name.startsWith(letter);


final long countFriendsStartN = friends.stream().filter(startsWithLetter.apply("N")).count();
final long countFriendsStartB = friends.stream().filter(startsWithLetter.apply("B")).count();

```

    letting the Java compiler infer the types based on the
    context.

```java

final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");

final Function<String, Predicate<String>> startsWithLetter = (letter) -> (name) -> name.startsWith(letter);


final long countFriendsStartN = friends.stream().filter(startsWithLetter.apply("N")).count();
final long countFriendsStartB = friends.stream().filter(startsWithLetter.apply("B")).count();

System.out.println(countFriendsStartB + " " + countFriendsStartN); // 1 2

```

## Note

    A Predicate<T> takes in one parameter of type T and
    returns a boolean result to indicate a decision for whatever check it represent

    A Function<T, R> represents a function that takes a parameter of type T and returns a result of
    type R

    Methods like filter() that evaluate candidate elements take in a Predicate as their parameters

    map() method uses Function as its parameter

---

## Picking an Element

    habitual approach

