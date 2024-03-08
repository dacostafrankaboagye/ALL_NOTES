
import org.junit.*;

public class CalculatorTest {
    @Test
    public void addTwoPositiveIntegers() {
        Calculator calculator = new Calculator();
        int calculatorResult = calculator.add(12, 10);
        int actualResult = 22;
        Assert.assertEquals(actualResult, calculatorResult);
    }

}