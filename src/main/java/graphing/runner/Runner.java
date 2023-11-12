package graphing.runner;

import graphing.expression.ExpressionTree;
import graphing.expression.RecursiveParser;

public class Runner {
    public static void main(String[] args) throws Exception {
        ExpressionTree tree = RecursiveParser.parse("sin(2*x + 1) * 2 + ln(x)^3");

      //  tree.graphvizLog("test.txt");
        System.out.println(tree.calculate(1));
    }
}
