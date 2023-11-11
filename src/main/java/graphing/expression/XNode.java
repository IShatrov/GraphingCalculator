package graphing.expression;

import java.io.FileWriter;
import java.io.IOException;

class XNode extends ExpressionNode {
    double calculate(double x) {
        return x;
    }

    void graphvizLog(FileWriter writer) throws IOException {
        writer.write("\t\"" + this.toString() + "\"[label = \"{" + this.toString() + " |x|}\"];\n\n");
    }
}
