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