package graphing.expression;

import java.io.FileWriter;
import java.io.IOException;

class ImmedNode extends ExpressionNode {
    private final double val;

    ImmedNode(double val) {
        this.val = val;
    }

    double calculate(double x) {
        return val;
    }

    void graphvizLog(FileWriter writer) throws IOException {
        writer.write("\t\"" + this.toString() + "\"[label = \"{" + this.toString() + " |val: " + val + "|}\"];\n\n");
    }
}
