## Worked Example - 1

    how many days have elapsed since the day you were born

```java

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

class Day {
    private LocalDate date;

    public Day(int year, int month, int day) {
        this.date = LocalDate.of(year, month, day);
    }

    public long daySinceBirth() {
        LocalDate currentDate = LocalDate.now();
        return ChronoUnit.DAYS.between(date, currentDate);
    }
}

class TryOut {

    public static void main(String[] args) {
        int bYear = 2000;
        int bMonth = 6;
        int bDay = 20;

        Day BirthDay = new Day(bYear, bMonth, bDay);
        System.out.println("Day Since Borth = " + BirthDay.daySinceBirth());
        System.out.println("Number of Years = " + BirthDay.daySinceBirth() /365);

    }
}

```

--- 

## Worked Example - 2

    Understanding Object Reference


```java


import java.awt.Rectangle;

class TryOut {

    public static void main(String[] args) {

        Rectangle BoxOne = new Rectangle(5, 10, 15, 20);
        Rectangle BoxTwo = BoxOne;

        BoxTwo.translate(10, 10);

        System.out.println(BoxOne.getX() + " " + BoxOne.getY());

    }
}


class TryOut {

    public static void main(String[] args) {

        String greeting = "Hello";

        String greeting2 = greeting;
        greeting2 = greeting2.toUpperCase();

        System.out.println(greeting); // Output: Hello
        System.out.println(greeting2); // Output: HELLO

    }
}

```


--- 

## Worked Example - 3

    Capitalizing first letter of every word in  a sentence

```java

public class Main{

    public static String capitalizeFirstLetter(String sentence){

        String[] words = sentence.split("\\s");

        StringBuilder result = new StringBuilder();

        for(String word : words){
            if(!word.isEmpty()){
                result.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1))
                        .append(" ");
            }
        }
        return result.toString().trim();

    }

    public static void main(String[] args) {

        PrintStream printer = System.out;

        String mySentence = "i am going home, very soon !";

        String myResult = Main.capitalizeFirstLetter(mySentence);

        printer.println(myResult);


    }
}


```

--- 

## Worked Example - 4


    Simple JFrame

```java

import javax.swing.JFrame;

public class Main{

    public static void main(String[] args) {

        JFrame frame = new JFrame();

        frame.setSize(300, 400);
        frame.setTitle("Simple Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);


    }
}


```


--- 

## Worked Example - 5

    Add a component to a JFrame

```java

import javax.swing.*;
import java.awt.*;

class RectangleComponent extends JComponent{
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;

        // construct rectangle
        Rectangle box = new Rectangle(5, 10, 20, 30);
        g2.draw(box);

        // 15 unit - right : 25 units - down
        box.translate(15, 25);

        // draw
        g2.draw(box);
    }
}


class RectangleViewer{

    public static void viewRectangle(){
        JFrame frame =  new JFrame();

        frame.setSize(300, 400);
        frame.setTitle("Showing Rectangles");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // add the component to the frame
        RectangleComponent component = new RectangleComponent();
        frame.add(component);

        frame.setVisible(true);
    }
}


```
--- 

## Worked Example - 6

    Rectangles

```java

        Ellipse2D.Double ellipse = new Ellipse2D.Double(10, 15, 20, 30);
        // for circle - use ellipse - width and height  - should be the same values


```


--- 

## Worked Example - 7

    lines

```java

        // construct line - method1
        Line2D.Double segment = new Line2D.Double(20, 20, 20, -20);

        // construct line - method2 - more object oriented
        Point2D.Double from  = new Point2D.Double(90, 90);
        Point2D.Double to = new Point2D.Double(90, -90);

        Line2D.Double segment2 =  new Line2D.Double(from, to);

```
--- 

## Worked Example - 8

    text

```java

   g2.drawString("Frank Aboagye", 50, 100);


```


--- 

## Worked Example - 9

    Color and Fill

```java

        Ellipse2D.Double ellipse_circle = new Ellipse2D.Double(50, 50, 100, 100);

        g2.setColor(Color.BLUE);
        g2.draw(ellipse_circle);
        g2.setColor(Color.RED);
        g2.fill(ellipse_circle);


```
--- 

## Worked Example - 10

    Construct an Alien Face

```java

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

class FaceComponent extends JComponent{

    public void paintComponent(Graphics g){

        // use the 2D
        Graphics2D g2 = (Graphics2D) g;

        // head
        Ellipse2D.Double head = new Ellipse2D.Double(5, 10, 100, 150);
        g2.draw(head);

        // eyes
        g2.setColor(Color.GREEN);
        Rectangle eye = new Rectangle(25, 70, 15, 15);
        g2.fill(eye);
        eye.translate(50, 0);
        g2.fill(eye);

        // mouth
        Line2D.Double mouth = new Line2D.Double(30, 110, 80, 110);
        g2.setColor(Color.RED);
        g2.draw(mouth);

        // greeting
        g2.setColor(Color.BLUE);
        g2.drawString("Alien Image", 5, 175);


    }
}

class FaceView{
    public static void viewFace(){
        JFrame frame  = new JFrame();
        frame.setSize(150, 250);
        frame.setTitle("An Alien Face");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        FaceComponent component = new FaceComponent();
        frame.add(component);

        frame.setVisible(true);

    }
}

public class Main{

    public static void main(String[] args) {

        FaceView.viewFace();

    }
}

```


--- 

## Worked Example - 11

```java

```
--- 

## Worked Example - 12

```java

```


--- 

## Worked Example - 13

```java

```
--- 

## Worked Example - 14

```java

```


--- 

## Worked Example - 15

```java

```
--- 

## Worked Example - 16

```java

```


--- 

## Worked Example - 17

```java

```
--- 

## Worked Example - 18

```java

```


--- 

## Worked Example - 19

```java

```
--- 

## Worked Example - 20

```java

```


--- 

## Worked Example - 2

```java

```
--- 

## Worked Example - 2

```java

```


--- 

## Worked Example - 2

```java

```
--- 

## Worked Example - 2

```java

```


--- 

## Worked Example - 2

```java

```
--- 

## Worked Example - 2

```java

```


--- 

## Worked Example - 2

```java

```
--- 

## Worked Example - 2

```java

```


--- 

## Worked Example - 2

```java

```
--- 

## Worked Example - 2

```java

```


--- 

## Worked Example - 2

```java

```
--- 

## Worked Example - 2

```java

```


--- 

## Worked Example - 2

```java

```
--- 

## Worked Example - 2

```java

```


--- 

## Worked Example - 2

```java

```
--- 

## Worked Example - 2

```java

```


--- 

## Worked Example - 2

```java

```
--- 

## Worked Example - 2

```java

```


--- 

## Worked Example - 2

```java

```
--- 

## Worked Example - 2

```java

```


--- 

## Worked Example - 2

```java

```
--- 

## Worked Example - 2

```java

```


--- 

## Worked Example - 2

```java

```
--- 

## Worked Example - 2

```java

```


--- 

## Worked Example - 2

```java

```
--- 

## Worked Example - 2

```java

```


--- 

## Worked Example - 2

```java

```
--- 

## Worked Example - 2

```java

```


--- 

## Worked Example - 2

```java

```
--- 

## Worked Example - 2

```java

```


--- 

## Worked Example - 2

```java

```
--- 

## Worked Example - 2

```java

```


--- 

## Worked Example - 2

```java

```
--- 

## Worked Example - 2

```java

```


--- 

## Worked Example - 2

```java

```
--- 

## Worked Example - 2

```java

```


--- 

## Worked Example - 2

```java

```
--- 

## Worked Example - 2

```java

```


--- 

## Worked Example - 2

```java

```
--- 

## Worked Example - 2

```java

```


--- 

## Worked Example - 2

```java

```
--- 

## Worked Example - 2

```java

```


--- 

## Worked Example - 2

```java

```
--- 

## Worked Example - 2

```java

```


--- 

## Worked Example - 2

```java

```
--- 

## Worked Example - 2

```java

```


--- 

## Worked Example - 2

```java

```
--- 

## Worked Example - 2

```java

```


--- 

## Worked Example - 2

```java

```
--- 

## Worked Example - 2

```java

```


--- 

## Worked Example - 2

```java

```
--- 

## Worked Example - 2

```java

```


--- 

## Worked Example - 2

```java

```
--- 

## Worked Example - 2

```java

```


--- 

## Worked Example - 2

```java

```
--- 

## Worked Example - 2

```java

```


--- 

## Worked Example - 2

```java

```
--- 

## Worked Example - 2

```java

```


--- 

## Worked Example - 2

```java

```
--- 

## Worked Example - 2

```java

```


--- 

## Worked Example - 2

```java

```
--- 

## Worked Example - 2

```java

```


--- 

## Worked Example - 2

```java

```
--- 

## Worked Example - 2

```java

```


--- 

## Worked Example - 2

```java

```
--- 

## Worked Example - 2

```java

```


--- 

## Worked Example - 2

```java

```
--- 

## Worked Example - 2

```java

```


--- 

## Worked Example - 2

```java

```
--- 

## Worked Example - 2

```java

```


--- 

## Worked Example - 2

```java

```
--- 

## Worked Example - 2

```java

```


--- 

## Worked Example - 2

```java

```
--- 

## Worked Example - 2

```java

```


--- 

## Worked Example - 2

```java

```
--- 

## Worked Example - 2

```java

```


--- 

## Worked Example - 2

```java

```
--- 

## Worked Example - 2

```java

```


--- 

## Worked Example - 2

```java

```
--- 

## Worked Example - 2

```java

```


--- 

## Worked Example - 2

```java

```
--- 

## Worked Example - 2

```java

```


--- 

## Worked Example - 2

```java

```
--- 

## Worked Example - 2

```java

```


--- 

## Worked Example - 2

```java

```
--- 

## Worked Example - 2

```java

```


--- 

## Worked Example - 2

```java

```
--- 

## Worked Example - 2

```java

```


--- 

## Worked Example - 2

```java

```
--- 

## Worked Example - 2

```java

```


--- 

## Worked Example - 2

```java

```
--- 

## Worked Example - 2

```java

```


--- 

## Worked Example - 2

```java

```
--- 

## Worked Example - 2

```java

```


--- 

## Worked Example - 2

```java

```
--- 

## Worked Example - 2

```java

```


--- 

## Worked Example - 2

```java

```
--- 

## Worked Example - 2

```java

```


--- 

## Worked Example - 2

```java

```
--- 

## Worked Example - 2

```java

```


--- 

## Worked Example - 2

```java

```
--- 

## Worked Example - 2

```java

```


--- 

## Worked Example - 2

```java

```
--- 

## Worked Example - 2

```java

```


--- 

## Worked Example - 2

```java

```
--- 

## Worked Example - 2

```java

```


--- 

## Worked Example - 2

```java

```
--- 

## Worked Example - 2

```java

```


--- 

## Worked Example - 2

```java

```
--- 

## Worked Example - 2

```java

```


--- 

## Worked Example - 2

```java

```
--- 

## Worked Example - 2

```java

```


--- 

## Worked Example - 2

```java

```
--- 

## Worked Example - 2

```java

```


--- 

## Worked Example - 2

```java

```
--- 

## Worked Example - 2

```java

```


--- 

## Worked Example - 2

```java

```
--- 

## Worked Example - 2

```java

```


--- 

## Worked Example - 2

```java

```
--- 

## Worked Example - 2

```java

```


--- 

## Worked Example - 2

```java

```
--- 

## Worked Example - 2

```java

```


--- 

## Worked Example - 2

```java

```
--- 

## Worked Example - 2

```java

```


--- 

## Worked Example - 2

```java

```
--- 

## Worked Example - 2

```java

```


--- 

## Worked Example - 2

```java

```
--- 

## Worked Example - 2

```java

```


--- 

## Worked Example - 2

```java

```
--- 

## Worked Example - 2

```java

```


--- 

## Worked Example - 2

```java

```

