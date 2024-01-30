package uvg.edu.gt;

import org.junit.Test;
import static org.junit.Assert.*;

public class MyPFCalcTest {

    @Test
    public void testEvaluate() {
        MyPFCalc calculator = new MyPFCalc();
        assertEquals(15, calculator.evaluate("1 2 + 4 * 3 +"));
        
    }

    @Test
    public void testIsOperand() {
        MyPFCalc calculator = new MyPFCalc();
        assertTrue(calculator.isOperand("123"));
        assertFalse(calculator.isOperand("+"));
    }

    @Test
    public void testIsOperator() {
        MyPFCalc calculator = new MyPFCalc();
        assertTrue(calculator.isOperator("+"));
        assertFalse(calculator.isOperator("123"));
    }

    @Test
    public void testApplyOperation() {
        MyPFCalc calculator = new MyPFCalc();
        assertEquals(5, calculator.applyOperation(2, 3, "+"));
        assertEquals(6, calculator.applyOperation(2, 3, "*"));
      
    }
}
