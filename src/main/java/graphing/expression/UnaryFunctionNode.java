package graphing.expression;

import java.io.FileWriter;
import java.io.IOException;

class UnaryFunctionNode extends ExpressionNode {
    private final UnaryFunction func;

    UnaryFunctionNode(UnaryFunction func) {
        this.func = func;
    }

    double calculate(double x) {
        return func.calculation.applyAsDouble(left.calculate(x));
    }

    void graphvizLog(FileWriter writer) throws IOException {
        writer.write(getGraphvizLabel("func: " + func.stringRepresentation));
    }
}
