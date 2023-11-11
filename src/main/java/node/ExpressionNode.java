package node;

abstract class ExpressionNode {
    ExpressionNode left, right;

    ExpressionNode getLeft() {
        return left;
    }

    ExpressionNode getRight() {
        return right;
    }

    void setLeft(ExpressionNode target) {
        left = target;
    }

    void setRight(ExpressionNode target) {
        right = target;
    }

    abstract double calculate(double x);

    public abstract String toString();
}
