package node;

public class BinaryOperatorNode extends ExpressionNode {
    BinaryOperator op;

    double calculate(double x) {
        return op.calculation.applyAsDouble(left.calculate(x), right.calculate(x));
    }

    public String toString() {
        return op.stringRepresentation;
    }
}
