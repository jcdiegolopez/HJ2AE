package uvg.edu.gt;

public interface POSFIXCalc {
    
    int evaluate(String expression);
    boolean isOperand(String element);
    boolean isOperator(String element);
    int applyOperation(int operandA, int operandB, String operator);
}
