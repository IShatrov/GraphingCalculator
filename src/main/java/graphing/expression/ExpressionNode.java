package graphing.expression;

import java.io.FileWriter;
import java.io.IOException;

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

    void graphvizWriteChildren(FileWriter writer) throws IOException {
        if (left != null) {
            writer.write("\t\"" + this.toString() + "\"->\"" + left.toString() + "\";\n");
            left.graphvizWriteChildren(writer);
        }

        if (right != null) {
            writer.write("\t\"" + this.toString() + "\"->\"" + right.toString() + "\";\n");
            right.graphvizWriteChildren(writer);
        }

        this.graphvizLog(writer);
    }

    String getGraphvizLabel(String label) {
        return "\t\"" + this.toString() + "\"[label = \"{" + this.toString() + " |" + label + "}\"];\n\n";
    }

    abstract void graphvizLog(FileWriter writer) throws IOException;
}
