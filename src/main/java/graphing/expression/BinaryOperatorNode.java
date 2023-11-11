package graphing.expression;

import java.io.FileWriter;
import java.io.IOException;

class BinaryOperatorNode extends ExpressionNode {
    private final BinaryOperator op;

    BinaryOperatorNode(BinaryOperator op) {
        this.op = op;
    }

    double calculate(double x) {
        return op.calculation.applyAsDouble(left.calculate(x), right.calculate(x));
    }

    void graphvizLog(FileWriter writer) throws IOException {
        writer.write("\t\"" + this.toString() + "\"[label = \"{" + this.toString() + " |op: " + op.stringRepresentation + "|}\"];\n\n");
    }
}
