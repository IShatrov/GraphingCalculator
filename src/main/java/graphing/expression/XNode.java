package graphing.expression;

import java.io.FileWriter;
import java.io.IOException;

class XNode extends ExpressionNode {
    double calculate(double x) {
        return x;
    }

    void graphvizLog(FileWriter writer) throws IOException {
        writer.write(getGraphvizLabel("x"));
    }
}
