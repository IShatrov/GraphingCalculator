package graphing.plotter;

import graphing.expression.ExpressionTree;
import java.util.ArrayList;

/**
 * Tabulates function from xMin to xMax.
 */
public class TabulatedFunction {
    private static final int MAX_POINTS = 10_000;

    private final ArrayList<Double> xValues, yValues;
    private final double xMin, xMax, yMin, yMax;

    /**
     * Constructs TabulatedFunction with specified parameters.
     * @param function function to tabulate
     * @param xMin x to start tabulation from
     * @param xMax x to finish tabulation at
     * @param yMin min y for plot
     * @param yMax max y for plot
     * @throws ArithmeticException when xMin >= xMax or yMin >= yMax
     */
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

    public double getxMin() {
        return xMin;
    }

    public double getxMax() {
        return xMax;
    }

    public double getyMin() {
        return yMin;
    }

    public double getyMax() {
        return yMax;
    }

    /**
     * Writes x values
     * @param sep separator
     */
    public String xString(String sep) {
        return makeSeparatedString(xValues, sep);
    }

    /**
     * Writes y values
     * @param sep separator
     */
    public String yString(String sep) {
        return makeSeparatedString(yValues, sep);
    }

    /**
     * Creates a string from ArrayList members using separator.
     * @param lst ArrayList to generate string from
     * @param sep separator
     * @return separated string
     * @param <T> types of elements if lst
     */
    private static <T> String makeSeparatedString(ArrayList<T> lst, String sep) {
        StringBuilder ans = new StringBuilder();

        for (T i : lst) {
            ans.append(i);
            ans.append(sep);
        }

        return new String(ans);
    }
}
