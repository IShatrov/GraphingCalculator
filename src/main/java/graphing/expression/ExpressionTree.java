package graphing.expression;

import java.io.FileWriter;
import java.io.IOException;

/**
 * An abstract syntax tree for math expressions.
 */
public class ExpressionTree {
    private final ExpressionNode root;

    /**
     * Constructs ExpressionTree with given root.
     * @param root node to set as root
     */
    public ExpressionTree(ExpressionNode root) {
        this.root = root;
    }

    /**
     * Calculates function at given point.
     * @param x point to calculate at
     * @return
     */
    public double calculate(double x) {
        return root.calculate(x);
    }

    /**
     * Generates graphviz log of the tree.
     * @param filename name of file
     * @throws IOException when writing fails
     */
    public void graphvizLog(String filename) throws IOException {
        FileWriter writer = new FileWriter(filename);

        writer.write("digraph dump\n{\n\t" +
                        "node[shape = \"record\", style = \"rounded\"];\n\n"
        );

        root.graphvizWriteChildren(writer);

        writer.write("}");

        writer.close();
    }
}
