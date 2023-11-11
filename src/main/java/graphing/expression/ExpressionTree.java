package graphing.expression;

public class ExpressionTree {
    private final ExpressionNode root;

    public ExpressionTree(ExpressionNode root) {
        this.root = root;
    }

    public double calculate(double x) {
        return root.calculate(x);
    }
}
