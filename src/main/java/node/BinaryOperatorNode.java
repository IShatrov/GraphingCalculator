package node;

public class BinaryOperatorNode extends ExpressionNode {
    private final BinaryOperator op;

    BinaryOperatorNode(BinaryOperator op) {
        this.op = op;
    }

    double calculate(double x) {
        return op.calculation.applyAsDouble(left.calculate(x), right.calculate(x));
    }

    public String toString() {
        return op.stringRepresentation;
    }
}
