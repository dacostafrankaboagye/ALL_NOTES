
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
---

- The three basic, standard layout elements in Compose are
   - Column
   - Row
   - Box composables
 - these composables can act as parent UI elements.
 - take composable content as arguments
```kt

// each child element inside a Row composable is placed horizontally next to each other in a row
Row {
    Text("First Column")
    Text("Second Column")
}
```
- When you pass a function as that parameter, you can use trailing lambda syntax.

```kt

Row(
    content = {
        Text("Some text")
        Text("Some more text")
        Text("Last text")
    }
)


Row {
    Text("Some text")
    Text("Some more text")
    Text("Last text")
}
```

---

- It is a good practice to pass the modifier attribute(s) along with the modifier from the parent composable.

```kt

package com.example.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
                    GreetingText(message = "Happy New Year", from = "From:  Frank")
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
fun GreetingText(modifier: Modifier = Modifier, message: String, from: String) {
    Column(modifier = modifier, verticalArrangement = Arrangement.Center) {
        Text(text = message, fontSize = 100.sp, lineHeight = 116.sp, textAlign = TextAlign.Center)
        Text(text = from, fontSize = 36.sp, modifier=Modifier.padding(16.dp).align(alignment = Alignment.End))
    }

}

@Preview(
    showBackground = true,
    name = "myApp",
    showSystemUi = false
)
@Composable
fun GreetingPreview() {
    HappyBirthdayTheme {
        GreetingText(message = "Happy New Year", from = "From:  Frank")

    }
}


```










