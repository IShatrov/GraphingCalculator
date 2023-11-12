import graphing.expression.ExpressionTree;
import graphing.expression.RecursiveParser;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculationTest {
    private static final double EPSILON = 1e-6;

    @Test
    public void constantTest() throws Exception {
        ExpressionTree constant = RecursiveParser.parse("2");
        assertEquals(2, constant.calculate(0), EPSILON);
        assertEquals(2, constant.calculate(3), EPSILON);
    }

    @Test
    public void polinomialTest() throws Exception {
        ExpressionTree polinomial = RecursiveParser.parse("x^2 + 3*x + 4");
        assertEquals(4, polinomial.calculate(0), EPSILON);
        assertEquals(8, polinomial.calculate(1), EPSILON);
        assertEquals(22, polinomial.calculate(3), EPSILON);
    }

    @Test
    public void trigonometryTest() throws Exception {
        ExpressionTree trigonometry = RecursiveParser.parse("sin(2*x + 1)^2 - 3*x*cos(2) + tan(x)");
        assertEquals(0.708073418, trigonometry.calculate(0), EPSILON);
        assertEquals(2.825763090, trigonometry.calculate(1), EPSILON);
    }

    @Test
    public void exponentialTest() throws Exception {
        ExpressionTree exponential = RecursiveParser.parse("2^x");
        assertEquals(1, exponential.calculate(0), EPSILON);
        assertEquals(2, exponential.calculate(1), EPSILON);
        assertEquals(0.5, exponential.calculate(-1), EPSILON);
        assertEquals(8, exponential.calculate(3), EPSILON);
        assertEquals(5.6568542495, exponential.calculate(2.5), EPSILON);
    }
}
