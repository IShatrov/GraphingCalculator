package node;

public class UnaryFunctionNode extends ExpressionNode {
    UnaryFunction func;

    double calculate(double x) {
        return func.calculation.applyAsDouble(left.calculate(x));
    }

    public String toString() {
        return func.stringRepresentation;
    }
}
