package uvg.edu.gt;

public class MyPFCalc implements POSFIXCalc{
    public int evaluate(String expression) {
        MyStack<Integer> stack = new MyStack<>();

        String[] elements = expression.split(" ");

        for (String element : elements) {
            if (isOperand(element)) {
                stack.push(Integer.parseInt(element));
            } else if (isOperator(element)) {
                try {
                    int operandB = stack.pop();
                    int operandA = stack.pop();
                    int result = applyOperation(operandA, operandB, element);
                    stack.push(result);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        try {
            return stack.pop();
        } catch (Exception e) {
            e.printStackTrace();
            return 0; // Manejar el caso en que la pila está vacía al finalizar la evaluación
        }
    }

    public boolean isOperand(String element) {
        return element.matches("\\d+");
    }

    public boolean isOperator(String element) {
        return element.matches("[+\\-*/]");
    }

    public int applyOperation(int operandA, int operandB, String operator) {
        switch (operator) {
            case "+":
                return operandA + operandB;
            case "-":
                return operandA - operandB;
            case "*":
                return operandA * operandB;
            case "/":
                return operandA / operandB;
            default:
                throw new IllegalArgumentException("Unrecognized operator: " + operator);
        }
    }
}
