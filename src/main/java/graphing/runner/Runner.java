package graphing.runner;

import graphing.expression.ExpressionTree;
import graphing.expression.RecursiveParser;
import graphing.plotter.PlotBuilder;
import graphing.plotter.TabulatedFunction;

import java.io.FileWriter;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        System.out.println("Please write function to plot:");
        String str = scn.nextLine();

        System.out.println("Please enter xMin and xMax:");
        double xMin = scn.nextDouble(), xMax = scn.nextDouble();

        System.out.println("Please enter yMin and yMax:");
        double yMin = scn.nextDouble(), yMax = scn.nextDouble();

        ExpressionTree func = RecursiveParser.parse(str);

        TabulatedFunction table = new TabulatedFunction(func, xMin, xMax, yMin, yMax);

        table.writeX(new FileWriter("rr.txt"), " ");

        FileWriter writer = new FileWriter("test.py");

        PlotBuilder.plot(writer, table);

        writer.close();
    }
}
