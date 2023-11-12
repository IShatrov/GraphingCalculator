package graphing.expression;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Node that contains x - function argument.
 */
class XNode extends ExpressionNode {

    /**
     * Returns x.
     * @param x input
     * @return x
     */
    double calculate(double x) {
        return x;
    }

    void graphvizLog(FileWriter writer) throws IOException {
        writer.write(getGraphvizLabel("X"));
    }
}
