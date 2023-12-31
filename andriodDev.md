
- Jetpack Compose is a modern toolkit for building Android UIs.
- defining a set of functions, called composable functions, that take in data and describe UI elements.

- The Composable function is annotated with the @Composable annotation. All composable functions must have this annotation.
- informs the Compose compiler that this function is intended to convert data into UI.
- must be a noun - best practice
 
```kt

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview() {
   HappyBirthdayTheme {
       Greeting("Android")
   }
}

```

- The compose function that returns nothing and bears the @Composable annotation MUST be named using pascal case
- It's a best practice to have your Composable accept a Modifier parameter, and pass that modifier to its first child.
- The scalable pixels (SP) is a unit of measure for the font size

---

- UI elements in Android apps use two different units of measurement:
   -  density-independent pixels (DP)
   -  scalable pixels (SP).
- By default, the SP unit is the same size as the DP unit, but SP resizes based on the user's preferred text size under phone setting


```kt
package com.example.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.happybirthday.ui.theme.HappyBirthdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBirthdayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}

//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}

@Composable
fun GreetingText(modifier: Modifier = Modifier, message: String) {
    Text(text = message, fontSize = 100.sp, lineHeight = 100.sp)

}

@Preview(
    showBackground = true,
    name = "myApp",
    showSystemUi = false
)
@Composable
fun GreetingPreview() {
    HappyBirthdayTheme {
        GreetingText(message = "Happy New Year")

    }
}
```















