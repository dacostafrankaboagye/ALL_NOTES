
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
---

 Understand this:
 Jetpack Compose is a modern toolkit for building Android UI. Jetpack Compose simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs.
 
 The user interface (UI) of an app is what you see on the screen: text, images, buttons, and many other types of elements.
 
 Composable functions are the basic building block of Compose. A composable function is a function that describes some part of your UI.
 
 The Composable function is annotated with the @Composable annotation; this annotation informs the Compose compiler that this function is intended to convert data into UI.
 
 The three basic standard layout elements in Compose are Column, Row, and Box. They are Composable functions that take Composable content, so you can place items inside. 
 
 For example, each child within a Row will be placed horizontally next to each other.

---

# Note
 Modifiers tell a UI element how to lay out, display, or behave within its parent layout

## Adding Images

 - Resource Manager is a tool window that lets you import, create, manage, and use resources in your app.
 - For photographs and background images you should place them in the drawable-nodpi folder, which stops the resizing behavior.
 - you can use an Image composable to display an image.

   Note
   -  Select Density from the QUALIFIER TYPE drop-down list
   -  Select No Density from the VALUE list.


## Grouping Resources

- An example
```kt

MyProject/
    src/
        MyActivity.kt
    res/
        drawable/
            graphic.png
        mipmap/
            icon.png
        values/
            strings.xml

```

Note
```
 drawable/ directory for an image resource
 mipmap/ directory for launcher icons
 values/ directory for string resources.
 
 Resources can be accessed with resource IDs that are generated in your project's R class.
 
 An R class is an automatically generated class by Android that contains the IDs of all resources in the project

 In most cases, the resource ID is the same as the filename

 e.g Access the graphic.png
   
   R.drawable.graphic

Note:
R = auto generated
drawable = sub dir in the res folder
graphic = resource ID = same as file name
```

### Box
-  Use Box layout to stack elements on top of one another.
-  Box lets you configure the specific alignment of the elements that it contains.


```kt

package com.example.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.res.painterResource
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
                    GreetingImage(message = "Happy New Year", from = "From:  Frank")
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
        Text(text = from, fontSize = 36.sp, modifier= Modifier
            .padding(16.dp)
            .align(alignment = Alignment.End))
    }

}

@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier) {

    val image = painterResource(id = R.drawable.androidparty)
    Box {
        Image(
            painter = image,
            contentDescription = null
        )
        GreetingText(
            message = message,
            from = from,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        )
    }
}

// set the image's contentDescription argument to null so that TalkBack skips the Image composable.


@Preview(
    showBackground = true,
    name = "myApp",
    showSystemUi = false
)
@Composable
fun GreetingPreview() {
    HappyBirthdayTheme {
        GreetingImage(message = "Happy New Year", from = "From:  Frank")

    }
}



```
---

## Change opacity and scale the image

-  use the ContentScale parameters.
  
-   You use the ContentScale.Crop parameter scaling, which scales the image uniformly to
  maintain the aspect ratio so that the width and height of the image are equal to, or larger than, the corresponding dimension of the screen.

```kt

import androidx.compose.ui.layout.ContentScale

Image(
    painter = image,
    contentDescription = null,
    contentScale = ContentScale.Crop
)
```

### Change opacity

```kt

Image(
   painter = image,
   contentDescription = null,
   contentScale = ContentScale.Crop,
   alpha = 0.5F
)


```

### Layout Modifiers
- Modifiers are used to decorate or add behavior to Jetpack Compose UI elements.
- To set them, a composable or a layout needs to accept a modifier as a parameter
```kt
//Example
Text(
    text = "Hello, World!",
    // Solid element background color
    modifier = Modifier.background(color = Color.Green) 
)
```
- To set children's position within a Row
    - set the horizontalArrangement and verticalAlignment arguments.
 - For a Column
    - set the verticalArrangement and horizontalAlignment arguments.

- different vertical arrangements:equal weight, space between, space around, space evenly, top, center and bottom
- different horizontal arrangements: equal weight, space between, space around, space evenly, end, center and start

### Padding
```kt

// This is an example. 
Modifier.padding(
    start = 16.dp,
    top = 16.dp,
    end = 16.dp,
    bottom = 16.dp
)

```
- The strings.xml file has a list of strings that the user sees in your app.
- Example
```xml
<resources>
    <string name="app_name">Happy Birthday</string>
    <string name="happy_new_year_text">Happy New Year</string>
    <string name="signature_text">From:  Frank</string>
</resources>
```

```kt
@Preview(showBackground = false)
@Composable
private fun BirthdayCardPreview() {
   HappyBirthdayTheme {
       GreetingImage( stringResource(R.string.happy_birthday_text),
           stringResource(R.string.signature_text))
   }
}
```

```kt
@Composable
fun GreetingText(message: String, from: String, modifier: Modifier = Modifier) {
   // Create a column so that texts don't overlap
   Column(
       verticalArrangement = Arrangement.Center,
       modifier = modifier
   ) {
       Text(
           text = message,
           fontSize = 100.sp,
           lineHeight = 116.sp,
           textAlign = TextAlign.Center
       )
       Text(
           text = from,
           fontSize = 36.sp,
           modifier = Modifier
               .padding(16.dp)
               .align(alignment = Alignment.CenterHorizontally)
       )
   }
}

```

## Example

```kt

package com.example.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
                    GreetingImage(
                        message = stringResource(R.string.happy_new_year_text),
                        from = stringResource(R.string.signature_text)
                    )
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
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = message,
            fontSize = 100.sp,
            lineHeight = 116.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(8.dp)
        )
        Text(
            text = from,
            fontSize = 36.sp,
            modifier= Modifier
                .padding(16.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
    }

}

@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier) {

    val image = painterResource(id = R.drawable.androidparty)
    Box {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.5F
        )
        GreetingText(
            message = message,
            from = from,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        )
    }
}

// set the image's contentDescription argument to null so that TalkBack skips the Image composable.


@Preview(
    showBackground = true,
    name = "myApp",
    showSystemUi = false
)
@Composable
fun GreetingPreview() {
    HappyBirthdayTheme {
        GreetingImage(
            message = stringResource(id = R.string.happy_new_year_text),
            from = stringResource(id = R.string.signature_text)
        )

    }
}


```




