package graphing.runner;

import graphing.expression.ExpressionTree;

public class Runner {
    public static void main(String[] args) throws java.io.IOException {
        ExpressionTree tree = new ExpressionTree();

        tree.graphvizLog("test.txt");
    }
}
