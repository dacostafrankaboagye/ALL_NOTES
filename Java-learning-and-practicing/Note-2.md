
## Data types and their sizes

    byte: size 8 bits (1 byte), ranging from − 128 to 127 ; 
    short: size 16 bits (2 bytes), ranging from − 32768 to 32767 ; 
    int: size 32 bits (4 bytes), ranging from − ( 2^31 ) to ( 2^31 ) − 1 ; 
    long: size 64 bits (8 bytes), ranging from − ( 2^63 ) to ( 2^63 ) − 1;


## Method overloading
```java

public static int abs(int a) { return (a < 0) ? -a : a; }

public static float abs(float a) { return (a <= 0.0F) ? 0.0F - a : a; }
  
```

        Two methods can have the same name, the same return type but different type of arguments.


Note
```java

public static String toString(long num) {
    return // some string
}
    
public static String toString(int num) {
    return // some string
}


float val = 2F; toString(val);	-> none of the methods above
long val = 2L; toString(val);	-> long will be called
int val = 2; toString(val);	    -> int will be called
byte val = 2; toString(val);	-> int will be called
char val = 2; toString(val);	-> int will be called
double val = 2; toString(val);	-> none of the methods will ne called


```

---

## Note this

    Dont' chnage the contents of parameter Variables

```java

public void deposit(double amount){
    // Using the parameter variable to hold an intermediate value
    amount = balance + amount; // Poor style
    . . . 
}


// Don’t assign new values to them. Instead, introduce a new local variable.

public void deposit(double amount){
    double newBalance = balance + amount;
    . . . 
}

```


