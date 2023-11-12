package graphing.runner;

import graphing.expression.RecursiveParser;

public class Runner {
    public static void main(String[] args) throws Exception {
        RecursiveParser.parse("2^x");
    }
}
