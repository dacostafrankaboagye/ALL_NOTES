
Jetpack Compose is a modern toolkit for building Android UIs.
defining a set of functions, called composable functions, that take in data and describe UI elements.

The Composable function is annotated with the @Composable annotation. All composable functions must have this annotation.
 informs the Compose compiler that this function is intended to convert data into UI. 
```kt
@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}
```
