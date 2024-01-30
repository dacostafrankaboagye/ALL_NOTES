
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
