package gaphing.expression;

public class UnaryFunctionNode extends ExpressionNode {
    private final UnaryFunction func;

    UnaryFunctionNode(UnaryFunction func) {
        this.func = func;
    }

    double calculate(double x) {
        return func.calculation.applyAsDouble(left.calculate(x));
    }

    public String toString() {
        return func.stringRepresentation;
    }
}
