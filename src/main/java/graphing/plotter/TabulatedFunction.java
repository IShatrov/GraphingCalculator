package graphing.plotter;

import graphing.expression.ExpressionTree;
import java.util.ArrayList;

public class TabulatedFunction {
    private static final int MAX_POINTS = 10_000;

    private final ArrayList<Double> xValues, yValues;
    private final double xMin, xMax, yMin, yMax;

    public TabulatedFunction(ExpressionTree function, double xMin, double xMax, double yMin, double yMax)
            throws ArithmeticException {
        if (xMin >= xMax) {
            throw new ArithmeticException("xMin larger than xMax");
        }

        if (yMin >= yMax) {
            throw new ArithmeticException("yMin larger than yMax");
        }

        this.xMin = xMin;
        this.xMax = xMax;
        this.yMin = yMin;
        this.yMax = yMax;

        xValues = new ArrayList<>();
        yValues = new ArrayList<>();

        double delta = (xMax - xMin) / MAX_POINTS;

        for (double x = xMin; x <= xMax; x += delta) {
            double y = function.calculate(x);

            if (Double.isFinite(y)) {
                xValues.add(x);
                yValues.add(y);
            }
        }
    }
}
