package graphing.expression;

class ImmedNode extends ExpressionNode {
    private final double val;

    ImmedNode(double val) {
        this.val = val;
    }

    double calculate(double x) {
        return val;
    }
}
