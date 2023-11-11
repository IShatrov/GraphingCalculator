package graphing.expression;

import java.io.FileWriter;
import java.io.IOException;

public class ExpressionTree {
    private final ExpressionNode root;

    public ExpressionTree(ExpressionNode root) {
        this.root = root;
    }

    public double calculate(double x) {
        return root.calculate(x);
    }

    public void graphvizLog(String filename) throws IOException {
        FileWriter writer = new FileWriter(filename);

        writer.write("digraph dump\n{\n\t" +
                        "node[shape = \"record\", style = \"rounded\"];\n\n"
        );

        root.graphvizWriteChildren(writer);

        writer.write("}");

        writer.close();
    }

    public ExpressionTree() {
        root = new BinaryOperatorNode(BinaryOperator.SUM);

        root.setLeft(new ImmedNode(5));
        root.setRight(new XNode());
    }
}
